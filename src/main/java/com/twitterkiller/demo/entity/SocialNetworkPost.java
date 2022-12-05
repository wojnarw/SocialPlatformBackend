package com.twitterkiller.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.sql.Date;

@Entity(name = "posts")
public class SocialNetworkPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Date postDate;
    @Column
    @Size(min = 3, max = 64)
    private String author;
    @Column
    @Size(min = 3, max = 65000)
    private String content;
    @Column
    private int viewCount;

    public SocialNetworkPost(String author, String content) {
        this.postDate = new Date(System.currentTimeMillis());
        this.author = author;
        this.content = content;
        this.viewCount = 0;
    }

    // constructor for dummy data generator
    public SocialNetworkPost(String author, String content, int viewCount) {
        this.postDate = new Date(System.currentTimeMillis());
        this.author = author;
        this.content = content;
        this.viewCount = viewCount;
    }

    public SocialNetworkPost() {

    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public Date getPostDate() {
        return postDate;
    }

    public String getAuthor() {
        return author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public int getViewCount() {
        return viewCount;
    }

    @Override
    public String toString() {
        return "SocialNetworkPost{" +
                "id=" + id +
                ", postDate=" + postDate +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", viewCount=" + viewCount +
                '}';
    }
}
