package demo.ifeimo.com.newsdemo.data.adapter.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Wing on 2018/4/13.
 */

public class DBhelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "login.db";
    private static final String TABLE_NAME = "Orders";

    public DBhelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//create table Orders(id integer primary key autoincrement,member_id text,password text,sex text,name text,nick text,pic text);
        String sql = "create table if not exists " + TABLE_NAME + "(id integer primary key autoincrement,member_id text,password text,sex text,name text,nick text,pic text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists" + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    public String getTableName() {
        return TABLE_NAME;
    }


}
