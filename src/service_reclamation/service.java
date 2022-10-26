/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service_reclamation;

/**
 *
 * @author khchi
 */import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class service {
    




     public List<reclamation> getAllreclamations() throws SQLException {

        List<reclamation> list = new ArrayList<>();
        String req = "select * from reclamation";
        Statement st = mysqlconnect.connectDB().createStatement();
        ResultSet rst = st.executeQuery(req);

        while (rst.next()) {
            reclamation r = new reclamation(rst.getInt("id"),rst.getInt("client_id"), rst.getString("sujet"), rst.getString("description"));
           
            list.add(r);
        }
        return list;
    }
}