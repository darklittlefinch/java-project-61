package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    static final int MAX_VALUE = 100;

    // method determining is number prime
    public static boolean isPrime(int number) {
        var dividersCount = 0;

        for (var i = 1; i <= number; i++) {
            var remainder = number % i;
            if (remainder == 0) {
                dividersCount++;
            }
        }

        return dividersCount == 2;
    }

    public static String getAnswerPrime(int number) {
        if (isPrime(number)) {
            return "yes";
        } else {
            return "no";
        }
    }

    public static void startPrime() {
        var qsCount = Engine.QUESTIONS_COUNT;
        String[][] questionsAnswers = new String[qsCount][qsCount];

        for (var i = 0; i < qsCount; i++) {
            var number = Utils.getRandomIntExceptZero(MAX_VALUE);

            questionsAnswers[i][Engine.QUESTION_INDEX] = Integer.toString(number);
            questionsAnswers[i][Engine.ANSWER_INDEX] = getAnswerPrime(number);
        }

        Engine.startGame(RULES, questionsAnswers);
    }
}
