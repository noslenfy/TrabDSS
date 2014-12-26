/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOGeshabitat;

import BLGeshabitat.Doador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nelson
 */
public class DoadorDAO extends EntityDAO{

    
    public DoadorDAO() {
    }        

    @Override
    public PreparedStatement getInsertSqlStatement(String table) throws PersistableException {
        Doador doador = (Doador)super.objectToPersist;
        PreparedStatement statement=null;
        String sql = "INSERT INTO " + table + " (Rua,Nif,Telefone,Email,DtNascimento,Localidade,Nome,Cp,EstadoCivil,Profissao,Actividade,Tipo,Parceria) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
       
        try {
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, doador.getRua());
            statement.setInt(2, doador.getNif());  
            statement.setString(3, doador.getTelefone());
            statement.setString(4, doador.getEmail());
            statement.setDate(5, doador.getDtNascimento());        
            statement.setString(6, doador.getLocalidade());
            statement.setString(7, doador.getNome());
            statement.setString(8, doador.getCp());
            statement.setString(9, doador.getEstadoCivil());
            statement.setString(10, doador.getProfissao());
            statement.setString(11, doador.getActividade());
            statement.setString(12, doador.getTipo()); 
            statement.setBoolean(13, doador.isParceria());
            
        } catch (SQLException ex) { 
            throw new PersistableException("Erro ao criar o PreparedStatement!");
        }

        return statement;
    } 
    
    @Override
    public Doador convertResultSet(ResultSet rst) throws PersistableException {
            Doador ret;
        try {
            ret = new Doador(rst.getInt("Nif"),
                                  rst.getString("Telefone"),
                                  rst.getString("Rua"),
                                  rst.getString("Email"),
                                  rst.getString("Localidade"),
                                  rst.getString("Nome"),
                                  rst.getString("Cp"),
                                  rst.getDate("DtNascimento"),
                                  rst.getString("EstadoCivil"),
                                  rst.getString("Profissao"),
                                  rst.getString("Actividade"),
                                  rst.getString("Tipo"),
                                  rst.getBoolean("Parceria"));
            ret.setId(rst.getInt("Id"));
        } catch (SQLException ex) {
            throw new PersistableException("Ocorreu um erro na crição da entidade (convertToResulSet())");
        }
        return ret;
    }
 
    
    

        

    
}
