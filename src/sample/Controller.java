package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.eclipse.jgit.api.Git;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Controller {
    DataToCollect dataToCollect = new DataToCollect();
    @FXML
    private TextField uRLfield;
    @FXML
    public Button goButton;
    @FXML
    private CheckBox checkBox4;
    @FXML
    public CheckBox checkBoxj;
    @FXML
    public CheckBox checkBoxC;
    @FXML
    public CheckBox checkBoxCpp;


    public void onClick() throws IOException {
        SingleGitRepo singleGitRepo = new SingleGitRepo();
        if(singleGitRepo.start(dataToCollect, getURL()))
            ;
        else {
            new AlertBox().display("Alert!", "Invalid URL");
        }

    }
    //gets url from text field
    public String getURL(){
        return uRLfield.getText();

    }


    public void box4() throws IOException {
        if(checkBox4.isSelected()){
            Stage stage = (Stage) checkBox4.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("MultiFileScene.fxml"))));
        }
    }
    public void jChecked(){
        if(checkBoxj.isSelected())
            dataToCollect.setDoJavaFile(true);
        if (!checkBoxj.isSelected())
            dataToCollect.setDoJavaFile(false);
    }

    public void cChecked(){
        if(checkBoxC.isSelected())
            dataToCollect.setDoC(true);
        if(!checkBoxC.isSelected())
            dataToCollect.setDoC(false);
    }

    public void cppChecked(){
        if(checkBoxCpp.isSelected())
            dataToCollect.setDoCppFile(true);
        if(!checkBoxCpp.isSelected())
            dataToCollect.setDoCppFile(false);
    }




}
