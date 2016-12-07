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
import modelos.Compra;
import modelos.DetalleCompra;
import modelos.Material;

/**
 *
 * @author nesquit
 */
public class CompraDAO extends DAO {

    public List<Material> obtenerMateriales(String categoria) throws Exception {
        List<Material> listaMateriales = null;
        Material material;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT materiales.id, nombre FROM materiales INNER JOIN "+categoria+" WHERE "+categoria+".idMaterial = materiales.id AND materiales.estatus = 1");
            rs = st.executeQuery();
            listaMateriales = new ArrayList();
            while(rs.next()) {
                material = new Material();
                material.setIdMaterial(rs.getInt("id"));
                material.setNombre(rs.getString("nombre"));
                listaMateriales.add(material);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listaMateriales;
    }
    
    public String consultarStock(int idMaterial) throws Exception {
        String stockExistente = null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT stock FROM materiales WHERE id = ?");
            st.setInt(1, idMaterial);
            rs = st.executeQuery();
            if(rs.first()) {
                stockExistente = rs.getString("stock");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return stockExistente;
    }
    
    public Material consultarMaterial(int idMaterial) throws Exception {
        Material material =  null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT id, nombre, precioCompra FROM materiales WHERE id = ?");
            st.setInt(1, idMaterial);
            rs = st.executeQuery();
            if(rs.first()) {
                material = new Material();
                material.setIdMaterial(rs.getInt("id"));
                material.setNombre(rs.getString("nombre"));
                material.setPrecioCompra(rs.getDouble("precioCompra"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return material;
    }
    
    public int registrarCompra(double totalCompra) throws Exception {
        int idCompra = 0;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("INSERT INTO compras VALUES(0, ?, now())");
            st.setDouble(1, totalCompra);
            st.executeUpdate();
            st = this.getCon().prepareStatement("SELECT id FROM compras ORDER BY id DESC");
            rs = st.executeQuery();
            if(rs.first()) {
                idCompra = rs.getInt("id");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return idCompra;
    }
    
    public void registrarDetalleCompra(DetalleCompra detalleCompra, int idCompra) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("INSERT INTO detallecompra VALUES(0, ?, ?, ?, ?, ?)");
            st.setInt(1, idCompra);
            st.setInt(2, detalleCompra.getIdMaterial());
            st.setDouble(3, detalleCompra.getPrecioCompraMaterial());
            st.setDouble(4, detalleCompra.getTotalPrecioCompraMaterial());
            st.setInt(5, detalleCompra.getTotalUnidadesMaterial());
            st.executeUpdate();
            st = this.getCon().prepareStatement("UPDATE materiales SET "
                    + "stock = stock + ? "
                    + "WHERE id = ?");
            st.setInt(1, detalleCompra.getTotalUnidadesMaterial());
            st.setInt(2, detalleCompra.getIdMaterial());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    public List<Compra> consultarCompras() throws Exception {
        List<Compra> listaCompras = new ArrayList();
        Compra compra = null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT * FROM compras");
            rs = st.executeQuery();
            while(rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("id"));
                compra.setTotalCompra(rs.getDouble("totalCompra"));
                compra.setFechaCompra(rs.getString("fechaCompra"));
                listaCompras.add(compra);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listaCompras;
    }
    
    public List<DetalleCompra> verDetalleCompra(Compra compra) throws Exception {
        List<DetalleCompra> listaDetalleCompra = new ArrayList();
        DetalleCompra detalleCompra = null;
        ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCon().prepareStatement("SELECT id, idCompra, (SELECT nombre FROM materiales WHERE id = idMaterial) AS material, precioCompraMaterial, totalPrecioCompraMaterial, totalUnidadesMaterial FROM detallecompra WHERE idCompra = ?");
            st.setInt(1, compra.getIdCompra());
            rs = st.executeQuery();
            while(rs.next()) {
                detalleCompra = new DetalleCompra();
                detalleCompra.setIdDetalleCompra(rs.getInt("id"));
                detalleCompra.setIdCompra(rs.getInt("idCompra"));
                detalleCompra.setNombreMaterial(rs.getString("material"));
                detalleCompra.setPrecioCompraMaterial(rs.getDouble("precioCompraMaterial"));
                detalleCompra.setTotalPrecioCompraMaterial(rs.getDouble("totalPrecioCompraMaterial"));
                detalleCompra.setTotalUnidadesMaterial(rs.getInt("totalUnidadesMaterial"));
                listaDetalleCompra.add(detalleCompra);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listaDetalleCompra;
    }
    
}
