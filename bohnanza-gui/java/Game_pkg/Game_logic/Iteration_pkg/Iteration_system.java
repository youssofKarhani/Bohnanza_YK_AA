package Game_pkg.Game_logic.Iteration_pkg;

import Game_pkg.Game_components.Player;
import Game_pkg.Game_logic.Iteration_pkg.PhaseState;


public class Iteration_system {
    private static final Iteration_system instance = new Iteration_system(); // Eager initialization of the singleton instance

    private Player player; // Reference to the Player class
    private PhaseState currentState;
    private int phaseCounter = 0;

    private Iteration_system() {
        this.currentState = new PlantBeanCardsFromHandState(); // Initial state
    }

    // Static method to get the singleton instance
    public static Iteration_system getInstance() {
        return instance;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setPhaseState(PhaseState state) {
        this.currentState = state;
    }

    public void iteratePhases() {
        currentState.handle(this);
    }

}


/**
public class Iteration_system {
    private static final Iteration_system instance = new Iteration_system(); // Eager initialization of the singleton instance

    private int phaseNum;
    private Player player; // Reference to the Player class

    private Iteration_system() {
        this.phaseNum = 1;
    }

    // Static method to get the singleton instance
    public static Iteration_system getInstance() {
        return instance;
    }

    public int getPhaseNum() {
        return phaseNum;
    }

    public void setPhaseNum(int phaseNum) {
        this.phaseNum = phaseNum;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void iteratePhase() {
        switch (phaseNum) {
            case 1:
                plantBeanCardsFromHand();
                break;
            case 2:
                turnOverAndTradeBeanCards();
                break;
            case 3:
                plantTurnedOverAndTradedBeanCards();
                break;
            case 4:
                drawBeanCards();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + phaseNum);
        }
        phaseNum = (phaseNum % 4) + 1; // Move to the next phase
    }

    public void start() {
        phaseNum = 1; // Start from the first phase
        iteratePhase();
    }

    public void iteratePlayer() {
        for (int i = 1; i <= 4; i++) {
            iteratePhase();
        }
    }

    // Phase 1: Plant Bean Cards from Your Hand
    private void plantBeanCardsFromHand() {
        List<Card> handCards = player.getHandCards();
        if (!handCards.isEmpty()) {
            Card cardToPlant = handCards.remove(0);
            // Logic to plant the card in a bean field
            System.out.println(player.getName() + " plants " + cardToPlant.getName() + " from hand.");
        } else {
            System.out.println(player.getName() + " has no cards to plant from hand.");
        }
    }

    // Phase 2: Turn Over (draw 2 additional cards) and Trade Bean Cards
    private void turnOverAndTradeBeanCards() {
        drawCards(2); // Draw 2 additional cards
        // Logic to trade cards (simplified for now)
        System.out.println(player.getName() + " turns over and trades bean cards.");
    }

    // Phase 3: Plant Turned-over and Traded Bean Cards
    private void plantTurnedOverAndTradedBeanCards() {
        List<Card> drawnCards = player.getDrawnCards();
        for (Card card : drawnCards) {
            // Logic to plant the drawn and traded cards
            System.out.println(player.getName() + " plants " + card.getName() + " from turned-over/traded cards.");
        }
        drawnCards.clear(); // Clear the drawn cards after planting
    }

    // Phase 4: Draw Bean Cards (3 cards from the deck)
    private void drawBeanCards() {
        drawCards(3); // Draw 3 cards from the deck
        System.out.println(player.getName() + " draws 3 bean cards.");
    }

    // Helper method to draw a specified number of cards from the deck
    private void drawCards(int numberOfCards) {
        List<Card> drawnCards = player.getDrawnCards();
        for (int i = 0; i < numberOfCards; i++) {
            player.drawCard();
        }
    }
}

*/