package io.txg.ankiviewer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/note")
public class NoteRestResource {

	@Autowired
	private NoteRepository noteRepository;

	@RequestMapping("/{order}")
	public Note noteByOrder(@PathVariable("order") Integer order) {
		return noteRepository.findByOrderAdded(order);
	}
	
	@RequestMapping("")
	public List<Note> noteByText(@RequestParam("text") String text, @RequestParam("page") Integer page) {
		return noteRepository.findByText(text, page);
	}

}
