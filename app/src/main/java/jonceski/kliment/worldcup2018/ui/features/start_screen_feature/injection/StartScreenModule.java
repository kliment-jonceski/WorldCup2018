package jonceski.kliment.worldcup2018.ui.features.start_screen_feature.injection;

import dagger.Module;
import dagger.Provides;
import jonceski.kliment.worldcup2018.ui.features.start_screen_feature.StartScreen;
import jonceski.kliment.worldcup2018.ui.features.start_screen_feature.interactor
        .StartScreenInteractor;
import jonceski.kliment.worldcup2018.ui.features.start_screen_feature.presenter
        .StartScreenPresenter;

/**
 * Module for providing dependencies in the StartScreen feature.
 */
@Module
public class StartScreenModule {
    private StartScreen.View view;

    public StartScreenModule(StartScreen.View view) {
        this.view = view;
    }

    @Provides
    @StartScreenScope
    public StartScreen.View provideView() {
        return view;
    }

    @Provides
    @StartScreenScope
    public StartScreen.Interactor provideInteractor() {
        return new StartScreenInteractor();
    }

    @Provides
    @StartScreenScope
    StartScreen.Presenter providePresenter(StartScreen.View view, StartScreen.Interactor interactor) {
        return new StartScreenPresenter(view, interactor);
    }
}
