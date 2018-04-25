package demo.ifeimo.com.newsdemo.data.adapter.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import demo.ifeimo.com.newsdemo.Model.Person;
import demo.ifeimo.com.newsdemo.preference.PreferenceHelper;

/**
 * Created by Wing on 2018/4/13.
 */

public class OrderDao {
    private static final String tag = "OrderDao";
    private final String[] ORDER_COLUMNS = new String[]{"id", "member_id", "password", "sex", "name", "nick", "pic"};
    private Context context;
    private DBhelper dbhelper;

    public OrderDao(Context context) {
        this.context = context;
        dbhelper = new DBhelper(context);
    }

    //数据库是否存在
    public boolean isDataExist() {
        int count = 0;
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = dbhelper.getReadableDatabase();
            cursor = db.query(dbhelper.getTableName(), new String[]{"COUNT(id)"}, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                count = cursor.getInt(0);
            }
            if (count > 0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return false;
    }

    //插入
    public void addDatas(String member_id, String password, String sex, String name, String nick, String pic) {
        SQLiteDatabase db = null;
        try {
            db = dbhelper.getWritableDatabase();
            db.beginTransaction();
            Log.d(tag, "insert into " + dbhelper.getTableName() + "(member_id, password, sex, name, nick, pic) values (" +
                    member_id + "," + "'" + password + "'" + "," + "'" + sex + "'"
                    + "," + "'" + name + "'" + "," + "'" + nick + "'"
                    + "," + "'" + pic + "'" + ")");
            String add = "insert into " + dbhelper.getTableName() + "(member_id, password, sex, name, nick, pic) values (" +
                    member_id + "," + "'" + password + "'" + "," + "'" + sex + "'"
                    + "," + "'" + name + "'" + "," + "'" + nick + "'"
                    + "," + "'" + pic + "'" + ")";
            db.execSQL(add);
            db.setTransactionSuccessful();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.endTransaction();
                db.close();

            }
        }
    }

    //根据Member_id查询
    public JSONObject getDatas(String member_id, String password) {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        String member = null;
        String word = null, sex = null, name = null, nick = null;


        try {
            db = dbhelper.getReadableDatabase();
            cursor = db.query(dbhelper.getTableName(), ORDER_COLUMNS, "member_id = ?", new String[]{member_id}, null, null, null);
            if (cursor.moveToFirst()) {
                do {
                    member = cursor.getString(cursor.getColumnIndex("member_id"));
                    word = cursor.getString(cursor.getColumnIndex("password"));
                    sex = cursor.getString(cursor.getColumnIndex("sex"));
                    name = cursor.getString(cursor.getColumnIndex("name"));
                    nick = cursor.getString(cursor.getColumnIndex("nick"));
                } while (cursor.moveToNext());
            }

            PreferenceHelper.getInstance().savePerson(member, word, sex, name, nick, this.context);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.close();

            }
            if (cursor != null) {
                cursor.close();
            }
        }
        return null;
    }

    //查询Member_id
    public String getMember_id(String member_id, String password) {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        String member = null;
        try {
            db = dbhelper.getReadableDatabase();
            cursor = db.query(dbhelper.getTableName(), ORDER_COLUMNS, "member_id = ?", new String[]{member_id}, null, null, null);
            if (cursor.moveToFirst()) {
                do {
                    member = cursor.getString(cursor.getColumnIndex("member_id"));
                } while (cursor.moveToNext());
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.close();

            }
            if (cursor != null) {
                cursor.close();
            }
        }
        return member;
    }

    //数据转换成类
    private Person parsePerson(Cursor cursor) {
        Person person = new Person();
        person.member_id = (cursor.getString(cursor.getColumnIndex("member_id")));
        person.password = (cursor.getString(cursor.getColumnIndex("password")));
        person.nick = (cursor.getString(cursor.getColumnIndex("nick")));
        person.sex = (cursor.getString(cursor.getColumnIndex("sex")));

        return person;
    }


}
