import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Registrar extends JFrame implements ActionListener {
    int ANCHO=300, LARGO=400;
    JFrame Ventana2;
    JButton Bregistrar2, BirAtras;
    JLabel Tusuario, Tpassword, Tpassword2;
    JTextField  Txusuario;
    JPasswordField Txpassword, Txpassword2;
    String passwordddd, passwordddd2;
    public Registrar() {
        // ventana
        Ventana2 = new JFrame();
        Ventana2.setTitle("Crear cuenta");
        Ventana2.setSize(ANCHO, LARGO);
        Ventana2.setLayout(null);
        Ventana2.setLocationRelativeTo(null);
        //Ventana2.setResizable(false);
        Ventana2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Ventana2.setVisible(true);
        Paneles();
    }

    public void Coneccion(){
        Main M = new Main();
        Connection DB = null;
        DB = M.Conexion();
        PreparedStatement DB2 = null;
        while (DB != null){
            try {
                String SQL = "INSERT INTO usuario (nombre,password) VALUES ('"+Txusuario.getText()+"','"+ passwordddd2+"')";
                DB2 = DB.prepareStatement(SQL);
                DB2.executeUpdate();
                break;
            }catch (Exception e){

            }
        }
    }
    public void Paneles(){
        TXRegistro();
        BtnRegistro();
    }
    public void TXRegistro(){
        // Texto "usuario" y area para ingresarlo
        Tusuario = new JLabel("Usuario");
        Tusuario.setBounds(125,30,100,20);
        Txusuario = new JTextField();
        Txusuario.setBounds(100,50,100,20);
        Ventana2.add(Tusuario);
        Ventana2.add(Txusuario);


        // Texto "contraseña" y area para ingresarla
        Tpassword = new JLabel("Contraseña");
        Tpassword.setBounds(115,100,100,20);
        Txpassword = new JPasswordField();
        Txpassword.setBounds(100,120,100,20);
        Ventana2.add(Tpassword);
        Ventana2.add(Txpassword);


        // Confirmar contraseña
        Tpassword2 = new JLabel("Repetir contraseña");
        Tpassword2.setBounds(95,160,120,20);
        Txpassword2 = new JPasswordField();
        Txpassword2.setBounds(100,180,100,20);
        Ventana2.add(Tpassword2);
        Ventana2.add(Txpassword2);
    }
    public void BtnRegistro(){
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

    @Override
    public void actionPerformed(ActionEvent e) {
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
                Coneccion();
                Ventana2.setVisible(false);
                new Login();
            }
        }
        if (e.getSource() == BirAtras){
            Ventana2.setVisible(false);
            new Login();
        }
    }
    }
