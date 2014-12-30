/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOGeshabitat;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author nelson
 */
public class DBConnection implements Serializable{
    private String db_type;
    private String host;
    private String port;
    private String user;
    private String password;
    private String database;

    public DBConnection(String db_type, String host, String port, String user, String password, String database) {
        this.db_type = db_type;
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
        this.database = database;
    }

    public String getDb_type() {
        return db_type;
    }
    public String getHost() {
        return host;
    }
    public String getPort() {
        return port;
    }
    public String getUser() {
        return user;
    }
    public String getPassword() {
        return password;
    }
    public String getDatabase() {
        return database;
    }

    public void setDb_type(String db_type) {
        this.db_type = db_type;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public void setPort(String port) {
        this.port = port;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setDatabase(String database) {
        this.database = database;
    }


    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.db_type);
        hash = 83 * hash + Objects.hashCode(this.host);
        hash = 83 * hash + Objects.hashCode(this.port);
        hash = 83 * hash + Objects.hashCode(this.user);
        hash = 83 * hash + Objects.hashCode(this.password);
        hash = 83 * hash + Objects.hashCode(this.database);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DBConnection other = (DBConnection) obj;
        if (!Objects.equals(this.db_type, other.db_type)) {
            return false;
        }
        if (!Objects.equals(this.host, other.host)) {
            return false;
        }
        if (!Objects.equals(this.port, other.port)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.database, other.database)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBConnection{" + "db_type=" + db_type + ", host=" + host + ", port=" + port + ", user=" + user + ", password=" + password + ", database=" + database + '}';
    }
    
    
    public void save(String file) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(this);
            oos.flush();
     }
    
    public static DBConnection load(String file) throws IOException, ClassNotFoundException {
        ObjectInputStream ios = new ObjectInputStream(new FileInputStream(file));
        DBConnection db = (DBConnection) ios.readObject();
        return db;
   }
}
