package Game_pkg;

import Game_pkg.Game_components.Deck;
import Game_pkg.Game_components.Player;
import Game_pkg.Game_logic.Iteration_pkg.Iteration_system;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final Game instance = new Game(); // Eager initialization of the singleton instance

    private Deck deck;
    private List<Player> players;
    private Iteration_system iterationSystem;
    boolean extension;

    // Private constructor to prevent instantiation
    public Game() {
        this.deck = Deck.getInstance(); // Initialize the Deck instance
        this.players = new ArrayList<>();
        this.iterationSystem = Iteration_system.getInstance();
    }

    // Static method to get the singleton instance
    public static Game getInstance() {
        return instance;
    }

    // Method to initialize the players
    public void initializePlayers(int numPlayers) {
        for (int i = 0; i < numPlayers; i++) {
            if (numPlayers > 4)
                players.add(new Player("Player " + (i + 1), this, 3));
            else
                players.add(new Player("Player " + (i + 1), this, 2));
        }
        System.out.println("Players initialized " + players.get(0).getName());
    }

    // **Method to start the game, dealing 5 cards to each player**
    public void startGame() {
        System.out.println("Game started \n");
        for (Player player : players) {
            player.drawMultipleCard(5); // Deal 5 cards to each player
        }

        // Print the cards drawn by each player
        for (Player player : players) {
            System.out.println(player.getName() + " has drawn: ");
            for (int i = 0; i < player.getHandCards().size(); i++) {
                System.out.println(player.getHandCards().get(i).getName());
            }
            System.out.println("-----------------------------");
        }

        playRound();
    }

    // Method to iterate through each player's turn
    public void playRound() {
        for (Player player : players) {
            System.out.println(player.getName() + "'s turn:");
            iterationSystem.setPlayer(player);
            iterationSystem.iteratePhases();
            System.out.println();
        }
    }

    public void setHighBohnExtension(boolean extension) {
        this.extension = extension;
    }


    public Deck get_Deck() {
        return deck;
    }

    public List<Player> get_Players(Player player) {
        return players;
    }
}
