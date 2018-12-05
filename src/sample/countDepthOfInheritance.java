package sample;

//experimental class, don't know if this will work properly. DoI will follow CC algorithm

import java.io.*;
import java.util.*;

public class countDepthOfInheritance {
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
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return (inheritance);
    }
}
