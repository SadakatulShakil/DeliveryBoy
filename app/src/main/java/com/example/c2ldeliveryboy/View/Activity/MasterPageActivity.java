package com.example.c2ldeliveryboy.View.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.c2ldeliveryboy.R;
import com.example.c2ldeliveryboy.View.Fragment.MenuContainerFragment;

public class MasterPageActivity extends AppCompatActivity {
    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_page);

        initViews();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutID, new MenuContainerFragment())
                .commit();
    }

    private void initViews() {

        frameLayout = findViewById(R.id.frameLayoutID);
    }
}
