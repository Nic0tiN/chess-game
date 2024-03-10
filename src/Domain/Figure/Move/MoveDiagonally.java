package Domain.Figure.Move;

public class MoveDiagonally extends MoveSpecification {
    @Override
    public Boolean IsSatisfiedBy(Movement movement) {
        return (new MoveDiagonallyForward()).Or(new MoveDiagonallyBackward()).IsSatisfiedBy(movement);
    }
}
