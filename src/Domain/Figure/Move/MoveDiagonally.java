package Domain.Figure.Move;

public class MoveDiagonally extends MoveSpecification {
    @Override
    public Boolean IsSatisfiedBy(Move move) {
        return (new MoveDiagonallyForward()).Or(new MoveDiagonallyBackward()).IsSatisfiedBy(move);
    }
}
