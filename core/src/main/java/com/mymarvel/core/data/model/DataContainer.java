package com.mymarvel.core.data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataContainer<T> {

    @JsonProperty("offset")
    protected Integer mOffset;
    @JsonProperty("limit")
    protected Integer mLimit;
    @JsonProperty("total")
    protected Integer mTotal;
    @JsonProperty("count")
    protected Integer mCount;
    @JsonProperty("results")
    protected T mResults;

    public DataContainer() {
    }

    public Integer getOffset() {
        return mOffset;
    }

    public void setOffset(Integer offset) {
        mOffset = offset;
    }

    public Integer getLimit() {
        return mLimit;
    }

    public void setLimit(Integer limit) {
        mLimit = limit;
    }

    public Integer getTotal() {
        return mTotal;
    }

    public void setTotal(Integer total) {
        mTotal = total;
    }

    public Integer getCount() {
        return mCount;
    }

    public void setCount(Integer count) {
        mCount = count;
    }


    public T getResults() {
        return mResults;
    }

    public void setResults(T results) {
        mResults = results;
    }
}
