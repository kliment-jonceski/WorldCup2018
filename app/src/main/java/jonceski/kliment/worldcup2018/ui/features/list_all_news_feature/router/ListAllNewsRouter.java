package jonceski.kliment.worldcup2018.ui.features.list_all_news_feature.router;

/**
 * Created by kliment on 11/7/2017.
 */

public class ListAllNewsRouter {
    private static ListAllNewsRouter instance;

    private ListAllNewsRouter() {

    }

    public ListAllNewsRouter getInstance() {
        if (instance == null) {
            instance = new ListAllNewsRouter();
        }

        return instance;
    }

    public void destroyDependencies() {
        instance = null;
    }
}
