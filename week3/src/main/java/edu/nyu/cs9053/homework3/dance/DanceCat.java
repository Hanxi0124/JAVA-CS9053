package edu.nyu.cs9053.homework3.dance;
import java.lang.*;
import java.util.*;
public class DanceCat{
    private static final String DEFAULT_NAME="asdfg";

    //Method to Parse the String. This has been called in first constructor.
    public static String[] parsedMove(String unparsedMoves){
        String[] parsedMoves=new String[18];
        for(int i=0;i<unparsedMoves.length();i++){
            parsedMoves[i]=Character.toString(unparsedMoves.charAt(i));
        }
        for(int j=unparsedMoves.length();j<18;j++){
            parsedMoves[j]="";
        }
        return parsedMoves;
    }

    public static DanceMove[] createDanceMoveObject(String[] moves,String[] idealMoves){
        DanceMove[] danceMoveObjects=new DanceMove[18];
        for(int i=0;i<18;i++){
            danceMoveObjects[i]=new DanceMove(moves[i],idealMoves[i]);
        }
        return danceMoveObjects;
    }

    //A static method returning a value between 0 - 100 which controls the competitor cat's skill level.
    public static int getComputerLevel(){
        Random rand = new Random();
        return(rand.nextInt(100));
    }

    private final String name;
    private final DanceMove[] danceMoves;

//constructor-1
public DanceCat(String unparsedMoves,String[] idealMoves){
    this(parsedMove(unparsedMoves),idealMoves);
    }

//constructor-2
public DanceCat(String[] moves,String[] idealMoves){
    this(createDanceMoveObject(moves,idealMoves));
}

//constructor-3
public DanceCat(DanceMove[] danceMoves){
    this(DEFAULT_NAME,danceMoves);
}

//constructor-4
public DanceCat(String name,DanceMove[] danceMoves){
    this.name=name;
    this.danceMoves=danceMoves;
}

//a getter returning the name
public String getName(){
    return name;
}

//a getter returning the danceMoves
public DanceMove[] getDanceMoves(){
    return danceMoves;
}

//counts the number of correct moves. It has something to do with correct moves in DanceMove class
public int getNumberOfCorrectMoves(){
    int numberOfCorrectMoves=0;
    for(int i=0;i<17;i++){
        if(danceMoves[i].correctMove()==true){
            numberOfCorrectMoves++;
        }
    }
    return numberOfCorrectMoves;
}
}
