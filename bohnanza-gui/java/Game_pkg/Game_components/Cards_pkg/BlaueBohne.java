package Game_pkg.Game_components.Cards_pkg;

import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;

public class BlaueBohne extends Card {
    private final ImageIcon image;

    public BlaueBohne() {
        super("BlaueBohne", createCoinMap());
        image = new ImageIcon("C:/Users/alyar/Desktop/bohnanza-demo-gui/bohnanza-gui/src/main/resources/BLAUE_BOHNE.jpg"); // Replace with actual path
    }

    // Method to initialize and return the coin map
    private static Map<Integer, Integer> createCoinMap() {
        Map<Integer, Integer> coinMap = new HashMap<>();
        coinMap.put(4, 1);
        coinMap.put(6, 2);
        coinMap.put(8, 3);
        coinMap.put(10, 4);
        return coinMap;
    }

    public Map<Integer, Integer> getCoinMap() {
        return super.getCoinMap();
    }
    // Getter for the image object
    public ImageIcon getImage() {
        return image;
    }
}
