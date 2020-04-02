package com.example.c2ldeliveryboy.View.Adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c2ldeliveryboy.R;
import com.example.c2ldeliveryboy.View.Model.Items;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private Context itemContext;
    private List<Items> itemList;

    public ItemAdapter(Context itemContext, List<Items> itemList) {
        this.itemContext = itemContext;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);


        return new ItemAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemAdapter.ViewHolder holder, final int position) {

        final Items itemsPosition = itemList.get(position);

        holder.itemName.setText(itemsPosition.getItemName());
        holder.itemWashOption.setText(itemsPosition.getItemOption());
        holder.itemQuantity.setText(itemsPosition.getItemQuantity());
        holder.itemAmount.setText(itemsPosition.getItemAmount());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView itemName, itemWashOption, itemQuantity, itemAmount;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemNameTV);
            itemWashOption = itemView.findViewById(R.id.washOptionTV);
            itemQuantity = itemView.findViewById(R.id.itemQuantity);
            itemAmount = itemView.findViewById(R.id.itemAmount);
        }
    }
}
