package sample.halstead;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class vocabularyList
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

    //collects elements of a txt file into an array
    private String[] readFile(File file)throws Exception
    {
        FileReader reader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(reader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bReader.readLine()) != null){
            lines.addAll(Arrays.asList(line.split("\\s+")));
        }
        bReader.close();
        reader.close();
        return lines.toArray(new String[lines.size()]);
    }

    public void setVocabList(String path)throws Exception
    {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        try {
            for (int i = 0; i < listOfFiles.length; i++) {
                File file = listOfFiles[i];
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    String[] arr = this.readFile(file);
                    addVocabElement(arr);
                }
            }
        } catch (NullPointerException e){
            //catches null but doesn't throw anything yet
        }
    }

    public ArrayList<halsteadOperator> getVocabList(){
        return vocabList;
    }

    public boolean isOperator(String name){
        for (halsteadOperator h : vocabList) {
            if(h.getOperatorName().equals(name))
                return true;
        }
        return false;
    }

    //doesn't need a main - but it is good for testing
    /*public static void main(String[] args)throws Exception
    {
        vocabularyList test = new vocabularyList();
        test.buildDefinitions("HalLib");
        for(int i = 0; i < test.vocabList.size(); i++){
            System.out.println(test.vocabList.get(i));
        }
    }*/
}