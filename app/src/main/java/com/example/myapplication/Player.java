package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class Player {
    String sign;
    int color ;
    public HashMap<String, Boolean> board= new HashMap<>();
    boolean win = false;


    public Player(String sign , int color){
        this.sign = sign;
        this.color = color;
        X_or_O.setBoard(this.board);
    }
    public void checkWining(){
        if (this.firstRowCheck() || this.secondRowCheck() || this.thirdRowCheck() || this.diagonalsCheck() ||
            this.firstColumn()   || this.secondColumn()   || this.thirdColumn()){
            this.win = true;
        }
    }

    public boolean firstRowCheck(){
        if (this.board.get("a") && this.board.get("b") && this.board.get("c")){
            return true;
        }
        return false;
    }
    public boolean secondRowCheck(){
        if (this.board.get("d") && this.board.get("e") && this.board.get("f")){
            return true;
        }
        return false;
    }
    public boolean thirdRowCheck(){
        if (this.board.get("g") && this.board.get("h") && this.board.get("i")){
            return true;
        }
        return false;
    }
    public boolean diagonalsCheck(){
        if (this.board.get("a") && this.board.get("e") && this.board.get("i")){
            return true;
        } else if (this.board.get("c") && this.board.get("e") && this.board.get("g")){
            return true;
        }
        return false;
    }
    public boolean firstColumn(){
        if (this.board.get("a") && this.board.get("d") && this.board.get("g")){
            return true;
        }
        return false;
    }
    public boolean secondColumn(){
        if (this.board.get("b") && this.board.get("e") && this.board.get("h")){
            return true;
        }
        return false;
    }
    public boolean thirdColumn(){
        if (this.board.get("c") && this.board.get("f") && this.board.get("i")){
            return true;
        }
        return false;
    }


    public void setTurn(Button button , X_or_O game){
        button.setText(this.sign);
        String tag = (String) button.getTag();
        this.board.put(tag , true);
        button.setBackgroundColor(this.color);
        button.setEnabled(false);
        game.board.remove(tag);
        game.turns++;
    }
}
