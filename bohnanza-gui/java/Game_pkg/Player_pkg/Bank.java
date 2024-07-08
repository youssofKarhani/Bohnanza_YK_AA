package Game_pkg.Player_pkg;


import Game_pkg.Game_components.Player;

public class Bank extends Building {

    public Bank(int cost) {
        super("Bank", cost, "Black-eyed bean");
    }

    @Override
    public void activate(Player player) {
        // Specific attribute activation logic for the Bank
        System.out.println("Bank activated for " + player.getName());
        // Implement Bank-specific logic here
    }

    public String getSpecificAttribute() {
        return null;
    }
}