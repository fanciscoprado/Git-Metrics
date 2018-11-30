package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class VocabConstructor
{
    final char[] HALF_OPERATOR = {'=', '+', '-', '*', '/', '%','!', '>', '<', '&', '|', '?', '~', '^', ':'};

    final String[] BASIC_OPERATOR_LIST = {"=", "0", "0", "==", "0", "0", "+", "0", "0", "++", "0", "1", "+=", "0", "0"
            , "-", "0", "0", "--", "0", "1", "-=", "0", "0", "*", "0", "0", "*=", "0", "0", "/", "0", "0", "/="
            , "0", "0", "%", "0", "0", "%=", "0", "0", "!", "0", "0", "!=", "0", "0", ">", "0", "0", ">=", "0", "0", ">>"
            , "0", "0", ">>>", "0", "0", "<", "0", "0", "<=", "0", "0", "<<", "0", "0", "&", "0", "0", "&&", "0"
            , "0", "&=", "0", "0", "|", "0", "0", "||", "0", "0", "|=", "0", "0", "?:", "0", "0", "~", "1", "0"
            , "^", "0", "0", "^=", "0", "0"};

    File currentFile = new File("src/sample/Halstead.java");
    ArrayList<halsteadOperator> vocabList = new ArrayList<halsteadOperator>();  //collects operators and their positions
    ArrayList<String> codeList;                                     //collects all relevant elements for Halstead metrics

    //Fills vocabList with operators - reads from a built-in list right now but should read from a file later.
    public void setVocab()
    {
        halsteadOperator temp = new halsteadOperator();
        String c;
        for (int index = 0; index < BASIC_OPERATOR_LIST.length; index++) {
            c = BASIC_OPERATOR_LIST[index];                 //halsteadOperator has three elements. The String array being
            if(index % 3 == 0)                              //read from stores them in this order: name, if its a prefix
            {                                               //and if its a postfix
                temp = new halsteadOperator();
                temp.operatorName = c;
            }
            if((index - 1) % 3 == 0) {
                if (c.equals("0"))
                    temp.prefixFlag = false;
                else
                    temp.prefixFlag = true;
            }
            if((index - 2) % 3 == 0) {
                if (c.equals("0"))
                    temp.suffixFlag = false;
                else
                    temp.suffixFlag = true;
                System.out.println(temp);
                vocabList.add(temp);
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
            if(true);
        }
    }

    //Creates operators out of tokenized elements
    public void buildOperator()
    {
    }

    public static void main(String[] args)
    {
        VocabConstructor test = new VocabConstructor();
        test.setVocab();
        /*for(int i = 0; i < test.vocabList.size(); i++){
            System.out.println(test.vocabList.get(i));
        }*/
        System.out.println(test.vocabList.get(1));
        System.out.println(test.vocabList.get(2));
        System.out.println(test.vocabList.get(3));
    }
}

//Data class: defines and identifies operators
class halsteadOperator
{
    boolean prefixFlag;
    boolean suffixFlag;
    String operatorName;

    @Override
    public String toString(){
        return operatorName + ", " + prefixFlag + ", " + suffixFlag;
    }
}