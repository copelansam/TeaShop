package edu.kennesaw.teashop.domain.inventory.queries;

public abstract class QueryDecorator implements IItemQuery{

    protected IItemQuery wrappedQuery;

    public QueryDecorator(IItemQuery wrappedQuery){
        this.wrappedQuery = wrappedQuery;
    }
}
