package Domain.Figure.Move;

public class MoveVertically extends MoveSpecification {
    @Override
    public Boolean IsSatisfiedBy(Movement movement) {
        return (new MoveVerticallyForward()).Or(new MoveVerticallyBackward()).IsSatisfiedBy(movement);
    }
}
