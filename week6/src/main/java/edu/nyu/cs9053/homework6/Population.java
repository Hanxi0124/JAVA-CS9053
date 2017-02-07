package edu.nyu.cs9053.homework6;

/**
 * User: blangel
 * Date: 10/5/14
 * Time: 6:57 PM
 */
public class Population {

    // will be created by first running - java edu.nyu.cs9053.homework6.SpreadEpidemic




    @Infection(cause = Disease.SmallPox) public String getInfectedSmallPox() {
        return "e3182d26-e9d7-49d1-8d8b-1da05b03646a60d1aa07-1f57-4189-b79b-619e6b772060111150dfcf46-eb41-434a-abeb-496a24f9b778";
    }

    @Infection(cause = Disease.Ebola) public String getInfectedEbola() {
        return "00114f4f14b0-7e79-4fbc-8c4e-57de667c4d411d2f234c-d3b5-4323-b7fe-11d62055321050201ed5-a204-4cb6-a324-1f988a18f021";
    }

    @Infection(cause = Disease.Sars) public String getInfectedSars() {
        return "8dd95144-8f71-45dc-ae69-0d6a7ed56bc5d1a4505c-df11-4db6-9616-e8df479ed69601119bfbfeeb-0785-4c23-9e80-ff10d2fde1c7";
    }

    @Infection(cause = Disease.H1N1) public String getInfectedH1N1() {
        return "76184b5d-76f3-4887-bee2-35b8188ff8ea1100110111100000114ac27548-4481-49c6-b021-ebc17a2598c6d87c76cc-aef5-4171-9701-d657ce1ddb6f";
    }


}
