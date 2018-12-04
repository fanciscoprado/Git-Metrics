package sample.halstead;

import java.util.ArrayList;

public class VocabConstructor
{
    final String[] BASIC_OPERATOR_LIST = {"=", "0", "0", "==", "0", "0", "+", "0", "0", "++", "0", "1", "+=", "0", "0"
            , "-", "0", "0", "--", "0", "1", "-=", "0", "0", "*", "0", "0", "*=", "0", "0", "/", "0", "0", "/="
            , "0", "0", "%", "0", "0", "%=", "0", "0", "!", "0", "0", "!=", "0", "0", ">", "0", "0", ">=", "0", "0", ">>"
            , "0", "0", ">>>", "0", "0", "<", "0", "0", "<=", "0", "0", "<<", "0", "0", "&", "0", "0", "&&", "0"
            , "0", "&=", "0", "0", "|", "0", "0", "||", "0", "0", "|=", "0", "0", "?:", "0", "0", "~", "1", "0"
            , "^", "0", "0", "^=", "0", "0"};

    //collects operators and their positions
    ArrayList<halsteadOperator> vocabList = new ArrayList<>();

    //Fills vocabList with operators - reads from a built-in list right now but should read from a file later.
    public void setVocab()
    {
        halsteadOperator temp = new halsteadOperator();
        String s;
        for (int index = 0; index < BASIC_OPERATOR_LIST.length; index++) {
            //halsteadOperator has three elements. The String array being read from stores them in this order:
            //name, if its a prefix and if its a postfix
            s = BASIC_OPERATOR_LIST[index];
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
    }

    //doesn't need a main - but it is good for testing
    /*public static void main(String[] args)throws Exception
    {
        VocabConstructor test = new VocabConstructor();
        test.setVocab();
        for(int i = 0; i < test.vocabList.size(); i++){
            System.out.println(test.vocabList.get(i));
        }
        File currentFile = new File("src/sample/wc.java");
        test.buildCodeList(currentFile);
        for(int i = 0; i < test.codeList.size(); i++){
            System.out.println(test.codeList.get(i));
        }
    }*/
}