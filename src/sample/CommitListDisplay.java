package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CommitListDisplay {

    Stage window;
    Scene scene;
    ListView<String> listView;
    public void display(CommiterInfo commiterInfo){
        window = new Stage();
        window.setTitle("Commit Messages");
        Image image = new Image("icon.png");
        window.getIcons().add(image);
        Text name = new Text(commiterInfo.getName() + "'s total commit cout: " + commiterInfo.getCommits());
        name.setFont(new Font(20));
        listView = new ListView<>();

        for(String temp : commiterInfo.getCommitMessageList()){
            listView.getItems().add(temp);
        }

        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(name,listView);

        scene = new Scene(layout, 450, 250);

        window.setScene(scene);
        window.show();


    }

}
