package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class VocabConstructor
{
    final char[] HALF_OPERATOR = {'=', '+', '-', '*', '/', '%','!', '>', '<', '&', '|', '?', '~', '^', ':'};

    final String[] BASIC_OPERATOR_LIST = {"=", "0", "0", "==", "0", "0", "+", "0", "0", "++", "0", "1", "+=", "0", "0"
            , "-", "0", "0", "--", "0", "1", "-=", "0", "0", "*", "0", "0", "*=", "0", "0", "/", "0", "0", "/="
            , "0", "0", "%", "0", "0", "%=", "0", "0", "!", "0", "0", "!=", "0", "0", ">", "0", "0", ">=", "0", "0", ">>"
            , "0", "0", ">>>", "0", "0", "<", "0", "0", "<=", "0", "0", "<<", "0", "0", "&", "0", "0", "&&", "0"
            , "0", "&=", "0", "0", "|", "0", "0", "||", "0", "0", "|=", "0", "0", "?:", "0", "0", "~", "1", "0"
            , "^", "0", "0", "^=", "0", "0"};

    //collects operators and their positions
    ArrayList<halsteadOperator> vocabList = new ArrayList<halsteadOperator>();

    //collects all relevant elements for Halstead metrics
    ArrayList<String> codeList;

    //Fills vocabList with operators - reads from a built-in list right now but should read from a file later.
    public void setVocab()
    {
        halsteadOperator temp = new halsteadOperator();
        String c;
        for (int index = 0; index < BASIC_OPERATOR_LIST.length; index++) {
            //halsteadOperator has three elements. The String array being read from stores them in this order:
            //name, if its a prefix and if its a postfix
            c = BASIC_OPERATOR_LIST[index];
            if(index % 3 == 0)
            {
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
                vocabList.add(temp);
            }
        }
    }

    //Creates an indexed list of all the elements from stream tokenizer
    public void buildCodeList(File currentFile)throws Exception
    {
        BufferedReader readFile = new BufferedReader(new FileReader(currentFile));
        StreamTokenizer fileStream = new StreamTokenizer(readFile);
        char tempChar;
        StringBuilder tempString = new StringBuilder;
        fileStream.slashStarComments(true);
        while(fileStream.nextToken() != fileStream.TT_EOF){
            if(fileStream.sval==null){
                tempChar = (char)fileStream.ttype;
                for (char c : HALF_OPERATOR) {
                    if(c == tempChar) {
                        tempString.append(tempChar);
                        break;
                    }
                }
            }
        }
    }

    //Creates operators out of tokenized elements
    public void buildOperator(/*StreamfileStream*/)
    {
    }

    //doesn't need a main - but it is good for testing
    public static void main(String[] args)throws Exception
    {
        VocabConstructor test = new VocabConstructor();
        test.setVocab();
        for(int i = 0; i < test.vocabList.size(); i++){
            System.out.println(test.vocabList.get(i));
        }
        File currentFile = new File("src/sample/Halstead.java");
        test.buildCodeList(currentFile);
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