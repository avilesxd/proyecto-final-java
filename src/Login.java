import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    // Variables
    int ANCHO=300, LARGO=400;
    JFrame Ventana;
    JButton Blogin, Bregistrar;
    JLabel Tusuario, Tpassword;
    JTextField  Txusuario;
    JPasswordField Txpassword;
    String passwordChar2;
    public Login(){
        // ventana
        Ventana = new JFrame();
        Ventana.setTitle("Iniciar Seccion");
        Ventana.setSize(ANCHO,LARGO);
        Ventana.setLayout(null);
        Ventana.setLocationRelativeTo(null);
        Ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Ventana.setResizable(false);
        Ventana.setVisible(true);



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
                JOptionPane.showMessageDialog(null, "              Bienvenido");
                new Dashboard();
            }
            else {
                JOptionPane.showMessageDialog(null,"Usuario y/o clave incorrecta");
            }
        }
        if (e.getSource() == Bregistrar){
            Ventana.setVisible(false);
            new Registrar();
        }
    }
}
