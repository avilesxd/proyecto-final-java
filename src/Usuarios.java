import java.sql.SQLException;

public class Usuarios {
    ModelUsuario MU = new ModelUsuario();
    private String usuario,usuarioInterfaz, password, passwordInterfaz, nombre, telefono, direccion, run;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
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

    public boolean ValidacionusuarioExistente() throws Exception {
        try {
            String[] SUP3 = MU.Solicitar(getUsuario());
            if (getUsuario().equals(SUP3[0])){
                setUsuario(null);
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void EnviarRegistro() throws Exception {
        MU.Insertar(getUsuario(),getPassword());
    }

    public boolean ValidarRun(String rut) {
        String run = "";
        String auxrut = rut;
        String rut1 = rut.split("-")[0];
        int sum = 0;
        int mult = 0;
        int num_verificador = 0;
        char[] rut_div = rut1.toCharArray();
        int a8[] = {2, 3, 4, 5, 6, 7, 2, 3};

        try {
            for (int i = rut1.length() - 1; i >= 0; i--) {
                if (Character.isDigit(rut_div[i])) {
                    run += rut_div[i];
                }
            }
            char[] rutf = run.toCharArray();
            if (rutf.length == 7) {
                for (int i = 0; i < 7; i++) {
                    char a = rutf[i];
                    int b;
                    b = a - '0';
                    mult = b * a8[i];
                    sum += mult;
                }
                int c = sum / 11;
                int d = c * 11;
                int e = sum - d;
                num_verificador = 11 - e;

            }
            if (rutf.length == 8) {
                for (int i = 0; i < 8; i++) {
                    char a = rutf[i];
                    int b;
                    b = a - '0';
                    mult = b * a8[i];
                    sum += mult;
                }
                int c = sum / 11;
                int d = c * 11;
                int e = sum - d;
                num_verificador = 11 - e;

            }
        } catch (Exception e) {
        }

        String ultimo = auxrut.substring(auxrut.length() - 1);
        String auxR = String.valueOf(num_verificador);
        if (ultimo.equals("K") && num_verificador == 10) {
            return true;
        } else if (ultimo.equals("0") && num_verificador == 11) {
            return true;
        } else if (ultimo.equals(auxR)){
            return true;
        }else {
            return false;
        }
    }

    public int ValidarRegistroClientes(){
        if (getTelefono().length() == 8 && ValidarRun(getRun())){
            return 1;
        } else if (getTelefono().length() != 8) {
            return 2;
        }else {
            return 3;
        }
    }

    public void EnviarRegistroClientes() throws SQLException {
        MU.RegistroClientes(getNombre(), getTelefono(), getDireccion(), getRun());
    }
}
