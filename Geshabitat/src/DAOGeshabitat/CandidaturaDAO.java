/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOGeshabitat;

import BLGeshabitat.Candidatura;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nelson
 */
public class CandidaturaDAO extends EntityDAO{

    
    public CandidaturaDAO() {
    }        

    @Override
    public PreparedStatement getInsertSqlStatement(String table) throws PersistableException {
        Candidatura candidatura = (Candidatura)super.objectToPersist;
        PreparedStatement statement=null;
        String sql = "INSERT INTO " + table + " (Rua,Nif,Telefone,Email,DtNascimento,Localidade,Nome,Cp,EstadoCivil,Profissao,Nacionalidade,Rendimento,Estado,Escolaridade,Funcionario_Id,Projecto_Id,Prestacao) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  
        try {
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, candidatura.getRua());
            statement.setInt(2, candidatura.getNif());  
            statement.setString(3, candidatura.getTelefone());
            statement.setString(4, candidatura.getEmail());
            statement.setDate(5, candidatura.getDtNascimento());        
            statement.setString(6, candidatura.getLocalidade());
            statement.setString(7, candidatura.getNome());
            statement.setString(8, candidatura.getCp());
            statement.setString(9, candidatura.getEstadoCivil());
            statement.setString(10, candidatura.getProfissao());
            statement.setString(11, candidatura.getNacionalidade());
            statement.setFloat(12, candidatura.getRendimento()); 
            statement.setString(13, candidatura.getEstado());
            statement.setString(14, candidatura.getEscolaridade()); 
            statement.setInt(15, candidatura.getFuncionario());            
            statement.setInt(16, candidatura.getProjecto()); 
            statement.setFloat(17, candidatura.getPrestacao()); 
            
        } catch (SQLException ex) { 
            throw new PersistableException("Erro ao criar o PreparedStatement!");
        }

        return statement;
    } 
    
    @Override
    public Candidatura convertResultSet(ResultSet rst) throws PersistableException {
            Candidatura ret;
        try {           
            ret = new Candidatura(rst.getInt("Nif"),
                                  rst.getString("Nome"),
                                  rst.getString("Telefone"),
                                  rst.getString("Email"),                    
                                  rst.getString("Rua"),
                                  rst.getString("Localidade"),
                                  rst.getString("Cp"),
                                  rst.getDate("DtNascimento"),
                                  rst.getString("Nacionalidade"),
                                  rst.getString("Profissao"),
                                  rst.getFloat("Rendimento"),
                                  rst.getString("Estado"),                    
                                  rst.getString("Escolaridade"),
                                  rst.getInt("Funcionario_Id"),
                                  rst.getInt("Projecto_Id"),
                                  rst.getFloat("Prestacao"),
                                  rst.getString("EstadoCivil"));
            ret.setId(rst.getInt("Id"));
        } catch (SQLException ex) {
            throw new PersistableException("Ocorreu um erro na crição da entidade (convertToResulSet())");
        }
        return ret;
    }
 

    

        

    
}
