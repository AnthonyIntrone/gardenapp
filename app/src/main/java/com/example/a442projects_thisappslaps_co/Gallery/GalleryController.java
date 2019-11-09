package com.example.a442projects_thisappslaps_co.Gallery;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.a442projects_thisappslaps_co.Database.DatabaseCursorWrapper;
import com.example.a442projects_thisappslaps_co.Database.DatabaseHelper;

import java.util.ArrayList;
import java.util.Collections;

import static com.example.a442projects_thisappslaps_co.Database.DatabaseSchema.GalleryTable.NAME;

class GalleryController {

    private SQLiteDatabase mSQLiteDatabase;

    GalleryController(Context context) {
        mSQLiteDatabase = new DatabaseHelper(context.getApplicationContext()).getWritableDatabase();
    }

    ArrayList<Project> getProjectList() {
        ArrayList<Project> projects = new ArrayList<>();

        try (DatabaseCursorWrapper cursorWrapper = queryProjects()) {
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast()) {
                projects.add(cursorWrapper.getProject());
                cursorWrapper.moveToNext();
            }
        }

        Collections.reverse(projects);

        return projects;
    }

    private DatabaseCursorWrapper queryProjects() {
        Cursor cursor = mSQLiteDatabase.query(NAME, null, null, null, null, null, null);
        return new DatabaseCursorWrapper(cursor);
    }
}
