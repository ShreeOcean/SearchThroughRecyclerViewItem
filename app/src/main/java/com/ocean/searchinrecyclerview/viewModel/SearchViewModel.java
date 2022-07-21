package com.ocean.searchinrecyclerview.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ocean.searchinrecyclerview.model.ChooseEmpExpenseForModel;
import com.ocean.searchinrecyclerview.model.SearchEmpModel;
import com.ocean.searchinrecyclerview.repository.SearchRepo;

import java.util.List;

public class SearchViewModel extends ViewModel {

    private SearchRepo searchRepo;
    private ChooseEmpExpenseForModel chooseEmpResponse;

    public SearchViewModel(SearchRepo searchRepo){
        this.searchRepo = searchRepo;
    }

    public MutableLiveData<String> customerName = new MutableLiveData<>();

    public MutableLiveData<List<SearchEmpModel>> searchResponse = new MutableLiveData<>();

    public void onClickSearch(){

//        searchRepo.searchCustomer(customerName.getValue());
    }
}
