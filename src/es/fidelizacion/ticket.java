package es.fidelizacion;
import java.awt.*;
import java.awt.print.*;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.Doc;
import javax.print.PrintException;
import javax.print.ServiceUI;
import javax.print.attribute.*;

public class ticket {
//Contenido del ticket
private String contentTicket =
"             Cafeteria El Toledano            \n"+
"              Resumen saldo puntos            \n"+
"==============================================\n"+
" {{nombre}}                       {{dateTime}}\n"+
" {{apellidos}}                    {{ID}}      \n"+
"==============================================\n"+
"              Puntos/Premios                  \n"+
" Desayunos:    {{Desay}}/{{PremioD}}          \n"+
" Menus:        {{Menus}}/{{PremioM}}          \n"+
" Importes:     {{Impor}}/{{PremioI}}          \n"+
"==============================================\n"+
"                 {{Codigo}}                   \n"+
"\n\n\n\n\n\n\n ";

//El constructor que setea los valores a la instancia
ticket(String nombre, String apellidos,String codigo, String id, String dateTime,String importes, String premioimportes){
this.contentTicket = this.contentTicket.replace("{{nombre}}", nombre);
this.contentTicket = this.contentTicket.replace("{{dateTime}}", dateTime);
this.contentTicket = this.contentTicket.replace("{{apellidos}}", apellidos);
this.contentTicket = this.contentTicket.replace("{{Codigo}}", codigo);
this.contentTicket = this.contentTicket.replace("{{ID}}", id);
this.contentTicket = this.contentTicket.replace("{{Impor}}", importes);
this.contentTicket = this.contentTicket.replace("{{PremioI}}", premioimportes);
}

@SuppressWarnings("null")
public void print() throws IOException {

//PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null); //nos da el array de los servicios de impresion
	//PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
	//Especificamos el tipo de dato a imprimir
	//Tipo: bytes; Subtipo: autodetectado
	DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;

    //Con esto mostramos el dialogo para seleccionar impresora
    //Si quieres ver el dialogo de seleccionar impresora usalo
    //Solo mostrara las impresoras que soporte arreglo de bits
    PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
    //PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
    //PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
    PrintService service=PrintServiceLookup.lookupDefaultPrintService();
  //Creamos un arreglo de tipo byte
  //y le agregamos el string convertido (cuerpo del ticket) a bytes tal como
  //lo maneja la impresora(mas bien ticketera :p)
   byte[] bytes= this.contentTicket.getBytes();
   Doc doc = new SimpleDoc(bytes,flavor,null);
//Creamos un trabajo de impresión
   DocPrintJob job=null;
//if(services.length>0){
//for(int i=0; i<services.length; i++){
//if(services[i].getName().equals("GP-5890X Series")){//aqui escribimos/elegimos la impresora por la que queremos imprimir
  job = service.createPrintJob();// System.out.println(i+": "+services[i].getName());
//   }
// }
//}

//Imprimimos dentro de un try obligatoriamente
try{
job.print(doc, null);
}catch(PrintException ex){
System.out.println(ex);
    }
  }
}