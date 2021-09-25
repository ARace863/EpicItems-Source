package me.arace863.epicitems.Utils.Databases;

import me.arace863.epicitems.EpicItems;
import org.bukkit.configuration.file.FileConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {
    FileConfiguration config;

    public MySQL(EpicItems plugin) {
        this.config = plugin.getConfig();
    }

    private String host = "localhost";
    private String port = "3306";
    private String database = "acenetwork";
    private String username = "root";
    private String password = "password";

    private Connection connection;

    public boolean isConnected() {
        return (connection == null ? false : true);
    }

    public void connect() throws ClassNotFoundException, SQLException {
        if (!isConnected()){
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false", username, password);
        }
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
