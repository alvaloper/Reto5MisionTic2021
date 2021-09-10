/**
 *
 * @DAO AutorDAO
 *  Se crean y establecen los métodos necesarios para Agregar, Actualizar, Eliminar y 
 *  Consultar de la tabla autor
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
public class AutorDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Autor p = new Autor();

    /**
    * 
    * @Method listar()
    * Permite listar los datos almacenados en la tabla autor, 
    * y cargarlos en la tabla de la vista.
    * @return datos
    * 
    */
    public List listar() {
        List<Autor> datos = new ArrayList<>();
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement("select * from autor");
            rs = ps.executeQuery();
            while (rs.next()) {
                Autor p = new Autor();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                datos.add(p);
            }
        } catch (Exception e) {
        }
        return datos;
    }
    
    /**
    * 
    * @Method agregar()
    * Permite Agregar los datos ingresados por el usuario a la tabla autor
    * @param per
    * @return r
    * 
    */
    public int agregar(Autor per) {  
        int r=0;
        String sql="insert into autor(autor)values(?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1,per.getNom());
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
    * Permite Modificar los datos ingresados por el usuario en la tabla autor
    * @param per
    * @return r
    * 
    */
    public int Actualizar(Autor per) {  
        int r=0;
        String sql="update autor set autor=? where idAutor=?";        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1,per.getNom());
            ps.setInt(2,per.getId());
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
    * Permite Eliminar los datos ingresados por el usuario a la tabla autor
    * segun el Id del autor
    * @param id
    * @return r
    * 
    */
    public int Delete(int id){
        int r=0;
        String sql="delete from autor where idAutor="+id;
        try {
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            r= ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}
