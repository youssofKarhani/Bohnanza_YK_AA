package io.bitbucket.plt.sdp.bohnanza.gui;

import Game_pkg.Game;
import Game_pkg.Game_components.Cards_pkg.Card;
import Game_pkg.Game_components.Cardfactory;
import Game_pkg.Game_components.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainWindow extends JFrame {

    private JTextField playerNameField;
    private JButton createPlayerButton;
    private JTextArea playerInfoArea;

    private JTextField cardNameField;
    private JButton createCardButton;
    private JTextArea cardInfoArea;

    private Game game;

    public MainWindow(int numFields) {
        // Initialize the game instance
        game = Game.getInstance();

        // Initialize GUI components
        playerNameField = new JTextField(20);
        createPlayerButton = new JButton("Create Player");
        playerInfoArea = new JTextArea(5, 20);

        cardNameField = new JTextField(20);
        createCardButton = new JButton("Create Card");
        cardInfoArea = new JTextArea(5, 20);

        // Add components to the frame
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Player Name:"));
        panel.add(playerNameField);
        panel.add(createPlayerButton);
        panel.add(new JScrollPane(playerInfoArea));

        panel.add(new JLabel("Card Name:"));
        panel.add(cardNameField);
        panel.add(createCardButton);
        panel.add(new JScrollPane(cardInfoArea));

        this.setContentPane(panel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // Add Event Listeners for the buttons
        createPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get player name from the text field
                String playerName = playerNameField.getText();

                // Create new player and add to game
                Player player = new Player(playerName, game, numFields);
                game.get_Players(player);

                // Display player information
                playerInfoArea.setText("Player Created:\nName: " + player.getName());
            }
        });

        createCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get card name from the text field
                String cardName = cardNameField.getText().trim(); // Trim whitespace for safety

                // Invoke Backend Logic to create a card
                Card card = Cardfactory.createCard(cardName);

                if (card != null) {
                    // Add the card to the game's deck (assuming deck management logic)
                    game.get_Deck().drawCard(card);

                    // Display card information
                    cardInfoArea.setText("Card Created:\nName: " + card.getName());
                } else {
                    cardInfoArea.setText("Error: Card type not found or creation failed.");
                }
            }
        });

        // Example: Start the game button (you can add this as needed)
        JButton startGameButton = new JButton("Start Game");
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.initializePlayers(2); // Initialize players (example with 2 players)
                game.startGame(); // Start the game

                // Update GUI or display game status as needed
                StringBuilder sb = new StringBuilder();
                List<Player> players = game.get_Players(null); // Retrieve players
                for (Player player : players) {
                    sb.append("Player: ").append(player.getName()).append("\n");
                }
                playerInfoArea.setText("Game Started!\n" + sb.toString());
            }
        });
        panel.add(startGameButton); // Add the start game button to the GUI
    }

    public static void main(String[] args) {
        // Example usage with 2 fields
        SwingUtilities.invokeLater(() -> new MainWindow(2));
    }
}
