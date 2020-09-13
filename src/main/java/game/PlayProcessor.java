package game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Play processor class
 * Secret numbers and user case are here
 */
public class PlayProcessor {

    // Code used to detect the winning case on the play processor
    public static final int WINNING_CODE = 999;

    // List of all static secret numbers, generated at the instantiation
    private static List<Integer> secretNumbers;

    static {
        /* Secret numbers are 3, between 1 (inclusive bound) and 11 (exclusive bound) */
        secretNumbers = new Random().ints(3, 1, 11)
                .boxed().collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * The main method of the play processor
     *
     * @return an int result
     * 999 : mean the user has win the game
     * other int : the amount of secret numbers that are factor of the submitter number
     */
    public static int play(Integer submittedNumber) {
        // TODO to remove : only for debug
        System.out.println(secretNumbers);

        long multipleFromNumbers = getMultipleFromNumbers(submittedNumber);

        if (multipleFromNumbers == secretNumbers.size()) {
            return WINNING_CODE; // just a constant number used to detect the winning case
        } else {
            return Math.toIntExact(multipleFromNumbers); // however, return the number of multiples found from secret numbers
        }
    }


    /**
     * Just play again
     *
     * @param submittedNumber the input number
     * @return the result
     */
    public static int playAgain(Integer submittedNumber) {
        return play(submittedNumber);
    }

    /**
     * Return amount of secret numbers that are a factor of the submitted number
     *
     * @param submittedNumber the input number
     * @return amount of secret numbers
     */
    private static long getMultipleFromNumbers(Integer submittedNumber) {
        List<Integer> allFactorsOfInteger = getAllFactorsOfInteger(submittedNumber);

        return secretNumbers.stream().filter(allFactorsOfInteger::contains).count();
    }

    /**
     * Return all factors of an integer
     *
     * @param integer the integer
     * @return an arrayList, can be empty, of all factors
     */
    private static List<Integer> getAllFactorsOfInteger(Integer integer) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i <= integer; ++i) {
            if (integer % i == 0) {
                factors.add(i);
            }
        }

        return factors;
    }

    /**
     * Setter for secretNumbers
     *
     * @param secretNumbers secretNumbers
     */
    public static void setSecretNumbers(List<Integer> secretNumbers) {
        PlayProcessor.secretNumbers = secretNumbers;
    }
}
