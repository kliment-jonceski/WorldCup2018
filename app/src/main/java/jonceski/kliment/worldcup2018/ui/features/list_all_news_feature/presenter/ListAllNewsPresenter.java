package jonceski.kliment.worldcup2018.ui.features.list_all_news_feature.presenter;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import jonceski.kliment.worldcup2018.navigation.entity.NewsModel;
import jonceski.kliment.worldcup2018.ui.features.base_mvp.presenter.PresenterTemplate;
import jonceski.kliment.worldcup2018.ui.features.list_all_news_feature.ListAllNews;

/**
 * Created by kliment on 11/7/2017.
 */

public class ListAllNewsPresenter extends PresenterTemplate<ListAllNews.View, ListAllNews
        .Interactor> implements ListAllNews.Presenter {
    private static final String LOG_TAG = ListAllNewsPresenter.class.getSimpleName();

    public ListAllNewsPresenter(ListAllNews.View view, ListAllNews.Interactor interactor) {
        super(view, interactor);
    }

    public void onCreate() {
        interactor.getNews().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsModel value) {
                        view.updateviewForNews(value);
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