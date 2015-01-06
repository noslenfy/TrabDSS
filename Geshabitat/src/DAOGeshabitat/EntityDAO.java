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
import java.util.Date;
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
    
    /**
     * Actualiza um registo na base dados de acordo com a coluna e valor fornecidos, usando a chave estrabageira na forma
     * Tablename.Id para selecionar registo a actualizar
     * 
     * Update table Set Column = newValue where 'tableId' = Id
     * @param table
     * @param column - Nome do atributo a actualizar
     * @param newvalue
     * @param Id - Id da chave estrageira (Nota - apenas com chaves estrangeiras do tipo Nome.Id)
     * @throws PersistableException
     */
    @Override
    public void update(String table, String column, Object newvalue, int Id) throws PersistableException{
        //update table Set Recibo=1 where Doacao.Id = 1;
        String tableId = table+".Id";
        String sql = "UPDATE " + table + " SET " + column + " = ? " + " WHERE " + tableId + " = ?";

        PreparedStatement statement = null;
               
        try {
            statement = conn.prepareStatement(sql);
            if(newvalue instanceof String)  statement.setString(1, (String)newvalue);
            if(newvalue instanceof Date)  statement.setDate(1, new java.sql.Date(((Date)newvalue).getTime()));
            
            statement.setInt(2, Id);
 
            statement.executeUpdate(); 

            
            
        } catch (SQLException ex) {
            throw new PersistableException("Ocorreu um erro na actualização do registo!\n" + ex.getMessage());
        } finally {
            try {
                if (statement != null)  statement.close();               
            } catch (SQLException ex) {
                throw new PersistableException("Ocorreu um erro ao fechar conexões!\n" + ex.getMessage());
            }      
        }
    }

    
    @Override
    public Object get(int Id) throws PersistableException {
       return this.get("Id", Id);
    }
    
    @Override
    public Iterable getAll(Collection<Integer> ids) throws PersistableException {
        List<Object> ret = new ArrayList<>();
        for(Integer id : ids) {
            ret.add(get(id));
        }
        return ret;
    }
    
    
    @Override
    public Object get(String Column, int Value) throws PersistableException {

        String sql = "SELECT * FROM " + EntityDAO.table + " where " + Column + " =?";
        Object ret=null;
        
        try {
            PreparedStatement statement = conn.prepareStatement(sql);           
            statement.setInt(1, Value);
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
    public Object get(String Column, String Value) throws PersistableException {

        String sql = "SELECT * FROM " + EntityDAO.table + " where " + Column + " =?";
        Object ret=null;
        
        try {
            PreparedStatement statement = conn.prepareStatement(sql);           
            statement.setString(1, Value);
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
    public String get(String fieldToShow, String Column, String Value) throws PersistableException {

        String sql = "SELECT " + fieldToShow + " FROM " + EntityDAO.table + " where " + Column + " =?";
        String ret=null;
        
        try {
            PreparedStatement statement = conn.prepareStatement(sql);           
            statement.setString(1, Value);
            ResultSet rst = statement.executeQuery();
            
            while(rst.next())
            {
                if(ret != null) throw new PersistableException("Existe mais que um registo com esse id");
                ret=rst.getString(fieldToShow);
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

    /**
     * Retorna todos os elementos de uma tabela que cumpram um requisito
     * @param Atribute
     * @param Value
     * @return
     * @throws PersistableException
     */
    @Override
    public Iterable getAll(String Atribute, String Value) throws PersistableException {
        String sql = "SELECT * FROM " + EntityDAO.table + " where " + Atribute + " = ?";
        
        List<Object> ret = new ArrayList<>();
        
        PreparedStatement statement;
        ResultSet rst;
        
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, Value);
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

    /**
     *Testa se existem elementos com os criterios indicados.
     * SELECT * FROM EntityDAO.table where Column=Value
     * @param Column
     * @param Value
     * @return
     * @throws PersistableException
     */
    @Override
    public boolean exists(String Column, String Value) throws PersistableException {
        return this.get(Column,Value) != null;
    }
    
    
    
    
    //Falta implementar
    
    
    
    @Override
    public void deleteAll(Collection entidades) throws PersistableException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }








    
    
}