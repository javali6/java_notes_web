package com.example.notes.services;

import com.example.notes.domain.Note;
import com.example.notes.repositories.NoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.List;

@Slf4j
@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    NoteRepository noteRepository;

    @Override
    public List<Note> listOfNotes() {
        return noteRepository.findByOrderByTimestampDesc();
    }

    @Override
    public void addNote(Note note) {
        log.debug("OFFSETDATETIME: " + OffsetDateTime.now());
        note.setTimestamp(new Timestamp(System.currentTimeMillis()));
        noteRepository.save(note);
    }
}
