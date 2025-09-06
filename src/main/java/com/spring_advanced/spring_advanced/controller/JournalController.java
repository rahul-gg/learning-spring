package com.spring_advanced.spring_advanced.controller;


import com.spring_advanced.spring_advanced.Journal;
import com.spring_advanced.spring_advanced.service.JournalService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("journal")
public class JournalController {

    @Autowired
    JournalService journalService;

    @PostMapping
    public ResponseEntity<Journal> createJournal(@RequestBody Journal journal) {
        try {
            if (journal.getTitle() == null || journal.getTitle().isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Journal createdJournal = journalService.createJournal(journal);
            return new ResponseEntity<>(createdJournal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Journal>> getJournals() {
        try {
            List<Journal> journals = journalService.getJournals();
            return new ResponseEntity<>(journals, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Journal> getJournalById(@PathVariable ObjectId id) {
        Optional<Journal> journal = journalService.getJournalById(id);
        return journal.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Journal> updateJournal(@PathVariable ObjectId id, @RequestBody Journal updatedJournal) {
        Journal prevJournal = journalService.getJournalById(id).orElse(null);
        if (prevJournal != null) {
            if (updatedJournal.getTitle() == null || updatedJournal.getTitle().isEmpty() || updatedJournal.getTitle().equals(prevJournal.getTitle())) {
                return new ResponseEntity<>(prevJournal,HttpStatus.BAD_REQUEST);
            }
            prevJournal.setTitle(updatedJournal.getTitle());
            prevJournal.setDate(LocalDateTime.now());
            return new ResponseEntity<>(journalService.createJournal(prevJournal), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJournal(@PathVariable ObjectId id) {
        try {
            journalService.deleteJournal(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
