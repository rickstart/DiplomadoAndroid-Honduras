package com.mobintum.honducontact.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rick on 27/06/16.
 * email: ricardo.centeno@mobintum.com
 */
public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "visioncontact.db";
    private static final Integer VER_1 = 1;
    private static final Integer DATABASE_VERSION = VER_1;

    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE Contact (" +
                "   contactId integer NOT NULL CONSTRAINT Contact_pk PRIMARY KEY AUTOINCREMENT," +
                "   firstName varchar(250) NOT NULL," +
                "   lastName varchar(250)," +
                "   pathPhoto text," +
                "   company varchar(250)," +
                "   email varchar(250)," +
                "   github varchar(250)," +
                "   facebook varchar(250)," +
                "   twitter varchar(250)," +
                "   instagram varchar(250)" +
                ");");

        db.execSQL("CREATE TABLE ContactNumber (" +
                "    contactNumberId integer NOT NULL CONSTRAINT ContactNumber_pk PRIMARY KEY AUTOINCREMENT," +
                "    number varchar(250) NOT NULL," +
                "    fk_contactId integer NOT NULL," +
                "    fk_typeNumberId integer NOT NULL," +
                "    CONSTRAINT ContactNumber_Contact FOREIGN KEY (fk_contactId)" +
                "    REFERENCES Contact (contactId)," +
                "    CONSTRAINT ContactNumber_TypeNumber FOREIGN KEY (fk_typeNumberId)" +
                "    REFERENCES TypeNumber (typeNumberId)" +
                ");");

        db.execSQL("CREATE TABLE TypeNumber (" +
                "   typeNumberId integer NOT NULL CONSTRAINT TypeNumber_pk PRIMARY KEY AUTOINCREMENT," +
                "   type varchar(250) NOT NULL" +
                ");");

        db.execSQL("INSERT INTO TypeNumber (type) VALUES ('Home');");
        db.execSQL("INSERT INTO TypeNumber (type) VALUES ('Mobile');");
        db.execSQL("INSERT INTO TypeNumber (type) VALUES ('Fax');");
        db.execSQL("INSERT INTO TypeNumber (type) VALUES ('Office');");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion!=newVersion){

        }

    }
}
