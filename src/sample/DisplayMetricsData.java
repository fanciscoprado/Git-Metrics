package sample;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class DisplayMetricsData {


    public TableView<Data> setupTablee(ObservableList<Data> list){

        TableView<Data> table = new TableView<>();
        table.setItems(list);

        TableColumn<Data, String> nameColum = new TableColumn<>("File Name");
        nameColum.setMinWidth(200);
        nameColum.setCellValueFactory(new PropertyValueFactory<>("filename"));

        TableColumn<Data, String> wordColum = new TableColumn<>("Word Count");
        wordColum.setMinWidth(200);
        wordColum.setCellValueFactory(new PropertyValueFactory<>("wcount"));

        TableColumn<Data, String> lineColumn = new TableColumn<>("Line Count");
        lineColumn.setMinWidth(200);
        lineColumn.setCellValueFactory(new PropertyValueFactory<>("lcount"));

        TableColumn<Data, String> charColum = new TableColumn<>("Char Count");
        charColum.setMinWidth(200);
        charColum.setCellValueFactory(new PropertyValueFactory<>("ccount"));

        TableColumn<Data, String> sorceColumn = new TableColumn<>("Source Count");
        sorceColumn.setMinWidth(200);
        sorceColumn.setCellValueFactory(new PropertyValueFactory<>("slcount"));

        TableColumn<Data, String> commentColumn = new TableColumn<>("Comment Count");
        commentColumn.setMinWidth(200);
        commentColumn.setCellValueFactory(new PropertyValueFactory<>("cccount"));

        table.getColumns().addAll(nameColum, lineColumn,wordColum,charColum, commentColumn, sorceColumn);
        return table;

    }






}
