package com.app.todo.controller;

import com.app.todo.handler.ContentNotFoundException;
import com.app.todo.model.Note;
import com.app.todo.model.NoteRequestBody;
import com.app.todo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@RestController(value = "/notes")
public class NoteController {
    @Autowired
    private NoteRepository noteRepo;

    @PostMapping("/note/add")
    public ResponseEntity<?> addNote(@Valid @RequestBody Note note, HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();

        note.setUser(principal.getName());

        noteRepo.save(note);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/note/getByTitle")
    public Note getNoteByTitle(@Valid @RequestBody NoteRequestBody requestBody, HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();

        return noteRepo.findNoteByUserAndTitle(principal.getName(), requestBody
                .getTerm()).orElseThrow(() -> new ContentNotFoundException("Note", "Title", requestBody.getTerm()));
    }

}
