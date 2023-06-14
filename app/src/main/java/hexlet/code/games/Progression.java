package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.Random;

public class Progression {
    static final String RULES = "What number is missing in the progression?";
    static final int MIN_NUMBERS_COUNT = 5;
    static final int MAX_NUMBERS_COUNT = 10;
    static final int MAX_STEP_VALUE = 10;
    static final int MAX_FIRST_NUMBER_VALUE = 20;

    // method generating random arithmetic progression
    public static String[] getProgression(int numbersCount, int step, int firstNumber) {

        String[] numbers = new String[numbersCount];

        var numberOfProgression = firstNumber;

        for (var i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.toString(numberOfProgression);
            numberOfProgression += step;
        }

        return numbers;
    }

    public static void startProgression() {
        var qsCount = Engine.QUESTIONS_COUNT;
        String[][] questionsAnswers = new String[qsCount][qsCount];

        for (var i = 0; i < qsCount; i++) {
            var numbersCount = Utils.getRandomInt(MIN_NUMBERS_COUNT, MAX_NUMBERS_COUNT);
            var step = Utils.getRandomIntExceptZero(MAX_STEP_VALUE);
            var firstNumber = Utils.getRandomIntExceptZero(MAX_FIRST_NUMBER_VALUE);

            var progression = getProgression(numbersCount, step, firstNumber);

            // generating position of number that will we think
            Random random = new Random();
            var number = random.nextInt(progression.length);
            questionsAnswers[i][Engine.ANSWER_INDEX] = progression[number];

            progression[number] = "..";
            questionsAnswers[i][Engine.QUESTION_INDEX] = String.join(" ", progression);
        }

        Engine.startGame(RULES, questionsAnswers);
    }
}
