/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOGeshabitat;


import java.util.Collection;

/**
 *
 * @author 
 */
public interface Persistable {
    
   
    public int put(Object entity) throws PersistableException;
    public void putAll(Collection entities) throws PersistableException;
    
    public Object get(int Id) throws PersistableException;
    public Object get(String column, int Id) throws PersistableException;
    public Object get(String Column, String Atribute) throws PersistableException;
    
    // Nota - Generalizar,  não retornar string
    public String get(String fieldToShow, String Column, String Value) throws PersistableException;
    
    public Iterable getAll() throws PersistableException;
    public Iterable getAll(String Atribute, String Value) throws PersistableException;
    
    public Iterable getAll(Collection<Integer> ids) throws PersistableException;
    
    public void delete(int Id) throws PersistableException;
    public void deleteAll() throws PersistableException;
    public void deleteAll(Collection entidades) throws PersistableException;
   
    //NOTA-GENERALIZAR
    public void update(String table, String column, Object newvalue, int Id) throws PersistableException;
    
    public long count() throws PersistableException;
    
    public boolean exists(int id) throws PersistableException;
    public boolean exists(String Column, String Atribute) throws PersistableException;
}
