package jonceski.kliment.worldcup2018.navigation;

import android.app.Activity;
import android.content.Context;
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
        Activity currentActivity = App.getInstance().getCurrentActivity();
        Intent featureIntent = MenuFeaturesEnum.getMenuFeatureForId(idFeature).getIntent();
        currentActivity.startActivity(featureIntent);
    }

    /**
     * Returns the destination activity extracted from the intent.
     *
     * @param intent the intent from which the destination Class is extracted.
     * @return class of the destination activity.
     */
    @SuppressWarnings("unchecked")
    public Class<? extends Activity> getDestinationActivityClass(Intent intent) throws Exception {
        return (Class<? extends Activity>) Class.forName(intent.getComponent().getClassName());
    }
}
