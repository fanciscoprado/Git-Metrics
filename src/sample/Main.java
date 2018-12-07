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


    public static void main(String[] args) {
        File file = new File("temp/");
        if(file.exists())
            deletTemp(file);
        launch(args);
    }


    public static void deletTemp(File folder){ // recusivly delets the git archive downloaded
        File[] listOfFiles = folder.listFiles();
        try {
            for (File temp : listOfFiles) {
                if (!temp.delete()) {
                    deletTemp(temp);
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
