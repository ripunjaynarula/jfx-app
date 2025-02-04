package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene primaryscene=new Scene(root, 300, 275);
        primaryStage.setTitle("19BCE0470 To-do List");
        primaryStage.setScene(primaryscene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
