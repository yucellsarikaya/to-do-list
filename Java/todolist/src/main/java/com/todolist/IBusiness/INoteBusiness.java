package com.todolist.IBusiness;

import java.util.List;
import java.util.Optional;

import com.todolist.Entity.Note;

public interface INoteBusiness {
	void add(Note note);

	void update(Note note);

	void delete(Note note);

	List<Note> getAll();
	
	Optional<Note> getById(String id);
}
