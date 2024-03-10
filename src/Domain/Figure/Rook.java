package Domain.Figure;

import Domain.Figure.Move.Movement;
import Domain.Figure.Move.MoveHorizontally;
import Domain.Figure.Move.MoveVertically;
import Lib.Specification.ISpecification;

public class Rook extends Figure {
    public Rook(Color.ColorEnum color) {
        super(FigureEnum.ROOK, color);
    }

    @Override
    protected Boolean isSatisfied(Movement movement) {
        ISpecification<Movement> moves = (new MoveHorizontally())
                .Or(new MoveVertically());

        return moves.IsSatisfiedBy(movement);
    }
}
