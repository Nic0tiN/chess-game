package Domain.Rule;

import Domain.Board.Board;
import Domain.Figure.Color;
import Domain.Exception.WrongMoveException;
import Domain.Figure.Move.Movement;

public class TurnRule extends Rule {
    private Color.ColorEnum nextMovingColor;

    public TurnRule (Color.ColorEnum nextPlayingColor) {
        this.nextMovingColor = nextPlayingColor;
    }

    @Override
    public boolean handle(Board board, Movement movement) throws WrongMoveException {
        if (movement.figureMoving != null && movement.figureMoving.color != nextMovingColor) {
            throw new WrongMoveException("It is not your turn.");
        }

        if (checkNext(board, movement)) {
            switch (nextMovingColor) {
                case WHITE -> nextMovingColor = Color.ColorEnum.BLACK;
                case BLACK -> nextMovingColor = Color.ColorEnum.WHITE;
            }

            return true;
        }

        return false;
    }
}
