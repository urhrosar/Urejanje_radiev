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

public class controller_edit implements Initializable {

    @FXML
    private TextField frekvenca_text;

    @FXML
    private TextField ime_text;

    @FXML
    private ComboBox<kraji> kraj_dropdown;

    @FXML
    private TextField naslov_text;

    @FXML
    private Button uredim_btn;

    private int item_id;
    private String kraj_;

    

    public void insert_into_textField() throws Exception {
        try {

            String data = new baza().get_data(item_id);

            System.out.println(data);

            String[] values = data.replace("(", "").replace(")", "").replace("\"", "").split(",");
            ime_text.setText(values[1]);
            frekvenca_text.setText(values[2]);
            naslov_text.setText(values[3]);

            kraj_ = values[5];

        } catch (Exception e) {
        }
    }

    public void set_kraji() throws SQLException {
        List<String> data = new baza().get_kraji();

        ObservableList<kraji> kraji = FXCollections.observableArrayList();

        for (int i = 0; i < data.size(); i++) {
            String[] values = data.get(i).toString().replace("(", "").replace(")", "").replace("\"", "").split(",");
            kraji.add(new kraji(Integer.parseInt(values[0]), values[1], values[2]));
        }
        kraj_dropdown.setItems(kraji);

        
            int index = 0;
            for (kraji _kraj : kraji) {
                if (Integer.parseInt(_kraj.getPostna_st()) == Integer.parseInt(kraj_)) {
                    kraj_dropdown.setValue(kraji.get(index));
                }
                index++;
            }
        
    }

    public void init(int id) {
        item_id = id;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        try {
            Platform.runLater(() -> {

                try {
                    insert_into_textField();
                } catch (Exception e) {

                }

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

   public void uredi(ActionEvent event) throws Exception {

        new baza().update_radija(Integer.toString(item_id), ime_text.getText(), frekvenca_text.getText(), naslov_text.getText(), kraj_);
        new launcher().SwitchToMainpage();
            ((Stage) uredim_btn.getScene().getWindow()).close();

    }

}
