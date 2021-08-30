package com.todolist.Manager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.Entity.Note;
import com.todolist.IBusiness.INoteBusiness;
import com.todolist.IData.INoteData;

@Service
public class NoteManager implements INoteBusiness {
	private INoteData noteData;
	
	@Autowired
	public NoteManager(INoteData noteData) {
		this.noteData = noteData;
	}

	@Override
	@Transactional
	public void add(Note note) {
		this.noteData.save(note);
	}

	@Override
	@Transactional
	public void update(Note note) {
		this.noteData.save(note);
	}

	@Override
	@Transactional
	public void delete(Note note) {
		this.noteData.delete(note);
	}

	@Override
	@Transactional
	public List<Note> getAll() {
		return this.noteData.findAll();
	}

	@Override
	@Transactional
	public Optional<Note> getById(String id) {
		return this.noteData.findById(id);
	}


}
