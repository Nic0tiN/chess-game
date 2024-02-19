package Domain.Figure;

import Domain.Board.Color;
import Domain.Figure.Move.Move;
import Domain.Figure.Move.MoveDiagonallyForward;
import Domain.Figure.Move.MoveOverOneSquare;
import Domain.Figure.Move.MoveVerticallyForward;
import Lib.Specification.ISpecification;
import Lib.Specification.NotSpecification;

public class Pawn extends Figure {
    private Boolean hasMoved = false;
    public Pawn(Color.ColorEnum color) {
        super(FigureEnum.PAWN, color);
    }

    @Override
    public Boolean move(Move move) {
        ISpecification<Move> pawnMoves = (new MoveVerticallyForward());

        if (move.figureAtDestination != null) {
            pawnMoves.Or(new MoveDiagonallyForward());
        }
        else if (!hasMoved) {
            pawnMoves.Or(new MoveOverOneSquare(2));
        }

        hasMoved = pawnMoves.IsSatisfiedBy(move); // Fixit: bug if has moved but next moved unsatisfies will reset `hasMoved` value.

        return hasMoved;
    }
}
