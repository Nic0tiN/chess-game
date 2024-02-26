package Domain.Rule;

import Domain.Board.Board;
import Domain.Exception.WrongMoveException;
import Domain.Figure.Move.Move;

public class PositionRule extends Rule {

    @Override
    public boolean handle(Board board, Move move) throws WrongMoveException {

        if (move.from.equals(move.to)) {
            throw new WrongMoveException("You must choose a different position.");
        }

        if (move.figureMoving == null) {
            throw new WrongMoveException(String.format("No figures at position %s.", move.from));
        }

        return checkNext(board, move);
    }
}
