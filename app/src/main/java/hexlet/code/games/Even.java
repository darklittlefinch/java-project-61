package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Even {
    // method determining is number even
    public static boolean isEven(int number) {
        var remainder = number % 2;

        if (number == 0) {
            return false;
        }

        return remainder == 0;
    }

    public static String getAnswerEven(int number) {
        if (isEven(number)) {
            return "yes";
        } else {
            return "no";
        }
    }

    public static void startEven(int questionsCount) {
        var rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        String[][] questionsAnswers = new String[questionsCount][questionsCount];
        var questionIndex = 0;
        var answerIndex = 1;

        Random random = new Random();
        final var maxNumber = 100;

        for (var i = 0; i < questionsCount; i++) {
            var number = random.nextInt(maxNumber);
            questionsAnswers[i][questionIndex] = Integer.toString(number);
            questionsAnswers[i][answerIndex] = getAnswerEven(number);
        }

        Engine.startGame(rules, questionsAnswers);
    }
}
