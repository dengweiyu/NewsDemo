package demo.ifeimo.com.newsdemo.Model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wing on 2018/4/7.
 */

public class TypeUrl {
    public static List<String> list;

    public static String getTypeUrl(int type) {
        switch (type) {
            case 0:
                return "social";
            case 1:
                return "guonei";
            case 2:
                return "world";
            case 3:
                return "huabian";
            case 4:
                return "tiyu";
            case 5:
                return "keji";
            case 6:
                return "health";
            case 7:
                return "military";
            case 8:
                return "meinv";
            default:
                return "social";
        }
    }

    public static List<String> getCount() {
        list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(getTypeUrl(i));
        }

        return list;
    }
}
