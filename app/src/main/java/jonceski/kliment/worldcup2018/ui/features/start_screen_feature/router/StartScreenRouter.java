package jonceski.kliment.worldcup2018.ui.features.start_screen_feature.router;

/**
 * Class that handles all the navigation part from the 'StartScreen' feature to the others
 * features and vise versa.
 */

public final class StartScreenRouter {
    private static StartScreenRouter instance;

    private StartScreenRouter() {
    }

    public static StartScreenRouter getInstance() {
        if (instance == null) {
            instance = new StartScreenRouter();
        }

        return instance;
    }
}
