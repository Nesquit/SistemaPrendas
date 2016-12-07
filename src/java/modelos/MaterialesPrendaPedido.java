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
public class MaterialesPrendaPedido extends Prenda {
    
    private int id;
    private int idPedido;
    private int idMaterial;
    private String prenda;
    private String material;
    private String nombreMaterial;
    private double cantidadMaterial;
    private double precioVentaMaterial;
    private double subtotalMaterial;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public double getCantidadMaterial() {
        return cantidadMaterial;
    }

    public void setCantidadMaterial(double cantidadMaterial) {
        this.cantidadMaterial = cantidadMaterial;
    }

    public double getPrecioVentaMaterial() {
        return precioVentaMaterial;
    }

    public void setPrecioVentaMaterial(double precioVentaMaterial) {
        this.precioVentaMaterial = precioVentaMaterial;
    }

    public double getSubtotalMaterial() {
        return subtotalMaterial;
    }

    public void setSubtotalMaterial(double subtotalMaterial) {
        this.subtotalMaterial = subtotalMaterial;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPrenda() {
        return prenda;
    }

    public void setPrenda(String prenda) {
        this.prenda = prenda;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }
    
}
