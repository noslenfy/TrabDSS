/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOGeshabitat;

import BLGeshabitat.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nelson
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
        String sql = "INSERT INTO " + table + " (Rua,Nif,Telefone,Email,DtNascimento,Localidade,Nome,Cp,EstadoCivil) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";
       
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
                                  rst.getString("EstadoCivil"));
            ret.setId(rst.getInt("Id"));
        } catch (SQLException ex) {
            throw new PersistableException("Ocorreu um erro na crição da entidade (convertToResulSet())");
        }
        return ret;
    }
 
    
    

        

    
}
