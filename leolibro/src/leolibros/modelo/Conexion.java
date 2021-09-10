package leolibros.modelo;
import java.sql.Connection; //Importacion de libreria MySQL
import java.sql.DriverManager;  //Importacion de libreria MySQL
public class Conexion {
    String url="jdbc:mysql://localhost:3306/tereto5";   //Seleccion base de datos
    String user="root",pass="852456";   //Usuario y password  Mysql
    Connection con;
    public Connection getConnection(){
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");  //Driver conexion base de datos
            con=DriverManager.getConnection(url,user,pass); //Cnexion a la base de datos
        } catch (Exception e) {    //Captura de posible errores de conexion        
        }
        return con; //Retorno variable con
    }
}
