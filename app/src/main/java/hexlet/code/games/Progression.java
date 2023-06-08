package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Progression {
    static final String RULES = "What number is missing in the progression?";
    static final int RANGE_OF_COUNT = 6;
    static final int MIN_NUMBERS_COUNT = 5;
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

    public static void startProgression(int questionsCount) {
        String[][] questionsAnswers = new String[questionsCount][questionsCount];

        Random random = new Random();

        for (var i = 0; i < questionsCount; i++) {
            var numbersCount = random.nextInt(RANGE_OF_COUNT) + MIN_NUMBERS_COUNT;
            var step = random.nextInt(MAX_STEP_VALUE) + 1;
            var firstNumber = random.nextInt(MAX_FIRST_NUMBER_VALUE) + 1;

            var progression = getProgression(numbersCount, step, firstNumber);

            // generating a position of number that will we think
            var number = random.nextInt(progression.length);
            questionsAnswers[i][Engine.ANSWER_INDEX] = progression[number];

            progression[number] = "..";
            questionsAnswers[i][Engine.QUESTION_INDEX] = String.join(" ", progression);
        }

        Engine.startGame(RULES, questionsAnswers);
    }
}
