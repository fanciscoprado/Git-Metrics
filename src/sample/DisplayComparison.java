package sample;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.LinkedList;

public class DisplayComparison {

    public VBox display(LinkedList<CommiterInfo> clist){
        VBox layout = new VBox();
        layout.getChildren().add(new DisplayComiiterData().displayPiechart(clist));

        return layout;
    }
}
