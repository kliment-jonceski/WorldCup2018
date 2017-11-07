package jonceski.kliment.worldcup2018.navigation.drawer;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import jonceski.kliment.worldcup2018.App;
import jonceski.kliment.worldcup2018.R;

/**
 * Handles creating the Navigation Drawer, populating with items, etc.
 */

public class NavigationDrawerDelegate {
    private AppCompatActivity mActivity;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    Toolbar toolbar;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    private DrawerItemCustomAdapter drawerItemCustomAdapter;

    public NavigationDrawerDelegate(AppCompatActivity mActivity) {
        this.mActivity = mActivity;
    }

    public void init() {
        //mTitle = mDrawerTitle = getTitle();
        ArrayList<MenuFeatureModel> list = new ArrayList<>();
        list.add(new MenuFeatureModel("home", R.drawable.ic_home_black_48dp, "FEATURE_HOME"));
        list.add(new MenuFeatureModel("stadiums", R.drawable.ic_vignette_black_48dp, "FEATURE_HOME"));
        list.add(new MenuFeatureModel("teams", R.drawable.ic_title_black_48dp, "FEATURE_HOME"));
        list.add(new MenuFeatureModel("test feature", R.drawable.home_logo, "FEATURE_TEST"));


        mDrawerLayout = (DrawerLayout) mActivity.findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) mActivity.findViewById(R.id.left_drawer);

        setupToolbar();

        mActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        mActivity.getSupportActionBar().setHomeButtonEnabled(true);

        drawerItemCustomAdapter = new DrawerItemCustomAdapter(mActivity, R.layout.navigation_drawer_list_item, list);
        mDrawerList.setAdapter(drawerItemCustomAdapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout) mActivity.findViewById(R.id.drawer_layout);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        setupDrawerToggle();
    }

    void setupToolbar(){
        toolbar = (Toolbar) mActivity.findViewById(R.id.toolbar);
        mActivity.setSupportActionBar(toolbar);
        mActivity.getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    void setupDrawerToggle(){
        mDrawerToggle = new ActionBarDrawerToggle(
                mActivity,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                toolbar,  /* nav drawer image to replace 'Up' caret */
                R.string.app_name,  /* "open drawer" description for accessibility */
                R.string.app_name  /* "close drawer" description for accessibility */
        ) {
            public void onDrawerClosed(View view) {
                mActivity.getSupportActionBar().setTitle("close");
                mActivity.invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                mActivity.getSupportActionBar().setTitle("open");
                mActivity.invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        //mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    /** Swaps fragments in the main content view */
    private void selectItem(int position) {
        // Highlight the selected item, update the title, and close the drawer
        mDrawerList.setItemChecked(position, true);
        mActivity.setTitle(drawerItemCustomAdapter.getItem(position).getTitle());
        mDrawerLayout.closeDrawer(mDrawerList);
        App.getInstance().getNavigationManager().startFeature(drawerItemCustomAdapter.getItem
                (position).getIdFeature());
    }
}
