package Domain.Figure.Move;

public class MoveDiagonallyForward extends MoveForward {
    @Override
    public Boolean IsSatisfiedBy(Move move) {
        return Math.abs(move.getHorizontalDistance()) == this.verticalDistance(move);
    }
}
