package jonceski.kliment.worldcup2018.ui.features.list_all_news_feature;

import io.reactivex.Observable;
import jonceski.kliment.worldcup2018.navigation.entity.NewsModel;

/**
 * Created by kliment on 10/24/2017.
 */

public interface ListAllNews {
    interface View {
        void updateviewForNews(NewsModel news);
    }

    interface Presenter {
        void onCreate();
    }

    interface Interactor {
        Observable<NewsModel> getNews();
    }
}
