
package com.makila.videoclub.modelo.DAO;

import com.makila.videoclub.modelo.Country;
import com.makila.videoclub.servisios.Fachada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class CountryDAO {
    
    
    public static ArrayList<Country> listadoCountry(){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Country> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql = "SELECT * FROM country ORDER BY muni_nomb";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            Country country = null;
            while(rs.next()){
                
            }
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return listado;
    }
}
