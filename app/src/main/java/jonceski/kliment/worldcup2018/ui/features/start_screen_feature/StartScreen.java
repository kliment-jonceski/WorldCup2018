package jonceski.kliment.worldcup2018.ui.features.start_screen_feature;

import io.reactivex.Observable;
import jonceski.kliment.worldcup2018.navigation.entity.NewsItem;
import jonceski.kliment.worldcup2018.navigation.entity.NewsModel;

/**
 * Main interface for the 'StartScreen' feature. All definitions for MVP components.
 */

public interface StartScreen {
    interface View {
        void updateviewForNews(NewsItem news);
    }

    interface Presenter {
        void onCreate();
    }

    interface Interactor {
        Observable<NewsModel> getNews();
    }
}

