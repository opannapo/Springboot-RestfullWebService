package com.lamaknyo.api.repository.predicate;

import com.lamaknyo.api.common.FilterDto;

import javax.persistence.criteria.*;

public abstract class BasePredicate<T> {
    protected Root root;
    protected CriteriaBuilder builder;
    protected CriteriaQuery query;

    private FilterDto<String, Object> filterDto;

    public void prepare(Root r, CriteriaQuery cq, CriteriaBuilder cb) {
        this.root = r;
        this.builder = cb;
        this.query = cq;
    }

    public void addFilter(FilterDto<String, Object> filterDto) {
        this.filterDto = filterDto;
    }

    protected FilterDto<String, Object> getFilter() {
        return this.filterDto;
    }

    protected CriteriaQuery select(Selection<? extends T> selection) {
        return query.select(selection);
    }

    protected Predicate result() {
        return query.getGroupRestriction();
    }


}
