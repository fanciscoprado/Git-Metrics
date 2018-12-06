package sample.halstead;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class codeList {

    final char[] HALF_OPERATOR = {'=', '+', '-', '*', '/', '%','!', '>', '<', '&', '|', '?', '~', '^', ':', '@', '_'};

    //collects all relevant elements for Halstead metrics
    private ArrayList<String> codeList = new ArrayList<>();

    //Creates an indexed list of all the elements from stream tokenizer
    public void setCodeList(File currentFile)throws Exception
    {
        BufferedReader readFile = new BufferedReader(new FileReader(currentFile));
        StreamTokenizer fileStream = new StreamTokenizer(readFile);
        char tempChar;
        StringBuilder tempString = new StringBuilder();
        fileStream.slashStarComments(true);
        while(fileStream.nextToken() != fileStream.TT_EOF){
            if(fileStream.sval==null){
                tempChar = (char)fileStream.ttype;
                for (int i = 0; i < HALF_OPERATOR.length; i++) {
                    if(HALF_OPERATOR[i] == tempChar) {
                        tempString.append(tempChar);
                        break;
                    }
                    if((i+1)==HALF_OPERATOR.length){
                        if(tempString.length() > 0){
                            codeList.add(tempString.toString());
                            tempString = new StringBuilder();
                        }
                    }
                }
            } else {
                if(tempString.length() > 0){
                    codeList.add(tempString.toString());
                    tempString = new StringBuilder();
                }
                codeList.add(fileStream.sval);
            }
        }
        readFile.close();
    }

    public ArrayList<String> getCodeList(){
        return codeList;
    }
}
