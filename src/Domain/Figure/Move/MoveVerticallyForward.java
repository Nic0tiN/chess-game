package Domain.Figure.Move;

public class MoveVerticallyForward extends MoveForward {

    public MoveVerticallyForward() {}
    public MoveVerticallyForward(int maxSquare) {
        this.maxSquare = maxSquare;
    }

    @Override
    public Boolean IsSatisfiedBy(Movement movement) {
        if (maxSquare > 0) {
            return movement.getHorizontalDistance() == 0 && this.verticalDistance(movement) > 0
                    && this.verticalDistance(movement) <= maxSquare;
        }

        return movement.getHorizontalDistance() == 0 && this.verticalDistance(movement) > 0;
    }
}
