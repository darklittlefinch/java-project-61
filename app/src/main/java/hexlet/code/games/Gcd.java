package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

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

    public static void startGCD() {
        var qsCount = Engine.QUESTIONS_COUNT;
        String[][] questionsAnswers = new String[qsCount][qsCount];

        for (var i = 0; i < qsCount; i++) {

            // excepting 0 value in one of number because of inability to answer with a number
            var firstNumber = Utils.getRandomIntExceptZero(MAX_VALUE);
            var secondNumber = Utils.getRandomInt(MAX_VALUE);

            questionsAnswers[i][Engine.QUESTION_INDEX] = firstNumber + " " + secondNumber;

            var gcd = findGCD(firstNumber, secondNumber);
            questionsAnswers[i][Engine.ANSWER_INDEX] = Integer.toString(gcd);
        }

        Engine.startGame(RULES, questionsAnswers);
    }
}
