package Lib.Specification;

public class NotSpecification<T> extends CompositeSpecification<T> {
    private final ISpecification<T> specification;

    public NotSpecification(ISpecification<T> spec) {
        this.specification = spec;
    }

    @Override
    public Boolean IsSatisfiedBy(T candidate) {
        return !specification.IsSatisfiedBy(candidate);
    }
}
