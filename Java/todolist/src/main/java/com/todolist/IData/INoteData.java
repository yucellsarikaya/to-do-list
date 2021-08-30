package com.todolist.IData;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.Entity.Note;

public interface INoteData extends JpaRepository<Note, String> {

}
