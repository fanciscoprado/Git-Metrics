package sample;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.util.LinkedList;

public class ResultBox {


    public static void display(ObservableList<DataColected> list, LinkedList<CommiterInfo> cList) {
        Stage window = new Stage();
        //Block events to other windows
       // Image image = new Image("icon.png");
        //window.getIcons().add(image);
        //window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Results");
        window.setMinWidth(250);
        Button sceneSwitch1 = new Button("Contributors");
        Button sceneSwitch2 = new Button("Metrics");


        VBox layout1 = new VBox();
        layout1.getChildren().addAll(new DisplayMetricsData().setupTablee(list), sceneSwitch1 );
        Scene dataDisplay = new Scene(layout1);

        VBox layout2 = new VBox();
        layout2.getChildren().addAll(new DisplayComiiterData().displayPiechart(cList), sceneSwitch2);
        Scene commiterDataDisplay = new Scene(layout2);

        sceneSwitch1.setOnAction(e -> window.setScene(commiterDataDisplay));
        sceneSwitch2.setOnAction(e -> window.setScene(dataDisplay));





        //Display window and wait for it to be closed before returning

        window.setScene(dataDisplay);
        window.showAndWait();

    }




}