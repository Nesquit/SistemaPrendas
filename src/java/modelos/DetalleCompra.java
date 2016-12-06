/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author nesquit
 */
public class DetalleCompra {
    
    private int idDetalleCompra;
    private int idCompra;
    private int idMaterial;
    private double precioCompraMaterial;
    private double totalPrecioCompraMaterial;
    private int totalUnidadesMaterial;

    public int getIdDetalleCompra() {
        return idDetalleCompra;
    }

    public void setIdDetalleCompra(int idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public double getPrecioCompraMaterial() {
        return precioCompraMaterial;
    }

    public void setPrecioCompraMaterial(double precioCompraMaterial) {
        this.precioCompraMaterial = precioCompraMaterial;
    }

    public double getTotalPrecioCompraMaterial() {
        return totalPrecioCompraMaterial;
    }

    public void setTotalPrecioCompraMaterial(double totalPrecioCompraMaterial) {
        this.totalPrecioCompraMaterial = totalPrecioCompraMaterial;
    }

    public int getTotalUnidadesMaterial() {
        return totalUnidadesMaterial;
    }

    public void setTotalUnidadesMaterial(int totalUnidadesMaterial) {
        this.totalUnidadesMaterial = totalUnidadesMaterial;
    }
    
}
