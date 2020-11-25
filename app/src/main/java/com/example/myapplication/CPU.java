package com.example.myapplication;

import android.graphics.Color;
import android.util.Log;
import android.widget.Button;

import java.util.HashMap;
import java.util.Random;

public class CPU extends Player {
    public CPU(String sign, int color) {
        super(sign, color);
    }

    public char cpuTurn(HashMap<String, Boolean> playerBoard , X_or_O game){
        char winChar     = this.tryToWin(playerBoard);
        char defenceChar = this.tryToDefence(playerBoard);

        if (winChar > 0){
            return winChar;
        } else if (defenceChar > 0){
            return defenceChar;
        }
        return randomTurn(game);
    }

    public char tryToWin(HashMap<String, Boolean> playerBoard){
        char f_r_w = this.firstRowWin(playerBoard);
        char s_r_w = this.secondRowWin(playerBoard);
        char t_r_w = this.thirdRowWin(playerBoard);
        char f_c_w = this.firstColumnWin(playerBoard);
        char s_c_w = this.secondColumnWin(playerBoard);
        char t_c_w = this.thirdColumnWin(playerBoard);
        char d_w   = this.diagonalsWin(playerBoard);

        if (f_r_w > 0){
            Log.d("Game Action Choose" , "firstRowWin");
            return f_r_w;
        } else if (s_r_w > 0){
            Log.d("Game Action Choose" , "SecondRowWin");
            return s_r_w;
        } else if (t_r_w > 0){
            Log.d("Game Action Choose" , "ThirdRowWin");
            return t_r_w;
        } else if (f_c_w > 0){
            Log.d("Game Action Choose" , "firstColumnWin");
            return f_c_w;
        } else if (s_c_w > 0){
            Log.d("Game Action Choose" , "secondColumnWin");
            return s_c_w;
        } else if (t_c_w > 0){
            Log.d("Game Action Choose" , "thirdColumnWin");
            return t_c_w;
        } else if (d_w > 0){
            Log.d("Game Action Choose" , "diagonalsWin");
            return d_w;
        }
        return 0;
    }

    public char tryToDefence(HashMap<String, Boolean> playerBoard){
        char f_r_d = this.firstRowDefence(playerBoard);
        char s_r_d = this.secondRowDefence(playerBoard);
        char t_r_d = this.thirdRowDefence(playerBoard);
        char f_c_d = this.firstColumnDefence(playerBoard);
        char s_c_d = this.secondColumnDefence(playerBoard);
        char t_c_d = this.thirdColumnDefence(playerBoard);
        char d_d   = this.diagonalsDefence(playerBoard);

        if (f_r_d > 0){
            Log.d("Game Action Choose" , "firstRowDefence");
            return f_r_d;
        } else if (s_r_d > 0){
            Log.d("Game Action Choose" , "secondRowDefence");
            return s_r_d;
        } else if (t_r_d > 0){
            Log.d("Game Action Choose" , "thirdRowDefence");
            return t_r_d;
        } else if (f_c_d > 0){
            Log.d("Game Action Choose" , "firstColumnDefence");
            return f_c_d;
        } else if (s_c_d > 0){
            Log.d("Game Action Choose" , "secondColumnDefence");
            return s_c_d;
        } else if (t_c_d > 0){
            Log.d("Game Action Choose" , "thirdColumnDefence");
            return t_c_d;
        } else if (d_d > 0){
            Log.d("Game Action Choose" , "diagonalsDefence");
            return d_d;
        }
        return 0;
    }
    public char firstRowDefence(HashMap<String, Boolean> playerBoard){
        if (playerBoard.get("a") && playerBoard.get("b") && !this.board.get("c")){
            return 'c';
        } else if (playerBoard.get("a") && !this.board.get("b") && playerBoard.get("c")){
            return 'b';
        } else if (!this.board.get("a") && playerBoard.get("b") && playerBoard.get("c")){
            return 'a';
        }
        return 0;
    }

    public char secondRowDefence(HashMap<String, Boolean> playerBoard){
        if (playerBoard.get("d") && playerBoard.get("e") && !this.board.get("f")){
            return 'f';
        } else if (playerBoard.get("d") && !this.board.get("e") && playerBoard.get("f")){
            return 'e';
        } else if (!this.board.get("d") && playerBoard.get("e") && playerBoard.get("f")){
            return 'd';
        }
        return 0;
    }

    public char thirdRowDefence(HashMap<String, Boolean> playerBoard){
        if (playerBoard.get("g") && playerBoard.get("h") && !this.board.get("i")){
            return 'i';
        } else if (playerBoard.get("g") && !this.board.get("h") && playerBoard.get("i")){
            return 'h';
        } else if (!this.board.get("g") && playerBoard.get("h") && playerBoard.get("i")){
            return 'g';
        }
        return 0;
    }

    public char firstColumnDefence(HashMap<String, Boolean> playerBoard){
        if (playerBoard.get("a") && playerBoard.get("d") && !this.board.get("g")){
            return 'g';
        } else if (playerBoard.get("a") && !this.board.get("d") && playerBoard.get("g")){
            return 'd';
        } else if (!this.board.get("a") && playerBoard.get("d") && playerBoard.get("g")){
            return 'a';
        }
        return 0;
    }

    public char secondColumnDefence(HashMap<String, Boolean> playerBoard){
        if (playerBoard.get("b") && playerBoard.get("e") && !this.board.get("h")){
            return 'h';
        } else if (playerBoard.get("b") && !this.board.get("e") && playerBoard.get("h")){
            return 'e';
        } else if (!this.board.get("b") && playerBoard.get("e") && playerBoard.get("h")){
            return 'b';
        }
        return 0;
    }

    public char thirdColumnDefence(HashMap<String, Boolean> playerBoard){
        if (playerBoard.get("c") && playerBoard.get("f") && !this.board.get("i")){
            return 'i';
        } else if (playerBoard.get("c") && !this.board.get("f") && playerBoard.get("i")){
            return 'f';
        } else if (!this.board.get("c") && playerBoard.get("f") && playerBoard.get("i")){
            return 'c';
        }
        return 0;
    }
    public char diagonalsDefence(HashMap<String, Boolean> playerBoard) {
        if (playerBoard.get("a") && playerBoard.get("e") && !this.board.get("i")){
            return 'i';
        } else if (playerBoard.get("a") && !this.board.get("e") && playerBoard.get("i")){
            return 'e';
        } else if (!this.board.get("a") && playerBoard.get("e") && playerBoard.get("i")){
            return 'a';
        } else if (playerBoard.get("c") && playerBoard.get("e") && !this.board.get("g")){
            return 'g';
        } else if (playerBoard.get("c") && !this.board.get("e") && playerBoard.get("g")){
            return 'e';
        } else if (!this.board.get("c") && playerBoard.get("e") && playerBoard.get("g")){
            return 'c';
        }
        return 0;
    }
    public char firstRowWin(HashMap<String, Boolean> playerBoard){
        if (this.board.get("a") && this.board.get("b") && !playerBoard.get("c")){
            return 'c';
        } else if (this.board.get("a") && !playerBoard.get("b") && this.board.get("c")){
            return 'b';
        } else if (!playerBoard.get("a") && this.board.get("b") && this.board.get("c")){
            return 'a';
        }
        return 0;
    }
    public char secondRowWin(HashMap<String, Boolean> playerBoard){
        if (this.board.get("d") && this.board.get("e") && !playerBoard.get("f")){
            return 'f';
        } else if (this.board.get("d") && !playerBoard.get("e") && this.board.get("f")){
            return 'e';
        } else if (!playerBoard.get("d") && this.board.get("e") && this.board.get("f")){
            return 'd';
        }
        return 0;
    }

    public char thirdRowWin(HashMap<String, Boolean> playerBoard){
        if (this.board.get("g") && this.board.get("h") && !playerBoard.get("i")){
            return 'i';
        } else if (this.board.get("g") && !playerBoard.get("h") && this.board.get("i")){
            return 'h';
        } else if (!playerBoard.get("g") && this.board.get("h") && this.board.get("i")){
            return 'g';
        }
        return 0;
    }

    public char firstColumnWin(HashMap<String, Boolean> playerBoard){
        if (this.board.get("a") && this.board.get("d") && !playerBoard.get("g")){
            return 'g';
        } else if (this.board.get("a") && !playerBoard.get("d") && this.board.get("g")){
            return 'd';
        } else if (!playerBoard.get("a") && this.board.get("d") && this.board.get("g")){
            return 'a';
        }
        return 0;
    }
    public char secondColumnWin(HashMap<String, Boolean> playerBoard){
        if (this.board.get("b") && this.board.get("e") && !playerBoard.get("h")){
            return 'h';
        } else if (this.board.get("b") && !playerBoard.get("e") && this.board.get("h")){
            return 'e';
        } else if (!playerBoard.get("b") && this.board.get("e") && this.board.get("h")){
            return 'b';
        }
        return 0;
    }
    public char thirdColumnWin(HashMap<String, Boolean> playerBoard){
        if (this.board.get("c") && this.board.get("f") && !playerBoard.get("i")){
            return 'i';
        } else if (this.board.get("c") && !playerBoard.get("f") && this.board.get("i")){
            return 'f';
        } else if (!playerBoard.get("c") && this.board.get("f") && this.board.get("i")){
            return 'c';
        }
        return 0;
    }

    public char diagonalsWin(HashMap<String, Boolean> playerBoard) {
        if (this.board.get("a") && this.board.get("e") && !playerBoard.get("i")){
            return 'i';
        } else if (this.board.get("a") && !playerBoard.get("e") && this.board.get("i")){
            return 'e';
        } else if (!playerBoard.get("a") && this.board.get("e") && this.board.get("i")){
            return 'a';
        } else if (this.board.get("c") && this.board.get("e") && !playerBoard.get("g")){
            return 'g';
        } else if (this.board.get("c") && !playerBoard.get("e") && this.board.get("g")){
            return 'e';
        } else if (!playerBoard.get("c") && this.board.get("e") && this.board.get("g")){
            return 'c';
        }
        return 0;
    }

    public char randomTurn(X_or_O game){
        Log.d("Game Action Choose" , "Random");
        int c = new Random().nextInt(game.board.size());
        return game.board.get(c).charAt(0);
    }
}
