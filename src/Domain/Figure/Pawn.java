package Domain.Figure;

import Domain.Figure.Move.Move;
import Domain.Figure.Move.MoveDiagonallyForward;
import Domain.Figure.Move.MoveVerticallyForward;
import Lib.Specification.ISpecification;

public class Pawn extends Figure {
    public Pawn(Color.ColorEnum color) {
        super(FigureEnum.PAWN, color);
    }

    @Override
    protected Boolean isSatisfied(Move move) {
        ISpecification<Move> pawnMoves = (new MoveVerticallyForward((this.getCountMoves() == 0) ? 2 : 1));

        if (move.figureAtDestination != null) { // Attack
            pawnMoves = pawnMoves.Or(new MoveDiagonallyForward());
        }

        return pawnMoves.IsSatisfiedBy(move);
    }
}
