package sample;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class FileHandler {
    public LinkedList parseFiles(DataToCollect dataToCollect) throws IOException {
        File folder = new File("temp/");
        LinkedList<File> fileList = new LinkedList<>();
        LinkedList<File> flist = makeList(folder, fileList,dataToCollect);



        return  flist;
    }

    private LinkedList makeList(File folder, LinkedList<File> list, DataToCollect dataToCollect) throws IOException { //Makes observable list of DataColected objects that contain the metrics
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            String fname = file.getName();
            if(!file.isFile())
                makeList(file,list,dataToCollect);
            else {//add file to list
                if(fileNeeded(file,dataToCollect)){
                    list.push(file);
                }
            }
        }
        return list;
    }

    private boolean fileNeeded(File file, DataToCollect dataToCollect){


        String extension = "";
        String fileName = file.getName();
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i + 1);
        }

        if(dataToCollect.isDoCppFile()){
            if(extension.equals("cpp"))
                return true;
        }
        if (dataToCollect.isDoJavaFile())
            if(extension.equals("java"))
                return true;


        return false;
    }

}
