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
        contacts.add( new Contact("Ivan Valle", "http://www.grupovision.org", "+504 98090157", "ivalle@grupovision.org", "ivanvallehn" , "ivalle", "@ivanvallehn", "https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-9/12662701_1000123373393170_6257234275068153647_n.jpg?oh=e573bea5de2eac8a43bafc5b8e587fe9&oe=58017A84"));
        contacts.add( new Contact("Maurin Alcántara","http://www.grupovision.org", "89745511", "malcantara@gmail.com","MaurinAlcantara","MAlcantaraf","malcantara90","https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-9/13344649_1357732067573917_2015319381161678062_n.jpg?oh=b1a54448cb76c70a89aa3f89776acb39&oe=58070457"));
        contacts.add( new Contact("Olvin A. Garcia","http:////www.grupovision.org", "+504 9512-0158", "agarcia@grupovision.org","olvingarcia","olvinalexander2a","olvingarcia2a","https://avatars3.githubusercontent.com/u/6761067?v=3&s=460"));
        contacts.add( new Contact("Miguel Calderon","http:////www.grupovision.org", "+504 9596-8431",       "acalderon@grupovision.org","mcalderon022","XXX666","zzzz777","https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-9/10384673_1512308849031639_3624761729857182957_n.jpg?oh=5bcf55f06e0a03fdd1da24e98ebbce2d&oe=57FE9CE2"));
        contacts.add( new Contact("Osman Nuñez", "http://www.grupovision.org", "(504) 33662046", "onunez@grupovision.org", "osmanu71" , "osmanu71", "@osmanu71", "https://fbcdn-profile-a.akamaihd.net/hprofile-ak-xaf1/v/t1.0-1/c0.0.160.160/p160x160/1904140_618424001545396_1679004552_n.jpg?oh=f665a2cdaf4ee2c686453e454da441da&oe=57F8E55B&__gda__=1472411336_d81ca76986d2df160458c6b8e3df748c"));
        contacts.add( new Contact("Mario Romero", "http://www.grupovision.org", "22454002", "mvalladares@grupovision@org", "mariova777", "mario.va777", "mario", "http://4.bp.blogspot.com/-TySxIjecqxM/UycmsFOfAfI/AAAAAAAAAAk/CYllnrMve1E/s1600/DSC07860.JPG"));
        return contacts;
    }
}
