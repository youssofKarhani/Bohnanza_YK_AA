package Game_pkg.Player_pkg;

import Game_pkg.Game_components.Cards_pkg.Card;

import java.util.ArrayList;
import java.util.List;

public class Beanfield {
    private List<List<Card>> beanFields;
    private int coins = 0;
    private static final int MAX_CARDS_PER_FIELD = 10;
    private boolean autoHarvest = false;

    public Beanfield(int numFields) {
        beanFields = new ArrayList<>(numFields);
        for (int i = 0; i < numFields; i++) {
            beanFields.add(new ArrayList<>());
        }
    }

    public void setAutoHarvest(boolean autoHarvest) {
        this.autoHarvest = autoHarvest;
    }

    public boolean plant(Card card, int fieldIndex) {
        List<Card> field = beanFields.get(fieldIndex);
        if (field.isEmpty()) {
            field.add(card);
            return true;
        }
        if (field.get(0).getName().equals(card.getName())) {
            if (!isFieldFull(fieldIndex)) {
                field.add(card);
                return true;
            } else {
                System.out.println("Field is full");
            }
        } else {
            System.out.println("Field has a different type of beans");
            if (autoHarvest) {
                this.harvest(fieldIndex);
                field.add(card);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void harvest(int fieldIndex) {
        List<Card> field = beanFields.get(fieldIndex);
        if (field.isEmpty()) {
            System.out.println("Field is empty");
            return;
        }
        int coinsGenerated = getPotentialHarvestCoins(fieldIndex);
        System.out.println("Field generated " + coinsGenerated + " Coins");
        coins += coinsGenerated;
        field.clear();
    }

    public boolean isFieldFull(int fieldIndex) {
        return beanFields.get(fieldIndex).size() >= MAX_CARDS_PER_FIELD;
    }

    public boolean isFieldReadyToHarvest(int fieldIndex) {
        List<Card> field = beanFields.get(fieldIndex);
        if (field.isEmpty()) {
            return false;
        }
        Card card = field.get(0);
        return card.getCoinMap().containsKey(field.size());
    }

    public int getPotentialHarvestCoins(int fieldIndex) {
        List<Card> field = beanFields.get(fieldIndex);
        if (field.isEmpty()) {
            return 0;
        }
        Card card = field.get(0);
        int numCards = field.size();
        return card.getCoinMap().getOrDefault(numCards, 0);
    }

    public int getCoins() {
        return coins;
    }

    public List<Card> getFieldCards(int fieldIndex) {
        return new ArrayList<>(beanFields.get(fieldIndex));
    }

    public int getNumCardsInField(int fieldIndex) {
        return beanFields.get(fieldIndex).size();
    }

    public void displayFields() {
        for (int i = 0; i < beanFields.size(); i++) {
            System.out.print("Field " + (i + 1) + ": ");
            List<Card> field = beanFields.get(i);
            for (Card card : field) {
                System.out.print(card.getName() + " ");
            }
            System.out.println();
        }
    }

    public void addCoins(int amount) {
        coins += amount;
    }
}
