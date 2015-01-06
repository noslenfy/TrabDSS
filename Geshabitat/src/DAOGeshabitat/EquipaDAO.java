/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOGeshabitat;

import BLGeshabitat.Equipa;
import BLGeshabitat.Voluntario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nelson
 */
public class EquipaDAO extends EntityDAO {
    
    public EquipaDAO() {
    }        

    @Override
    public PreparedStatement getInsertSqlStatement(String table) throws PersistableException {
       
        int autoGenerateKeys = PreparedStatement.RETURN_GENERATED_KEYS;
        Equipa equipa = (Equipa)super.objectToPersist;
        PreparedStatement statement=null;
        String sql = "INSERT INTO " + table + " (Nome,Funcionario_id) "
                + "VALUES (?,?)";
       
        try {
            statement = conn.prepareStatement(sql,autoGenerateKeys);
            
            statement.setString(1, equipa.getNome());
            statement.setInt(2, equipa.getFuncionario_Id());  
            
        } catch (SQLException ex) { 
            throw new PersistableException("Erro ao criar o PreparedStatement!");
        }

        return statement;
    } 
    
    public PreparedStatement getInsertSqlStatementEquipaVoluntario(String table, int Voluntario_Id, int Equipa_Id) throws PersistableException {
        
        PreparedStatement statement=null;
        String sql = "INSERT INTO " + table + " (Equipa_Id, Voluntario_Id) "
                + "VALUES (?,?)";
  
        try {
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, Equipa_Id);
            statement.setInt(2, Voluntario_Id);   
            
        } catch (SQLException ex) { 
            throw new PersistableException("Erro ao criar o PreparedStatement!");
        }

        return statement;
    } 
    
    @Override
    public Equipa convertResultSet(ResultSet rst) throws PersistableException {
            Equipa ret;
        try {
            ret = new Equipa(rst.getString("Nome"),
                             rst.getInt("Funcionario_id"));
            ret.setId(rst.getInt("Id"));
        } catch (SQLException ex) {
            throw new PersistableException("Ocorreu um erro na crição da entidade (convertToResulSet())");
        }
        return ret;
    }
        
    
    @Override
    public int put(Object obj) throws PersistableException {
        Equipa equipa = (Equipa)obj;
        List<Integer> voluntarios = equipa.getVoluntarios();

        this.objectToPersist = obj;
      
        int GeneratedKey=-1;
        PreparedStatement statement = null;
        ResultSet keys = null;
        
        try {
             //Begin Transaction
            conn.setAutoCommit(false);
            
            //Equipa
            statement = this.getInsertSqlStatement(table);
            statement.executeUpdate(); 
            
            //Obter id
            keys = statement.getGeneratedKeys();
            if(keys.next()) GeneratedKey=keys.getInt(1);
            else throw new PersistableException("Ocorreu um erro na obtenção do Id!");

            //Voluntarios
            for(Integer v : voluntarios) {
                statement=this.getInsertSqlStatementEquipaVoluntario(FacadeDAO.EQUIPAVOLUNTARIOTABLE, v, GeneratedKey);
                statement.executeUpdate(); 
            }
            
          
            conn.commit();
            
            
        } catch (SQLException | PersistableException ex) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex1) {
                    throw new PersistableException("Ocorreu um erro na criação do registo!\n" + ex.getMessage());
                }
            }
        } finally {
            try {
                if (statement != null)  statement.close();
                if (keys != null) keys.close();
                
            } catch (SQLException ex) {
                throw new PersistableException("Ocorreu um erro ao fechar conexões!\n" + ex.getMessage());
            }      
        }
        return  GeneratedKey; 
    }
    
    public Iterable getAll() throws PersistableException  {
        String sql = "SELECT * FROM " + EntityDAO.table;
        
        List<Object> ret = new ArrayList<>();
        
        PreparedStatement statement = null;
        ResultSet rst = null;
        
        try {
            statement = conn.prepareStatement(sql);           
            rst = statement.executeQuery();

            while(rst.next())
            {
                ret.add(this.convertResultSet(rst));
            }
            
       
            for(Object obj : ret) {
                Equipa eq = (Equipa)obj;
      
                eq.setVoluntarios(this.getVoluntarios(statement, eq.getId()));

                obj=eq;
            }
            
        } catch (SQLException ex) { 
            throw new PersistableException ("Ocorreu um erro na obtenção do registo!" + ex.getMessage());
        } finally {
            try {
                if (statement != null)  statement.close();
                if (rst != null) rst.close();
                
            } catch (SQLException ex) {
                throw new PersistableException("Ocorreu um erro ao fechar conexões!\n" + ex.getMessage());
            }  
        }

        return ret;
    } 
    

    private List<Integer> getVoluntarios(PreparedStatement statement, int Equipa_id) throws SQLException {
        String sql = "SELECT * FROM " + FacadeDAO.EQUIPAVOLUNTARIOTABLE +" WHERE Equipa_Id = " + Equipa_id;

        ResultSet rst = statement.executeQuery(sql);
        
        List<Integer> voluntarios = new ArrayList<>();
        while(rst.next()) {
            voluntarios.add((Integer)rst.getInt("Voluntario_Id"));
        }
        return voluntarios;
    }
}
