package com.example.c2ldeliveryboy.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.c2ldeliveryboy.R;

public class MainActivity extends AppCompatActivity {

    private TextView signUpBt;
    private Button signInBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intItView();

        signUpBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        signInBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MasterPageActivity.class);
                startActivity(intent);
            }
        });
    }

    private void intItView() {
        signUpBt = findViewById(R.id.btSignUp);
        signInBt = findViewById(R.id.signInBT);
    }
}
