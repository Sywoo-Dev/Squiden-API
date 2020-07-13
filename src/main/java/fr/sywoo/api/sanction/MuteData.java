package fr.sywoo.api.sanction;

import java.util.Date;

public class MuteData {

    private String reason = "Non spécifiée";
    private Date duration;
    private String author;

    public MuteData(String reason, Date duration, String author) {
        this.reason = reason;
        this.duration = duration;
        this.author = author;
    }

    public String getReason() {
        return reason;
    }

    public MuteData setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public Date getDuration() {
        return duration;
    }

    public MuteData setDuration(Date duration) {
        this.duration = duration;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public MuteData setAuthor(String author) {
        this.author = author;
        return this;
    }
}
