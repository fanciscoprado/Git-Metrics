package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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
    public void onClick(){
        repoCount = 0;
        int totalCommits;
        LinkedList<MultiGitRepo> parsedRepoList = new LinkedList<>();
        boolean showResults = true;
        for(String temp : repoList) {
                MultiGitRepo multiGitRepo = new MultiGitRepo();
            if (multiGitRepo.start(dataToCollect, temp)) {
                parsedRepoList.push(multiGitRepo);
                showResults = true;
            }
            else {
                new AlertBox().display("Alert!", "Invalid URL(s) pleas try again");
                showResults = false;
            }
        }
        if(showResults) {
            Stage window = new Stage();
            window.setTitle("Results");
            HBox layout2 = new HBox();

            for (MultiGitRepo temp : parsedRepoList) {
                totalCommits = 0;
                for (CommiterInfo tempe : temp.commiterList) {
                    totalCommits = totalCommits + tempe.getCommits();
                }
                layout2.getChildren().add(new DisplayComparison().display(temp.commiterList, totalCommits));
                Button showMetrics = new Button("Show Metrics");
                showMetrics.setOnAction(e -> {
                    ResultBox resultBox = new ResultBox();
                    resultBox.display(temp.dataColectedList, temp.getCommiterList());
                });
                layout2.getChildren().add(showMetrics);
            }
            Scene commiterDataDisplay = new Scene(layout2);
            Image image = new Image("icon.png");
            window.getIcons().add(image);
            window.setScene(commiterDataDisplay);
            window.showAndWait();
        }
        repoCount = 0;
        repoList.clear();




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
            if(repoCount == 0)
                repoList.clear();
            System.out.println(getURL());
            repoList.push(getURL());
            repoCount++;
        }else {
            new AlertBox().display("Alert!", "To many repos close to continue");
            onClick();
        }
    }
}
