package Domain.Figure.Move;

public class MoveDiagonallyBackward extends MoveSpecification {
    @Override
    public Boolean IsSatisfiedBy(Movement movement) {
        return Math.abs(movement.getHorizontalDistance()) == Math.abs(movement.getVerticalDistance()) && movement.getVerticalDistance() < 0;
    }
}
