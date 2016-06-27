package com.mobintum.honducontact.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.mobintum.honducontact.database.DatabaseAdapter;
import java.util.ArrayList;

/**
 * Created by Rick on 27/06/16.
 * email: ricardo.centeno@mobintum.com
 */
public class ContactNumber {

    public static final String TABLE_NAME = "ContactNumber";
    public static final String CONTACT_NUMBER_ID = "contactNumberId";
    public static final String NUMBER = "number";
    public static final String FK_TYPE_NUMBER_ID = "fk_typeNumberId";
    public static final String FK_CONTACT_ID = "fk_contactId";

    private Integer contactNumberId;
    private String number;
    private Integer fk_typeNumberId;
    private Integer fk_contactId;

    public ContactNumber(String number, Integer fk_typeNumberId, Integer fk_contactId) {
        this.number = number;
        this.fk_typeNumberId = fk_typeNumberId;
        this.fk_contactId = fk_contactId;
    }

    public ContactNumber(Integer contactNumberId, String number, Integer fk_typeNumberId, Integer fk_contactId) {
        this.contactNumberId = contactNumberId;
        this.number = number;
        this.fk_typeNumberId = fk_typeNumberId;
        this.fk_contactId = fk_contactId;
    }

    public Integer getContactNumberId() {
        return contactNumberId;
    }

    public void setContactNumberId(Integer contactNumberId) {
        this.contactNumberId = contactNumberId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getFk_typeNumberId() {
        return fk_typeNumberId;
    }

    public void setFk_typeNumberId(Integer fk_typeNumberId) {
        this.fk_typeNumberId = fk_typeNumberId;
    }

    public Integer getFk_contactId() {
        return fk_contactId;
    }

    public void setFk_contactId(Integer fk_contactId) {
        this.fk_contactId = fk_contactId;
    }

    public static long insert(Context context, ContactNumber contactNumber){
        ContentValues cv = new ContentValues();
        cv.put(NUMBER, contactNumber.getNumber());
        cv.put(FK_TYPE_NUMBER_ID, contactNumber.getFk_typeNumberId());
        cv.put(FK_CONTACT_ID, contactNumber.getFk_contactId());
        return DatabaseAdapter.getDB(context).insert(TABLE_NAME,null,cv);
    }

    public static ArrayList<ContactNumber> getContactNumbers(Context context, int contactId){
        ArrayList<ContactNumber> contactNumbers = new ArrayList<>();
        Cursor cursor = DatabaseAdapter.getDB(context).query(TABLE_NAME,null,FK_CONTACT_ID+"="+contactId,null,null,null,null);
        if (cursor!=null) {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                Integer contactNumberId = cursor.getInt(cursor.getColumnIndexOrThrow(CONTACT_NUMBER_ID));
                String number = cursor.getString(cursor.getColumnIndexOrThrow(NUMBER));
                Integer fk_typeNumberId = cursor.getInt(cursor.getColumnIndexOrThrow(FK_TYPE_NUMBER_ID));
                Integer fk_contactId = cursor.getInt(cursor.getColumnIndexOrThrow(FK_CONTACT_ID));
                contactNumbers.add(new ContactNumber(contactNumberId, number, fk_typeNumberId, fk_contactId));
            }
            cursor.close();
        }

        return contactNumbers;

    }
}
