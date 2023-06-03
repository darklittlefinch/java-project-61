package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Progression {
    // метод, генерирующий случайную арифметическую прогрессию чисел
    // возвращаемая прогрессия содержит от 5 до 10 чисел
    public static String[] getProgression() {
        Random random = new Random();

        // генерируем число от 5 до 10
        // для этого сначала генерируем число от 0 до 5
        // затем прибавляем к получившемуся числу ещё 5
        var numbersCount = random.nextInt(6) + 5;

        String[] numbers = new String[numbersCount];

        // генерируем первое число, исключая 0, чтобы не было слишком скучно :)
        var number = random.nextInt(20) + 1;
        numbers[0] = Integer.toString(number);

        // генерируем шаг прогрессии, также исключая 0
        // иначе все числа прогрессии были бы одинаковыми
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

            // генерируем номер числа, которое будем загадывать в игре
            var number = random.nextInt(progression.length);
            correctAnswers[i] = progression[number];

            progression[number] = "..";
            questions[i] = String.join(" ", progression);
        }

        Engine.startGame(rules, questions, correctAnswers);
    }
}
