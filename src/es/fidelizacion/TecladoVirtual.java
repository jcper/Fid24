package es.fidelizacion;

import java.io.*;

public class TecladoVirtual {
	static Runtime Teclado=Runtime.getRuntime();
	
	
	public static void Teclado() {
	 
	
	try{
		
		Teclado.exec("teclado/FreeVK.exe");
	    	
	 }
	catch(Exception e){}
	
    }
}

