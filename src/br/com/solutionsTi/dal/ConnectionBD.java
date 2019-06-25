package br.com.solutionsTi.dal;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlbertoRochaPinalli
 */
public class ConnectionBD {

    public static Connection getConnection() {
        java.sql.Connection conexao = null;
        String driver = "com.mysql.jdbc.Driver";//chama o driver
        String url = "jdbc:mysql://localhost:3306/bdti";//armazena informações do banco
        String user = "root";
        String password = "";
        //estabelece a conexaoo
        try {
            Class.forName(driver);//executa o driver
            conexao = DriverManager.getConnection(url,user,password);
            return conexao;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não possível iniciar o banco");
             return null;
        }
       

    }
}
