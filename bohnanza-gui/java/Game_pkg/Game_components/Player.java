package Game_pkg.Game_components;

import java.util.List;
import java.util.ArrayList;

import Game_pkg.Game;
import Game_pkg.Game_components.Cards_pkg.Card;
import Game_pkg.Player_pkg.Beanfield;
import Game_pkg.Player_pkg.Building;

public class Player {
    private String name;
    private Beanfield beanFields;
    private List<Card> handCards;
    private List<Card> turnOverCards;
    private List<Building> buildings;
    private Game game; // Reference to the Game class
    int state;

    public Player(String name, Game game, int numFields) {
        this.name = name;
        this.handCards = new ArrayList<>();
        this.turnOverCards = new ArrayList<>();
        this.game = game;
        this.state = 0;
        initializeBeanFields(numFields);
    }

    public Player(String testPlayer) {
    }

    public void changeState(int state){
        this.state = state;
    }

    // Initialize bean fields
    public void initializeBeanFields(int numFields) {
        this.beanFields = new Beanfield(numFields);
    }

    public Card drawOneCard() {
        return game.get_Deck().drawCard();
    }
    // Draw multiple cards from the deck
    public void drawMultipleCard(int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            handCards.add(drawOneCard());
        }
    }

    // Return a card from hand based on an integer index
    public Card oneHandCard(int index) {
        if (index >= 0 && index < handCards.size()) {
            return handCards.get(index);
        }
        return null;
    }

    // Return a card from turnOver based on an integer index
    public Card oneTurnOverCard(int index) {
        if (index >= 0 && index < handCards.size()) {
            return handCards.get(index);
        }
        return null;
    }

    public List<Card> getHandCards() {
        return handCards;
    }

    public void setHandCards(List<Card> handCards) {
        this.handCards = handCards;
    }

    public List<Card> getTurnOverCards() {
        return turnOverCards;
    }

    public void drawTurnOverCards() {
        for(int i = 0; i < 3; i++)
            this.turnOverCards.add(drawOneCard());
    }

    // Trade method which takes an integer parameter
    public void trade(int param) {
        // TODO: Implement method
    }

    // Plant method which takes an integer parameter
    public void plant(int fieldNum) {
        Card card = handCards.remove(0);
        beanFields.plant(card, fieldNum);
        System.out.print("You have planeted:"+card.getName()+" in field "+fieldNum+"\n");
    }

    // Harvest method which takes an integer parameter
    public void harvest(int fieldNum) {
        beanFields.harvest(fieldNum);
    }

    // Get the number of coins from a field
    public int getCoins() {
        return beanFields.getCoins();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    //get beanfield
    public Beanfield getBeanFields() {
        return this.beanFields;
    }
    public boolean buyBuilding(Building building) {
        // Check if the player already owns a building of this type
        for (Building b : buildings) {
            if (b.getName().equals(building.getName())) {
                System.out.println("You already own this building.");
                return false;
            }
        }

        // Check if the player has enough coins
        int coins = this.getCoins();
        if (this.getCoins() >= building.getCost()) {
            coins -= building.getCost();
            buildings.add(building);
            building.activate(this);
            System.out.println(building.getName() + " purchased for " + building.getCost() + " coins.");
            return true;
        } else {
            System.out.println("Not enough coins to buy " + building.getName());
            return false;
        }
    }
}





