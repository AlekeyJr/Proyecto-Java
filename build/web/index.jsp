<%-- 
    Document   : productos
    Created on : 19/09/2020, 03:21:47 PM
    Author     : AlekeyJr
--%>

<%@page import="modelo.Marcas" %>
<%@page import="modelo.Productos" %> 
<%@page import="java.util.HashMap"%>
<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
     </head>
    <body>
        <h1 align="center">Formulario Productos</h1>
        <div align="center">
        <button type="button" name="btn_nuevo" id="btn_nuevo" class="btn btn-info btn-lg" data-toggle="modal" data-target="#modal_productos" onclick="limpiar()">Nuevo</button>
        </div>
        <br>
        <div class="container"> 
           <div class="modal fade" id="modal_productos" role="dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-body">
            <form action="sr_nuevoproducto" method="post" class="formg-roup">
                <label for="lbl_id">ID:</label>
                <input type="text" name="txt_id" id="txt_id" class="form-control" value="0" readonly>
                <br>
                <label for="lbl_producto">Producto:</label>
                <input type="text" name="txt_producto" id="txt_producto" class="form-control" placeholder="Nombre Producto" required>
                <br>
                <label for="lbl_marcas">Marcas :</label>
                <select name="drop_marcas" id="drop_list" class="form-control"> 
                      <% 
                        Marcas marcas = new Marcas();
                        HashMap<String,String> drop = marcas.drop_marcas();
                        for(String i: drop.keySet()){
                            out.println("<option value='"+ i +"'>"+ drop.get(i) +" </option>");
                        }
                     
                     %>  

                </select>
                <br>     
                <label for="lbl_desc">Descripcion:</label>
                <input type="text" name="txt_desc" id="txt_desc" class="form-control" placeholder="Descripcion..." required>
                <br>
                <label for="lbl_costo">Precio Costo:</label>
                <input type="number" step="0.01" name="txt_costo" id="txt_costo" class="form-control" placeholder="Q100" required>
                <br>
                <label for="lbl_venta">Precio Venta:</label>
                <input type="number" step="0.01" name="txt_venta" id="txt_venta" class="form-control" placeholder="Q250" required>
                <br>
                <label for="lbl_ex">Existencia:</label>
                <input type="number" name="txt_ex" id="txt_ex" class="form-control" placeholder="100" required>
                <br>

            <button name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary" >Agregar</button>  
            <button name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-primary" >Modificar</button>           
            <button name="btn_eliminar"  id="btn_eliminar" value="eliminar" class="btn btn-primary" onclick="javascript:if(!confirm('¿Desea Eliminar?'))return false">Eliminar</button> 
            <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
            </br>
            <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
       
            </form> 
            </br>
            </div>
            </div>
                     </div>
                        
                            
                     
                     <br>
            <table class="table table-striped">
    <thead>
      <tr>
        
        <th>Producto</th>
        <th>Marca</th>
        <th>Descripcion</th>
        <th>Precio Costo</th>
        <th>Precio Venta</th>
        <th>Existencia</th>      
      </tr>
    </thead>
    <tbody id="tbl_productos">
        <% 
        Productos productos = new Productos();
        DefaultTableModel tabla = new DefaultTableModel();
        tabla = productos.leer();
        for (int t=0;t<tabla.getRowCount();t++){
            out.println("<tr data-id=" + tabla.getValueAt(t,0) +  " data-id_m=" + tabla.getValueAt(t,7) + ">");
            out.println("<td>" + tabla.getValueAt(t,1) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,2) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,3) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,4) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,5) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,6) + "</td>");
            out.println("</tr>");
        
        }
        %>
      
    </tbody>
  </table>



                     
        </div>
        
        <script type="text/javascript">
            $('#tbl_productos').on('click','tr td', function(evt){
   var target,id,id_m,producto,desc,costo,venta,ex;
   
   target = $(event.target);
   id = target.parent().data('id');
   id_m = target.parent().data('id_m');
   producto= target.parent("tr").find("td").eq(0).html();
   desc= target.parents("tr").find("td").eq(2).html();
   costo= target.parent("tr").find("td").eq(3).html();
   venta= target.parent("tr").find("td").eq(4).html();
   ex= target.parent("tr").find("td").eq(5).html();
   
   $("#txt_id").val(id);
   $("#txt_producto").val(producto);
   $("#drop_list").val(id_m);
   $("#txt_desc").val(desc);
   $("#txt_costo").val(costo);
   $("#txt_venta").val(venta);
   $("#txt_ex").val(ex);
   
   $("#modal_productos").modal('show');
});
</script>
    <script> function Index() {
                 window.location.href = 'index.jsp';} </script>

    </body>
    </script>
<script> function Index() {
                 window.location.href = 'index.jsp';} </script>
            </body>
            
     <script>function limpiar(){
        $("#txt_id").val(0);
       $("#txt_producto").val('');
       $("#txt_desc").val('');
       $("#txt_costo").val('');
       $("#txt_venta").val('');
       $("#txt_direccion").val('');
    }</script>  
</html>
