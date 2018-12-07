package sample;

import java.io.File;
import java.io.IOException;

public class DataColected {
    private long ccount;
    private long wcount;
    private long lcount;
    private int cccount;
    private int slcount;
    private int cyclomaticComplexity;
    private int maintainabilityIndex;
    private int depthOfInheritance;
    /*
    private int operators //distinct operators
    private int operands //distinct operands
    private int operatorsT //total number of operators
    private int operandsT //total number of operands
     */
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
    /*
    public void setOperators(int operators)
    {
        this.operators = operators;
    }
    public void setOperands(int operands)
    {
        this.operands = operands;
    }
    public void setOperatorsT(int operatorsT)
    {
        this.operatorsT = operatorsT;
    }
    public void setOperandsT(int operandsT)
    {
        this.operandsT = operandsT;
    }
     */

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
}
