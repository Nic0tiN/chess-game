package Domain.Figure;

import Domain.Figure.Move.*;
import Lib.Specification.ISpecification;

public class Knight extends Figure {
    public Knight(Color.ColorEnum color) {
        super(FigureEnum.KNIGHT, color);
    }

    @Override
    protected Boolean isSatisfied(Movement movement) {
        ISpecification<Movement> knightMoves = new MoveLShape();

        return knightMoves.IsSatisfiedBy(movement);
    }
}
