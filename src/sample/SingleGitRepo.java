package sample;

import javafx.collections.ObservableList;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class SingleGitRepo {
    GitController gitController = new GitController();
    FileHandler fileHandler = new FileHandler();
    DataCollector dataCollector = new DataCollector();

    ObservableList<DataCollected> dataCollectedList;
    LinkedList<CommiterInfo> commiterList;


    public boolean start(DataToCollect dataToCollect, String url) {

        try {
           if(gitController.downloadRepo(url)) {
               commiterList = gitController.getCommitCount();
               LinkedList<File> fileList = fileHandler.parseFiles(dataToCollect);
               dataCollectedList = dataCollector.collectData(fileList, dataToCollect);
               displayResults(dataCollectedList, commiterList);
               gitController.close();
               return true;
           }else ;
        } catch (IOException e) {
            return false;
        }
        return false;

    }
     void displayResults(ObservableList<DataCollected> dataCollectedList, LinkedList<CommiterInfo> commiterList){
        ResultBox resultBox = new ResultBox();
        resultBox.display(dataCollectedList,commiterList);

    }

    public ObservableList<DataCollected> getDataCollectedList() {
        return dataCollectedList;
    }

    public LinkedList<CommiterInfo> getCommiterList() {
        return commiterList;
    }
}
