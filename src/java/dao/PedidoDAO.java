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
import modelos.MaterialesPrendaPedido;
import modelos.Pedido;
import modelos.Tela;

/**
 *
 * @author nesquit
 */
public class PedidoDAO extends DAO {
    
    public List<Tela> listarTelas() throws Exception {
        List<Tela> listaTelas = new ArrayList();
        Tela tela = null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT materiales.id, nombre FROM materiales INNER JOIN telas ON telas.idMaterial = materiales.id");
            rs = st.executeQuery();
            while(rs.next()) {
                tela = new Tela();
                tela.setIdMaterial(rs.getInt("materiales.id"));
                tela.setNombre(rs.getString("nombre"));
                listaTelas.add(tela);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listaTelas;
    }
    
    public List<Elastico> listarElasticos() throws Exception {
        List<Elastico> listaElasticos = new ArrayList();
        Elastico elastico = null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT materiales.id, nombre FROM materiales INNER JOIN elasticos ON elasticos.idMaterial = materiales.id");
            rs = st.executeQuery();
            while(rs.next()) {
                elastico = new Elastico();
                elastico.setIdMaterial(rs.getInt("materiales.id"));
                elastico.setNombre(rs.getString("nombre"));
                listaElasticos.add(elastico);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listaElasticos;
    }
    
    public List<Boton> listarBotones() throws Exception {
        List<Boton> listaBotones = new ArrayList();
        Boton boton = null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT materiales.id, nombre FROM materiales INNER JOIN botones ON botones.idMaterial = materiales.id");
            rs = st.executeQuery();
            while(rs.next()) {
                boton = new Boton();
                boton.setIdMaterial(rs.getInt("materiales.id"));
                boton.setNombre(rs.getString("nombre"));
                listaBotones.add(boton);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listaBotones;
    }
    
    public List<Cierre> listarCierres() throws Exception {
        List<Cierre> listaCierres = new ArrayList();
        Cierre cierre = null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT materiales.id, nombre FROM materiales INNER JOIN cierres ON cierres.idMaterial = materiales.id");
            rs = st.executeQuery();
            while(rs.next()) {
                cierre = new Cierre();
                cierre.setIdMaterial(rs.getInt("materiales.id"));
                cierre.setNombre(rs.getString("nombre"));
                listaCierres.add(cierre);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listaCierres;
    }
    
    public Tela obtenerDatosTela(int idMaterial) throws Exception {
        Tela tela = null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT materiales.id AS material, telas.id AS tela, precioVenta, stock FROM telas INNER JOIN materiales ON materiales.id = telas.idMaterial WHERE telas.idMaterial = ?");
            st.setInt(1, idMaterial);
            rs = st.executeQuery();
            if(rs.first()) {
                tela = new Tela();
                tela.setIdMaterial(rs.getInt("material"));
                tela.setIdTela(rs.getInt("tela"));
                tela.setPrecioVenta(rs.getDouble("precioVenta"));
                tela.setStock(rs.getDouble("stock"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return tela;
    }
    
    public Elastico obtenerDatosElastico(int idMaterial) throws Exception {
        Elastico elastico = null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT materiales.id, elasticos.id, precioVenta, stock FROM elasticos INNER JOIN materiales ON materiales.id = elasticos.idMaterial WHERE elasticos.idMaterial = ?");
            st.setInt(1, idMaterial);
            rs = st.executeQuery();
            if(rs.first()) {
                elastico = new Elastico();
                elastico.setIdMaterial(rs.getInt("materiales.id"));
                elastico.setIdElastico(rs.getInt("elasticos.id"));
                elastico.setPrecioVenta(rs.getDouble("precioVenta"));
                elastico.setStock(rs.getDouble("stock"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return elastico;
    }
    
    public Boton obtenerDatosBoton(int idMaterial) throws Exception {
        Boton boton = null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT materiales.id, botones.id, precioVenta, stock FROM botones INNER JOIN materiales ON materiales.id = botones.idMaterial WHERE botones.idMaterial = ?");
            st.setInt(1, idMaterial);
            rs = st.executeQuery();
            if(rs.first()) {
                boton = new Boton();
                boton.setIdMaterial(rs.getInt("materiales.id"));
                boton.setIdBoton(rs.getInt("botones.id"));
                boton.setPrecioVenta(rs.getDouble("precioVenta"));
                boton.setStock(rs.getDouble("stock"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return boton;
    }
    
    public Cierre obtenerDatosCierre(int idMaterial) throws Exception {
        Cierre cierre = null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT materiales.id, cierres.id, precioVenta, stock FROM cierres INNER JOIN materiales ON materiales.id = cierres.idMaterial WHERE cierres.idMaterial = ?");
            st.setInt(1, idMaterial);
            rs = st.executeQuery();
            if(rs.first()) {
                cierre = new Cierre();
                cierre.setIdMaterial(rs.getInt("materiales.id"));
                cierre.setIdCierre(rs.getInt("cierres.id"));
                cierre.setPrecioVenta(rs.getDouble("precioVenta"));
                cierre.setStock(rs.getDouble("stock"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return cierre;
    }
    
    public int registrarPedido(double totalPedido, String user) throws Exception {
        int idPedido = 0;
        int idCliente = 0;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT id FROM clientes WHERE idUsuario = (SELECT id FROM usuarios WHERE correo = ?)");
            st.setString(1, user);
            rs = st.executeQuery();
            if(rs.first()) {
                idCliente = rs.getInt("id");
            }
            st = this.getCon().prepareStatement("INSERT INTO pedidos VALUES(0, ?, ?, now(), date_add(now(), interval 3 day), 1)");
            st.setInt(1, idCliente);
            st.setDouble(2, totalPedido);
            st.executeUpdate();
            st = this.getCon().prepareStatement("SELECT id FROM pedidos ORDER BY id DESC");
            rs = st.executeQuery();
            if(rs.first()) {
                idPedido = rs.getInt("id");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return idPedido;
    }
    
    public void registrarDetallePedido(MaterialesPrendaPedido prenda, int idPedido) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("INSERT INTO materialesprendapedido VALUES(0, ?, ?, ?, ?, ?, ?, ?)");
            st.setInt(1, prenda.getIdPrenda());
            st.setInt(2, idPedido);
            st.setInt(3, prenda.getIdMaterial());
            st.setString(4, prenda.getMaterial());
            st.setDouble(5, prenda.getCantidadMaterial());
            st.setDouble(6, prenda.getPrecioVentaMaterial());
            st.setDouble(7, prenda.getSubtotalMaterial());
            st.executeUpdate();
            st = this.getCon().prepareStatement("UPDATE materiales SET "
                    + "stock = stock - ? "
                    + "WHERE id = ?");
            st.setDouble(1, prenda.getCantidadMaterial());
            st.setInt(2, prenda.getIdMaterial());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    public List<Pedido> consultarPedidos(String user) throws Exception {
        List<Pedido> listaPedidos = new ArrayList();
        Pedido pedido = null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT * FROM pedidos WHERE idCliente = (SELECT id FROM clientes WHERE idUsuario = (SELECT id FROM usuarios WHERE correo = ?))");
            st.setString(1, user);
            rs = st.executeQuery();
            while(rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("id"));
                pedido.setIdCliente(rs.getInt("idCliente"));
                pedido.setTotalPedido(rs.getDouble("totalPedido"));
                pedido.setFechaPedido(rs.getString("fechaPedido"));
                pedido.setFechaEntrega(rs.getString("fechaEntrega"));
                pedido.setEstatus(rs.getInt("estatus"));
                listaPedidos.add(pedido);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listaPedidos;
    }
    
    public List<MaterialesPrendaPedido> verDetallePedido(Pedido pedido) throws Exception {
        List<MaterialesPrendaPedido> listaDetallePedido = new ArrayList();
        MaterialesPrendaPedido detallepedido = null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT id, tipoMaterial, (SELECT tipoPrenda FROM prendas WHERE id = idPrenda) AS prenda, (SELECT nombre FROM materiales WHERE id = idMaterial) AS material, cantidadMaterial, precioVentaMaterial, subtotalMaterial FROM materialesprendapedido WHERE idPedido = ?");
            st.setInt(1, pedido.getIdPedido());
            rs = st.executeQuery();
            while(rs.next()) {
                detallepedido = new MaterialesPrendaPedido();
                detallepedido.setId(rs.getInt("id"));
                detallepedido.setPrenda(rs.getString("prenda"));
                detallepedido.setMaterial(rs.getString("tipoMaterial"));
                detallepedido.setNombreMaterial(rs.getString("material"));
                detallepedido.setCantidadMaterial(rs.getDouble("cantidadMaterial"));
                detallepedido.setPrecioVentaMaterial(rs.getDouble("precioVentaMaterial"));
                detallepedido.setSubtotalMaterial(rs.getDouble("subtotalMaterial"));
                listaDetallePedido.add(detallepedido);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listaDetallePedido;
    }
    
}
