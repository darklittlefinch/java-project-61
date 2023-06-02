package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static void startGame(String rules, String[] questions, String[] correctAnswers) {
        var userName = Cli.startGreet();
        System.out.println(rules);

        Scanner scanner = new Scanner(System.in);

        for (var i = 0; i < questions.length; i++) {
            System.out.println("Question: " + questions[i]);
            System.out.print("Your answer: ");
            String answer = scanner.next();

            if (answer.equals(correctAnswers[i])) {
                System.out.println("Correct!");
            } else {
                String errorTemplate = "'%s' is wrong answer ;(. Correct answer was '%s'";
                System.out.println(String.format(errorTemplate, answer, correctAnswers[i]));
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
    }
}
