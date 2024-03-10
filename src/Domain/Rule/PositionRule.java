package Domain.Rule;

import Domain.Board.Board;
import Domain.Exception.WrongMoveException;
import Domain.Figure.Move.Movement;

public class PositionRule extends Rule {

    @Override
    public boolean handle(Board board, Movement movement) throws WrongMoveException {

        if (movement.from.equals(movement.to)) {
            throw new WrongMoveException("You must choose a different position.");
        }

        if (movement.figureMoving == null) {
            throw new WrongMoveException(String.format("No figures at position %s.", movement.from));
        }

        return checkNext(board, movement);
    }
}
