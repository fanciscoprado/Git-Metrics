package sample;

import java.io.*;
import java.util.*;

//Algorithm to calculate Cyclomatic Complexity from: https://github.com/amirjamil90/Cyclomatic-Complexity-/blob/master/Complexity.java
// Author: amirjamil90 March 15, 2015

public class countCyclomaticComplexity {
    //Information that may or may not be implemented in output in the future.
    //CC <10 = easy to maintain; normal program
    //CC 11-20 = harder to maintain; moderate
    //CC 21+ = consider refactoring/redesigning; risky
    //CC 50+ = unstable, high chance for errors
    public int checkForUniquePath(File file){
        int complexity = 1;
        String[] keywords = {"if", "else", "while", "case", "for", "switch", "do", "continue", "break", "&&", "||", "?", ":", "catch", "finally", "throw", "throws", "return", /*"set", "get"*/};
        String words = "";        //temp variable to hold value of token
        String line = null;
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            while (line != null)
            {
                StringTokenizer stTokenizer = new StringTokenizer(line);
                while (stTokenizer.hasMoreTokens())
                {
                    words = stTokenizer.nextToken();
                    for (int i = 0; i < keywords.length; i++)
                    {
                        if (keywords[i].equals(words))        //compares token (words) to see if it is a keyword
                        {
                             complexity++;
                        }
                    }
                }
            line = br.readLine();
            }
            fr.close();
            br.close();
        } catch (IOException e) {
           e.printStackTrace();
        }

        return complexity;
    }
}