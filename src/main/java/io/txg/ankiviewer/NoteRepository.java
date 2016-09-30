package io.txg.ankiviewer;

public interface NoteRepository {

	Note findByOrderAdded(int order);
	
}
