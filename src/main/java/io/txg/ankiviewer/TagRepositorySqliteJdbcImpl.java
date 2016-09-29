package io.txg.ankiviewer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TagRepositorySqliteJdbcImpl implements TagRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private JsonParser jsonParser = JsonParserFactory.getJsonParser();

	@Override
	public List<Tag> findAll() {
		return jdbcTemplate
				.queryForObject("SELECT tags FROM col WHERE id = 1",
						(rs, rowNum) -> jsonParser.parseMap(rs.getString("tags")).keySet())
				.stream().map((nomeTag) -> new Tag(nomeTag)).collect(Collectors.toList());
	}

}
