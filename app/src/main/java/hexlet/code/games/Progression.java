package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Progression {
    public static String[] getProgression() {
        Random random = new Random();

        var numbersCount = random.nextInt(6) + 5;

        String[] numbers = new String[numbersCount];
        var number = random.nextInt(20) + 1;
        numbers[0] = Integer.toString(number);

        var step = random.nextInt(10) + 1;

        for (var i = 1; i < numbers.length; i++) {
            numbers[i] = Integer.toString(number + step);
            number += step;
        }

        return numbers;
    }

    public static void startProgression() {
        var rules = "What number is missing in the progression?";

        var questionsCount = 3;
        String[] questions = new String[questionsCount];
        String[] correctAnswers = new String[questionsCount];

        Random random = new Random();

        for (var i = 0; i < questionsCount; i++) {
            var progression = getProgression();

            var number = random.nextInt(progression.length);
            correctAnswers[i] = progression[number];

            progression[number] = "..";
            questions[i] = String.join(" ", progression);
        }

        Engine.startGame(rules, questions, correctAnswers);
    }
}
