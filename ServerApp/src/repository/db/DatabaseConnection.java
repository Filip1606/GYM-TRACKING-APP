/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Filip
 */
public class DatabaseConnection {

    private List<Connection> connectionPool;
    private static DatabaseConnection instance;
    Properties properties = new Properties();
    
    private Connection connection;

    private DatabaseConnection() throws SQLException {
        connectionPool = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            try {
             
                properties.load(new FileInputStream("dbconfig.properties"));
                String url = properties.getProperty("url");
                String username = properties.getProperty("user");
                String password = properties.getProperty("password");
                Connection konekcija = DriverManager.getConnection(url, username, password);
                konekcija.setAutoCommit(false);
                connectionPool.add(konekcija);
            } catch (Exception ex) {
                System.out.println("Greska! Konekcija sa bazom nije uspesno uspostavljena!\n" + ex.getMessage());
                ex.printStackTrace();
                //throw ex;
            }
        }
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public synchronized void push(Connection connection) {
        connectionPool.add(connection);
    }

    public synchronized Connection pop() throws Exception {
        if (connectionPool.isEmpty()) {
            throw new Exception("Nema slobodne konekcije");
        }
        Connection connection = connectionPool.get(0);
        connectionPool.remove(0);
        return connection;
    }
}
