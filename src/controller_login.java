import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class controller_login {

    @FXML
    private Label logIn_status;
    @FXML
    private TextField username_input;
    @FXML
    private PasswordField password_input;
    @FXML
    private Button login_btn;
    @FXML
    private Button register_btn;

    @FXML
    protected void onHelloButtonClick() {
        logIn_status.setText("Welcome to JavaFX Application!");
    }

    public void getData(ActionEvent actionEvent) {
        System.out.println(username_input.getText());
        System.out.println(password_input.getText());
        baza.writeToDatabase(username_input.getText(), password_input.getText());

    }
}