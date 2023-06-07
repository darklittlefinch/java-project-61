package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Calc {
    // method returning random operator
    public static String getOperator() {
        String[] operators = {"+", "-", "*"};

        Random random = new Random();
        var randomNumber = random.nextInt(operators.length);

        return operators[randomNumber];
    }

    public static int getAnswerCalc(int firstNumber, int secondNumber, String operator) {
        if (operator.equals("+")) {
            return firstNumber + secondNumber;
        } else if (operator.equals("-")) {
            return firstNumber - secondNumber;
        } else {
            return firstNumber * secondNumber;
        }
    }

    public static void startCalc(int questionsCount) {
        var rules = "What is the result of the expression?";

        String[][] questionsAnswers = new String[questionsCount][questionsCount];
        var questionIndex = 0;
        var answerIndex = 1;

        Random random = new Random();
        final var maxNumber = 20;

        for (var i = 0; i < questionsCount; i++) {
            var firstNumber = random.nextInt(maxNumber);
            var secondNumber = random.nextInt(maxNumber);
            var operator = getOperator();

            questionsAnswers[i][questionIndex] = firstNumber + " " + operator + " " + secondNumber;

            var correctAnswer = getAnswerCalc(firstNumber, secondNumber, operator);
            questionsAnswers[i][answerIndex] = Integer.toString(correctAnswer);
        }

        Engine.startGame(rules, questionsAnswers);
    }
}
