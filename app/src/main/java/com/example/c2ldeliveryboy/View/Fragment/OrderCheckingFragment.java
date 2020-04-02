package com.example.c2ldeliveryboy.View.Fragment;

import android.content.Context;
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
import android.widget.Toast;

import com.example.c2ldeliveryboy.R;
import com.example.c2ldeliveryboy.View.Adapter.CheckingAdapter;
import com.example.c2ldeliveryboy.View.Adapter.ItemAdapter;
import com.example.c2ldeliveryboy.View.Model.Items;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderCheckingFragment extends Fragment {
    private Context context;
    private RecyclerView orderCheckingRecycleView;
    private List<Items> mItemList;
    private RecyclerView.Adapter itemAdapter;
    private Button pickingUp;
    public OrderCheckingFragment() {
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
        return inflater.inflate(R.layout.fragment_order_checking, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inItView(view);
        mItemList = new ArrayList<>();

        itemAdapter = new CheckingAdapter(context, mItemList);
        orderCheckingRecycleView.setLayoutManager(new LinearLayoutManager(context));
        orderCheckingRecycleView.setAdapter(itemAdapter);

        pickingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Successfully Order Picked  !", Toast.LENGTH_SHORT).show();
            }
        });
        prepareData();
    }

    private void prepareData() {
        Items data= new Items("T-shirt","Wash & Steem", "1");
        mItemList.add(data);

        data= new Items("Shirt","Wash & Steem & Fold", "2");
        mItemList.add(data);

        data= new Items("Jacket","Wash & Steem", "1");
        mItemList.add(data);

        data= new Items("Saree","Wash & Steem", "2");
        mItemList.add(data);

        data= new Items("Serwani","Wash & Steem", "1");
        mItemList.add(data);

        data= new Items("Bed-Sheet","Wash & Steem", "3");
        mItemList.add(data);

        itemAdapter.notifyDataSetChanged();
    }

    private void inItView(View view) {
        orderCheckingRecycleView = view.findViewById(R.id.orderCheckingRecycleView);
        pickingUp = view.findViewById(R.id.pickingUpBTN);
    }
}
