package com.example.projeto_app_dontpad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button txtButton;
    Button txtButton_1;
    EditText txtEditText;
    Intent mainContent;
    String txtEditTextTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEditText = findViewById(R.id.txtEditText);
        txtButton = findViewById(R.id.txtButton);
        txtButton_1 = findViewById(R.id.txtButton_1);

        Intent intMainActivity = getIntent();
        txtEditText.setText(intMainActivity.getStringExtra("open"));

        //botão texto
        txtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Página atual", Toast.LENGTH_SHORT).show();
            }
        });

        //botão fotos
        txtButton_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                txtEditTextTag = txtEditText.getText().toString();
                mainContent = new Intent (MainActivity.this, MainContent.class);
                mainContent.putExtra("open",txtEditTextTag);
                startActivity(mainContent);
            }
        });


    }
}
