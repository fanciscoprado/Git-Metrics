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
            //get word line char count
            wc counter = new wc();
            try {
                counter.counter(data.getFilename(),temp);
                data.setWcount(counter.getWcount());
                data.setLcount(counter.getLcount());
                data.setCcount(counter.getCcount());
            } catch (IOException e) {
                e.printStackTrace();
            }
            dataList.add(data);
        }


        return dataList;
    }
}
