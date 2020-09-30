/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AlekeyJr
 */
public class Productos extends Info{
    private int idmarca;
    private Conexion cn;

    public Productos(int idmarca, int id, double costo, double venta, int ex, String producto, String descripcion){
        super(id, costo, venta, ex, producto, descripcion);
        this.idmarca = idmarca;
    }

    public Productos(){}
    
    public int getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    public Conexion getCn() {
        return cn;
    }

    public void setCn(Conexion cn) {
        this.cn = cn;
    }
    
    @Override
    public int agregar(){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "insert into productos(producto,idMarca,descripcion,precio_costo,precio_venta,existencia) values(?,?,?,?,?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1,getProducto());
            parametro.setInt(2,getIdmarca());
            parametro.setString(3,getDescripcion());
            parametro.setDouble(4,getCosto());
            parametro.setDouble(5,getVenta());
            parametro.setInt(6, getEx());
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
            
            String query = "SELECT e.idProducto as id,e.producto,e.descripcion,e.precio_costo, e.precio_venta,e.existencia,p.marca, p.idMarca "
                    + "FROM productos as e inner join marcas as p on e.idMarca = p.idMarca;";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[] = {"idProducto","producto","marca","descripcion","precio_costo","precio_venta","existencia","idMarca"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[8];
      while (consulta.next()){
          datos[0] = consulta.getString("id");
          datos[1] = consulta.getString("producto");
          datos[2] = consulta.getString("marca");
          datos[3] = consulta.getString("descripcion");
          datos[4] = consulta.getString("precio_costo");
          datos[5] = consulta.getString("precio_venta");
          datos[6] = consulta.getString("existencia");
          datos[7] = consulta.getString("idMarca");
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
            parametro.setDouble(4,getCosto());
            parametro.setDouble(5,getVenta());
            parametro.setInt(6, getEx());
            parametro.setInt(7, getId());
            
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
            String query = "delete from productos where idProducto=? ;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
           parametro.setInt(1, getId());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
       
    return retorno;
    }
}
