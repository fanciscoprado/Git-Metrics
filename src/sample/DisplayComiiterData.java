package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;


import java.util.LinkedList;

public class DisplayComiiterData{
    public PieChart displayPiechart(LinkedList<CommiterInfo> cList){
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        int totalCommits=0;
        for(CommiterInfo temp: cList){
            totalCommits += temp.getCommits();
            pieChartData.add(new PieChart.Data(temp.getName() /*+ " " + temp.getCommits()*/,temp.getCommits()));
        }
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Repo Total commits: " + totalCommits);
        chart.setLegendSide(Side.LEFT);
        chart.getData()
                .stream()
                .forEach(data -> {
                    data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, e ->{
                        CommitListDisplay ehh = new CommitListDisplay();
                        for(CommiterInfo temp: cList){
                            if(temp.getName().equals(data.getName())){
                                ehh.display(temp);
                                break;
                            }
                        }



                    });
                });
        return chart;
    }
}
