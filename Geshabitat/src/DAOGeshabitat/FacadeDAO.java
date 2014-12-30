/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOGeshabitat;

import BLGeshabitat.Funcionario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author nelson
 */
public final class FacadeDAO {
    private static String DB_TYPE;// = "mysql";
    private static String HOST;// = "localhost";
    private static String PORT;// = "3306";
    private static String USER;// = "root";
    private static String PASSWORD;//
    private static String DATABASE;// = "GesHabitat";
    
  
    public static Connection conn;

    
    /// corrigir
    public static final String FUNCIONARIOTABLE = "Funcionario";
    public static final String DOADORTABLE = "Doador";
    public static final String VOLUNTARIOTABLE = "Voluntario";
    public static final String CANDIDATURATABLE = "Candidatura";
    public static final String MATERIALTABLE = "Material";
    public static final String FAMILIARTABLE = "Familia";
    public static final String ANEXOSTABLE = "Anexos";
    public static final String DOACAOTABLE = "Doacao";
    public static final String DOACAOMATERIALTABLE = "DoacaoMaterial";
    public static final String PROJECTOTABLE = "Projecto";
    
    public FacadeDAO() {     


    }
    
    public FacadeDAO(DBConnection conn) throws PersistableException {     
        FacadeDAO.DB_TYPE=conn.getDb_type();
        FacadeDAO.HOST=conn.getHost();
        FacadeDAO.PORT=conn.getPort();
        FacadeDAO.USER=conn.getUser();
        FacadeDAO.PASSWORD=conn.getPassword();
        FacadeDAO.DATABASE=conn.getDatabase();
        this.connect();
    }
  
    public void connect() throws PersistableException{
        try {
            conn = DriverManager. getConnection(getURL(), USER, PASSWORD);
        } catch (SQLException ex) {
            throw new PersistableException("Erro na conexão à basedados!");
        }
    }
    public void closeConnection()throws PersistableException{
        try {
            conn.close();
        } catch (SQLException ex) {
            throw new PersistableException("Erro na conexão à basedados!");
        }
    }
            
    
    private static String getURL() {
        return "jdbc:" + DB_TYPE + "://" + HOST + ":" + PORT + "/" + DATABASE;
    }

    private String getTable(EntityDAO entity){
        if(entity instanceof FuncionarioDAO) return FUNCIONARIOTABLE;
        if(entity instanceof VoluntarioDAO) return VOLUNTARIOTABLE;
        if(entity instanceof DoadorDAO) return DOADORTABLE;
        if(entity instanceof CandidaturaDAO) return CANDIDATURATABLE;
        if(entity instanceof MaterialDAO) return MATERIALTABLE;
        if(entity instanceof DoacaoDAO) return DOACAOTABLE;
        if(entity instanceof ProjectoDAO) return PROJECTOTABLE;
        return null;
    }
    
    public int put(EntityDAO entityTypeDAO, Object obj) throws PersistableException {
       EntityDAO.setConnection(conn, getTable(entityTypeDAO));  
       return entityTypeDAO.put(obj);
    }
    public void update(EntityDAO entityTypeDAO, String column, String value, int Id) throws PersistableException {
       EntityDAO.setConnection(conn, getTable(entityTypeDAO));  
       entityTypeDAO.update(getTable(entityTypeDAO),column, value, Id);
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
    public boolean exists(EntityDAO entityTypeDAO, String Column, String Value) throws PersistableException {
        EntityDAO.setConnection(conn, getTable(entityTypeDAO));
        return entityTypeDAO.exists(Column, Value);
    }
    
    
    public float getTotalDoacoes(int Doador_Id) throws PersistableException {
        return new DoadorDAO().getTotalDoacoes(Doador_Id);
    }  
    
}
    
