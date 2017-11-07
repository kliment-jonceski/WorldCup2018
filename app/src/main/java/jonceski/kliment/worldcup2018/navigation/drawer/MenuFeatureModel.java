package jonceski.kliment.worldcup2018.navigation.drawer;

/**
 * Created by kliment on 8/8/2017.
 */

public class MenuFeatureModel {
    private String title;
    private int idIcon;
    private String idFeature;

    public MenuFeatureModel(String title, int idIcon, String idFeature) {
        this.title = title;
        this.idIcon = idIcon;
        this.idFeature = idFeature;
    }


    public String getTitle() {
        return title;
    }

    public int getIdIcon() {
        return idIcon;
    }

    public String getIdFeature() {
        return idFeature;
    }
}
