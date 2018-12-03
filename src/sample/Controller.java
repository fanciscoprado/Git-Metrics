package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import org.eclipse.jgit.api.Git;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Controller {
    DataToCollect dataToCollect = new DataToCollect();
    @FXML
    private TextField uRLfield;
    @FXML
    private CheckBox checkBox1;
    @FXML
    private CheckBox checkBox2;
    @FXML
    private CheckBox checkBox3;
    @FXML
    public Button goButton;

    public void onClick() throws IOException {
        SingleGitRepo singleGitRepo = new SingleGitRepo();
        singleGitRepo.start(dataToCollect, getURL());

    }
    //gets url from text field
    public String getURL(){
        return uRLfield.getText();

    }

    public void  box1(){
        if(checkBox1.isSelected())
            dataToCollect.setWordCount(true);
        else
            dataToCollect.setWordCount(false);

    }

    public void box2(){
        if(checkBox2.isSelected())
            dataToCollect.setLineCount(true);
        else
            dataToCollect.setLineCount(false);

    }

    public void  box3(){
        if(checkBox3.isSelected())
            dataToCollect.setCharCount(true);
        else
            dataToCollect.setCharCount(false);

    }




}
