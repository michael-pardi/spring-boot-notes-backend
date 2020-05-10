package com.app.todo.controller;

import com.app.todo.model.Note;
import com.app.todo.model.UserInfo;
import com.app.todo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/notes")
public class NoteController {
    @Autowired
    private NoteRepository noteRepo;

    @PostMapping("/note/add")
    public ResponseEntity<?> addNote(@RequestBody Note note) {
        Note newNote = new Note();

        newNote.setTitle(note.getTitle());
        newNote.setContent(note.getContent());
        newNote.setUser(note.getUser());

        noteRepo.save(newNote);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/note/getByTitle")
    public ResponseEntity<Note> getNoteByTitle(@RequestBody String title) {
        Note note = noteRepo.findNoteByTitle(title);

        if (note == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(note, HttpStatus.OK);
    }

}
