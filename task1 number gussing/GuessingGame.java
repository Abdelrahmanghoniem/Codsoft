import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int maxAttempts = 10;
        int totalRounds = 0;
        int totalScore = 0;
        String playAgain;

        try (Scanner scanner = new Scanner(System.in)) {
            do {
                int numberToGuess = random.nextInt(100) + 1;
                int attempts = 0;
                boolean guessedCorrectly = false;

                System.out.println("Round " + (totalRounds + 1) + ": Guess the number between 1 and 100");

                while (attempts < maxAttempts && !guessedCorrectly) {
                    System.out.print("Enter your guess: ");
                    int userGuess = scanner.nextInt();
                    attempts++;

                    if (userGuess == numberToGuess) {
                        guessedCorrectly = true;
                        System.out.println("Congratulations! You guessed the correct number.");
                        totalScore += (maxAttempts - attempts + 1); // More points for fewer attempts
                    } else if (userGuess > numberToGuess) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.println("Too low! Try again.");
                    }
                }

                if (!guessedCorrectly) {
                    System.out.println("Sorry! You've used all your attempts. The correct number was " + numberToGuess);
                }

                totalRounds++;
                System.out.println("Your score: " + totalScore);
                System.out.print("Do you want to play another round? (yes/no): ");
                playAgain = scanner.next();

            } while (playAgain.equalsIgnoreCase("yes"));

            System.out.println("Game over! You played " + totalRounds + " round(s) with a total score of " + totalScore);
        } // Scanner is automatically closed here.
    }
}
