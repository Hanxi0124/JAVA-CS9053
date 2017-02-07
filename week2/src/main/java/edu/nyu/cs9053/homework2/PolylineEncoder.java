//package Test;
package edu.nyu.cs9053.homework2;
public class PolylineEncoder{
String ans=""; //This is the final output of this program.
int integer=0;
double lattemp=0;   //to take diff in latitude value each time
double longtemp=0;  //diff in longitude value


public String encodePolyline(Gps[] gpsPoints) {
    for(int i=0;i<gpsPoints.length;i++){
        integer = (int)Math.round(((gpsPoints[i].getLatitude())-lattemp) * 100000.0);
        lattemp=gpsPoints[i].getLatitude();
        ans=ans+(asc(fiveBitsChunk(binary(integer))));
        integer = (int)Math.round(((gpsPoints[i].getLongitude())-longtemp) * 100000.0);
        longtemp=gpsPoints[i].getLongitude();
        ans=ans+(asc(fiveBitsChunk(binary(integer))));
    }
    return ans;
 }

//This method returns the Decimal equivalent of the shifted form Convert.
    static int binary(int value) {
       if (value < 0) { //2 complement if the value is negative
           value = (~(-value)) + 1; //1 complement
           value = value << 1; //right shift by 1
           value = ~value; //invert the bits
       }
       else
           value = value << 1;

       return value;
   }

   static int[] fiveBitsChunk(int value) {
    int highest  = Integer.SIZE - Integer.numberOfLeadingZeros(value);
    int[] output = new int[(int)((double)highest / 5 + 0.99)];
    int mask     = Integer.parseInt("11111", 2);//convert the string representation of base 2 into its decimal equv.
    for (int i = 0; i < output.length; ++i) {
        if (i == output.length - 1)
            output[i] = (value & mask) + 63;
        else
            output[i] = ((value & mask) | 0x20) + 63;

        value = value >> 5;
    }

    return output;
}
static String asc(int[] values) {
       StringBuilder sb = new StringBuilder(values.length);
       for (int i : values)
           sb.append((char)i);

       return sb.toString();
   }

}
