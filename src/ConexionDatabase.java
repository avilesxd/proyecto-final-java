import java.sql.*;

public class ConexionDatabase {
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String db = "jdbc:mysql://localhost:3306/usuarios";
    static String nombre = "root";
    static String clave = "";
    static String usuario;
    static String password;
    static Connection DB = null;

    public static Connection Conexion(){
        Connection Conexion = null;
        try {
            Class.forName(driver);
            Conexion = DriverManager.getConnection(db, nombre, clave);
        } catch (Exception e) {
            System.out.println("Error con la base de datos");
        }finally {
            try {
                Conexion().close();
            }catch (SQLException e){

            }
        }
        return Conexion;
    }

    public static void main(String[] args) {
        DB = Conexion();

        /*if (DB != null){
            System.out.println("Exito");
        }
         */
        Statement st = null;
        ResultSet rs = null;

        while (DB != null) {
            try {
                String SQL = "SELECT nombre,password FROM usuario WHERE nombre ='" + I.Txusuario.getText() + "'";
                st = DB.createStatement();
                rs = st.executeQuery(SQL);
                if (rs.next()) {
                    usuario = rs.getString("nombre");
                    password = rs.getString("password");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Error en el main");
            }
        }
    }
}
