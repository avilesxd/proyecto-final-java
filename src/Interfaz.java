import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame implements ActionListener{
    // Variables
    JFrame Ventana, Ventana2, Ventana3;
    JButton Blogin, Bregistrar, Bregistrar2, BirAtras, BirAtras2;
    JLabel Tusuario, Tusuario2, Tpassword, Tpassword2, Tpassword3, nombre,direccion,telefono,run;
    JTextField  Txusuario, Txusuario3, nombre2,direccion2,telefono2,run2;
    JPasswordField Txpassword, Txpassword2, Txpassword3;
    String passwordChar2, passwordddd, passwordddd2;

    public Interfaz(){

    }

    public void Ventana(){
        // Ventana Login
        Ventana = new JFrame();
        Ventana.setTitle("Iniciar Seccion");
        Ventana.setSize(300,400);
        Ventana.setLayout(null);
        Ventana.setLocationRelativeTo(null);
        Ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Ventana.setResizable(false);
        Ventana.setVisible(true);
    }

    public void Ventana2(){
        Ventana2 = new JFrame();
        Ventana2.setTitle("Crear cuenta");
        Ventana2.setSize(300,400);
        Ventana2.setLayout(null);
        Ventana2.setLocationRelativeTo(null);
        //Ventana2.setResizable(false);
        Ventana2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Ventana2.setVisible(true);
    }

    public void Ventana3(){
        // ventana
        Ventana3 = new JFrame();
        Ventana3.setTitle("DashBoard");
        Ventana3.setSize(1280,720);
        Ventana3.setLayout(null);
        Ventana3.setLocationRelativeTo(null);
        //Ventana3.setResizable(false);
        Ventana3.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Ventana3.setVisible(true);
    }

    public void Login(){
        // Texto "usuario" y area para ingresarlo
        Tusuario = new JLabel("Usuario");
        Tusuario.setBounds(125,30,100,20);
        Txusuario = new JTextField();
        Txusuario.setBounds(100,50,100,20);
        Ventana.add(Tusuario);
        Ventana.add(Txusuario);
        // Texto "contraseña" y area para ingresarla
        Tpassword = new JLabel("Contraseña");
        Tpassword.setBounds(115,100,100,20);
        Txpassword = new JPasswordField();
        Txpassword.setBounds(100,120,100,20);
        Ventana.add(Tpassword);
        Ventana.add(Txpassword);
        // Botones
        // Boton Login
        Blogin = new JButton("Login");
        Blogin.setBounds(100,200,100,40);
        Blogin.addActionListener(this);
        // Boton Registrar
        Bregistrar = new JButton("Registrar");
        Bregistrar.setBounds(100,270,100,40);
        Bregistrar.addActionListener(this);
        Ventana.add(Blogin);
        Ventana.add(Bregistrar);
    }

    public void Registrar(){
        // Texto "usuario" y area para ingresarlo
        Tusuario2 = new JLabel("Usuario");
        Tusuario2.setBounds(125,30,100,20);
        Txusuario3 = new JTextField();
        Txusuario3.setBounds(100,50,100,20);
        Ventana2.add(Tusuario2);
        Ventana2.add(Txusuario3);
        // Texto "contraseña" y area para ingresarla
        Tpassword3 = new JLabel("Contraseña");
        Tpassword3.setBounds(115,100,100,20);
        Txpassword3 = new JPasswordField();
        Txpassword3.setBounds(100,120,100,20);
        Ventana2.add(Tpassword3);
        Ventana2.add(Txpassword3);
        // Confirmar contraseña
        Tpassword2 = new JLabel("Repetir contraseña");
        Tpassword2.setBounds(95,160,120,20);
        Txpassword2 = new JPasswordField();
        Txpassword2.setBounds(100,180,100,20);
        Ventana2.add(Tpassword2);
        Ventana2.add(Txpassword2);
        // Boton Registrar
        Bregistrar2 = new JButton("Registrar");
        Bregistrar2.setBounds(100,270,100,40);
        Bregistrar2.addActionListener(this);
        Ventana2.add(Bregistrar2);
        // Boton ir atras
        BirAtras = new JButton("Ir Atras");
        BirAtras.setBounds(100,320,100,40);
        BirAtras.addActionListener(this);
        Ventana2.add(BirAtras);
    }

    public void Dashboard(){
        // Ingresar los datos para los usuarios
        // Nombre
        nombre = new JLabel("Nombre");
        nombre.setBounds(10,10,100,30);
        Ventana3.add(nombre);
        nombre2 = new JTextField();
        nombre2.setBounds(100,10,150,30);
        Ventana3.add(nombre2);
        // Direccion
        direccion = new JLabel("Direccion");
        direccion.setBounds(10,50,100,30);
        Ventana3.add(direccion);
        direccion2 = new JTextField();
        direccion2.setBounds(100,50,150,30);
        Ventana3.add(direccion2);
        // Telefono
        telefono = new JLabel("Telefono");
        telefono.setBounds(10,90,150,30);
        Ventana3.add(telefono);
        telefono2 = new JTextField();
        telefono2.setBounds(100,90,150,30);
        Ventana3.add(telefono2);
        // Run
        run = new JLabel("Run");
        run.setBounds(10,130,150,30);
        Ventana3.add(run);
        run2 = new JTextField();
        run2.setBounds(100,130,150,30);
        Ventana3.add(run2);
        // Boton para cerrar la sesion
        BirAtras2 = new JButton("Cerrar sesion");
        BirAtras2.setBounds(1100,600,120,40);
        BirAtras2.addActionListener(this);
        Ventana3.add(BirAtras2);
    }

    public int ValidacionUsuario(){
        char [] passwordChar = Txpassword.getPassword();
        passwordChar2 = new String(passwordChar);
        if (Main.usuario.equals(Txusuario.getText()) && Main.password.equals(passwordChar2)){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Blogin){
            Ventana.setVisible(false);
            if (ValidacionUsuario() == 1){
                JOptionPane.showMessageDialog(null, "Bienvenido" + " " + Main.usuario);
                Dashboard();
            }
            else if(ValidacionUsuario() == 0){
                JOptionPane.showMessageDialog(null,"Usuario y/o clave incorrecta");
                Login();
            }
        }
        if (e.getSource() == Bregistrar){
            Ventana.setVisible(false);
            Registrar();
        }
        if (e.getSource() == Bregistrar2) {
            char [] passwordChar = Txpassword.getPassword();
            passwordddd = new String(passwordChar);

            char[] passworddddChar = Txpassword2.getPassword();
            passwordddd2 = new String(passworddddChar);
            if (Main.usuario.equals(Txusuario.getText())){
                JOptionPane.showMessageDialog(null, "El usuario ya existe, Intente nuevamente!");
            } else if (!passwordddd.equals(passwordddd2)){
                JOptionPane.showMessageDialog(null, "Verifique su contraseñas!");
            } else  {
                JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
                Ventana2.setVisible(false);
                Login();
            }
        }
        if (e.getSource() == BirAtras){
            Ventana2.setVisible(false);
            Login();
        }
        if (e.getSource() == BirAtras2){
            Ventana3.setVisible(false);
            Login();
        }
    }
}