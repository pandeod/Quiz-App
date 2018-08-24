package com.internship.scheduler.Entity;

import java.util.Date;

public class CalendarEvent {
    int sid;
    String title;
    String subject;
    String description;
    Date date;
    String timing;
    String labs;
    String author;
    int authorId;

    public CalendarEvent() {
    }

    public CalendarEvent(int sid, String title, String subject, String description, Date date, String timing, String rooms,int authorId, String author) {
        this.sid = sid;
        this.title = title;
        this.subject = subject;
        this.description = description;
        this.date = date;
        this.timing = timing;
        this.labs = rooms;
        this.author = author;
        this.authorId=authorId;
    }

    public int getSid() {
        return sid;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public String getTiming() {
        return timing;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getLabs() {
        return labs;
    }

    public String getAuthor() {
        return author;
    }
}
