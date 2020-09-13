package runner;

import game.PlayProcessor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class MainRunnerTest {

    @Before
    public void setUp() {
        PlayProcessor.setSecretNumbers(new LinkedList<>(Arrays.asList(2, 7, 10)));
    }

    /**
     * Just a test to check if the runner is executed correctly
     * <p>
     * No validation test for the results here
     */
    @Test
    public void testRunner() throws FileNotFoundException {
        boolean hasError = false;

        String resourceName = "input/MainRunnerTest";

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(resourceName).getFile());

        final FileInputStream fips = new FileInputStream(file.getAbsolutePath());

        System.setIn(fips);

        try {
            MainRunner.main(null);
        } catch (IOException e) {
            hasError = true;
        }

        Assert.assertFalse(hasError);
    }
}
