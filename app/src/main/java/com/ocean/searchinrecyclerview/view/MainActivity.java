package com.ocean.searchinrecyclerview.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ocean.searchinrecyclerview.adapter.RecyclerAdapterChooseEmp;
import com.ocean.searchinrecyclerview.model.ChooseEmpExpenseForModel;
import com.ocean.searchinrecyclerview.model.SearchEmpModel;
import com.ocean.searchinrecyclerview.databinding.ActivityMainBinding;
import com.ocean.searchinrecyclerview.retrofit.RetrofitApi;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    RecyclerAdapterChooseEmp recyclerAdapter;
    ProgressDialog progressDialog;
    List<SearchEmpModel> empModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recyclerViewChooseEmp.setLayoutManager(new LinearLayoutManager(this));

//        progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Please wait...");
//        progressDialog.setCancelable(false);
//        progressDialog.show();

//        callRetrofitApiChooseEmp();
        binding.etChooseEmp.setText(getIntent().getStringExtra("customer_name"));
        binding.imageBtnSearch.setOnClickListener(v -> {

            binding.recyclerViewChooseEmp.setVisibility(View.VISIBLE);
            //Toast.makeText(getApplicationContext(), "Search Image btn clicked", Toast.LENGTH_SHORT).show();
            callRetrofitApiChooseEmp();

        });

//        if (recyclerAdapter != null){
//            recyclerAdapter.notifyDataSetChanged();
//            SearchEmpModel searchEmpModel = (SearchEmpModel) getIntent().getExtras().getSerializable("customer_name");
//            binding.etChooseEmp.setText(searchEmpModel.getCustomer_name());
//
//        }

    }

    private void callRetrofitApiChooseEmp() {

        RequestBody auth_key = RequestBody.create(MediaType.parse("text/plain"), "f0ecd33f8ddbbee98522ca726745c5e4");
        RequestBody customer_name = RequestBody.create(MediaType.parse("text/plain"), binding.etChooseEmp.getText().toString());

        RetrofitApi.getInstance().getApiServices().searchCustomer(auth_key, customer_name).enqueue(new Callback<ChooseEmpExpenseForModel>() {
            @Override
            public void onResponse(Call<ChooseEmpExpenseForModel> call, Response<ChooseEmpExpenseForModel> response) {

                if (response.isSuccessful() && response.body().getStatus() == "success"){
                    empModel = response.body().getCustomerListModel();
                    System.out.println(response.body());
                    Log.d("MainActivity", "onResponse: " + response.body().toString());
                    recyclerAdapter = new RecyclerAdapterChooseEmp(empModel, MainActivity.this);
                    recyclerAdapter.setList(empModel);
                    binding.recyclerViewChooseEmp.setAdapter(recyclerAdapter);
                    //recyclerAdapter.notifyDataSetChanged();
                    System.out.println(response.body());
                    Log.d("MainActivty", "onResponse: " + empModel);

                }
            }


            @Override
            public void onFailure(Call<ChooseEmpExpenseForModel> call, Throwable t) {

            }
        });




    }


}