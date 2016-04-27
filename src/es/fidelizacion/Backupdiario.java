package es.fidelizacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Backupdiario {

	 static void backup() {
		 
        String executeCmd ="cmd.exe /c C:/MySQL/bin/mysqldump -uroot -palejandro fidelizacion >backup/Backup_seguridad"+Formulario.FechaEntradaMysql+".sql";  
        Process runtimeProcess;
        try {
 
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            if (processComplete == 0) {
                System.out.println("Backup created successfully");
               
            } else {
                System.out.println("Could not create the backup");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	 }
	 
}
