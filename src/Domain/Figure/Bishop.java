package Domain.Figure;

import Domain.Figure.Move.Move;
import Domain.Figure.Move.MoveDiagonally;
import Lib.Specification.ISpecification;

public class Bishop extends Figure {
    public Bishop(Color.ColorEnum color) {
        super(FigureEnum.BISHOP, color);
    }

    @Override
    protected Boolean isSatisfied(Move move) {
        ISpecification<Move> moves = new MoveDiagonally();

        return moves.IsSatisfiedBy(move);
    }
}
