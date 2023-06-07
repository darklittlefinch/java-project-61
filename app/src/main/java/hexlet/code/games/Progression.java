package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Progression {
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
        var rules = "What number is missing in the progression?";

        String[][] questionsAnswers = new String[questionsCount][questionsCount];
        var questionIndex = 0;
        var answerIndex = 1;

        final var rangeOfCount = 6;
        final var minCount = 5;

        final var maxSteps = 10;

        final var maxFirstNumber = 20;

        Random random = new Random();

        for (var i = 0; i < questionsCount; i++) {
            var numbersCount = random.nextInt(rangeOfCount) + minCount;
            var step = random.nextInt(maxSteps) + 1;
            var firstNumber = random.nextInt(maxFirstNumber) + 1;

            var progression = getProgression(numbersCount, step, firstNumber);

            // generating a position of number that will we think
            var number = random.nextInt(progression.length);
            questionsAnswers[i][answerIndex] = progression[number];

            progression[number] = "..";
            questionsAnswers[i][questionIndex] = String.join(" ", progression);
        }

        Engine.startGame(rules, questionsAnswers);
    }
}
