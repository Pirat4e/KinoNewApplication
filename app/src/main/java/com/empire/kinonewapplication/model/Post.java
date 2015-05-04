package com.empire.kinonewapplication.model;

import java.util.ArrayList;

/**
 * Created by Ivanco on 04.05.2015.
 */
public class Post {
    private String title;
    private String url;
    private String content;
    private ArrayList<Attachment> attachments;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(ArrayList<Attachment> attachments) {
        this.attachments = attachments;
    }
}
