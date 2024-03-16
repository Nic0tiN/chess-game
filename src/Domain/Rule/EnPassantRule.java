package Domain.Rule;

import Domain.Board.Board;
import Domain.Exception.WrongMoveException;
import Domain.Figure.Figure;
import Domain.Figure.Move.Movement;

import java.util.List;

public class EnPassantRule extends Rule {
    private final List<Movement> movementsHistory;

    public EnPassantRule(List<Movement> movementsHistory) {
        this.movementsHistory = movementsHistory;
    }

    @Override
    public boolean handle(Board board, Movement movement) throws WrongMoveException {
        Movement lastMovement;
        if (this.movementsHistory.isEmpty()) {
            return checkNext(board, movement);
        }

        lastMovement = this.movementsHistory.getLast();
        if (
                lastMovement != null
                && lastMovement.figureMoving != null
                && lastMovement.figureMoving.figure == Figure.FigureEnum.PAWN
                && Math.abs(lastMovement.getVerticalDistance()) == 2
                && movement.figureMoving != null
                && movement.figureMoving.figure == Figure.FigureEnum.PAWN
                && Math.abs(movement.getVerticalDistance()) == 1
                && Math.abs(movement.getHorizontalDistance()) == 1
        ) {
            // allow pawn's diagonal move by simulating opponent's pawn position attackable
            movement = new Movement(movement.from, movement.to, movement.figureMoving, lastMovement.figureMoving);

            if (checkNext(board, movement)) {
                board.ClearPosition(lastMovement.to);

                return true;
            }

            return false;
        }

        return checkNext(board, movement);
    }
}
