package edu.nyu.cs9053.homework2;
//package Test;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class AnnuityCalculator {

    private static final int DEFAULT_SCALE = 10;

    private static final RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_UP;

    public static BigDecimal computeFutureValueOfAnnuityIn15Years(double annuityAmount, double annualInterestRateInPercent) {
        annualInterestRateInPercent=annualInterestRateInPercent/100;
        String annuityAmountString=Double.toString(annuityAmount);
        String annualInterestRateInPercentString=Double.toString(annualInterestRateInPercent);
        BigDecimal p=new BigDecimal(annuityAmountString);
        BigDecimal r=new BigDecimal(annualInterestRateInPercentString);
        int t=15;
        BigDecimal calstep1=(r.add(new BigDecimal("1")));
        BigDecimal calstep2=(calstep1.pow(t));
        BigDecimal calstep3=(calstep2.subtract(new BigDecimal("1")));
        BigDecimal calstep4=(calstep3.divide(r,DEFAULT_SCALE,DEFAULT_ROUNDING_MODE));
        return ((p.multiply(calstep4)).setScale(10));
    }

    public static BigDecimal computeFutureValueOfAnnuityIn30Years(double annuityAmount, double annualInterestRateInPercent) {
        String annuityAmountString=Double.toString(annuityAmount);
        annualInterestRateInPercent=annualInterestRateInPercent/100;
        String annualInterestRateInPercentString=Double.toString(annualInterestRateInPercent);
        BigDecimal p=new BigDecimal(annuityAmountString);
        BigDecimal r=new BigDecimal(annualInterestRateInPercentString);
        int t=30;
        BigDecimal calstep1=(r.add(new BigDecimal("1")));
        BigDecimal calstep2=(calstep1.pow(t));
        BigDecimal calstep3=(calstep2.subtract(new BigDecimal("1")));
        BigDecimal calstep4=(calstep3.divide(r,DEFAULT_SCALE,DEFAULT_ROUNDING_MODE));
        return ((p.multiply(calstep4)).setScale(10));

    }

    public static BigDecimal computeMonthlyCompoundedFutureValueOfAnnuityIn15Years(double annuityAmount, double annualInterestRateInPercent) {
        annualInterestRateInPercent=annualInterestRateInPercent/100;
        BigDecimal m=new BigDecimal("12");
        String annuityAmountString=Double.toString(annuityAmount);
        String annualInterestRateInPercentString=Double.toString(annualInterestRateInPercent);
        BigDecimal p=new BigDecimal(annuityAmountString);
        BigDecimal r=new BigDecimal(annualInterestRateInPercentString);
        BigDecimal ttcopy=new BigDecimal("15");
        BigDecimal calstep1=r.divide(m,DEFAULT_SCALE,DEFAULT_ROUNDING_MODE);
        BigDecimal calstep2=calstep1.add(new BigDecimal("1"));
        BigDecimal calstep3=m.multiply(ttcopy);
        int power = calstep3.intValue();
        BigDecimal calstep4=calstep2.pow(power);
        BigDecimal calstep5=calstep4.subtract(new BigDecimal("1"));
        BigDecimal calstep6=calstep5.divide(calstep1,DEFAULT_SCALE,DEFAULT_ROUNDING_MODE);
        return ((p.multiply(calstep6)).setScale(10));
    }

    public static BigDecimal computeMonthlyCompoundedFutureValueOfAnnuityIn30Years(double annuityAmount, double annualInterestRateInPercent) {
        annualInterestRateInPercent=annualInterestRateInPercent/100;
        BigDecimal m=new BigDecimal("12");
        String annuityAmountString=Double.toString(annuityAmount);
        String annualInterestRateInPercentString=Double.toString(annualInterestRateInPercent);
        BigDecimal p=new BigDecimal(annuityAmountString);
        BigDecimal r=new BigDecimal(annualInterestRateInPercentString);
        int t=30;
        BigDecimal ttcopy=new BigDecimal("30");
        BigDecimal calstep1=r.divide(m,DEFAULT_SCALE,DEFAULT_ROUNDING_MODE);
        BigDecimal calstep2=calstep1.add(new BigDecimal("1"));
        BigDecimal calstep3=m.multiply(ttcopy);
        int power = calstep3.intValue();
        BigDecimal calstep4=calstep2.pow(power);
        BigDecimal calstep5=calstep4.subtract(new BigDecimal("1"));
        BigDecimal calstep6=calstep5.divide(calstep1,DEFAULT_SCALE,DEFAULT_ROUNDING_MODE);
        return ((p.multiply(calstep6)).setScale(10));
    }

    public static BigDecimal computeFutureValueOfAnnuity(double annuityAmount, double annualInterestRateInPercent, int years) {
        annualInterestRateInPercent=annualInterestRateInPercent/100;
        String annuityAmountString=Double.toString(annuityAmount);
        String annualInterestRateInPercentString=Double.toString(annualInterestRateInPercent);
        BigDecimal p=new BigDecimal(annuityAmountString);
        BigDecimal r=new BigDecimal(annualInterestRateInPercentString);
        int t=years;
        BigDecimal calstep1=(r.add(new BigDecimal("1")));
        BigDecimal calstep2=(calstep1.pow(t));
        BigDecimal calstep3=(calstep2.subtract(new BigDecimal("1")));
        BigDecimal calstep4=(calstep3.divide(r,DEFAULT_SCALE,DEFAULT_ROUNDING_MODE));
        return ((p.multiply(calstep4)).setScale(10));

    }

    public static BigDecimal computeMonthlyCompoundedFutureValueOfAnnuity(double annuityAmount, double annualInterestRateInPercent, int years) {
        annualInterestRateInPercent=annualInterestRateInPercent/100;
        BigDecimal m=new BigDecimal("12");
        String annuityAmountString=Double.toString(annuityAmount);
        String annualInterestRateInPercentString=Double.toString(annualInterestRateInPercent);
        BigDecimal p=new BigDecimal(annuityAmountString);
        BigDecimal r=new BigDecimal(annualInterestRateInPercentString);
        int t=years;
        BigDecimal ttcopy = new BigDecimal(t);
        BigDecimal calstep1=r.divide(m,DEFAULT_SCALE,DEFAULT_ROUNDING_MODE);
        BigDecimal calstep2=calstep1.add(new BigDecimal("1"));
        BigDecimal calstep3=m.multiply(ttcopy);
        int power = calstep3.intValue();
        BigDecimal calstep4=calstep2.pow(power);
        BigDecimal calstep5=calstep4.subtract(new BigDecimal("1"));
        BigDecimal calstep6=calstep5.divide(calstep1,DEFAULT_SCALE,DEFAULT_ROUNDING_MODE);
        return ((p.multiply(calstep6)).setScale(10));
    }

}
