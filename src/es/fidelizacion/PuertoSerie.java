package es.fidelizacion;

import java.io.InputStream;
import java.util.Enumeration;

import javax.comm.CommPortIdentifier;
import javax.comm.SerialPort;
import javax.swing.*;

public class PuertoSerie  {
	   CommPortIdentifier portId;
	    Enumeration portList;
	    static InputStream entrada=null;
	    static SerialPort serialPort;
	     static Thread readThread;
         static String puerto;
         static int intervalomsgTotal;
         static int longitudLector;
	     public PuertoSerie() {
	    	  super();
	    	  portList = CommPortIdentifier.getPortIdentifiers();
	          readThread = new Thread(new LeerSerial());
	          while (portList.hasMoreElements()) {
	              portId = (CommPortIdentifier) portList.nextElement();
	              if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
	              	System.out.println(portId.getName()); //puertos disponbibles
	              	System.out.println(puerto+intervalomsgTotal);
	                  if (portId.getName().equals(puerto)) {
	                		System.out.println("puerto"+puerto+longitudLector);
	                		try {
	                			serialPort = (SerialPort) portId.open("PuertoSerie", 500);
	                			entrada =serialPort.getInputStream(); //esta variable del tipo InputStream obtiene el dato serial
	                          	readThread.start(); // inciamos el hilo para realizar nuestra accion de imprimir el dato serial
	                            
	      					
	      						} catch (Exception e) {
	      							
	      							serialPort.close();
	                	
	      						}
	                  } 		
	              }
	              
	          }
	     }
	 public static void CerrarCom() {
		 
	  serialPort.close();
	 }
	 public static class LeerSerial implements Runnable {
			  static String s="";
	  		  static int dato;
	  		 
	      			public void run () {
	      					 while(true){
	      						    try{
	      						    			   
	      						  while (entrada.available() > 0 ) {
	      						    			      dato = entrada.read();
	      						    			      s=s+(char)dato;
	      						    			     if(s.length()==PuertoSerie.longitudLector && Formulario.AreaCodigo.isEnabled()){
	      						    			     Formulario.AreaCodigo.setText(s);
	      						    			     System.out.println(s);//imprimimos el dato serial
	      						    			     Formulario.ventana.setExtendedState(JFrame.NORMAL);
	      						    			     s="";
	      						    			     entrada.reset();
	      						    			    }
	      						    			   if(s.length()==PuertoSerie.longitudLector && PanelAdministrador.AreaCodigoAdministrador.isEnabled()){
	      						    				    PanelAdministrador.AreaCodigoAdministrador.setText(s);
	      						    				  s="";
		      						    			  entrada.reset();
		      						    			
		      						    			  }
	      						    			     if(s.length()==PuertoSerie.longitudLector){
	      						    				    cliente.textField[0].setText(s);
	      						    				  s="";
		      						    			  entrada.reset();
		      						    			  
		      						    			 }
	      						    		     }
	      						    		   
	      						    		   }
	      									catch (Exception e) {
	      						 			} 
	      						    		 }
	      						        }  	   
	      				    	}  	
	      				  }	
	              


	   