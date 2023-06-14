package hexlet.code;

import java.util.Random;

public class Utils {
    public static int getRandomInt(int minNumber, int maxNumber) {
        Random random = new Random();
        var range = maxNumber - minNumber + 1;
        return random.nextInt(range) + minNumber;
    }

    public static int getRandomInt(int maxNumber) {
        return getRandomInt(0, maxNumber);
    }

    public static int getRandomIntExceptZero(int maxNumber) {
        Random random = new Random();
        return random.nextInt(maxNumber) + 1;
    }
}
