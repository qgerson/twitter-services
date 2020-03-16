package com.qgerson.twitterservice.domain;

import javax.persistence.*;

@Entity
public class Tweet {
    @Id
    @GeneratedValue
    @Column( nullable = false )
    private Integer id;

    @Column( nullable = false )
    private String user;

    @Column( nullable = false )
    private String text;

    @Column( nullable = true )
    private String location;

    @Column( nullable = false )
    private String languageId;

    @Column(nullable = false )
    private boolean isValid;

    public Tweet() {
    }

    public Tweet(String user, String text, String location, String languageId,boolean isValid) {
        this.user = user;
        this.text = text;
        this.location = location;
        this.languageId = languageId;
        this.isValid = isValid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLanguageId() {
        return languageId;
    }

    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
