package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class Controller {
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
}
