package Domain.Figure.Move;

public class MoveDiagonallyForward extends MoveForward {
    public MoveDiagonallyForward() {}

    public MoveDiagonallyForward(int maxSquare) {
        this.maxSquare = maxSquare;
    }

    @Override
    public Boolean IsSatisfiedBy(Movement movement) {
        if (this.maxSquare > 0) {
            return Math.abs(movement.getHorizontalDistance()) == this.verticalDistance(movement)
                    && (Math.abs(movement.getVerticalDistance()) + Math.abs(movement.getHorizontalDistance())) / 2 <= maxSquare;
        }

        return Math.abs(movement.getHorizontalDistance()) == this.verticalDistance(movement);
    }
}
