package es.fidelizacion;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import java.util.*;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteAdministrador extends JFrame {
	 
     protected static final String ID_String = null;
	static JLabel CodigoEtiqueta;
     static JLabel IDclienteEtiqueta;
     static JLabel NombreEtiqueta;
     static JLabel Apellido1Etiqueta;
     static JLabel Apellido2Etiqueta;
     static JLabel CodigoPostalEtiqueta;
     static JLabel EmailEtiqueta;
     static JLabel TelefonoEtiqueta;
     static JLabel PuntosActualesEtiqueta;
     static JLabel PuntosConsumidosEtiqueta;
     static JLabel RegalosPendientes;
     static JButtonTrans Salir;
     static JButtonTrans Eliminar;
     static JButtonTrans Guardar;
     static JButtonTrans Texto_CodigoEtiqueta;
     static JButtonTrans Texto_NombreEtiqueta;
     static JButtonTrans Texto_Apellido1Etiqueta;
     static JButtonTrans Texto_Apellido2Etiqueta;
     static JButtonTrans Texto_CodigoPostalEtiqueta;
     static JButtonTrans Texto_EmailEtiqueta;
     static JButtonTrans Texto_TelefonoEtiqueta;
     static JButtonTrans ConsultarPuntosActuales;
     static JButtonTrans ConsultarPuntosConsumidos;
     static JButtonTrans ConsultarRegalosPendientes;
     static int IDFichaCliente;
     
     static void RellenarFormulario(String Codigo, int ID, String Nombre, String apellido1, 
 		String apellido2,String CodigoPostal, String Email, String Telefono) 
        {
		
        //Create and populate the panel.
		
        JPanel p = new JPanel();
        p.setLayout(null);
        
        String ID_String=String.valueOf(ID);
        IDFichaCliente=ID;
       
        Salir=new JButtonTrans("Salir");
        Salir.setBounds(120,340,100,21);
        Eliminar=new JButtonTrans("Eliminar");
        Eliminar.setEnabled(false);
        Eliminar.setBounds(240,340,100,21);
        CodigoEtiqueta=new JLabel("Codigo: "+ Codigo);
        Texto_CodigoEtiqueta= new JButtonTrans("Modificar Codigo");
        Texto_CodigoEtiqueta.setBounds(300, 10, 100, 21);
        Texto_CodigoEtiqueta.setEnabled(false);
        CodigoEtiqueta.setBounds(10, 10, 200, 21);
        IDclienteEtiqueta=new JLabel("IDCliente: "+ ID_String);
        IDclienteEtiqueta.setBounds(10,40,200,21);
        NombreEtiqueta=new JLabel("Nombre: "+ Nombre);
        NombreEtiqueta.setBounds(10,70,200,21);
        Texto_NombreEtiqueta=new JButtonTrans("Modificar Nombre");
        Texto_NombreEtiqueta.setBounds(300,70,100,21);
        Texto_NombreEtiqueta.setEnabled(false);
	    Apellido1Etiqueta=new JLabel("1ºapellido: "+apellido1);
	    Apellido1Etiqueta.setBounds(10,100,200,21);
	    Texto_Apellido1Etiqueta=new JButtonTrans("Modificar 1º apellido");
	    Texto_Apellido1Etiqueta.setBounds(300,100,100,21);
	    Texto_Apellido1Etiqueta.setEnabled(false);
	    Apellido2Etiqueta=new JLabel("2ºapellido: "+apellido2);
	    Apellido2Etiqueta.setBounds(10,130,200,21);
	    Texto_Apellido2Etiqueta=new JButtonTrans("Modificar 2º apellido");
	    Texto_Apellido2Etiqueta.setEnabled(false);
	    Texto_Apellido2Etiqueta.setBounds(300,130,100,21);
	    CodigoPostalEtiqueta=new JLabel("Codigo Postal: "+ CodigoPostal);
	    CodigoPostalEtiqueta.setBounds(10,160,200,21);
	    Texto_CodigoPostalEtiqueta=new JButtonTrans("Modificar Codigo Postal");
	    Texto_CodigoPostalEtiqueta.setBounds(300,160,100,21);
	    Texto_CodigoPostalEtiqueta.setEnabled(false);
	    EmailEtiqueta=new JLabel("Email: "+ Email);
	    EmailEtiqueta.setBounds(10,190,200,21);
	    Texto_EmailEtiqueta=new JButtonTrans("Modificar Email");
	    Texto_EmailEtiqueta.setBounds(300,190,100,21);
	    Texto_EmailEtiqueta.setEnabled(false);
	    TelefonoEtiqueta=new JLabel("Telefono: "+ Telefono);
	    TelefonoEtiqueta.setBounds(10,220,200,21);
	    Texto_TelefonoEtiqueta=new JButtonTrans("Modificar Telefono");
	    Texto_TelefonoEtiqueta.setBounds(300,220,100,21);
	    Texto_TelefonoEtiqueta.setEnabled(false);
	    PuntosActualesEtiqueta=new JLabel("Puntos Obtenidos");
	    PuntosActualesEtiqueta.setBounds(10,250,200,21);
	    PuntosConsumidosEtiqueta=new JLabel("Puntos Consumidos");
	    PuntosConsumidosEtiqueta.setBounds(10,280,200,21);
	    RegalosPendientes=new JLabel("Regalos Obtenidos: ");
	    RegalosPendientes.setBounds(10,310,200,21);
	    ConsultarPuntosActuales=new JButtonTrans("Consultar");
	    ConsultarPuntosActuales.setBounds(300,250,100,21);
	    ConsultarPuntosActuales.setEnabled(false);
	    ConsultarPuntosConsumidos=new JButtonTrans("Consultar");
	    ConsultarPuntosConsumidos.setBounds(300,280,100,21);
	    ConsultarPuntosConsumidos.setEnabled(false);
	    ConsultarRegalosPendientes=new JButtonTrans("Consultar");
	    ConsultarRegalosPendientes.setBounds(300,310,100,21);
	    ConsultarRegalosPendientes.setEnabled(false);
	    
	    p.add(CodigoEtiqueta);
	    p.add(Texto_CodigoEtiqueta);
	    p.add(IDclienteEtiqueta);
	    p.add(NombreEtiqueta);
	    p.add(Texto_NombreEtiqueta);
	    p.add(Apellido1Etiqueta);
	    p.add(Texto_Apellido1Etiqueta);
	    p.add(Apellido2Etiqueta);
	    p.add(Texto_Apellido2Etiqueta);
        p.add(CodigoPostalEtiqueta);
        p.add(Texto_CodigoPostalEtiqueta);
        p.add(EmailEtiqueta);
        p.add(Texto_EmailEtiqueta);
        p.add(TelefonoEtiqueta);
        p.add(Texto_TelefonoEtiqueta);
        p.add(PuntosActualesEtiqueta);
        p.add(PuntosConsumidosEtiqueta);
        p.add(ConsultarPuntosActuales);
        p.add(ConsultarPuntosConsumidos);
        p.add(ConsultarRegalosPendientes);
        p.add(RegalosPendientes);
        p.add(Salir);
        p.add(Eliminar);
        JFrame frame = new JFrame("Panel Consulta");
       

        //Set up the content pane.
        p.setOpaque(true);  //content panes must be opaque
        frame.add(p);
        frame.setResizable(false);
        
       

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500,420);
        Salir.addActionListener(new ActionListener(){
     	   public void actionPerformed(ActionEvent e){
    		   frame.dispose();
    	   }
    	
    });
        
        Eliminar.addActionListener(new ActionListener(){
      	   public void actionPerformed(ActionEvent e){
      		
                int confirmado = JOptionPane.showConfirmDialog(
                		   frame,
                		   "¿Este registro va a ser eliminado?");
                
                if (JOptionPane.OK_OPTION == confirmado){
                		   System.out.println("confirmado");
                		Basedatos.loadHSQLDB(); 
                        Basedatos.connectDB(); 
                        Basedatos.createStatement();
                        Basedatos.IDClienteEliminarRegistro(PanelAdministrador.AreaCodigoAdministrador.getText());
                        Basedatos.EliminarRegistroCliente(PanelAdministrador.AreaCodigoAdministrador.getText());
                		JOptionPane.showMessageDialog(frame, "Datos eliminados correctamente");
                		FormularioBlanco();
                		
                		   
                		}else{
                		   System.out.println("vale... no borro nada...");
                		   
                		}
                Basedatos.closeHSQLDB();
          	   }
           });
        Texto_CodigoEtiqueta.addActionListener(new ActionListener(){
       	   public void actionPerformed(ActionEvent e){
       		
       		
       		String seleccion=JOptionPane.showInputDialog(
       			   frame," Nuevo Codigo De Barras "); // el icono sera un iterrogante
       		           if(seleccion!=null){
       			       Basedatos.loadHSQLDB(); 
                       Basedatos.connectDB(); 
                       Basedatos.createStatement();
                       Basedatos.ModificarCodigoBarras(seleccion,IDFichaCliente);
                       CodigoEtiqueta.setText("Codigo:"+seleccion);
               		   JOptionPane.showMessageDialog(frame, "Datos modificados correctamente");
               	       Basedatos.closeHSQLDB();
               	 }
       	   }
          });
 
       
        Texto_NombreEtiqueta.addActionListener(new ActionListener(){
      	   public void actionPerformed(ActionEvent e){
         		
      		String seleccion1 = JOptionPane.showInputDialog(
      			   frame,
      			   "NUEVO NOMBRE");  // el icono sera un iterrogante
      	           if(seleccion1!=null){
              		Basedatos.loadHSQLDB(); 
                    Basedatos.connectDB(); 
                    Basedatos.createStatement();
                    Basedatos.ModificarNombre(seleccion1,ID_String);
                    System.out.println(ID_String);
                    NombreEtiqueta.setText("NOMBRE: "+seleccion1);
              		JOptionPane.showMessageDialog(frame, "Datos modificados correctamente");
              		Basedatos.closeHSQLDB();
      	           }
        	   }
         });
        Texto_Apellido1Etiqueta.addActionListener(new ActionListener(){
       	   public void actionPerformed(ActionEvent e){
          		
       		String seleccion = JOptionPane.showInputDialog(
       			   frame,
       			   "NUEVO APELLIDO");  // el icono sera un iterrogante
       	           if(seleccion!=null){
               		Basedatos.loadHSQLDB(); 
                     Basedatos.connectDB(); 
                     Basedatos.createStatement();
                     Basedatos.ModificarApellido1(seleccion,ID_String);
                     Apellido1Etiqueta.setText("1ºapellido: "+seleccion);
               		JOptionPane.showMessageDialog(frame, "Datos modificados correctamente");
               		Basedatos.closeHSQLDB();
       	           }
         	   }
          });
        
        Texto_Apellido2Etiqueta.addActionListener(new ActionListener(){
        	   public void actionPerformed(ActionEvent e){
           		
        		String seleccion = JOptionPane.showInputDialog(
        			   frame,
        			   "NUEVO APELLIDO");  // el icono sera un iterrogante
        		      if(seleccion!=null){
        		      Basedatos.loadHSQLDB(); 
                      Basedatos.connectDB(); 
                      Basedatos.createStatement();
                      Basedatos.ModificarApellido2(seleccion,ID_String);
                      Apellido2Etiqueta.setText("2ºapellido: "+seleccion);
                		JOptionPane.showMessageDialog(frame, "Datos modificados correctamente");
                		Basedatos.closeHSQLDB();
        		      }
          	   }
           });
        

     
        
        
        Texto_CodigoPostalEtiqueta.addActionListener(new ActionListener(){
        	   public void actionPerformed(ActionEvent e){
           		
        		String seleccion = JOptionPane.showInputDialog(
        			   frame,
        			   "NUEVA CODIGO POSTAL");  // el icono sera un iterrogante
        		      if(seleccion!=null){
                	  Basedatos.loadHSQLDB(); 
                      Basedatos.connectDB(); 
                      Basedatos.createStatement();
                      Basedatos.ModificarCODIGOPOSTAL(seleccion,ID_String);
                      CodigoPostalEtiqueta.setText("Direccion:"+seleccion);
                	  JOptionPane.showMessageDialog(frame, "Datos modificados correctamente");
                	  Basedatos.closeHSQLDB();
        		      }
          	   }
           });
   
      
     
        Texto_TelefonoEtiqueta.addActionListener(new ActionListener(){
        	   public void actionPerformed(ActionEvent e){
           		
        		String seleccion = JOptionPane.showInputDialog(
        			   frame,
        			   "NUEVO TELEFONO");  // el icono sera un iterrogante
        		     if(seleccion!=null){
                	  Basedatos.loadHSQLDB(); 
                      Basedatos.connectDB(); 
                      Basedatos.createStatement();
                      Basedatos.ModificarTelefono(seleccion,ID_String);
                      TelefonoEtiqueta.setText("Telefono:" +seleccion);
                	  JOptionPane.showMessageDialog(frame, "Datos modificados correctamente");
                	  Basedatos.closeHSQLDB();
        		     }
          	   }
           });
        Texto_EmailEtiqueta.addActionListener(new ActionListener(){
     	   public void actionPerformed(ActionEvent e){
        		
     		String seleccion = JOptionPane.showInputDialog(
     			   frame,
     			   "NUEVO EMAIL");  // el icono sera un iterrogante
     		     if(seleccion!=null){
             		Basedatos.loadHSQLDB(); 
                   Basedatos.connectDB(); 
                   Basedatos.createStatement();
                   Basedatos.ModificarEmail(seleccion,ID_String);
                   EmailEtiqueta.setText("Email:" +seleccion);
             	  JOptionPane.showMessageDialog(frame, "Datos modificados correctamente");
             	  Basedatos.closeHSQLDB();
     		     }
       	   }
        });
        
        
          ConsultarPuntosActuales.addActionListener(new ActionListener(){
      	   public void actionPerformed(ActionEvent e){
         		
      	        new ConsultaPuntosActualesDiarios();
        	   }
         });
          ConsultarPuntosConsumidos.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e){
            		
         	        new ConsultaPuntosConsumidosDiarios();
           	   }
            });
          
          ConsultarRegalosPendientes.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e){
            		
         	        new ConsultaRegalosPendientes();
           	   }
            });
           
}
    
     static void FormularioBlanco(){
    	 CodigoEtiqueta.setText("Codigo: ");
         Texto_CodigoEtiqueta.setVisible(false);
         IDclienteEtiqueta.setText("IDCliente: ");
         NombreEtiqueta.setText("Nombre: ");
         Texto_NombreEtiqueta.setVisible(false);
 	    Apellido1Etiqueta=new JLabel("1ºapellido: ");
 	    Texto_Apellido1Etiqueta.setVisible(false);
 	    Apellido2Etiqueta.setText("2ºapellido: ");
 	    Texto_Apellido2Etiqueta.setVisible(false);
 	    CodigoPostalEtiqueta.setText("Codigo Postal: ");
 	    Texto_CodigoPostalEtiqueta.setVisible(false);
 	    EmailEtiqueta.setText("Email: ");
 	    Texto_EmailEtiqueta.setVisible(false);
 	    TelefonoEtiqueta.setText("Telefono: ");
 	    Texto_TelefonoEtiqueta.setVisible(false);
 	    PuntosActualesEtiqueta.setText("Puntos Actuales: ");
 	    PuntosConsumidosEtiqueta.setText("Puntos Cosumidos: ");
 	    Eliminar.setVisible(false);   
         }
     	
     	
     	
     }
