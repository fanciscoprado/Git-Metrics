package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CommitListDisplay {

    Stage window;
    Scene scene;
    ListView<String> listView;
    public void display(CommiterInfo commiterInfo){
        window = new Stage();
        window.setTitle("ListView Demo");
        Text name = new Text(commiterInfo.getName() + "'s total commit cout: " + commiterInfo.getCommits());
        listView = new ListView<>();

        for(String temp : commiterInfo.getCommitMessageList()){
            listView.getItems().add(temp);
        }

        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(listView);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();


    }

}
