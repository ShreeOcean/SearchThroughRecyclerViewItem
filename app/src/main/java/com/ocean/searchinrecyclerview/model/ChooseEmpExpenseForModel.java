package com.ocean.searchinrecyclerview.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChooseEmpExpenseForModel {

    @SerializedName("status")
    private String status;
    @SerializedName("customer_list")
    private List<SearchEmpModel> customerListModel;

    public ChooseEmpExpenseForModel(String status, List<SearchEmpModel> customerListModel) {
        this.status = status;
        this.customerListModel = customerListModel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SearchEmpModel> getCustomerListModel() {
        return customerListModel;
    }

    public void setCustomerListModel(List<SearchEmpModel> customerListModel) {
        this.customerListModel = customerListModel;
    }
}
