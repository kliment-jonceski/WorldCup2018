package jonceski.kliment.worldcup2018.ui.features.list_all_news_feature.injection;

import dagger.Provides;
import jonceski.kliment.worldcup2018.ui.features.list_all_news_feature.ListAllNews;
import jonceski.kliment.worldcup2018.ui.features.list_all_news_feature.presenter
        .ListAllNewsPresenter;

/**
 * Created by kliment on 11/7/2017.
 */

public class ListAllNewsModule {
    private ListAllNews.View view;

    public ListAllNewsModule(ListAllNews.View view) {
        this.view = view;
    }

    @Provides
    @ListAllNewsScope
    public ListAllNews.View provideView() {
        return this.view;
    }

    @Provides
    @ListAllNewsScope
    public ListAllNews.Interactor provideInteractor(ListAllNews.Interactor interactor) {
        return interactor;
    }

    @Provides
    @ListAllNewsScope
    public ListAllNews.Presenter providePresenter(ListAllNews.View view, ListAllNews.Interactor interactor) {
        return new ListAllNewsPresenter(view, interactor);
    }
}
