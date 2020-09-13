package processor;

import game.PlayProcessor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class PlayProcessorTest {

    @Before
    public void setUp() {
        PlayProcessor.setSecretNumbers(new LinkedList<>(Arrays.asList(2, 7, 10)));
    }

    /**
     * Player input : 5
     * Game result : 0
     */
    @Test
    public void testProcessor_FailedResult() {
        int play = PlayProcessor.play(5);

        Assert.assertEquals(0, play);
    }

    /**
     * Player input : 4
     * Game result : 1
     */
    @Test
    public void testProcessor_OneResult() {
        int play = PlayProcessor.play(4);

        Assert.assertEquals(1, play);
    }

    /**
     * Player input : 14
     * Game result : 2
     */
    @Test
    public void testProcessor_WinResult_SecondTry() {
        int play = PlayProcessor.play(14);

        Assert.assertEquals(2, play);
    }


    /**
     * Player input : 70
     * Game result : Win (code 999)
     */
    @Test
    public void testProcessor_WinResult() {
        int play = PlayProcessor.play(70);

        Assert.assertEquals(999, play);
    }


    /**
     * Player input : 280
     * Game result : Win (code 999)
     */
    @Test
    public void testProcessor_WinResult_() {
        int play = PlayProcessor.play(280);

        Assert.assertEquals(999, play);
    }

}
