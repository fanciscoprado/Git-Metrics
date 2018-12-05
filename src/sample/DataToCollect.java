package sample;

public class DataToCollect {
    private boolean wordCount;
    private boolean charCount;
    private boolean lineCount;
    private boolean doJavaFile = true;
    private boolean doCppFile;
    private boolean doCppH;



    public boolean isWordCount() {
        return wordCount;
    }

    public void setWordCount(boolean wordCount) {
        this.wordCount = wordCount;
    }

    public boolean isCharCount() {
        return charCount;
    }

    public void setCharCount(boolean charCount) {
        this.charCount = charCount;
    }

    public boolean isLineCount() {
        return lineCount;
    }

    public void setLineCount(boolean lineCount) {
        this.lineCount = lineCount;
    }

    public boolean isDoJavaFile() {
        return doJavaFile;
    }

    public void setDoJavaFile(boolean doJavaFile) {
        this.doJavaFile = doJavaFile;
    }

    public boolean isDoCppFile() {
        return doCppFile;
    }

    public void setDoCppFile(boolean doCppFile) {
        this.doCppFile = doCppFile;
    }

    public boolean isDoCppH() {
        return doCppH;
    }

    public void setDoCppH(boolean doCppH) {
        this.doCppH = doCppH;
    }

}
