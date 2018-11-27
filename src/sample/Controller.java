package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Controller {
    private boolean wordcoutn, linecount, charcount;
    String url;
    @FXML
    private TextField uRLfield;
    @FXML
    private CheckBox checkBox1;
    @FXML
    private CheckBox checkBox2;
    @FXML
    private CheckBox checkBox3;
    @FXML
    public Button goButton;

    public void onClick() throws IOException {
        getURL();
        System.out.println(url);
        GitController counter = new GitController();
        counter.downloadRepo(url, wordcoutn, linecount, charcount);


    }
    //gets url from text field
    public void getURL(){
        url = uRLfield.getText();

    }

    public void  box1(){
        if(checkBox1.isSelected())
            wordcoutn = true;
        else
            wordcoutn = false;
        System.out.println(wordcoutn);
    }

    public void box2(){
        if(checkBox2.isSelected())
            linecount = true;
        else
            linecount = false;
        System.out.println(wordcoutn);
    }

    public void  box3(){
        if(checkBox3.isSelected())
            charcount = true;
        else
            charcount = false;
        System.out.println(wordcoutn);
    }




}
