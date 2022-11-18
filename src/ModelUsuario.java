import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModelUsuario {
    public void Insertar(Usuarios usuarios) throws Exception{
        Connection c=null;
        PreparedStatement ps = null;
        String sql = null;

        try {
            c = Main.Conexion();
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

    public static void main(String[] args) {
        Usuarios u = new Usuarios();
        ModelUsuario mu  = new ModelUsuario();
        u.setUsuario("ignacio");
        u.setPassword("1234");
        try {
            mu.Insertar(u);
        }catch (Exception e){

        }
    }
}