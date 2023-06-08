package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Gcd {
    static final String RULES = "Find the greatest common divisor of given numbers.";
    static final int MAX_VALUE = 50;

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
        String[][] questionsAnswers = new String[questionsCount][questionsCount];

        Random random = new Random();

        for (var i = 0; i < questionsCount; i++) {
            var firstNumber = random.nextInt(MAX_VALUE);
            var secondNumber = random.nextInt(MAX_VALUE);

            questionsAnswers[i][Engine.QUESTION_INDEX] = firstNumber + " " + secondNumber;

            var gcd = findGCD(firstNumber, secondNumber);
            questionsAnswers[i][Engine.ANSWER_INDEX] = Integer.toString(gcd);
        }

        Engine.startGame(RULES, questionsAnswers);
    }
}
