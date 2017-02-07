package edu.nyu.cs9053.homework2;
//package Test;
public class Program {

    public static void main(String[] args) {
        String ans="";
        AnnuityCalculator annuity=new AnnuityCalculator();
        PolylineEncoder poly=new PolylineEncoder();
        if ((!args[0].equals("annuity")) && (!args[0].equals("gps")))
        {
            System.out.println("Invalid argument");
            System.exit(0);
        }
        else{
            if(args[0].equals("gps")){
            int size=(args.length)-1;
            Gps[] gp=new Gps[size]; //1 box is filled by "gps"
            for(int i=1;i<args.length;i++){
                String[] latlong=args[i].split(",");
                double lat=Double.parseDouble(latlong[0]);
                double lng=Double.parseDouble(latlong[1]);
                gp[i-1]=new Gps(lat,lng);
            }
            ans=poly.encodePolyline(gp);
            System.out.println(ans);
            System.exit(0);
            }
            else if(args[0].equals("annuity")){//put else
                if (args.length<4){
                    System.out.println("Invalid argument");
                    System.exit(0);
                }
                else if(args.length==4){
                    if(args[3].equals("15")){
                        double value1 = Double.parseDouble(args[1]);
                        double value2 = Double.parseDouble(args[2]);
                        System.out.println(annuity.computeFutureValueOfAnnuityIn15Years(value1,value2));
                        System.exit(0);
                    }
                    else if(args[3].equals("30")){
                        double value1 = Double.parseDouble(args[1]);
                        double value2 = Double.parseDouble(args[2]);
                        System.out.println(annuity.computeFutureValueOfAnnuityIn30Years(value1,value2));
                        System.exit(0);
                    }
                    else{
                        double value1 = Double.parseDouble(args[1]);
                        double value2 = Double.parseDouble(args[2]);
                        Integer value3 = Integer.valueOf(args[3]);
                        System.out.println(annuity.computeFutureValueOfAnnuity(value1,value2,value3));
                        System.exit(0);
                    }

                }
                else if(args[1].equals("compound") && args.length==5){
                    if(args[4].equals("15")){
                        double value1 = Double.parseDouble(args[2]);
                        double value2 = Double.parseDouble(args[3]);
                        System.out.println(annuity.computeMonthlyCompoundedFutureValueOfAnnuityIn15Years(value1,value2));
                        System.exit(0);
                    }
                    else if(args[4].equals("30")){
                        double value1 = Double.parseDouble(args[2]);
                        double value2 = Double.parseDouble(args[3]);
                        System.out.println(annuity.computeMonthlyCompoundedFutureValueOfAnnuityIn30Years(value1,value2));
                        System.exit(0);
                    }
                    else{
                        double value1 = Double.parseDouble(args[2]);
                        double value2 = Double.parseDouble(args[3]);
                        Integer value3 = Integer.valueOf(args[4]);
                        System.out.println(annuity.computeMonthlyCompoundedFutureValueOfAnnuity(value1,value2,value3));
                        System.exit(0);

                }
            }
            else{
                System.out.println("Invalid argument");
                System.exit(0);
            }

        }

        }
    }

}
