package es.fidelizacion;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Configurar extends JFrame implements ActionListener  {
	
   static String[] labelsconfiguracion = {" COM: ","Codigo Barras:","Intervalo de msg:"};
   static int numPairs1 = labelsconfiguracion.length;
   static String[] nCom ={ "0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10","11","12","13","14","15","16","17","18","19","20"};
   static JComboBox[] textField = new JComboBox[numPairs1];
   static String puertoCom; 
   static int longitud;
   static int intervalo;
   
   /**
    * Create the GUI and show it.  For thread safety,
    * this method should be invoked from the
    * event-dispatching thread.
    */
       static void ConfigurarCOM()  {
       
		JButtonTrans MODIFICAR=  new JButtonTrans("MODIFICAR");
		JButtonTrans SALIR= new JButtonTrans("SALIR");
		JPanel Botones;
		SpringLayout layout;
	    
		
    
       //Create and populate the panel.
	   layout= new SpringLayout();
       JPanel Configuracion = new JPanel(layout);
     
       for (int i = 0; i < numPairs1; i++) {
           JLabel l = new JLabel(labelsconfiguracion[i], JLabel.TRAILING);
           Configuracion.add(l);
           textField[i] = new JComboBox(nCom);
           l.setLabelFor(textField[i]);
           Configuracion.add(textField[i]);
       }
      
        
       
   
        Botones=new JPanel(new FlowLayout());
        Botones.add(MODIFICAR);
        Botones.add(SALIR);
       
       
       
       //Layout the panel.
       SpringUtilities.makeCompactGrid(Configuracion,numPairs1,2,6,6,6,6);//xPad, yPad
       JFrame frame = new JFrame("Configuracion lector");
       frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS) );
       frame.add(Configuracion);
       frame.add(Botones);
       frame.setResizable(false);
       frame.setVisible(true);
       frame.setSize(300,180);
        
       Basedatos.loadHSQLDB(); 
       Basedatos.connectDB(); 
       Basedatos.createStatement();
       Basedatos.ConfigurarLector();
       Basedatos.closeHSQLDB();
        
       textField[0].setSelectedItem(puertoCom);
       textField[1].setSelectedIndex(13);
   	   textField[1].setEnabled(false);
   	   textField[2].setSelectedIndex(5);
   	   textField[2].setEnabled(false);
        
       SALIR.addActionListener(new ActionListener(){
       	   public void actionPerformed(ActionEvent e){
    		   frame.dispose();
    	     }
    	
         });
       
       MODIFICAR.addActionListener(new ActionListener(){
       	   public void actionPerformed(ActionEvent e){
       		textField[1].setSelectedIndex(13);
       	    String longitud=String.valueOf(textField[1].getSelectedItem());
       		int longitudI=Integer.parseInt(longitud);
       		textField[1].setEnabled(false);
            textField[2].setSelectedIndex(5);
            String intervalo=String.valueOf(textField[2].getSelectedItem());
            int intervaloI=Integer.parseInt(intervalo);
            int intervaloImsg=100*intervaloI;
            textField[2].setEnabled(false);
            JOptionPane.showMessageDialog(frame, "Para que los cambios sean modificados correctamente," 
            		+" por favor reinicie el ordenador");
            Basedatos.loadHSQLDB(); 
            Basedatos.connectDB(); 
            Basedatos.createStatement();
            Basedatos.EliminarConfiguracionLector();
            Basedatos.insertConfiguracionLector(String.valueOf(textField[0].getSelectedItem()), longitudI, intervaloImsg);
          }
    	
         });
         
        
       }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}