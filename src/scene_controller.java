import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class scene_controller {

    private Stage stage;
    private Scene scene;
    private Parent rootParent;

    public void SwitchToLogin(ActionEvent event) throws IOException
    {
        rootParent = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(rootParent);
        stage.setScene(scene);
        stage.show();

    }

    public void SwitchToRegister(ActionEvent event) throws IOException
    {
        rootParent = FXMLLoader.load(getClass().getResource("register.fxml"));
        stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(rootParent);
        stage.setScene(scene);
        stage.show();

    }

    public void SwitchToMainpage(ActionEvent event) throws IOException
    {
        rootParent = FXMLLoader.load(getClass().getResource("mainpage.fxml"));
        stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(rootParent);
        stage.setScene(scene);
        stage.show();

    }

    public void SwitchToUredi(ActionEvent event) throws IOException
    {
        rootParent = FXMLLoader.load(getClass().getResource("uredi.fxml"));
        stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(rootParent);
        stage.setScene(scene);
        stage.show();

    }

}
