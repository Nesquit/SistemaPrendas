/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;

/**
 *
 * @author nesquit
 */
public class ClienteDAO extends DAO{
    
    public void registrarCliente() throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("INSERT INTO Clientes ");
        } catch (Exception e) {
            throw e;
        } finally {
            
        }
    }
    
}
