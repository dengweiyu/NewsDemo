package demo.ifeimo.com.newsdemo.Interface;


import demo.ifeimo.com.newsdemo.Model.NewsItem;
import retrofit2.http.GET;

import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Wing on 2018/4/7.
 */

public interface APIService {
    /**
     * @param type
     * @param key
     * @param num
     * @param page
     * @return
     */
    @GET("{type}/")
    Observable<NewsItem> getNewsData(@Path("type") String type, @Query("key") String key, @Query("num") String num, @Query("page") int page);
}
