package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Even {
    static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    static final int MAX_VALUE = 100;

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
        String[][] questionsAnswers = new String[questionsCount][questionsCount];

        Random random = new Random();

        for (var i = 0; i < questionsCount; i++) {
            var number = random.nextInt(MAX_VALUE);
            questionsAnswers[i][Engine.QUESTION_INDEX] = Integer.toString(number);
            questionsAnswers[i][Engine.ANSWER_INDEX] = getAnswerEven(number);
        }

        Engine.startGame(RULES, questionsAnswers);
    }
}
