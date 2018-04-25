package demo.ifeimo.com.newsdemo.preference;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONObject;

/**
 * Created by Wing on 2018/3/11.
 */

public class PreferenceHelper {
    private String IDENTIFY = "com.li.NewsApp";

    public PreferenceHelper() {
        super();
    }

    public static PreferenceHelper instance;

    public static PreferenceHelper getInstance() {
        if (instance == null) {
            synchronized (PreferenceHelper.class) {
                if (instance == null) {
                    instance = new PreferenceHelper();
                }
            }
        }
        return instance;
    }

    public void clear(Context context) {
        SharedPreferences share = context.getSharedPreferences(IDENTIFY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = share.edit();
        editor.clear();
        editor.commit();
    }

    public void savePerson(String member, String password, String sex, String name, String nick, Context context) {
        SharedPreferences share = context.getSharedPreferences(IDENTIFY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = share.edit();
        editor.putString("member_id", member);
        editor.putString("password", password);
        editor.putString("sex", sex);
        editor.putString("name", name);
        editor.putString("nick", nick);
        editor.commit();
    }

    public void saveIfLogined(String status, Context context) {

        SharedPreferences share = context.getSharedPreferences(IDENTIFY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = share.edit();
        editor.putString("status", status);
        editor.commit();
    }

    public String getMember(Context context) {
        SharedPreferences share = context.getSharedPreferences(IDENTIFY, Context.MODE_PRIVATE);
        return share.getString("member_id", "");
    }

    public String getPassword(Context context) {
        SharedPreferences share = context.getSharedPreferences(IDENTIFY, Context.MODE_PRIVATE);
        return share.getString("password", "");
    }

    public String getSex(Context context) {
        SharedPreferences share = context.getSharedPreferences(IDENTIFY, Context.MODE_PRIVATE);
        return share.getString("sex", "");
    }

    public String getName(Context context) {
        SharedPreferences share = context.getSharedPreferences(IDENTIFY, Context.MODE_PRIVATE);
        return share.getString("name", "");
    }

    public String getNick(Context context) {
        SharedPreferences share = context.getSharedPreferences(IDENTIFY, Context.MODE_PRIVATE);
        return share.getString("nick", "");
    }

    public String getIfLogined(Context context) {
        SharedPreferences share = context.getSharedPreferences(IDENTIFY, Context.MODE_PRIVATE);
        return share.getString("status", "");
    }

    public void saveLoginMember(String member_id, Context context) {
        SharedPreferences share = context.getSharedPreferences(IDENTIFY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = share.edit();
        editor.putString("member", member_id);
        editor.commit();
    }

    public void saveLoginPassword(String password, Context context) {
        SharedPreferences share = context.getSharedPreferences(IDENTIFY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = share.edit();
        editor.putString("word", password);
        editor.commit();
    }

    public String getLoginMember(Context context) {
        SharedPreferences share = context.getSharedPreferences(IDENTIFY, Context.MODE_PRIVATE);
        return share.getString("member", "");
    }

    public String getLoginPassword(Context context) {
        SharedPreferences share = context.getSharedPreferences(IDENTIFY, Context.MODE_PRIVATE);
        return share.getString("word", "");
    }
}
