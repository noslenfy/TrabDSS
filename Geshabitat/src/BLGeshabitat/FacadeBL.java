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
import DAOGeshabitat.FaseDAO;
import DAOGeshabitat.FuncionarioDAO;
import DAOGeshabitat.MaterialDAO;
import DAOGeshabitat.PersistableException;
import DAOGeshabitat.ProjectoDAO;
import DAOGeshabitat.TarefaDAO;
import DAOGeshabitat.VoluntarioDAO;
import java.util.Date;
import java.util.List;
import java.util.Map;


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
        if(obj instanceof Fase) return new FaseDAO();
        if(obj instanceof Tarefa) return new TarefaDAO();
        return null;
    }
    
    /**
     * Mediante um Id obtem o objecto especificado atraves do seu tipo
     * @param objType -type of object to search
     * @param Id - Id of object to search
     * @return
     * @throws PersistableException
     */
    public Object get(Object objType, int Id) throws PersistableException {
        return facadeDAO.get(getType(objType), Id);
    } 
    
    public String getNomeFuncionario(int Id) throws PersistableException {
        return this.getField(new Funcionario(), "Nome", "Id", Id);
    } 

    /**
     * Select fielToShow fom TableObject where Column=Value
     * @param objType -type of object to search
     * @param fieldToShow - Campo a obter
     * @param Column - Coluna usada para filtar
     * @param Value - Valor atribuido
     * @return - Retorna o valor definido em fielToShow usando os criterios indicados
     * @throws PersistableException
     */
    public String getField(Object objType, String fieldToShow, String Column, int Value) throws PersistableException {
        return facadeDAO.get(getType(objType),fieldToShow,Column,String.valueOf(Value));
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

    /**
     * Searches all from table TableDAO where Atribute=Value
     * @param objType
     * @param Atribute
     * @param Value
     * @return
     * @throws PersistableException
     */
    public List<Object> getAll(Object objType, String Atribute, String Value) throws PersistableException {
        return facadeDAO.getAll(this.getType(objType), Atribute, Value);
    }
    public void update(Object obj, String column, Object newvalue, int Id) throws PersistableException {
        facadeDAO.update(this.getType(obj),  column, newvalue, Id);
    }

    public boolean exists(Object objType, String Atribute, String Value) throws PersistableException {
        return facadeDAO.exists(this.getType(objType), Atribute, Value);
    }

    public float getTotalDoacoes(int Doador_Id) throws PersistableException {
        return facadeDAO.getTotalDoacoes(Doador_Id);
    }  
    
    public List<Tarefa> getTarefasNRealizadas (int Projecto_Id) throws PersistableException {
        return facadeDAO.getTarefasNRealizadas(Projecto_Id);
    }
    
    public List<Tarefa> getTarefasNIniciadas (int Projecto_Id) throws PersistableException {
        return facadeDAO.getTarefasNIniciadas(Projecto_Id);
    }
    
    public List<Tarefa> getTarefasIniciadas (int Projecto_Id) throws PersistableException {
        return facadeDAO.getTarefasIniciadas(Projecto_Id);
    }
    
    public Map<Tarefa,Integer> getTarefasConcluidas (int Projecto_Id) throws PersistableException {
        return facadeDAO.getTarefasConcluidas(Projecto_Id);
    }
    
    public FacadeDAO getFacadeDAO() {
        return this.facadeDAO;
    }

 
    public void alocaMateriais(List<Date> datas, List<Material> materiais, List<Float> quantidades, List<Fase> fases) throws PersistableException {
        this.facadeDAO.alocaMateriais(datas,materiais,quantidades,fases);
    }
      
    public List<RegistoMaterial> getMateriaisUtilizados(int Project_Id) throws PersistableException {
        return facadeDAO.getMateriaisUtilizados(Project_Id);
    }
    
    public float getTotalDoado() throws PersistableException {
        return facadeDAO.getTotalDoado();
    }
}
