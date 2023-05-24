package com.example.notes.repositories;

import com.example.notes.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByOrderByTimestampDesc();

}
