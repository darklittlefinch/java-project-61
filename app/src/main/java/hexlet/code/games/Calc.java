package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Calc {
    public static String getOperator() {
        String[] operators = {"+", "-", "*"};

        Random random = new Random();
        var randomNumber = random.nextInt(3);

        return operators[randomNumber];
    }

    /*
    public static void startCalc() {
        Scanner scanner = new Scanner(System.in);

        var userName = Cli.startGreet();

        System.out.println("What is the result of the expression?");

        for (var i = 0; i < 3; i++) {
            Random random = new Random();

            var firstNumber = random.nextInt(20);
            var secondNumber = random.nextInt(20);
            var operator = getOperator();

            String question = Integer.toString(firstNumber) + " " + Character.toString(operator) + " "
            + Integer.toString(secondNumber);
            int correctAnswer = 0;

            switch (operator) {
                case '+':
                    correctAnswer = firstNumber + secondNumber;
                    break;
                case '-':
                    correctAnswer = firstNumber - secondNumber;
                    break;
                case '*':
                    correctAnswer = firstNumber * secondNumber;
                    break;
            }

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            int answer = scanner.nextInt();

            if (answer == correctAnswer) {
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

    public static void startCalc() {
        var rules = "What is the result of the expression?";

        var questionsCount = 3;
        String[] questions = new String[questionsCount];
        String[] correctAnswers = new String[questionsCount];

        Random random = new Random();

        for (var i = 0; i < questionsCount; i++) {
            var firstNumber = random.nextInt(20);
            var secondNumber = random.nextInt(20);
            var operator = getOperator();

            questions[i] = firstNumber + " " + operator + " " + secondNumber;

            if (operator.equals("+")) {
                correctAnswers[i] = Integer.toString(firstNumber + secondNumber);
            } else if (operator.equals("-")) {
                correctAnswers[i] = Integer.toString(firstNumber - secondNumber);
            } else {
                correctAnswers[i] = Integer.toString(firstNumber * secondNumber);
            }

            /*
            switch (operator) {
                case "+" -> correctAnswers[i] = Integer.toString(firstNumber + secondNumber);
                case "-" -> correctAnswers[i] = Integer.toString(firstNumber - secondNumber);
                case "*" -> correctAnswers[i] = Integer.toString(firstNumber * secondNumber);
            }
             */
        }

        Engine.startGame(rules, questions, correctAnswers);
    }
}
