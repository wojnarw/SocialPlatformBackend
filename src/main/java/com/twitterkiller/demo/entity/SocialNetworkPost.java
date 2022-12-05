package com.twitterkiller.demo.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity(name = "posts")
public class SocialNetworkPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private Date postDate;
    @Column
    private String author;
    @Column
    private String content;
    @Column
    private int viewCount;

    public SocialNetworkPost(String author, String content) {
        this.postDate = new Date(System.currentTimeMillis());
        this.author = author;
        this.content = content;
        this.viewCount = 0;
        this.id = 0l;
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
