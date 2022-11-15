import java.sql.*;

public class Main {
    static String driver = "com.mysql.cj.jdbc.Driver";
    static  String db = "jdbc:mysql://localhost:3306/usuarios";
    static String nombre = "root";
    static String clave = "";
    static String usuario;
    static String password;
    static Connection DB = null;

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
         Registrar R = new Registrar();
         Main M = new Main();
         DB = M.Conexion();

        /*if (DB != null){
            System.out.println("Exito");
        }
         */
        PreparedStatement DB2 = null;
        Statement st = null;
        ResultSet rs = null;

        while (DB != null){
            if (L.ID_Ventana == 0){
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
                    System.out.println("Error en el main");
                }
            }else if (L.ID_Ventana == 2){
                try {
                    String SQL = "INSERT INTO usuario (nombre,password) VALUES ('"+ R.Txusuario.getText()+"','"+ R.passwordChar4+"')";
                    DB2 = DB.prepareStatement(SQL);
                    DB2.executeUpdate();
                    break;
                }catch (Exception e){

                }
            }
        }
    }
}