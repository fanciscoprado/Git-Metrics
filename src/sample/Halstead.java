package sample;

public class Halstead
{
    /*special case words for java operators*/
    String[] javaOperators= {"break","case","continue","default","do","if","else","enum","for","goto","if","new",
        "return","asm","operator","private","protected","public","sizeof","struct","switch","union","while",
        "this","namespace","using","try","catch","throw","throws","finally","strictfp","instanceof","interface",
        "extends","implements","abstract","concrete","const_cast","static_cast","dynamic_cast","reinterpret_cast",
        "typeid","template","explicit","true","false","typename","const","friend","volatile","transient","final",
        "auto","extern","register","static","typedef","virtual,","mutable","inline","add","remove"};
    String[] CPlusOperators;
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
    public double getCPLength(int operators, int operands)
    {
        double temp = operators*(Math.log(operators)/Math.log(2))+(operands*(Math.log(operands)/Math.log(2)));
        return temp;
    }
    public double getVolume(int PLength, int vocab)
    {
        double temp = PLength*(Math.log(vocab)/Math.log(2));
        return temp;
    }
    public int getDifficulty(int operators, int operands, int operandsT)
    {
        int temp = (operators/2)*(operandsT/operands);
        return temp;
    }
    public double getEffort(double Difficulty, double Volume)
    {
        double temp = Difficulty*Volume;
        return temp;
    }

}
