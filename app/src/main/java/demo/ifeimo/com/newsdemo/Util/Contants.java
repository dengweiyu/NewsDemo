package demo.ifeimo.com.newsdemo.Util;

/**
 * Created by Wing on 2018/3/21.
 */

public class Contants {
    private static final String APIKEY = "bd2c27a7ea21ee18fcef4d3bc71bc221";

    public static String SERVER_ADDRESS = "http://api.tianapi.com/";

//    + type + "/?key=" + APIKEY + "&num=" + num;

    public static String getNewsUrl() {
        return SERVER_ADDRESS;
    }

    public static String getApikey() {
        return APIKEY;
    }

}
