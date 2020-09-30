/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AlekeyJr
 */
public class Marcas {
    private int id_marca;
    private String marcas;
    Conexion cn;
    
    public Marcas(){};
    public Marcas(int id_marca, String marcas) {
        this.id_marca = id_marca;
        this.marcas = marcas;
    }


        
    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getMarcas() {
        return marcas;
    }

    public void setMarcas(String marcas) {
        this.marcas = marcas;
    }
    
    public HashMap drop_marcas(){
        HashMap<String,String> drop= new HashMap();
        
        try{
            cn = new Conexion();
            String query = " SELECT idMarca as id,marca FROM marcas; ";
            cn.abrir_conexion();
            
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            while (consulta.next()){
                drop.put(consulta.getString("id"), consulta.getString("Marca"));
            }
            cn.cerrar_conexion();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return drop;
    }
 /*   
    public int agregar(){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "insert into marcas(marca) values(?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1,getMarcas());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
       
    return retorno;
    }
    
    
    public DefaultTableModel leer(){
    
        DefaultTableModel tabla = new DefaultTableModel();
        try{
            cn = new Conexion();
            cn.abrir_conexion();
            
            String query = "SELECT e.idProducto as id,e.producto,e.idMarca,e.descripcion,e.precio_costo,\n" +
                            "e.precio_venta,e.existencia,p.marca, p.idMarca FROM productos as e inner join marcas as p\n" +
                            "on e.idMarca = p.idMarca;";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[] = {"idProducto","producto","idMarca","descripcion","precio_costo","precio_venta","existencia"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[6];
      while (consulta.next()){
          datos[0] = consulta.getString("idProducto");
          datos[1] = consulta.getString("producto");
          datos[2] = consulta.getString("idMarca");
          datos[3] = consulta.getString("descripcion");
          datos[4] = consulta.getString("precio_costo");
          datos[5] = consulta.getString("precio_venta");
          datos[6] = consulta.getString("existencia");
          tabla.addRow(datos);
      
      }
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return tabla;
    
    }
    
    @Override
    public int modificar(){
        
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "update productos set producto=?, idMarca=?,descripcion=?,precio_costo=?,precio_venta=?,existencia=? where idProducto=? ;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1,getProducto());
            parametro.setInt(2,getIdmarca());
            parametro.setString(3,getDescripcion());
            parametro.setInt(4,getCosto());
            parametro.setInt(5,getVenta());
            parametro.setInt(6, getEx());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
       
    return retorno;
        
    }
    @Override
    public int eliminar(){
    int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "delete from productos where idProducto =? ;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
           
            parametro.setInt(1, getId());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
       
    return retorno;
    }*/
    
}
