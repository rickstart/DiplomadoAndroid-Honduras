package com.mobintum.honducontact.models;

import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;

import com.mobintum.honducontact.database.DatabaseAdapter;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Created by Rick on 22/06/16.
 * email: ricardo.centeno@mobintum.com
 */
public class Contact implements Serializable {

    public static final String TABLE_NAME = "Contact";
    public static final String CONTACT_ID = "contactId";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String PATH_PHOTO = "pathPhoto";
    public static final String COMPANY = "company";
    public static final String EMAIL = "email";
    public static final String GITHUB = "github";
    public static final String FACEBOOK = "facebook";
    public static final String TWITTER = "twitter";
    public static final String INSTAGRAM = "instagram";

    private Integer contactId;
    private String firstName;
    private String lastName;
    private String pathPhoto;
    private String company;
    private String email;
    private String github;
    private String facebook;
    private String twitter;
    private String instagram;

    public Contact(String firstName) {
        this.firstName = firstName;
    }

    public Contact(Integer contactId, String firstName, String lastName, String pathPhoto, String company, String email, String github, String facebook, String twitter, String instagram) {
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pathPhoto = pathPhoto;
        this.company = company;
        this.email = email;
        this.github = github;
        this.facebook = facebook;
        this.twitter = twitter;
        this.instagram = instagram;
    }

    public Contact(String firstName, String lastName, String pathPhoto, String company, String email, String github, String facebook, String twitter, String instagram) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pathPhoto = pathPhoto;
        this.company = company;
        this.email = email;
        this.github = github;
        this.facebook = facebook;
        this.twitter = twitter;
        this.instagram = instagram;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPathPhoto() {
        return pathPhoto;
    }

    public void setPathPhoto(String pathPhoto) {
        this.pathPhoto = pathPhoto;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }


    public static long insert(Context context, Contact contact){
        ContentValues cv = new ContentValues();
        cv.put(FIRST_NAME, contact.getFirstName());
        cv.put(LAST_NAME, contact.getLastName());
        cv.put(PATH_PHOTO, contact.getPathPhoto());
        cv.put(COMPANY, contact.getCompany());
        cv.put(EMAIL, contact.getEmail());
        cv.put(GITHUB, contact.getGithub());
        cv.put(FACEBOOK, contact.getFacebook());
        cv.put(TWITTER, contact.getTwitter());
        cv.put(INSTAGRAM, contact.getInstagram());
        return DatabaseAdapter.getDB(context).insert(TABLE_NAME,null,cv);
    }

    public static ArrayList<Contact> getContacts(Context context){
        ArrayList<Contact> contacts = new ArrayList<>();
        Cursor cursor = DatabaseAdapter.getDB(context).query(TABLE_NAME,null,null,null,null,null,null);
        if(cursor!=null) {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                Integer contactId = cursor.getInt(cursor.getColumnIndexOrThrow(CONTACT_ID));
                String firstName = cursor.getString(cursor.getColumnIndexOrThrow(FIRST_NAME));
                String lastName = cursor.getString(cursor.getColumnIndexOrThrow(LAST_NAME));
                String pathPhoto = cursor.getString(cursor.getColumnIndexOrThrow(PATH_PHOTO));
                String company = cursor.getString(cursor.getColumnIndexOrThrow(COMPANY));
                String email = cursor.getString(cursor.getColumnIndexOrThrow(EMAIL));
                String github = cursor.getString(cursor.getColumnIndexOrThrow(GITHUB));
                String facebook = cursor.getString(cursor.getColumnIndexOrThrow(FACEBOOK));
                String twitter = cursor.getString(cursor.getColumnIndexOrThrow(TWITTER));
                String instagram = cursor.getString(cursor.getColumnIndexOrThrow(INSTAGRAM));
                contacts.add(new Contact(contactId, firstName, lastName, pathPhoto, company, email, github, facebook, twitter, instagram));
            }
            cursor.close();
        }

        return contacts;
    }

    public static int deleteContactById(Context context, int contactId){
        int j = DatabaseAdapter.getDB(context).delete(ContactNumber.TABLE_NAME,ContactNumber.FK_CONTACT_ID+"="+contactId,null);
        int i = DatabaseAdapter.getDB(context).delete(TABLE_NAME,CONTACT_ID+"="+contactId,null);
        return i;
    }
}
