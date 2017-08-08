package jonceski.kliment.worldcup2018;

import android.app.Activity;
import android.app.Application;

import jonceski.kliment.worldcup2018.navigation.NavigationManager;

/**
 * Application class of the app.
 */

public class App extends Application {
    private static App instance;
    private NavigationManager navigationManager;
    private Activity currentActivity;

    @Override
    public void onCreate() {
        super.onCreate();
        navigationManager = new NavigationManager();
    }

    public App() {
        instance = this;
    }

    public static App getInstance() {
        return instance;
    }

    public NavigationManager getNavigationManager() {
        return navigationManager;
    }
}
