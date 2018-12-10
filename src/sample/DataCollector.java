package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.halstead.Halstead;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class DataCollector {

    public ObservableList<DataCollected> collectData(LinkedList<File> fileList, DataToCollect dataToCollect) throws IOException {
        ObservableList<DataCollected> dataCollectedList = FXCollections.observableArrayList();
        for(File temp : fileList){
            DataCollected dataCollected = new DataCollected();
            dataCollected.setFilename(temp.getName());
            getMetrics(temp, dataToCollect, dataCollected);
            getSourceLines(dataCollected,temp);
            getHalstead(dataCollected,temp);
            getCyclomaticComplexity(dataCollected, temp);
            dataCollectedList.add(dataCollected);
        }

        return dataCollectedList;
    }

    private void getMetrics(File temp, DataToCollect dataToCollect, DataCollected dataCollected) throws IOException {
        if(!dataToCollect.isLineCount() && !dataToCollect.isWordCount() && !dataToCollect.isCharCount()){
            getWLSCount(dataCollected,temp);
        }else {
            wc counter = new wc();
            counter.counter(temp.getName(),temp);

            if (dataToCollect.isWordCount())
                getWordCount(counter, dataCollected);
            if (dataToCollect.isCharCount())
                getCharCount(counter, dataCollected);
            if (dataToCollect.isLineCount())
                getLineCount(counter, dataCollected);
        }
    }
    private void getWordCount(wc counter, DataCollected dataCollected){
        dataCollected.setFilename(counter.getFilename());
        dataCollected.setWcount(counter.getWcount());
    }
    private void getCharCount(wc counter, DataCollected dataCollected){
        dataCollected.setFilename(counter.getFilename());
        dataCollected.setCcount(counter.getCcount());
    }
    private void getLineCount(wc counter, DataCollected dataCollected){
        dataCollected.setFilename(counter.getFilename());
        dataCollected.setLcount(counter.getLcount());
    }

    private void getWLSCount(DataCollected dataCollected, File temp){
        wc counter = new wc();
        try {
            counter.counter(dataCollected.getFilename(),temp);
            dataCollected.setWcount(counter.getWcount());
            dataCollected.setLcount(counter.getLcount());
            dataCollected.setCcount(counter.getCcount());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getSourceLines(DataCollected dataCollected, File temp){
        //Replaced countSourceLines with lineCounter
        //countSourceLines counter = new countSourceLines();
        lineCounter counter = new lineCounter();
        int[] lineTally = {0, 0};
        try {
            /*dataCollected.setSlcount(counter.getSourceLines(temp));
            dataCollected.setCccount(counter.getCommentLines(temp));*/
            //getNumberOfLines returns an array of two length
            lineTally = counter.getNumberOfLines(temp);
            dataCollected.setSlcount(lineTally[0]);  //lineTally[0] is Source Lines
            dataCollected.setCccount(lineTally[1]);  //lineTally[1] is Comment Lines

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void getHalstead(DataCollected dataCollected, File temp){
        /* TODO: 12/2/2018 */
        Halstead halMetrics = new Halstead();
        try {
            halMetrics.compute(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        dataCollected.setOperators(halMetrics.getnOne());
        dataCollected.setOperands(halMetrics.getnTwo());
        dataCollected.setOperatorsT(halMetrics.getN1());
        dataCollected.setOperandsT(halMetrics.getN2());
        dataCollected.setVocab(dataCollected.getOperators()+dataCollected.getOperands());
        dataCollected.setPLength(dataCollected.getOperatorsT()+dataCollected.getOperandsT());
        dataCollected.setCPLength(String.format("%.3f", dataCollected.getOperators() * (Math.log(
                dataCollected.getOperators())/Math.log(2)) + (dataCollected.getOperands() *
                (Math.log(dataCollected.getOperands())/Math.log(2)))));
        dataCollected.setVolume(String.format("%.3f", dataCollected.getPLength() *
                (Math.log(dataCollected.getVocab())/Math.log(2))));
        dataCollected.setDifficulty(String.format("%.3f", ((double)dataCollected.getOperators()/2) *
                ((double)dataCollected.getOperandsT() / (double)dataCollected.getOperands())));
        dataCollected.setEffort(String.format("%.3f", Float.valueOf(dataCollected.getDifficulty()) *
                Float.valueOf(dataCollected.getVolume())));
        dataCollected.setTime(String.format("%.3f", Float.valueOf(dataCollected.getEffort())/18));

        dataCollected.setBugs(String.format("%.3f", Float.valueOf(dataCollected.getVolume())/3000));
        /*
        String.format("%.3f", )
    public double getBugs()
    {
        bugs = volume/3000;
        return bugs;
    }
         */

    }

    private void getCyclomaticComplexity(DataCollected dataCollected, File temp){
        countCyclomaticComplexity cyclomatic = new countCyclomaticComplexity();
        dataCollected.setCyclomaticComplexity(cyclomatic.checkForUniquePath(temp));
    }
    private void getDepthOfInheritance(DataCollected inheritance, File temp) {
        inheritance.setDepthOfInheritance(new countDepthOfInheritance().checkForInheritance(temp));
    }
    private void getMaintainabilityIndex(DataCollected maintain, File temp){
        maintain.setMaintainabilityIndex(new calculateMaintainabilityIndex().calculateMI(temp));
    }
}
