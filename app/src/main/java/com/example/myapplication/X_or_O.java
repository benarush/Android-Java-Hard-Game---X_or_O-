package com.example.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class X_or_O {
    List<String> board= new ArrayList<>();
    int turns = 0;

    public X_or_O(){
        setBoard(board);
    }
    static public void setBoard(HashMap<String, Boolean> board){
        char c = 'a';
        for (int i = 1 ; i < 10 ; i++ , c++) {
            board.put(String.valueOf(c), false);
        }
    }
    static public void setBoard(List<String> board){
        char c = 'a';
        for (int i = 1; i < 10; i++, c++) {
            board.add(String.valueOf(c));
        }
    }


}
