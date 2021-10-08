package safetask;

public class ValuableItem {
    private String volume;
    private int cost;

    public ValuableItem(String volume, int cost) {
        this.volume = volume;
        this.cost = cost;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
