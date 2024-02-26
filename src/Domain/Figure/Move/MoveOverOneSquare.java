package Domain.Figure.Move;

public class MoveOverOneSquare extends MoveSpecification {

    public MoveOverOneSquare() {}

    @Override
    public Boolean IsSatisfiedBy(Move move) {
        int maxSquares = 1;
        return Math.abs(move.getVerticalDistance()) > maxSquares || Math.abs(move.getHorizontalDistance()) > maxSquares;
    }
}
