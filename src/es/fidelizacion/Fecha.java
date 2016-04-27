package es.fidelizacion;

import java.util.*;
import java.text.*;


  public class Fecha {
    int hora, minutos, segundos;
   Calendar calendario; 
   Date now;
   DateFormat df;
   String fecha;
   String time;
   String fechamysql;
   SimpleDateFormat dt1;
  public Fecha(){
	
	calendario = new GregorianCalendar();
	hora=calendario.get(Calendar.HOUR_OF_DAY);
	String.valueOf(hora);
	minutos = calendario.get(Calendar.MINUTE);
	String.valueOf(minutos);
	segundos = calendario.get(Calendar.SECOND);
	String.valueOf(segundos);
	 now = new Date();
	 df = DateFormat.getDateInstance();
	 fecha=df.format(now);
	 time=hora +":"+minutos+":"+segundos;
	 dt1 = new SimpleDateFormat("yyyy-MM-dd");
	 fechamysql=dt1.format(now);
	 
  }
  public  String getFecha(){
	return fecha;	
 }
  public  String getTime(){
	 return time;
 }
  public String getFechamysql(){
	return fechamysql;
 }
  public void setFecha(String Fecha){
      fecha=Fecha;
   }
 }



 