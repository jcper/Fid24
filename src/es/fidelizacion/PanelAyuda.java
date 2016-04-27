package es.fidelizacion;

import java.io.IOException;
import java.awt.Desktop;
import java.io.File;

public class PanelAyuda {

	
	
	static void Ayuda(){
	      {   
	    		try {
	    		    
	    			File arch = new File("ayuda/manual.pdf"); 
	    			Desktop.getDesktop().open(arch); 
	    		    System.out.println("ejecutando ayuda");
	    		} catch (IOException e) {
	    		                e.printStackTrace();

	    		  }
	    	  }
	    	}
		
		
	}

