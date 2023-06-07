package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Calc {
    // method returning random operator
    public static String getOperator() {
        String[] operators = {"+", "-", "*"};

        final var operatorsCount = 3;
        Random random = new Random();
        var randomNumber = random.nextInt(operatorsCount);

        return operators[randomNumber];
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

            if (operator.equals("+")) {
                questionsAnswers[i][answerIndex] = Integer.toString(firstNumber + secondNumber);
            } else if (operator.equals("-")) {
                questionsAnswers[i][answerIndex] = Integer.toString(firstNumber - secondNumber);
            } else {
                questionsAnswers[i][answerIndex] = Integer.toString(firstNumber * secondNumber);
            }
        }

        Engine.startGame(rules, questionsAnswers);
    }
}
