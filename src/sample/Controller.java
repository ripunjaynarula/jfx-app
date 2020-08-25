package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;


public class Controller implements Initializable {
    @FXML private TextField newtask;
    @FXML private ListView<String> tasklist;
    private String filepath="tasks.txt";
    private File data= new File(filepath);
    public void addnewtask(ActionEvent e){
        String text= newtask.getText();

        if (!text.equals("")){
            tasklist.getItems().add(text);
            newtask.setText("");
        } else{
            System.out.println("NO INPUT PRESENT ");
        }

        //System.out.println(text);

    }
    public void exitprogram(ActionEvent e){
        List<String> currenttasks=tasklist.getItems();

        try {
           FileWriter writer = new FileWriter(filepath);
            for (String text: currenttasks){
                text+="\n";
                writer.write(text);
            }
            writer.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


        System.exit(0);
    }
    public void deletetask(ActionEvent e){
        String selected= tasklist.getSelectionModel().getSelectedItem();
        if (selected!=null){
            tasklist.getItems().remove(selected);
        } else {
            System.out.println("NO SELECTION MADE");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Scanner myReader= new Scanner(data);

            while (myReader.hasNextLine()){
                String text=myReader.nextLine();
                tasklist.getItems().add(text);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
