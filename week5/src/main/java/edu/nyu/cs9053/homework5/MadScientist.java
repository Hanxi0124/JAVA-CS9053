package edu.nyu.cs9053.homework5;

/**
 * User: blangel
 * Date: 9/21/14
 * Time: 6:01 PM
 */
public class MadScientist{

    private final TimeMachine timeMachine;


    public MadScientist(TimeMachine timeMachine) {
        this.timeMachine = timeMachine;
    }

    public static void main(String[] args) {

        MadScientist madScientist = new MadScientist (new TimeMachine());
        LinearDecay linearDecay = new LinearDecay();
        DoubleDecay doubleDecay = new DoubleDecay();
        ExponentialDecay exponentialDecay= new ExponentialDecay(0.05);

        while(linearDecay.getRemainingYearsOfTravel()>0 || doubleDecay.getRemainingYearsOfTravel()>0 || exponentialDecay.getRemainingYearsOfTravel()>0){

            madScientist.experiment(linearDecay);
            madScientist.experiment(doubleDecay);
            madScientist.experiment(exponentialDecay);
        }
    }

    public void experiment(TimeTraveler timeTraveler) {

            timeMachine.travel(timeTraveler,new TimeTravelCallback(){
                @Override
                public void leaped(Time unit, int amount, boolean ahead){
                    if(timeTraveler.getRemainingYearsOfTravel()>0){
                        timeTraveler.adjust(unit,amount,ahead);
                        System.out.println(timeTraveler.getName()+" travels for "+amount+" "+unit+" "+(ahead ? "back. " : "ahead. "));
                    }
                }
            });
}
}
