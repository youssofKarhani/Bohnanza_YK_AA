package Game_pkg.Player_pkg;
import Game_pkg.Game_components.Player;

public abstract class Building {
    private String name;
    private int cost;
    private String beanType;

    public Building(String name, int cost, String beanType) {
        this.name = name;
        this.cost = cost;
        this.beanType = beanType;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public String getBeanType() {
        return beanType;
    }

    public abstract void activate(Player player);


}