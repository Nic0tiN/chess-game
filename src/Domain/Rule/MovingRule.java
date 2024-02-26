package Domain.Rule;

import Domain.Board.Board;
import Domain.Board.Position;
import Domain.Board.PositionIterator;
import Domain.Exception.WrongMoveException;
import Domain.Figure.Figure;
import Domain.Figure.Move.Move;

public class MovingRule extends Rule {
    @Override
    public boolean handle(Board board, Move move) throws WrongMoveException {
        if (move.figureMoving != null
                && move.figureAtDestination != null
                && move.figureAtDestination.color.equals(move.figureMoving.color)
        ) {
            throw new WrongMoveException("You can not take your own pieces.");
        }

        if (move.figureMoving.figure != Figure.FigureEnum.KNIGHT) {
            // Are we trying to move over figures ?
            for (Position position : new PositionIterator(move.from, move.to)) {
                if (board.getFigureAtPosition(position).isPresent()
                        && !board.getFigureAtPosition(position).get().equals(move.figureAtDestination)
                ) {
                    throw new WrongMoveException("You can not move over figures.");
                }
            }
        }

        if (checkNext(board, move)) {
            board.MoveFigureTo(move.to, move.figureMoving); // Do move

            return true;
        }

        return false;
    }
}
