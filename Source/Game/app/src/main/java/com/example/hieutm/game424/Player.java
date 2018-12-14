package com.example.hieutm.game424;

import java.io.Serializable;

public class Player implements Serializable {
    private int
            id,
            score;
    private String
            name;

    public Player(){}

    public Player(int id,String name,int score){
        this.name=name;
        this.score=score;
        this.id=id;
    }

    public int getID(){
        return id;
    }

    public void setID(int ID){
        this.id=ID;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score=score;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }


    @Override
    public String toString() {
        return this.name;
    }
}
