package jonceski.kliment.worldcup2018.ui.features.list_all_news_feature.injection;

import dagger.Subcomponent;
import jonceski.kliment.worldcup2018.ui.features.list_all_news_feature.view.ListAllNewsActivity;

/**
 * Created by kliment on 11/7/2017.
 */

@ListAllNewsScope
@Subcomponent(modules = ListAllNewsModule.class)
public interface ListAllNewsComponent {
    void inject(ListAllNewsActivity activity);
}
