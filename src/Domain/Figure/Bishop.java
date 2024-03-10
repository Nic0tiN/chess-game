package Domain.Figure;

import Domain.Figure.Move.Movement;
import Domain.Figure.Move.MoveDiagonally;
import Lib.Specification.ISpecification;

public class Bishop extends Figure {
    public Bishop(Color.ColorEnum color) {
        super(FigureEnum.BISHOP, color);
    }

    @Override
    protected Boolean isSatisfied(Movement movement) {
        ISpecification<Movement> moves = new MoveDiagonally();

        return moves.IsSatisfiedBy(movement);
    }
}
