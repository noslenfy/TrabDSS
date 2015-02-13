/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOGeshabitat.Projectos;

import BLGeshabitat.Projectos.Tarefa;
import DAOGeshabitat.EntityDAO;
import DAOGeshabitat.PersistableException;
import static DAOGeshabitat.EntityDAO.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 
 */
public class TarefaDAO extends EntityDAO{

    public TarefaDAO() {
    }

    @Override
    public PreparedStatement getInsertSqlStatement(String table) throws PersistableException
    {
        int autoGenerateKeys = PreparedStatement.RETURN_GENERATED_KEYS;
        Tarefa tarefa = (Tarefa)super.objectToPersist;
        PreparedStatement statement=null;
        String sql = "INSERT INTO " + table + " (Descricao,Fase_Id,Data_inicio,Data_conclusao) "
                + "VALUES (?,?,?,?)";
       
        try {
            statement = conn.prepareStatement(sql,autoGenerateKeys);
            
            statement.setString(1, tarefa.getDescricao());
            statement.setInt(2, tarefa.getFase_Id());  
            if(tarefa.getData_Inicio()==null) statement.setNull(3, 0);
            else statement.setDate(3, new java.sql.Date(tarefa.getData_Inicio().getTime()));
            if(tarefa.getData_Conclusão()==null) statement.setNull(4, 0);
            else statement.setDate(4, new java.sql.Date(tarefa.getData_Conclusão().getTime()));
       
        } catch (SQLException ex) { 
            throw new PersistableException("Erro ao criar o PreparedStatement!");
        }

        return statement;
    } 
    
    @Override
    public Tarefa convertResultSet(ResultSet rst) throws PersistableException {
            Tarefa ret;
        try {
            ret = new Tarefa(rst.getString("Descricao"),
                                  rst.getInt("Fase_Id"),
                                  rst.getDate("Data_inicio"),
                                  rst.getDate("Data_conclusao"));
            ret.setId(rst.getInt("Id"));
        } catch (SQLException ex) {
            throw new PersistableException("Ocorreu um erro na crição da entidade (convertToResulSet())");
        }
        return ret;
    }
    
    /**
     * Todas as tarefas que não tem data de conclusao
     * @param Projecto_Id
     * @return
     * @throws PersistableException
     */
    public List<Tarefa> getTarefasNRealizadas (int Projecto_Id) throws PersistableException {
        String sql = "select TA.Id,TA.Descricao,TA.Fase_Id,TA.Data_inicio,TA.Data_conclusao from Projecto as PO inner join Fase as FA " +
                     "on PO.Id = FA.Projecto_Id "+
                     "inner join Tarefa as TA " +
                     "on FA.Id=TA.Fase_Id " +
                     "where PO.Id=? and TA.Data_conclusao IS NULL";
        
        List<Tarefa> ret = new ArrayList<>();
        
        PreparedStatement statement = null;
        ResultSet rst = null;
        
        try {
            statement = conn.prepareStatement(sql);           
            statement.setInt(1, Projecto_Id);
            rst = statement.executeQuery();

            while(rst.next())
            {
                ret.add(this.convertResultSet(rst));
            }
            statement.close();
            rst.close();
        } catch (SQLException | PersistableException ex)  { 
            throw new PersistableException ("Ocorreu um erro na obtenção do registo!" + ex.getMessage());
        } finally {
            try {
                if (statement != null)  statement.close();   
                if (rst != null) rst.close();
            } catch (SQLException ex) {
                throw new PersistableException("Ocorreu um erro ao fechar conexões!\n" + ex.getMessage());
            }  
        }  
        return ret;
        
    }
    
    /**
     * Todas as tarefas que não tem data de inicio nem de conclusao
     * @param Projecto_Id
     * @return
     * @throws PersistableException
     */  
    public List<Tarefa> getTarefasNIniciadas (int Projecto_Id) throws PersistableException {
        String sql = "select TA.Id,TA.Descricao,TA.Fase_Id,TA.Data_inicio,TA.Data_conclusao from Projecto as PO inner join Fase as FA " +
                     "on PO.Id = FA.Projecto_Id "+
                     "inner join Tarefa as TA " +
                     "on FA.Id=TA.Fase_Id " +
                     "where PO.Id=? and TA.Data_conclusao IS NUll and TA.Data_inicio IS NULL";
        
        List<Tarefa> ret = new ArrayList<>();
        
        PreparedStatement statement = null;
        ResultSet rst = null;
        
        try {
            statement = conn.prepareStatement(sql);           
            statement.setInt(1, Projecto_Id);
            rst = statement.executeQuery();

            while(rst.next())
            {
                ret.add(this.convertResultSet(rst));
            }
            statement.close();
            rst.close();
        } catch (SQLException | PersistableException ex)  { 
            throw new PersistableException ("Ocorreu um erro na obtenção do registo!" + ex.getMessage());
        } finally {
            try {
                if (statement != null)  statement.close();   
                if (rst != null) rst.close();
            } catch (SQLException ex) {
                throw new PersistableException("Ocorreu um erro ao fechar conexões!\n" + ex.getMessage());
            }  
        }  
        return ret;
        
    }
    
    /**
     * Todas as tarefas que tem data de conclusao
     * @param Projecto_Id
     * @return Map com tarefa e duracao(dias)
     * @throws PersistableException
     */
    public Map<Tarefa,Integer> getTarefasConcluidas (int Projecto_Id) throws PersistableException {
        String sql = "select datediff(TA.Data_conclusao,TA.Data_inicio) as Duracao, TA.Id,TA.Descricao,TA.Fase_Id,TA.Data_inicio,TA.Data_conclusao from Projecto as PO inner join Fase as FA " +
                     "on PO.Id = FA.Projecto_Id "+
                     "inner join Tarefa as TA " +
                     "on FA.Id=TA.Fase_Id " +
                     "where PO.Id=? and TA.Data_conclusao IS NOT NUll";
        
        Map<Tarefa,Integer> ret = new HashMap<>();
        
        PreparedStatement statement = null;
        ResultSet rst = null;
        
        try {
            statement = conn.prepareStatement(sql);           
            statement.setInt(1, Projecto_Id);
            rst = statement.executeQuery();

            while(rst.next())
            {
                Tarefa tarefa = this.convertResultSet(rst);
                Integer duracao = rst.getInt("Duracao");
                
                ret.put(tarefa,duracao);
            }
            statement.close();
            rst.close();
        } catch (SQLException | PersistableException ex)  { 
            throw new PersistableException ("Ocorreu um erro na obtenção do registo!" + ex.getMessage());
        } finally {
            try {
                if (statement != null)  statement.close();   
                if (rst != null) rst.close();
            } catch (SQLException ex) {
                throw new PersistableException("Ocorreu um erro ao fechar conexões!\n" + ex.getMessage());
            }  
        }  
        return ret;
        
    }
   
    /**
     * Todas as tarefas que tem data de inicio mas não tem data de conclusao
     * @param Projecto_Id
     * @return
     * @throws PersistableException
     */
    public List<Tarefa> getTarefasIniciadas (int Projecto_Id) throws PersistableException {
        String sql = "select TA.Id,TA.Descricao,TA.Fase_Id,TA.Data_inicio,TA.Data_conclusao from Projecto as PO inner join Fase as FA " +
                     "on PO.Id = FA.Projecto_Id "+
                     "inner join Tarefa as TA " +
                     "on FA.Id=TA.Fase_Id " +
                     "where PO.Id=? and TA.Data_conclusao is NULL and TA.Data_inicio is not null";
        
        List<Tarefa> ret = new ArrayList<>();
        
        PreparedStatement statement = null;
        ResultSet rst = null;
        
        try {
            statement = conn.prepareStatement(sql);           
            statement.setInt(1, Projecto_Id);
            rst = statement.executeQuery();

            while(rst.next())
            {
                ret.add(this.convertResultSet(rst));
            }
            statement.close();
            rst.close();
        } catch (SQLException | PersistableException ex)  { 
            throw new PersistableException ("Ocorreu um erro na obtenção do registo!" + ex.getMessage());
        } finally {
            try {
                if (statement != null)  statement.close();   
                if (rst != null) rst.close();
            } catch (SQLException ex) {
                throw new PersistableException("Ocorreu um erro ao fechar conexões!\n" + ex.getMessage());
            }  
        }  
        return ret;
        
    }




}
    


