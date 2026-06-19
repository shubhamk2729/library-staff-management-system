package com.example.library.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class Book {
    
    @Id
    private String id;
    private String name;
    private String type;
    private boolean borrowed;

    public Book() {}

    public Book(String name, String type) {
        this.name = name;
        this.type = type;
        this.borrowed = false;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public boolean isBorrowed() { return borrowed; }
    public void setBorrowed(boolean borrowed) { this.borrowed = borrowed; }
}