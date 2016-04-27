package es.fidelizacion;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
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


public class ConfigurarAdministrador extends JFrame implements ActionListener  {
	
   static String[] labelsconfiguracion = {"Contraseña: ","Licencia: ","Fecha(yyyy/mm/dd/): ","Establecimiento: ","Nif: "};
   static int numPairs1 = labelsconfiguracion.length;
   static JTextField[] textField = new JTextField[numPairs1];
  
   /**
    * Create the GUI and show it.  For thread safety,
    * this method should be invoked from the
    * event-dispatching thread.
    */
       static void Configurar()  {
       
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
           textField[i] = new JTextField();
           l.setLabelFor(textField[i]);
           Configuracion.add(textField[i]);
       }
      
        
       
   
        Botones=new JPanel(new FlowLayout());
        Botones.add(MODIFICAR);
        Botones.add(SALIR);
       
       
       
       //Layout the panel.
       SpringUtilities.makeCompactGrid(Configuracion,numPairs1,2,6,6,6,6);//xPad, yPad
       JFrame frame = new JFrame("Configuracion Administrador");
       frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS) );
       frame.add(Configuracion);
       frame.add(Botones);
       frame.setResizable(false);
       frame.setVisible(true);
       frame.setSize(300,200);
       
       Basedatos.loadHSQLDB(); 
       Basedatos.connectDB(); 
       Basedatos.createStatement();
       Basedatos.Configurar();
       Basedatos.closeHSQLDB();
        
	   if( textField[0].getText().equals("adminjcper")){
		   
		   textField[0].setText(PanelAdministrador.Contraseña);
		   textField[0].setEnabled(true);
	       textField[1].setText(String.valueOf(PanelAdministrador.Licencia));
	   	   textField[1].setEnabled(true);
	   	   textField[2].setText(PanelAdministrador.Fecha);
	   	   textField[2].setEnabled(false);
	   	   textField[3].setText(PanelAdministrador.Establecimiento);
	  	   textField[3].setEnabled(true);
	  	   textField[4].setText(PanelAdministrador.Nif);
		   textField[4].setEnabled(true); 
		   
	   }else{
       textField[0].setText(PanelAdministrador.Contraseña);
       textField[1].setText(String.valueOf(PanelAdministrador.Licencia));
   	   textField[1].setEnabled(false);
   	   textField[2].setText(PanelAdministrador.Fecha);
   	   textField[2].setEnabled(false);
   	   textField[3].setText(PanelAdministrador.Establecimiento);
  	   textField[3].setEnabled(false);
  	   textField[4].setText(PanelAdministrador.Nif);
	   textField[4].setEnabled(false); 
	   }
       
	   
       SALIR.addActionListener(new ActionListener(){
       	   public void actionPerformed(ActionEvent e){
    		   frame.dispose();
    	     }
    	
         });
       
       MODIFICAR.addActionListener(new ActionListener(){
       	   public void actionPerformed(ActionEvent e){
       	   if(textField[0].getText().equals("adminjcper")){
       		   textField[0].setEnabled(false);
       		   textField[1].setEnabled(true);
    	   	   textField[2].setEnabled(false);
    	  	   textField[3].setEnabled(true);
    		   textField[4].setEnabled(true); 
    		   int licenciaI=Integer.parseInt(textField[1].getText());
    		   String Longitud=textField[4].getText();
    		   //Quitamos el primer caracter y el ultimo digito
    			   String valueCif=Longitud.substring(1,8);
             	   int nifI=Integer.parseInt(valueCif);
        		   int nifILicencia=nifI+1111111;
    		   if(licenciaI==nifILicencia){
    		   JOptionPane.showMessageDialog(frame, "Licencia generada correctamente");
    		   Basedatos.loadHSQLDB(); 
               Basedatos.connectDB(); 
               Basedatos.createStatement();
               Basedatos.EliminarConfiguracion();
               Basedatos.insertConfiguracion("1234",Integer.parseInt(textField[1].getText()),Formulario.FechaEntradaMysql,textField[3].getText(),textField[4].getText());
               Basedatos.restoreDB();//Se borra la base datos  de ejemplo  menos configuracion y configuracion lector.
               JOptionPane.showMessageDialog(frame, "datos guardados correctamente");
               Basedatos.closeHSQLDB();
               
              }else{
    			   JOptionPane.showMessageDialog(frame, "licencia generada incorrectamente,"+" por favor consulte con su distribuidor"); 
    			   textField[1].setText("");
    			   textField[4].setText("");
    		    }
    		   
            }else{
            	Basedatos.ActualizarContraseña(textField[0].getText());
                JOptionPane.showMessageDialog(frame, "datos guardados correctamente");
                Basedatos.closeHSQLDB();
            }
          }
    	
         });
         
        
       }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
     
    
}
