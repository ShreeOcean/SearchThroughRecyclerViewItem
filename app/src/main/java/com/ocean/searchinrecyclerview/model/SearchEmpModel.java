package com.ocean.searchinrecyclerview.model;

import com.google.gson.annotations.SerializedName;

public class SearchEmpModel {

    @SerializedName("customer_name")
    private String customer_name;

    @SerializedName("email_id")
    private String email_id;

    @SerializedName("contact")
    private String contact;

    @SerializedName("customer_id")
    private String customer_id;

    public SearchEmpModel(){}

    public SearchEmpModel(String customer_name, String email_id, String contact, String customer_id) {
        this.customer_name = customer_name;
        this.email_id = email_id;
        this.contact = contact;
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "SearchEmpModel{" +
                "customer_name='" + customer_name + '\'' +
                ", email_id='" + email_id + '\'' +
                ", contact='" + contact + '\'' +
                ", customer_id='" + customer_id + '\'' +
                '}';
    }
}
