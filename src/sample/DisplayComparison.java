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
        Text totalWord = new Text("Total Word Count: " + getTotalWord(dataColected));
        Text totalChar = new Text("Total Character Count: " + getTotalChar(dataColected));
        Text totalLine = new Text("Total Line Count: " + getTotalLine(dataColected));
        totalChar.setFont(new Font(20));
        totalLine.setFont(new Font(20));
        totalWord.setFont(new Font(20));
        totalSorceline.setFont(new Font(20));
        totalCommits.setFont(new Font(20));
        totalComment.setFont(new Font(20));
        layout.getChildren().addAll(totalCommits,totalSorceline,totalComment,totalChar,totalLine,totalWord);

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

    private int getTotalChar(ObservableList<DataColected> dataColecteds){
        int total=0;
        for(DataColected dataToCollect : dataColecteds){
            total += dataToCollect.getCcount();
        }
        return total;
    }

    private int getTotalLine(ObservableList<DataColected> dataColecteds){
        int total=0;
        for(DataColected dataToCollect : dataColecteds){
            total += dataToCollect.getLcount();
        }
        return total;
    }

    private int getTotalWord(ObservableList<DataColected> dataColecteds){
        int total=0;
        for(DataColected dataToCollect : dataColecteds){
            total += dataToCollect.getWcount();
        }
        return total;
    }
}
