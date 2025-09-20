package com.spring_advanced.spring_advanced.service;

import com.spring_advanced.spring_advanced.entity.Journal;
import com.spring_advanced.spring_advanced.entity.User;
import com.spring_advanced.spring_advanced.repository.JournalRepository;
import com.spring_advanced.spring_advanced.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public Journal createJournal(Journal journal, User user) {
        try {
            journal.setDate(LocalDateTime.now());
            Journal created = journalRepository.save(journal);
            List<Journal> updatedList = user.getJournals();
            updatedList.add(created);
            user.setJournals(updatedList);
            userRepository.save(user);
            return created;
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("Something went wrong during the create journal transaction", e);
        }
    }

    public List<Journal> getJournals() {
        return journalRepository.findAll();
    }

    public Optional<Journal> getJournalById(ObjectId id) {
        return journalRepository.findById(id);
    }

    @Transactional
    public void deleteJournal(ObjectId id, String username) {
        try {
            Optional<User> user = userRepository.findUserByUsername(username);
            if (user.isPresent()) {
                User updatedUser = user.get();
                List<Journal> journalList = updatedUser.getJournals();
                journalList.removeIf(value -> value.getId().equals(id));
                journalRepository.deleteById(id);
                updatedUser.setJournals(journalList);
                userRepository.save(updatedUser);
            }
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("Something went wrong while deleting a journal", e);
        }
    }
}
