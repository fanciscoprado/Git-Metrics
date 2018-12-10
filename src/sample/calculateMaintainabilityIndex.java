package sample;

import java.io.*;
import java.lang.Math;

// Original formula: MI = 171 - 5.2 * ln(V) - 0.23 * (G) - 16.2 * ln(LOC)
//                   mI = 171-5.2 * Math.log(V) - 0.23 * (CC) - 16.2 * Math.log(SLOC);

//Formula(s) for calculating maintainability index found here: http://www.projectcodemeter.com/cost_estimation/help/GL_maintainability.htm

public class calculateMaintainabilityIndex {
    //Information that may or may not be implemented in output in the future.
    //Value 1-100, higher = better
    //20-100 = good
    //10-19 = moderate
    //0-9 = low
    public double calculateMI(DataCollected dataCollected){
        double mI = 1.0;

        mI = 171-5.2 * Math.log(Float.valueOf(dataCollected.getVolume())) - 0.23 * (dataCollected.getCyclomaticcomplexity()) - 16.2 * Math.log(dataCollected.getSlcount());
        return mI;
    }
}