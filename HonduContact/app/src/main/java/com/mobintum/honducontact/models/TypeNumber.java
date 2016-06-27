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
public class TypeNumber {
    public static final String TABLE_NAME = "TypeNumber";
    public static final String TYPE_NUMBER_ID = "typeNumberId";
    public static final String TYPE = "type";

    private Integer typeNumberId;
    private String type;

    public TypeNumber(Integer typeNumberId, String type) {
        this.typeNumberId = typeNumberId;
        this.type = type;
    }

    public Integer getTypeNumberId() {
        return typeNumberId;
    }

    public void setTypeNumberId(Integer typeNumberId) {
        this.typeNumberId = typeNumberId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static long insert(Context context, TypeNumber typeNumber){
        ContentValues cv = new ContentValues();
        cv.put(TYPE, typeNumber.getType());
        return DatabaseAdapter.getDB(context).insert(TABLE_NAME, null,cv);
    }

    public static ArrayList<TypeNumber> getTypeNumbers(Context context){
        ArrayList<TypeNumber> typeNumbers = new ArrayList<>();
        Cursor cursor = DatabaseAdapter.getDB(context).query(TABLE_NAME,null,null,null,null,null,null);
        if(cursor!=null){
            for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
                Integer typeNumberId = cursor.getInt(cursor.getColumnIndexOrThrow(TYPE_NUMBER_ID));
                String type = cursor.getString(cursor.getColumnIndexOrThrow(TYPE));
                typeNumbers.add(new TypeNumber(typeNumberId,type));
            }
            cursor.close();
        }
        return typeNumbers;
    }

    public static ArrayList<String> getTypeNumbersString(Context context){
        ArrayList<String> typeNumbers = new ArrayList<>();
        Cursor cursor = DatabaseAdapter.getDB(context).query(TABLE_NAME,null,null,null,null,null,null);
        if(cursor!=null){
            for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
                Integer typeNumberId = cursor.getInt(cursor.getColumnIndexOrThrow(TYPE_NUMBER_ID));
                String type = cursor.getString(cursor.getColumnIndexOrThrow(TYPE));
                typeNumbers.add(type);
            }
            cursor.close();
        }
        return typeNumbers;
    }

    @Override
    public String toString() {
        return type;
    }
}

