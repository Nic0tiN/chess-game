package Domain.Figure.Move;

public class MoveDiagonallyForward extends MoveSpecification {
    @Override
    public Boolean IsSatisfiedBy(Move move) {
        return Math.abs(move.getHorizontalDistance()) == move.getVerticalDistance();
    }
}
