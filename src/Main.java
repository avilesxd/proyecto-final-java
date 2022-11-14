import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    static String driver = "com.mysql.cj.jdbc.Driver";
    static  String db = "jdbc:mysql://localhost:3306/usuarios";
    static String nombre = "root";
    static String clave = "";
    static String usuario;
    static String password;

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
        Login L = new Login();
        Main M = new Main();
        Connection DB = M.Conexion();

        if (DB != null){
            System.out.println("Exito");
        }

        Statement st = null;
        ResultSet rs = null;

        while (DB != null){
            try {
                String SQL = "SELECT nombre,password FROM usuario WHERE nombre ='" + L.Txusuario.getText() + "'";
                st = DB.createStatement();
                rs = st.executeQuery(SQL);
                if (rs.next()){
                    usuario = rs.getString("nombre");
                    password = rs.getString("password");
                    continue;
                }
            } catch (Exception e){
                System.out.println("Error");
            }
        }
    }
}