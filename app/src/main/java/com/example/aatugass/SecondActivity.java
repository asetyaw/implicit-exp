package com.example.aatugass;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textMessage = findViewById(R.id.textMessage);

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");

        if (message != null) {
            textMessage.setText(message);
        }
    }
}
