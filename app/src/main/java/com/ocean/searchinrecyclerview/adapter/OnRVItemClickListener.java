package com.ocean.searchinrecyclerview.adapter;

import com.ocean.searchinrecyclerview.model.SearchEmpModel;

import java.util.List;

public interface OnRVItemClickListener {

    void onItemClick(List<SearchEmpModel> searchData, int position);
}
