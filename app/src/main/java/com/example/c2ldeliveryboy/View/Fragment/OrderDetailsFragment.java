package com.example.c2ldeliveryboy.View.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.c2ldeliveryboy.R;
import com.example.c2ldeliveryboy.View.Activity.MasterPageActivity;
import com.example.c2ldeliveryboy.View.Adapter.ItemAdapter;
import com.example.c2ldeliveryboy.View.Adapter.NotificationAdapter;
import com.example.c2ldeliveryboy.View.Model.Items;
import com.example.c2ldeliveryboy.View.Model.Notification;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderDetailsFragment extends Fragment {
    private Context context;
    private RecyclerView itemRecyclerView;
    private List<Items> mItemList;
    private RecyclerView.Adapter itemAdapter;
    private Button btnAccept, btnDecline;
    public OrderDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inItView(view);
        mItemList = new ArrayList<>();

        itemAdapter = new ItemAdapter(context, mItemList);
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        itemRecyclerView.setAdapter(itemAdapter);

        prepareData();

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameForOrderDetails, new ConfrimOrderFragment())
                        .commit();
            }
        });

        btnDecline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MasterPageActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }

    private void prepareData() {
        Items data= new Items("T-shirt","Wash & Steem", "1", "25 ৳");
        mItemList.add(data);

        data= new Items("Shirt","Wash & Steem & Fold", "2", "35 ৳");
        mItemList.add(data);

        data= new Items("Jacket","Wash & Steem", "1", "75 ৳");
        mItemList.add(data);

        data= new Items("Saree","Wash & Steem", "2", "25 ৳");
        mItemList.add(data);

        data= new Items("Serwani","Wash & Steem", "1", "125 ৳");
        mItemList.add(data);

        data= new Items("Bed-Sheet","Wash & Steem", "3", "45 ৳");
        mItemList.add(data);

        itemAdapter.notifyDataSetChanged();
    }

    private void inItView(View view) {
        itemRecyclerView = view.findViewById(R.id.orderItemRecycleView);
        btnAccept = view.findViewById(R.id.acceptBTN);
        btnDecline = view.findViewById(R.id.declineBTN);

    }
}
