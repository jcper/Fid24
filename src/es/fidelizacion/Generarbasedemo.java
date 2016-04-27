package es.fidelizacion;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Generarbasedemo {
	
	   static void restore() {
			 
	        String executeCmd="cmd.exe /c C:/MySQL/bin/mysql -u root -palejandro fidelizacion <backup/Backup_seguridadDemo.sql";
	 
	        Process runtimeProcess;
	        try {
	 
	            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
	            int processComplete = runtimeProcess.waitFor();
	            
	            
	            if (processComplete == 0) {
	                System.out.println("restored successfully");
	              
	            } else {
	            	System.out.println(processComplete);
	                System.out.println("Could not restore");
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	 
	  
	    }

	}



