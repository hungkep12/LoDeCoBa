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

    public static List<String> generateSpecialPrize() {
        return generateNumber(1, 5);
    }

    public static List<String> generateFirstPrize() {
        return generateNumber(1, 5);
    }

    public static List<String> generateSecondPrize() {
        return generateNumber(2, 5);
    }

    public static List<String> generateThirdPrize() {
        return generateNumber(6, 5);
    }

    public static List<String> generateFourthPrize() {
        return generateNumber(4, 4);
    }

    public static List<String> generateFifthPrize() {
        return generateNumber(6, 4);
    }

    public static List<String> generateSixthPrize() {
        return generateNumber(3, 3);
    }

    public static List<String> generateSeventhPrize() {
        return generateNumber(4, 2);
    }

    public static boolean checkHasPrize(String prize, String selection) {
        String lastTwoChar = prize.substring(prize.length() - 2);
        return lastTwoChar.equals(selection);
    }

    private static List<String> generateNumber(int quantity, int digits) {
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            int rndNumber = random.nextInt((int) (Math.pow(10, digits) - 1));
            StringBuilder rndString = new StringBuilder();
            rndString.append(rndNumber);
            while (rndString.length() < digits) {
                rndString.insert(0, "0");
            }
            numbers.add(rndString.toString());
        }
        return numbers;
    }

}
