package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    static final int MAX_VALUE = 100;

    // method determining is number even
    public static boolean isEven(int number) {
        var remainder = number % 2;
        return remainder == 0;
    }

    public static String getAnswerEven(int number) {
        if (isEven(number)) {
            return "yes";
        } else {
            return "no";
        }
    }

    public static void startEven() {
        var qsCount = Engine.QUESTIONS_COUNT;
        String[][] questionsAnswers = new String[qsCount][qsCount];

        for (var i = 0; i < qsCount; i++) {
            var number = Utils.getRandomInt(MAX_VALUE);
            questionsAnswers[i][Engine.QUESTION_INDEX] = Integer.toString(number);
            questionsAnswers[i][Engine.ANSWER_INDEX] = getAnswerEven(number);
        }

        Engine.startGame(RULES, questionsAnswers);
    }
}
