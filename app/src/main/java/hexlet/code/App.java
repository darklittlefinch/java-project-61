package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
import java.util.Scanner;

public class App {
    static final int QUESTIONS_COUNT = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Please enter the game number and press Enter.");

        final var greet = 1;
        final var even = 2;
        final var calc = 3;
        final var gcd = 4;
        final var progression = 5;
        final var prime = 6;
        final var exit = 0;

        System.out.println(greet + " - Greet");
        System.out.println(even + " - Even");
        System.out.println(calc + " - Calc");
        System.out.println(gcd + " - GCD");
        System.out.println(progression + " - Progression");
        System.out.println(prime + " - Prime");
        System.out.println(exit + " - Exit");

        System.out.print("Your choice: ");
        int gameNumber = scanner.nextInt();

        switch (gameNumber) {
            case greet:
                Cli.startGreet();
                break;
            case even:
                Even.startEven(QUESTIONS_COUNT);
                break;
            case calc:
                Calc.startCalc(QUESTIONS_COUNT);
                break;
            case gcd:
                Gcd.startGCD(QUESTIONS_COUNT);
                break;
            case progression:
                Progression.startProgression(QUESTIONS_COUNT);
                break;
            case prime:
                Prime.startPrime(QUESTIONS_COUNT);
                break;
            case exit:
                break;
            default:
                System.out.println("Something went wrong");
        }

        scanner.close();
    }
}
