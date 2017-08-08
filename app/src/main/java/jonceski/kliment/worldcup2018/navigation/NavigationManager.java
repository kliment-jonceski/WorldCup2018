package jonceski.kliment.worldcup2018.navigation;

import android.content.Intent;

import jonceski.kliment.worldcup2018.App;

/**
 * This class is responsable for the navigation through the features in the application.
 * Here the navigation features should be initialized.
 * All features should start other features via this Navigation Manager.
 */

public class NavigationManager {

    public void startActivity() {

    }

    public void startFeature(String idFeature) {
        Intent intent = MenuFeaturesEnum.getMenuFeatureForId(idFeature).getIntent();
        App.getInstance().startActivity(intent);
    }
}
