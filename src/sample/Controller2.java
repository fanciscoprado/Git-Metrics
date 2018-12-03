package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller2 extends Controller {
    @FXML
    private CheckBox checkBox1;
    @FXML
    private TextField uRLfield;
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
    @Override
    public void onClick() throws IOException {
        MultiGitRepo multiGitRepo = new MultiGitRepo();
        multiGitRepo.start(dataToCollect,getURL());
        ResultBox box = new ResultBox();
        System.out.println("This is scene 2");
        box.display(multiGitRepo.getDataColectedList(),multiGitRepo.getCommiterList());
    }

    @Override
    public void box4() throws IOException {
        if(checkBox4.isSelected()) {
            Stage stage = (Stage) checkBox1.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("sample.fxml"))));
        }
    }
}
