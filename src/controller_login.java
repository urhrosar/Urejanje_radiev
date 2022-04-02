import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.*;

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
    
    public static boolean loged_in = false;

    public void SwitchToRegister(ActionEvent event) throws Exception {
        new launcher().SwitchToRegister();
        ((Stage) register_btn.getScene().getWindow()).close();
    }

    public void SwitchToMainpage(ActionEvent event) throws Exception {
        loged_in = new baza().login(username_input.getText(), password_input.getText());
        check_login();
    }


    public void check_login() throws Exception {
        if (loged_in == true) {
            new launcher().SwitchToMainpage();
            ((Stage) login_btn.getScene().getWindow()).close();
        } else if (loged_in == false) {
            System.out.println("failed");
            username_input.setText("");
            password_input.setText("");
        }
    }
    

}