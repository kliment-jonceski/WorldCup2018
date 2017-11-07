package jonceski.kliment.worldcup2018.ui.features.start_screen_feature.presenter;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import jonceski.kliment.worldcup2018.navigation.entity.NewsItem;
import jonceski.kliment.worldcup2018.navigation.entity.NewsModel;
import jonceski.kliment.worldcup2018.ui.features.base_mvp.presenter.PresenterTemplate;
import jonceski.kliment.worldcup2018.ui.features.start_screen_feature.StartScreen;

/**
 * Created by kliment on 8/9/2017.
 */

public class StartScreenPresenter extends PresenterTemplate<StartScreen.View, StartScreen.Interactor> implements StartScreen.Presenter {
    private static final String LOG_TAG = StartScreenPresenter.class.getSimpleName();

    /**The StartScreenPresenter object is created by dagger and the view and interactor
     * dependencies are injected via it's constructor.
     */
    @Inject
    public StartScreenPresenter(StartScreen.View view, StartScreen.Interactor interactor) {
        super(view, interactor);
    }

    @Override
    public void onCreate() {
        interactor.getNews().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsModel value) {
                        view.updateviewForNews(value.getChannel().getNewsItem().get(0));
                    }

                    @Override
                    public void onError(Throwable e) {
                        //TODO error handling;
                    }

                    @Override
                    public void onComplete() {
                        Log.d(LOG_TAG, "Complete get News.");
                    }
                });
    }
}
