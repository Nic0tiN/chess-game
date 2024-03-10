package Domain.Rule;

import Domain.Board.Board;
import Domain.Board.Position;
import Domain.Board.PositionIterator;
import Domain.Exception.WrongMoveException;
import Domain.Figure.Figure;
import Domain.Figure.Move.Movement;

public class MovingRule extends Rule {
    @Override
    public boolean handle(Board board, Movement movement) throws WrongMoveException {
        if (movement.figureMoving != null
                && movement.figureAtDestination != null
                && movement.figureAtDestination.color.equals(movement.figureMoving.color)
        ) {
            throw new WrongMoveException("You can not take your own pieces.");
        }

        if (movement.figureMoving.figure != Figure.FigureEnum.KNIGHT) {
            // Are we trying to move over figures ?
            for (Position position : new PositionIterator(movement.from, movement.to)) {
                if (board.getFigureAtPosition(position).isPresent()
                        && !board.getFigureAtPosition(position).get().equals(movement.figureAtDestination)
                ) {
                    throw new WrongMoveException("You can not move over figures.");
                }
            }
        }

        if (checkNext(board, movement)) {
            board.MoveFigureTo(movement.from, movement.to, movement.figureMoving); // Do move

            return true;
        }

        return false;
    }
}
