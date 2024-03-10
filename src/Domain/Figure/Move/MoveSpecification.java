package Domain.Figure.Move;

import Lib.Specification.CompositeSpecification;

abstract public class MoveSpecification extends CompositeSpecification<Movement> {
    @Override
    abstract public Boolean IsSatisfiedBy(Movement movement);
}
