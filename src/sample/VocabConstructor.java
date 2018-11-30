package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class VocabConstructor
{
    File currentFile = new File("src/sample/Halstead.java");
    Set<halsteadOperator> vocabSet = new HashSet<>();           //collects operators and their positions
    ArrayList<String> codeList;                                 //collects all relevant elements for Halstead metrics

    //Fills vocabSet with operators - reads from a built-in list right now but should read from a file later.
    public void setVocab()
    {
        final String[] FULL_OPERATOR = {"=", "0", "0", "==", "0", "0", "+", "0", "0", "++", "0", "1", "+=", "0", "0"
                , "-", "0", "0", "--", "0", "1", "-=", "0", "0", "*", "0", "0", "*=", "0", "0", "/", "0", "0", "/="
                , "0", "0", "%", "0", "0", "%=", "!", "0", "0", "!=", "0", "0", ">", "0", "0", ">=", "0", "0", ">>"
                , "0", "0", ">>>", "0", "0", "<", "0", "0", "<=", "0", "0", "<<", "0", "0", "&", "0", "0", "&&", "0"
                , "0", "&=", "0", "0", "|", "0", "0", "||", "0", "0", "|=", "0", "0", "?:", "0", "0", "~", "1", "0"
                , "^", "0", "0", "^=", "0", "0"};
        int index = -1;
        halsteadOperator temp = new halsteadOperator();
        for (String c : FULL_OPERATOR) {
            //halsteadOperator has three elements. The String array being read from stores them in this order:
            index++;
            if(index % 3 == 0)
                temp.operatorName = c;
            if((index - 1) % 3 == 0) {
                if (c.equals("0"))
                    temp.prefixFlag = false;
                else
                    temp.prefixFlag = true;
            }
            if((index - 2) % 3 == 0) {
                if (c.equals("0"))
                    temp.postfixFlag = false;
                else
                    temp.postfixFlag = true;
                vocabSet.add(temp);
            }
        }
    }

    //Creates an indexed list of all the elements from stream tokenizer
    public void buildCodeList()throws Exception
    {
        BufferedReader readFile = new BufferedReader(new FileReader(currentFile));
        StreamTokenizer fileStream = new StreamTokenizer(readFile);
        fileStream.slashStarComments(true);
        while(fileStream.nextToken() != fileStream.TT_EOF){
            System.out.println(fileStream.toString());
        }
    }

    //Creates operators out of tokenized elements
    public void buildOperator()
    {
    }
}

//Data class: defines and identifies operators
class halsteadOperator
{
    boolean prefixFlag;
    boolean postfixFlag;
    String operatorName;
}