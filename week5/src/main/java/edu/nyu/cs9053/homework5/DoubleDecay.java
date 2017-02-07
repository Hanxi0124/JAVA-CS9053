package edu.nyu.cs9053.homework5;
public class DoubleDecay implements TimeTraveler{

    private String travelerName="DoubleTraveler";
    public static double STRENGHT_YEARS=100;

    @Override public String getName(){
            return travelerName;
    }

    @Override public Double getRemainingYearsOfTravel(){
            return (STRENGHT_YEARS); //working here
    }

    @Override public void adjust(Time unit, int amount, boolean ahead){ //adjust TimeTraveler ability to travel
            if(unit==Time.Hours){
                STRENGHT_YEARS -= 2*amount/(24*365);
            }
            else if(unit==Time.Days){
                STRENGHT_YEARS -= 2*amount/365;
            }
            else {
                System.out.println("Invalid Unit Input");
            }
    }


}
