package com.app.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.todo.model.Note;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface NoteRepository extends JpaRepository<Note, Integer> {
    public Optional<Note> findNoteByUserAndTitle(String user, String title);
}