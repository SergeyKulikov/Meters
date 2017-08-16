package com.systems.great.meters;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Sergey on 05.08.2017.
 */

public class MetersDB extends SQLiteOpenHelper {
    ArrayList<Table> tables = new ArrayList<Table>();

    public MetersDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MetersDB(Context context, String name, SQLiteDatabase.CursorFactory factory,
                    int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public String getTableList() {
        // getting a tables' list separated by a comma
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<tables.size(); i++ ) {
            sb.append(tables.get(i).getTableName());
            sb.append((i == tables.size()-1) ? "" : ",");
        }
        return sb.toString();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        for (int i=0; i<tables.size(); i++) {
            tables.get(i).generateTableCreateCode();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
