package com.spring_advanced.spring_advanced.service;

import com.spring_advanced.spring_advanced.Journal;
import com.spring_advanced.spring_advanced.repository.JournalRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalService {

    @Autowired
    JournalRepository journalRepository;

    public Journal createJournal(Journal journal) {
        journal.setDate(LocalDateTime.now());
        return journalRepository.save(journal);
    }

    public List<Journal> getJournals() {
        return journalRepository.findAll();
    }

    public Optional<Journal> getJournalById(ObjectId id) {
        return journalRepository.findById(id);
    }

    public void deleteJournal(ObjectId id) {
        journalRepository.deleteById(id);
    }
}
