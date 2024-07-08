package Game_pkg.Game_logic.Iteration_pkg;
import  Game_pkg.Game_components.Cards_pkg.Card;
import Game_pkg.Game_components.Player;

import java.util.List;

public class PlantBeanCardsFromHandState implements PhaseState {
    @Override
    public void handle(Iteration_system context) {
        List<Card> handCards = context.getPlayer().getHandCards();
        Player player = context.getPlayer();
        if (!handCards.isEmpty()) {
            Card cardToPlant = handCards.get(0); // The top card from the hand
            System.out.println("You need to plant: " + cardToPlant.getName());

            int fieldIndex = 0;

            player.plant(fieldIndex);
            context.setPhaseState(new TurnOverAndTradeBeanCardsState());
            context.iteratePhases();
        } else {
            System.out.println(player.getName() + " has no cards to plant from hand.");
            context.setPhaseState(new TurnOverAndTradeBeanCardsState());
            context.iteratePhases();
        }

    }
}
/**
 * Player player = context.getPlayer();
 *         List<Card> handCards = player.getHandCards();
 *
 *         if (!handCards.isEmpty()) {
 *             Card cardToPlant = handCards.get(0); // The top card from the hand
 *             System.out.println("You need to plant: " + cardToPlant.getName());
 *             displayFields(player);
 *
 *             Scanner scanner = new Scanner(System.in);
 *             System.out.println("Choose a field to plant in (0, 1, 2): ");
 *             int fieldIndex = scanner.nextInt();
 *
 *             boolean success = player.plantCard(cardToPlant, fieldIndex);
 *
 *             if (success) {
 *                 System.out.println("Card planted successfully.");
 *             } else {
 *                 System.out.println("Field has a different type of beans. Harvesting the field...");
 *                 List<Card> harvestedCards = player.harvestField(fieldIndex);
 *                 int coinsGained = player.getCoinsFromHarvest(fieldIndex);
 *                 System.out.println("Field harvested. You gained " + coinsGained + " coins.");
 *                 player.plantCard(cardToPlant, fieldIndex);
 *                 System.out.println("Card planted successfully after harvesting.");
 *             }
 *             handCards.remove(0); // Remove the planted card from the hand
 *         } else {
 *             System.out.println(player.getName() + " has no cards to plant from hand.");
 *         }
 *
 *         // Move to the next phase
 *         context.setPhaseState(new TurnOverAndTradeBeanCardsState());
 *     }
 *
 *     private void displayFields(Player player) {
 *         System.out.println("Your current fields:");
 *         for (int i = 0; i < player.getBeanFields().size(); i++) {
 *             System.out.print("Field " + i + ": ");
 *             List<Card> field = player.getBeanFields().get(i).getFieldCards();
 *             if (field.isEmpty()) {
 *                 System.out.println("Empty");
 *             } else {
 *                 System.out.println(field.get(0).getName() + " (" + field.size() + " cards)");
 *             }
 *         }
 *     }
 * }
 * */