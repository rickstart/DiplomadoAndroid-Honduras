package com.mobintum.visioncontacts;



/**
 * Created by Rick on 22/06/16.
 * email: ricardo.centeno@mobintum.com
 */
public class Contact {
    
    private String name;
    private String company;
    private String phone;
    private String email;
    private String github;
    private String facebook;
    private String twitter;
    private String photo;

    public Contact(String name, String company, String phone, String email, String github, String facebook, String twitter, String photo) {
        this.name = name;
        this.company = company;
        this.phone = phone;
        this.email = email;
        this.github = github;
        this.facebook = facebook;
        this.twitter = twitter;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
