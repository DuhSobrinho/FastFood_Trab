package FastFood;


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Eduardo
 */
public class Index extends Application {
    private static Scene scene;
    private static Stage stage;
    
    @Override
    public void start(Stage mainStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        scene = new Scene(root);
        scene.getStylesheets().add("Model/Index.css");
        
        stage = mainStage;
        stage.setScene(scene);
        stage.setTitle("Fries of Destiny");
        stage.show();
    }
    
    public static void irParaHome() throws IOException {
        Parent root = FXMLLoader.load(Index.class.getResource("/View/Index.fxml"));
        scene.setRoot(root);
        stage.setMaximized(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
