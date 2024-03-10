package Domain.Figure.Move;

public class MoveHorizontally extends MoveSpecification {
    private int maxSquare;

    public MoveHorizontally() {
        this.maxSquare = -1;
    }
    public MoveHorizontally(int maxSquare) {
        this.maxSquare = maxSquare;
    }
    @Override
    public Boolean IsSatisfiedBy(Movement movement) {
        if (maxSquare == -1) {
            return Math.abs(movement.getHorizontalDistance()) > 0 && movement.getVerticalDistance() == 0;
        }

        return Math.abs(movement.getHorizontalDistance()) > 0 && Math.abs(movement.getHorizontalDistance()) <= maxSquare && movement.getVerticalDistance() == 0;
    }
}
