package sample;

import javafx.collections.ObservableList;
import org.eclipse.jgit.api.Git;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class SingleGitRepo {
    GitController gitController = new GitController();
    FileHandler fileHandler = new FileHandler();
    DataCollector dataCollector = new DataCollector();
    Git git;
    ObservableList<DataColected> dataColectedList;
    LinkedList<CommiterInfo> commiterList;


    public void start(DataToCollect dataToCollect, String url) throws IOException {

        git = gitController.downloadRepo(url);
        commiterList = gitController.getCommitCount(git);
        LinkedList<File> fileList = fileHandler.parseFiles(dataToCollect);
        dataColectedList = dataCollector.collectData(fileList, dataToCollect);
        displayResults(dataColectedList,commiterList);
        git.getRepository().close();
        git.close();
        gitController.close();
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
