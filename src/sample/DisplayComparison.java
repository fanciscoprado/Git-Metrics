package sample;

import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.LinkedList;

public class DisplayComparison {

    public VBox display(LinkedList<CommiterInfo> clist, int tCommits, ObservableList<DataColected> dataColected){
        VBox layout = new VBox();
        layout.getChildren().add(new DisplayComiiterData().displayPiechart(clist));
        Text totalCommits = new Text("Total commit: " + tCommits);
        Text totalSorceline = new Text("Total SorceLines: " + getTotalSorceLines(dataColected));
        Text totalComment = new Text("Total Comment Count: "+ getTotalComment(dataColected));
        totalSorceline.setFont(new Font(20));
        totalCommits.setFont(new Font(20));
        totalComment.setFont(new Font(20));
        layout.getChildren().addAll(totalCommits,totalSorceline,totalComment);

        return layout;
    }
    private int getTotalSorceLines(ObservableList<DataColected> dataColecteds){
        int total=0;
        for(DataColected dataToCollect : dataColecteds){
            total += dataToCollect.getSlcount();
        }
        return total;
    }

    private int getTotalComment(ObservableList<DataColected> dataColecteds){
        int total=0;
        for(DataColected dataToCollect : dataColecteds){
            total += dataToCollect.getCccount();
        }
        return total;
    }
}
