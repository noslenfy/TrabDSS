/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOGeshabitat.Fundos;

import BLGeshabitat.Projectos.Fase;
import BLGeshabitat.Fundos.Material;
import BLGeshabitat.Projectos.RegistoMaterial;
import DAOGeshabitat.EntityDAO;
import DAOGeshabitat.FacadeDAO;
import DAOGeshabitat.PersistableException;
import static DAOGeshabitat.EntityDAO.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


/**
 *
 * @author 
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
    public RegistoMaterial convertResultSetRegistoMaterial(ResultSet rst) throws PersistableException {
            RegistoMaterial ret;
        try {           
            ret = new RegistoMaterial(rst.getDate("Data"),
                                      rst.getString("Descricao"),
                                      rst.getFloat("Quantidade"),
                                      rst.getString("Fase"));
        } catch (SQLException ex) {
            throw new PersistableException("Ocorreu um erro na crição da entidade (convertToResulSet())");
        }
        return ret;
    }
    
    public float getStock(int id) throws PersistableException {
        return Float.valueOf(this.get("Stock", "Id", String.valueOf(id)));
    }
   
    public List<Float> getExistencias(Collection<Integer> ids) throws PersistableException {
        List<Float> ret = new ArrayList<>();
        for(Integer id : ids) {
            ret.add(getStock(id));
        }
        return ret;
    }


    public PreparedStatement getUpdateSqlStatementStockMaterial(String table, Material material) throws PersistableException {
        String tableId = table+".Id";
        String sql = "UPDATE " + table + " SET Stock = ? " + " WHERE " + tableId + " = ?";
        
        PreparedStatement statement=null;

        try {
            statement = conn.prepareStatement(sql);
            
            statement.setFloat(1, material.getStock());
            statement.setInt(2, material.getId());
            
        } catch (SQLException ex) { 
            throw new PersistableException("Erro ao criar o PreparedStatement!");
        }

        return statement;
    }

    public void alocaMateriais(List<Date> datas, List<Material> materiais, List<Float> quantidades, List<Fase> fases) throws PersistableException {
        PreparedStatement statement = null;
        ResultSet keys = null;
       
        try {
            
            String sql = "Insert Into " + FacadeDAO.MATERIALFASETABLE + " (Material_Id,Fase_Id,Data,Quantidade)"
                    + " values(?,?,?,?)";
   
             //Begin Transaction
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(sql);
            
            for(int i =0; i<datas.size(); i++) {
            
            //insere registo de alocação;
                statement.setInt(1, materiais.get(i).getId());
                statement.setInt(2, fases.get(i).getId());
                statement.setDate(3, new java.sql.Date(datas.get(i).getTime()));
                statement.setFloat(4, quantidades.get(i));

                statement.executeUpdate(); 
            }
            
            for(int i =0; i<datas.size(); i++) {
               //Actualização Stock
                materiais.get(i).setStock(materiais.get(i).getStock()-quantidades.get(i));
                statement=this.getUpdateSqlStatementStockMaterial(FacadeDAO.MATERIALTABLE, materiais.get(i));
                statement.executeUpdate();
            }

            conn.commit();
            
            
        } catch (SQLException | PersistableException ex) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex1) {
                    throw new PersistableException("Ocorreu um erro ao realizar roollback!\n" + ex.getMessage());
                }
                throw new PersistableException("Ocorreu um erro na criação do registo!\n" + ex.getMessage());
            }
        } finally {
            try {
                if (statement != null)  statement.close();
                if (keys != null) keys.close();
                
            } catch (SQLException ex) {
                throw new PersistableException("Ocorreu um erro ao fechar conexões!\n" + ex.getMessage());
            }      
        }
    }

    public List<RegistoMaterial> getMateriaisUtilizados(int Project_Id) throws PersistableException {
        PreparedStatement statement = null;
        ResultSet keys = null;
        
        List<RegistoMaterial> ret = new ArrayList<>();
        
        try {
            
            String sql = "select MF.Data ,MA.Descricao, MF.Quantidade, FA.Descricao as Fase from Projecto as PO inner join Fase as FA\n" +
                         "	on PO.Id = FA.Projecto_Id\n" +
                         "	inner join MaterialFase as MF\n" +
                         "	  on FA.Id=MF.Fase_Id\n" +
                         "        inner join Material as MA\n" +
                         "	    on MA.Id=MF.Material_Id\n" +
                         "	where PO.Id=?";
   
            statement = conn.prepareStatement(sql);
            statement.setInt(1, Project_Id);
            ResultSet rst = statement.executeQuery();
            
            while(rst.next())
            {
                
                ret.add(convertResultSetRegistoMaterial(rst));
            }         
            
        } catch (SQLException | PersistableException ex) {
            throw new PersistableException("Ocorreu um erro na obtencao dos materiais utilizados!\n" + ex.getMessage());
        } finally {
            try {
                if (statement != null)  statement.close();
                if (keys != null) keys.close();
                
            } catch (SQLException ex) {
                throw new PersistableException("Ocorreu um erro ao fechar conexões!\n" + ex.getMessage());
            }      
        }
        return ret;
    }
    
}
