package es.fidelizacion;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import es.fidelizacion.Formulario.TimerListener;


public class cliente implements ActionListener {
	static int ID; 
    static int Codigo;
    static int PuntosActuales;
    static int CamposFormulario=13;
    static String[] labels = {"Codigo: ","Nombre: ", "1ºApellido: ", "2ºApellido: ","CodigoPostal: ","Email: ","Telefono: "};
    static int numPairs = labels.length;
    static JTextField[] textField = new JTextField[numPairs];
    static String FechaAlta;
    static Timer timerFormulario;
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
        static void createAndShowGUI()  {
        timerFormulario=new Timer(1000,taskPerformer);
        timerFormulario.start();
        PanelAdministrador.AreaCodigoAdministrador.setEnabled(false);
        JFrame frame = new JFrame("Cliente");
        JButtonTrans BORRAR =  new JButtonTrans("BORRAR");
		JButtonTrans GUARDAR=  new JButtonTrans("GUARDAR");
		JButtonTrans SALIR= new JButtonTrans("SALIR");
		JPanel Botones;
		SpringLayout layout;
        
        //Create and populate the panel.
		layout= new SpringLayout();
        JPanel p = new JPanel(layout);
        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            p.add(l);
            textField[i] = new JTextField(10);
            l.setLabelFor(textField[i]);
            p.add(textField[i]);
        }
       
         Botones=new JPanel(new FlowLayout());
         Botones.add(GUARDAR);
         Botones.add(BORRAR);
         Botones.add(SALIR);
         
      
        
        //Layout the panel.
        SpringUtilities.makeCompactGrid(p, numPairs, 2, 6, 6, 6, 6); //xPad, yPad
        
        
        GUARDAR.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e)
            {
                for (int i = 0 ; i < numPairs ; i++)
                {
                    System.out.println(labels[i]+"->"+textField[i].getText());
                    
                }
                if(textField[0].getText().equals("")){
                	   PuertoSerie.LeerSerial.s="";
                	   JOptionPane.showMessageDialog(frame,
      	      				   "El campo  Codigo: esta en blanco","Error", JOptionPane.WARNING_MESSAGE,Formulario.IError);
                	   
                	  
                  }
                                  
                   
                Basedatos.loadHSQLDB(); 
                Basedatos.connectDB(); 
                Basedatos.createStatement(); 
                FechaAlta=Formulario.FechaEntradaMysql;
    
                Basedatos.insertData(textField[0].getText(), textField[1].getText(),textField[2].getText(),textField[3].getText(),
                textField[4].getText(),FechaAlta,textField[5].getText(),textField[6].getText());
                Basedatos.ObtenerIDCliente(textField[0].getText());
                Basedatos.insertTablaImportes(ID,FechaAlta);
                Basedatos.insertTablaDiaria(ID,FechaAlta);
                Basedatos.insertTablaConsumoDiario(ID,FechaAlta);
                Basedatos.insertTablaRegalosPendientes(ID,FechaAlta);
                Basedatos.closeHSQLDB();
                JOptionPane.showMessageDialog(p, "Datos guardados correctamente");
                FormularioBlanco();
                PuertoSerie.LeerSerial.s="";
                
            }
        });  
       
       

        //Set up the content pane.
        p.setOpaque(true);  //content panes must be opaque
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS) );
        frame.add(p);
        frame.add(Botones);
        frame.setResizable(false);
        
       

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400,400);
        BORRAR.addActionListener(new ActionListener(){
     	   public void actionPerformed(ActionEvent e){
     		  if(textField[0].getText().equals("")){
           	   JOptionPane.showMessageDialog(frame,
 	      				   "El campo  Codigo: esta en blanco","Error", JOptionPane.WARNING_MESSAGE,Formulario.IError);
           	  
             }
    		   FormularioBlanco();
    	   }
    	
    });

        SALIR.addActionListener(new ActionListener(){
        	   public void actionPerformed(ActionEvent e){
        		   frame.dispose();
        		   PanelAdministrador.AreaCodigoAdministrador.setEnabled(true);
        	   }
        	
        });
    }
        private static void DetectarPuertoSerie(){
      	  String caracteres=textField[0].getText();
      	  if(caracteres.length()==13 ){
      	         textField[0].setEnabled(false);
      	         PuertoSerie.LeerSerial.s="";
      		    
      	  }if(caracteres.length()>=14){
        		 textField[0].setText("");
        		 PuertoSerie.LeerSerial.s="";
        	}
         }
        static ActionListener taskPerformer = new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                //...Perform a task...
            	 DetectarPuertoSerie();
            }
        };
        
        static void FormularioBlanco(){
        	
            for (int i = 0; i < numPairs; i++) {
               
                textField[i].setText(""); 
         }
        	
            PanelAdministrador.AreaCodigoAdministrador.setEnabled(true);
        }
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
}