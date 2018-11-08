package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ResultBox {

    public static void display(boolean w, boolean l, boolean c, ObservableList<wc> list) {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Results");
        window.setMinWidth(250);
        VBox layout = new VBox();

        TableView<wc> table;

        TableColumn<wc, String> nameColum = new TableColumn<>("File Name");
        nameColum.setMinWidth(200);
        nameColum.setCellValueFactory(new PropertyValueFactory<>("filename"));

        TableColumn<wc, String> wordColum = new TableColumn<>("File Name");
        wordColum.setMinWidth(200);
        wordColum.setCellValueFactory(new PropertyValueFactory<>("wcount"));

        TableColumn<wc, String> nameColum = new TableColumn<>("File Name");
        nameColum.setMinWidth(200);
        nameColum.setCellValueFactory(new PropertyValueFactory<>("filename"));

        TableColumn<wc, String> nameColum = new TableColumn<>("File Name");
        nameColum.setMinWidth(200);
        nameColum.setCellValueFactory(new PropertyValueFactory<>("filename"));

        table = new TableView<>();
        table.setItems(list);
        table.getColumns().addAll(nameColum);
        layout.getChildren().addAll(table);


        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

}