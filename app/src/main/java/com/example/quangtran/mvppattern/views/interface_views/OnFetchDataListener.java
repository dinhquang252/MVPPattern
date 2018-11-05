package com.example.quangtran.mvppattern.views.interface_views;

import com.example.quangtran.mvppattern.models.Item;

import java.util.List;


public interface OnFetchDataListener {
    void onFetchDataSuccess(List<Item> users);
}
