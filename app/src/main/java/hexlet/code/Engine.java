package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int QUESTION_INDEX = 0;
    public static final int ANSWER_INDEX = 1;

    public static void startGame(String rules, String[][] questionsAnswers) {
        var userName = Cli.startGreet();
        System.out.println(rules);

        Scanner scanner = new Scanner(System.in);

        for (String[] questionAnswer : questionsAnswers) {
            System.out.println("Question: " + questionAnswer[QUESTION_INDEX]);
            System.out.print("Your answer: ");
            String answer = scanner.next();

            if (answer.equals(questionAnswer[ANSWER_INDEX])) {
                System.out.println("Correct!");
            } else {
                String errorTemplate = "'%s' is wrong answer ;(. Correct answer was '%s'.";
                System.out.println(String.format(errorTemplate, answer, questionAnswer[ANSWER_INDEX]));
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
    }
}
