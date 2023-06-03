package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Gcd {
    // method finding GCD of two numbers
    public static int findGCD(int firstNumber, int secondNumber) {
        var gcd = 1;

        for (var i = 1; i <= firstNumber && i <= secondNumber; i++) {
            if (firstNumber % i == 0 && secondNumber % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }

    public static void startGCD(int questionsCount) {
        var rules = "Find the greatest common divisor of given numbers.";
        String[] questions = new String[questionsCount];
        String[] correctAnswers = new String[questionsCount];

        Random random = new Random();
        final var maxNumber = 50;

        for (var i = 0; i < questionsCount; i++) {
            var firstNumber = random.nextInt(maxNumber);
            var secondNumber = random.nextInt(maxNumber);

            questions[i] = firstNumber + " " + secondNumber;

            var gcd = findGCD(firstNumber, secondNumber);
            correctAnswers[i] = Integer.toString(gcd);
        }

        Engine.startGame(rules, questions, correctAnswers);
    }
}
