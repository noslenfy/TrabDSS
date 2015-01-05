/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOGeshabitat;

import BLGeshabitat.Doacao;
import BLGeshabitat.Material;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nelson
 */
public class DoacaoDAO extends EntityDAO{

    
    public DoacaoDAO() {
    }        

    @Override
    public PreparedStatement getInsertSqlStatement(String table) throws PersistableException {
       
        int autoGenerateKeys = PreparedStatement.RETURN_GENERATED_KEYS;
        Doacao doacao = (Doacao)super.objectToPersist;
        PreparedStatement statement=null;
        String sql = "INSERT INTO " + table + " (Recibo,Data,Descricao,Evento,Valor,Tipo,Destino,Projecto_Id,Doador_Id) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";
       
        try {
            statement = conn.prepareStatement(sql,autoGenerateKeys);
            
            statement.setBoolean(1, doacao.isRecibo());
            statement.setDate(2, new java.sql.Date(doacao.getData().getTime()));  
            statement.setString(3, doacao.getDescricao());
            statement.setString(4, doacao.getEvento());
            statement.setFloat(5, doacao.getValor());        
            statement.setInt(6, doacao.getTipo());
            statement.setString(7, doacao.getDestino());
            if(doacao.getProjecto_Id()==-1) statement.setNull(8, doacao.getProjecto_Id()); 
            else statement.setInt(8, doacao.getProjecto_Id()); 
            statement.setInt(9, doacao.getDoador_Id());

            
        } catch (SQLException ex) { 
            throw new PersistableException("Erro ao criar o PreparedStatement!");
        }

        return statement;
    } 
    
    @Override
    public Doacao convertResultSet(ResultSet rst) throws PersistableException {
            Doacao ret = null;
//        try {
//            ret = new Doacao(rst.getInt("Nif"),
//                                  rst.getString("Nome"),
//                                  rst.getString("Telefone"),
//                                  rst.getString("Email"),
//                                  rst.getString("Rua"),
//                                  rst.getString("Localidade"),
//                                  rst.getString("Cp"),
//                                  rst.getDate("DtNascimento"),
//                                  rst.getString("EstadoCivil"),
//                                  rst.getString("Profissao"),
//                                  rst.getString("Actividade"),
//                                  rst.getString("Tipo"),
//                                  rst.getBoolean("Parceria"));
//            ret.setId(rst.getInt("Id"));
//        } catch (SQLException ex) {
//            throw new PersistableException("Ocorreu um erro na crição da entidade (convertToResulSet())");
//        }
        return ret;
    }

        private PreparedStatement getInsertSqlStatementDoacaoMaterial(String table, Material material ,int Doacao_Id) throws PersistableException {
        
        PreparedStatement statement=null;
        String sql = "INSERT INTO " + table + " (Doacao_Id,Material_id,Quantidade) "
                + "VALUES (?,?,?)";
  
        try {
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, Doacao_Id);
            statement.setInt(2, material.getId());
            statement.setFloat(3, material.getStock());
            
        } catch (SQLException ex) { 
            throw new PersistableException("Erro ao criar o PreparedStatement!");
        }

        return statement;
    } 
    
     
        
    @Override
    public int put(Object obj) throws PersistableException {
        Doacao doacao = (Doacao)obj;
        super.objectToPersist=doacao;
        List<Material> materiais = doacao.getMateriais();
                

      
        int GeneratedKey=-1;
        PreparedStatement statement = null;
        ResultSet keys = null;
        List<Float> existencias=null;

        
        try {
            if(doacao.getTipo()==1) {
                existencias = new ArrayList<>();
                
                //é necessário alterar a tabela actual para calcular as existencias
                String tabela = EntityDAO.table;
                EntityDAO.table = FacadeDAO.MATERIALTABLE;
                
                //calcular existencias
                for(Material mat : materiais) {
                    existencias.add(new MaterialDAO().getStock(mat.getId()));
                }

                //reposição da tabela antiga
                EntityDAO.table = tabela;

            }
            
             //Begin Transaction
            conn.setAutoCommit(false);
            
            //insere doacao;
            statement = this.getInsertSqlStatement(table);
            statement.executeUpdate(); 
            
            //Se for doacao material insere materiais na tabela DoacaoMaterial e actualiza stock
            if(doacao.getTipo()==1) {
                //Obter id da doacao
                keys = statement.getGeneratedKeys();
                if(keys.next()) GeneratedKey=keys.getInt(1);
                else throw new PersistableException("Ocorreu um erro na obtenção do Id!");

                //Materiais
                for(Material m : materiais) {
                    statement=this.getInsertSqlStatementDoacaoMaterial(FacadeDAO.DOACAOMATERIALTABLE, m, GeneratedKey);
                    statement.executeUpdate(); 
                }
                
                //Actualização de stock
                for(int i=0; i< materiais.size(); i++) {
                    Material m = materiais.get(i);
                    m.setStock(m.getStock()+existencias.get(i));
                    statement=new MaterialDAO().getUpdateSqlStatementStockMaterial(FacadeDAO.MATERIALTABLE, m);
                    statement.executeUpdate(); 
                }

            }
                  
            conn.commit();
            
            
        } catch (SQLException | PersistableException ex) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex1) {
                    throw new PersistableException("Ocorreu um erro na criação do registo!\n" + ex.getMessage());
                }
            }
        } finally {
            try {
                if (statement != null)  statement.close();
                if (keys != null) keys.close();
                
            } catch (SQLException ex) {
                throw new PersistableException("Ocorreu um erro ao fechar conexões!\n" + ex.getMessage());
            }      
        }
        return  GeneratedKey; 
    }

    public float getTotalDoado() throws PersistableException {
        float ret =0;
        
        String sql = "select sum(valor) as Total from " + FacadeDAO.DOACAOTABLE;
        PreparedStatement statement = null;
        ResultSet rst = null;
        try {
            statement = conn.prepareStatement(sql);           
            rst = statement.executeQuery();
            
            if(rst.next())
            {
                ret=rst.getFloat("Total");
            }
            
        } catch (SQLException ex) { 
            throw new PersistableException("Ocorreu um erro na obtenção do registo" + ex.getMessage());
        } finally {
            try {
                if (statement != null)  statement.close();    
                if( rst != null ) rst.close();
            } catch (SQLException ex) {
                throw new PersistableException("Ocorreu um erro ao fechar conexões!\n" + ex.getMessage());
            }             
            
        }
        return ret;

    }
    
    
}
