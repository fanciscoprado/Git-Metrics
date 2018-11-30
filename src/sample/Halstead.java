package sample;

public class Halstead
{

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
    public double getTime(double Effort)
    {
        double temp = Effort/18;
        return temp;
    }
    public double getBugs(double Volume)
    {
        double temp = Volume/3000;
        return temp;
    }

}
