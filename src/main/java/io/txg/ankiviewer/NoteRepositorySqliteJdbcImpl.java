package io.txg.ankiviewer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class NoteRepositorySqliteJdbcImpl implements NoteRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private JsonParser jsonParser = JsonParserFactory.getJsonParser();

	@Override
	public Note findByOrderAdded(int order) {
		Note note = jdbcTemplate.queryForObject("SELECT id, mid, flds FROM notes LIMIT 1 OFFSET ?",
				new Object[] { order - 1 }, new RowMapper<Note>() {

					@Override
					public Note mapRow(ResultSet rs1, int rowNum1) throws SQLException {
						String id = rs1.getString("id");
						String mid = rs1.getString("mid");
						String flds = rs1.getString("flds");

						List<Field> fldsList = preencherCampos(mid, flds);
						
						return new Note(id, fldsList);
					}

				});
		return note;
	}

	@Override
	public List<Note> findByText(String text, int page) {
		List<Note> notes = jdbcTemplate.query("SELECT id, mid, flds FROM notes WHERE flds like ? LIMIT 10 OFFSET ?",
				new Object[] { "%" + text + "%",  (page - 1) * 10}, new RowMapper<Note>() {

					@Override
					public Note mapRow(ResultSet rs1, int rowNum1) throws SQLException {
						String id = rs1.getString("id");
						String mid = rs1.getString("mid");
						String flds = rs1.getString("flds");

						List<Field> fldsList = preencherCampos(mid, flds);
						
						return new Note(id, fldsList);
					}

				});
		return notes;
	}

	private List<Field> preencherCampos(String mid, String flds) {
		Map<String, Object> modelsMap = jdbcTemplate.queryForObject(
				"SELECT models FROM col WHERE id = 1",
				(rs2, rowNum2) -> jsonParser.parseMap(rs2.getString("models")));

		List<Map<String, Object>> obj = (List<Map<String, Object>>)((Map<String, Object>)modelsMap.get(mid)).get("flds");
		
		String[] fldsValues = flds.split("\u001F");
		
		List<Field> fldsList = new ArrayList<>();
		
		for (int i = 0; i < fldsValues.length; i++) {
			Field fieldObj = new Field((String)obj.get(i).get("name"), fldsValues[i]);
			fldsList.add(fieldObj);
		}
		return fldsList;
	}

	@Override
	public List<Note> findByPage(int page) {
		List<Note> notes = jdbcTemplate.query("SELECT id, mid, flds FROM notes LIMIT 10 OFFSET ?",
				new Object[] {(page - 1) * 10}, new RowMapper<Note>() {

					@Override
					public Note mapRow(ResultSet rs1, int rowNum1) throws SQLException {
						String id = rs1.getString("id");
						String mid = rs1.getString("mid");
						String flds = rs1.getString("flds");

						List<Field> fldsList = preencherCampos(mid, flds);
						
						return new Note(id, fldsList);
					}

				});
		return notes;
	}
	
}
