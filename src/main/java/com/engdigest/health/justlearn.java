package com.engdigest.health;
// package com.engdigest.journalApp.controller;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.engdigest.journalApp.entity.JournalEntry;





// @RestController
// @RequestMapping("/journal")
// public class justlearn {
    
//     private Map<Long , JournalEntry> journalEntries = new HashMap<>();

//     @GetMapping()
//     public List<JournalEntry> getAll(){
//         return new ArrayList<>(journalEntries.values());
//     }

//     @PostMapping
//     public boolean createEntry(@RequestBody JournalEntry myEntry){
//         journalEntries.put(myEntry.getId(), myEntry);
//         return true;
//     }


//     @GetMapping("id/{id}")
//     public JournalEntry getJournalEntryById(@PathVariable("id") long myId){
//         return journalEntries.get(myId);
//     }

//     @DeleteMapping("id/{id}")
//     public JournalEntry deleteMappingById(@PathVariable("id") long myId){
//         return journalEntries.remove(myId);
//     }

//     @PutMapping("id/{id}")
//     public JournalEntry updateJournalById(@PathVariable long id, @RequestBody JournalEntry entry) {
//         //TODO: process PUT request
        
//         return journalEntries.put(id, entry);
//     }
    
// }
