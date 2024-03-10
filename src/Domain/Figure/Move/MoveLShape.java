package Domain.Figure.Move;

public class MoveLShape extends MoveSpecification {
    @Override
    public Boolean IsSatisfiedBy(Movement movement) {
        return (Math.abs(movement.getHorizontalDistance()) == 1 && Math.abs(movement.getVerticalDistance()) == 2)
                || (Math.abs(movement.getHorizontalDistance()) == 2 && Math.abs(movement.getVerticalDistance()) == 1);
    }
}
