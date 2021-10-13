package safetask;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Item> itemsList = itemGenerator();
    public static void main(String[] args) {
        int safeSize = itemsList.stream().mapToInt(Item::getVolume).sum()/2;
        Safe safe = new Safe(safeSize);
    }

    private static List<Item> itemGenerator() {
        List<Item> items = new ArrayList();

        for (int i = 0; i < 30; i++) {
            int volume = 1+(int) (Math.random() * 11);
            int cost = 1+(int) (Math.random()*30);
            double specificCost = ((double) cost)/((double) volume);
            items.add(new Item(volume, cost, specificCost));
        }

        int allItemsVolume = 0;
        int allItemsCost = 0;
        System.out.println("Набор предметов:");
        for(Item item : items) {
            allItemsVolume += item.getVolume();
            allItemsCost += item.getCost();
            System.out.println("Размер: " + item.getVolume() + ", цена: " + item.getCost() + ", удельная стоимость: "+item.getSpecificCost());
        }
        System.out.println("Суммарная масса: "+allItemsVolume+", суммарная цена: "+allItemsCost);


        return items;
    }
}
