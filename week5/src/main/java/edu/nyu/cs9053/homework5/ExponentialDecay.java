package edu.nyu.cs9053.homework5;
public class ExponentialDecay implements TimeTraveler{

    private String travelerName="ExponentialTraveler";
    public static double STRENGHT_YEARS=100;
    private final double decayConstant;

    public ExponentialDecay(double decayConstantUser){
        this.decayConstant=decayConstantUser;
    }

    @Override public String getName(){
            return travelerName;
    }

    @Override public Double getRemainingYearsOfTravel(){
            return (STRENGHT_YEARS); //working here
    }

    @Override public void adjust(Time unit, int amount, boolean ahead){ //adjust TimeTraveler ability to travel
            if(unit==Time.Hours){
                STRENGHT_YEARS -= (int)(Math.round(STRENGHT_YEARS*Math.exp(-decayConstant*(amount/(24*365)))));
            }
            else if(unit==Time.Days){
                STRENGHT_YEARS -= (int)(Math.round(STRENGHT_YEARS*Math.exp(-decayConstant*(amount/365))));
            }
            else {
                System.out.println("Invalid Unit Input");
            }
    }


}
