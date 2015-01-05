/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOGeshabitat;

import BLGeshabitat.Anexo;
import BLGeshabitat.Candidatura;
import BLGeshabitat.Familiar;
import static DAOGeshabitat.EntityDAO.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nelson
 */
public class CandidaturaDAO extends EntityDAO{

    
    public CandidaturaDAO() {
    }        

    @Override
    public PreparedStatement getInsertSqlStatement(String table) throws PersistableException {
        
        int autoGenerateKeys = PreparedStatement.RETURN_GENERATED_KEYS;
        Candidatura candidatura = (Candidatura)super.objectToPersist;
        PreparedStatement statement=null;
        String sql = "INSERT INTO " + table + " (Rua,Nif,Telefone,Email,DtNascimento,Localidade,Nome,Cp,EstadoCivil,Profissao,Rendimento,Estado,Escolaridade,Funcionario_Id,Prestacao,Telemovel) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            statement = conn.prepareStatement(sql,autoGenerateKeys);
            
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
            statement.setFloat(11, candidatura.getRendimento()); 
            statement.setString(12, candidatura.getEstado());
            statement.setString(13, candidatura.getEscolaridade()); 
            statement.setInt(14, candidatura.getFuncionario_Id());            
            statement.setFloat(15, candidatura.getPrestacao()); 
            statement.setString(16, candidatura.getTelemovel()); 
            
        } catch (SQLException ex) { 
            throw new PersistableException("Erro ao criar o PreparedStatement!\n" + ex.getMessage());
        }

        return statement;
    } 
    
    private PreparedStatement getInsertSqlStatementFamiliar(String table, Familiar familiar, int Candidatura_Id) throws PersistableException {

        PreparedStatement statement=null;
        String sql = "INSERT INTO " + table + " (DtNascimento,Nome,EstadoCivil,Ocupacao,Escolaridade,Grau,Candidatura_Id) "
                + "VALUES (?,?,?,?,?,?,?)";
  
        try {
            statement = conn.prepareStatement(sql);
            
            statement.setDate(1, new java.sql.Date(familiar.getDtNascimento().getTime()));        
            statement.setString(2, familiar.getNome());
            statement.setString(3, familiar.getEstadoCivil());
            statement.setString(4, familiar.getOcupacao());
            statement.setString(5, familiar.getEscolaridade()); 
            statement.setString(6, familiar.getGrau());            
            statement.setInt(7, Candidatura_Id); 
            
        } catch (SQLException ex) { 
            throw new PersistableException("Erro ao criar o PreparedStatement!");
        }

        return statement;
    } 
        
    private PreparedStatement getInsertSqlStatementAnexo(String table, Anexo anexo,int Candidatura_Id) throws PersistableException {
        
        PreparedStatement statement=null;
        String sql = "INSERT INTO " + table + " (Descricao,Caminho,Candidatura_Id) "
                + "VALUES (?,?,?)";
  
        try {
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, anexo.getDescricao());
            statement.setString(2, anexo.getCaminho());   
            statement.setInt(3, Candidatura_Id);  
            
        } catch (SQLException ex) { 
            throw new PersistableException("Erro ao criar o PreparedStatement!");
        }

        return statement;
    } 

    @Override
    public int put(Object obj) throws PersistableException {
        Candidatura candidatura = (Candidatura)obj;
        List<Familiar> familiares = candidatura.getAgregado();
        List<Anexo> anexos = candidatura.getAnexos();
                
        this.objectToPersist = obj;
      
        int GeneratedKey=-1;
        PreparedStatement statement = null;
        ResultSet keys = null;
        
        try {
             //Begin Transaction
            conn.setAutoCommit(false);
            
            //Candidatura
            statement = this.getInsertSqlStatement(table);
            statement.executeUpdate(); 
            
            //Obter id
            keys = statement.getGeneratedKeys();
            if(keys.next()) GeneratedKey=keys.getInt(1);
            else throw new PersistableException("Ocorreu um erro na obtenção do Id!");

            //Familiares
            for(Familiar f : familiares) {
                statement=this.getInsertSqlStatementFamiliar(FacadeDAO.FAMILIARTABLE, f, GeneratedKey);
                statement.executeUpdate(); 
            }
            
            //Anexos
            for(Anexo a : anexos) {
                statement=this.getInsertSqlStatementAnexo(FacadeDAO.ANEXOSTABLE, a, GeneratedKey);
                statement.executeUpdate(); 
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

    public Iterable getAll() throws PersistableException  {
        String sql = "SELECT * FROM " + EntityDAO.table;
        
        List<Object> ret = new ArrayList<>();
        
        PreparedStatement statement = null;
        ResultSet rst = null;
        
        try {
            statement = conn.prepareStatement(sql);           
            rst = statement.executeQuery();

            while(rst.next())
            {
                ret.add(this.convertResultSet(rst));
            }
            
       
            for(Object obj : ret) {
                Candidatura cand = (Candidatura)obj;
      
                cand.setAgregado(this.getFamiliares(statement, cand.getId()));
                cand.setAnexos(this.getAnexos(statement, cand.getId()));
                
                obj=cand;
            }
            
        } catch (SQLException ex) { 
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
    
    public List<Familiar> getFamiliares(PreparedStatement statement, int id) throws SQLException, PersistableException {
        String sql = "SELECT * FROM " + FacadeDAO.FAMILIARTABLE + " WHERE Candidatura_Id = " + id;

        ResultSet rst = statement.executeQuery(sql);
        
        List<Familiar> familiares = new ArrayList<>();
        while(rst.next()) {
            familiares.add((Familiar)this.convertResultSetFamiliar(rst));
        }
        return familiares;
    }
    
    
    public List<Anexo> getAnexos(PreparedStatement statement, int id) throws PersistableException, SQLException {
        String sql = "SELECT * FROM " + FacadeDAO.ANEXOSTABLE + " WHERE Candidatura_Id = " + id;

        ResultSet rst = statement.executeQuery(sql);
        
        List<Anexo> anexos = new ArrayList<>();
        while(rst.next()) {
            anexos.add((Anexo)this.convertResultSetAnexo(rst));
        }
        return anexos;
        
    }
    
    @Override
    public Object convertResultSet(ResultSet rst) throws PersistableException {
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
                                  rst.getString("Profissao"),
                                  rst.getFloat("Rendimento"),
                                  rst.getString("Estado"),
                                  rst.getString("Escolaridade"),
                                  rst.getInt("Funcionario_Id"),
                                  rst.getFloat("Prestacao"),
                                  rst.getString("EstadoCivil"),
                                  rst.getString("Telemovel"));
            ret.setId(rst.getInt("Id"));
        } catch (SQLException ex) {
            throw new PersistableException("Ocorreu um erro na crição da entidade (convertToResulSet())");
        }

        
        /// falta implementar a pesquisa de familiares e anexos
        
        return ret;
    }
    
    public Object convertResultSetFamiliar(ResultSet rst) throws PersistableException {
        Familiar ret;
        try {
            ret = new Familiar(rst.getInt("Id"),
                                  rst.getString("Nome"),
                                  rst.getString("EstadoCivil"),
                                  rst.getDate("DtNascimento"),
                                  rst.getString("Escolaridade"),
                                  rst.getString("Ocupacao"),
                                  rst.getString("Grau"));

        } catch (SQLException ex) {
            throw new PersistableException("Ocorreu um erro na crição da entidade (convertToResulSet())");
        }

        return ret;
    }
    
    public Object convertResultSetAnexo(ResultSet rst) throws PersistableException {
        Anexo ret;
        try {
            ret = new Anexo(rst.getInt("Id"),
                                  rst.getString("Descricao"),
                                  rst.getString("Caminho"));

        } catch (SQLException ex) {
            throw new PersistableException("Ocorreu um erro na crição da entidade (convertToResulSet())");
        }

        return ret;
    }
    

    
}
