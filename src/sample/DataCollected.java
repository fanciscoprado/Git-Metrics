package sample;

import java.io.File;
import java.io.IOException;

public class DataCollected {
    private long ccount;
    private long wcount;
    private long lcount;
    private int cccount;
    private int slcount;
    private int cyclomaticcomplexity;
    private double maintainabilityindex;
    private int depthofinheritance;
    private int operators; //distinct operators
    private int operands; //distinct operands
    private int operatorsT; //total number of operators
    private int operandsT; //total number of operands
    private int vocab;
    private int PLength;
    private String CPLength;
    private String volume;\
    private double complexity;
    private double difficulty;
    private double effort;
    private double time;
    private double bugs;

    private boolean skipped;

    public String getFilename() {
        return filename;
    }

    private String filename;

    public void setCcount(long ccount) {
        this.ccount = ccount;
    }

    public void setWcount(long wcount) {
        this.wcount = wcount;
    }

    public void setLcount(long lcount) {
        this.lcount = lcount;
    }

    public void setCccount(int cccount) {
        this.cccount = cccount;
    }

    public void setSlcount(int slcount) {
        this.slcount = slcount;
    }

    public void setSkipped(boolean skipped) {
        this.skipped = skipped;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setOperators(int operators) {
        this.operators = operators;
    }

    public void setOperands(int operands) {
        this.operands = operands;
    }

    public void setOperatorsT(int operatorsT) {
        this.operatorsT = operatorsT;
    }

    public void setOperandsT(int operandsT) {
        this.operandsT = operandsT;
    }

    public void setVocab(int vocab) {
        this.vocab = vocab;
    }

    public void setPLength(int PLength) {
        this.PLength = PLength;
    }

    public void setCPLength(String CPLength) {
        this.CPLength = CPLength;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setCyclomaticComplexity(int cyclomaticcomplexity) {this.cyclomaticcomplexity = cyclomaticcomplexity;}

    public void setMaintainabilityIndex(double maintainabilityindex) {this.maintainabilityindex = maintainabilityindex;}

    public void setDepthOfInheritance(int depthofinheritance) {this.depthofinheritance = depthofinheritance;}

    public boolean isSkipped() {
        return skipped;
    }

    public long getCcount() {
        return ccount;
    }

    public long getWcount() {
        return wcount;
    }

    public long getLcount() {
        return lcount;
    }

    public int getCccount() {
        return cccount;
    }

    public int getSlcount() {
        return slcount;
    }

    public int getOperators() {
        return operators;
    }

    public int getOperands() {
        return operands;
    }

    public int getOperatorsT() {
        return operatorsT;
    }

    public int getOperandsT() {
        return operandsT;
    }

    public int getVocab()
    {
        return vocab;
    }

    public int getPLength()
    {
        return PLength;
    }

    public String getCPLength()
    {
        return CPLength;
    }

    public String getVolume()
    {
        return volume;
    }

    public double getDifficulty()
    {
        return difficulty;
    }

    public double getEffort()
    {
        return effort;
    }

    public double getTime()
    {
        return time;
    }

    public double getBugs()
    {
        return bugs;
    }

    public int getCyclomaticComplexity() { return cyclomaticcomplexity; }

    public double getMaintainabilityIndex() { return maintainabilityindex; }

    public double getComplexity() { return complexity;}

    public int getDepthOfInheritance() { return depthofinheritance; }
}
