package com.example.projeto_app_dontpad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainDisplay extends AppCompatActivity {

    ImageView dspImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_main);

        dspImageView = findViewById(R.id.displayImageView);
        int img = getIntent().getIntExtra("Image Int", R.drawable.ic_launcher_background);
        dspImageView.setImageResource(img);
    }
}
