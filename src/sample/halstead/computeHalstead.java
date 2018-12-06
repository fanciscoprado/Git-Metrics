package sample.halstead;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class computeHalstead {

    final char[] HALF_OPERATOR = {'=', '+', '-', '*', '/', '%','!', '>', '<', '&', '|', '?', '~', '^', ':', '@', '_'};

    //collects all relevant elements for Halstead metrics
    ArrayList<String> codeList = new ArrayList<>();

    public void compute(File currentFile)throws Exception
    {
        buildCodeList(currentFile);
        //needs to do a lot more than this
        //it needs a vocab list from vocab constructor
        //it needs to compare elements from the codeList to the vocab list and delegate operator or operand status
        //      to individual elements -- or call another method to that.
        //this class as a whole needs to be able to calculate n1, n2, N1 and N2
        //calculating secondary and tertiary stats will likely be this classes job as well
    }

    //Creates an indexed list of all the elements from stream tokenizer
    private void buildCodeList(File currentFile)throws Exception
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
}
