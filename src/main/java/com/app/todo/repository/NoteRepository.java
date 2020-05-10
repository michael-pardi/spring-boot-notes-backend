package com.app.todo.repository;

import org.springframework.data.repository.CrudRepository;
import com.app.todo.model.Note;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface NoteRepository extends CrudRepository<Note, Integer> {
    public Note findNoteByTitle(String title);
    public Note findNoteByUser(String user);
}