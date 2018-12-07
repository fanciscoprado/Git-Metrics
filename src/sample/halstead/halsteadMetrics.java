package sample.halstead;

public class halsteadMetrics
{
    /*private int nOne;
    private int nTwo;
    private int N1;
    private int N2;
    private int programVocab;
    private int programLength;
    private double calculatedProgramLength;
    private double volume;
    private double difficulty;
    private double effort;
    private double timeRequired;
    private double bugs;

    void setnOne(int val){
        this.nOne = val;
    }

    void setnTwo(int val){
        this.nTwo = val;
    }

    void setN1(int val){
        this.N1 = val;
    }

    void setN2(int val){
        this.N2 = val;
    }

    void setProgramVocab(int val){
        this.programVocab = val;
    }

    void setProgramLength(int val){
        this.programLength = val;
    }

    void setCalculatedProgramLength(double val){
        this.calculatedProgramLength = val;
    }

    void setVolume(double val){
        this.volume = val;
    }

    void setDifficulty(double val){
        this.difficulty = val;
    }

    void setEffort(double val){
        this.effort = val;
    }

    void setTimeRequired(double val){
        this.timeRequired = val;
    }

    void setBugs(double val){
        this.bugs = val;
    }

    int getnOne(){
        return this.nOne;
    }

    int getnTwo(){
        return this.nTwo;
    }

    int getN1(){
        return this.N1;
    }

    int getN2(){
        return this.N2;
    }*/

    int getProgramVocab(int operators, int operands){
        return operators + operands;
    }

    int getProgramLength(int operatorsT, int operandsT){
        return operatorsT + operandsT;
    }

    double getCalculatedProgramLength(int operators, int operands){
        return (operators*(Math.log(operators)/Math.log(2)))+(operands*(Math.log(operands)/Math.log(2)));
    }

    double getVolume(){
        this.volume = this.programLength*(Math.log(this.programVocab)/Math.log(2));
        return this.volume;
    }

    double getDifficulty(int operators, int operands, int operandsT){
        this.difficulty = (operators/2)*(operandsT/operands);
        return this.difficulty;
    }

    double getEffort(){
        this.effort = this.difficulty*this.volume;
        return this.effort;
    }

    double getTimeRequired(){
        this.timeRequired = this.effort/18;
        return this.timeRequired;
    }

    double getBugs(){
        this.bugs = this.timeRequired/3000;
        return this.bugs;
    }
}
