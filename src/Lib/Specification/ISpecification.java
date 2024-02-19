package Lib.Specification;

public interface ISpecification<T> {
    Boolean IsSatisfiedBy(T candidate);
    ISpecification<T> And(ISpecification<T> specification);
    ISpecification<T> Or(ISpecification<T> specification);
    ISpecification<T> Not();
}
