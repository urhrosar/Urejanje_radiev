import java.io.IOException;

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

    
    void SwitchToMainpage() throws Exception {
        Parent main = FXMLLoader.load(getClass().getResource("mainpage.fxml"));
        Stage stage = new Stage();
        //stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(main);
        stage.setScene(scene);
        stage.show();

    }

    
    void SwitchToLoginpage() throws Exception {
        Parent main = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage stage = new Stage();
        //stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(main);
        stage.setScene(scene);
        stage.show();

    }

    
    void SwitchToRegister() throws Exception  {
        //Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
        //stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        //scene = new Scene(root);
        //stage.setScene(scene);
        //stage.show();
        Stage stage = new Stage();
        Parent register = FXMLLoader.load(getClass().getResource("register.fxml"));
        Scene scene = new Scene(register);
        //scene.getStylesheets().add(getClass().getResource("GUI/style.css").toExternalForm());
        stage.setResizable(false);
        //stage.getIcons().add(new Image("assets/app_icon_b.png"));
        stage.setTitle("Register");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    

    public void SwitchToUredi() throws Exception
    {
        Parent main = FXMLLoader.load(getClass().getResource("uredi.fxml"));
        Stage stage = new Stage();
        //stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(main);
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}