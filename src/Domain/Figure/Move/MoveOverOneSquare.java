package Domain.Figure.Move;

public class MoveOverOneSquare extends MoveSpecification {

    public MoveOverOneSquare() {}

    @Override
    public Boolean IsSatisfiedBy(Movement movement) {
        int maxSquares = 1;
        return Math.abs(movement.getVerticalDistance()) > maxSquares || Math.abs(movement.getHorizontalDistance()) > maxSquares;
    }
}
