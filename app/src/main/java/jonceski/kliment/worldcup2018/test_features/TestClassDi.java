package jonceski.kliment.worldcup2018.test_features;

import javax.inject.Inject;

/**
 * Created by kliment on 10/18/2017.
 */

public class TestClassDi {
    private TestService testService;

    @Inject
    public TestClassDi(TestService testService) {
        this.testService = testService;
    }

    public TestService getTestService() {
        return testService;
    }
}
