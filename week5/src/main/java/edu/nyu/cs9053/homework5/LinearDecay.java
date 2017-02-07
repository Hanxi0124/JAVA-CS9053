package edu.nyu.cs9053.homework5;
public class LinearDecay implements TimeTraveler{

    private String travelerName="LinearTraveler";
    public static double STRENGHT_YEARS=100;
    
    @Override public String getName(){
            return travelerName;
    }

    @Override public Double getRemainingYearsOfTravel(){
            return (STRENGHT_YEARS);
    }

    @Override public void adjust(Time unit, int amount, boolean ahead){
            if(unit==Time.Hours){
                STRENGHT_YEARS -= amount/(24*365);
            }
            else if(unit==Time.Days){
                STRENGHT_YEARS -= amount/365;
            }
            else {
                System.out.println("Invalid Input");
            }
    }


}
