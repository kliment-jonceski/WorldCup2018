package jonceski.kliment.worldcup2018;

import org.junit.Test;

import code.generator.TestGenerator;
import jonceski.kliment.worldcup2018.test_features.TestAllDi;
import jonceski.kliment.worldcup2018.test_features.TestClassDi;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    public void testName() throws Exception {

    }

    @Test
    public void testDependenci() {
        //TestClassDi testClassDi = new TestClassDi();
        TestAllDi testAllDi = new TestAllDi();

        //assertNotNull(testClassDi.getTestService());
        //assertNotNull(testAllDi.getTestClassDi());
        assertNotNull(testAllDi);
    }

    @Test
    public void testCodeGenerator() {
        new TestGenerator().generateTest();
        assertNotNull(1+2);
    }
}