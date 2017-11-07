package jonceski.kliment.worldcup2018.hierarchy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import jonceski.kliment.worldcup2018.App;

/**
 * Activity that sets the current activity in App accordingly.
 */

public abstract class SetCurrentStateActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getInstance().setCurrentActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        App.getInstance().setCurrentActivity(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        App.getInstance().setCurrentActivity(null);
    }
}
