/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inmobiliaria;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JComboBox;
/**
 *
 * @author Ro
 */
public class Ventana {
    
    private JFrame Ventana;
    private JDialog Dialogo;
        
        public Ventana(){
            Ventana = new JFrame("VENTANA");
            Dialogo = new JDialog(Ventana,"",true);
        }
        
        public void mostrarVentana(){
            
            Ventana.getContentPane().setBackground(Color.blue);
            Ventana.setSize(400,300);
            Ventana.setVisible(true);
            Dialogo.setSize(300,200);
            Dialogo.setVisible(false);
            Ventana.setTitle("Select an option");
            Ventana.setSize(200,150);
            Ventana.getContentPane().setLayout(new FlowLayout());
            JButton b = new JButton("Ok");
            Ventana.getContentPane().add(b);
            Ventana.setVisible(true);
            String[] list = {"Rojo", "Amarillo", "Blanco"};
            JComboBox c = new JComboBox(list);
            Ventana.getContentPane().add(c);
            Ventana.setVisible(true);
                       
        }
}
