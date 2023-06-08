package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

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

    public static void startPrime(int questionsCount) {
        String[][] questionsAnswers = new String[questionsCount][questionsCount];

        Random random = new Random();

        for (var i = 0; i < questionsCount; i++) {
            var number = random.nextInt(MAX_VALUE) + 1;

            questionsAnswers[i][Engine.QUESTION_INDEX] = Integer.toString(number);
            questionsAnswers[i][Engine.ANSWER_INDEX] = getAnswerPrime(number);
        }

        Engine.startGame(RULES, questionsAnswers);
    }
}
