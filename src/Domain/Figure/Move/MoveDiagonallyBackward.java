package Domain.Figure.Move;

public class MoveDiagonallyBackward extends MoveSpecification {
    @Override
    public Boolean IsSatisfiedBy(Move move) {
        return Math.abs(move.getHorizontalDistance()) == Math.abs(move.getVerticalDistance()) && move.getVerticalDistance() < 0;
    }
}
