import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class launcher extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("login.fxml"));
        // Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        // stage.setTitle("login-Urejanje_radiev");
        // stage.setScene(scene);
        // stage.show();
        test();
    }
    public void test() throws Exception {
        Stage stage = new Stage();
        Parent main = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setTitle("Urejanje radiev");
        stage.setScene(new Scene(main));
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}