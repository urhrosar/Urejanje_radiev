import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class controller_mainpage implements Initializable { 

    @FXML
    private TableView <element> Tabela_radiev;
    @FXML
    private TableColumn <element, String> id_radia;
    @FXML
    private TableColumn <element, String> ime_radia;
    @FXML
    private TableColumn <element, String> frekvenca_radia;
    @FXML
    private TableColumn <element, String> kraj_radia;
    @FXML
    private TableColumn <element, String> naslov_radia;
    @FXML
    private Button dodaj_btn;
    @FXML
    private Button uredi_btn;
    @FXML
    private Button brisi_btn;

    public void insert_into_table() throws Exception {
        try {
            Tabela_radiev.getItems().clear();
            List<String> data = new baza().get_main_data();

            ObservableList<element> tableElements = FXCollections.observableArrayList();
            for (int i = 0; i < data.size(); i++) {
                String[] values = data.get(i).toString().replace("(", "").replace(")", "").replace("\"", "").split(",");
                tableElements.add(new element(values[0], values[1], values[2], values[3], values[4]));
            }

            Tabela_radiev.setItems(tableElements);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        try {

            id_radia.setCellValueFactory(new PropertyValueFactory<element, String>("id_radia")); 
            ime_radia.setCellValueFactory(new PropertyValueFactory<element, String>("ime_radia"));
            frekvenca_radia.setCellValueFactory(new PropertyValueFactory<element, String>("frekvenca_radia"));
            kraj_radia.setCellValueFactory(new PropertyValueFactory<element, String>("kraj_radia"));
            naslov_radia.setCellValueFactory(new PropertyValueFactory<element, String>("naslov_radia"));
            

            insert_into_table();
        } catch (Exception e) {
        }
    }

    public class element {
        private SimpleStringProperty id_radia;
        private SimpleStringProperty ime_radia;
        private SimpleStringProperty frekvenca_radia;
        private SimpleStringProperty kraj_radia;
        private SimpleStringProperty naslov_radia;

        public element(String id_radia_, String ime_radia_, String frekvenca_radia_, String kraj_radia_, String naslov_radia_){
            this.id_radia = new SimpleStringProperty(id_radia_);
            this.ime_radia = new SimpleStringProperty(ime_radia_);
            this.frekvenca_radia = new SimpleStringProperty(frekvenca_radia_);
            this.kraj_radia = new SimpleStringProperty(kraj_radia_);
            this.naslov_radia = new SimpleStringProperty(naslov_radia_); 
        }

        public final String getId_radia(){
            return id_radia.get();
        }
        public final String getIme_radia(){
            return ime_radia.get();
        }
        public final String getFrekvenca_radia(){
            return frekvenca_radia.get();
        }
        public final String getKraj_radia(){
            return kraj_radia.get();
        }
        public final String getNaslov_radia(){
            return naslov_radia.get();
        }
      
    }

    public void delete_item(ActionEvent event) throws Exception {
        new baza().delete(get_selectedItemId());
        insert_into_table();
    }
    
    public int get_selectedItemId(){
        return Integer.parseInt(Tabela_radiev.getSelectionModel().getSelectedItem().getId_radia());
    }

    public void SwitchToUredi_(ActionEvent event) throws Exception {
        System.out.println(get_selectedItemId());
        new launcher().SwitchToUredi(get_selectedItemId());
        ((Stage)dodaj_btn.getScene().getWindow()).close();
        
    }

    public void SwitchToDodaj_(ActionEvent event) throws Exception {
        new launcher().SwitchToDodaj();
        ((Stage)dodaj_btn.getScene().getWindow()).close();
    }



    public void Izvozi_(ActionEvent event) throws Exception {

        List<String> data = new baza().get_main_data();

        ObservableList<element> tableElements = FXCollections.observableArrayList();
        String izpis = "";
        for (int i = 0; i < data.size(); i++) {
            String[] izpisf = data.get(i).toString().replace("(", "").replace(")", "").replace("\"", "").split(",");
            izpis += izpisf[0] + ";" + izpisf[1] + ";" + izpisf[2] + ";" + izpisf[3] + ";" + izpisf[4] + "\n";
        }


        OutputStream os = new FileOutputStream("izvoz.csv");
        os.write(239);
        os.write(187);
        os.write(191);
    
        PrintWriter w = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
        System.out.println(izpis);
        w.print(izpis);
        w.flush();
        w.close();
    //use ; for new cell and \n for new row
    }

}