package com.example.diceroller;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.text.Editable;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {



    private static List<String> a = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent2 = getIntent();
        createArray();


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    TextView tvScore;

    int score = 0;

    public void on_button_click(View view){

        TextView tv = this.findViewById(R.id.textView);

        int number = roll_the_dice(6);

        tv.setText(String.valueOf(number));

        EditText  mEdit = findViewById(R.id.editText);
        Editable guessedNumber = mEdit.getText();

        TextView tvc = this.findViewById(R.id.congrats);


        int guessedN = Integer.parseInt(guessedNumber.toString());
        if (guessedN == number){
            tvc.setText("Congrats");

            tvScore = findViewById(R.id.score);
            score = score + 1;
            tvScore.setText(String.valueOf(score));

        }
        else {
            tvc.setText("Try Again");
        }


    }

    public int roll_the_dice(int bound){

 
        Random r = new Random();
        int number = r.nextInt(bound);


        return number;
    }


    public static void createArray(){

        a.add("If you could go anywhere in the world where would you go?");
        a.add("If you were stranded on a desert island what three things would you want to take with you?");
        a.add("If you could eat only one food for the rest of your life, what would that be?");
        a.add("If you won a million dollars, what is the first thing you would buy?");
        a.add("If you could spend the day with one fictional character, who would it be?");
        a.add("If you found a magic lantern and a genie gave you three wishes, what would you wish?");
    }

    public static void addItem(String item) {

        a.add(item);
    }

    public void on_buttonD_ICE_click(View view){
        TextView tv = this.findViewById(R.id.textView);

        int n = roll_the_dice(a.size());

        tv.setText(a.get(n));

    }

    public void Change(View view) {
        Intent intent = new Intent(this, AddIceBreaker.class);
        startActivity(intent);
    }


    public void Finish(View view){
        Intent intent3 = new Intent(this, Finisg.class);

        startActivity(intent3);


    }





}
