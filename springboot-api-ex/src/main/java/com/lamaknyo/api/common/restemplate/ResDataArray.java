package com.lamaknyo.api.common.restemplate;

import java.util.List;

public class ResDataArray {
    private List list;
    private long count;
    private long total;
    private int page;
    private int limit;
    private boolean hasNext;


    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
