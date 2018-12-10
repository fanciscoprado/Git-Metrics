package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Image image = new Image("icon.png");
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("Metrics");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) { // starts the intial del, then get doubled checked by deletTemp method in main
        File file = new File("temp/");
        if(file.exists())
            deletTemp(file);
        launch(args);
    }


    public static void deletTemp(File folder){ // recusivly deletes the git archive downloaded
        File[] listOfFiles = folder.listFiles();
        try {
            for (File temp : listOfFiles) {
                if (!temp.delete()) {
                    deletTemp(temp);
                }
                if (temp.delete()) {
                    System.out.println("delete" + temp.getName());
                }

            }
        }catch (Exception e){
            System.out.println("could not delete");
            folder.setWritable(true);
            folder.delete();
        }
        folder.delete();
    }
}
