package com.example.c2ldeliveryboy.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c2ldeliveryboy.R;
import com.example.c2ldeliveryboy.View.Model.Items;

import java.util.List;

public class CheckingAdapter extends RecyclerView.Adapter<CheckingAdapter.ViewHolder> {

    private Context checkingContext;
    private List<Items> itemList;

    public CheckingAdapter(Context checkingContext, List<Items> itemList) {
        this.checkingContext = checkingContext;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public CheckingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.checking_item_list,parent,false);


        return new CheckingAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final CheckingAdapter.ViewHolder holder, final int position) {
        final Items itemsPosition = itemList.get(position);

        holder.itemName.setText(itemsPosition.getItemName());
        holder.itemWashOption.setText(itemsPosition.getItemOption());
        holder.itemQuantity.setText(itemsPosition.getItemQuantity());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView itemName, itemWashOption, itemQuantity;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.itemNameTV);
            itemWashOption = itemView.findViewById(R.id.washOptionTV);
            itemQuantity = itemView.findViewById(R.id.itemQuantity);
        }
    }
}
