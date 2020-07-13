package fr.sywoo.api.sanction;

import java.util.Date;

public class BanData {

    private String reason = "Non spécifiée";
    private Date duration;
    private String author;

    public BanData(String reason, Date duration, String author) {
        this.reason = reason;
        this.duration = duration;
        this.author = author;
    }

    public String getReason() {
        return reason;
    }

    public BanData setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public Date getDuration() {
        return duration;
    }

    public BanData setDuration(Date duration) {
        this.duration = duration;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public BanData setAuthor(String author) {
        this.author = author;
        return this;
    }
}
