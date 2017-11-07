package jonceski.kliment.worldcup2018.injection;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * AppModule is providing dependencies used throughout the whole app. They are live as long as the main App.java
 * instance is living.
 */

@Module
public class AppModule {
    private Application application;

    public AppModule(Application app) {
        this.application = app;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }
}
