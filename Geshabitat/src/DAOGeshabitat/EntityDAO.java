/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOGeshabitat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;




public abstract class EntityDAO implements Persistable{ 

    public static Connection conn;
    public static String table;
    
    public Object objectToPersist;
  
    public abstract PreparedStatement getInsertSqlStatement(String table) throws PersistableException;
    
    public abstract Object convertResultSet(ResultSet rst) throws PersistableException ;
    
    public static void setConnection(Connection conn, String table) {
        EntityDAO.conn = conn;
        EntityDAO.table = table;
    }
    
    /**
     *
     * @param obj object of type compatible with EntityDAO to persist
     * @return Id of the created row 
     * @throws PersistableException
     */
    @Override
    public int put(Object obj) throws PersistableException {
        this.objectToPersist = obj;
        int GeneratedKey;
        try {
            PreparedStatement statement = this.getInsertSqlStatement(table);
            statement.executeUpdate(); 
            ResultSet keys = statement.getGeneratedKeys();
            if(keys.next()) {
                 GeneratedKey=keys.getInt(1);
             }
             else {
                 throw new PersistableException("Ocorreu um erro na obtenção do Id!");
             }
            statement.close();
            keys.close();
            return  GeneratedKey;         
        } catch (SQLException | PersistableException ex) {
            throw new PersistableException("Ocorreu um erro na criação do registo!" + ex.getMessage());
        }

    }

    @Override
    public void putAll(Collection entities) throws PersistableException {
        for(Object entity : entities) {
            this.put(entity);
        }
    }
    
    @Override
    public Object get(int Id) throws PersistableException {
       return this.get("Id", Id);
    }
    
    @Override
    public Object get(String Column, int Atribute) throws PersistableException {

        String sql = "SELECT * FROM " + EntityDAO.table + " where " + Column + " =?";
        Object ret=null;
        
        try {
            PreparedStatement statement = conn.prepareStatement(sql);           
            statement.setInt(1, Atribute);
            ResultSet rst = statement.executeQuery();
            
            while(rst.next())
            {
                if(ret != null) throw new PersistableException("Existe mais que um registo com esse id");
                ret=this.convertResultSet(rst);
            }
            statement.close();
            rst.close();
            
        } catch (SQLException ex) { 
            throw new PersistableException("Ocorreu um erro na obtenção do registo" + ex.getMessage());
        }  
        return ret;
    }
    
    @Override
    public Iterable getAll() throws PersistableException {
        String sql = "SELECT * FROM " + EntityDAO.table;
        
        List<Object> ret = new ArrayList<>();
        
        PreparedStatement statement;
        ResultSet rst;
        
        try {
            statement = conn.prepareStatement(sql);           
            rst = statement.executeQuery();

            while(rst.next())
            {
                ret.add(this.convertResultSet(rst));
            }
            statement.close();
            rst.close();
        } catch (SQLException ex) { 
            throw new PersistableException ("Ocorreu um erro na obtenção do registo!" + ex.getMessage());
        }  
        return ret;
    }

    @Override
    public Iterable getAll(String Column) throws PersistableException {
        String sql = "SELECT * FROM " + EntityDAO.table + " where " + Column + " = ?";
        
        List<Object> ret = new ArrayList<>();
        
        PreparedStatement statement;
        ResultSet rst;
        
        try {
            statement = conn.prepareStatement(sql);           
            rst = statement.executeQuery();

            while(rst.next())
            {
                ret.add(this.convertResultSet(rst));
            }
            statement.close();
            rst.close();
        } catch (SQLException ex) { 
            throw new PersistableException ("Ocorreu um erro na obtenção do registo!" + ex.getMessage());
        }  
        return ret;
    }
    
    @Override
    public void delete(int Id) throws PersistableException {
        String sql = "delete from " + EntityDAO.table + " where Id=?";

        
        try {
            PreparedStatement statement = conn.prepareStatement(sql);           
            statement.setInt(1, Id);
            statement.executeUpdate();
            statement.close();

        } catch (SQLException ex) { 
            throw new PersistableException("Ocorreu um erro na eliminação do registo" + ex.getMessage());
        }  
    }  
    
    @Override
    public void deleteAll() throws PersistableException {
        String sql = "delete from " + EntityDAO.table;
         try {
            Statement statement = conn.prepareStatement(sql);           
            statement.executeUpdate(sql);
            statement.close();

        } catch (SQLException ex) { 
            throw new PersistableException("Ocorreu um erro na eliminação do registo" + ex.getMessage());
        }
        
    }
    
    @Override
    public long count() throws PersistableException {

        String sql =  "select count(*) as n from " + EntityDAO.table;
        int count=-1;
        int sucess=0;
        
         try {           
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next()) {
                if(sucess==1) throw new PersistableException("Ocorreu um erro na eliminação do registo");
                
                count = result.getInt("n");
                sucess=1;
            }
            statement.close();
         } catch (SQLException ex) {
            throw new PersistableException("Ocorreu um erro na eliminação do registo" + ex.getMessage());
        }
         
        return count;
    }
       
    @Override
    public boolean exists(int id) throws PersistableException {
        return this.get(id) != null;
    }

    
    
    
    
    //Falta implementar
    
    @Override
    public void update(Object entity) throws PersistableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Iterable getAll(Collection<Integer> ids) throws PersistableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll(Collection entidades) throws PersistableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }








    
    
}