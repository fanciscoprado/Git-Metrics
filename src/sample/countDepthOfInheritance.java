package sample;

//experimental class, don't know if this will work properly. DoI will follow CC algorithm.

import java.io.*;
import java.util.*;

public class countDepthOfInheritance {
    //Information that may or may not be implemented in output in the future. Depth of Inheritance of this class: 1.
    //Counter is the depth.
    //Low implies less complexity, less possibility for code reuse.
    //High implies higher complexity, more possibility for code reuse. Higher chance for errors.
    public int checkForInheritance (){
        int inheritance = 1;
        String fileName;
        String[]keywords = {"class"};
        String words = "";        //temp variable to hold value of token
        String line = null;
        try
        {
            fileName = "GetFiles.java";
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            while (line != null)
            {
                StringTokenizer stTokenizer = new StringTokenizer(line);
                while (stTokenizer.hasMoreTokens())
                {
                    words = stTokenizer.nextToken();
                    for(int i=0; i<keywords.length; i++)
                    {
                        if(keywords[i].equals(words))        //compares token (words) to see if it is keyword
                        {
                            inheritance++;
                        }
                    }
                }
                line = br.readLine();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return (inheritance);
    }
}
