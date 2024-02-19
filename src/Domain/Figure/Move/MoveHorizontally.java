package Domain.Figure.Move;

public class MoveHorizontally extends MoveSpecification {
    @Override
    public Boolean IsSatisfiedBy(Move move) {
        return Math.abs(move.getHorizontalDistance()) > 0 && move.getVerticalDistance() == 0;
    }
}
