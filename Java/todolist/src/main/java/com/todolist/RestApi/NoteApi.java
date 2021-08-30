package com.todolist.RestApi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.Entity.Note;
import com.todolist.IBusiness.INoteBusiness;

@RestController
@RequestMapping("/api/note")
@CrossOrigin
public class NoteApi {
	private INoteBusiness noteService;

	@Autowired
	public NoteApi(INoteBusiness noteService) {
		this.noteService = noteService;
	}
	
	@GetMapping("/list")
	public List<Note> get(){
		return this.noteService.getAll();
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody Note note) {
		this.noteService.delete(note);
	}
	
	@PostMapping("/add")
	public void add(@RequestBody Note note) {
		this.noteService.add(note);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody Note note) {
		this.noteService.update(note);
	}
	
	@GetMapping("/{id}")
	public Optional<Note> getById(@PathVariable String id){
		return this.noteService.getById(id);
	}
}
