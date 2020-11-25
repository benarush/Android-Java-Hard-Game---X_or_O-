package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    String playerSign = "X";
    static int playerScore = 0 ;
    static int cpuScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ((TextView) findViewById(R.id.PlayerScore)).setText(String.valueOf(playerScore));
        ((TextView) findViewById(R.id.CPUScore)).setText(String.valueOf(cpuScore));
    }

    public void startGame(View b){
        Intent i = new Intent(this , MainActivity.class);
        i.putExtra("Sign" , this.playerSign);
        startActivity(i);
        finish();
    }
    public void setPlayerSign(View v){
        Button b = (Button) v;
        b.setBackgroundColor(Color.GREEN);
        if (b == findViewById(R.id.ChooseX)){
            this.playerSign = "X";
            findViewById(R.id.ChooseY).setBackgroundColor(Color.GRAY);
        } else if (b == findViewById(R.id.ChooseY)){
            this.playerSign = "O";
            findViewById(R.id.ChooseX).setBackgroundColor(Color.GRAY);
        }
    }

}