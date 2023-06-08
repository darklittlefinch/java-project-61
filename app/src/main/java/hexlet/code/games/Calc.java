package hexlet.code.games;

import java.util.Random;
import hexlet.code.Engine;

public class Calc {
    static final String RULES = "What is the result of the expression?";
    static final int MAX_VALUE = 20;
    static final String[] OPERATORS = {"+", "-", "*"};

    // method returning random operator
    public static String getOperator() {
        Random random = new Random();
        var randomNumber = random.nextInt(OPERATORS.length);

        return OPERATORS[randomNumber];
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
        String[][] questionsAnswers = new String[questionsCount][questionsCount];

        Random random = new Random();

        for (var i = 0; i < questionsCount; i++) {
            var firstNumber = random.nextInt(MAX_VALUE);
            var secondNumber = random.nextInt(MAX_VALUE);
            var operator = getOperator();

            questionsAnswers[i][Engine.QUESTION_INDEX] = firstNumber + " " + operator + " " + secondNumber;

            var correctAnswer = getAnswerCalc(firstNumber, secondNumber, operator);
            questionsAnswers[i][Engine.ANSWER_INDEX] = Integer.toString(correctAnswer);
        }

        Engine.startGame(RULES, questionsAnswers);
    }
}
