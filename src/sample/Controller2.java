package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

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
    @FXML
    private Button addRepo;
    private LinkedList<String> repoList = new LinkedList<>();
    private int repoCount = 0;

    @Override
    public void onClick() throws IOException {
        LinkedList<MultiGitRepo> parsedRepoList = new LinkedList<>();
        for(String temp : repoList){
            MultiGitRepo multiGitRepo = new MultiGitRepo();
            multiGitRepo.start(dataToCollect,temp);
            parsedRepoList.push(multiGitRepo);
        }
        Stage window = new Stage();
        //Block events to other windows
        window.setTitle("Results");
        HBox layout2 = new HBox();
        for(MultiGitRepo temp : parsedRepoList){
            layout2.getChildren().add(new DisplayComparison().display(temp.commiterList));
        }
        Scene commiterDataDisplay = new Scene(layout2);
        window.setScene(commiterDataDisplay);
        window.show();




    }

    @Override
    public void box4() throws IOException {
        if(checkBox4.isSelected()) {
            Stage stage = (Stage) checkBox1.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("sample.fxml"))));
        }
    }

    public void addRepoClicked() throws IOException {
        if(repoCount < 2) {
            System.out.println(getURL());
            repoList.push(getURL());
            repoCount++;
        }else {
            System.out.println("To many repos continuing");
            onClick();
        }
    }
}
