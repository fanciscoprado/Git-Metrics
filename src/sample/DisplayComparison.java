package sample;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.LinkedList;

public class DisplayComparison {

    public VBox display(LinkedList<CommiterInfo> clist, int tCommits){
        VBox layout = new VBox();
        layout.getChildren().add(new DisplayComiiterData().displayPiechart(clist));
        Text totalCommits = new Text("Total commit: " + tCommits);
        layout.getChildren().add(totalCommits);

        return layout;
    }
}
