package io.txg.ankiviewer;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class TagRepositorySqliteJdbcImpl implements TagRepository {

	@Override
	public List<Tag> findAll() {
		return null;
	}

}
