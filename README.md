#Short description

This project is a short code Maven project write in Java 8, for a game called "Secret numbers"

#Game rules

- The game generates 3 secret numbers between 1 and 10.
- The goal of the player is to enter a number that is a multiple of the 3 secret numbers generated.
- Each time the player inputs a number the game shows the player a result between 0 and 3.
- The result is determined by the amount of secret numbers that are a factor of the submitted number.
- The game ends when the player finds a multiple of all 3 secret numbers.

#How to run the app

The app can be run by launching the main() method in MainRunner.java

The game is playable by using the console prompt

#Example

**Game choose secretly 2,7,10**

Player input : 5
Game answer : 0

Player input : 4
Game answer : 1
        (Because 2*2 = 4, so there is a multiple of one of the secret numbers)

Player input : 14
Game answer : 2
        (Because 7*2 = 14, so you got a multiple of two of the secret numbers)

Player input : 70
Game answer : Win
        (2*35 = 70, 7*10 = 70, the three secret numbers are a factor of 70, it’s a win!)

Player input : 280
Game answer : Win
        (2*7*10*2 = 280, the three secret numbers are a factor of 280, it’s a win!)

#Debug

You can uncomment the line in the main() method in MainRunner.java to see which secrets numbers are generated.

This should be refactored, and replaced by a Json file who contains a boolean value for enabling or disabling debug mode.

#JUNIT testing

JUNIT4 tests can be found under the directory src/test/java/

