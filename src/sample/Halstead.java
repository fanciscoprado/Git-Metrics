package sample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Halstead
{
    /*special case words for java operators*/
    String[] javaOperators={"break","case","continue","default","do","if","else","enum","for","goto","if","new",
        "return","asm","operator","private","protected","public","sizeof","struct","switch","union","while",
        "this","namespace","using","try","catch","throw","throws","finally","strictfp","instanceof","interface",
        "extends","implements","abstract","concrete","const_cast","static_cast","dynamic_cast","reinterpret_cast",
        "typeid","template","explicit","true","false","typename","const","friend","volatile","transient","final",
        "auto","extern","register","static","typedef","virtual,","mutable","inline"};
    String[] CPlusOperators;
    Set<halsteadOperator> vocabSet = new HashSet<>();           //collects operators and their positions
    public int getDistinctOperator()
    {
        return 0;
    }
    public int getTotalOperator()
    {
        return 0;
    }
    public int getVocab(int operator, int operand)
    {
        int temp = operator + operand;
        return temp;
    }
    public int getPLength(int operatorT, int operandT)
    {
        int temp = operatorT + operandT;
        return temp;
    }
    public int getCPLength()
    {
        return 0;
    }
    public int getVolume()
    {
        return 0;
    }
    public int getDifficulty()
    {
        return 0;
    }
    public int getEffort()
    {
        return 0;
    }

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
}

//Data class: defines and identifies operators
class halsteadOperator
{
    boolean prefixFlag;
    boolean postfixFlag;
    String operatorName;
}