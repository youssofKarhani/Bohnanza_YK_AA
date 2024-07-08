package Game_pkg.Game_logic;

import Game_pkg.Game_components.Cards_pkg.Card;
import Game_pkg.Game_components.Player;

import java.util.List;

public class Trading_system {
    private static final Trading_system instance = new Trading_system(); // Eager initialization of the singleton instance

    private Player activePlayer;
    private Player tradingPlayer;
    private Card activePlayerCard;
    private Card tradingPlayerCard;

    private Trading_system() {
    }

    // Static method to get the singleton instance
    public static Trading_system getInstance() {
        return instance;
    }    public void startTrading(Player activePlayer, List<Player> allPlayers) {
        this.activePlayer = activePlayer;
        this.activePlayerCard = null;
        this.tradingPlayer = null;
        this.tradingPlayerCard = null;

        // Assume that activePlayer and tradingPlayer are chosen and the cards are selected programmatically for now
        // In a real scenario, the GUI will handle these selections

        // Example: active player wants to trade the first card in hand
        if (!activePlayer.getHandCards().isEmpty()) {
            activePlayerCard = activePlayer.getHandCards().get(0);
        }

        // Example: trading player is the second player in the list who agrees to trade
        for (Player player : allPlayers) {
            if (player != activePlayer && !player.getHandCards().isEmpty()) {
                tradingPlayer = player;
                tradingPlayerCard = player.getHandCards().get(0);
                break;
            }
        }

        // Check if both players and their cards are valid
        if (activePlayerCard != null && tradingPlayerCard != null) {
            executeTrade();
        } else {
            System.out.println("Trade cannot be executed due to invalid card selection.");
        }
    }

    // Method to execute the trade
    private void executeTrade() {
        activePlayer.getHandCards().remove(activePlayerCard);
        tradingPlayer.getHandCards().remove(tradingPlayerCard);

        activePlayer.getHandCards().add(tradingPlayerCard);
        tradingPlayer.getHandCards().add(activePlayerCard);

        System.out.println("Trade successful!");
        System.out.println(activePlayer.getName() + " traded " + activePlayerCard.getName() + " with " + tradingPlayer.getName() + "'s " + tradingPlayerCard.getName());
    }

}
