package Game_pkg.Game_logic.Iteration_pkg;

public class DrawBeanCardsState implements PhaseState {
    @Override
    public void handle(Iteration_system context) {
        context.getPlayer().drawMultipleCard(3);
        System.out.println(context.getPlayer().getName() + " draws 3 bean cards.");
        context.setPhaseState(new PlantBeanCardsFromHandState());
    }


}
