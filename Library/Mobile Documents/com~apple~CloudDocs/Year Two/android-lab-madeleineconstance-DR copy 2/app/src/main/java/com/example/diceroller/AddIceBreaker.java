package com.example.diceroller;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class AddIceBreaker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ice_breaker);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();

    }

    public void save(View view){
    MainActivity ma = new MainActivity();


    EditText mEdit = findViewById(R.id.editText2);
    Editable iceBreaker = mEdit.getText();

    String iB = iceBreaker.toString();

    ma.addItem(iB);

    Intent intent2 = new Intent(this, MainActivity.class);
    startActivity(intent2);

}

    public void cancel(View view){
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent2);
    }

}
