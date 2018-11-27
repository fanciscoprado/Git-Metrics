package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class DataCollector {
    public ObservableList<Data> collectData(LinkedList<File> fileList){
        ObservableList<Data> dataList = FXCollections.observableArrayList();
        for(File temp : fileList){
            Data data = new Data();
            data.setFilename(temp.getName());
            getWordCount(data,temp);
            getSourceLines(data,temp);
            dataList.add(data);
        }


        return dataList;
    }

    private void getWordCount(Data data, File temp){
        wc counter = new wc();
        try {
            counter.counter(data.getFilename(),temp);
            data.setWcount(counter.getWcount());
            data.setLcount(counter.getLcount());
            data.setCcount(counter.getCcount());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getSourceLines(Data data, File temp){
        countSourceLines counter = new countSourceLines();
        try {
            data.setSlcount(counter.getSourceLines(temp));
            data.setCccount(counter.getCommentLines(temp));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
