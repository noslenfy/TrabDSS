/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOGeshabitat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author nelson
 */
public class FacadeDAO {
    private static final String DB_TYPE = "mysql";
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String USER = "root";
    private static final String PASSWORD = "220883";
    private static final String DATABASE = "GesHabitat";
    
  
    public static Connection conn;

    
    /// corrigir
    private static final String FuncionarioTable = "Funcionario";
    private static final String DoadorTable = "Doador";
    private static final String VoluntarioTable = "Voluntario";
    private static final String CandidaturaTable = "Candidatura";
    
    public FacadeDAO() {     
       this.connect();

    }
    
  
    private void connect(){
        try {
            conn = DriverManager.getConnection(getURL(), USER, PASSWORD);
        } catch (SQLException ex) {}
    }
    public void closeConnection(){
        try {
            conn.close();
        } catch (SQLException ex) {}
    }
            
    
    private static String getURL() {
        return "jdbc:" + DB_TYPE + "://" + HOST + ":" + PORT + "/" + DATABASE;
    }

    private String getTable(EntityDAO entity){
        if(entity instanceof FuncionarioDAO) return FuncionarioTable;
        if(entity instanceof VoluntarioDAO) return VoluntarioTable;
        if(entity instanceof DoadorDAO) return DoadorTable;
        if(entity instanceof DoadorDAO) return CandidaturaTable;
        return null;
    }
    
    public int put(EntityDAO entityTypeDAO, Object obj) throws PersistableException {
       EntityDAO.setConnection(conn, getTable(entityTypeDAO));  
       return entityTypeDAO.put(obj);
    }   
    public Object get(EntityDAO entityTypeDAO, int Id) throws PersistableException {
        EntityDAO.setConnection(conn, getTable(entityTypeDAO)); 
        return entityTypeDAO.get(Id);
    } 
    public Object get(EntityDAO entityTypeDAO, String Column, int Id) throws PersistableException {
        EntityDAO.setConnection(conn, getTable(entityTypeDAO)); 
        return entityTypeDAO.get(Column, Id);
    } 
    public List<Object> getAll(EntityDAO entityTypeDAO) throws PersistableException {
        EntityDAO.setConnection(conn, getTable(entityTypeDAO));
        ArrayList<Object> array = (ArrayList<Object>) entityTypeDAO.getAll();
        
        return array;
    }
    public List<Object> getAll(EntityDAO entityTypeDAO, String Column) throws PersistableException {
        EntityDAO.setConnection(conn, getTable(entityTypeDAO));
        ArrayList<Object> array = (ArrayList<Object>) entityTypeDAO.getAll(Column);
        
        return array;
    }
    public void delete(EntityDAO entityTypeDAO, int Id) throws PersistableException {
        EntityDAO.setConnection(conn, getTable(entityTypeDAO));
        entityTypeDAO.delete(Id);
    }
    public void deleteAll(EntityDAO entityTypeDAO) throws PersistableException {
        EntityDAO.setConnection(conn, getTable(entityTypeDAO));
        entityTypeDAO.deleteAll();
    }
    public long count(EntityDAO entityTypeDAO) throws PersistableException  {
        EntityDAO.setConnection(conn, getTable(entityTypeDAO));
        return entityTypeDAO.count();
    }   
    public boolean exists(EntityDAO entityTypeDAO, int id) throws PersistableException {
        EntityDAO.setConnection(conn, getTable(entityTypeDAO));
        return entityTypeDAO.exists(id);
    }
    
}
    
