import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    int ANCHO=1280, LARGO=720;
    JFrame Ventana3;
    JButton BirAtras2;

    public Dashboard(){
        // ventana
        Ventana3 = new JFrame();
        Ventana3.setTitle("Panel DashBoard");
        Ventana3.setSize(ANCHO, LARGO);
        Ventana3.setLayout(null);
        Ventana3.setLocationRelativeTo(null);
        //Ventana3.setResizable(false);
        Ventana3.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Ventana3.setVisible(true);
        Paneles();
    }
    public void Paneles(){
        BtnDashboard();
    }
    public void BtnDashboard(){
        // Boton ir atras
        BirAtras2 = new JButton("Cerrar sesion");
        BirAtras2.setBounds(100,320,120,40);
        BirAtras2.addActionListener(this);
        Ventana3.add(BirAtras2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BirAtras2){
            Ventana3.setVisible(false);
            new Login();
        }
    }
}
