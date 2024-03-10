package Domain.Figure.Move;

public class MoveDiagonallyForward extends MoveForward {
    @Override
    public Boolean IsSatisfiedBy(Movement movement) {
        return Math.abs(movement.getHorizontalDistance()) == this.verticalDistance(movement);
    }
}
