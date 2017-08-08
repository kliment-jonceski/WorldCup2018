package jonceski.kliment.worldcup2018.ui.features.splash_screen_feature;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import jonceski.kliment.worldcup2018.App;
import jonceski.kliment.worldcup2018.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                App.getInstance().getNavigationManager().startFeature("FEATURE_HOME");
            }
        }, 1000);
    }
}
