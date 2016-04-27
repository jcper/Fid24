package es.fidelizacion;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

public class GenerarBackup {
	
	
    

	 static void backup() {
		 
        String executeCmd ="cmd.exe /c C:/MySQL/bin/mysqldump -uroot -palejandro fidelizacion >backup/Backup_seguridad.sql";  
        Process runtimeProcess;
        try {
 
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
            PanelAdministrador.progressBarBackup.setIndeterminate(true);
           
 
            if (processComplete == 0) {
                System.out.println("Backup created successfully");
                PanelAdministrador.progressBarBackup.setIndeterminate(false);
                PanelAdministrador.progressBarBackup.setVisible(false);
                JOptionPane.showMessageDialog(PanelAdministrador.VentanaAdministrador, "Backup realizado correctamente");
               
            } else {
            	 PanelAdministrador.progressBarBackup.setIndeterminate(false);
                 PanelAdministrador.progressBarBackup.setVisible(false);
                System.out.println("Could not create the backup");
                JOptionPane.showMessageDialog(PanelAdministrador.VentanaAdministrador, "No hemos podido realizar el Backup");
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	 }
	 
}
       
    
