package com.ocean.searchinrecyclerview.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ocean.searchinrecyclerview.model.SearchEmpModel;
import com.ocean.searchinrecyclerview.databinding.ChooseEmpSearchListItemBinding;
import com.ocean.searchinrecyclerview.view.MainActivity;

import java.util.List;

public class RecyclerAdapterChooseEmp extends RecyclerView.Adapter<RecyclerAdapterChooseEmp.MyViewHolder> {

    private List<SearchEmpModel> list;
    private ChooseEmpSearchListItemBinding itemBinding;
    Context context;
    OnRVItemClickListener listner;

    public RecyclerAdapterChooseEmp(List<SearchEmpModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public RecyclerAdapterChooseEmp(Context context, List<SearchEmpModel> list, OnRVItemClickListener onRVItemClickListener) {

        this.list = list;
        this.context = context;
        this.listner = onRVItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerAdapterChooseEmp.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemBinding = ChooseEmpSearchListItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterChooseEmp.MyViewHolder holder, int position) {

        holder.binding.tvChooseEmpFromRvItem.setText(list.get(position).getCustomer_name());
        holder.binding.tvChooseEmpFromRvItem.setOnClickListener(v -> {
            Intent intent = new Intent(context, MainActivity.class);
            intent.putExtra("customer_name", list.get(position).getCustomer_name());
            context.startActivity(intent);
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ChooseEmpSearchListItemBinding binding;

        public MyViewHolder(ChooseEmpSearchListItemBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;

        }

    }

    public void setList(List<SearchEmpModel> empModelList){
        if(empModelList != null && empModelList.size() > 0 ){
            this.list = empModelList;
            notifyDataSetChanged();
        }
    }

//    public Observable<String> getPositionClicks(){
//        return onClickSubject.
//    }
}
