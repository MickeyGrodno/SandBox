package eu.senlacousese.safetask;

public class Item {
    private int volume;
    private int cost;

    public Item(int volume, int cost) {
        this.volume = volume;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Предмет :" + "объем = " + volume + ", цена = " + cost;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
