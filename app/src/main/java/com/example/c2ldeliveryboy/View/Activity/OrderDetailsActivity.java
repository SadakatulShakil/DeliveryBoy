package com.example.c2ldeliveryboy.View.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.c2ldeliveryboy.R;
import com.example.c2ldeliveryboy.View.Fragment.OrderDetailsFragment;

public class OrderDetailsActivity extends AppCompatActivity {
    private FrameLayout frameLayout;
    private Toolbar dToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        initViews();

        dToolbar.setTitle(getString(R.string.order_details));
        dToolbar.setNavigationIcon(R.drawable.ic_back);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameForOrderDetails,new OrderDetailsFragment())
                .commit();

        dToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initViews() {
        frameLayout = findViewById(R.id.frameForOrderDetails);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dToolbar = findViewById(R.id.toolbar);
        }
    }
}
