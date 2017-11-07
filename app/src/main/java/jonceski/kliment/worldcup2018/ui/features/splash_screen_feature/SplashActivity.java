package jonceski.kliment.worldcup2018.ui.features.splash_screen_feature;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import code.generator.TestGenerator;
import jonceski.kliment.worldcup2018.App;
import jonceski.kliment.worldcup2018.R;
import jonceski.kliment.worldcup2018.hierarchy.SetCurrentStateActivity;
import jonceski.kliment.worldcup2018.navigation.MenuFeaturesEnum;

public class SplashActivity extends SetCurrentStateActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new TestGenerator().generateTest();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                App.getInstance().getNavigationManager().startFeature(MenuFeaturesEnum.FEATURE_HOME.name());
            }
        }, 1000);


    }
}
