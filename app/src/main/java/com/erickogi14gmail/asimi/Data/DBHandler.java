package com.erickogi14gmail.asimi.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kimani kogi on 4/21/2017.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "remainders.db";
    String CREATE_TABLE = "CREATE TABLE " + DBKeys.TABLE + "("
            + DBKeys.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"

            + DBKeys.KEY_REMAINDER_NAME + " TEXT, "
            + DBKeys.KEY_REMAINDER_DESCRIPTION + " TEXT, "

            + DBKeys.KEY_REMAINDER_PLACE_LATITUDE + " TEXT ,"
            + DBKeys.KEY_REMAINDER_PLACE_LONGITUDE + " TEXT ,"

            + DBKeys.KEY_REMAINDER_TIME + " Text ,"


            + DBKeys.KEY_REMAINDER_STATE + " TEXT ,"
            + DBKeys.KEY_REMAINDER_KEY + " TEXT ,"


            + DBKeys.KEY_REMAINDER_PLACE_NAME + " TEXT"

            + ")";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DBKeys.TABLE);


        // Create tables again
        onCreate(db);

    }

}

