package com.engdigest.journalApp.service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.engdigest.journalApp.entity.JournalEntry;
import com.engdigest.journalApp.repository.JournalEntryRepository;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class  JournalEntryService {
    @Autowired
    private JournalEntryRepository repository;

     public void saveEntry(JournalEntry journalEntry){
         try{
            journalEntry.setDate(LocalDateTime.now());
            repository.save(journalEntry);
         }
         catch(Exception e){
            log.error("Exception" , e);
         }
        repository.save(journalEntry);
        
     }

     public List<JournalEntry> getAll(){
        return repository.findAll();
     }

     public Optional<JournalEntry> findById(ObjectId id){
      return repository.findById(id);
     }

     public void deleteById(ObjectId id){
      repository.deleteById(id);
     }
}
// controller call - --->service  calls --->repositriy