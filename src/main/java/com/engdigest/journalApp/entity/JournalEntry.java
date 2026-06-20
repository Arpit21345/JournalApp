package com.engdigest.journalApp.entity;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document

@Data
@NoArgsConstructor
// reqyired for deserilzation json to pojo 
public class JournalEntry {
    
    @Id
    private ObjectId  id;
    @NonNull
    private String title;

    private String content;

    private LocalDateTime date;

   

    
}
