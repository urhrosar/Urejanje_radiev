import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.*;

public class controller_register {

    @FXML
    private Button exit_btn;

    @FXML
    private Label logIn_status;

    @FXML
    private PasswordField password_input;

    @FXML
    private Button register_btn;

    @FXML
    private TextField username_input;

    
    public void getData(ActionEvent event) throws Exception{
        System.out.println(username_input.getText());
        System.out.println(password_input.getText());
        new baza().writeToDatabase(username_input.getText(), password_input.getText());
        new launcher().SwitchToLoginpage();
        ((Stage) register_btn.getScene().getWindow()).close();
    }

}

