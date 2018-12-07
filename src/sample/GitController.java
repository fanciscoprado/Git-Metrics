package sample;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import org.eclipse.jgit.revwalk.RevCommit;
public class GitController {
    File folder = new File("temp/");
    Git git = null;
    public boolean downloadRepo(String url) throws IOException {


        try {
            git = Git.cloneRepository()
                    .setURI(url)
                    .setDirectory(folder)
                    .call();

        } catch (GitAPIException e) {
            //System.out.println("no good amigo");
            return false;
        }


        return true;
    }
    public LinkedList<CommiterInfo> getCommitCount() {
        Iterable<RevCommit> commits = null;
        LinkedList<CommiterInfo> commiterList = new LinkedList<>();
        try {
            commits = git.log().call();
        } catch (GitAPIException e) {
            //System.out.println("list no bueno");
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
    public void removeall(File folder){ // recusivly delets the git archive downloaded
         git.getRepository().close();
         git.close();
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
