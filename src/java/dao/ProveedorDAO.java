/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelos.Proveedor;

/**
 *
 * @author nesquit
 */
public class ProveedorDAO extends DAO{
        
    
    public boolean registrar(Proveedor prov) throws Exception {
       boolean r=true;
        
        try {
            this.conectar();
            PreparedStatement st = this.getCon()
                    .prepareStatement("INSERT INTO `proveedores` "
                            + "(`nombreEmpresa`,"
                            + " `nombreContacto`,"
                            + " `apellidoContacto`,"
                            + " `direccion`, "
                            + "`telefono`, "
                            + "`correo`,"
                            + " `estatus`) VALUES (?, ?, ?, ?,  ?, ?, ?)");

            st.setString(1, prov.getNombreEmpresa());
            st.setString(2, prov.getNombreContacto());
            st.setString(3, prov.getApellidoContacto());
            st.setString(4, prov.getDireccion());
            st.setString(5, prov.getTelefono());
            st.setString(6, prov.getCorreo());
            st.setInt(7, 1);
            st.executeUpdate();
            System.out.println(st.getUpdateCount());
        } catch (Exception e) {
            System.out.println("error: jeje" + e);
            r=false;
            System.out.println("hola");
            
            
        } finally {
            this.cerrar();
        }
        System.out.println("jej "+r);
        return r;
    }
    
    
    public List<Proveedor> Listar() throws Exception{
        List<Proveedor> lista;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st=this.getCon().prepareStatement("select * from proveedores");
            rs=st.executeQuery();
            lista=new ArrayList();
            while (rs.next()) {
                Proveedor prov=new Proveedor();
                prov.setIdProveedor(rs.getInt("id"));
                prov.setNombreEmpresa(rs.getString("nombreEmpresa"));
                prov.setNombreContacto(rs.getString("nombreContacto"));
                prov.setApellidoContacto(rs.getString("apellidoContacto"));
                prov.setDireccion(rs.getString("direccion"));
                prov.setTelefono(rs.getString("telefono"));
                prov.setCorreo(rs.getString("correo"));
                prov.setEstatus(rs.getInt("estatus"));
                if (rs.getInt("estatus")==1) {
                    prov.setEstatusImg("./estatus/verde.png");
                }else if (rs.getInt("estatus")==2 || rs.getInt("estatus")==0 ) {
                    prov.setEstatusImg("./estatus/rojo.png");                    
                }
                
                lista.add(prov);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return lista;
    }
    
    public Proveedor leerID(Proveedor prove) throws Exception{
        Proveedor prov=null;
        ResultSet rs;
        
            try {
            this.conectar();
            PreparedStatement st=this.getCon().prepareStatement("select * from proveedores where id=?");
            st.setInt(1, prove.getIdProveedor());
            rs=st.executeQuery();
            
            if (rs.next()) {
                prov=new Proveedor();
                 prov.setIdProveedor(rs.getInt("id"));
                 prov.setNombreEmpresa(rs.getString("nombreEmpresa"));
                prov.setNombreContacto(rs.getString("nombreContacto"));
                prov.setApellidoContacto(rs.getString("apellidoContacto"));
                prov.setDireccion(rs.getString("direccion"));
                prov.setTelefono(rs.getString("telefono"));
                prov.setCorreo(rs.getString("correo"));
                prov.setEstatus(rs.getInt("estatus"));
             
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return prov;
        
    }
    
    
    public void modificar(Proveedor prov)throws Exception{
        try {
          
            
            this.conectar();
            PreparedStatement st=this.getCon().prepareStatement("update proveedores set "
                    + "nombreEmpresa=?,"
                    + "nombreContacto=?,"
                    + "apellidoContacto=?,"
                    + "direccion=?, "
                    + "telefono=? ,"
                    + "correo=? ,"
                    + "estatus=? "
                    + "where id=?");
            st.setString(1, prov.getNombreEmpresa());
            st.setString(2, prov.getNombreContacto());
            st.setString(3, prov.getApellidoContacto());
            st.setString(4, prov.getDireccion());
            st.setString(5, prov.getTelefono());
            st.setString(6, prov.getCorreo());
            st.setInt(7, prov.getEstatus());
            st.setInt(8, prov.getIdProveedor());
            st.executeUpdate();
            
        } catch (Exception e) {
            throw  e;
        }finally{
            this.cerrar();
        }
    }
     public void eliminar(Proveedor prov) throws Exception{
         try {
             this.conectar();
             PreparedStatement st=this.getCon().prepareStatement("delete from proveedores where id=?");
             st.setInt(1, prov.getIdProveedor());
             st.executeUpdate();
             
         } catch (Exception e) {
             throw e;
         }finally{
             this.cerrar();
         }
         
     }
    
    
}
