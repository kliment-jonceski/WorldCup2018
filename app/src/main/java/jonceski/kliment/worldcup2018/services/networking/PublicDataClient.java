package jonceski.kliment.worldcup2018.services.networking;

import io.reactivex.Observable;
import jonceski.kliment.worldcup2018.navigation.entity.NewsModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kliment on 8/8/2017.
 */

public interface PublicDataClient {
    @GET("worldcup/news/rss.xml")
    Call<ResponseBody> reposForUser();

    @GET("worldcup/news/rss.xml")
    Call<NewsModel> getFootballNews();

    @GET("worldcup/news/rss.xml")
    Observable<NewsModel> getFootballNewsRx();
}
