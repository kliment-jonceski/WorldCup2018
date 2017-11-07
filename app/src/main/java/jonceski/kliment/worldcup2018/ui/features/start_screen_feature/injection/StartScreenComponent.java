package jonceski.kliment.worldcup2018.ui.features.start_screen_feature.injection;

import dagger.Subcomponent;
import jonceski.kliment.worldcup2018.ui.features.start_screen_feature.view.StartScreenActivity;

/**
 * Dagger component.
 */
@StartScreenScope
@Subcomponent(modules = StartScreenModule.class)
public interface StartScreenComponent {
    void inject(StartScreenActivity activity);
}
