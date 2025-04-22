package com.example.aatugass;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnExplicitIntent, btnImplicitIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvNama = findViewById(R.id.tvNama);
        TextView tvNIM = findViewById(R.id.tvNIM);

        tvNama.animate()
                .alpha(1f)
                .translationY(0)
                .setDuration(1000)
                .setStartDelay(300)
                .start();

        tvNIM.animate()
                .alpha(1f)
                .translationY(0)
                .setDuration(1000)
                .setStartDelay(600)
                .start();


        btnExplicitIntent = findViewById(R.id.btnExplicitIntent);
        btnImplicitIntent = findViewById(R.id.btnImplicitIntent);

        btnExplicitIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explicitIntent = new Intent(MainActivity.this, SecondActivity.class);
                explicitIntent.putExtra("message", "ceritanya ini explisit :)");
                startActivity(explicitIntent);
            }
        });

        Button btnShareText = findViewById(R.id.btnShareText);
        btnShareText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String shareText = "Nama: Aasetya\nNIM: 23552011386";
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                startActivity(Intent.createChooser(shareIntent, "Bagikan melalui"));
            }
        });

        btnImplicitIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent implicitIntent = new Intent(Intent.ACTION_VIEW);
                implicitIntent.setData(Uri.parse("https://www.google.com"));
                try {
                    startActivity(implicitIntent);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "No application found to handle this action", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
