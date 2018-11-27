package sample;

public class CommiterInfo {

    private String name = "";
    private int commits = 1;

    public CommiterInfo(String name) {
        this.name = name;
    }


    public void addCommitCount() {
        commits++;
    }
    public int getCommits(){
        return commits;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
