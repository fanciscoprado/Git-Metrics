package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

public class Controller2 extends Controller {
    @FXML
    private TextField uRLfield;
    @FXML
    private TextField userName;
    @FXML
    private TextField password;
    @FXML
    public Button goButton;
    @FXML
    private CheckBox checkBox4;
    @FXML
    private Button addRepo;
    private LinkedList<String> repoList = new LinkedList<>();
    private int repoCount = 0;

    @Override
    public void onClick() throws IOException {
        SingleGitRepo singleGitRepo = new SingleGitRepo();
        if(singleGitRepo.start(dataToCollect, getURL(),getUser(),getPassword()))
            ;
        else {
            new AlertBox().display("Alert!", "Invalid URL");
        }

    }
    //gets url from text field
    public String getURL(){
        return uRLfield.getText();

    }
    @Override
    public void box4() throws IOException {
        if(!checkBox4.isSelected()) {
            Stage stage = (Stage) checkBox4.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("sample.fxml"))));
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


    public String getPassword() {

        return password.getText();
    }

    public String getUser() {

        return userName.getText();
    }
}
