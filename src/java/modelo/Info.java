/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author AlekeyJr
 */
abstract class Info {
    
    private String producto, descripcion;
    private int id,ex;
    private double costo,venta;
    public Info(){}
    
    public Info(int id, double costo, double venta, int ex, String producto, String descripcion) {
        this.id = id;
        this.costo = costo;
        this.venta = venta;
        this.ex = ex;
        this.producto = producto;
        this.descripcion = descripcion;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

 
    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getVenta() {
        return venta;
    }

    public void setVenta(double venta) {
        this.venta = venta;
    }

    public int getEx() {
        return ex;
    }

    public void setEx(int ex) {
        this.ex = ex;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    

    public int modificar(){return 0;
}
   public int eliminar(){return 0;
} 
    public int agregar(){return 0;
}

    
    
}
