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

import com.example.c2ldeliveryboy.R;
import com.example.c2ldeliveryboy.View.Adapter.NotificationAdapter;
import com.example.c2ldeliveryboy.View.Model.Notification;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment {

    private Context context;
    private RecyclerView notfyRecyclerView;
    private List<Notification> mNotificationList;
    private RecyclerView.Adapter notificationAdapter;

    public HomePageFragment() {
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
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inItView(view);
        mNotificationList = new ArrayList<>();

        notificationAdapter = new NotificationAdapter(context, mNotificationList);
        notfyRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        notfyRecyclerView.setAdapter(notificationAdapter);

        prepareData();
    }

    private void prepareData() {

    Notification data = new Notification("0012345", "01 March, 2020", "02.35 pm", "3 items", "70 ৳");
    mNotificationList.add(data);

        data = new Notification("0012346", "02 March, 2020", "03.35 pm", "2 items", "50 ৳");
        mNotificationList.add(data);

        data = new Notification("0012347", "03 March, 2020", "04.35 pm", "4 items", "120 ৳");
        mNotificationList.add(data);

        data = new Notification("0012348", "04 March, 2020", "04.55 pm", "2 items", "40 ৳");
        mNotificationList.add(data);

        data = new Notification("0012349", "05 March, 2020", "05.25 pm", "4 items", "100 ৳");
        mNotificationList.add(data);

        data = new Notification("0012310", "06 March, 2020", "06.00 pm", "5 items", "170 ৳");
        mNotificationList.add(data);

        data = new Notification("0012311", "07 March, 2020", "06.30 pm", "4 items", "110 ৳");
        mNotificationList.add(data);

        data = new Notification("0012312", "08 March, 2020", "07.00 pm", "2 items", "35 ৳");
        mNotificationList.add(data);

        notificationAdapter.notifyDataSetChanged();
    }

    private void inItView(View view) {
        notfyRecyclerView = view.findViewById(R.id.notificationRecycleView);
    }
}
