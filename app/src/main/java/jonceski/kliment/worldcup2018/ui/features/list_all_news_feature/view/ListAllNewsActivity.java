package jonceski.kliment.worldcup2018.ui.features.list_all_news_feature.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import jonceski.kliment.worldcup2018.App;
import jonceski.kliment.worldcup2018.R;
import jonceski.kliment.worldcup2018.navigation.entity.NewsModel;
import jonceski.kliment.worldcup2018.ui.features.base_mvp.view.BaseMvpActivity;
import jonceski.kliment.worldcup2018.ui.features.list_all_news_feature.ListAllNews;
import jonceski.kliment.worldcup2018.ui.features.list_all_news_feature.injection.ListAllNewsModule;
import jonceski.kliment.worldcup2018.ui.features.list_all_news_feature.presenter
        .ListAllNewsPresenter;
import jonceski.kliment.worldcup2018.ui.features.start_screen_feature.StartScreen;

/**
 * Created by kliment on 11/7/2017.
 */

public class ListAllNewsActivity extends BaseMvpActivity implements ListAllNews.View {
    @Inject
    ListAllNewsPresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.list_all_news_activity;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getInstance().getAppComponent().plus(new ListAllNewsModule(this)).inject(this);
        presenter.onCreate();
    }

    @Override
    public void updateviewForNews(NewsModel news) {

    }
}
