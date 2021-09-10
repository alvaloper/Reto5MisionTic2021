/**
 *
 * @DAO EdicionDAO
 *  Se crean y establecen los métodos necesarios para Agregar, Actualizar, Eliminar y 
 *  Consultar de la tabla Edicion
 * 
 */
package leolibros.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Author Espinoza Alvarado Luis Jose ing.espinozalj at gmail.com
 *
 */
public class EdicionDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Edicion p = new Edicion();

    /**
    * 
    * @Method listar()
    * Permite listar los datos almacenados en la tabla edicion, 
    * y cargarlos en la tabla de la vista.
    * @return datos
    * 
    */
    public List listar() {
        List<Edicion> datos = new ArrayList<>();
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement("select * from edicion");
            rs = ps.executeQuery();
            while (rs.next()) {
                Edicion p = new Edicion();
                p.setId(rs.getInt(1));
                p.setAnnio(rs.getString(2));
                p.setIdioma(rs.getString(3));
                p.setCopias(rs.getString(4));
                datos.add(p);
            }
        } catch (Exception e) {
        }
        return datos;
    }
    
    /**
    * 
    * @Method agregar()
    * Permite Agregar los datos ingresados por el usuario a la tabla edicion 
    * @param per
    * @return r
    * 
    */
    public int agregar(Edicion per) {  
        int r=0;
        String sql="insert into edicion(isbn,annio,idioma,copias)values(?,?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,per.getId());            
            ps.setString(2,per.getAnnio());
            ps.setString(3,per.getIdioma());
            ps.setString(4,per.getCopias());
            r=ps.executeUpdate();    
            if(r==1){
                return 1;
            }
            else{
                return 0;
            }
        } catch (Exception e) {
        }  
        return r;
    }
    
    /**
    * 
    * @Method Actualizar()
    * Permite Modificar los datos ingresados por el usuario en la tabla edicion
    * @param per
    * @return r
    * 
    */
    public int Actualizar(Edicion per) {  
        int r=0;
        String sql="update edicion set annio=?, idioma=?, copias=? where isbn=?";        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1,per.getAnnio());
            ps.setString(2,per.getIdioma());
            ps.setString(3,per.getCopias());
            ps.setInt(4,per.getId());
            r=ps.executeUpdate();    
            if(r==1){
                return 1;
            }
            else{
                return 0;
            }
        } catch (Exception e) {
        }  
        return r;
    }
    
    /**
    * 
    * @Method Delete()
    * Permite Eliminar los datos ingresados por el usuario a la tabla edicion
    * segun el id (isbn)de la edicion 
    * @param id
    * @return r
    * 
    */
    public int Delete(int id){
        int r=0;
        String sql="delete from edicion where ISBN="+id;
        try {
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            r= ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}
