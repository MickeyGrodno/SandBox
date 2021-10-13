package safetask;

public class Item {
    private int volume;
    private int cost;
    private double specificCost;

    public Item(int volume, int cost, double pecificCost) {
        this.volume = volume;
        this.cost = cost;
        this.specificCost = pecificCost;
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

    public double getSpecificCost() {
        return specificCost;
    }

    public void setSpecificCost(double specificCost) {
        this.specificCost = specificCost;
    }
}
