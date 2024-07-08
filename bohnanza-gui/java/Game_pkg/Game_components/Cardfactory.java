package Game_pkg.Game_components;

import Game_pkg.Game_components.Cards_pkg.*;
import java.util.HashMap;
import java.util.Map;

public class Cardfactory {
    private static final Map<String, Class<? extends Card>> cardTypes = new HashMap<>();
    private static final Map<String, Boolean> productionStatus = new HashMap<>();

    static {
        // Initialize card types and production status
        cardTypes.put("Gartenbohne", Gartenbohne.class);
        cardTypes.put("RoteBohne", RoteBohne.class);
        cardTypes.put("Augenbohne", Augenbohne.class);
        cardTypes.put("Sojabohne", Sojabohne.class);
        cardTypes.put("BrechBohne", BrechBohne.class);
        cardTypes.put("Saubohne", Saubohne.class);
        cardTypes.put("Feuerbohne", Feuerbohne.class);
        cardTypes.put("BlaueBohne", BlaueBohne.class);

        // Initialize production status (assuming all are initially in production)
        for (String key : cardTypes.keySet()) {
            productionStatus.put(key, true);
        }
    }

    // Method to create a specific type of card based on cardType string
    public static Card createCard(String cardType) {
        Class<? extends Card> clazz = cardTypes.get(cardType);
        if (clazz != null) {
            try {
                return clazz.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                System.out.println("Error creating card of type: " + cardType);
                e.printStackTrace();
            }
        } else {
            System.out.println("Card type not found: " + cardType);
        }
        return null; // Return null if card type is not found or cannot be instantiated
    }

    // Method to get a random card type that is still in production
    public static String getRandomCardType() {
        // Get a list of card types that are still in production
        String[] availableTypes = productionStatus.entrySet()
                .stream()
                .filter(Map.Entry::getValue)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);

        // Return a random card type from the available types
        if (availableTypes.length > 0) {
            int randomIndex = (int) (Math.random() * availableTypes.length);
            return availableTypes[randomIndex];
        } else {
            return null; // Return null if no card types are available
        }
    }

    // Method to stop producing a specific card type
    public static void stopProducingCardType(String cardType) {
        productionStatus.put(cardType, false);
    }

    // Method to start producing a specific card type
    public static void startProducingCardType(String cardType) {
        productionStatus.put(cardType, true);
    }

    // Method to check if a specific card type is in production
    public static boolean isProducingCardType(String cardType) {
        return productionStatus.getOrDefault(cardType, false);
    }
}
