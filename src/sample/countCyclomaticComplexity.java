package sample;

import java.io.*;
import java.util.*;

//Code from: https://github.com/amirjamil90/Cyclomatic-Complexity-/blob/master/Complexity.java used.
// Author: amirjamil90 March 15, 2015

public class countCyclomaticComplexity {
    public int checkForUniquePath(){
        int complexity = 1;
        String fileName;
        String[]keywords = {"if","else","while","case","for","switch","do","continue","break",
                "&&","||","?",":","catch","finally","throw","throws","return",};
        String words = "";
        String line = null;
        try{
            fileName = "GetFiles.java";
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return (complexity);
    }
}
