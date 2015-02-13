/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLGeshabitat;

import BLGeshabitat.Fundos.Material;
import BLGeshabitat.Utilizadores.Funcionario;
import BLGeshabitat.Fundos.RegistoVoluntariado;
import BLGeshabitat.Projectos.RegistoMaterial;
import BLGeshabitat.Projectos.Tarefa;
import BLGeshabitat.Projectos.Fase;
import BLGeshabitat.Projectos.Projecto;
import BLGeshabitat.Fundos.Doacao;
import BLGeshabitat.Fundos.Doador;
import BLGeshabitat.Fundos.Voluntario;
import BLGeshabitat.Familias.Candidatura;
import DAOGeshabitat.Familias.CandidaturaDAO;
import DAOGeshabitat.DBConnection;
import DAOGeshabitat.Fundos.DoacaoDAO;
import DAOGeshabitat.Fundos.DoadorDAO;
import DAOGeshabitat.EntityDAO;
import DAOGeshabitat.FacadeDAO;
import DAOGeshabitat.Projectos.FaseDAO;
import DAOGeshabitat.Utilizadores.FuncionarioDAO;
import DAOGeshabitat.Fundos.MaterialDAO;
import DAOGeshabitat.PersistableException;
import DAOGeshabitat.Projectos.ProjectoDAO;
import DAOGeshabitat.Fundos.RegistoVoluntariadoDAO;
import DAOGeshabitat.Projectos.TarefaDAO;
import DAOGeshabitat.Fundos.VoluntarioDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Observable;


/**
 *
 * @author 
 */
public class GesHabitat extends Observable implements IGesHabitat {
    
    protected static FacadeDAO facadeDAO;
    

    public GesHabitat() {
        this.facadeDAO = new FacadeDAO();
    }

    public GesHabitat(DBConnection conn) throws PersistableException {
        this.facadeDAO = new FacadeDAO(conn);
    }
 
    public List<Doador> getListaDoadores() throws PersistableException {
        List<Doador> ret = new ArrayList();
        for(Object obj : facadeDAO.getAll(this.getType(new Doador()))) {
            Doador d = (Doador)obj;
            ret.add(d);
        }
        return ret;
    }   
    public List<Material> getListaMaterial() throws PersistableException {
        List<Material> ret = new ArrayList();
        for(Object obj : facadeDAO.getAll(this.getType(new Material()))) {
            Material d = (Material)obj;
            ret.add(d);
        }
        return ret;
    }
    public List<Candidatura> getListaCandidaturas() throws PersistableException {
        List<Candidatura> ret = new ArrayList();
        for(Object obj : facadeDAO.getAll(this.getType(new Candidatura()))) {
            Candidatura d = (Candidatura)obj;
            ret.add(d);
        }
        return ret;
    }
    public List<Funcionario> getListaFuncionarios() throws PersistableException {
        List<Funcionario> ret = new ArrayList();
        for(Object obj : facadeDAO.getAll(this.getType(new Funcionario()))) {
            Funcionario d = (Funcionario)obj;
            ret.add(d);
        }
        return ret;
    }
    public List<Voluntario> getListaVoluntarios() throws PersistableException {
        List<Voluntario> ret = new ArrayList();
        for(Object obj : facadeDAO.getAll(this.getType(new Voluntario()))) {
            Voluntario d = (Voluntario)obj;
            ret.add(d);
        }
        return ret;
    }
    public List<Funcionario> getListaUtilizadores() throws PersistableException {
        List<Funcionario> ret = new ArrayList();
        for(Object obj : facadeDAO.getAll(this.getType(new Funcionario()))) {
            Funcionario d = (Funcionario)obj;
            if(d.getUsername()!=null) {
                ret.add(d);
            }
        }
        return ret;
    }
    
    
    
    public void addVoluntario(Voluntario c) throws PersistableException {
        facadeDAO.put(this.getType(c), c);
    }
    public void addFuncionario(Funcionario c) throws PersistableException {
        facadeDAO.put(this.getType(c), c);
    }
    public void addDoador(Doador c) throws PersistableException {
        facadeDAO.put(this.getType(c), c);
    }        
    public void addProjecto(Projecto c) throws PersistableException {
        facadeDAO.put(this.getType(c), c);
    }    
    public void addCandidatura(Candidatura c) throws PersistableException {
        facadeDAO.put(this.getType(c), c);
    }    
    
    public Projecto getProjecto(int id) throws PersistableException {
        Projecto ret = (Projecto)facadeDAO.get(this.getType(new Projecto()), id);
        return ret;
    }
    
    
    public List<Fase> getListaFases(int Project_Id) throws PersistableException {
        Projecto p = this.getProjecto(Project_Id);
        return p.getFases(); 
    }
    
    public float verificaStock(int id_artigo) throws PersistableException {
        Material m  = (Material) this.get(this.getType(new Material()), id_artigo);
        return m.getStock();   
    }
    
    
    
    
    public static  EntityDAO getType (Object obj){
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
        if(obj instanceof RegistoVoluntariado) return new RegistoVoluntariadoDAO();        
        return null;
    }

    public void setFacadeDAO(FacadeDAO facadeDAO) {
        this.facadeDAO = facadeDAO;
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
        int generatedKey=facadeDAO.put(this.getType(obj), obj);
        this.setChanged();
        this.notifyObservers(obj);
        return generatedKey;
    }
    
    public void delete(Object obj, int Id) throws PersistableException {
        facadeDAO.delete(this.getType(obj), Id);
    }
    public List<Object> getAll(Object obj) throws PersistableException {
        return facadeDAO.getAll(this.getType(obj));
    }
    
    public List<Material> getDoacoesMateriais(int Doacao_Id) throws PersistableException {
        List<Material> ret = new ArrayList();
        Map<Integer,Float> doacoes = facadeDAO.getDoacoesMateriais(Doacao_Id);
        
        for(Map.Entry<Integer,Float> ent : doacoes.entrySet()) {
            Material m = (Material) this.get(new Material(), ent.getKey());
            m.setStock(ent.getValue());
            ret.add(m);
        }
        return ret;
    }
//
//    public Doador getDoadorMaisActivo() throws PersistableException {
//
//        for(Object obj : this.getAll(new Doador())) {
//            Doador d = (Doador)obj;
//            
//        }
//    }
    
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
    
    public List<Funcionario> getUsers()throws PersistableException {
        return facadeDAO.getUsers();
    }
    public void update(Object obj, String column, Object newvalue, int Id) throws PersistableException {
        facadeDAO.update(this.getType(obj),  column, newvalue, Id);
        this.setChanged();
        this.notifyObservers(obj);
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

 
    public List<RegistoMaterial> getMateriaisUtilizados(int Project_Id) throws PersistableException {
        return this.facadeDAO.getMateriaisUtilizados(Project_Id);
    }

      

    
    public float getTotalDoado() throws PersistableException {
        return facadeDAO.getTotalDoado();
    }

    public void setPassword(String username, String pass) throws PersistableException {
        facadeDAO.setPassword(username,pass);
    }

    public void alocaMateriais(List<Date> datas, List<Material> materiais, List<Float> quantidades, List<Fase> fases) throws PersistableException {
        facadeDAO.alocaMateriais(datas, materiais, quantidades, fases);
        this.setChanged();
        this.notifyObservers();
    }

    public void rejeitarCand(Candidatura c) throws PersistableException {
        this.update(new Candidatura(), "Estado", "Rejeitada", c.getId());
    }
    
    public void aprovarCand(Candidatura c) throws PersistableException {
        this.update(new Candidatura(), "Estado", "Aprovada", c.getId());
    }
    
    public void ReabrirCand(Candidatura c) throws PersistableException {
        this.update(new Candidatura(), "Estado", "Em Aprovação", c.getId());
    }

    public void EncerrarProjecto(Projecto pro) throws PersistableException {
        this.update(new Projecto(), "DtConclusaoProjecto", new Date(), pro.getId());
    }
    
    public void ReabrirProjecto(Projecto pro) throws PersistableException {
        this.update(new Projecto(), "DtConclusaoProjecto", null, pro.getId());
    }
    
}
