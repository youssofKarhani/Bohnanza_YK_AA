package Game_pkg.Game_logic.Iteration_pkg;

import Game_pkg.Game_logic.Iteration_pkg.PhaseState;

public class TurnOverAndTradeBeanCardsState implements PhaseState {
    @Override
    public void handle(Iteration_system context) {
        context.getPlayer().drawTurnOverCards();
        System.out.println(context.getPlayer().getName() + " turns over and trades bean cards.");
        context.setPhaseState(new PlantTurnedOverAndTradedBeanCardsState());
        context.iteratePhases();
    }
}
