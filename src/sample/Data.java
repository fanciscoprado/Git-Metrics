package sample;

import java.io.File;
import java.io.IOException;

public class Data {
    private long ccount;
    private long wcount;
    private long lcount;
    private int cccount;
    private int slcount;
    private boolean skipped;

    public String getFilename() {
        return filename;
    }

    private String filename;

    public void collect(String fname,File file) throws IOException {
        filename = fname;
        wc temp = new wc();
        temp.counter(fname,file);
        ccount = temp.getCcount();
        wcount = temp.getWcount();
        lcount = temp.getLcount();
        countSourceLines s = new countSourceLines();
        cccount = s.getCommentLines(file);
        slcount = s.getSourceLines(file);
        skipped = temp.isSkipped();


    }

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
