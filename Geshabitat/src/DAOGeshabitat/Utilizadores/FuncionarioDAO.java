/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOGeshabitat.Utilizadores;

import BLGeshabitat.Utilizadores.Funcionario;
import DAOGeshabitat.EntityDAO;
import DAOGeshabitat.FacadeDAO;
import DAOGeshabitat.PersistableException;
import static DAOGeshabitat.EntityDAO.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author 
 */
public class FuncionarioDAO extends EntityDAO{

    public FuncionarioDAO() {
    }

    @Override
    public PreparedStatement getInsertSqlStatement(String table) throws PersistableException
    {
        int autoGenerateKeys = PreparedStatement.RETURN_GENERATED_KEYS;
        Funcionario funcionario = (Funcionario)super.objectToPersist;
        PreparedStatement statement=null;
        String sql = "INSERT INTO " + table + " (Rua,Nif,Telefone,Email,DtNascimento,Localidade,Nome,Cp,EstadoCivil,Username,CFamilias,CFundos,CConstrucao) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
       
        try {
            statement = conn.prepareStatement(sql,autoGenerateKeys);
            
            statement.setString(1, funcionario.getRua());
            statement.setInt(2, funcionario.getNif());  
            statement.setString(3, funcionario.getTelefone());
            statement.setString(4, funcionario.getEmail());
            statement.setDate(5, funcionario.getDtNascimento());        
            statement.setString(6, funcionario.getLocalidade());
            statement.setString(7, funcionario.getNome());
            statement.setString(8, funcionario.getCp());
            statement.setString(9, funcionario.getEstadoCivil());  
            if(funcionario.getUsername().equals("")) statement.setNull(10, 0);
            else statement.setString(10, funcionario.getUsername());
            statement.setBoolean(11, funcionario.isCFamilias());
            statement.setBoolean(12, funcionario.isCFundos());
            statement.setBoolean(13, funcionario.isCConstrucao());            
        } catch (SQLException ex) { 
            throw new PersistableException("Erro ao criar o PreparedStatement!");
        }

        return statement;
    } 
    
    @Override
    public Funcionario convertResultSet(ResultSet rst) throws PersistableException {
            Funcionario ret;
        try {
            ret = new Funcionario(rst.getInt("Nif"),
                                  rst.getString("Nome"),
                                  rst.getString("Telefone"),
                                  rst.getString("Email"),
                                  rst.getString("Rua"),
                                  rst.getString("Localidade"),
                                  rst.getString("Cp"),
                                  rst.getDate("DtNascimento"),
                                  rst.getString("EstadoCivil"),                    
                                  rst.getString("Username"),
                                  rst.getBoolean("CFamilias"),
                                  rst.getBoolean("CFundos"),
                                  rst.getBoolean("CConstrucao"));
        ret.setId(rst.getInt("Id"));
        } catch (SQLException ex) {
            throw new PersistableException("Ocorreu um erro na crição da entidade (convertToResulSet())");
        }
        return ret;
    }
    
    @Override
    public int put(Object obj) throws PersistableException {
        this.objectToPersist = obj;
        int GeneratedKey;
        PreparedStatement statement = null;
        ResultSet keys = null;
        try {
            statement = this.getInsertSqlStatement(table);
            statement.executeUpdate(); 
            keys = statement.getGeneratedKeys();
            if(keys.next()) {
                 GeneratedKey=keys.getInt(1);
             }
             else {
                 throw new PersistableException("Ocorreu um erro na obtenção do Id!");
             }
       
        } catch (SQLException | PersistableException ex) {
            throw new PersistableException("Ocorreu um erro na criação do registo!" + ex.getMessage());
        } finally {
            try {
                if (statement != null)  statement.close();               
                if (keys != null) keys.close();
            } catch (SQLException ex) {
                throw new PersistableException("Ocorreu um erro ao fechar conexões!\n" + ex.getMessage());
            }   
        }
        
        
        //se for utilizador de sistema
        Funcionario f = (Funcionario)obj;
        if (f.getUsername()!=null) {
            
            try {
            
            //creating user
            String sql ="create user ?@? identified by ?";

            statement = conn.prepareStatement(sql);

            statement.setString(1, f.getUsername());
            statement.setString(2, FacadeDAO.HOST);
            statement.setString(3, FacadeDAO.DEFAULTUSERPASS);
                
            statement.execute();
          
            
            //granting privileges
            sql = "grant all on "+FacadeDAO.DATABASE+".* to ?@?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, f.getUsername());
            statement.setString(2, FacadeDAO.HOST);  
            statement.execute();
            
            
            //flushing
            sql = "flush privileges";
            statement = conn.prepareStatement(sql);
            statement.execute();

            
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                     if (statement != null)  statement.close();               
                } catch (SQLException ex) {
                throw new PersistableException("Ocorreu um erro ao fechar conexões!\n" + ex.getMessage());
                }  
            
            
            }
        }
        
        return  GeneratedKey;  

    }
    
    
    
    public List<Funcionario> getUsers() throws PersistableException {
        String sql = "SELECT * FROM " + EntityDAO.table + " where Username IS NOT NULL";
        
        List<Funcionario> ret = new ArrayList<>();
        
        PreparedStatement statement = null;
        ResultSet rst = null;
        
        try {
            statement = conn.prepareStatement(sql);           
            rst = statement.executeQuery();

            while(rst.next())
            {
                ret.add(this.convertResultSet(rst));
            }

        } catch (SQLException ex) { 
            throw new PersistableException ("Ocorreu um erro na obtenção do registo!" + ex.getMessage());
        } finally {
            try {
                if(statement != null) statement.close();
                if(rst != null) rst.close();
            } catch (SQLException ex) {
             throw new PersistableException ("Ocorreu um erro ao fechar as conexões!" + ex.getMessage());
            }
        }
        return ret;
    }

    public void setPassword(String username, String pass) throws PersistableException {
        PreparedStatement statement = null;
        ResultSet keys = null;
        String sql = "SET PASSWORD FOR ?@? = PASSWORD(?)";
        
        try {
            statement = conn.prepareStatement(sql);

            statement.setString(1, username);
            statement.setString(2, FacadeDAO.HOST);
            statement.setString(3, pass);

            statement.execute(); 

        } catch (SQLException ex) {
            throw new PersistableException("Ocorreu um erro ao criar utilizador!\n");
        } finally {
            try {
                if(statement != null) statement.close();
            } catch (SQLException ex) {
             throw new PersistableException ("Ocorreu um erro ao fechar as conexões!" + ex.getMessage());
            }

        }
    }
}
    


