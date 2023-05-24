package com.example.notes.controllers;

import com.example.notes.domain.Note;
import com.example.notes.services.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/notes")
    public String get(Model model) {
        model.addAttribute("note", noteService.listOfNotes());
        Note oneNote = new Note();
        model.addAttribute("noteForm", oneNote);
        return "notes";
    }

    @PostMapping("/notes")
    public String post(@ModelAttribute Note note, Model model) {
        noteService.addNote(note);
        return "redirect:/notes";
    }

}
