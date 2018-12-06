package sample.halstead;

import org.eclipse.jgit.util.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class definitionList {
    public String[] run(File file)throws Exception
    {
        FileReader reader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(reader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bReader.readLine()) != null){
            lines.add(line);
        }
        bReader.close();
        reader.close();
        return lines.toArray(new String[lines.size()]);
    }

    //made a main for testing, will delete later
    public static void main(String[] args)throws Exception{
        definitionList dList= new definitionList();
        File folder = new File("HalLib");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            File file = listOfFiles[i];
            if (file.isFile() && file.getName().endsWith(".txt")) {
                String content = FileUtils.pathToString(file);
                String[] arr = dList.run(file);
                System.out.println(content);
                System.out.println(Arrays.toString(arr));
            }
        }
        /*String[] arr = dList.run();
        System.out.println(Arrays.toString(arr));*/
    }
}