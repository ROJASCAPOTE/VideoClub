/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makila.videoclub.servisios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER E5
 */
public class Fachada {

    private static Connection con = null;

    public static Connection getConnection() {
        try {
            if (con == null) {
                //Determina cuando se termina el programa
                Runtime.getRuntime().addShutdownHook(new MiShDwnHook());
                //Recupera los parámetros de conexión del archivo 
                //jdbc.properties
                ResourceBundle rb = ResourceBundle.getBundle("Servicios.jdbc");
                String driver = rb.getString("driver");
                String url = rb.getString("url");
                String pwd = rb.getString("pwd");
                String usr = rb.getString("usr");

                Class.forName(driver);
                con = DriverManager.getConnection(url, usr, pwd);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : "
                    + ex.getMessage());
        }
        return con;
    }

    static class MiShDwnHook extends Thread {

        //Justo antes de finaliza el programa la JVM invocará
        //este método donde podemos cerra la conexión
        @Override
        public void run() {
            try {
                Connection con = Fachada.getConnection();
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error : "
                        + ex.getMessage());
            }
        }
    }
}
