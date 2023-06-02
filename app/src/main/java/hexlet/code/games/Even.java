package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Even {
    public static String isEven(int number) {
        var remainder = number % 2;
        if (remainder == 0) {
            return "yes";
        }
        return "no";
    }

    /*
    public static void startEven() {
        Scanner scanner = new Scanner(System.in);

        var userName = Cli.startGreet();

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (var i = 0; i < 3; i++) {
            Random random = new Random();
            var number = random.nextInt(100);

            var correctAnswer = isEven(number);

            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String answer = scanner.next();

            if (answer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
        return;
    }
     */

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
