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
import modelos.Boton;
import modelos.Cierre;
import modelos.Elastico;
import modelos.Material;
import modelos.Primario;
import modelos.Proveedor;
import modelos.Tela;

/**
 *
 * @author nesquit
 */
public class MaterialDAO extends DAO {
    
    public void registrarBoton(Boton boton) throws Exception {
        int idMaterial = 0;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("INSERT INTO materiales VALUES(0, ?, ?, ? ,? ,? ,?, ?, 1)");
            st.setInt(1, boton.getIdProveedor());
            st.setString(2, boton.getNombre());
            st.setString(3, boton.getDescripcion());
            st.setDouble(4, boton.getPrecioCompra());
            st.setDouble(5, boton.getPrecioVenta());
            st.setString(6, boton.getUnidadMedida());
            st.setInt(7, boton.getStock());
            st.executeUpdate();
            st = this.getCon().prepareStatement("SELECT id FROM materiales ORDER BY id DESC");
            rs = st.executeQuery();
            if(rs.first()) {
                idMaterial = rs.getInt("id");
            }
            st = this.getCon().prepareStatement("INSERT INTO botones VALUES(0, ?, ?, ?)");
            st.setInt(1, idMaterial);
            st.setString(2, boton.getColor());
            st.setString(3, boton.getTamanio());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    public List<Boton> listarBotones() throws Exception {
        List<Boton> listaBotones = null;
        Boton boton;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT botones.id, idMaterial, color, tamanio, (SELECT nombreEmpresa FROM proveedores WHERE id = idProveedor) AS proveedor, nombre, descripcion, precioCompra, precioVenta, unidadMedida, stock, estatus FROM botones INNER JOIN materiales ON materiales.id = botones.idMaterial");
            rs = st.executeQuery();
            listaBotones = new ArrayList();
            while(rs.next()) {
                boton = new Boton();
                boton.setIdBoton(rs.getInt("id"));
                boton.setIdMaterial(rs.getInt("idMaterial"));
                boton.setColor(rs.getString("color"));
                boton.setTamanio(rs.getString("tamanio"));
                boton.setProveedor(rs.getString("proveedor"));
                boton.setNombre(rs.getString("nombre"));
                boton.setDescripcion(rs.getString("descripcion"));
                boton.setPrecioCompra(rs.getDouble("precioCompra"));
                boton.setPrecioVenta(rs.getDouble("precioVenta"));
                boton.setUnidadMedida(rs.getString("unidadMedida"));
                boton.setStock(rs.getInt("stock"));
                boton.setEstatus(rs.getInt("estatus"));
                listaBotones.add(boton);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listaBotones;
    }
    
    public Boton leerIdBoton(Boton boton) throws Exception {
        Boton nuevoBoton = null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT botones.id, idMaterial, color, tamanio, idProveedor, nombre, descripcion, precioCompra, precioVenta, unidadMedida, stock, estatus FROM botones INNER JOIN materiales ON materiales.id = botones.idMaterial WHERE botones.id = ?");
            st.setInt(1, boton.getIdBoton());
            System.out.println(st);
            rs = st.executeQuery();
            if(rs.next()) {
                nuevoBoton = new Boton();
                nuevoBoton.setIdBoton(rs.getInt("botones.id"));
                nuevoBoton.setIdMaterial(rs.getInt("idMaterial"));
                nuevoBoton.setColor(rs.getString("color"));
                nuevoBoton.setTamanio(rs.getString("tamanio"));
                nuevoBoton.setIdProveedor(rs.getInt("idProveedor"));
                nuevoBoton.setNombre(rs.getString("nombre"));
                nuevoBoton.setDescripcion(rs.getString("descripcion"));
                nuevoBoton.setPrecioCompra(rs.getDouble("precioCompra"));
                nuevoBoton.setPrecioVenta(rs.getDouble("precioVenta"));
                nuevoBoton.setUnidadMedida(rs.getString("unidadMedida"));
                nuevoBoton.setStock(rs.getInt("stock"));
                nuevoBoton.setEstatus(rs.getInt("estatus"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return nuevoBoton;
    }
    
    public void actualizarBoton(Boton boton) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("UPDATE materiales SET "
                    + "idProveedor = ?, "
                    + "nombre = ?, "
                    + "descripcion = ?, "
                    + "precioCompra = ?, "
                    + "precioVenta = ?, "
                    + "unidadMedida = ?, "
                    + "estatus = ? "
                    + "WHERE id = ?");
            st.setInt(1, boton.getIdProveedor());
            st.setString(2, boton.getNombre());
            st.setString(3, boton.getDescripcion());
            st.setDouble(4, boton.getPrecioCompra());
            st.setDouble(5, boton.getPrecioVenta());
            st.setString(6, boton.getUnidadMedida());
            st.setInt(7, boton.getEstatus());
            st.setInt(8, boton.getIdMaterial());
            st.executeUpdate();
            st = this.getCon().prepareStatement("UPDATE botones SET "
                    + "color = ?, "
                    + "tamanio = ? "
                    + "WHERE id = ?");
            st.setString(1, boton.getColor());
            st.setString(2, boton.getTamanio());
            st.setInt(3, boton.getIdBoton());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    public void registrarCierre(Cierre cierre) throws Exception {
        int idMaterial = 0;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("INSERT INTO materiales VALUES(0, ?, ?, ? ,? ,? ,?, ?, 1)");
            st.setInt(1, cierre.getIdProveedor());
            st.setString(2, cierre.getNombre());
            st.setString(3, cierre.getDescripcion());
            st.setDouble(4, cierre.getPrecioCompra());
            st.setDouble(5, cierre.getPrecioVenta());
            st.setString(6, cierre.getUnidadMedida());
            st.setInt(7, cierre.getStock());
            st.executeUpdate();
            st = this.getCon().prepareStatement("SELECT id FROM materiales ORDER BY id DESC");
            rs = st.executeQuery();
            if(rs.first()) {
                idMaterial = rs.getInt("id");
            }
            st = this.getCon().prepareStatement("INSERT INTO cierres VALUES(0, ?, ?, ?, ?)");
            st.setInt(1, idMaterial);
            st.setString(2, cierre.getColor());
            st.setString(3, cierre.getMaterial());
            st.setString(4, cierre.getTamanio());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    public List<Cierre> listarCierres() throws Exception {
        List<Cierre> listaCierres = null;
        Cierre cierre;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT cierres.id, idMaterial, color, material, tamanio, (SELECT nombreEmpresa FROM proveedores WHERE id = idProveedor) AS proveedor, nombre, descripcion, precioCompra, precioVenta, unidadMedida, stock, estatus FROM cierres INNER JOIN materiales ON materiales.id = cierres.idMaterial");
            rs = st.executeQuery();
            listaCierres = new ArrayList();
            while(rs.next()) {
                cierre = new Cierre();
                cierre.setIdCierre(rs.getInt("id"));
                cierre.setIdMaterial(rs.getInt("idMaterial"));
                cierre.setColor(rs.getString("color"));
                cierre.setMaterial(rs.getString("material"));
                cierre.setTamanio(rs.getString("tamanio"));
                cierre.setProveedor(rs.getString("proveedor"));
                cierre.setNombre(rs.getString("nombre"));
                cierre.setDescripcion(rs.getString("descripcion"));
                cierre.setPrecioCompra(rs.getDouble("precioCompra"));
                cierre.setPrecioVenta(rs.getDouble("precioVenta"));
                cierre.setUnidadMedida(rs.getString("unidadMedida"));
                cierre.setStock(rs.getInt("stock"));
                cierre.setEstatus(rs.getInt("estatus"));
                listaCierres.add(cierre);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listaCierres;
    }
    
    public Cierre leerIdCierre(Cierre cierre) throws Exception {
        Cierre nuevoCierre = null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT cierres.id, idMaterial, color, material, tamanio, idProveedor, nombre, descripcion, precioCompra, precioVenta, unidadMedida, stock, estatus FROM cierres INNER JOIN materiales ON materiales.id = cierres.idMaterial WHERE cierres.id = ?");
            st.setInt(1, cierre.getIdCierre());
            rs = st.executeQuery();
            if(rs.next()) {
                nuevoCierre = new Cierre();
                nuevoCierre.setIdCierre(rs.getInt("cierres.id"));
                nuevoCierre.setIdMaterial(rs.getInt("idMaterial"));
                nuevoCierre.setColor(rs.getString("color"));
                nuevoCierre.setMaterial(rs.getString("material"));
                nuevoCierre.setTamanio(rs.getString("tamanio"));
                nuevoCierre.setIdProveedor(rs.getInt("idProveedor"));
                nuevoCierre.setNombre(rs.getString("nombre"));
                nuevoCierre.setDescripcion(rs.getString("descripcion"));
                nuevoCierre.setPrecioCompra(rs.getDouble("precioCompra"));
                nuevoCierre.setPrecioVenta(rs.getDouble("precioVenta"));
                nuevoCierre.setUnidadMedida(rs.getString("unidadMedida"));
                nuevoCierre.setStock(rs.getInt("stock"));
                nuevoCierre.setEstatus(rs.getInt("estatus"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return nuevoCierre;
    }
    
    public void actualizarCierre(Cierre cierre) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("UPDATE materiales SET "
                    + "idProveedor = ?, "
                    + "nombre = ?, "
                    + "descripcion = ?, "
                    + "precioCompra = ?, "
                    + "precioVenta = ?, "
                    + "unidadMedida = ?, "
                    + "estatus = ? "
                    + "WHERE id = ?");
            st.setInt(1, cierre.getIdProveedor());
            st.setString(2, cierre.getNombre());
            st.setString(3, cierre.getDescripcion());
            st.setDouble(4, cierre.getPrecioCompra());
            st.setDouble(5, cierre.getPrecioVenta());
            st.setString(6, cierre.getUnidadMedida());
            st.setInt(7, cierre.getEstatus());
            st.setInt(8, cierre.getIdMaterial());
            st.executeUpdate();
            st = this.getCon().prepareStatement("UPDATE cierres SET "
                    + "color = ?, "
                    + "material = ?, "
                    + "tamanio = ? "
                    + "WHERE id = ?");
            st.setString(1, cierre.getColor());
            st.setString(2, cierre.getMaterial());
            st.setString(3, cierre.getTamanio());
            st.setInt(4, cierre.getIdCierre());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    public void registrarElastico(Elastico elastico) throws Exception {
        int idMaterial = 0;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("INSERT INTO materiales VALUES(0, ?, ?, ? ,? ,? ,?, ?, 1)");
            st.setInt(1, elastico.getIdProveedor());
            st.setString(2, elastico.getNombre());
            st.setString(3, elastico.getDescripcion());
            st.setDouble(4, elastico.getPrecioCompra());
            st.setDouble(5, elastico.getPrecioVenta());
            st.setString(6, elastico.getUnidadMedida());
            st.setInt(7, elastico.getStock());
            st.executeUpdate();
            st = this.getCon().prepareStatement("SELECT id FROM materiales ORDER BY id DESC");
            rs = st.executeQuery();
            if(rs.first()) {
                idMaterial = rs.getInt("id");
            }
            st = this.getCon().prepareStatement("INSERT INTO elasticos VALUES(0, ?, ?, ?)");
            st.setInt(1, idMaterial);
            st.setString(2, elastico.getColor());
            st.setInt(3, elastico.getAnchura());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    public List<Elastico> listarElasticos() throws Exception {
        List<Elastico> listaElasticos = null;
        Elastico elastico;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT elasticos.id, idMaterial, color, anchura, (SELECT nombreEmpresa FROM proveedores WHERE id = idProveedor) AS proveedor, nombre, descripcion, precioCompra, precioVenta, unidadMedida, stock, estatus FROM elasticos INNER JOIN materiales ON materiales.id = elasticos.idMaterial");
            rs = st.executeQuery();
            listaElasticos = new ArrayList();
            while(rs.next()) {
                elastico = new Elastico();
                elastico.setIdElastico(rs.getInt("id"));
                elastico.setIdMaterial(rs.getInt("idMaterial"));
                elastico.setColor(rs.getString("color"));
                elastico.setAnchura(rs.getInt("anchura"));
                elastico.setProveedor(rs.getString("proveedor"));
                elastico.setNombre(rs.getString("nombre"));
                elastico.setDescripcion(rs.getString("descripcion"));
                elastico.setPrecioCompra(rs.getDouble("precioCompra"));
                elastico.setPrecioVenta(rs.getDouble("precioVenta"));
                elastico.setUnidadMedida(rs.getString("unidadMedida"));
                elastico.setStock(rs.getInt("stock"));
                elastico.setEstatus(rs.getInt("estatus"));
                listaElasticos.add(elastico);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listaElasticos;
    }
    
    public Elastico leerIdElastico(Elastico elastico) throws Exception {
        Elastico nuevoElastico = null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT elasticos.id, idMaterial, color, anchura, idProveedor, nombre, descripcion, precioCompra, precioVenta, unidadMedida, stock, estatus FROM elasticos INNER JOIN materiales ON materiales.id = elasticos.idMaterial WHERE elasticos.id = ?");
            st.setInt(1, elastico.getIdElastico());
            rs = st.executeQuery();
            if(rs.next()) {
                nuevoElastico = new Elastico();
                nuevoElastico.setIdElastico(rs.getInt("id"));
                nuevoElastico.setIdMaterial(rs.getInt("idMaterial"));
                nuevoElastico.setColor(rs.getString("color"));
                nuevoElastico.setAnchura(rs.getInt("anchura"));
                nuevoElastico.setIdProveedor(rs.getInt("idProveedor"));
                nuevoElastico.setNombre(rs.getString("nombre"));
                nuevoElastico.setDescripcion(rs.getString("descripcion"));
                nuevoElastico.setPrecioCompra(rs.getDouble("precioCompra"));
                nuevoElastico.setPrecioVenta(rs.getDouble("precioVenta"));
                nuevoElastico.setUnidadMedida(rs.getString("unidadMedida"));
                nuevoElastico.setStock(rs.getInt("stock"));
                nuevoElastico.setEstatus(rs.getInt("estatus"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return nuevoElastico;
    }
    
    public void actualizarElastico(Elastico elastico) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("UPDATE materiales SET "
                    + "idProveedor = ?, "
                    + "nombre = ?, "
                    + "descripcion = ?, "
                    + "precioCompra = ?, "
                    + "precioVenta = ?, "
                    + "unidadMedida = ?, "
                    + "estatus = ? "
                    + "WHERE id = ?");
            st.setInt(1, elastico.getIdProveedor());
            st.setString(2, elastico.getNombre());
            st.setString(3, elastico.getDescripcion());
            st.setDouble(4, elastico.getPrecioCompra());
            st.setDouble(5, elastico.getPrecioVenta());
            st.setString(6, elastico.getUnidadMedida());
            st.setInt(7, elastico.getEstatus());
            st.setInt(8, elastico.getIdMaterial());
            st.executeUpdate();
            st = this.getCon().prepareStatement("UPDATE elasticos SET "
                    + "color = ?, "
                    + "anchura = ? "
                    + "WHERE id = ?");
            st.setString(1, elastico.getColor());
            st.setInt(2, elastico.getAnchura());
            st.setInt(3, elastico.getIdElastico());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    public void registrarPrimario(Primario primario) throws Exception {
        int idMaterial = 0;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("INSERT INTO materiales VALUES(0, ?, ?, ? ,? ,? ,?, ?, 1)");
            st.setInt(1, primario.getIdProveedor());
            st.setString(2, primario.getNombre());
            st.setString(3, primario.getDescripcion());
            st.setDouble(4, primario.getPrecioCompra());
            st.setDouble(5, primario.getPrecioVenta());
            st.setString(6, primario.getUnidadMedida());
            st.setInt(7, primario.getStock());
            st.executeUpdate();
            st = this.getCon().prepareStatement("SELECT id FROM materiales ORDER BY id DESC");
            rs = st.executeQuery();
            if(rs.first()) {
                idMaterial = rs.getInt("id");
            }
            st = this.getCon().prepareStatement("INSERT INTO primarios VALUES(0, ?, ?)");
            st.setInt(1, idMaterial);
            st.setString(2, primario.getColor());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    public List<Primario> listarPrimarios() throws Exception {
        List<Primario> listaPrimarios = null;
        Primario primario;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT primarios.id, idMaterial, color, (SELECT nombreEmpresa FROM proveedores WHERE id = idProveedor) AS proveedor, nombre, descripcion, precioCompra, precioVenta, unidadMedida, stock, estatus FROM primarios INNER JOIN materiales ON materiales.id = primarios.idMaterial");
            rs = st.executeQuery();
            listaPrimarios = new ArrayList();
            while(rs.next()) {
                primario = new Primario();
                primario.setIdPrimario(rs.getInt("id"));
                primario.setIdMaterial(rs.getInt("idMaterial"));
                primario.setColor(rs.getString("color"));
                primario.setProveedor(rs.getString("proveedor"));
                primario.setNombre(rs.getString("nombre"));
                primario.setDescripcion(rs.getString("descripcion"));
                primario.setPrecioCompra(rs.getDouble("precioCompra"));
                primario.setPrecioVenta(rs.getDouble("precioVenta"));
                primario.setUnidadMedida(rs.getString("unidadMedida"));
                primario.setStock(rs.getInt("stock"));
                primario.setEstatus(rs.getInt("estatus"));
                listaPrimarios.add(primario);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listaPrimarios;
    }
    
    public Primario leerIdPrimario(Primario primario) throws Exception {
        Primario nuevoPrimario = null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT primarios.id, idMaterial, color, idProveedor, nombre, descripcion, precioCompra, precioVenta, unidadMedida, stock, estatus FROM primarios INNER JOIN materiales ON materiales.id = primarios.idMaterial WHERE primarios.id = ?");
            st.setInt(1, primario.getIdPrimario());
            rs = st.executeQuery();
            if(rs.next()) {
                nuevoPrimario = new Primario();
                nuevoPrimario.setIdPrimario(rs.getInt("id"));
                nuevoPrimario.setIdMaterial(rs.getInt("idMaterial"));
                nuevoPrimario.setColor(rs.getString("color"));
                nuevoPrimario.setIdProveedor(rs.getInt("idProveedor"));
                nuevoPrimario.setNombre(rs.getString("nombre"));
                nuevoPrimario.setDescripcion(rs.getString("descripcion"));
                nuevoPrimario.setPrecioCompra(rs.getDouble("precioCompra"));
                nuevoPrimario.setPrecioVenta(rs.getDouble("precioVenta"));
                nuevoPrimario.setUnidadMedida(rs.getString("unidadMedida"));
                nuevoPrimario.setStock(rs.getInt("stock"));
                nuevoPrimario.setEstatus(rs.getInt("estatus"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return nuevoPrimario;
    }
    
    public void actualizarPrimario(Primario primario) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("UPDATE materiales SET "
                    + "idProveedor = ?, "
                    + "nombre = ?, "
                    + "descripcion = ?, "
                    + "precioCompra = ?, "
                    + "precioVenta = ?, "
                    + "unidadMedida = ?, "
                    + "estatus = ? "
                    + "WHERE id = ?");
            st.setInt(1, primario.getIdProveedor());
            st.setString(2, primario.getNombre());
            st.setString(3, primario.getDescripcion());
            st.setDouble(4, primario.getPrecioCompra());
            st.setDouble(5, primario.getPrecioVenta());
            st.setString(6, primario.getUnidadMedida());
            st.setInt(7, primario.getEstatus());
            st.setInt(8, primario.getIdMaterial());
            st.executeUpdate();
            st = this.getCon().prepareStatement("UPDATE primarios SET "
                    + "color = ? "
                    + "WHERE id = ?");
            st.setString(1, primario.getColor());
            st.setInt(2, primario.getIdPrimario());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    public void registrarTela(Tela tela) throws Exception {
        int idMaterial = 0;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("INSERT INTO materiales VALUES(0, ?, ?, ? ,? ,? ,?, ?, 1)");
            st.setInt(1, tela.getIdProveedor());
            st.setString(2, tela.getNombre());
            st.setString(3, tela.getDescripcion());
            st.setDouble(4, tela.getPrecioCompra());
            st.setDouble(5, tela.getPrecioVenta());
            st.setString(6, tela.getUnidadMedida());
            st.setInt(7, tela.getStock());
            st.executeUpdate();
            st = this.getCon().prepareStatement("SELECT id FROM materiales ORDER BY id DESC");
            rs = st.executeQuery();
            if(rs.first()) {
                idMaterial = rs.getInt("id");
            }
            st = this.getCon().prepareStatement("INSERT INTO telas VALUES(0, ?, ?, ?)");
            st.setInt(1, idMaterial);
            st.setString(2, tela.getColor());
            st.setString(3, tela.getTextura());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    public List<Tela> listarTelas() throws Exception {
        List<Tela> listaTelas = null;
        Tela tela;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT telas.id, idMaterial, color, textura, (SELECT nombreEmpresa FROM proveedores WHERE id = idProveedor) AS proveedor, nombre, descripcion, precioCompra, precioVenta, unidadMedida, stock, estatus FROM telas INNER JOIN materiales ON materiales.id = telas.idMaterial");
            rs = st.executeQuery();
            listaTelas = new ArrayList();
            while(rs.next()) {
                tela = new Tela();
                tela.setIdTela(rs.getInt("id"));
                tela.setIdMaterial(rs.getInt("idMaterial"));
                tela.setColor(rs.getString("color"));
                tela.setTextura(rs.getString("textura"));
                tela.setProveedor(rs.getString("proveedor"));
                tela.setNombre(rs.getString("nombre"));
                tela.setDescripcion(rs.getString("descripcion"));
                tela.setPrecioCompra(rs.getDouble("precioCompra"));
                tela.setPrecioVenta(rs.getDouble("precioVenta"));
                tela.setUnidadMedida(rs.getString("unidadMedida"));
                tela.setStock(rs.getInt("stock"));
                tela.setEstatus(rs.getInt("estatus"));
                listaTelas.add(tela);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listaTelas;
    }
    
    public Tela leerIdTela(Tela tela) throws Exception {
        Tela nuevaTela = null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT telas.id, idMaterial, color, textura, idProveedor, nombre, descripcion, precioCompra, precioVenta, unidadMedida, stock, estatus FROM telas INNER JOIN materiales ON materiales.id = telas.idMaterial WHERE telas.id = ?");
            st.setInt(1, tela.getIdTela());
            rs = st.executeQuery();
            if(rs.next()) {
                nuevaTela = new Tela();
                nuevaTela.setIdTela(rs.getInt("id"));
                nuevaTela.setIdMaterial(rs.getInt("idMaterial"));
                nuevaTela.setColor(rs.getString("color"));
                nuevaTela.setTextura(rs.getString("textura"));
                nuevaTela.setIdProveedor(rs.getInt("idProveedor"));
                nuevaTela.setNombre(rs.getString("nombre"));
                nuevaTela.setDescripcion(rs.getString("descripcion"));
                nuevaTela.setPrecioCompra(rs.getDouble("precioCompra"));
                nuevaTela.setPrecioVenta(rs.getDouble("precioVenta"));
                nuevaTela.setUnidadMedida(rs.getString("unidadMedida"));
                nuevaTela.setStock(rs.getInt("stock"));
                nuevaTela.setEstatus(rs.getInt("estatus"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return nuevaTela;
    }
    
    public void actualizarTela(Tela tela) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("UPDATE materiales SET "
                    + "idProveedor = ?, "
                    + "nombre = ?, "
                    + "descripcion = ?, "
                    + "precioCompra = ?, "
                    + "precioVenta = ?, "
                    + "unidadMedida = ?, "
                    + "estatus = ? "
                    + "WHERE id = ?");
            st.setInt(1, tela.getIdProveedor());
            st.setString(2, tela.getNombre());
            st.setString(3, tela.getDescripcion());
            st.setDouble(4, tela.getPrecioCompra());
            st.setDouble(5, tela.getPrecioVenta());
            st.setString(6, tela.getUnidadMedida());
            st.setInt(7, tela.getEstatus());
            st.setInt(8, tela.getIdMaterial());
            st.executeUpdate();
            st = this.getCon().prepareStatement("UPDATE telas SET "
                    + "color = ?,"
                    + "textura = ? "
                    + "WHERE id = ?");
            st.setString(1, tela.getColor());
            st.setString(2, tela.getTextura());
            st.setInt(3, tela.getIdTela());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
}
