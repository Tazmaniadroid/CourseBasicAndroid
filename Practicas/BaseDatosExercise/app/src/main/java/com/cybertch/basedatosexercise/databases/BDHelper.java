package com.cybertch.basedatosexercise.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cybertch.basedatosexercise.models.Contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
public class BDHelper {

    private Context context = null;
    private SQLiteDatabase sqLiteDatabase = null;
    private Database database = null;

    private static final String DB_NAME = "contacts_bd";
    private static final int VERSION_BD = 1;

    public static final int MODE_READ = 1;
    public static final int MODE_WRITE = 2;

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String LASTNAME = "lastname";
    private static final String NUMBERPHONE = "numberPhone";
    private static final String TABLE = "contacts";

    public BDHelper() {
    }

    public BDHelper(Context context, int mode) {
        this.context = context;
        database = new Database(context, DB_NAME, null, VERSION_BD);
        if (mode == MODE_READ) {
            sqLiteDatabase = database.getReadableDatabase();
        } else {
            sqLiteDatabase = database.getWritableDatabase();
        }
    }

    public boolean insert(Contact contact) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, contact.getId());
        contentValues.put(NAME, contact.getName());
        contentValues.put(LASTNAME, contact.getLastname());
        contentValues.put(NUMBERPHONE, contact.getNumberPhone());
        long insert = sqLiteDatabase.insert(TABLE, null, contentValues);
        if (insert != 0 && insert > 0)
            return true;
        else
            return false;
    }

    public boolean update(int id, HashMap<String, String> fields) {
        if (fields != null && fields.size() != 0) {
            ContentValues contentValues = new ContentValues();
            for (String key : fields.keySet()) {
                contentValues.put(key, fields.get(key));
            }
            String[] args = new String[]{Integer.toString(id)};
            long update = sqLiteDatabase.update(TABLE, contentValues, "id=?", args);
            if (update != 0 && update > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean delete(int id) {
        String[] args = new String[]{Integer.toString(id)};
        long delete = sqLiteDatabase.delete(TABLE, "id=?", args);
        if (delete != 0 && delete > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Contact query(int id) {
        Contact contact = null;
        String[] fields = new String[]{
                ID, NAME, LASTNAME, NUMBERPHONE
        };
        String[] args = new String[]{Integer.toString(id)};
        Cursor cursor = sqLiteDatabase.query(TABLE, fields, "id=", args,
                null, null, null);
        if (cursor.moveToFirst()) {
            do {
                contact = new Contact();
                contact.setId(cursor.getInt(0));
                contact.setName(cursor.getString(1));
                contact.setLastname(cursor.getString(2));
                contact.setNumberPhone(cursor.getString(3));
            } while (cursor.moveToNext());
        }
        return contact;
    }

    public List<Contact> queryAll(int id) {
        List<Contact> contacts = null;
        String[] fields = new String[]{
                ID, NAME, LASTNAME, NUMBERPHONE
        };
        String[] args = new String[]{Integer.toString(id)};
        Cursor cursor = sqLiteDatabase.query(TABLE, fields, "id=", args,
                null, null, null);
        if (cursor.moveToFirst()) {
            contacts = new ArrayList<Contact>();
            do {
                contacts.add(new Contact(cursor.getInt(cursor.getColumnIndex(ID)),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)));
            } while (cursor.moveToNext());
        }
        return contacts;
    }
}
