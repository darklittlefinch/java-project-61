package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static void startGame(String rules, String[][] questionsAnswers) {
        var userName = Cli.startGreet();
        System.out.println(rules);

        var questionIndex = 0;
        var answerIndex = 1;

        Scanner scanner = new Scanner(System.in);

        for (String[] questionAnswer : questionsAnswers) {
            System.out.println("Question: " + questionAnswer[questionIndex]);
            System.out.print("Your answer: ");
            String answer = scanner.next();

            if (answer.equals(questionAnswer[answerIndex])) {
                System.out.println("Correct!");
            } else {
                String errorTemplate = "'%s' is wrong answer ;(. Correct answer was '%s'.";
                System.out.println(String.format(errorTemplate, answer, questionAnswer[answerIndex]));
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
    }
}
