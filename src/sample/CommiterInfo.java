package sample;

import java.util.LinkedList;

public class CommiterInfo {

    private String name = "";
    private int commits = 1;
    private LinkedList<String> commitMessageList = new LinkedList<>();


    public CommiterInfo(String name) {
        this.name = name;
    }
    public void pushCommit(String message){
        commitMessageList.push(message);
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
