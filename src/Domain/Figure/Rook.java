package Domain.Figure;

import Domain.Figure.Move.Move;
import Domain.Figure.Move.MoveHorizontally;
import Domain.Figure.Move.MoveVertically;
import Lib.Specification.ISpecification;

public class Rook extends Figure {
    public Rook(Color.ColorEnum color) {
        super(FigureEnum.ROOK, color);
    }

    @Override
    protected Boolean isSatisfied(Move move) {
        ISpecification<Move> moves = (new MoveHorizontally())
                .Or(new MoveVertically());

        return moves.IsSatisfiedBy(move);
    }
}
