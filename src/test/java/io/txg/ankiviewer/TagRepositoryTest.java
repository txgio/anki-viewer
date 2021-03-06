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
public class TagRepositoryTest {

	@Autowired
	private TagRepository tagRepository;

	@Test
	public void testFindAll() {
		List<Tag> tags = tagRepository.findAll();

		Assert.assertEquals("Tag01", tags.stream().findFirst().get().getNome());
		Assert.assertEquals("Tag02", tags.stream().reduce((first, second) -> second).get().getNome());
	}

}
