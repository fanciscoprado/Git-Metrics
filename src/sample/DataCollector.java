package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class DataCollector {
    public ObservableList<Data> collectData(LinkedList<File> fileList, DataToCollect dataToCollect) throws IOException {
        ObservableList<Data> dataList = FXCollections.observableArrayList();
        for(File temp : fileList){
            Data data = new Data();
            data.setFilename(temp.getName());
            getMetrics(temp, dataToCollect, data);
           // getWordCount(data,temp);
           // getSourceLines(data,temp);
            dataList.add(data);
        }


        return dataList;
    }

    private void getMetrics(File temp, DataToCollect dataToCollect, Data data) throws IOException {
        if(!dataToCollect.isLineCount() && !dataToCollect.isWordCount() && !dataToCollect.isCharCount()){
            getWLSCount(data,temp);
        }else {
            wc counter = new wc();
            counter.counter(temp.getName(),temp);

            if (dataToCollect.isWordCount())
                getWordCount(counter,data);
            if (dataToCollect.isCharCount())
                getCharCount(counter,data);
            if (dataToCollect.isLineCount())
                getLineCount(counter,data);

        }
    }
    private void getWordCount(wc counter, Data data){
        data.setFilename(counter.getFilename());
        data.setWcount(counter.getWcount());
    }
    private void getCharCount(wc counter, Data data){
        data.setFilename(counter.getFilename());
        data.setCcount(counter.getCcount());
    }
    private void getLineCount(wc counter, Data data){
        data.setFilename(counter.getFilename());
        data.setLcount(counter.getLcount());
    }

    private void getWLSCount(Data data, File temp){
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
    private void getHalstead(){
        /* TODO: 12/2/2018 */
    }
}
