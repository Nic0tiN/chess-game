package Domain.Figure;

import Domain.Figure.Move.*;
import Lib.Specification.ISpecification;
import Lib.Specification.NotSpecification;

public class King extends Figure {
    public King(Color.ColorEnum color) {
        super(FigureEnum.KING, color);
    }

    @Override
    protected Boolean isSatisfied(Movement movement) {
        ISpecification<Movement> kingMoves = new NotSpecification<>(new MoveOverOneSquare())
                .And(new MoveDiagonally().Or(new MoveVertically()))
                .Or(new MoveHorizontally((this.getCountMoves() > 0) ? 1 : 2));

       return kingMoves.IsSatisfiedBy(movement);
    }
}
