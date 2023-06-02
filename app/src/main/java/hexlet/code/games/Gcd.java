package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Gcd {
    public static int findGCD(int firstNumber, int secondNumber) {
        var gcd = 1;

        for (var i = 1; i <= firstNumber && i <= secondNumber; i++) {
            if (firstNumber % i == 0 && secondNumber % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }

    public static void startGCD() {
        var rules = "Find the greatest common divisor of given numbers.";

        var questionsCount = 3;
        String[] questions = new String[questionsCount];
        String[] correctAnswers = new String[questionsCount];

        Random random = new Random();

        for (var i = 0; i < questionsCount; i++) {
            var firstNumber = random.nextInt(50);
            var secondNumber = random.nextInt(50);

            questions[i] = firstNumber + " " + secondNumber;

            var gcd = findGCD(firstNumber, secondNumber);
            correctAnswers[i] = Integer.toString(gcd);
        }

        Engine.startGame(rules, questions, correctAnswers);
    }
}
