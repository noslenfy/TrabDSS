/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOGeshabitat.Projectos;

import BLGeshabitat.Projectos.Fase;
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
public class FaseDAO extends EntityDAO{

    public FaseDAO() {
    }

    @Override
    public PreparedStatement getInsertSqlStatement(String table) throws PersistableException
    {
        int autoGenerateKeys = PreparedStatement.RETURN_GENERATED_KEYS;
        Fase fase = (Fase)super.objectToPersist;
        PreparedStatement statement=null;
        String sql = "INSERT INTO " + table + " (Descricao,Projecto_Id) "
                + "VALUES (?,?)";
       
        try {
            statement = conn.prepareStatement(sql,autoGenerateKeys);
            
            statement.setString(1, fase.getDescricao());
            statement.setInt(2, fase.getProjecto_Id());
        } catch (SQLException ex) { 
            
            throw new PersistableException("Erro ao criar o PreparedStatement!");
        }

        return statement;
    } 
    
    @Override
    public Fase convertResultSet(ResultSet rst) throws PersistableException {
            Fase ret;
        try {
            ret = new Fase(rst.getString("Descricao"),
                            rst.getInt("Projecto_Id"));
            ret.setId(rst.getInt("Id"));
        } catch (SQLException ex) {
            throw new PersistableException("Ocorreu um erro na crição da entidade (convertToResulSet())");
        }
        return ret;
    }
}
    


