package sample.halstead;

public class halsteadMetrics
{
    public int getProgramVocab(int operators, int operands){
        return operators + operands;
    }

    public int getProgramLength(int operatorsT, int operandsT){
        return operatorsT + operandsT;
    }

    public double getCalculatedProgramLength(int operators, int operands){
        return (operators*(Math.log(operators)/Math.log(2)))+(operands*(Math.log(operands)/Math.log(2)));
    }

    public double getVolume(int Plength, int vocab){
        return Plength*(Math.log(vocab)/Math.log(2));
    }

    public double getDifficulty(int operators, int operands, int operandsT){
        return (operators/2)*(operandsT/operands);
    }

    public double getEffort(double difficulty, double volume){
        return difficulty*volume;
    }

    public double getTimeRequired(double effort){
        return effort/18;
    }

    public double getBugs(double timeRequired){
        return timeRequired/3000;
    }
}
