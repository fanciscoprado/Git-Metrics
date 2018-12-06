package sample.halstead;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class definitionList {
    public String[] run()throws Exception
    {
        FileReader reader = new FileReader("test.txt");
        BufferedReader bReader = new BufferedReader(reader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bReader.readLine()) != null){
            lines.add(line);
        }
        bReader.close();
        return lines.toArray(new String[lines.size()]);
    }
}
