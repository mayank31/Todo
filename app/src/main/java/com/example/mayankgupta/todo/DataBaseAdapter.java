package com.example.mayankgupta.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by mayankgupta on 30/09/2016.
 */
public class DataBaseAdapter {
    static final String DATABASE_NAME = "Todo.db";
    static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;
    static final String DATABASE_CREATE = "create table " + "TodoData" + "( "
            + "Title" + " text primary key ,"
            + "Description  text); ";
    public SQLiteDatabase db;
    private final Context context;
    private DataBaseHelper dbHelper;
    public DataBaseAdapter(Context _context) {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null,
                DATABASE_VERSION);
    }
    public DataBaseAdapter open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        db.close();
    }


    public void insertEntry(String mtitle, String mdesc) {
        ContentValues newValues = new ContentValues();
        newValues.put("Title",mtitle);
        newValues.put("Description", mdesc);


        db.insert("TodoData", null, newValues);

    }
    public int deleteEntry(String title) {

        String where = "Title=?";
        int numberOFEntriesDeleted = db.delete("TodoData", where,
                new String[] { title });

        return numberOFEntriesDeleted;
    }
    public Cursor getData()
    {
      //  Cursor cursor = db.query("ToDoData", null, null,
        //        null, null, null, null);
        Cursor  cursor=db.rawQuery("Select * from TodoData;",null);
        cursor.moveToFirst();
        return cursor;
    }
    public void updateEntry(String Name, String email, String rollno) {
        ContentValues updatedValues = new ContentValues();
        updatedValues.put("Name", Name);
        updatedValues.put("Email", email);

        String where = "Rollno = ?";
        db.update("UserData", updatedValues, where, new String[] { rollno });
    }
}
