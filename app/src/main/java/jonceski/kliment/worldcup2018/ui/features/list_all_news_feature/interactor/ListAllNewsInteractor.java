package jonceski.kliment.worldcup2018.ui.features.list_all_news_feature.interactor;

import io.reactivex.Observable;
import jonceski.kliment.worldcup2018.App;
import jonceski.kliment.worldcup2018.navigation.entity.NewsModel;
import jonceski.kliment.worldcup2018.ui.features.list_all_news_feature.ListAllNews;

/**
 * Created by kliment on 11/7/2017.
 */

public class ListAllNewsInteractor implements ListAllNews.Interactor {
    @Override
    public Observable<NewsModel> getNews() {
        return App.getInstance().getServices().getHttpServices().getFootbalNewsObservable();
    }
}
