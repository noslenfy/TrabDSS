/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLGeshabitat;

import DAOGeshabitat.CandidaturaDAO;
import DAOGeshabitat.DBConnection;
import DAOGeshabitat.DoacaoDAO;
import DAOGeshabitat.DoadorDAO;
import DAOGeshabitat.EntityDAO;
import DAOGeshabitat.FacadeDAO;
import DAOGeshabitat.FuncionarioDAO;
import DAOGeshabitat.MaterialDAO;
import DAOGeshabitat.PersistableException;
import DAOGeshabitat.ProjectoDAO;
import DAOGeshabitat.VoluntarioDAO;
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

    public FacadeBL(DBConnection conn) throws PersistableException {
        this.facadeDAO = new FacadeDAO(conn);
    }
    
    private EntityDAO getType (Object obj){
        if(obj instanceof Candidatura) return new CandidaturaDAO();
        if(obj instanceof Doacao) return new DoacaoDAO();
        if(obj instanceof Projecto) return new ProjectoDAO();
        if(obj instanceof Doador) return new DoadorDAO();
        if(obj instanceof Funcionario) return new FuncionarioDAO();
        if(obj instanceof Voluntario) return new VoluntarioDAO();
        if(obj instanceof Material) return new MaterialDAO();
        if(obj instanceof Projecto) return new ProjectoDAO();
        return null;
    }
 
    
    public int put(Object obj) throws PersistableException {
        return facadeDAO.put(this.getType(obj), obj);
    }
    
    public void delete(Object obj, int Id) throws PersistableException {
        facadeDAO.delete(this.getType(obj), Id);
    }
    public List<Object> getAll(Object obj) throws PersistableException {
        return facadeDAO.getAll(this.getType(obj));
    }
    
    public void update(Object obj, String column, String value, int Id) throws PersistableException {
        facadeDAO.update(this.getType(obj),  column, value, Id);
    }


    public boolean existsMaterial(String Column, String Value) throws PersistableException {
        return facadeDAO.exists(new MaterialDAO(), Column, Value);
    }

    public float getTotalDoacoes(int Doador_Id) throws PersistableException {
        return facadeDAO.getTotalDoacoes(Doador_Id);
    }  
    
      
}
