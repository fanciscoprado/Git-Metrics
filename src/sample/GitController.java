package sample;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import org.eclipse.jgit.revwalk.RevCommit;
public class GitController {
    File folder = new File("temp/");

    public Git downloadRepo(String url) throws IOException {
        Git git = null;

        try {
            git = Git.cloneRepository()
                    .setURI(url)
                    .setDirectory(folder)
                    .call();

        } catch (GitAPIException e) {
            System.out.println("no good amigo");
            e.printStackTrace();
        }


        return git;
    }
    public LinkedList<CommiterInfo> getCommitCount(Git git) {
        Iterable<RevCommit> commits = null;
        LinkedList<CommiterInfo> commiterList = new LinkedList<>();
        try {
            commits = git.log().call();
        } catch (GitAPIException e) {
            e.printStackTrace();
        }


        for( RevCommit commit : commits ) {
            makeListOfCommiters(commiterList, commit.getAuthorIdent().getName(), commit);
        }


        return commiterList;
    }

    private void makeListOfCommiters (LinkedList<CommiterInfo> commiterList,String string, RevCommit commit){
        CommiterInfo info = new CommiterInfo(string);
        if(commiterList.size() ==0) {
            info.pushCommit(commit.getFullMessage());
            commiterList.push(info);
        }
        else {
            boolean inList = false;
            for(CommiterInfo temp : commiterList){
                if(temp.getName().equals(string)) {
                    inList = true;
                    temp.pushCommit(commit.getFullMessage());
                    temp.addCommitCount();
                    break;
                }
            }
            if(!inList) {
                info.pushCommit(commit.getFullMessage());
                commiterList.push(info);
                inList = false;
            }
        }
    }
    public void close(){
        removeall(folder);
    }
    private void removeall(File folder){ // recusivly delets the git archive downloaded
        File[] listOfFiles = folder.listFiles();
        try {
            for (File temp : listOfFiles) {
                if (!temp.delete()) {
                    removeall(temp);
                }
                if (temp.delete()) {
                    System.out.println("deletet" + temp.getName());
                }

            }
        }catch (Exception e){
            System.out.println("could not delet");
            folder.setWritable(true);
            folder.delete();
        }
        folder.delete();
    }
}
