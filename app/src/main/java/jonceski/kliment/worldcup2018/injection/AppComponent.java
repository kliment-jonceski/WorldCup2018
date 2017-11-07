package jonceski.kliment.worldcup2018.injection;

import javax.inject.Singleton;

import dagger.Component;
import jonceski.kliment.worldcup2018.ui.features.list_all_news_feature.injection
        .ListAllNewsComponent;
import jonceski.kliment.worldcup2018.ui.features.list_all_news_feature.injection.ListAllNewsModule;
import jonceski.kliment.worldcup2018.ui.features.start_screen_feature.injection
        .StartScreenComponent;
import jonceski.kliment.worldcup2018.ui.features.start_screen_feature.injection.StartScreenModule;

/**
 * Dagger-Component for application scope dependencies.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    StartScreenComponent plus(StartScreenModule startScreenModule);

    ListAllNewsComponent plus(ListAllNewsModule listAllNewsModule);
}
