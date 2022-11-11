import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    static String driver = "com.mysql.cj.jdbc.Driver";
    static  String db = "jdbc:mysql://localhost:3306/usuarios";
    static String nombre = "root";
    static String clave = "";

    public static Connection Conexion(){
        Connection Conexion = null;
        try {
            Class.forName(driver);
            Conexion = DriverManager.getConnection(db,nombre,clave);
        }catch (Exception e){
            System.out.println("Error con la base de datos");
        }
        return Conexion;
    }

    public static void main(String[] args) {
        String SQL = "SELECT nombre FROM usuario WHERE id=1";
        Database DB = new Database();
        DB.Conexion();

        if (DB != null){
            System.out.println("Exito");
        }

        Statement st = null;
        ResultSet rs = null;

        if (DB != null){
            try {
                st = DB.Conexion().createStatement();
                rs = st.executeQuery(SQL);
                if (rs.next()){
                    System.out.println(rs.getString("nombre"));
                }
            } catch (Exception e){

            }
        }
    }
}
