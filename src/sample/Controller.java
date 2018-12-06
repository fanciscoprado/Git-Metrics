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
    private CheckBox checkBox1;
    @FXML
    private CheckBox checkBox2;
    @FXML
    private CheckBox checkBox3;
    @FXML
    public Button goButton;
    @FXML
    private CheckBox checkBox4;
    @FXML
    private AnchorPane stage;
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

    public void box4() throws IOException {
        if(checkBox4.isSelected()){
            Stage stage = (Stage) checkBox1.getScene().getWindow();
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
