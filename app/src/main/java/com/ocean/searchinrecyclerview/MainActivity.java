package com.ocean.searchinrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ocean.searchinrecyclerview.databinding.ActivityMainBinding;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recyclerViewChooseEmp.setLayoutManager(new LinearLayoutManager(this));
        binding.imageBtnSearch.setOnClickListener(v -> {

            binding.recyclerViewChooseEmp.setVisibility(View.VISIBLE);
            callRetrofitApiChooseEmp();
        });

    }

    private void callRetrofitApiChooseEmp() {

        RequestBody auth_key = RequestBody.create(MediaType.parse("text/plain"), "f0ecd33f8ddbbee98522ca726745c5e4");
        RequestBody customer_name = RequestBody.create(MediaType.parse("text/plain"), binding.etChooseEmp.getText().toString());

            RetrofitApi.getInstance().getApiServices().searchCustomer(auth_key,customer_name).enqueue(new Callback<List<SearchEmpModel>>() {
                @Override
                public void onResponse(Call<List<SearchEmpModel>> call, Response<List<SearchEmpModel>> response) {

                    if (response.isSuccessful()){

                        List<SearchEmpModel> empModel = response.body();

                        recyclerAdapter = new RecyclerAdapterChooseEmp(empModel, getApplicationContext());
                        binding.recyclerViewChooseEmp.setAdapter(recyclerAdapter);
                        binding.recyclerViewChooseEmp.setHasFixedSize(true);
                        recyclerAdapter.notifyDataSetChanged();
                        System.out.println(response.body());
                        Log.d("MainActivty", "onResponse: " + empModel);

                    }

                }

                @Override
                public void onFailure(Call<List<SearchEmpModel>> call, Throwable t) {


                    Toast.makeText(MainActivity.this, " *** " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("onFailure", "onFailure: " + t.getMessage().toString());

                }
            });
        }


}