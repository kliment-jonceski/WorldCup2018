package jonceski.kliment.worldcup2018.navigation;

import android.content.Intent;
import android.os.Bundle;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import jonceski.kliment.worldcup2018.App;
import jonceski.kliment.worldcup2018.ui.features.start_screen_feature.view.StartScreenActivity;
import jonceski.kliment.worldcup2018.ui.features.testing_feature.TestActivity;

/**
 * Enumeration class which holds all features used in the application.
 */

public enum MenuFeaturesEnum {
    FEATURE_HOME(StartScreenActivity.class, null),
    FEATURE_TEST(TestActivity.class, null);

    private static final Map<String, MenuFeaturesEnum> FEATURES_MAP;

    static {
        HashMap<String, MenuFeaturesEnum> map = new HashMap<>();

        for (MenuFeaturesEnum sideMenuItemEnum : MenuFeaturesEnum.values()) {
            map.put(sideMenuItemEnum.name(), sideMenuItemEnum);
        }

        FEATURES_MAP = Collections.unmodifiableMap(map);
    }

    private Intent intent;

    /**
     * Builds intent from the class that holds the feature.
     * @param tClass The component class that is to be used for the intent.
     * @param extraData extra data bundled in the intent for starting the feature.
     */
    MenuFeaturesEnum(Class<?> tClass, Bundle extraData) {
        if (tClass == null) {
            return;
        }

        this.intent = new Intent(App.getInstance(), tClass);
        if (extraData != null) {
            this.intent.putExtras(extraData);
        }
    }

    MenuFeaturesEnum(Intent intent) {
        this.intent = intent;
    }

    public Intent getIntent() {
        return intent;
    }

    public static MenuFeaturesEnum getMenuFeatureForId(String idFeature) {
        if (FEATURES_MAP.containsKey(idFeature)) {
            return FEATURES_MAP.get(idFeature);
        }

        //if the feature is not found return feature for starting screen.
        return FEATURE_HOME;
    }
}
