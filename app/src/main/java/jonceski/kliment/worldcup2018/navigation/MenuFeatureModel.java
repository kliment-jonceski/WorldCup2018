package jonceski.kliment.worldcup2018.navigation;

/**
 * Created by kliment on 8/8/2017.
 */

public class MenuFeatureModel {
    private String title;
    private int idIcon;

    public MenuFeatureModel(String title, int idIcon) {
        this.title = title;
        this.idIcon = idIcon;
    }

    public String getTitle() {
        return title;
    }

    public int getIdIcon() {
        return idIcon;
    }
}
