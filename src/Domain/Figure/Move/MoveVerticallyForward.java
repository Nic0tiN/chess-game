package Domain.Figure.Move;

public class MoveVerticallyForward extends MoveSpecification {
    @Override
    public Boolean IsSatisfiedBy(Move move) {
        return move.getHorizontalDistance() == 0 && move.getVerticalDistance() > 0;
    }
}
