package runner;

import game.PlayProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainRunner {

    public static void main(String[] args) throws IOException {
        int inputNumber = readInputStream();

        // Let's play !
        int playResult = PlayProcessor.play(inputNumber);

        while (playResult != 999) {
            System.out.println(playResult);

            // not all secret numbers are found
            // play again
            inputNumber = readInputStream();

            playResult = PlayProcessor.playAgain(inputNumber);
        }

        // WIN !!
        System.out.println("Win");
    }

    /**
     * An utility method used to read the input stream from the console output
     *
     * @return the user input, should be an Integer
     */
    private static int readInputStream() throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        try {
            return Integer.parseInt(name);
        } catch (NumberFormatException ex) {
            //do not throw an exception
            // retry the readInputStream() for another input
            System.out.println("Merci de saisir un nombre valide");

            readInputStream();
        }
        return -1;
    }

}
