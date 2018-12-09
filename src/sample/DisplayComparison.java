package sample;

import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.LinkedList;

public class DisplayComparison {

    public VBox display(LinkedList<CommiterInfo> clist, int tCommits, ObservableList<DataCollected> dataCollected){
        VBox layout = new VBox();
        layout.getChildren().add(new DisplayComiiterData().displayPiechart(clist));
        Text totalCommits = new Text("Total commit: " + tCommits);
        Text totalSorceline = new Text("Total SorceLines: " + getTotalSorceLines(dataCollected));
        Text totalComment = new Text("Total Comment Count: "+ getTotalComment(dataCollected));
        Text totalWord = new Text("Total Word Count: " + getTotalWord(dataCollected));
        Text totalChar = new Text("Total Character Count: " + getTotalChar(dataCollected));
        Text totalLine = new Text("Total Line Count: " + getTotalLine(dataCollected));
        totalChar.setFont(new Font(20));
        totalLine.setFont(new Font(20));
        totalWord.setFont(new Font(20));
        totalSorceline.setFont(new Font(20));
        totalCommits.setFont(new Font(20));
        totalComment.setFont(new Font(20));
        layout.getChildren().addAll(totalCommits,totalSorceline,totalComment,totalChar,totalLine,totalWord);

        return layout;
    }
    private int getTotalSorceLines(ObservableList<DataCollected> dataCollecteds){
        int total=0;
        for(DataCollected dataToCollect : dataCollecteds){
            total += dataToCollect.getSlcount();
        }
        return total;
    }

    private int getTotalComment(ObservableList<DataCollected> dataCollecteds){
        int total=0;
        for(DataCollected dataToCollect : dataCollecteds){
            total += dataToCollect.getCccount();
        }
        return total;
    }

    private int getTotalChar(ObservableList<DataCollected> dataCollecteds){
        int total=0;
        for(DataCollected dataToCollect : dataCollecteds){
            total += dataToCollect.getCcount();
        }
        return total;
    }

    private int getTotalLine(ObservableList<DataCollected> dataCollecteds){
        int total=0;
        for(DataCollected dataToCollect : dataCollecteds){
            total += dataToCollect.getLcount();
        }
        return total;
    }

    private int getTotalWord(ObservableList<DataCollected> dataCollecteds){
        int total=0;
        for(DataCollected dataToCollect : dataCollecteds){
            total += dataToCollect.getWcount();
        }
        return total;
    }
}
