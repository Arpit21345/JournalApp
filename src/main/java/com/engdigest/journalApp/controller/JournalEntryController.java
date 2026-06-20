package com.engdigest.journalApp.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engdigest.journalApp.entity.JournalEntry;
import com.engdigest.journalApp.entity.User;
import com.engdigest.journalApp.service.JournalEntryService;
import com.engdigest.journalApp.service.UserService;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    

      @Autowired
      private JournalEntryService journalservice;

      @Autowired
      private UserService userService;


    @GetMapping("{userName}")
    public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String userName){
      User user = userService.findByUserName(userName);
          
      List<JournalEntry> all  = user.getJournalEntries();
      if(all != null && !all.isEmpty()){
            return new ResponseEntity(all, HttpStatus.OK);
      }
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("{userName}")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry, @PathVariable String userName){
      
      try{
        
    
      journalservice.saveEntry(myEntry,userName);
      return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
      }
      catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }  
    }


    @GetMapping("id/{id}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable("id") ObjectId myId){
      Optional<JournalEntry> journalEntry = journalservice.findById(myId);
      if(journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }

    @DeleteMapping("id/{userName}/{id}")
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable("id") ObjectId myId, @PathVariable("userName") String userName){
          journalservice.deleteById(myId, userName);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
 
    @PutMapping("id/{id}")
    public ResponseEntity<?> updateJournalById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry) {
      
      // // JournalEntry old = service.findById(id).orElseThrow(()-> new RuntimeException("Journal Entry not found "));
      // JournalEntry old = service.findById(id).orElse(null);

      // if(old!=null){
      //       old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("")? newEntry.getTitle(): old.getTitle());
      //       old.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("")? newEntry.getContent(): old.getContent());
      //       service.saveEntry(old);
      //       return new ResponseEntity<>(old,HttpStatus.OK);
      // }

      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      
      

    }
    
}
