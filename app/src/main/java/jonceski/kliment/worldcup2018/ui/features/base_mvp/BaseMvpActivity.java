package jonceski.kliment.worldcup2018.ui.features.base_mvp;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import jonceski.kliment.worldcup2018.navigation.NavigationDrawerDelegate;
import jonceski.kliment.worldcup2018.ui.features.start_screen_feature.view.StartScreenActivity;

/**
 * Created by kliment on 8/7/2017.
 */

public abstract class BaseMvpActivity extends AppCompatActivity {
    protected abstract int getLayoutId();
    private NavigationDrawerDelegate navigationDrawerDelegate;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        navigationDrawerDelegate = new NavigationDrawerDelegate(this);
        navigationDrawerDelegate.init();
    }

    @Override
    public void setTitle(CharSequence title) {
        if (this instanceof StartScreenActivity) {
            getSupportActionBar().setTitle("");
        } else {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        /*
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}
