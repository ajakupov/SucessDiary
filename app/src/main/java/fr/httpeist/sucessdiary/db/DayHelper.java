package fr.httpeist.sucessdiary.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;

import fr.httpeist.sucessdiary.model.Day;

/**
 * Created by eisti on 14/11/17.
 */

public class DayHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "diary.db";
    public static final int DB_VERSION = 1;

    public DayHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Day " +
                "(number text primary key, name text,text date)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Day");
        onCreate(db);
    }

    public boolean insertDay (String number, String name, String date) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("number", number);
        contentValues.put("name", name);
        contentValues.put("date", date);

        sqLiteDatabase.insert("Day", null, contentValues);
        return true;
    }

    public int deleteDay(String dayNumber) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        return sqLiteDatabase.delete("Day", "number = ?", new String[] {dayNumber});
    }

    public boolean updateDay (String number, String name, String date) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("date", date);
        sqLiteDatabase.update("Day", contentValues, "number = ?", new String[] {number});
        return true;
    }

    public ArrayList<Day> getAllDays () {
        ArrayList<Day> output = new ArrayList<Day>();

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor res = sqLiteDatabase.rawQuery("select * from Day", null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            String name = res.getString(res.getColumnIndex("name"));
            String number = res.getString(res.getColumnIndex("number"));
            String date = res.getString(res.getColumnIndex("date"));

            Day day = new Day(number, name, date);
            output.add(day);

            res.moveToNext();
        }

        return output;
    }
}
