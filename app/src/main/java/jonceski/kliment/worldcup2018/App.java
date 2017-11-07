package jonceski.kliment.worldcup2018;

import android.app.Activity;
import android.app.Application;

import jonceski.kliment.worldcup2018.hierarchy.SetCurrentStateActivity;
import jonceski.kliment.worldcup2018.injection.AppComponent;
import jonceski.kliment.worldcup2018.injection.AppModule;
import jonceski.kliment.worldcup2018.injection.DaggerAppComponent;
import jonceski.kliment.worldcup2018.navigation.NavigationManager;
import jonceski.kliment.worldcup2018.services.Services;

/**
 * Application class of the app.
 */

public class App extends Application {
    private static App instance;
    private NavigationManager navigationManager;
    private Activity currentActivity;
    // Dagger component
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        navigationManager = new NavigationManager();
    }

    public App() {
        instance = this;

        // setup dependency injection
        appComponent = createAppComponent();
    }

    private AppComponent createAppComponent() {
        return DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    /**
     * Get the application-component for injecting dependencies.
     *
     * @return the applicationComponent.
     */
    public AppComponent getAppComponent() {
        return appComponent;
    }

    public static App getInstance() {
        return instance;
    }

    public Activity getCurrentActivity() {
        return currentActivity;
    }

    public void setCurrentActivity(Activity currentActivity) {
        this.currentActivity = currentActivity;
    }

    public NavigationManager getNavigationManager() {
        return navigationManager;
    }

    public Services getServices() {
        return Services.getInstance();
    }
}
