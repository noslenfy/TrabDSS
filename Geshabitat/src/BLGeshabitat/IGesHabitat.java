/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLGeshabitat;


import BLGeshabitat.Fundos.*;
import BLGeshabitat.Familias.*;
import BLGeshabitat.Projectos.*;
import BLGeshabitat.Utilizadores.*;
import DAOGeshabitat.PersistableException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 
 */
public interface IGesHabitat {


public List<Doador> getListaDoadores() throws PersistableException;
public List<Material> getListaMaterial() throws PersistableException;
public List<Candidatura> getListaCandidaturas() throws PersistableException;
public List<Funcionario> getListaFuncionarios() throws PersistableException;
public List<Voluntario> getListaVoluntarios() throws PersistableException;
public List<Funcionario> getListaUtilizadores() throws PersistableException;
public List<Fase> getListaFases(int Project_Id) throws PersistableException;


public void addVoluntario(Voluntario c) throws PersistableException;
public void addFuncionario(Funcionario c) throws PersistableException;
public void addDoador(Doador c) throws PersistableException;
public void addProjecto(Projecto c) throws PersistableException;
public void addCandidatura(Candidatura c) throws PersistableException;


public Projecto getProjecto(int id) throws PersistableException;
public float verificaStock(int id_artigo) throws PersistableException;
public Object get(Object objType, int Id) throws PersistableException;
public String getNomeFuncionario(int Id) throws PersistableException;
public String getField(Object objType, String fieldToShow, String Column, int Value) throws PersistableException;


public int put(Object obj) throws PersistableException;
public void delete(Object obj, int Id) throws PersistableException;
public List<Object> getAll(Object obj) throws PersistableException;
public List<Material> getDoacoesMateriais(int Doacao_Id) throws PersistableException;
public List<Object> getAll(Object objType, String Atribute, String Value) throws PersistableException;
public List<Funcionario> getUsers()throws PersistableException;
public void update(Object obj, String column, Object newvalue, int Id) throws PersistableException;
public boolean exists(Object objType, String Atribute, String Value) throws PersistableException;
public float getTotalDoacoes(int Doador_Id) throws PersistableException;

public List<Tarefa> getTarefasNRealizadas (int Projecto_Id) throws PersistableException;
public List<Tarefa> getTarefasNIniciadas (int Projecto_Id) throws PersistableException;
public List<Tarefa> getTarefasIniciadas (int Projecto_Id) throws PersistableException;
public Map<Tarefa,Integer> getTarefasConcluidas (int Projecto_Id) throws PersistableException;

public List<RegistoMaterial> getMateriaisUtilizados(int Project_Id) throws PersistableException;

public float getTotalDoado() throws PersistableException;
public void setPassword(String username, String pass) throws PersistableException;
public void alocaMateriais(List<Date> datas, List<Material> materiais, List<Float> quantidades, List<Fase> fases) throws PersistableException;
public void rejeitarCand(Candidatura c) throws PersistableException;
public void aprovarCand(Candidatura c) throws PersistableException;
public void ReabrirCand(Candidatura c) throws PersistableException;
public void EncerrarProjecto(Projecto pro) throws PersistableException;
public void ReabrirProjecto(Projecto pro) throws PersistableException;


}
