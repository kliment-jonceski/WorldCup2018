package jonceski.kliment.worldcup2018.test_features.injection;

import dagger.Module;
import dagger.Provides;
import jonceski.kliment.worldcup2018.test_features.TestClassDi;
import jonceski.kliment.worldcup2018.test_features.TestService;

/**
 * Created by kliment on 10/18/2017.
 */

@Module
public class TestAllDiModule {

    @Provides
    TestService providesTestService() {
        return new TestService();
    }

    @Provides
    TestClassDi providesTestClassDi(TestService testService) {
        return new TestClassDi(testService);
    }
}
