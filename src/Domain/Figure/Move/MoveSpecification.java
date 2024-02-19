package Domain.Figure.Move;

import Lib.Specification.CompositeSpecification;

abstract public class MoveSpecification extends CompositeSpecification<Move> {
    @Override
    abstract public Boolean IsSatisfiedBy(Move move);
}
