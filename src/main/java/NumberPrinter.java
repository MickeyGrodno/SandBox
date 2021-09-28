import java.util.*;

public class NumberPrinter {
    public static void printer(Integer number) {

        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
        List<Integer> sortedNumbers = new ArrayList<>();
        Collections.reverse(Arrays.asList(sortedNumbers));

//        int maxValue = sortedNumbers.get(0);

        List
    }

    private void digitReplacement(int digit) {

    }

    private static List<String> numberContainer(int digit) {
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
