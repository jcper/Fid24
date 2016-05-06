package es.fidelizacion;

import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class PanelFidelizacion extends JFrame implements ActionListener  {
	
   static JTable tabla;
   static  DefaultTableModel modelo;
   static String nomcols[]={"NOMBRE","PUNTOS","LIMITE","PREMIOS"};
   static JScrollPane scroll;
   
   static String[] puntos ={ "0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
   static String[] PremiosPuntos={"0","10","20","30","40","50","60","70","80","90","100","200","300","400","500","600","700","800","900","1000"};
   static String[] Premios ={"0","1 menu","2 menus","3 menus","4 menus","5 menus", "1 desayuno","2 desayunos","3 desayunos","4 desayunos",
	    "5 desayunos", "5% descuento", "10% descuento", "15% descuento", "20% descuento","25% descuento"};
   static String datos[][]=new String[3][4];
   
   static JComboBox comboPuntos= new JComboBox(puntos);
   static JComboBox comboPremios=new JComboBox(Premios);
   static JComboBox comboGeneradorPuntos=new JComboBox(PremiosPuntos);
   
   
  
   /**
    * Create the GUI and show it.  For thread safety,
    * this method should be invoked from the
    * event-dispatching thread.
    */
       static void ConfigurarFidelizacion()  {
    	datos[0][0]="Articulo 1";
        datos[1][0]="Articulo 2";
        datos[2][0]="Importe";
    	modelo=new DefaultTableModel(datos,nomcols);
    
        
        tabla=new JTable(modelo);
        tabla.getModel().setValueAt(String.valueOf(Formulario.puntosporDesayuno), 0, 1);
        tabla.getModel().setValueAt(String.valueOf(Formulario.puntosporMenu), 1, 1);
        tabla.getModel().setValueAt(String.valueOf(Formulario.puntosporImporte), 2, 1);
        tabla.getModel().setValueAt(String.valueOf(Formulario.premioPuntosDesayuno),0,2);
        tabla.getModel().setValueAt(String.valueOf(Formulario.premioPuntosMenu),1,2);
        tabla.getModel().setValueAt(String.valueOf(Formulario.premioPuntosImporte),2,2);
        tabla.getModel().setValueAt(Formulario.PremioDesayunoF,0,3);
        tabla.getModel().setValueAt(Formulario.PremioDesayunoF,1,3);
        tabla.getModel().setValueAt(Formulario.PremioImporteF,2,3);
        
        
        TableColumn col1=tabla.getColumnModel().getColumn(1);
        col1.setCellEditor(new DefaultCellEditor(comboPuntos));
        TableColumn col2=tabla.getColumnModel().getColumn(2);
        col2.setCellEditor(new DefaultCellEditor(comboGeneradorPuntos));
        TableColumn col3=tabla.getColumnModel().getColumn(3);
        col3.setCellEditor(new DefaultCellEditor(comboPremios));
        
        scroll=new JScrollPane(tabla);
        
       
    	
		JButtonTrans MODIFICAR=  new JButtonTrans("MODIFICAR");	  
		MODIFICAR.setForeground(Color.black);
		JButtonTrans SALIR= new JButtonTrans("SALIR");
		SALIR.setForeground(Color.black);
		JButtonTrans CONSULTAR=new JButtonTrans("CONSULTAR");
		CONSULTAR.setForeground(Color.black);
		JPanel Botones;
		
		Botones=new JPanel(new FlowLayout(FlowLayout.LEFT,50,10));
	    Botones.setBackground(Color.WHITE);
	    Botones.add(MODIFICAR);
	    Botones.add(SALIR);
	    Botones.add(CONSULTAR);
	       
		
		  // Parametros de la ventana
	   JFrame frame = new JFrame("Configuracion Fidelizacion");
       
        frame.setLayout(new BorderLayout());
        frame.add(Botones);
        
     
        
       
        
        // Propiedades de la tabla
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.setFillsViewportHeight(true);        
        
        tabla.setModel(modelo);
        
        // Agregando elementos a la ventana
        frame.getContentPane().add(scroll, BorderLayout.NORTH);    
        frame.pack(); 
        frame.setVisible(true); 
		
       Basedatos.loadHSQLDB(); 
       Basedatos.connectDB(); 
       Basedatos.createStatement(); 
       Basedatos.ConfigurarPuntosFidelizacion();
       Basedatos.closeHSQLDB();
       
       
       
       
       SALIR.addActionListener(new ActionListener(){
       	   public void actionPerformed(ActionEvent e){
    		   frame.dispose();
    	     }
    	
         });
       
       MODIFICAR.addActionListener(new ActionListener(){
       	   public void actionPerformed(ActionEvent e){
       		String puntosporDesayuno= (String) tabla.getModel().getValueAt(0,1);
       		int puntosporDesayunoI=Integer.parseInt(puntosporDesayuno);
       		String puntosporMenu=(String) tabla.getModel().getValueAt(1,1);
       		int puntosporMenuI=Integer.parseInt(puntosporMenu);
       		String puntosporImporte=(String) tabla.getModel().getValueAt(2,1);
       		int puntosporImporteI=Integer.parseInt(puntosporImporte);
       		String seleccionadopuntosMenus=(String) tabla.getModel().getValueAt(0,2);
       		int seleccionadopuntosMenusI=Integer.parseInt(seleccionadopuntosMenus);
       	    String seleccionadopuntosDesayunos= (String) tabla.getModel().getValueAt(1,2);
       	    int seleccionadopuntosDesayunosI=Integer.parseInt(seleccionadopuntosDesayunos);
       		String seleccionadopuntosImportes= (String) tabla.getModel().getValueAt(2,2);
       		int seleccionadopuntosImportesI=Integer.parseInt(seleccionadopuntosImportes);
       		String seleccionadoPremiosMenu=(String) tabla.getModel().getValueAt(0,3);
       		String seleccionadoPremiosDesayunos=(String) tabla.getModel().getValueAt(1,3);
       		String seleccionadoPremiosImportes=(String) tabla.getModel().getValueAt(2,3);
       	    Basedatos.loadHSQLDB(); 
            Basedatos.connectDB(); 
            Basedatos.createStatement(); 
            Basedatos.insertTablaFidelizacion(seleccionadopuntosDesayunosI, seleccionadoPremiosDesayunos, seleccionadopuntosMenusI,
            seleccionadoPremiosMenu, seleccionadopuntosImportesI, seleccionadoPremiosImportes, 
            puntosporDesayunoI,puntosporMenuI,puntosporImporteI);
            Basedatos.closeHSQLDB();
            JOptionPane.showMessageDialog(frame, "Datos Modificados correctamente");
          }
    	
         });
         
          CONSULTAR.addActionListener(new ActionListener(){
       	   public void actionPerformed(ActionEvent e){
       		
            Basedatos.loadHSQLDB(); 
            Basedatos.connectDB(); 
            Basedatos.createStatement(); 
            Basedatos.ConsultaFidelizacion();
            Basedatos.closeHSQLDB();
          }
    	
         });
       }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	  static void ConfigurarArticulos(){
		  
		  
		  
		  
		  
		  
	  }

}
