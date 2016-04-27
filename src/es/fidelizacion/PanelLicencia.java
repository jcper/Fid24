package es.fidelizacion;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class PanelLicencia extends JFrame implements ActionListener  {
	
	   static String[] labelsconfiguracion = {"FID24 version: ","Fecha ALTA: ","Licencia: "};
	   static int numPairs1 = labelsconfiguracion.length;
	   static JTextField[] textField = new JTextField[numPairs1];
	  
	   /**
	    * Create the GUI and show it.  For thread safety,
	    * this method should be invoked from the
	    * event-dispatching thread.
	    */
	       static void Configurar()  {
	      
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
	        Botones.add(SALIR);
	       
	       
	       
	       //Layout the panel.
	       SpringUtilities.makeCompactGrid(Configuracion,numPairs1,2,6,6,6,6);//xPad, yPad
	       JFrame frame = new JFrame("Panel licencia");
	       frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS) );
	       frame.add(Configuracion);
	       frame.add(Botones);
	       frame.setResizable(false);
	       frame.setVisible(true);
	       frame.setSize(300,150);
	       
	       Basedatos.loadHSQLDB(); 
	       Basedatos.connectDB(); 
	       Basedatos.createStatement();
	       Basedatos.Configurar();
	       Basedatos.closeHSQLDB();
	       
	       textField[0].setText("FID24 VERSION 2.01");
	       textField[0].setEnabled(false);
	       textField[1].setText(PanelAdministrador.Fecha);
	       textField[1].setEnabled(false);
	       if(String.valueOf(PanelAdministrador.Licencia).equals("0")){
	    	  textField[2].setText("version Demo");
	    	  textField[2].setEnabled(false);
	       }else{
	       textField[2].setText(String.valueOf(PanelAdministrador.Licencia));
	       textField[2].setEnabled(false);
	       }
	       
	       SALIR.addActionListener(new ActionListener(){
	       	   public void actionPerformed(ActionEvent e){
	    		   frame.dispose();
	    	     }
	    	
	         });

	       } 

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}