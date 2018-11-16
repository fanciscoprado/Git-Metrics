package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;


public class Counter {
    public void setup(String url, boolean w, boolean l, boolean c) throws IOException {

        File folder = new File("temp/");
        try {
            Git git = Git.cloneRepository()
                    .setURI(url)
                    .setDirectory(folder)
                    .call();

            ObservableList<Data> list = FXCollections.observableArrayList();
            makeList(folder,list);
            ResultBox resultBox = new ResultBox();
            resultBox.display(w,l,c,list);
            git.getRepository().close(); // Close all the things!
            git.close(); // Close all the things!
            removeall(folder);

        } catch (GitAPIException e) {

            e.printStackTrace();
        }


    }

    private void makeList(File folder,ObservableList<Data> list) throws IOException { //Makes linked list of wc objects that contain the metrics
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            String fname = file.getName();
            if(!file.isFile())
                makeList(file,list);
            else {
                Data temp = new Data();
                temp.collect(fname,file);
                if(!temp.isSkipped())
                    list.add(temp);
            }



        }

    }
    private void removeall(File folder){ // recusivly delets the git archive downloaded
        File[] listOfFiles = folder.listFiles();
        try {
            for (File temp : listOfFiles) {
                if (!temp.delete()) {
                    //System.out.println(temp.getName());
                    removeall(temp);
                }
                if (temp.delete()) {
                    System.out.println("deletet" + temp.getName());
                }

            }
        }catch (Exception e){
            System.out.println("could not delet");
            folder.setWritable(true);
            folder.delete();
        }
        folder.delete();
    }
}
