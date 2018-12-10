package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CommitListDisplay {

    Stage window;
    Scene scene;
    Button button;
    ListView<String> listView;
    public void display(CommiterInfo commiterInfo){
        window = new Stage();
        window.setTitle("ListView Demo");
        button = new Button("Submit");

        listView = new ListView<>();

        for(String temp : commiterInfo.getCommitMessageList()){
            listView.getItems().add(temp);
        }

        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(listView, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();


    }

}
