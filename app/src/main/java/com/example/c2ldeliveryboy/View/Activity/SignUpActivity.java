package com.example.c2ldeliveryboy.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.c2ldeliveryboy.R;

public class SignUpActivity extends AppCompatActivity {

    private TextView signInTV;
    private ImageView imArrow;
    private Button signUpBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        inItView();

        signInTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        imArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        signUpBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, MasterPageActivity.class);
                startActivity(intent);
            }
        });
    }

    private void inItView() {
        signInTV = findViewById(R.id.tvSignIn);
        imArrow = findViewById(R.id.arrow);
        signUpBt = findViewById(R.id.signUpBT);
    }
}
