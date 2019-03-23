package com.cybertch.basedatosexercise.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

/**
 * Description:
 * <p>
 * Project: BaseDatosExercise
 * Package: com.cybertch.basedatosexercise.databases
 *
 * @author: Jaive Torres Pineda
 * dateCreated: 3/16/19
 * dateLastModified:
 * @version:
 * @since:
 **/
public class Database extends SQLiteOpenHelper {

    private static final String QUERY_USER="CREATE TABLE contacts(id INTEGER PRIMARY KEY " +
            "AUTOINCREMENT," +
            "name VARCHAR(100),lastname VARCHAR(100),numberPhone VARCHAR(10))";
    private static final String QUERY_USER_DELETE="DROP TABLE IF EXISTS contacts";

    public Database(@Nullable Context context, @Nullable String name,
                    @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QUERY_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(QUERY_USER_DELETE);
        db.execSQL(QUERY_USER);
    }
}
