package com.exercise.raynard.todolist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TaskDBHelper extends SQLiteOpenHelper {

    public TaskDBHelper(Context context){
        super(context, MainActivity.TaskContract.DB_NAME,null, MainActivity.TaskContract.DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + MainActivity.TaskContract.TaskEntry.TABLE +" ( "
                + MainActivity.TaskContract.TaskEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MainActivity.TaskContract.TaskEntry.COL_TASK_TITLE + " TEXT NOT NULL);";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MainActivity.TaskContract.TaskEntry.TABLE);
        onCreate(db);
    }
}
