package es.fidelizacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
public class ConsultasMenus extends JFrame {
	
	static JTable tabla = null;
    static DefaultTableModel modelo = null;
    static JScrollPane desplazamiento = null;
    static JButtonTrans Salir;
    static JButtonTrans Exportar;
    static JPanel Botones;
    public ConsultasMenus(){
    	 Salir=new JButtonTrans("Salir");
    	 Exportar=new JButtonTrans("Exportar Excel");
    	 Botones=new JPanel(new FlowLayout());
         Botones.add(Salir);
         Botones.add(Exportar);
         
        
    	String[] columnas = {"ID Cliente","Puntos_Actuales","Regalos Actuales","Premios Consumidos"};
        tabla = new JTable();
        modelo = new DefaultTableModel();
        desplazamiento = new JScrollPane(tabla);
       
       
     // Parametros de la ventana
        this.setTitle("Tabla de Clientes");
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
        Basedatos.ConsultarTablasMenus();
        Basedatos.closeHSQLDB();
        
        Salir.addActionListener(new ActionListener(){
    	   public void actionPerformed(ActionEvent e){
    	       dispose();
    	   }
    	
        });
        
        Exportar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }

    		private void jButton1ActionPerformed(ActionEvent evt) {
    			  if (tabla.getRowCount() > 0) {
    		            JFileChooser chooser = new JFileChooser();
    		            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
    		            chooser.setFileFilter(filter);
    		            chooser.setDialogTitle("Guardar archivo");
    		            chooser.setAcceptAllFileFilterUsed(false);
    		            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
    		                List<JTable> tb = new ArrayList<JTable>();
    		                List<String> nom = new ArrayList<String>();
    		                tb.add(tabla);
    		                nom.add("Listado");
    		                String file = chooser.getSelectedFile().toString().concat(".xls");
    		                try {
    		                    Exportar e = new Exportar(new File(file), tb, nom);
    		                    if (e.export()) {
    		                        JOptionPane.showMessageDialog(null, "Los datos fueron exportados a excel en el directorio seleccionado", "Mensaje de Informacion", JOptionPane.INFORMATION_MESSAGE);
    		                    }
    		                } catch (Exception e) {
    		                    JOptionPane.showMessageDialog(null, "Hubo un error " + e.getMessage(), " Error", JOptionPane.ERROR_MESSAGE);
    		                }
    		            }
    		        }else{
    		            JOptionPane.showMessageDialog(null, "No hay datos para exportar","Mensaje de error",JOptionPane.ERROR_MESSAGE);
    		        }   
    		    }

    	});
        
    
    }   

}



