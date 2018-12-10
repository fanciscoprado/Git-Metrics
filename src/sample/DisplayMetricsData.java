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
        nameColum.setMinWidth(100);
        nameColum.setCellValueFactory(new PropertyValueFactory<>("filename"));

        TableColumn<DataCollected, String> wordColum = new TableColumn<>("Word Count");
        wordColum.setMinWidth(100);
        wordColum.setCellValueFactory(new PropertyValueFactory<>("wcount"));

        TableColumn<DataCollected, String> lineColumn = new TableColumn<>("Line Count");
        lineColumn.setMinWidth(100);
        lineColumn.setCellValueFactory(new PropertyValueFactory<>("lcount"));

        TableColumn<DataCollected, String> charColum = new TableColumn<>("Char Count");
        charColum.setMinWidth(100);
        charColum.setCellValueFactory(new PropertyValueFactory<>("ccount"));

        TableColumn<DataCollected, String> sorceColumn = new TableColumn<>("Source Count");
        sorceColumn.setMinWidth(100);
        sorceColumn.setCellValueFactory(new PropertyValueFactory<>("slcount"));

        TableColumn<DataCollected, String> commentColumn = new TableColumn<>("Comment Count");
        commentColumn.setMinWidth(100);
        commentColumn.setCellValueFactory(new PropertyValueFactory<>("cccount"));

        TableColumn<DataCollected, String> halnOneColumn = new TableColumn<>("n1 Count");
        halnOneColumn.setMinWidth(100);
        halnOneColumn.setCellValueFactory(new PropertyValueFactory<>("operators"));

        TableColumn<DataCollected, String> halnTwoColumn = new TableColumn<>("n2 Count");
        halnTwoColumn.setMinWidth(100);
        halnTwoColumn.setCellValueFactory(new PropertyValueFactory<>("operands"));

        TableColumn<DataCollected, String> halN1Column = new TableColumn<>("N1 Count");
        halN1Column.setMinWidth(100);
        halN1Column.setCellValueFactory(new PropertyValueFactory<>("operatorsT"));

        TableColumn<DataCollected, String> halN2Column = new TableColumn<>("N2 Count");
        halN2Column.setMinWidth(100);
        halN2Column.setCellValueFactory(new PropertyValueFactory<>("operandsT"));

        TableColumn<DataCollected, String> halVocab = new TableColumn<>("Vocabulary");
        halVocab.setMinWidth(100);
        halVocab.setCellValueFactory(new PropertyValueFactory<>("vocab"));

        TableColumn<DataCollected, String> halPLength = new TableColumn<>("Length");
        halPLength.setMinWidth(100);
        halPLength.setCellValueFactory(new PropertyValueFactory<>("PLength"));

        TableColumn<DataCollected, String> halCPLength = new TableColumn<>("Calc Length");
        halCPLength.setMinWidth(100);
        halCPLength.setCellValueFactory(new PropertyValueFactory<>("CPLength"));

        TableColumn<DataCollected, String> halVolume = new TableColumn<>("Volume");
        halVolume.setMinWidth(100);
        halVolume.setCellValueFactory(new PropertyValueFactory<>("volume"));

        TableColumn<DataCollected, String> halDifficulty = new TableColumn<>("Difficulty");
        halDifficulty.setMinWidth(100);
        halDifficulty.setCellValueFactory(new PropertyValueFactory<>("difficulty"));

        TableColumn<DataCollected, String> halEffort = new TableColumn<>("Effort");
        halEffort.setMinWidth(100);
        halEffort.setCellValueFactory(new PropertyValueFactory<>("effort"));

        /*
        TableColumn<DataCollected, String> cyclomaticComplexityColumn = new TableColumn<>("Cyclomatic Complexity");     //cyclomatic complexity
        commentColumn.setMinWidth(100);
        commentColumn.setCellValueFactory(new PropertyValueFactory<>("cyclomaticcomplexity"));

        TableColumn<DataCollected, String> maintainabilityIndexColumn = new TableColumn<>("Maintainability Index");     //maintainability index
        commentColumn.setMinWidth(100);
        commentColumn.setCellValueFactory(new PropertyValueFactory<>("maintainabilityindex"));

        TableColumn<DataCollected, String> depthOfInheritanceColumn = new TableColumn<>("Depth of Inheritance");        //depth of inheritance
        commentColumn.setMinWidth(100);
        commentColumn.setCellValueFactory(new PropertyValueFactory<>("depthofinheritance"));
        */

        table.getColumns().addAll(nameColum, lineColumn,wordColum,charColum, commentColumn, sorceColumn, halnOneColumn,
                halnTwoColumn, halN1Column, halN2Column, halVocab, halPLength, halCPLength, halVolume, halDifficulty, halEffort/*, cyclomaticComplexityColumn, maintainabilityIndexColumn,
                depthOfInheritanceColumn*/);
        return table;

    }






}
