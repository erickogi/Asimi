package com.erickogi14gmail.asimi.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

import static com.erickogi14gmail.asimi.Data.DBKeys.KEY_ID;
import static com.erickogi14gmail.asimi.Data.DBKeys.KEY_REMAINDER_DESCRIPTION;
import static com.erickogi14gmail.asimi.Data.DBKeys.KEY_REMAINDER_KEY;
import static com.erickogi14gmail.asimi.Data.DBKeys.KEY_REMAINDER_NAME;
import static com.erickogi14gmail.asimi.Data.DBKeys.KEY_REMAINDER_PLACE_LATITUDE;
import static com.erickogi14gmail.asimi.Data.DBKeys.KEY_REMAINDER_PLACE_LONGITUDE;
import static com.erickogi14gmail.asimi.Data.DBKeys.KEY_REMAINDER_PLACE_NAME;
import static com.erickogi14gmail.asimi.Data.DBKeys.KEY_REMAINDER_STATE;
import static com.erickogi14gmail.asimi.Data.DBKeys.KEY_REMAINDER_TIME;
import static com.erickogi14gmail.asimi.Data.DBKeys.TABLE;

/**
 * Created by kimani kogi on 4/21/2017.
 */

public class DBOperations {
    private DBHandler dbHandler;
    private final Context mCtx;


    public DBOperations(Context context) {

        mCtx = context;
    }

    public void open() throws SQLException{
        dbHandler = new DBHandler(mCtx);

    }




    public int insert(DBKeys Keys) {

        //Open connection to write data
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_REMAINDER_NAME, Keys.REMAINDER_NAME);
        values.put(KEY_REMAINDER_DESCRIPTION, Keys.REMAINDER_DESCRIPTION);

        values.put(KEY_REMAINDER_PLACE_LATITUDE, Keys.REMAINDER_PLACE_LATITUDE);
        values.put(KEY_REMAINDER_PLACE_LONGITUDE, Keys.REMAINDER_PLACE_LONGITUDE);
        values.put(KEY_REMAINDER_TIME, Keys.REMAINDER_TIME);

        values.put(KEY_REMAINDER_STATE, Keys.REMAINDER_STATE);
        values.put(KEY_REMAINDER_KEY, Keys.REMAINDER_KEY);

        values.put(KEY_REMAINDER_PLACE_NAME, Keys.REMAINDER_PLACE_NAME);


        // Inserting Row
        long keys_Id = db.insert(DBKeys.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) keys_Id;
    }

    public void insertData(
            String REMAINDER_NAME, String REMAINDER_DESCRIPTION, String REMAINDER_PLACE_LATITUDE, String REMAINDER_PLACE_LONGITUDE
            , String REMAINDER_STATE, String REMAINDER_KEY, String REMAINDER_PLACE_NAME, long REMAINDER_TIME){
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_REMAINDER_NAME, REMAINDER_NAME);
        values.put(KEY_REMAINDER_DESCRIPTION, REMAINDER_DESCRIPTION);

        values.put(KEY_REMAINDER_PLACE_LATITUDE, REMAINDER_PLACE_LATITUDE);
        values.put(KEY_REMAINDER_PLACE_LONGITUDE, REMAINDER_PLACE_LONGITUDE);
        values.put(KEY_REMAINDER_TIME, REMAINDER_TIME);

        values.put(KEY_REMAINDER_STATE, REMAINDER_STATE);
        values.put(KEY_REMAINDER_KEY, REMAINDER_KEY);

        values.put(KEY_REMAINDER_PLACE_NAME, REMAINDER_PLACE_NAME);
       db.insert(DBKeys.TABLE, null, values);



    }
    //Overload to take reminder
    public long insertData(DBPojo pojo) {
        DBKeys Keys = new DBKeys();

        //Open connection to write data
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_REMAINDER_NAME, pojo.getREMAINDER_NAME());
        values.put(KEY_REMAINDER_DESCRIPTION, pojo.getREMAINDER_DESCRIPTION());

        values.put(KEY_REMAINDER_PLACE_LATITUDE, pojo.getREMAINDER_PLACE_LATITUDE());
        values.put(KEY_REMAINDER_PLACE_LONGITUDE, pojo.getREMAINDER_PLACE_LONGITUDE());
        values.put(KEY_REMAINDER_TIME, pojo.getREMAINDER_TIME());

        values.put(KEY_REMAINDER_STATE, pojo.getREMAINDER_STATE());
        values.put(KEY_REMAINDER_KEY, pojo.getREMAINDER_KEY());

        values.put(KEY_REMAINDER_PLACE_NAME, pojo.getREMAINDER_PLACE_NAME());


        // Inserting Row
        long keys_Id = db.insert(DBKeys.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) keys_Id;
    }



    public boolean update(String Id, String REMAINDER_NAME, String REMAINDER_DESC, String REMAINDER_PLACE_LAT, String REMAINDER_PLACE_LONG
            , String REMAINDER_STATE, String REMAINDER_KEY, String REMAINDER_PLACE_NAME, String REMAINDER_TIME


    ) {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(KEY_REMAINDER_NAME, REMAINDER_NAME);
        values.put(KEY_REMAINDER_DESCRIPTION, REMAINDER_DESC);

        values.put(KEY_REMAINDER_PLACE_LATITUDE, REMAINDER_PLACE_LAT);
        values.put(KEY_REMAINDER_PLACE_LONGITUDE, REMAINDER_PLACE_LONG);

        values.put(KEY_REMAINDER_TIME, REMAINDER_TIME);

        values.put(KEY_REMAINDER_STATE, REMAINDER_STATE);
        values.put(KEY_REMAINDER_KEY, REMAINDER_KEY);

        values.put(KEY_REMAINDER_PLACE_NAME, REMAINDER_PLACE_NAME);


        return db.update(DBKeys.TABLE, values, KEY_ID + "=" + Id, null) > 0;
    }

    public boolean delete(String rowId) {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        return db.delete(DBKeys.TABLE, KEY_ID + "=" + rowId, null) > 0;
    }




    public ArrayList<DBPojo> getTimeList(){
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        ArrayList<DBPojo> timeData = new ArrayList<>();
        String query = "SELECT "+DBKeys.KEY_REMAINDER_TIME+" FROM "+DBKeys.TABLE;

        Cursor cursor = db.rawQuery(query,null);

        if(!cursor.isLast()){
            while (cursor.moveToNext()){
                DBPojo pojo = new DBPojo();
                pojo.setREMAINDER_TIME(cursor.getLong(5));

                timeData.add(pojo);
            }
        }

        db.close();

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return timeData;
    }

    public ArrayList<DBPojo> getGameList() {
        //Open connection to read only
        SQLiteDatabase db = dbHandler.getReadableDatabase();


        ArrayList<DBPojo> data = new ArrayList<>();
        String QUERY = "SELECT * FROM " + DBKeys.TABLE;


        Cursor cursor = db.rawQuery(QUERY, null);

        if (!cursor.isLast()) {

            while (cursor.moveToNext()) {
                DBPojo pojo = new DBPojo();

                String name = cursor.getString(1);
                pojo.setID(cursor.getInt(0));
                pojo.setREMAINDER_NAME(cursor.getString(1));
                pojo.setREMAINDER_DESCRIPTION(cursor.getString(2));

                pojo.setREMAINDER_PLACE_LATITUDE(cursor.getString(3));
                pojo.setREMAINDER_PLACE_LONGITUDE(cursor.getString(4));

                pojo.setREMAINDER_TIME(cursor.getLong(5));

                pojo.setREMAINDER_STATE(cursor.getString(6));
                pojo.setREMAINDER_KEY(cursor.getString(7));

                pojo.setREMAINDER_PLACE_NAME(cursor.getString(8));


                data.add(pojo);

            }
        }
        db.close();
        // looping through all rows and adding to list

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return data;


    }
}
