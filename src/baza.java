import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class baza {

    private Connection db;

    private void connect() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String url = "jdbc:postgresql://tyke.db.elephantsql.com:5432/mdxsxkup";
        String username = "mdxsxkup";
        String password = "wJId9csfFnBUtHbb6ntXhEmLGx5IkB1o";

        try {
            db = DriverManager.getConnection(url, username, password);
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeToDatabase(String userName, String userPass)  {
        try{

            connect();
            
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(String.format("INSERT INTO uporabniki(uporabnisko, geslo) VALUES('%s', '%s')", userName, userPass));
            
            rs.close();
            st.close();
        }
        catch(Exception e){}

    }

    public boolean login(String username, String password) throws SQLException {
        connect();

        boolean login_success = false;

        Statement st = db.createStatement();
        ResultSet rs = st.executeQuery(String.format("SELECT login('%s', '%s')", username, password));

        while (rs.next()) {
            login_success = rs.getBoolean(1);
            System.out.println(login_success);
        }
        rs.close();
        st.close();

        return login_success;
    }

    public List<String> get_main_data() throws SQLException {
        connect();

        Statement st = db.createStatement();
        ResultSet rs = st.executeQuery("SELECT data();");

        List<String> data = new ArrayList<>();

        while (rs.next()) {
            data.add(rs.getString(1));
        }

        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }
        rs.close();
        st.close();

        return data;
    }

    public void delete(int id) throws SQLException {
        connect();

        Statement st = db.createStatement();
        ResultSet rs = st.executeQuery(String.format("SELECT remove(%s);", id));

        rs.close();
        st.close();
    }

    
}
