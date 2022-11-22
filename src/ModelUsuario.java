import java.sql.*;

public class ModelUsuario {
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

    public void Insertar(String usuario,String password) throws Exception{
        Connection c=null;
        PreparedStatement ps = null;
        String sql = null;

        try {
            c = Conexion();
            c.setAutoCommit(false);
            sql = "INSERT INTO usuarios (usuario,password) VALUES (?,?)";
            ps = c.prepareStatement(sql);
            ps.setString(1,usuario);
            ps.setString(2,password);
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

    public String[] Solicitar(String usuarios) throws Exception {
        Connection DB = Conexion();
        Statement st = null;
        ResultSet rs = null;
        if (DB != null){
            try {
                String SQL = "SELECT usuario,password FROM usuarios WHERE usuario ='" + usuarios + "'";
                st = DB.createStatement();
                rs = st.executeQuery(SQL);
                if (rs.next()) {
                    String usuario = rs.getString("usuario");
                    String password = rs.getString("password");
                    String[] SUP = new String[]{usuario,password};
                    return SUP;
                }
            } catch (Exception e) {

            }
        }
        return new String[]{""};
    }
}