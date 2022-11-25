import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Interfaz extends JFrame implements ActionListener{
    // Variables
    JFrame Ventana, Ventana2, Ventana3, Ventana4, Ventana5, Ventana6, Ventana7;
    JButton Blogin, Bregistrar, Bregistrar2, BirAtras, cerrarSesion, RegistrarCliente, BotonCancelarRegistro, RegistrarProducto, BotonCancelarRegistroProducto;
    JLabel Tusuario, Tusuario2, Tpassword, Tpassword2, Tpassword3, nombre, direccion, telefono, run, run3, nombreProducto, precioProducto, numeroStock;
    JTextField  Txusuario, Txusuario3, nombre2, direccion2, telefono2, run2, run4, nombreProducto2, precioProducto2, numeroStock2;
    JPasswordField Txpassword, Txpassword2, Txpassword3;
    String passwordddd, passwordddd2, susuTexto;
    JMenuBar menuBar;
    JMenu menu1, menu2, menu3;
    JMenuItem menuItem21, menuItem22, menuItem31, menuItem32;
    Usuarios U = new Usuarios();
    public Interfaz(){
        Ventana();
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
        Login();
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
        Registrar();
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
        Dashboard();
    }

    public void Ventana4(){
        // ventana
        Ventana4 = new JFrame();
        Ventana4.setTitle("Registrar cliente");
        Ventana4.setSize(300,300);
        Ventana4.setLayout(null);
        Ventana4.setLocationRelativeTo(null);
        //Ventana4.setResizable(false);
        //Ventana4.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Ventana4.setVisible(true);
        RegistrarCliente();
    }

    public void Ventana5(){
        new MostrarClientes();
    }

    public void Ventana6(){
        // ventana
        Ventana6 = new JFrame();
        Ventana6.setTitle("Ingresar productos");
        Ventana6.setSize(300,300);
        Ventana6.setLayout(null);
        Ventana6.setLocationRelativeTo(null);
        //Ventana6.setResizable(false);
        //Ventana6.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Ventana6.setVisible(true);
        AgregarProductos();
    }

    public void Ventana7(){
        new MostrarProductos();
    }

    public void Login(){
        // Texto "usuario" y área para ingresarlo
        Tusuario = new JLabel("Usuario");
        Tusuario.setBounds(125,30,100,20);
        Txusuario = new JTextField();
        Txusuario.setBounds(100,60,100,20);
        Ventana.add(Tusuario);
        Ventana.add(Txusuario);
        // Texto "contraseña" y área para ingresarla
        Tpassword = new JLabel("Contraseña");
        Tpassword.setBounds(115,100,100,20);
        Txpassword = new JPasswordField();
        Txpassword.setBounds(100,130,100,20);
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
        // Texto "usuario" y área para ingresarlo
        Tusuario2 = new JLabel("Usuario");
        Tusuario2.setBounds(125,30,100,20);
        Txusuario3 = new JTextField();
        Txusuario3.setBounds(100,50,100,20);
        Ventana2.add(Tusuario2);
        Ventana2.add(Txusuario3);
        // Texto "contraseña" y área para ingresarla
        Tpassword3 = new JLabel("Contraseña");
        Tpassword3.setBounds(115,90,100,20);
        Txpassword3 = new JPasswordField();
        Txpassword3.setBounds(100,110,100,20);
        Ventana2.add(Tpassword3);
        Ventana2.add(Txpassword3);
        // Confirmar contraseña
        Tpassword2 = new JLabel("Repetir contraseña");
        Tpassword2.setBounds(95,150,120,20);
        Txpassword2 = new JPasswordField();
        Txpassword2.setBounds(100,170,100,20);
        Ventana2.add(Tpassword2);
        Ventana2.add(Txpassword2);
        // Boton Registrar
        Bregistrar2 = new JButton("Registrar");
        Bregistrar2.setBounds(100,230,100,40);
        Bregistrar2.addActionListener(this);
        Ventana2.add(Bregistrar2);
        // Boton ir atras
        BirAtras = new JButton("Ir Atras");
        BirAtras.setBounds(100,290,100,40);
        BirAtras.addActionListener(this);
        Ventana2.add(BirAtras);
    }

    public void Dashboard(){
        // Menu
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        // Primer menu
        menu1 = new JMenu("Opciones");
        menuBar.add(menu1);
        // Objetos de la clase menu que se asocian al primer Jmenu creado
        menu2 = new JMenu("Clientes");
        menu1.add(menu2);
        menu3 = new JMenu("Productos");
        menu1.add(menu3);
        // Objetos de la clase menu que se asocian al segundo Jmenu
        menuItem21 = new JMenuItem("Ingresar Clientes");
        menu2.add(menuItem21);
        menuItem21.addActionListener(this);
        menuItem22 = new JMenuItem("Mostrar Clientes");
        menu2.add(menuItem22);
        menuItem22.addActionListener(this);
        // Objetos de la clase menu que se asocian al tercer Jmenu
        menuItem31 = new JMenuItem("Agregar Productos");
        menu3.add(menuItem31);
        menuItem31.addActionListener(this);
        menuItem32 = new JMenuItem("Mostrar Productos");
        menu3.add(menuItem32);
        menuItem32.addActionListener(this);
        menuBar.setBounds(10,10,66,30);
        Ventana3.add(menuBar);
        // Boton para cerrar la sesion
        cerrarSesion = new JButton("Cerrar sesion");
        cerrarSesion.setBounds(1100,600,120,40);
        cerrarSesion.addActionListener(this);
        Ventana3.add(cerrarSesion);
    }

    public void RegistrarCliente(){
        // Ingresar los datos para los usuarios
        // Nombre
        nombre = new JLabel("Nombre");
        nombre.setBounds(10,10,100,30);
        Ventana4.add(nombre);
        nombre2 = new JTextField();
        nombre2.setBounds(100,10,150,30);
        Ventana4.add(nombre2);
        // Direccion
        direccion = new JLabel("Direccion");
        direccion.setBounds(10,50,100,30);
        Ventana4.add(direccion);
        direccion2 = new JTextField();
        direccion2.setBounds(100,50,150,30);
        Ventana4.add(direccion2);
        // Telefono
        telefono = new JLabel("Telefono");
        telefono.setBounds(10,90,150,30);
        Ventana4.add(telefono);
        telefono2 = new JTextField();
        telefono2.setBounds(100,90,150,30);
        Ventana4.add(telefono2);
        // Run
        run = new JLabel("Run");
        run.setBounds(10,130,150,30);
        Ventana4.add(run);
        run2 = new JTextField();
        run2.setBounds(100,130,150,30);
        Ventana4.add(run2);
        // Boton para registrar al cliente
        RegistrarCliente = new JButton("Registrar");
        RegistrarCliente.setBounds(15,170,120,40);
        RegistrarCliente.addActionListener(this);
        Ventana4.add(RegistrarCliente);
        // Boton para cancelar registro
        BotonCancelarRegistro = new JButton("Cancelar");
        BotonCancelarRegistro.setBounds(145,170,120,40);
        BotonCancelarRegistro.addActionListener(this);
        Ventana4.add(BotonCancelarRegistro);
    }

    public void AgregarProductos(){
        // Ingresar los datos para los productos
        // Nombre
        nombreProducto = new JLabel("Nombre");
        nombreProducto.setBounds(10,10,100,30);
        Ventana6.add(nombreProducto);
        nombreProducto2 = new JTextField();
        nombreProducto2.setBounds(100,10,150,30);
        Ventana6.add(nombreProducto2);
        // Precio
        precioProducto = new JLabel("Precio");
        precioProducto.setBounds(10,50,100,30);
        Ventana6.add(precioProducto);
        precioProducto2 = new JTextField();
        precioProducto2.setBounds(100,50,150,30);
        Ventana6.add(precioProducto2);
        // Stock
        numeroStock = new JLabel("Stock");
        numeroStock.setBounds(10,90,150,30);
        Ventana6.add(numeroStock);
        numeroStock2 = new JTextField();
        numeroStock2.setBounds(100,90,150,30);
        Ventana6.add(numeroStock2);
        // Boton para registrar el producto
        RegistrarProducto = new JButton("Registrar");
        RegistrarProducto.setBounds(15,170,120,40);
        RegistrarProducto.addActionListener(this);
        Ventana6.add(RegistrarProducto);
        // Boton para cancelar el registro del producto
        BotonCancelarRegistroProducto = new JButton("Cancelar");
        BotonCancelarRegistroProducto.setBounds(145,170,120,40);
        BotonCancelarRegistroProducto.addActionListener(this);
        Ventana6.add(BotonCancelarRegistroProducto);
    }

    public static class MostrarClientes{
        JFrame Ventana52;
        JTable tabla;
        DefaultTableModel dtm2;
        MostrarClientes(){
            Ventana52 = new JFrame();
            Ventana52.setTitle("Clientes Registrados");
            Object[][] datos = {};
            String[] NombreColumnas = {"Id","Nombre","Telefono","Direccion","Run"};
            dtm2 = new DefaultTableModel(datos,NombreColumnas);
            tabla = new JTable(dtm2);
            JScrollPane sp = new JScrollPane(tabla);
            tabla.setPreferredScrollableViewportSize(new Dimension(500,200));
            tabla.setEnabled(false);
            Ventana52.add(sp);
            Ventana52.setResizable(false);
            Ventana52.setSize(500, 200);
            Ventana52.setVisible(true);
        }
    }

    public static class MostrarProductos{
        JFrame Ventana72;
        JTable tabla2;
        DefaultTableModel dtm;
        MostrarProductos(){
            Ventana72 = new JFrame();
            Ventana72.setTitle("Productos Registrados");
            String[][] datos = {};
            String[] NombreColumnas = {"Id","Nombre","Precio"};
            dtm = new DefaultTableModel(datos,NombreColumnas);
            tabla2 = new JTable(dtm);
            JScrollPane sp = new JScrollPane(tabla2);
            tabla2.setPreferredScrollableViewportSize(new Dimension(500,200));
            tabla2.setEnabled(false);
            Ventana72.add(sp);
            Ventana72.setResizable(false);
            Ventana72.setSize(500, 200);
            Ventana72.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BirAtras){
            Ventana2.setVisible(false);
            Ventana();
        }
        if (e.getSource() == cerrarSesion){
            Ventana3.setVisible(false);
            Ventana4.setVisible(false);
            Ventana6.setVisible(false);
            Ventana();
        }
        if (e.getSource() == Bregistrar){
            Ventana.setVisible(false);
            Ventana2();
        }
        if (e.getSource() == menuItem21){
            Ventana4();
        }
        if (e.getSource() == menuItem22){
            MostrarClientes MC =new MostrarClientes();
            U.ListarClientes(MC.dtm2);
        }
        if (e.getSource() == menuItem31){
            Ventana6();
        }
        if (e.getSource() == menuItem32){
            MostrarProductos MP =new MostrarProductos();
            U.ListarProductos(MP.dtm);
        }
        if (e.getSource() == BotonCancelarRegistro){
            Ventana4.setVisible(false);
        }
        if (e.getSource() == BotonCancelarRegistroProducto){
            Ventana6.setVisible(false);
        }
        if (e.getSource() == RegistrarCliente){
            U.setNombre(nombre2.getText());
            U.setTelefono(telefono2.getText());
            U.setDireccion(direccion2.getText());
            U.setRun(run2.getText());
            try {
                if (U.ValidarRegistroClientes() == 1){
                    JOptionPane.showMessageDialog(null,"Cliente registrado correctamente");
                    Ventana4.setVisible(false);
                    U.EnviarRegistroClientes();
                } else if (U.ValidarRegistroClientes() == 2) {
                    Ventana4.setVisible(false);
                    JOptionPane.showMessageDialog(null,"Ingrese solamente 8 digitos");
                    Ventana4();
                }else {
                    JOptionPane.showMessageDialog(null,"Verifique el run ingresado");
                    Ventana4.setVisible(false);
                    Ventana4();
                }
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == Blogin){
            Ventana.setVisible(false);
            char [] usuTexto = Txpassword.getPassword();
            susuTexto = new String(usuTexto);
            U.setUsuario(Txusuario.getText());
            U.setPassword(susuTexto);
            try {
                if (Txusuario.getText().isEmpty() || susuTexto.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Error, tiene que ingresar un usuario y una clave");
                    Ventana();
                } else if (U.Validacion()){
                    JOptionPane.showMessageDialog(null, "Bienvenido" + " " + U.getUsuario());
                    Ventana3();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Usuario y/o clave incorrecta");
                    Ventana();
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == Bregistrar2) {
            char [] passwordChar = Txpassword3.getPassword();
            passwordddd = new String(passwordChar);
            char[] passworddddChar = Txpassword2.getPassword();
            passwordddd2 = new String(passworddddChar);
            U.setUsuario(Txusuario3.getText());
            try {
                if (U.ValidacionusuarioExistente()){
                    JOptionPane.showMessageDialog(null, "El usuario ya existe, Intente nuevamente!");
                } else if (!passwordddd.equals(passwordddd2)){
                    JOptionPane.showMessageDialog(null, "Verifique su contraseñas!");
                } else  {
                    U.setUsuario(Txusuario3.getText());
                    U.setPassword(passwordddd2);
                    U.EnviarRegistro();
                    JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
                    Ventana2.setVisible(false);
                    Ventana();
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == RegistrarProducto){
           U.setNombreProducto(nombreProducto2.getText());
           U.setPrecioProducto(precioProducto2.getText());
           U.setNumeroStock(numeroStock2.getText());
            try {
                Ventana6.setVisible(false);
                JOptionPane.showMessageDialog(null,"Producto agregado correctamente");
                U.EnviarRegistroProductos();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}