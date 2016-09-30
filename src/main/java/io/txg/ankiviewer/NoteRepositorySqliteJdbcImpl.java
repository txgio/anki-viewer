package io.txg.ankiviewer;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NoteRepositorySqliteJdbcImpl implements NoteRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Note findByOrderAdded(int order) {
		Note note = jdbcTemplate.queryForObject("SELECT id, flds FROM notes LIMIT 1 OFFSET ?", new Object[] { order - 1 },
				(rs, rowNum) -> new Note(rs.getString("id"), Arrays.stream(rs.getString("flds").split("\u001F"))
						.map((valor) -> new Field(valor)).collect(Collectors.toList())));
		return note;
	}

}
