package Domain.Figure.Move;

public class MoveOverOneSquare extends MoveSpecification {
    private int maxSquares = 1;

    public MoveOverOneSquare() {}

    public MoveOverOneSquare(int maxSquares) {
        this.maxSquares = maxSquares;
    }

    @Override
    public Boolean IsSatisfiedBy(Move move) {
        return Math.abs(move.getVerticalDistance()) > maxSquares || Math.abs(move.getHorizontalDistance()) > maxSquares;
    }
}
