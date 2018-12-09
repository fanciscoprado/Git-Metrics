package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DisplayMetricsData {


    public TableView<DataCollected> setupTablee(ObservableList<DataCollected> list){

        TableView<DataCollected> table = new TableView<>();
        table.setItems(list);

        TableColumn<DataCollected, String> nameColum = new TableColumn<>("File Name");
        nameColum.setMinWidth(200);
        nameColum.setCellValueFactory(new PropertyValueFactory<>("filename"));

        TableColumn<DataCollected, String> wordColum = new TableColumn<>("Word Count");
        wordColum.setMinWidth(200);
        wordColum.setCellValueFactory(new PropertyValueFactory<>("wcount"));

        TableColumn<DataCollected, String> lineColumn = new TableColumn<>("Line Count");
        lineColumn.setMinWidth(200);
        lineColumn.setCellValueFactory(new PropertyValueFactory<>("lcount"));

        TableColumn<DataCollected, String> charColum = new TableColumn<>("Char Count");
        charColum.setMinWidth(200);
        charColum.setCellValueFactory(new PropertyValueFactory<>("ccount"));

        TableColumn<DataCollected, String> sorceColumn = new TableColumn<>("Source Count");
        sorceColumn.setMinWidth(200);
        sorceColumn.setCellValueFactory(new PropertyValueFactory<>("slcount"));

        TableColumn<DataCollected, String> commentColumn = new TableColumn<>("Comment Count");
        commentColumn.setMinWidth(200);
        commentColumn.setCellValueFactory(new PropertyValueFactory<>("cccount"));

        /*
        TableColumn<DataCollected, String> cyclomaticComplexityColumn = new TableColumn<>("Cyclomatic Complexity");
        commentColumn.setMinWidth(200);
        commentColumn.setCellValueFactory(new PropertyValueFactory<>("cyclomaticcomplexity"));

        TableColumn<DataCollected, String> maintainabilityIndexColumn = new TableColumn<>("Maintainability Index");
        commentColumn.setMinWidth(200);
        commentColumn.setCellValueFactory(new PropertyValueFactory<>("maintainabilityindex"));

        TableColumn<DataCollected, String> depthOfInheritanceColumn = new TableColumn<>("Depth of Inheritance");
        commentColumn.setMinWidth(200);
        commentColumn.setCellValueFactory(new PropertyValueFactory<>("depthofinheritance"));
        */

        table.getColumns().addAll(nameColum, lineColumn,wordColum,charColum, commentColumn, sorceColumn);
        return table;

    }






}
