package com.example.c2ldeliveryboy.View.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c2ldeliveryboy.R;
import com.example.c2ldeliveryboy.View.Activity.OrderDetailsActivity;
import com.example.c2ldeliveryboy.View.Model.Notification;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private Context notificationContext;
    private List<Notification> notificationList;

    public NotificationAdapter(Context notificationContext, List<Notification> notificationList) {
        this.notificationContext = notificationContext;
        this.notificationList = notificationList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_list,parent,false);


        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final Notification notificationPosition = notificationList.get(position);

        holder.order_id.setText(notificationPosition.getOrderId());
        holder.order_date.setText(notificationPosition.getOrderDate());
        holder.order_time.setText(notificationPosition.getOrderTime());
        holder.order_quantity.setText(notificationPosition.getOrderQuantity());
        holder.order_amount.setText(notificationPosition.getOrderAmount());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(notificationContext, OrderDetailsActivity.class);
                notificationContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView order_id, order_date, order_time, order_quantity, order_amount;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            order_id = itemView.findViewById(R.id.orderId);
            order_date = itemView.findViewById(R.id.orderDate);
            order_time = itemView.findViewById(R.id.orderTime);
            order_quantity = itemView.findViewById(R.id.quantity);
            order_amount = itemView.findViewById(R.id.amount);

        }
    }
}
