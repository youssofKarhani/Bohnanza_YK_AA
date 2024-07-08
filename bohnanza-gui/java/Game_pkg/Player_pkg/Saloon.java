package Game_pkg.Player_pkg;

import Game_pkg.Game_components.Player;

public class Saloon extends Building {

    public Saloon(int cost) {
        super("Saloon", cost, "Green bean");
    }

    @Override
    public void activate(Player player) {
        // Specific attribute activation logic for the Saloon
        System.out.println("Saloon activated for " + player.getName());
        // Implement Saloon-specific logic here
    }
}