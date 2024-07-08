import Game_pkg.Game;
import Game_pkg.Game_components.Cards_pkg.Card;
import Game_pkg.Game_components.Deck;
public class Main {

    public static void main(String[] args) {
        Game game = Game.getInstance();
        game.setHighBohnExtension(true);
        game.initializePlayers(6);
        game.startGame();
//        Deck deck = Deck.getInstance();
//        Card card = deck.drawBohnCard();
//        System.out.println("Card drawn: " + card.getName() + "Coins: " + card.getCoinMap());


    }

}