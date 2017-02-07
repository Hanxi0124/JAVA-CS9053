package edu.nyu.cs9053.homework3.dance;
public class DanceMove{
    String idealMove;
    String userMove;

    //constructor
    public DanceMove(String userMove,String idealMove){
        this.userMove=userMove;
        this.idealMove=idealMove;
    }

    //getter Method
    public String getIdealMove(){
        return idealMove;
    }

    //getter metahod
    public String getUserMove(){
        return userMove;
    }

    //Method to return true or false, this helps in counting.
    public boolean correctMove(){
        if(getUserMove().equals(getIdealMove())){
            return true;
        }
        else{
            return false;
        }
    }

}
