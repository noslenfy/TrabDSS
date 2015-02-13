/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOGeshabitat;

/**
 *
 * @author 
 */
public class PersistableException extends Exception{

    public PersistableException() {
    }

    public PersistableException(String message) {
        super(message);
    }

    public PersistableException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistableException(Throwable cause) {
        super(cause);
    }
}
