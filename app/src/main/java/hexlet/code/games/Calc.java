package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.Random;

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

        int result = switch (operator) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            default -> 0;
        };

        return result;
    }

    public static void startCalc() {
        var qsCount = Engine.QUESTIONS_COUNT;
        String[][] questionsAnswers = new String[qsCount][qsCount];

        for (var i = 0; i < qsCount; i++) {
            var firstNumber = Utils.getRandomInt(MAX_VALUE);
            var secondNumber = Utils.getRandomInt(MAX_VALUE);
            var operator = getOperator();

            questionsAnswers[i][Engine.QUESTION_INDEX] = firstNumber + " " + operator + " " + secondNumber;

            var correctAnswer = getAnswerCalc(firstNumber, secondNumber, operator);
            questionsAnswers[i][Engine.ANSWER_INDEX] = Integer.toString(correctAnswer);
        }

        Engine.startGame(RULES, questionsAnswers);
    }
}
