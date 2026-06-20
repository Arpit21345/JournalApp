package com.engdigest.journalApp.service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.engdigest.journalApp.entity.JournalEntry;
import com.engdigest.journalApp.entity.User;
import com.engdigest.journalApp.repository.JournalEntryRepository;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class  JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

     @Autowired
      private UserService userService;


// here saving it at two plces then adding in user also 
     public void saveEntry(JournalEntry journalEntry, String userName){
         try{
              User user = userService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
            userService.saveEntry(user);
         }
         catch(Exception e){
            log.error("Exception" , e);
         }
        journalEntryRepository.save(journalEntry);
        
     }

     public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
     }

     public Optional<JournalEntry> findById(ObjectId id){
      return journalEntryRepository.findById(id);
     }

     public void deleteById(ObjectId id , String userName){
       User user = userService.findByUserName(userName);
       user.getJournalEntries().removeIf(x -> x.getId().equals((id)));
       userService.saveEntry(user);
      journalEntryRepository.deleteById(id);
     }
}
// controller call - --->service  calls --->repositriy