package sample;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.LinkedList;

public class DisplayComparison {

    public VBox display(LinkedList<CommiterInfo> clist, int tCommits){
        VBox layout = new VBox();
        layout.getChildren().add(new DisplayComiiterData().displayPiechart(clist));
        Text totalCommits = new Text("Total commit: " + tCommits);
        totalCommits.setFont(new Font(20));
        layout.getChildren().add(totalCommits);

        return layout;
    }
}
