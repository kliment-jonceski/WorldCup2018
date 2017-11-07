package jonceski.kliment.worldcup2018.navigation.drawer;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import jonceski.kliment.worldcup2018.R;
import jonceski.kliment.worldcup2018.navigation.drawer.MenuFeatureModel;

/**
 * Created by kliment on 8/8/2017.
 */

public class DrawerItemCustomAdapter extends ArrayAdapter<MenuFeatureModel> {
    ArrayList<MenuFeatureModel> navigationFeatures;
    private Context mContext;
    private int layoutResourceId;

    public DrawerItemCustomAdapter(@NonNull Context context, @LayoutRes int resource,
                                   ArrayList<MenuFeatureModel> featureModels) {
        super(context, resource);
        this.mContext = context;
        this.layoutResourceId = resource;
        this.navigationFeatures = featureModels;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;

        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        listItem = inflater.inflate(layoutResourceId, parent, false);

        ImageView imageViewIcon = (ImageView) listItem.findViewById(R.id.imageViewIcon);
        TextView textViewName = (TextView) listItem.findViewById(R.id.textViewName);

        MenuFeatureModel folder = navigationFeatures.get(position);


        imageViewIcon.setImageResource(folder.getIdIcon());
        textViewName.setText(folder.getTitle());

        return listItem;
    }

    @Override
    public int getCount() {
        return navigationFeatures == null ? 0 : navigationFeatures.size();
    }

    @Nullable
    @Override
    public MenuFeatureModel getItem(int position) {
        return navigationFeatures == null ? null : navigationFeatures.get(position);
    }
}
