package Domain.Figure.Move;

public class MoveLShape extends MoveSpecification {
    @Override
    public Boolean IsSatisfiedBy(Move move) {
        return (Math.abs(move.getHorizontalDistance()) == 1 && Math.abs(move.getVerticalDistance()) == 2)
                || (Math.abs(move.getHorizontalDistance()) == 2 && Math.abs(move.getVerticalDistance()) == 1);
    }
}
