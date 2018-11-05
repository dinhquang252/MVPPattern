package com.example.quangtran.mvppattern.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GithubUser {
    @SerializedName("total_count")
    @Expose
    private Integer mTotalCount;
    @SerializedName("incomplete_results")
    @Expose
    private Boolean mIncompleteResults;
    @SerializedName("items")
    @Expose
    public List<Item> items = null;

    public Integer getTotalCount() {
        return mTotalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.mTotalCount = totalCount;
    }

    public Boolean getIncompleteResults() {
        return mIncompleteResults;
    }

    public void setIncompleteResults(Boolean incompleteResults) {
        this.mIncompleteResults = incompleteResults;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
