import java.util.*;

public class NumberPrinter {
    public static void main(String[] args) {
        printer(2341);
    }
    public static void printer(Integer number) {

        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
        Collections.reverse(digits);

        List<Integer> sortedNumbers = new ArrayList<>();
        Collections.reverse(Arrays.asList(sortedNumbers));
        int maxValue = sortedNumbers.get(0);

        StringBuilder lineBuilder = new StringBuilder();

        List<List<String>> bigSizeDigits = new ArrayList();
        digits.forEach(digit -> bigSizeDigits.add(bigSizeDigitsContainer(digit)));
        for(int line = 0; line < bigSizeDigits.get(0).size(); line++) {
            for (int digitNumber = 0; digitNumber < bigSizeDigits.size(); digitNumber++) {
                lineBuilder.append(bigSizeDigits.get(digitNumber).get(line));
            }
            System.out.println(lineBuilder);
            lineBuilder.setLength(0);
        }
    }

    private void digitReplacement(int digit) {

    }

    private static List<String> bigSizeDigitsContainer(int digit) {
        List<List<String>> allNumbers = new ArrayList<>();

        allNumbers.add(Arrays.asList(
                ("  ***  "),
                (" *   * "),
                (" *   * "),
                (" *   * "),
                (" *   * "),
                (" *   * "),
                ("  ***  ")
        ));

        allNumbers.add(Arrays.asList(
                ("   *   "),
                ("  **   "),
                ("   *   "),
                ("   *   "),
                ("   *   "),
                ("   *   "),
                ("   *   ")
        ));

        allNumbers.add(Arrays.asList(
                ("  ***  "),
                (" *   * "),
                ("    *  "),
                ("   *   "),
                ("  *    "),
                (" *     "),
                (" ***** ")
        ));

        allNumbers.add(Arrays.asList(
                ("  ***  "),
                (" *   * "),
                ("     * "),
                ("  ***  "),
                ("     * "),
                (" *   * "),
                ("  ***  ")
        ));

        allNumbers.add(Arrays.asList(
                ("     *  "),
                ("    **  "),
                ("   * *  "),
                ("  *  *  "),
                (" ****** "),
                ("     *  "),
                ("     *  ")
        ));

        allNumbers.add(Arrays.asList(
                (" ***** "),
                (" *     "),
                (" *     "),
                (" ****  "),
                ("     * "),
                (" *   * "),
                ("  ***  ")
        ));

        allNumbers.add(Arrays.asList(
                ("   **  "),
                ("  *    "),
                (" *     "),
                (" ****  "),
                (" *   * "),
                (" *   * "),
                ("  ***  ")
        ));

        allNumbers.add(Arrays.asList(
                (" ***** "),
                ("     * "),
                ("    *  "),
                ("   *   "),
                ("  *    "),
                (" *     "),
                (" *     ")
        ));

        allNumbers.add(Arrays.asList(
                ("  ***  "),
                (" *   * "),
                (" *   * "),
                ("  ***  "),
                (" *   * "),
                (" *   * "),
                ("  ***  ")
        ));

        allNumbers.add(Arrays.asList(
                ("  ***  "),
                (" *   * "),
                (" *   * "),
                ("  **** "),
                ("     * "),
                ("    *  "),
                ("  **   ")
        ));
        return allNumbers.get(digit);
    }
}
