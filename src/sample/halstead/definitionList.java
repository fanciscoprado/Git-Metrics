package sample.halstead;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class definitionList {
    public String[] run()throws Exception
    {
        FileReader reader = new FileReader("HalLib/basicOperator.txt");
        BufferedReader bReader = new BufferedReader(reader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bReader.readLine()) != null){
            lines.add(line);
        }
        bReader.close();
        return lines.toArray(new String[lines.size()]);
    }

    //made a main for testing, will delete later
    public static void main(String[] args)throws Exception{
        definitionList dList= new definitionList();
        String[] arr = dList.run();
        System.out.println(Arrays.toString(arr));
    }


}
