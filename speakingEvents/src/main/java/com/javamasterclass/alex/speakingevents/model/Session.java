package com.javamasterclass.alex.speakingevents.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long session_id;

    private String title;
    private String description;
    @ElementCollection
    private List<String> categories;
    @ManyToMany
    @JoinTable(
            name = "session_speakers",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "speaker_id")
    )
    private List<Speaker> speakers;
    private String level;
    @Embedded
    private Location location;
    private int duration;
    private Date date;

    public long getSession_id() {
        return session_id;
    }

    public void setSession_id(long session_id) {
        this.session_id = session_id;
    }

    public java.lang.String getTitle() {
        return title;
    }

    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    public java.lang.String getDescription() {
        return description;
    }

    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    public List<java.lang.String> getCategories() {
        return categories;
    }

    public void setCategories(List<java.lang.String> categories) {
        this.categories = categories;
    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean fieldIsNull () {
        if(title == null) return true;
        if(description == null) return true;
        if(categories == null) return true;
        if(speakers == null) return true;
        if(level == null) return true;
        if(duration == 0) return true;
        if(location == null) return true;
        return date == null;
    }
}
