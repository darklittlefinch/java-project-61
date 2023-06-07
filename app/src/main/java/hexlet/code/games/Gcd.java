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

        String[][] questionsAnswers = new String[questionsCount][questionsCount];
        var questionIndex = 0;
        var answerIndex = 1;

        Random random = new Random();
        final var maxNumber = 50;

        for (var i = 0; i < questionsCount; i++) {
            var firstNumber = random.nextInt(maxNumber);
            var secondNumber = random.nextInt(maxNumber);

            questionsAnswers[i][questionIndex] = firstNumber + " " + secondNumber;

            var gcd = findGCD(firstNumber, secondNumber);
            questionsAnswers[i][answerIndex] = Integer.toString(gcd);
        }

        Engine.startGame(rules, questionsAnswers);
    }
}
