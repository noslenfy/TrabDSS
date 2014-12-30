/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOGeshabitat;

import BLGeshabitat.Material;
import static DAOGeshabitat.EntityDAO.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 *
 * @author nelson
 */
public class MaterialDAO extends EntityDAO{
    
    @Override
    public PreparedStatement getInsertSqlStatement(String table) throws PersistableException {
       
        int autoGenerateKeys = PreparedStatement.RETURN_GENERATED_KEYS;
        Material material = (Material)super.objectToPersist;
        PreparedStatement statement=null;
        String sql = "INSERT INTO " + table + " (Descricao,Stock) "
                + "VALUES (?,?)";
  
        try {
            statement = conn.prepareStatement(sql,autoGenerateKeys);
            
            statement.setString(1, material.getDescricao());  
            statement.setFloat(2, material.getStock());
            
        } catch (SQLException ex) { 
            throw new PersistableException("Erro ao criar o PreparedStatement!");
        }

        return statement;
    } 
    
    @Override
    public Material convertResultSet(ResultSet rst) throws PersistableException {
            Material ret;
        try {           
            ret = new Material(rst.getString("Descricao"),
                                  rst.getFloat("Stock"));
            ret.setId(rst.getInt("Id"));
        } catch (SQLException ex) {
            throw new PersistableException("Ocorreu um erro na crição da entidade (convertToResulSet())");
        }
        return ret;
    }
    
    public float getStock(int id) throws PersistableException {
        return Float.valueOf(get("Stock", "Id", String.valueOf(id)));
    }
   
    public List<Float> getExistencias(Collection<Integer> ids) throws PersistableException {
        List<Float> ret = new ArrayList<>();
        for(Integer id : ids) {
            ret.add(getStock(id));
        }
        return ret;
    }
}
