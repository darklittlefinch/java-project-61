package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Prime {
    // метод, определяющий, является ли число простым
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

    public static void startPrime() {
        var rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        var questionsCount = 3;
        String[] questions = new String[questionsCount];
        String[] correctAnswers = new String[questionsCount];

        Random random = new Random();

        for (var i = 0; i < questionsCount; i++) {
            var number = random.nextInt(100) + 1;

            questions[i] = Integer.toString(number);
            correctAnswers[i] = isPrime(number);
        }

        Engine.startGame(rules, questions, correctAnswers);
    }
}
