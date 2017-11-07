package jonceski.kliment.worldcup2018.ui.features.start_screen_feature.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import jonceski.kliment.worldcup2018.App;
import jonceski.kliment.worldcup2018.R;
import jonceski.kliment.worldcup2018.navigation.entity.NewsItem;
import jonceski.kliment.worldcup2018.ui.features.base_mvp.view.BaseMvpActivity;
import jonceski.kliment.worldcup2018.ui.features.start_screen_feature.StartScreen;
import jonceski.kliment.worldcup2018.ui.features.start_screen_feature.injection.StartScreenModule;

/**
 * The first screen that is shown after, the application is launched by the user.
 */

public class StartScreenActivity extends BaseMvpActivity implements StartScreen.View {
    @BindView(R.id.news_item)
    TextView firstNewsItem;

    @Inject
    StartScreen.Presenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.start_screen_activity;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getInstance().getAppComponent().plus(new StartScreenModule(this)).inject(this);
        presenter.onCreate();
    }

    @Override
    public void updateviewForNews(NewsItem news) {
        firstNewsItem.setText(news != null ? news.getTitle() : "");
    }

    @OnClick(R.id.news_item)
    void clickedOnFirstItem() {
        Log.d(StartScreenActivity.class.getSimpleName(), "Clikced on news link");
    }
}
