package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Progression {
    // method generating random arithmetic progression
    // contains from 5 to 10 numbers
    public static String[] getProgression() {
        Random random = new Random();

        // generating a number from 5 to 10
        // to do it, first generating a number from 5 to 10
        // then adding to this number 5
        final var range = 6;
        final var minNumber = 5;
        var numbersCount = random.nextInt(range) + minNumber;

        String[] numbers = new String[numbersCount];

        // generating the first number excepting 0 to have more fun :)
        final var maxNumberOfFirst = 20;
        var number = random.nextInt(maxNumberOfFirst) + 1;
        numbers[0] = Integer.toString(number);

        // generating a progression step excepting 0 too
        // otherwise all the numbers will be equals
        final var maxNumberOfStep = 10;
        var step = random.nextInt(maxNumberOfStep) + 1;

        for (var i = 1; i < numbers.length; i++) {
            numbers[i] = Integer.toString(number + step);
            number += step;
        }

        return numbers;
    }

    public static void startProgression(int questionsCount) {
        var rules = "What number is missing in the progression?";

        String[][] questionsAnswers = new String[questionsCount][questionsCount];
        var questionIndex = 0;
        var answerIndex = 1;

        Random random = new Random();

        for (var i = 0; i < questionsCount; i++) {
            var progression = getProgression();

            // generating a position of number that will we think
            var number = random.nextInt(progression.length);
            questionsAnswers[i][answerIndex] = progression[number];

            progression[number] = "..";
            questionsAnswers[i][questionIndex] = String.join(" ", progression);
        }

        Engine.startGame(rules, questionsAnswers);
    }
}
