package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");

        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("0 - Exit");

        System.out.print("Your choice: ");
        int gameNumber = scanner.nextInt();

        switch (gameNumber) {
            case 1:
                Cli.startGreet();
                break;
            case 2:
                Even.startEven();
                break;
            case 3:
                Calc.startCalc();
            case 0:
                break;
            default:
                System.out.println("Something went wrong");
        }

        scanner.close();
    }
}
