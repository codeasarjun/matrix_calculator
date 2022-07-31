import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class App  extends Application{
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        launch();
    }

    @Override
    public void start(Stage pStage) throws Exception {
    
       Parent root=FXMLLoader.load(getClass().getResource("mainUI.fxml"));
        Scene scene=new Scene(root);
        pStage.setTitle("Matrix Calculator");
        pStage.setScene(scene);
        pStage.show();
        

        
    }
}
