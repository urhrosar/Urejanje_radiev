import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class scene_controller extends Application{

    private Stage stage;
    private Scene scene;


    @FXML
    private Button exit_btn;

    @FXML
    private Label logIn_status;

    @FXML
    private Button login_btn;

    @FXML
    private PasswordField password_input;

    @FXML
    private Button register_btn;

    @FXML
    private TextField username_input;

    @FXML
    void SwitchToMainpage(ActionEvent event) throws IOException {
        Parent main = FXMLLoader.load(getClass().getResource("mainpage.fxml"));
        stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(main);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void SwitchToLoginpage(ActionEvent event) throws IOException {
        Parent main = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(main);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void SwitchToRegister(ActionEvent event) throws IOException {
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





 
    

    public void SwitchToUredi(ActionEvent event) throws IOException
    {
        Parent main = FXMLLoader.load(getClass().getResource("uredi.fxml"));
        stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(main);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void start(Stage arg0) throws Exception {
        // TODO Auto-generated method stub
        
    }

}
