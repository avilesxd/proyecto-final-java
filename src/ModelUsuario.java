import java.sql.*;

public class ModelUsuario {
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String db = "jdbc:mysql://localhost:3306/usuarios";
    static String nombre = "root";
    static String clave = "";
    static String usuario, password;
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

    public void Insertar(Usuarios usuarios) throws Exception{
        Connection c=null;
        PreparedStatement ps = null;
        String sql = null;

        try {
            c = Conexion();
            c.setAutoCommit(false);
            sql = "INSERT INTO usuario (nombre,password) VALUES (?,?)";
            ps = c.prepareStatement(sql);
            ps.setString(1,usuarios.getUsuario());
            ps.setString(2,usuarios.getPassword());
            ps.executeUpdate();
            c.commit();
            c.close();
        }catch (Exception e){
            try {
                c.rollback();
            }catch (SQLException ex){
                throw e;
            }
        }
    }

    public void Solicitar(Usuarios usuarios) throws Exception{
        Statement st = null;
        ResultSet rs = null;
        try {
            String SQL = "SELECT nombre,password FROM usuario WHERE nombre ='" + usuarios.getUsuario() + "'";
            st = DB.createStatement();
            rs = st.executeQuery(SQL);
            if (rs.next()) {
               usuario = rs.getString("nombre");
               password = rs.getString("password");
            }
        } catch (Exception e) {

        }
    }
}