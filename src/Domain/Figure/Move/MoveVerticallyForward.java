package Domain.Figure.Move;

public class MoveVerticallyForward extends MoveForward {
    private int maxSquare = -1;

    public MoveVerticallyForward() {}
    public MoveVerticallyForward(int maxSquare) {
        this.maxSquare = maxSquare;
    }

    @Override
    public Boolean IsSatisfiedBy(Move move) {
        if (maxSquare > 0) {
            return move.getHorizontalDistance() == 0 && this.verticalDistance(move) > 0
                    && this.verticalDistance(move) <= maxSquare;
        }

        return move.getHorizontalDistance() == 0 && this.verticalDistance(move) > 0;
    }
}
