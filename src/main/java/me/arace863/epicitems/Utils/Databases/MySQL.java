/*
  Made by ARace863

  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

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

    private String host;
    private String port;
    private String database;
    private String username;
    private String password;

    private Connection connection;

    public boolean isConnected() {
        return (connection == null ? false : true);
    }

    public void connect() throws ClassNotFoundException, SQLException {
        if (!isConnected()){
            host = config.getString("host");
            port = config.getString("port");
            database = config.getString("database");
            username = config.getString("username");
            password = config.getString("password");

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
