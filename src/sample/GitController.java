package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
            //LinkedList<CommiterInfo> commiterList = new LinkedList<>(); //list of commiterInfo objects

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
        int count = 0;

        for( RevCommit commit : commits ) {
            makeListOfCommiters(commiterList, commit.getAuthorIdent().getName());
            count++;
        }


        return commiterList;
    }

    private void makeListOfCommiters (LinkedList<CommiterInfo> commiterList,String string){
        if(commiterList.size() ==0)
            commiterList.push(new CommiterInfo(string));
        else {
            boolean inList = false;
            for(CommiterInfo temp : commiterList){
                if(temp.getName().equals(string)) {
                    inList = true;
                    temp.addCommitCount();
                    break;
                }
            }
            if(!inList) {
                commiterList.push(new CommiterInfo(string));
                inList = false;
            }
        }
    }
/*
    private void makeList(File folder,ObservableList<Data> list) throws IOException { //Makes observable list of Data objects that contain the metrics
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            String fname = file.getName();
            if(!file.isFile())
                makeList(file,list);
            else {
                Data temp = new Data();
                temp.collect(fname,file);
                if(!temp.isSkipped())
                    list.add(temp);
            }
        }
    }
   */
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
