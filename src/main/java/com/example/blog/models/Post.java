package com.example.blog.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


// @Entity is a JPA annotation to make this object ready for storage in a JPA-based data store.
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String title, announcement, content;

    @Getter
    @Setter
    private int views;

    public Post() {
    }

    public Post(String title, String announcement, String content) {
        this.title = title;
        this.announcement = announcement;
        this.content = content;
    }

    public Post(long id, String title, String announcement, String content) {
        this.id = id;
        this.title = title;
        this.announcement = announcement;
        this.content = content;
    }
}
