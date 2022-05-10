import java.net.URL;
import java.sql.SQLException;
import java.util.*;
import javafx.application.Platform;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.util.*;

public class controller_add implements Initializable {

    @FXML
    private Button dodaj_btn;

    @FXML
    private TextField frekvenca_text;

    @FXML
    private TextField ime_text;

    @FXML
    private ComboBox<kraji> kraj_dropdown;

    @FXML
    private TextField naslov_text;

    @FXML
    void dodaj_btn(ActionEvent event) {

    }

    private String kraj_;

    public void set_kraji() throws SQLException {
        List<String> data = new baza().get_kraji();

        ObservableList<kraji> kraji = FXCollections.observableArrayList();

        for (int i = 0; i < data.size(); i++) {
            String[] values = data.get(i).toString().replace("(", "").replace(")", "").replace("\"", "").split(",");
            kraji.add(new kraji(Integer.parseInt(values[0]), values[1], values[2]));
        }
        kraj_dropdown.setItems(kraji);

        try {

            int index = 0;
            for (kraji _kraj : kraji) {
                if (Integer.parseInt(_kraj.getPostna_st()) == Integer.parseInt(kraj_)) {
                    kraj_dropdown.setValue(kraji.get(index));
                }
                index++;
            }
        } catch (Exception e) {
        }

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        try {
            Platform.runLater(() -> {

                kraj_dropdown.setConverter(new StringConverter<kraji>() {
                    @Override
                    public String toString(kraji kraj_dropdown) {
                        return kraj_dropdown.getIme() + " (" + kraj_dropdown.getPostna_st() + ")";
                    }

                    @Override
                    public kraji fromString(String string) {
                        return kraj_dropdown.getItems().stream().filter(ap -> ap.getIme().equals(string)).findFirst()
                                .orElse(null);
                    }
                });

                kraj_dropdown.valueProperty().addListener((obs, oldval, newval) -> {
                    if (newval != null)
                        // System.out.println("Selected: " + newval.getIme());
                        kraj_ = newval.getPostna_st();
                });

                try {
                    set_kraji();
                } catch (SQLException e) {
                }
            });

        } catch (Exception e) {
        }
    }

    public class kraji {
        private int id;
        private String ime;
        private String postna_st;

        kraji(int id_, String ime_, String postna_st_) {
            this.id = id_;
            this.ime = ime_;
            this.postna_st = postna_st_;
        }

        public int getId() {
            return id;
        }

        public String getIme() {
            return ime;
        }

        public String getPostna_st() {
            return postna_st;
        }
    }

    public void add(ActionEvent event) throws Exception {

        new baza().insert_radio(ime_text.getText(), frekvenca_text.getText(), naslov_text.getText(), kraj_);
        new launcher().SwitchToMainpage();
        ((Stage) dodaj_btn.getScene().getWindow()).close();

    }

}
