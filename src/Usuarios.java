public class Usuarios {
    ModelUsuario MU = new ModelUsuario();
    private String usuario,usuarioInterfaz, password, passwordInterfaz;

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

    public String getUsuarioInterfaz() {
        return usuarioInterfaz;
    }

    public void setUsuarioInterfaz(String usuarioInterfaz) {
        this.usuarioInterfaz = usuarioInterfaz;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordInterfaz() {
        return passwordInterfaz;
    }

    public void setPasswordInterfaz(String passwordInterfaz) {
        this.passwordInterfaz = passwordInterfaz;
    }

    public boolean Validacion(){
        if (getUsuarioInterfaz().equals(getUsuario()) && getPasswordInterfaz().equals(getPassword())){
            return true;
        }else {
            return false;
        }
    }

    public boolean ValidacionUsuarioExistente(){
        if (getUsuarioInterfaz().equals(getUsuario())){
            return true;
        }else {
            return false;
        }
    }
}
