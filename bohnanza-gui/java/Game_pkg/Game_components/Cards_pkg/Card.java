package Game_pkg.Game_components.Cards_pkg;
import  java.util.HashMap;
import  java.util.Map;
import  java.util.Random;

public class Card {
    private String name;
    private Map<Integer, Integer> coinMap;

    public Card(String name, Map<Integer, Integer> coins) {
        this.name = name;
        this.coinMap = coins;
    }

    public String getName() {
        return name;
    }

    public  Map<Integer, Integer> getCoinMap() {
        return this.coinMap;
    }
}

//    private static final Map<String, Integer> cardDistribution = new HashMap<>();
//    private static final int totalCards;
//
//    static {
//        cardDistribution.put("Gartenbohne", 6);
//        cardDistribution.put("Rote Bohne", 8);
//        cardDistribution.put("Augenbohne", 10);
//        cardDistribution.put("Sojabohne", 12);
//        cardDistribution.put("BrechBohne", 14);
//        cardDistribution.put("Saubohne", 16);
//        cardDistribution.put("Feuerbohne", 18);
//        cardDistribution.put("Blaue Bohne", 20);
//
//        int sum = 0;
//        for (int count : cardDistribution.values()) {
//            sum += count;
//        }
//        totalCards = sum;
//    }
//
//    public Card() {
//        this.name = generateRandomCard();
//        this.coins = cardDistribution.get(this.name);
//    }
//
//    private String generateRandomCard() {
//        Random random = new Random();
//        int randNum = random.nextInt(totalCards);
//        int cumulativeSum = 0;
//
//        for (Map.Entry<String, Integer> entry : cardDistribution.entrySet()) {
//            cumulativeSum += entry.getValue();
//            if (randNum < cumulativeSum) {
//                return entry.getKey();
//            }
//        }
//        // Fallback in case something goes wrong, though it shouldn't.
//        return "Unknown";
//    }
//
//    // Getters
//    public String getName() {
//        return name;
//    }
//
//    public int getCoins() {
//        return coins;
//    }
//}
