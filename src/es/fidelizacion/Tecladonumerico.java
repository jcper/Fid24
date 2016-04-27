package es.fidelizacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
 

public class Tecladonumerico extends JFrame implements ActionListener {
 
   
    /** numero tecleado */
    static JTextField pantalla;
 
    /** Los paneles donde colocaremos los botones */
    
 
    JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,borrar,listo;
    
    static String EnviarCodigo;
 
    /**
     * Constructor. Crea los botones y componentes de la calculadora
     */
    public  Tecladonumerico() {
    	 EnviarCodigo="";
        
    	 setSize(250, 300);
    	 setTitle("Teclado Numerico");
    	 setResizable(false); JPanel panelNumeros;
    	 setVisible(true);
 
        // Vamos a dibujar sobre el panel
        JPanel panel = (JPanel) this.getContentPane();
        panel.setLayout(new BorderLayout());
 
        pantalla = new JTextField();
        pantalla.setBorder(new EmptyBorder(4, 4, 4, 4));
        pantalla.setFont(new Font("Arial", Font.BOLD, 25));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(false);
        pantalla.setBackground(Color.WHITE);
        panel.add("North", pantalla);
        
        panelNumeros = new JPanel();
        panelNumeros.setLayout(new GridLayout(4, 3));
        panelNumeros.setBorder(new EmptyBorder(4, 4, 4, 4));
 
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        borrar=new JButton("borrar");
        listo=new JButton("listo");
 
        panelNumeros.add(b9);
        panelNumeros.add(b8);
        panelNumeros.add(b7);
        panelNumeros.add(b6);
        panelNumeros.add(b5);
        panelNumeros.add(b4);
        panelNumeros.add(b3);
        panelNumeros.add(b2);
        panelNumeros.add(b1);
        panelNumeros.add(b0);
        panelNumeros.add(borrar);
        panelNumeros.add(listo);
        
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b0.addActionListener(this);
        borrar.addActionListener(this);
        listo.addActionListener(this);
        
        panel.add("Center", panelNumeros);
     
    }
 
    public void actionPerformed(ActionEvent ae){
        // Este es el metodo que hace las operaciones necesarias para
        // que cada boton tenga su funcion.
        if (ae.getSource() == b0){
             EnviarCodigo = pantalla.getText();
            pantalla.setText( EnviarCodigo + "0");
        }

        if (ae.getSource() == b1){
            EnviarCodigo = pantalla.getText();
            pantalla.setText( EnviarCodigo + "1");
        }
 
        if (ae.getSource() == b2){
            EnviarCodigo = pantalla.getText();
            pantalla.setText( EnviarCodigo + "2");
        }
 
        if (ae.getSource() == b3){
            EnviarCodigo = pantalla.getText();
            pantalla.setText( EnviarCodigo + "3");
        }
 
        if (ae.getSource() == b4){
            EnviarCodigo = pantalla.getText();
            pantalla.setText( EnviarCodigo + "4");
        }
 
        if (ae.getSource() == b5){
            EnviarCodigo = pantalla.getText();
            pantalla.setText( EnviarCodigo + "5");
        }
 
        if (ae.getSource() == b6){
            EnviarCodigo = pantalla.getText();
            pantalla.setText( EnviarCodigo + "6");
        }
 
        if (ae.getSource() == b7){
            EnviarCodigo = pantalla.getText();
            pantalla.setText( EnviarCodigo + "7");
        }
        if (ae.getSource() == b8){
            EnviarCodigo = pantalla.getText();
            pantalla.setText( EnviarCodigo + "8");
        }
 
        if (ae.getSource() == b9){
            EnviarCodigo = pantalla.getText();
            pantalla.setText( EnviarCodigo + "9");
        }
        
        if (ae.getSource() == borrar){
            EnviarCodigo = pantalla.getText();
            pantalla.setText( EnviarCodigo="");
        }
        
        if (ae.getSource() == listo){
            EnviarCodigo = pantalla.getText();
            if( Formulario.AreaCodigo.getText().equals("")){
          Formulario.AreaCodigo.setText(EnviarCodigo);
          EnviarCodigo="";
          this.dispose();
            }else{
            	Formulario.texto_Factura_Ticket.setText( EnviarCodigo);
            	 this.dispose();
            }
         
          
        }
 
    }
    
}