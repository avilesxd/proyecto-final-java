import java.sql.*;

public class Prueba {
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String db = "jdbc:mysql://localhost:3306/usuarios";
    static String nombre = "root";
    static String clave  = "";

    public static Connection Conexion(){
        Connection Conexion = null;
        try {
            Class.forName(driver);
            Conexion = DriverManager.getConnection(db,nombre,clave);
        }catch (Exception e){
            System.out.println("Error de DB");
        }
        return Conexion;
    }

    public static void main(String[] args) {
        String SQL = "SELECT nombre FROM usuario WHERE id=1";
        Prueba P = new Prueba();
        P.Conexion();

        if (P != null){
            System.out.println("Exito");
        }
        Statement st = null;
        ResultSet rs = null;

        if (P != null){
            try {
                st = P.Conexion().createStatement();
                rs = st.executeQuery(SQL);
                if (rs.next()){
                    System.out.println(rs.getString("nombre"));
                }
            }catch (Exception e){

            }
        }
    }
}