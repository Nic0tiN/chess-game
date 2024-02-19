package Lib.Specification;

public class OrSpecification<T> extends CompositeSpecification<T> {
    private final ISpecification<T> specificationLeft;
    private final ISpecification<T> specificationRight;

    public OrSpecification(ISpecification<T> specL, ISpecification<T> specR) {
        this.specificationLeft = specL;
        this.specificationRight = specR;
    }

    @Override
    public Boolean IsSatisfiedBy(T candidate) {
        return specificationLeft.IsSatisfiedBy(candidate) || specificationRight.IsSatisfiedBy(candidate);
    }
}
