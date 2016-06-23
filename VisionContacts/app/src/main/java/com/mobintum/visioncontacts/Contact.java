package com.mobintum.visioncontacts;

import java.util.ArrayList;

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

    public static ArrayList<Contact> getContacts(){
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add( new Contact("Ricardo Centeno", "http://www.mobintum.com", "(521) 5514382887", "ricardo.centeno@mobintum.com", "rickstart" , "ricardo.centenolugo", "@rickstart", "https://avatars2.githubusercontent.com/u/3117867?v=3&s=460"));
        contacts.add( new Contact("Ivan Valle", "http://www.grupovision.org", "+504 98090157", "ivalle@grupovision.org", "ivanvallehn" , "ivalle", "@ivanvallehn", "https://www.facebook.com/photo.php?fbid=10153252661638928&set=t.798028927&type=3&theater"));
        contacts.add( new Contact("Maurin Alcántara","http://www.grupovision.org", "89745511", "malcantara@gmail.com","MaurinAlcantara","MAlcantaraf","malcantara90","https://www.facebook.com/282987965048338/photos/t.1630209199/1357732067573917/?type=3&theater"));
        contacts.add( new Contact("Olvin A. Garcia","http:////www.grupovision.org", "+504 9512-0158", "agarcia@grupovision.org","olvingarcia","olvinalexander2a","olvingarcia2a","https://avatars3.githubusercontent.com/u/6761067?v=3&s=460"));
        contacts.add( new Contact("Miguel Calderon","http:////www.grupovision.org", "+504 9596-8431",       "acalderon@grupovision.org","mcalderon022","XXX666","zzzz777","https://www.facebook.com/photo.php?fbid=1512308849031639&set=a.1485661858363005.1073741826.100007576158366&type=3"));
        contacts.add( new Contact("Osman Nuñez", "http://www.grupovision.org", "(504) 33662046", "onunez@grupovision.org", "osmanu71" , "osmanu71", "@osmanu71", "https://www.facebook.com/photo.php?fbid=618424001545396&set=a.115116515209483.24000.100001334046916&type=3&theater"));
        return contacts;
    }
}
