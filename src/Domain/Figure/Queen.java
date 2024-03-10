package Domain.Figure;

import Domain.Figure.Move.Movement;
import Domain.Figure.Move.MoveDiagonally;
import Domain.Figure.Move.MoveHorizontally;
import Domain.Figure.Move.MoveVertically;
import Lib.Specification.ISpecification;

public class Queen extends Figure {
    public Queen(Color.ColorEnum color) {
        super(FigureEnum.QUEEN, color);
    }

    @Override
    protected Boolean isSatisfied(Movement movement) {
        ISpecification<Movement> moves = (new MoveDiagonally())
                .Or(new MoveVertically())
                .Or(new MoveHorizontally());

        return moves.IsSatisfiedBy(movement);
    }
}
