package safetask;

import java.util.ArrayList;
import java.util.List;

public class Safe {
    private final int capacity;
    private List<Item> items;
    private int freeSpace;

    public Safe(int capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
        this.freeSpace = capacity;

    }

    public boolean putInSafe(Item item) {
        boolean successful = false;
        if(item.getVolume()<= freeSpace) {
            items.add(item);
            freeSpace -= item.getVolume();
            successful = true;
        }
        return successful;
    }

    public boolean deleteFromSafe(Item item) {
        boolean successful = false;
        if(items.remove(item)) {
            freeSpace += item.getVolume();
            successful = true;
        }
        return successful;
    }

    @Override
    public String toString() {
        int volumeSum = 0;
        int costSum = 0;
        for (Item item : items) {
            volumeSum += item.getVolume();
            costSum += item.getCost();
        }
        return "Safe{" +
                "items = " + items +
                "\n capacity = " + capacity +
                "\n free space = " + freeSpace +
                "\n volume sum = " + volumeSum +
                "\n cost sum = " + costSum +
                '}';
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(int freeSpace) {
        this.freeSpace = freeSpace;
    }
}
