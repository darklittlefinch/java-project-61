package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Prime {
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
        var rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        String[][] questionsAnswers = new String[questionsCount][questionsCount];
        var questionIndex = 0;
        var answerIndex = 1;

        Random random = new Random();
        final var maxNumber = 100;

        for (var i = 0; i < questionsCount; i++) {
            var number = random.nextInt(maxNumber) + 1;

            questionsAnswers[i][questionIndex] = Integer.toString(number);
            questionsAnswers[i][answerIndex] = getAnswerPrime(number);
        }

        Engine.startGame(rules, questionsAnswers);
    }
}
