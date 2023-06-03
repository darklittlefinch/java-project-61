package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Even {
    // method determining is number even
    public static String isEven(int number) {
        var remainder = number % 2;
        if (remainder == 0) {
            return "yes";
        }
        return "no";
    }

    public static void startEven(int questionsCount) {
        var rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[] questions = new String[questionsCount];
        String[] correctAnswers = new String[questionsCount];

        Random random = new Random();
        final var maxNumber = 100;

        for (var i = 0; i < questionsCount; i++) {
            var number = random.nextInt(maxNumber);
            questions[i] = Integer.toString(number);
            correctAnswers[i] = isEven(number);
        }

        Engine.startGame(rules, questions, correctAnswers);
    }
}
