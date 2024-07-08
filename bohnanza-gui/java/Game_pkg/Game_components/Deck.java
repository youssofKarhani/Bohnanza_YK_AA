package Game_pkg.Game_components;

import java.util.HashMap;
import java.util.Map;
import Game_pkg.Game_components.Cards_pkg.Card;

public class Deck {
    private static final Deck instance = new Deck();

    private Map<String, Integer> createdCards;
    private Map<String, Integer> maxCards;

    private Deck() {
        createdCards = new HashMap<>();
        maxCards = new HashMap<>();
        initializeMaxCards();
    }

    public static Deck getInstance() {
        return instance;
    }

    private void initializeMaxCards() {
        // Initialize maxCards map with maximum counts for each card type
        maxCards.put("Gartenbohne", 6);
        maxCards.put("Rote Bohne", 8);
        maxCards.put("Augenbohne", 10);
        maxCards.put("Sojabohne", 12);
        maxCards.put("BrechBohne", 14);
        maxCards.put("Saubohne", 16);
        maxCards.put("Feuerbohne", 18);
        maxCards.put("Blaue Bohne", 20);

        // Initialize createdCards map with zero counts for each card type
        for (String key : maxCards.keySet()) {
            createdCards.put(key, 0);
        }
    }

    // Method to draw a random card
    public Card drawCard() {
        String cardType = Cardfactory.getRandomCardType();
        if (cardType == null) {
            System.out.println("No more cards to draw");
            return null;
        }

        // Ensure createdCards and maxCards contain the cardType
        if (!createdCards.containsKey(cardType)) {
            createdCards.put(cardType, 0);
        }
        if (!maxCards.containsKey(cardType)) {
            maxCards.put(cardType, 0); // Adjust the initial count as needed
        }

        Card card = Cardfactory.createCard(cardType);
        if (card != null) {
            createdCards.put(cardType, createdCards.get(cardType) + 1);

            if (createdCards.get(cardType) >= maxCards.get(cardType)) {
                Cardfactory.stopProducingCardType(cardType);
            }
        }
        return card;
    }

    // Method to draw a specific card (for testing purposes or specific game logic)
    public void drawCard(Card card) {
        String cardType = card.getName();

        // Ensure createdCards and maxCards contain the cardType
        if (!createdCards.containsKey(cardType)) {
            createdCards.put(cardType, 0);
        }
        if (!maxCards.containsKey(cardType)) {
            maxCards.put(cardType, 0); // Adjust the initial count as needed
        }

        // Update the state to reflect that the specific card has been drawn
        createdCards.put(cardType, createdCards.get(cardType) + 1);

        if (createdCards.get(cardType) >= maxCards.get(cardType)) {
            Cardfactory.stopProducingCardType(cardType);
        }
    }

    // Method to discard a card
    public void discard(Card card) {
        String cardType = card.getName();
        if (createdCards.containsKey(cardType)) {
            createdCards.put(cardType, createdCards.get(cardType) - 1);
        }
    }

    public Map<String, Integer> getCreatedCards() {
        return createdCards;
    }

    public Map<String, Integer> getMaxCards() {
        return maxCards;
    }
}
