package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Calc {
    // метод, возращающий случайный оператор
    public static String getOperator() {
        String[] operators = {"+", "-", "*"};

        Random random = new Random();
        var randomNumber = random.nextInt(3);

        return operators[randomNumber];
    }

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
        }

        Engine.startGame(rules, questions, correctAnswers);
    }
}
