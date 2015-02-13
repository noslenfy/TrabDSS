/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOGeshabitat.Projectos;

import BLGeshabitat.Projectos.Projecto;
import DAOGeshabitat.EntityDAO;
import DAOGeshabitat.PersistableException;
import static DAOGeshabitat.EntityDAO.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 
 */
public class ProjectoDAO extends EntityDAO{

    public ProjectoDAO() {
    }

    @Override
    public PreparedStatement getInsertSqlStatement(String table) throws PersistableException
    {
        int autoGenerateKeys = PreparedStatement.RETURN_GENERATED_KEYS;
        Projecto projecto = (Projecto)super.objectToPersist;
        PreparedStatement statement=null;
        String sql = "INSERT INTO " + table + " (Rua,CustoFinal,Orcamento,DtInicioProjecto,DtConclusaoProjecto,Descricao,Localidade,Funcionario_Id,Cp,Candidatura_Id) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
       
        try {
            statement = conn.prepareStatement(sql,autoGenerateKeys);
            
            statement.setString(1, projecto.getRua());
            statement.setFloat(2, projecto.getCustoFinal());  
            statement.setFloat(3, projecto.getOrcamento());
            statement.setDate(4, new java.sql.Date(projecto.getDtInicioProjecto().getTime()));
            if(projecto.getDtConclusaoProjecto()==null) statement.setDate(5, null);
            else statement.setDate(5, new java.sql.Date(projecto.getDtConclusaoProjecto().getTime()));        
            statement.setString(6, projecto.getDescricao());
            statement.setString(7, projecto.getLocalidade());
            statement.setInt(8, projecto.getFuncionario_Id());
            statement.setString(9, projecto.getCp());          
            statement.setInt(10, projecto.getCandidatura_Id());     
        } catch (SQLException ex) { 
            throw new PersistableException("Erro ao criar o PreparedStatement!");
        }

        return statement;
    } 
    
    @Override
    public Projecto convertResultSet(ResultSet rst) throws PersistableException {
            Projecto ret = null;
        try {
            ret = new Projecto(rst.getString("Rua"),
                                rst.getFloat("CustoFinal"),
                                rst.getFloat("Orcamento"),
                                rst.getDate("DtInicioProjecto"),
                                rst.getDate("DtConclusaoProjecto"),
                                rst.getString("Descricao"),
                                rst.getString("Localidade"),
                                rst.getInt("Funcionario_Id"),
                                rst.getString("Cp"),
                                rst.getInt("Candidatura_Id"));
            ret.setId(rst.getInt("Id"));
        } catch (SQLException ex) {
            throw new PersistableException("Ocorreu um erro na crição da entidade (convertToResulSet())\n"+ex.getMessage());
        }
        return ret;
    }
}
    
