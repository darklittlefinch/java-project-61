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

    public static void startEven() {
        var rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        var questionsCount = 3;
        String[] questions = new String[questionsCount];
        String[] correctAnswers = new String[questionsCount];

        Random random = new Random();

        for (var i = 0; i < questionsCount; i++) {
            var number = random.nextInt(100);
            questions[i] = Integer.toString(number);
            correctAnswers[i] = isEven(number);
        }

        Engine.startGame(rules, questions, correctAnswers);
    }
}
