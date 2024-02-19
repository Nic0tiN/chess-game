package Domain.Figure;

import Domain.Board.Color;
import Domain.Figure.Move.*;
import Lib.Specification.ISpecification;
import Lib.Specification.NotSpecification;

public class King extends Figure {
    public King(Color.ColorEnum color) {
        super(FigureEnum.KING, color);
    }

    @Override
    public Boolean move(Move move) {
        ISpecification<Move> kingMoves = new MoveDiagonally()
                .Or(new MoveVertically())
                .Or(new MoveHorizontally())
                .And(new NotSpecification<>(new MoveOverOneSquare()));

        return kingMoves.IsSatisfiedBy(move);
    }
}
