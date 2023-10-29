package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoDeCoBaLogic {

    private LoDeCoBaLogic() {

    }

    private static final Random random = new Random();

    public static List<List<String>> generateFullPrize() {
        List<List<String>> results = new ArrayList<>();
        results.add(generateSpecialPrize());
        results.add(generateFirstPrize());
        results.add(generateSecondPrize());
        results.add(generateThirdPrize());
        results.add(generateFourthPrize());
        results.add(generateFifthPrize());
        results.add(generateSixthPrize());
        results.add(generateSeventhPrize());
        return results;
    }

    private static List<String> generateSpecialPrize() {
        return generateNumbers(1, 5);
    }

    private static List<String> generateFirstPrize() {
        return generateNumbers(1, 5);
    }

    private static List<String> generateSecondPrize() {
        return generateNumbers(2, 5);
    }

    private static List<String> generateThirdPrize() {
        return generateNumbers(6, 5);
    }

    private static List<String> generateFourthPrize() {
        return generateNumbers(4, 4);
    }

    private static List<String> generateFifthPrize() {
        return generateNumbers(6, 4);
    }

    private static List<String> generateSixthPrize() {
        return generateNumbers(3, 3);
    }

    private static List<String> generateSeventhPrize() {
        return generateNumbers(4, 2);
    }

    public static boolean checkHasPrize(String prize, String selection) {
        String lastTwoChar = prize.substring(prize.length() - 2);
        return lastTwoChar.equals(selection);
    }

    private static List<String> generateNumbers(int quantity, int digits) {
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            numbers.add(generateNumber(digits));
        }
        return numbers;
    }

    private static String generateNumber(int digits) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

}
