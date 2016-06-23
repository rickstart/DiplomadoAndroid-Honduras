package com.mobintum.secondexamplelist;

import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Rick on 23/06/16.
 * email: ricardo.centeno@mobintum.com
 */
public class Person {
    private String firstName;
    private String lastName;
    private String nationality;
    private Date birthdate;
    private String gender;
    private String documentTypeId;
    private String numberId;

    public Person(String firstName, String lastName, String nationality, Date birthdate, String gender, String documentTypeId, String numberId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.birthdate = birthdate;
        this.gender = gender;
        this.documentTypeId = documentTypeId;
        this.numberId = numberId;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(String documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public String getNumberId() {
        return numberId;
    }

    public void setNumberId(String numberId) {
        this.numberId = numberId;
    }

    public static ArrayList<Person> getPeople(){
        ArrayList<Person> people = new ArrayList<>();
        for(int i=0;i<100;i++){
            int year = 16 + i;
            Date birthdate = new Date(year,11,2);
            people.add(new Person("Pedro "+i,"Perez ","Honduras",birthdate,"male","passport", "QWERTY"+i));
        }

        return people;
    }
}
