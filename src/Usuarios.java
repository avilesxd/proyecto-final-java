public class Usuarios {
    private String usuario, password;

    public Usuarios(){
        setUsuario("admin");
        setPassword("1234");
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
