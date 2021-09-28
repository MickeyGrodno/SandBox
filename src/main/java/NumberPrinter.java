import java.util.*;

public class NumberPrinter {
    public static void main(String[] args) {
        printer(2341);
    }
    public static void printer(Integer number) {

        //Получаем список из цифр
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
        Collections.reverse(digits);

        //Производим сортировку и полуаем самую большую цифру
        List<Integer> sortedNumbers = new ArrayList<>(digits);
        Collections.sort(sortedNumbers);
        Collections.reverse(sortedNumbers);
        int maxValue = sortedNumbers.get(0);

        //Проходимся по списку цифр и вызываем для каждой метод bigSizeDigitsContainer, полученное значение записывается
        //в список bigSizeDigits
        List<List<String>> bigSizeDigits = new ArrayList();
        digits.forEach(digit -> bigSizeDigits.add(bigSizeDigitsContainer(digit)));

        //Здесь производим проверку значений на максимальное и прозводим замену звездочек в bigSizeDigits на макс число
        for(int i = 0; i < digits.size(); i++) {
            if(digits.get(i)==maxValue) {
                for(int x = 0; x < bigSizeDigits.get(i).size(); x++) {
                    bigSizeDigits.get(i).set(x, bigSizeDigits.get(i).get(x).replace('*', (char) (maxValue+'0')));
                }
            }
        }

        //Тут выполняем построчное склейвание и печать
        StringBuilder lineBuilder = new StringBuilder();
        for(int line = 0; line < bigSizeDigits.get(0).size(); line++) {
            for (int digitNumber = 0; digitNumber < bigSizeDigits.size(); digitNumber++) {
                lineBuilder.append(bigSizeDigits.get(digitNumber).get(line));
            }
            System.out.println(lineBuilder);
            lineBuilder.setLength(0);
        }
    }


    //Контейнер со всеми большими цифрами
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
