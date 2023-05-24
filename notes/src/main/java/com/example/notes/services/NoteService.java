package com.example.notes.services;

import com.example.notes.domain.Note;

import java.util.List;

public interface NoteService {

    List<Note> listOfNotes();
    void addNote(Note note);
}
