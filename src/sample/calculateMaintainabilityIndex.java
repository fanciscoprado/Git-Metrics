package sample;

import java.io.*;
import java.lang.Math;

//NEEDS FOLLOWING TO CALCULATE: halstead volume, cyclomatic complexity, count of source lines of code.
// Original formula: MI = 171 - 5.2 * ln(V) - 0.23 * (G) - 16.2 * ln(LOC)
// Microsoft Visual Studio formula: MI = MAX(0,(171 - 5.2 * ln(Halstead Volume) - 0.23 * (Cyclomatic Complexity) - 16.2 * ln(Lines of Code))*100 / 171)

//Formula(s) for calculating maintainability index found here: http://www.projectcodemeter.com/cost_estimation/help/GL_maintainability.htm

public class calculateMaintainabilityIndex {
    //Information that may or may not be implemented in output in the future.
    //Value 1-100, higher = better
    //20-100 = good
    //10-19 = moderate
    //0-9 = low
    public double calculateMI(File file){
        double mI = 1;
        Math.sqrt(1); //added temporarily to fix error
        //mI = 171-5.2 * Math.log(V) - 0.23 * (CC) - 16.2 * Math.log(SLOC);
        //mI = MAX(0, (171-5.2 * Math.log(V) - 0.23 * (CC) - 16.2 * Math.log(SLOC)) * 100 / 171);
        return mI;
    }
}
