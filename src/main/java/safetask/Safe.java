package safetask;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Safe {
    private static List<Item> itemsList = itemGenerator();
    private static int itemsVolume;
    private static int itemsCount;
    private int safeSize;

    private int[][] table;

    public void fillSafe() {
        for(int j = 0; j <= safeSize; j++) {
            table[0][j] = 0;
        }

        // Обратите внимание на краевую задачу, i начинается с 1, j начинается с 0
        // Поскольку i в F [i-1] [j] уменьшается на 1
        for(int i = 1; i <= itemsCount; i++) {
            for(int j = 0; j <= safeSize; j++) {
                // Если в рюкзак вместимостью j помещается i-й объект
                if(j >= itemsList.get(i-1).getVolume()) {
                    table[i][j] = Math.max(table[i - 1][j - itemsList.get(i-1).getVolume()] + itemsList.get(i-1).getCost(), table[i - 1][j]);
                }else {
                    // Ничего не могу отложить, можно только не ставить i-й объект
                    table[i][j] = table[i - 1][j];
                }
            }
        }

        // Распечатываем все результаты, мы запрашиваем F [N] [V]
        for(int i = 0; i <= itemsCount; i++) {
            for(int j = 0; j <= safeSize; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void initialization() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размер сейфа от 10 до "+itemsVolume);
        safeSize = sc.nextInt();
        itemsCount = itemsList.size();

        while (safeSize>itemsVolume || safeSize<10) {
            System.out.println("Введено неверное значение. Введите размер сейфа (от 10 до 50)");
            safeSize = sc.nextInt();
        }
        table = new int [itemsCount+1] [safeSize+1]; // Обратите внимание, что это N + 1, потому что требуется начальное состояние F [0] [0], что означает, что первые 0 предметов помещаются в самый большой рюкзак с пространством 0 Доход
    }

    public static void main(String[] args) {
        Safe safe = new Safe();
        safe.initialization();
        safe.fillSafe();
        safe.printResult(safe.itemsCount, safe.safeSize);
    }

    public void printResult(int itemsCount, int safeSize) {
        System.out.println("Максимальная ценность предметов "+table[10][safeSize]);

        boolean[] isAdd = new boolean[itemsCount + 1];
        for (int i = itemsCount; i >= 1; i--) {
            if (table[i][safeSize] == table[i - 1][safeSize])
                isAdd[i] = false;
            else {
                isAdd[i] = true;
                safeSize -= itemsList.get(i-1).getVolume();
            }
        }

        System.out.print("Берем предметы с номерами ");
        for(int i = 1; i <= itemsCount; i++) {
            if(isAdd[i]) {
                System.out.print(i+" ");
            }
        }
    }

    private static List<Item> itemGenerator() {
        List<Item> items = new ArrayList();

        for (int i = 0; i < 10; i++) {
            int volume = 1+(int) (Math.random()*10);
            int cost = 1+(int) (Math.random()*10);
            items.add(new Item(volume, cost));
        }
        System.out.println("Список предметов:");
        for(int i = 0; i < items.size(); i++) {
            System.out.println((i+1)+". " + items.get(i));
        }
        itemsCount = items.size();
        itemsVolume = items.stream().mapToInt(Item::getVolume).sum();
        System.out.println("Суммарны объем = "+itemsVolume);
        System.out.println("Суммарная стоимость = "+items.stream().mapToInt(Item::getCost).sum());
        return items;
    }
}