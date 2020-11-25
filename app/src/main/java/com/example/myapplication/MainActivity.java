package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Player player = new Player("X" , Color.BLUE);
    CPU cpu = new CPU("O" , Color.RED);
    X_or_O game = new X_or_O();
    boolean f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getIntent().getStringExtra("Sign").equals("O")){
            player.sign = "O";
            player.color = Color.RED;
            cpu.sign = "X";
            cpu.color = Color.BLUE;
        }
        randomSetTurn();
    }


    public void playerChoose(View b){
        Button button = (Button) b;
        player.setTurn(button , game);
        player.checkWining();
        if (player.win){
            SecondActivity.playerScore++;
            Toast.makeText(this , "You Win" , Toast.LENGTH_SHORT).show();
            disableButtons();
            goToSecondActivity();
        } else if (game.board.size()==0 || game.turns == 9){
            Toast.makeText(this , "Game is Over Nobody Fucking Win" , Toast.LENGTH_SHORT).show();
            goToSecondActivity();
        } else {
            cpu.setTurn(charToButton(cpu.cpuTurn(player.board , game)) , game);
            cpu.checkWining();
            if (cpu.win) {
                SecondActivity.cpuScore++;
                Toast.makeText(this, "You Lose! The CPU beat ya Ass!", Toast.LENGTH_SHORT).show();
                disableButtons();
                goToSecondActivity();
            }
        }
        if (game.board.size() == 0 || game.turns == 9) {
            Toast.makeText(this , "Game is Over Nobody Fucking Win" , Toast.LENGTH_SHORT).show();
            goToSecondActivity();
        }
    }

    private void goToSecondActivity() {
        Intent i = new Intent(this , SecondActivity.class);
        startActivity(i);
        finish();
    }


    public void disableButtons(){
        findViewById(R.id.a).setEnabled(false);
        findViewById(R.id.b).setEnabled(false);
        findViewById(R.id.c).setEnabled(false);
        findViewById(R.id.d).setEnabled(false);
        findViewById(R.id.e).setEnabled(false);
        findViewById(R.id.f).setEnabled(false);
        findViewById(R.id.g).setEnabled(false);
        findViewById(R.id.h).setEnabled(false);
        findViewById(R.id.i).setEnabled(false);
    }
    public Button charToButton(char c){
        Log.d("CPU CHARTER CHOOSING" , String.format("Char is : %c", c));
        switch (c){
            case 'a':
                return findViewById(R.id.a);
            case 'b':
                return findViewById(R.id.b);
            case 'c':
                return findViewById(R.id.c);
            case 'd':
                return findViewById(R.id.d);
            case 'e':
                return findViewById(R.id.e);
            case 'f':
                return findViewById(R.id.f);
            case 'g':
                return findViewById(R.id.g);
            case 'h':
                return findViewById(R.id.h);
            case 'i':
                return findViewById(R.id.i);
        }
        return findViewById(R.id.a);
    }

    private void randomSetTurn() {
        if (new Random().nextInt(2) == 0){
            Toast.makeText(this , "CPU START !" , Toast.LENGTH_SHORT).show();
            cpu.setTurn(charToButton(cpu.cpuTurn(player.board , game)) , game);
        } else {
            Toast.makeText(this , "You START !" , Toast.LENGTH_SHORT).show();
        }
    }

}