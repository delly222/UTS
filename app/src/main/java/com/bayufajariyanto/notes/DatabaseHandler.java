package com.bayufajariyanto.notes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "db_notes";
    private static int DATABASE_VERSION = 1;

    private static final String tb_notes = "tb_notes";

    private static final String tb_id = "tb_id";
    private static final String tb_text = "tb_text";

    private static final String CREATE_TABLE__TEXT = "CREATE TABLE "+tb_notes+"("+tb_id+" INTEGER PRIMARY KEY , "+tb_text+" TEXT "+")";

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE__TEXT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateText(Modal adNotif){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_id,adNotif.getId());
        values.put(tb_text,adNotif.getText());
        db.insert(tb_notes, null, values);
        db.close();
    }

    public List<Modal> ReadNotes(){
        List<Modal> textModalList = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+tb_notes;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do{
                Modal md = new Modal();
                md.setId(cursor.getString(0));
                md.setText(cursor.getString(1));
                textModalList.add(md);
            }while(cursor.moveToNext());
        }
        db.close();
        return textModalList;
    }

    public int Update (Modal adNotif){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(tb_notes, adNotif.getText());

        return db.update(tb_notes, values, tb_id + " = ? ",
                new String[] {String.valueOf(adNotif.getId())});
    }

    public void Delete (Modal adNotif){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_notes, tb_id+" = ?",
                new String[]{String.valueOf(adNotif.getId())});
        db.close();
    }
}
