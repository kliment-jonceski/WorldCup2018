package jonceski.kliment.worldcup2018.services.networking;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import jonceski.kliment.worldcup2018.navigation.entity.NewsModel;

/**
 * Service class that provides http services to the application components. This class should return
 * observables to the application components and process the requests asynchronously.
 */

public class HttpServices {
    /**The main host for the news request.*/
    public static final String FIFA_NEWS_ENDPOINT = "http://www.fifa.com/";
    private PublicDataClient fifaApiClient;
    private Map<String, ? super Object> cache;

    public HttpServices() {
        fifaApiClient = ClientBuilder.getPublicDataClient(FIFA_NEWS_ENDPOINT);
        cache = new HashMap<>();
    }

    public Observable<NewsModel> getFootbalNewsObservable() {
        if (cache.containsKey(UrlEndpointsEnum.NEWS_ENDPOINT.getEndpointUrl())) {
            return (Observable<NewsModel>) cache.get(UrlEndpointsEnum.NEWS_ENDPOINT.getEndpointUrl());
        } else {
            Observable<NewsModel> response = fifaApiClient.getFootballNewsRx();
            cache.put(UrlEndpointsEnum.NEWS_ENDPOINT.getEndpointUrl(), response);
            return response;
        }
    }
}
