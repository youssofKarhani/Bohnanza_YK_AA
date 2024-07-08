package Game_pkg.Game_logic.Iteration_pkg;

import Game_pkg.Game_components.Cards_pkg.Card;

public class PlantTurnedOverAndTradedBeanCardsState implements PhaseState {
    @Override
    public void handle(Iteration_system context) {
        for (Card card : context.getPlayer().getHandCards()) {
            System.out.println(context.getPlayer().getName() + " plants " + card.getName() + " from turned-over/traded cards.");
        }
        context.setPhaseState(new DrawBeanCardsState());
        context.iteratePhases();
    }
}
