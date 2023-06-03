package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Calc {
    // method returning random operator
    public static String getOperator() {
        String[] operators = {"+", "-", "*"};

        var operatorsCount = 3;
        Random random = new Random();
        var randomNumber = random.nextInt(operatorsCount);

        return operators[randomNumber];
    }

    public static void startCalc(int questionsCount) {
        var rules = "What is the result of the expression?";

        String[] questions = new String[questionsCount];
        String[] correctAnswers = new String[questionsCount];

        Random random = new Random();
        var maxNumber = 20;

        for (var i = 0; i < questionsCount; i++) {
            var firstNumber = random.nextInt(maxNumber);
            var secondNumber = random.nextInt(maxNumber);
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
