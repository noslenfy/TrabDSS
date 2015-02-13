/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOGeshabitat;

import BLGeshabitat.Fundos.*;
import BLGeshabitat.Projectos.*;
import BLGeshabitat.Utilizadores.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 
 */
public interface IFacadeDAO {

  
public void connect() throws PersistableException;
public void closeConnection()throws PersistableException;
    
    
            
public int put(EntityDAO entityTypeDAO, Object obj) throws PersistableException;
public void update(EntityDAO entityTypeDAO, String column, Object value, int Id) throws PersistableException; 
public Object get(EntityDAO entityTypeDAO, int Id) throws PersistableException;
public Object get(EntityDAO entityTypeDAO, String Column, int Id) throws PersistableException;
public String get(EntityDAO entityTypeDAO, String fieldToShow, String Column, String Value) throws PersistableException;
public List<Object> getAll(EntityDAO entityTypeDAO) throws PersistableException;
public List<Object> getAll(EntityDAO entityTypeDAO, String Atribute, String Value) throws PersistableException;
public void delete(EntityDAO entityTypeDAO, int Id) throws PersistableException;
public void deleteAll(EntityDAO entityTypeDAO) throws PersistableException;
public long count(EntityDAO entityTypeDAO) throws PersistableException;  
public boolean exists(EntityDAO entityTypeDAO, int id) throws PersistableException;
public boolean exists(EntityDAO entityTypeDAO, String Column, String Value) throws PersistableException;

public Map<Integer,Float> getDoacoesMateriais(int Doacao) throws PersistableException;
public List<Funcionario> getUsers() throws PersistableException;

public List<Tarefa> getTarefasNRealizadas (int Projecto_Id) throws PersistableException;
public List<Tarefa> getTarefasNIniciadas (int Projecto_Id) throws PersistableException;
public List<Tarefa> getTarefasIniciadas (int Projecto_Id) throws PersistableException;
public Map<Tarefa,Integer>  getTarefasConcluidas (int Projecto_Id) throws PersistableException;
public float getTotalDoacoes(int Doador_Id) throws PersistableException;
public void alocaMateriais(List<Date> datas, List<Material> materiais, List<Float> quantidades, List<Fase> fases) throws PersistableException;
public List<RegistoMaterial> getMateriaisUtilizados(int Project_Id) throws PersistableException;
public float getTotalDoado() throws PersistableException;
public void setPassword(String username, String pass) throws PersistableException;
    
}
    


