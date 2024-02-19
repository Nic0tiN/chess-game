import Domain.Board.Exception.OutOfBoardException;
import Domain.Game;

public class Application {
    private static Game game;

    public static void main(String[] args) {
        System.out.print("plop");

        try {
            Application.game = new Game();
        } catch (OutOfBoardException ignored) {}
    }
}
