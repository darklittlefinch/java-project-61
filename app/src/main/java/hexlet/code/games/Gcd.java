package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Gcd {
    static final String RULES = "Find the greatest common divisor of given numbers.";
    static final int MAX_VALUE = 50;

    // method finding GCD of two numbers
    public static int findGCD(int firstNumber, int secondNumber) {
        var minValue = Math.min(firstNumber, secondNumber);
        var maxValue = Math.max(firstNumber, secondNumber);

        if (minValue == 0) {
            return maxValue;
        }

        for (var i = minValue; i > 1; i--) {
            if (firstNumber % i == 0 && secondNumber % i == 0) {
                return i;
            }
        }

        return 1;
    }

    public static void startGCD(int questionsCount) {
        String[][] questionsAnswers = new String[questionsCount][questionsCount];

        Random random = new Random();

        for (var i = 0; i < questionsCount; i++) {

            // excepting 0 value in one of number because of inability to answer with a number
            var firstNumber = random.nextInt(MAX_VALUE) + 1;
            var secondNumber = random.nextInt(MAX_VALUE);

            questionsAnswers[i][Engine.QUESTION_INDEX] = firstNumber + " " + secondNumber;

            var gcd = findGCD(firstNumber, secondNumber);
            questionsAnswers[i][Engine.ANSWER_INDEX] = Integer.toString(gcd);
        }

        Engine.startGame(RULES, questionsAnswers);
    }
}
