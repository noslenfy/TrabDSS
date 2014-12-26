/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOGeshabitat;


import java.util.Collection;

/**
 *
 * @author nelson
 */
public interface Persistable {
    
   
    public int put(Object entity) throws PersistableException;
    public void putAll(Collection entities) throws PersistableException;
    
    public Object get(int Id) throws PersistableException;
    public Object get(String column, int Id) throws PersistableException;
    
    public Iterable getAll() throws PersistableException;
    public Iterable getAll(String Column) throws PersistableException;
    
    public Iterable getAll(Collection<Integer> ids) throws PersistableException;
    
    public void delete(int Id) throws PersistableException;
    public void deleteAll() throws PersistableException;
    public void deleteAll(Collection entidades) throws PersistableException;
   
    public void update(Object entity) throws PersistableException;
    
    public long count() throws PersistableException;
    
    public boolean exists(int id) throws PersistableException;    
}
