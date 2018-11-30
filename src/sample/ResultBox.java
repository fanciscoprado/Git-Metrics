package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import java.util.LinkedList;

public class ResultBox {
    Button sceneSwitch;

    public static void display(ObservableList<Data> list, LinkedList<CommiterInfo> cList) {
        Stage window = new Stage();
        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Results");
        window.setMinWidth(250);
        Scene dataDisplay = new DisplayMetricsData().displayAll(list);







        //***********************************************************************pie chart start**********************************
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for(CommiterInfo temp: cList){
            pieChartData.add(new PieChart.Data(temp.getName(),temp.getCommits()));
        }
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Commiters");
        chart.setLegendSide(Side.LEFT);
        //************************end pie cahrt************************************************





        //Display window and wait for it to be closed before returning

        window.setScene(new DisplayMetricsData().displayAll(list));
        window.showAndWait();

    }




}