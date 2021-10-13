package safetask;
//        Есть набор предметов, задаваемый заранее, предметы могут повторяться.
//        Предмет имеет 2 параметра (обязательных, остальные добавлять на усмотрение): объем (целое значение) и ценность (целое значение).
//        Предметы неделимы. Также задаётся сейф с обязательным параметром его объёма (целое значение).
//        Нужно написать программу, которая наполняет сейф набором предметов таким образом, чтобы ценность этого набора была максимальной.


import java.util.ArrayList;
import java.util.List;

public class Safe {
    private List<Item> items;
    private int capacity;

    public Safe(int capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
