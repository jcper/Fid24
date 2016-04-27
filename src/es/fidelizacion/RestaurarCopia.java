package es.fidelizacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.*;
import javax.swing.border.Border;

public class RestaurarCopia {
	
	static void restore() {
		 
        String executeCmd="cmd.exe /c C:/MySQL/bin/mysql -u root -palejandro fidelizacion <backup/Backup_seguridad.sql";
      
        Process runtimeProcess;
        try {
 
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
        
            
             PanelAdministrador.progressBarRestaurar.setIndeterminate(true);
         	 
            
            if (processComplete == 0) {
            	PanelAdministrador.progressBarRestaurar.setIndeterminate(false);
            	PanelAdministrador.progressBarRestaurar.setVisible(false);
                System.out.println("restored successfully");
                JOptionPane.showMessageDialog(PanelAdministrador.VentanaAdministrador, "Copia restaurada correctamente");
               
              
            } else {
            	System.out.println(processComplete);
                System.out.println("Could not restore");
                PanelAdministrador.progressBarRestaurar.setIndeterminate(false);
                PanelAdministrador.progressBarRestaurar.setVisible(false);
                
                JOptionPane.showMessageDialog(PanelAdministrador.VentanaAdministrador, "No se ha podido restaurar la copia");
               
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 
  
    }

}
