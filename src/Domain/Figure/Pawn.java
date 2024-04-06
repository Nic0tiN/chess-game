package Domain.Figure;

import Domain.Figure.Move.Movement;
import Domain.Figure.Move.MoveDiagonallyForward;
import Domain.Figure.Move.MoveVerticallyForward;
import Lib.Specification.ISpecification;

public class Pawn extends Figure {
    public Pawn(Color.ColorEnum color) {
        super(FigureEnum.PAWN, color);
    }

    @Override
    protected Boolean isSatisfied(Movement movement) {
        ISpecification<Movement> pawnMoves = (new MoveVerticallyForward((this.getCountMoves() == 0) ? 2 : 1));

        if (movement.figureAtDestination != null) { // Attack
            pawnMoves = new MoveDiagonallyForward(1);
        }

        return pawnMoves.IsSatisfiedBy(movement);
    }
}
