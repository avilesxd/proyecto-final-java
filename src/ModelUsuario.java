import java.sql.*;

public class ModelUsuario {
    public String[] RutExistente(String run){
        Connection DB = ConexionDB.Conexion();
        Statement st = null;
        ResultSet rs = null;
        if (DB != null){
            try {
                String SQL = "SELECT run FROM clientes WHERE usuario ='" + run + "'";
                st = DB.createStatement();
                rs = st.executeQuery(SQL);
                if (rs.next()) {
                    String rut = rs.getString("run");
                    String[] SUP5 = new String[]{rut};
                    return SUP5;
                }
            } catch (Exception e) {

            }
        }
        return new String[]{""};
    }

    public String[] Solicitar(String usuarios) throws Exception {
        Connection DB = ConexionDB.Conexion();
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

    public void Insertar(String usuario,String password) throws Exception{
        Connection c=null;
        PreparedStatement ps = null;
        String sql = null;

        try {
            c = ConexionDB.Conexion();
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

    public void RegistroProductos(String nombre, String precio, String stock){
        Connection c=null;
        PreparedStatement ps = null;
        String sql = null;

        try {
            c = ConexionDB.Conexion();
            c.setAutoCommit(false);
            sql = "INSERT INTO productos_base (nombre,precio,stock) VALUES ('"+nombre+"',"+precio+",'"+stock+"')";
            ps = c.prepareStatement(sql);
            ps.executeUpdate();
            c.commit();
            c.close();
        }catch (Exception e){

        }
    }

    public void RegistroClientes(String nombre, String telefono, String direccion, String run) {
        Connection c=null;
        PreparedStatement ps = null;
        String sql = null;

        try {
            c = ConexionDB.Conexion();
            c.setAutoCommit(false);
            sql = "INSERT INTO clientes (nombre, telefono, direccion, run) VALUES ('"+nombre+"',"+telefono+",'"+direccion+"','"+run+"')";
            ps = c.prepareStatement(sql);
            ps.executeUpdate();
            c.commit();
            c.close();
        }catch (Exception e){

        }
    }

    public Object[] MostarProductos(int zzz){
        Connection DB = ConexionDB.Conexion();
        Statement st = null;
        ResultSet rs = null;
        if (DB != null) {
            try {
                String SQL = "SELECT id,nombre,precio,stock from productos_base WHERE id=" + zzz + "";
                st = DB.createStatement();
                rs = st.executeQuery(SQL);
                if (rs.next()) {
                    String id = rs.getString("id");
                    String nombre = rs.getString("nombre");
                    String precio = rs.getString("precio");
                    int stock = rs.getInt("stock");
                    Object[] ProductosBase = {id, nombre, precio, stock};
                    return ProductosBase;
                }
            } catch (Exception e) {

            }
        }
        return new Object[]{""};
    }

    public Object[] MostrarClientes(int ttt){
        Connection DB = ConexionDB.Conexion();
        Statement st = null;
        ResultSet rs = null;
        if (DB != null) {
            try {
                String SQL = "SELECT id,nombre,telefono,direccion,run from clientes WHERE id=" + ttt + "";
                st = DB.createStatement();
                rs = st.executeQuery(SQL);
                if (rs.next()) {
                    String id = rs.getString("id");
                    String nombre = rs.getString("nombre");
                    int telefono = rs.getInt("telefono");
                    String direccion = rs.getString("direccion");
                    String run = rs.getString("run");
                    Object[] allClientes = {id,nombre,telefono,direccion,run};
                    return allClientes;
                }
            } catch (Exception e) {

            }
        }
        return new Object[]{""};
    }

    public int CantidadDeProductos() {
        Connection DB = ConexionDB.Conexion();
        Statement st = null;
        ResultSet rs = null;
        if (DB != null) {
            try {
                String SQL = "SELECT count(nombre) from productos_base";
                st = DB.createStatement();
                rs = st.executeQuery(SQL);
                if (rs.next()) {
                    String numeroTotal = rs.getString("Count(nombre)");
                    int x = Integer.parseInt(numeroTotal);
                    return x;
                }
            } catch (Exception e) {

            }
        }
        return 0;
    }

    public Object[] BuscarCliente(String ttt) {
        Connection DB = ConexionDB.Conexion();
        Statement st = null;
        ResultSet rs = null;
        if (DB != null) {
            try {
                String SQL = "SELECT * FROM clientes WHERE nombre='" + ttt + "'";
                st = DB.createStatement();
                rs = st.executeQuery(SQL);
                if (rs.next()) {
                    String id = rs.getString("id");
                    String nombre = rs.getString("nombre");
                    int telefono = rs.getInt("telefono");
                    String direccion = rs.getString("direccion");
                    String run = rs.getString("run");
                    Object[] allDataCliente = {id,nombre,telefono,direccion,run};
                    return allDataCliente;
                }
            } catch (Exception e) {

            }
        }
        return new Object[]{""};
    }

    public Object[] BuscarProducto(String ppp){
        Connection DB = ConexionDB.Conexion();
        Statement st = null;
        ResultSet rs = null;
        if (DB != null) {
            try {
                String SQL = "SELECT * FROM productos_base WHERE nombre='" + ppp + "'";
                st = DB.createStatement();
                rs = st.executeQuery(SQL);
                if (rs.next()) {
                    String id = rs.getString("id");
                    String nombre = rs.getString("nombre");
                    int precio = rs.getInt("precio");
                    Object[] allDataProducto = {id,nombre,precio};
                    return allDataProducto;
                }
            } catch (Exception e) {

            }
        }
        return new Object[]{""};
    }
}