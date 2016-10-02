package io.txg.ankiviewer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AnkiViewer.class)
public class NoteRepositoryTest {

	@Autowired
	private NoteRepository noteRepository;
	
	@Test
	public void testFindByOrderAdded() {
		Note note = noteRepository.findByOrderAdded(1);
		
		Assert.assertEquals("Front", note.getCampo(1).getNome());
		Assert.assertEquals("Front01", note.getCampo(1).getValor());
	}
	
}
