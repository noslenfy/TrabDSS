/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLGeshabitat;

import DAOGeshabitat.CandidaturaDAO;
import DAOGeshabitat.FacadeDAO;
import DAOGeshabitat.FuncionarioDAO;
import DAOGeshabitat.PersistableException;
import java.util.List;


/**
 *
 * @author nelson
 */
public class FacadeBL {
    
    private FacadeDAO facadeDAO;

    public FacadeBL() {
        this.facadeDAO = new FacadeDAO();
    }
 
    public void putCandidatura(Candidatura candidatura) throws PersistableException {
        this.facadeDAO = new FacadeDAO();
        
        facadeDAO.put(new CandidaturaDAO(), candidatura);
        facadeDAO.closeConnection();
    }
    public List<Object> getFuncionarios() throws PersistableException {
         this.facadeDAO = new FacadeDAO();
        return facadeDAO.getAll(new FuncionarioDAO());
    }
            
    
    public void putFuncionario(Funcionario funcionario) throws PersistableException {
        
        
    }
    public void putVoluntario(Voluntario voluntario) throws PersistableException {
        
        
    }
    public void putDoador(Doador doador) throws PersistableException {
        
        
    }
    
}
