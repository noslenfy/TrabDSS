/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOGeshabitat.Fundos;

import BLGeshabitat.Fundos.Voluntario;
import DAOGeshabitat.EntityDAO;
import DAOGeshabitat.PersistableException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 
 */
public class VoluntarioDAO extends EntityDAO{

    public VoluntarioDAO() {
    }
    

    @Override
    public PreparedStatement getInsertSqlStatement(String table) throws PersistableException
    {
        int autoGenerateKeys = PreparedStatement.RETURN_GENERATED_KEYS;
        Voluntario voluntario = (Voluntario)super.objectToPersist;   
        PreparedStatement statement=null;
        String sql = "INSERT INTO " + table + " (Rua,Nif,Telefone,Email,DtNascimento,Localidade,Nome,Cp,Nacionalidade,Profissao) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
       
        try {
            statement = conn.prepareStatement(sql,autoGenerateKeys);
            
            statement.setString(1, voluntario.getRua());
            statement.setInt(2, voluntario.getNif());  
            statement.setString(3, voluntario.getTelefone());
            statement.setString(4, voluntario.getEmail());
            statement.setDate(5, voluntario.getDtNascimento());        
            statement.setString(6, voluntario.getLocalidade());
            statement.setString(7, voluntario.getNome());
            statement.setString(8, voluntario.getCp());
            statement.setString(9, voluntario.getNacionalidade()); 
            statement.setString(10, voluntario.getProfissao());            
            
            
        } catch (SQLException ex) { 
            throw new PersistableException("Erro ao criar o PreparedStatement!");
        }

        return statement;
    } 
    
    @Override
    public Voluntario convertResultSet(ResultSet rst) throws PersistableException {
            Voluntario ret;
        try {
            ret = new Voluntario(rst.getInt("Nif"),
                                  rst.getString("Nome"),
                                  rst.getString("Telefone"),
                                  rst.getString("Email"),
                                  rst.getString("Rua"),
                                  rst.getString("Localidade"),
                                  rst.getString("Cp"),
                                  rst.getDate("DtNascimento"),
                                  rst.getString("Nacionalidade"),
                                  rst.getString("Profissao"));
            ret.setId(rst.getInt("Id"));
        } catch (SQLException ex) {
            throw new PersistableException("Ocorreu um erro na crição da entidade (convertToResulSet())");
        }
        return ret;
    }

    

        

    
}
