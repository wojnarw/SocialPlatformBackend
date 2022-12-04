package com.twitterkiller.demo.entity;

import java.util.Date;
import java.util.UUID;

public class SocialNetworkPost {
    private String id;
    private Date postDate;
    private String author;
    private String content;
    private int viewCount;

    public SocialNetworkPost(Date postDate, String author, String content) {
        this.postDate = postDate;
        this.author = author;
        this.content = content;
        this.viewCount = 0;
        this.id = UUID.randomUUID().toString();
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

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public int getViewCount() {
        return viewCount;
    }
}
