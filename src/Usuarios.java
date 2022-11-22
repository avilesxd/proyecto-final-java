public class Usuarios {
    ModelUsuario MU = new ModelUsuario();
    private String usuario,usuarioInterfaz, password, passwordInterfaz;

    public Usuarios(){

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

    public boolean Validacion() throws Exception {
        try {
            String[] SUP2 = MU.Solicitar(getUsuario());
            if (getUsuario().equals(SUP2[0]) && getPassword().equals(SUP2[1])) {
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public boolean ValidacionusuarioExistente()throws Exception {
       try {
           String[] SUP3 = MU.Solicitar(getUsuario());
           if (getUsuario().equals(SUP3[0])){
               setUsuario(null);
               return true;
           }else {
               return false;
           }
       }catch (Exception e){
           throw new Exception(e);
       }
    }

    public void EnviarRegistro() throws Exception {
        MU.Insertar(getUsuario(),getPassword());
    }
}
