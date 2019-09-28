package com.example.projeto_app_dontpad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainContent extends AppCompatActivity {

    Button txtButton;
    Button txtButton_1;
    EditText txtEditText;
    ImageView cameraButton;
    Intent mainActivity;
    String txtEditTextTag;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        txtEditText = findViewById(R.id.txtEditText);
        txtButton = findViewById(R.id.ftButton);
        txtButton_1 = findViewById(R.id.ftButton_1);

        Intent intMainContent = getIntent();
        txtEditText.setText(intMainContent.getStringExtra("open"));

        //botão texto
        txtButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                txtEditTextTag = txtEditText.getText().toString();

                mainActivity = new Intent(MainContent.this, MainActivity.class);
                mainActivity.putExtra("open",txtEditTextTag);
                startActivity(mainActivity);
            }
        });

        //botão fotos
        txtButton_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Página atual", Toast.LENGTH_SHORT).show();
            }
        });

        //botão camera
        cameraButton = findViewById(R.id.camFtButton);
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (camera.resolveActivity(getPackageManager())!=null) {
                    startActivityForResult(camera, REQUEST_IMAGE_CAPTURE);
                }
            }
        });
    }

}