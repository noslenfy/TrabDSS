/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOGeshabitat;

import BLGeshabitat.RegistoVoluntariado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nelson
 */
public class RegistoVoluntariadoDAO extends EntityDAO{
     
    
    
    public RegistoVoluntariadoDAO() {
    }        

    @Override
    public PreparedStatement getInsertSqlStatement(String table) throws PersistableException {
       
        int autoGenerateKeys = PreparedStatement.RETURN_GENERATED_KEYS;
        RegistoVoluntariado registoVoluntariado = (RegistoVoluntariado)super.objectToPersist;
        PreparedStatement statement=null;
        String sql = "INSERT INTO " + table + " (Voluntario_Id,Tarefa_Id,Tempo,Funcionario_Id,Equipa) "
                + "VALUES (?,?,?,?,?)";
       
        try {
            statement = conn.prepareStatement(sql,autoGenerateKeys);
            
           statement.setInt(1, registoVoluntariado.getVoluntario_Id());
            statement.setInt(2, registoVoluntariado.getTarefa_Id());  
            statement.setFloat(3, registoVoluntariado.getTempo());
            statement.setInt(4, registoVoluntariado.getFuncionario_Id());
            statement.setString(5, registoVoluntariado.getEquipa());        
 
            
        } catch (SQLException ex) { 
            throw new PersistableException("Erro ao criar o PreparedStatement!");
        }

        return statement;
    } 
    @Override
    public Object convertResultSet(ResultSet rst) throws PersistableException {
            RegistoVoluntariado ret;
        try {
            ret = new RegistoVoluntariado(rst.getInt("Tarefa_Id"),
                                  rst.getFloat("Tempo"),
                                  rst.getInt("Funcionario_Id"),
                                  rst.getString("Equipa"),
                                  rst.getInt("Voluntario_Id"));
            ret.setId(rst.getInt("Id"));
        } catch (SQLException ex) {
            throw new PersistableException("Ocorreu um erro na crição da entidade (convertToResulSet())");
        }
        return ret;
    }

  

}
