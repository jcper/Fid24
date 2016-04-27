package es.fidelizacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class ConsultaRegalosPendientes extends JFrame {
	
	static JTable tabla = null;
    static DefaultTableModel modelo = null;
    static JScrollPane desplazamiento = null;
    static JButton Salir;
    static JPanel Botones;
    public ConsultaRegalosPendientes(){
    	 Salir=new JButton("Salir");
    	 Botones=new JPanel(new FlowLayout());
         Botones.add(Salir);
        
    	String[] columnas = {"Fecha","Desayunos","Menus","Importes"};
        tabla = new JTable();
        modelo = new DefaultTableModel();
        desplazamiento = new JScrollPane(tabla);
     // Parametros de la ventana
        this.setTitle("Tabla de Regalos Pendientes");
        this.setLayout(new BorderLayout());
        this.add(Botones);
        
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
        this.getContentPane().add(desplazamiento, BorderLayout.NORTH);    
        this.pack(); 
        this.setVisible(true); 
        Basedatos.loadHSQLDB(); 
        Basedatos.connectDB(); 
        Basedatos.createStatement();
        Basedatos.ConsultarTablaRegalosPendientes(ClienteAdministrador.IDFichaCliente);
        Basedatos.closeHSQLDB();
        
        Salir.addActionListener(new ActionListener(){
    	   public void actionPerformed(ActionEvent e){
    	       dispose();
    	   }
    	
        });
    
    }   

}
