package sample;

import javafx.collections.ObservableList;
import jdk.nashorn.internal.runtime.ECMAException;
import org.eclipse.jgit.api.Git;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class SingleGitRepo {
    GitController gitController = new GitController();
    FileHandler fileHandler = new FileHandler();
    DataCollector dataCollector = new DataCollector();

    ObservableList<DataColected> dataColectedList;
    LinkedList<CommiterInfo> commiterList;


    public boolean start(DataToCollect dataToCollect, String url) {

        try {
           if(gitController.downloadRepo(url)) {
               commiterList = gitController.getCommitCount();
               LinkedList<File> fileList = fileHandler.parseFiles(dataToCollect);
               dataColectedList = dataCollector.collectData(fileList, dataToCollect);
               displayResults(dataColectedList, commiterList);
               gitController.close();
               return true;
           }else ;
        } catch (IOException e) {
            return false;
        }
        return false;

    }
     void displayResults(ObservableList<DataColected> dataColectedList, LinkedList<CommiterInfo> commiterList){
        ResultBox resultBox = new ResultBox();
        resultBox.display(dataColectedList,commiterList);

    }

    public ObservableList<DataColected> getDataColectedList() {
        return dataColectedList;
    }

    public LinkedList<CommiterInfo> getCommiterList() {
        return commiterList;
    }
}
