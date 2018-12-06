package sample.halstead;

import org.eclipse.jgit.util.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VocabConstructor
{
    //collects operators and their positional information
    private ArrayList<halsteadOperator> vocabList = new ArrayList<>();

    //Fills vocabList with operators - reads from a built-in list right now but should read from a file later.
    private void addVocabElement(String[] operatorList)
    {
        halsteadOperator temp = new halsteadOperator();
        String s;
        for (int index = 0; index < operatorList.length; index++) {
            //halsteadOperator has three elements. The String array being read from stores them in this order:
            //name, if its a prefix and if its a postfix
            s = operatorList[index];
            System.out.print(s);
            if(index % 3 == 0)
            {
                temp = new halsteadOperator();
                temp.setOperatorName(s);
            }
            if((index - 1) % 3 == 0) {
                if (s.equals("0"))
                    temp.setPrefixFlag(false);
                else
                    temp.setPrefixFlag(true);
            }
            if((index - 2) % 3 == 0) {
                if (s.equals("0"))
                    temp.setSuffixFlag(false);
                else
                    temp.setSuffixFlag(true);
                vocabList.add(temp);
            }
        }
        System.out.println();
    }

    private String[] readFile(File file)throws Exception
    {
        FileReader reader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(reader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bReader.readLine()) != null){
            String[] splited = line.split("\\s+");
            for (String s : splited) {
                lines.add(s);
            }
        }
        bReader.close();
        reader.close();
        return lines.toArray(new String[lines.size()]);
    }

    //made a main for testing, will delete later
    public void buildDefinitions()throws Exception{
        File folder = new File("HalLib");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            File file = listOfFiles[i];
            if (file.isFile() && file.getName().endsWith(".txt")) {
                String content = FileUtils.pathToString(file);
                String[] arr = this.readFile(file);
                System.out.println(content);
                //System.out.println(Arrays.toString(arr));
                addVocabElement(arr);
            }
        }
        /*String[] arr = dList.run();
        System.out.println(Arrays.toString(arr));*/
    }

    public ArrayList<halsteadOperator> getVocabList(){
        return vocabList;
    }

    //doesn't need a main - but it is good for testing
    public static void main(String[] args)throws Exception
    {
        VocabConstructor test = new VocabConstructor();
        test.buildDefinitions();
        for(int i = 0; i < test.vocabList.size(); i++){
            System.out.println(test.vocabList.get(i));
        }
    }
}