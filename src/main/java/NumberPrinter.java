import java.util.*;

public class NumberPrinter {
    private static List<List<String>> container = bigSizeDigitsContainer();

    public static void main(String[] args) {
        printer();
    }
    public static void printer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число:");
        String numbersLine = sc.nextLine();

        List<Integer> digits = new ArrayList<>();
        for(String number : numbersLine.split("")) {
            digits.add(Integer.parseInt(number));
        }

        //Производим сортировку и полуаем самую большую цифру
        List<Integer> sortedNumbers = new ArrayList<>(digits);
        Collections.sort(sortedNumbers);
        int maxValue = sortedNumbers.get(sortedNumbers.size()-1);

        //Проходимся по списку цифр и вызываем для каждой метод bigSizeDigitsContainer, полученное значение записывается
        //в список bigSizeDigits
        List<List<String>> bigSizeDigits = new ArrayList();
        digits.forEach(digit -> bigSizeDigits.add(container.get(digit)));

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
    private static List bigSizeDigitsContainer() {
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
        return allNumbers;
    }
}
