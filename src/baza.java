import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class baza {

    public static void writeToDatabase(String userName, String userPass) {

        String url = "jdbc:postgresql://tyke.db.elephantsql.com:5432/mdxsxkup";
        String user = "test";
        String password = "test";

        String username_input = userName;
        String password_input= userPass;


        // query
        String query = "INSERT INTO uporabniki(uporabnisko, pass) " +
                        "VALUES(?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, userName);
            pst.setString(2, userPass);
            pst.executeUpdate();
            System.out.println("Sucessfully created.");

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(baza.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }
}

