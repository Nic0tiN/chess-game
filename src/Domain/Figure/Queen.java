package Domain.Figure;

import Domain.Figure.Move.Move;
import Domain.Figure.Move.MoveDiagonally;
import Domain.Figure.Move.MoveHorizontally;
import Domain.Figure.Move.MoveVertically;
import Lib.Specification.ISpecification;

public class Queen extends Figure {
    public Queen(Color.ColorEnum color) {
        super(FigureEnum.QUEEN, color);
    }

    @Override
    protected Boolean isSatisfied(Move move) {
        ISpecification<Move> moves = (new MoveDiagonally())
                .Or(new MoveVertically())
                .Or(new MoveHorizontally());

        return moves.IsSatisfiedBy(move);
    }
}
