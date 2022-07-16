package com.ocean.searchinrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ocean.searchinrecyclerview.databinding.ChooseEmpSearchListItemBinding;

import java.util.List;

public class RecyclerAdapterChooseEmp extends RecyclerView.Adapter<RecyclerAdapterChooseEmp.MyViewHolder> {

    private List<SearchEmpModel> list;
    private ChooseEmpSearchListItemBinding itemBinding;
    Context context;

    public RecyclerAdapterChooseEmp(List<SearchEmpModel> list, Context context) {
        this.list = list;
        this.context = context;
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
}
