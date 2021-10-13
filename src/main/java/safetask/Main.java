package safetask;

//        Есть набор предметов, задаваемый заранее, предметы могут повторяться.
//        Предмет имеет 2 параметра (обязательных, остальные добавлять на усмотрение): объем (целое значение) и ценность (целое значение).
//        Предметы неделимы. Также задаётся сейф с обязательным параметром его объёма (целое значение).
//        Нужно написать программу, которая наполняет сейф набором предметов таким образом, чтобы ценность этого набора была максимальной.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static List<Item> itemsList = itemGenerator();
    public static void main(String[] args) {
        int safeSize = itemsList.stream().mapToInt(Item::getVolume).sum()/2;
        Safe safe = new Safe(safeSize);
        boolean proceed = true;
        Item item;

        while (proceed) {
            proceed = false;
            while(safe.getFreeSpace()>=itemsList.stream().min(Comparator.comparingDouble(Item::getVolume)).map(Item::getVolume).get()) {
                item = itemsList.stream()
                        .filter(it -> it.getVolume()<=safe.getFreeSpace())
                        .max(Comparator.comparingDouble(Item::getSpecificCost))
                        .get();
                if(safe.putInSafe(item)) {
                    itemsList.remove(item);
                }
            }
            for(Item itemInSafe : safe.getItems()) {
                int freeSpaceCalculated = (itemInSafe.getVolume()+safe.getFreeSpace());
                int specificCostCalculated = itemInSafe.getCost()/freeSpaceCalculated;
                for(Item itemInItemsList : itemsList) {
                   if(itemInItemsList.getSpecificCost()>specificCostCalculated && itemInItemsList.getVolume()<=freeSpaceCalculated) {
                       safe.deleteFromSafe(itemInSafe);
                       itemsList.add(itemInSafe);
                       itemsList.remove(itemInItemsList);
                       safe.putInSafe(itemInItemsList);
                       proceed = true;
                   }
               }
            }
        }

        System.out.println();
        System.out.println();
        System.out.println();
        itemsList.forEach(i -> System.out.println(i));
        System.out.println(safe);
    }

    private static List<Item> itemGenerator() {
        List<Item> items = new ArrayList();

        for (int i = 0; i < 20; i++) {
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
            System.out.println(item);
        }
        System.out.println("Суммарная масса: "+allItemsVolume+", суммарная цена: "+allItemsCost);


        return items;
    }
}
