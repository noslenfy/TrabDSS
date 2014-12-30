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
       
        int autoGenerateKeys = PreparedStatement.RETURN_GENERATED_KEYS;
        Doador doador = (Doador)super.objectToPersist;
        PreparedStatement statement=null;
        String sql = "INSERT INTO " + table + " (Rua,Nif,Telefone,Email,DtNascimento,Localidade,Nome,Cp,EstadoCivil,Profissao,Actividade,Tipo,Parceria) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
       
        try {
            statement = conn.prepareStatement(sql,autoGenerateKeys);
            
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
                                  rst.getString("Nome"),
                                  rst.getString("Telefone"),
                                  rst.getString("Email"),
                                  rst.getString("Rua"),
                                  rst.getString("Localidade"),
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

        public float getTotalDoacoes(int Doador_Id) throws PersistableException {
        
        String sql = "SELECT SUM(valor) AS total FROM Doador AS D inner join Doacao AS DC WHERE D.Id = DC.Doador_Id and D.Id=?";
        
        
        
        float ret=-1;
        PreparedStatement statement = null;
        ResultSet rst = null;
        
        try {
            statement = conn.prepareStatement(sql);     
            
            statement.setInt(1,Doador_Id);
            rst = statement.executeQuery();
            
            if(rst.next())
            {              
                ret=rst.getFloat("total");
            } else {
                throw new PersistableException("Ocorreu um erro na obtenção do registo");           
            }
            statement.close();
            rst.close();
            
        } catch (SQLException ex) { 
            throw new PersistableException("Ocorreu um erro na obtenção do registo" + ex.getMessage());
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
