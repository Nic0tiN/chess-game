package Lib.Specification;

abstract public class CompositeSpecification<T> implements ISpecification<T> {
    abstract public Boolean IsSatisfiedBy(T candidate);

    @Override
    public ISpecification<T> And(ISpecification<T> specification) {
        return new AndSpecification<T>(this, specification);
    }

    @Override
    public ISpecification<T> Or(ISpecification<T> specification) {
        return new OrSpecification<T>(this, specification);
    }

    @Override
    public ISpecification<T> Not() {
        return new NotSpecification<T>(this);
    }
}
