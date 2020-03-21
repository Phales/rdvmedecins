/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

import java.io.Serializable;
import javax.ejb.ApplicationException;


@ApplicationException(rollback=true)
public class PamException extends RuntimeException implements Serializable{

// code d'erreur
private int code;

public PamException(int code) {
super();
this.code = code;
}

public PamException(String message, int code) {
super(message);
this.code = code;
}

public PamException(Throwable cause, int code) {
super(cause);
this.code = code;
}

public PamException(String message, Throwable cause, int code) {
super(message, cause);
this.code = code;
}

public int getCode() {
return code;
}

public void setCode(int code) {
this.code = code;
}
}