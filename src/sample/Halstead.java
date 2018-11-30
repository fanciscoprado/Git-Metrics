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
    Set<halsteadOperator> vocabSet = new HashSet<>();
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
    public void setVocab()
    {
        final String[] FULL_OPERATOR = {"=", "0", "0", "==", "0", "0", "+", "0", "0", "++", "0", "1", "+=", "0", "0"
                , "-", "0", "0", "--", "0", "1", "-=", "0", "0", "*", "0", "0", "*=", "0", "0", "/", "0", "0", "/="
                , "0", "0", "%", "0", "0", "%=", "!", "0", "0", "!=", "0", "0", ">", "0", "0", ">=", "0", "0", ">>"
                , "0", "0", ">>>", "0", "0", "<", "0", "0", "<=", "0", "0", "<<", "0", "0", "&", "0", "0", "&&", "0"
                , "0", "&=", "0", "0", "|", "0", "0", "||", "0", "0", "|=", "0", "0", "?:", "0", "0", "~", "1", "0"
                , "^", "0", "0", "^="};

    }
}

//Data class, used to define and identify operators
class halsteadOperator
{
    boolean prefixFlag;
    boolean postfixFlag;
    String operatorName;
}