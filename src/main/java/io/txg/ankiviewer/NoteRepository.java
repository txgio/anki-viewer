package io.txg.ankiviewer;

import java.util.List;

public interface NoteRepository {

	Note findByOrderAdded(int order);

	List<Note> findByText(String text, int page);

	List<Note> findByPage(int page);
	
}
