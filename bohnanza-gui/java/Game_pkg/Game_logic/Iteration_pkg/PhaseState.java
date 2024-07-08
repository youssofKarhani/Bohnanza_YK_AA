package Game_pkg.Game_logic.Iteration_pkg;
/**
 * Phases of the game iteration.
 * - PlantBeanCardsFromHandState: Plants a card from the player's hand.
 * - TurnOverAndTradeBeanCardsState: Turns over and trades bean cards.
 * - PlantTurnedOverAndTradedBeanCardsState: Plants a card from the turned-over/traded cards.
 * - DrawBeanCardsState: Draws 3 bean cards.
 */
public interface PhaseState {
    void handle(Iteration_system context);
}
