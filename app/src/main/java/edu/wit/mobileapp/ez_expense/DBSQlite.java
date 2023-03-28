package edu.wit.mobileapp.ez_expense;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBSQlite extends SQLiteOpenHelper {
    /* will be name of database which is created in Android device */
    public static final String DBNAME = "Login.db";

    /* will create database Login.db*/
    public DBSQlite(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        /* will execute SQL query
           will create a table of users which will have 3 columns: 1st - username, 2nd - email,
           3rd - password*/
        MyDB.execSQL("create Table users(username TEXT primary key, email TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop table if exists users");
    }

    /* method to insert data into database */
    public Boolean insertData(String username, String email, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);

        /* if insertion is not possible or insertion failed return false else returns true*/
        if(result == -1) {
            return false;
        } else {
            return true;
        }
    }

    /* checks whether the username exists in the table already or not */
    public Boolean checkUsername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[] {username});

        /* if user exists return true else return false */
        if(cursor.getCount() > 0 ) {
            return true;
        } else {
            return false;
        }
    }

    /* checks email */
    public Boolean checkEmail(String email) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where email = ?", new String[] {email});

        /* if user exists return true else return false */
        if(cursor.getCount() > 0 ) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkUsernamePassword(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username, password});

        /* if user exists return true else return false */
        if(cursor.getCount() > 0 ) {
            return true;
        } else {
            return false;
        }
    }

    /* method to fetch data from SQLite database and return the data*/
   /* public Cursor viewData() {

        /* creates SQLite Database object and gets readable database */
       /* SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        /* creates Cursor object
        *  by using SQLite database object */
      /*  Cursor cursor = sqLiteDatabase.rawQuery("select * from users", null);

        return cursor;
    } */


}

