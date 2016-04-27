package es.fidelizacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ConsultaPuntosActualesDiarios extends JFrame {
	
	static JTable tabla = null;
    static DefaultTableModel modelo = null;
    static JScrollPane desplazamiento = null;
    static JButtonTrans Salir;
    static JPanel Resumen;
    static JPanel Botones;
    JLabel Fecha;
    JLabel Desayunos;
    JLabel Menus;
    JLabel Importes;
    
   
    public ConsultaPuntosActualesDiarios(){
    	 Salir=new JButtonTrans("Salir");
    	 Botones=new JPanel(new FlowLayout());
         Botones.add(Salir);
    	 Fecha=new JLabel();
    	 Desayunos=new JLabel();
    	 Menus=new JLabel();
    	 Importes=new JLabel();
    	 Resumen=new JPanel(new FlowLayout());
    	 Resumen.add(Fecha);
    	 Resumen.add(Desayunos);
    	 Resumen.add(Menus);
         Resumen.add(Importes);
         
    	String[] columnas = {"Fecha","Desayunos","Menus","Importes"};
        tabla = new JTable();
        modelo = new DefaultTableModel();
        desplazamiento = new JScrollPane(tabla);
       
       
     // Parametros de la ventana
        this.setTitle("Tabla de Puntos Actuales Diarios");
     
        this.setLayout(new BorderLayout());
        this.add(Resumen);
       
        
        
        // Modelo de la tabla
        modelo.setColumnIdentifiers(columnas);
        
        // Barras de desplazamiento
        desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        // Propiedades de la tabla
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.setFillsViewportHeight(true);        
        
        tabla.setModel(modelo);
        
        // Agregando elementos a la ventana
        this.getContentPane().add(Resumen, BorderLayout.NORTH);    
        this.getContentPane().add(desplazamiento, BorderLayout.CENTER);    
        this.getContentPane().add(Botones, BorderLayout.SOUTH);    
        this.pack(); 
        this.setVisible(true);
        Basedatos.loadHSQLDB(); 
        Basedatos.connectDB(); 
        Basedatos.createStatement();
        Basedatos.ConsultarTablaDiaria(ClienteAdministrador.IDFichaCliente);
        sumar();
        Basedatos.closeHSQLDB();
        
        
        Salir.addActionListener(new ActionListener(){
    	   public void actionPerformed(ActionEvent e){
    	       dispose();
    	   }
    	
        });
    
    }   
          public void sumar(){

    	//AQUI SE SUMAN LOS VALORES DE CADA FILA PARA COLOCARLO EN EL CAMPO DE TOTAL
    	        
    	        int totalRow= tabla.getRowCount();
    	        totalRow-=1; 
    	        int sumaDesayunos=0;
    	        int sumaMenus=0;
    	        int sumaImportes=0;
    	        int sumaTdesayunos=0;
    	        int sumaTmenus=0;
    	        int sumaTimportes=0;
    	        
    	        for(int i=0;i<=(totalRow);i++)
    	        {
    	             sumaDesayunos= Integer.parseInt(String.valueOf(tabla.getValueAt(i,1)));
    	             sumaMenus= Integer.parseInt(String.valueOf(tabla.getValueAt(i,2)));
    	             sumaImportes= Integer.parseInt(String.valueOf(tabla.getValueAt(i,3)));
    	             sumaTdesayunos=sumaTdesayunos+sumaDesayunos;
    	    	     sumaTmenus= sumaTmenus+sumaMenus;   
    	    	     sumaTimportes=sumaTimportes+sumaImportes;

    	         }
    	       
    	        Fecha.setText("Fecha:"+Formulario.FechaEntradaMysql);
    	        Desayunos.setText("Desayunos:"+sumaTdesayunos);
    	    	Menus.setText("Menus:"+sumaTmenus);
    	    	Importes.setText("Importes:"+sumaTimportes);
    	        
     	   }

}