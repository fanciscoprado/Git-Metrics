package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class DataCollector {

    public ObservableList<DataColected> collectData(LinkedList<File> fileList, DataToCollect dataToCollect) throws IOException {
        ObservableList<DataColected> dataColectedList = FXCollections.observableArrayList();
        for(File temp : fileList){
            DataColected dataColected = new DataColected();
            dataColected.setFilename(temp.getName());
            getMetrics(temp, dataToCollect, dataColected);
            getSourceLines(dataColected,temp);
            dataColectedList.add(dataColected);
        }


        return dataColectedList;
    }

    private void getMetrics(File temp, DataToCollect dataToCollect, DataColected dataColected) throws IOException {
        if(!dataToCollect.isLineCount() && !dataToCollect.isWordCount() && !dataToCollect.isCharCount()){
            getWLSCount(dataColected,temp);
        }else {
            wc counter = new wc();
            counter.counter(temp.getName(),temp);

            if (dataToCollect.isWordCount())
                getWordCount(counter, dataColected);
            if (dataToCollect.isCharCount())
                getCharCount(counter, dataColected);
            if (dataToCollect.isLineCount())
                getLineCount(counter, dataColected);
        }
    }
    private void getWordCount(wc counter, DataColected dataColected){
        dataColected.setFilename(counter.getFilename());
        dataColected.setWcount(counter.getWcount());
    }
    private void getCharCount(wc counter, DataColected dataColected){
        dataColected.setFilename(counter.getFilename());
        dataColected.setCcount(counter.getCcount());
    }
    private void getLineCount(wc counter, DataColected dataColected){
        dataColected.setFilename(counter.getFilename());
        dataColected.setLcount(counter.getLcount());
    }

    private void getWLSCount(DataColected dataColected, File temp){
        wc counter = new wc();
        try {
            counter.counter(dataColected.getFilename(),temp);
            dataColected.setWcount(counter.getWcount());
            dataColected.setLcount(counter.getLcount());
            dataColected.setCcount(counter.getCcount());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getSourceLines(DataColected dataColected, File temp){
        //Replaced countSourceLines with lineCounter
        //countSourceLines counter = new countSourceLines();
        lineCounter counter = new lineCounter();
        int[] lineTally = {0, 0};
        try {
            /*dataColected.setSlcount(counter.getSourceLines(temp));
            dataColected.setCccount(counter.getCommentLines(temp));*/
            //getNumberOfLines returns an array of two length
            lineTally = counter.getNumberOfLines(temp);
            dataColected.setSlcount(lineTally[0]);  //lineTally[0] is Source Lines
            dataColected.setCccount(lineTally[1]);  //lineTally[1] is Comment Lines

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void getHalstead(){
        /* TODO: 12/2/2018 */
    }

    private void getCyclomaticComplexity(){
        //TODO: 12/5/2018
    }
    private void getDepthOfInheritance() {
        //TODO: 12/5/2018
    }
    private void getMaintainabilityIndex(){
        //TODO: 12/5/2018
    }
}
