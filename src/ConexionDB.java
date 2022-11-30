import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String db = "jdbc:mysql://localhost:3306/ordenes";
    static String nombre = "root";
    static String clave = "";

    public static Connection Conexion(){
        Connection Conexion = null;
        try {
            Class.forName(driver);
            Conexion = DriverManager.getConnection(db, nombre, clave);
        } catch (Exception e) {
            System.out.println("Error con la base de datos");
        }finally {
            if (Conexion == null){
                try {
                    Conexion().close();
                }catch (SQLException e){

                }
            }
        }
        return Conexion;
    }
}
