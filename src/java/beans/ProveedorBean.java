/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author nesquit
 */
@Named(value = "proveedorBean")
@Dependent
public class ProveedorBean {

    /**
     * Creates a new instance of ProveedorBean
     */
    public ProveedorBean() {
    }
    
}
