package com.example.admin.game;

import java.io.Serializable;

public class Player implements Serializable {
    private int
            id,
            score,
            rank;
    private String
            name;

    public Player(){}

    public Player(String name,int score){
        this.name=name;
        this.score=score;
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

    public void setRank(int rank){
        this.rank=rank;
    }

    public int getRank(){
        return rank;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setScore(int score){
        this.score=score;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
