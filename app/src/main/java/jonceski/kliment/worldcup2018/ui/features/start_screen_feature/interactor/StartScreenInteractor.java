package jonceski.kliment.worldcup2018.ui.features.start_screen_feature.interactor;

import jonceski.kliment.worldcup2018.App;
import jonceski.kliment.worldcup2018.navigation.entity.NewsModel;
import jonceski.kliment.worldcup2018.ui.features.start_screen_feature.StartScreen;

import io.reactivex.Observable;

/**
 * Interactor for StartScreen feature. Interacts with other services from the
 * application (like http).
 */

public class StartScreenInteractor implements StartScreen.Interactor {

    @Override
    public Observable<NewsModel> getNews() {
        return App.getInstance().getServices().getHttpServices().getFootbalNewsObservable();
    }
}
