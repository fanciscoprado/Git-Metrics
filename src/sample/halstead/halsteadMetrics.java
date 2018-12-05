package sample.halstead;

public class halsteadMetrics
{
    private int nOne;
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


}
