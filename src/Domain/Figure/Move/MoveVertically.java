package Domain.Figure.Move;

public class MoveVertically extends MoveSpecification {
    @Override
    public Boolean IsSatisfiedBy(Move move) {
        return (new MoveVerticallyForward()).Or(new MoveVerticallyBackward()).IsSatisfiedBy(move);
    }
}
