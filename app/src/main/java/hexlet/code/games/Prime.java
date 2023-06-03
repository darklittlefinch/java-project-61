package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Prime {
    // method determining is number prime
    public static String isPrime(int number) {
        var dividersCount = 0;

        for (var i = 1; i <= number; i++) {
            var remainder = number % i;
            if (remainder == 0) {
                dividersCount++;
            }
        }

        if (dividersCount == 2) {
            return "yes";
        } else {
            return "no";
        }
    }

    public static void startPrime(int questionsCount) {
        var rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[] questions = new String[questionsCount];
        String[] correctAnswers = new String[questionsCount];

        Random random = new Random();
        var maxNumber = 100;

        for (var i = 0; i < questionsCount; i++) {
            var number = random.nextInt(maxNumber) + 1;

            questions[i] = Integer.toString(number);
            correctAnswers[i] = isPrime(number);
        }

        Engine.startGame(rules, questions, correctAnswers);
    }
}
