package Domain.Figure.Move;

public class MoveVerticallyBackward extends MoveSpecification {
    @Override
    public Boolean IsSatisfiedBy(Movement movement) {
        return movement.getHorizontalDistance() == 0 && movement.getVerticalDistance() < 0;
    }
}
