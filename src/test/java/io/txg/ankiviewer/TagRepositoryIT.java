package io.txg.ankiviewer;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AnkiViewer.class)
public class TagRepositoryIT {

	@Autowired
	private TagRepository tagRepository;

	@Test
	public void testFindAll() {
		List<Tag> tags = tagRepository.findAll();

		Assert.assertEquals("2ks8", tags.stream().findFirst().get().getNome());
		Assert.assertEquals("2ks7", tags.stream().reduce((first, second) -> second).get().getNome());
	}

}
