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
public class Boton extends Material{
    
    private int idBoton;
    private String color;
    private String tamanio;

    public int getIdBoton() {
        return idBoton;
    }

    public void setIdBoton(int idBoton) {
        this.idBoton = idBoton;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }
    
}
