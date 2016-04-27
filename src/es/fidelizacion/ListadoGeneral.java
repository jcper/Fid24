package es.fidelizacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ListadoGeneral extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JTable tabla = null;
    static DefaultTableModel modelo = null;
    static JScrollPane desplazamiento = null;
    static JButtonTrans Salir;
    static JButtonTrans Exportar;
    static JPanel Botones;
    JPanel Claves;
    JLabel BuscarFecha;
    JLabel clave00;
    JLabel clave01;
    JLabel clave02;
    JLabel claveID;
    public ListadoGeneral(){
     BuscarFecha=new JLabel("Buscar entre fechas: ");
     clave00=new JLabel("00=Consumidos");
     clave01=new JLabel("01=Obtenidos");
     clave02=new JLabel("02=Anulados");
     claveID=new JLabel("ID(1...1000)");
   	 Salir=new JButtonTrans("Salir");
	 Salir.setForeground(Color.black);
	 Exportar=new JButtonTrans("Exportar a excel");
	 Exportar.setForeground(Color.black);
	
	 Claves=new JPanel(new FlowLayout());
	 Botones=new JPanel(new FlowLayout());
     Botones.add(Salir);
     Botones.add(Exportar);
     Claves.add(clave00);
	 Claves.add(clave01);
	 Claves.add(clave02);
	 Claves.add(claveID);
    
	String[] columnas = {"Fecha Operacion","Codigo","ID Cliente","Tabla Puntos","Tipo Operacion","Cantidad"};
    tabla = new JTable();
    
	
    modelo = new DefaultTableModel(){
	 public Class getColumnClass(int column) {
        Class returnValue;
        if ((column >= 0) && (column < getColumnCount())) {
          returnValue = getValueAt(0, column).getClass();
        } else {
          returnValue = Object.class;
        }
        return returnValue;
      }
    };
    
    desplazamiento = new JScrollPane(tabla);
    // Parametros de la ventana
    this.setTitle("Registro Diario");
    this.setLayout(new BorderLayout());
    // Modelo de la tabla
    modelo.setColumnIdentifiers(columnas);
    
    // Barras de desplazamiento
    desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
    // Propiedades de la tabla
    tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    tabla.setFillsViewportHeight(true);        
    tabla.setModel(modelo);
	final TableRowSorter<TableModel> sorter =
            new TableRowSorter<TableModel>(modelo);
    tabla.setRowSorter(sorter);
	JPanel panel = new JPanel(new BorderLayout());
	JPanel fecha = new JPanel(new FlowLayout());
	
	panel.add(Claves, BorderLayout.WEST);
    final JTextField filterText =new JTextField();
    panel.add(filterText, BorderLayout.CENTER);
    this.add(panel, BorderLayout.NORTH);
    JButton button = new JButton("Buscar");
    JButton button1fecha = new JButton("Buscar");
    panel.add(button, BorderLayout.EAST);
    JDateChooser dateChooser_1 = new JDateChooser();
	fecha.add(BuscarFecha);
	fecha.add(dateChooser_1);
	fecha.add(button1fecha);
    panel.add(fecha,BorderLayout.SOUTH);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String text = filterText.getText();
   	    
        if (text.length() == 0) {
          sorter.setRowFilter(null);
        } else {
          try {
        	  if(text!="0"){
            sorter.setRowFilter(
             RowFilter.regexFilter(text,2));
            		}
        	if(text.equals("00")){
            sorter.setRowFilter(
             RowFilter.regexFilter("Consumidos",4));
                    }
        	if(text.equals("02")){
                sorter.setRowFilter(
               RowFilter.regexFilter("Anulados",4));
              }
        	if(text.equals("01")){
                sorter.setRowFilter(
               RowFilter.regexFilter("Obtenidos",4));
              }
          } catch (PatternSyntaxException pse) {
            System.err.println("Bad regex pattern");
          }
        }
      }
    });
    button1fecha.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
            String fechamysql=dt1.format(dateChooser_1.getDate());
       	   System.out.print(fechamysql);
            if (fechamysql.equals("")) {
              sorter.setRowFilter(null);
            } else {
              try {
                sorter.setRowFilter(
                		RowFilter.regexFilter(fechamysql));
                    
              } catch (PatternSyntaxException pse) {
                System.err.println("Bad regex pattern");
              }
            }
          }
        });
    // Agregando elementos a la ventana
    this.getContentPane().add(Botones, BorderLayout.SOUTH);  
    this.getContentPane().add(desplazamiento, BorderLayout.CENTER);    
    this.pack(); 
    this.setVisible(true); 
    Basedatos.loadHSQLDB(); 
    Basedatos.connectDB(); 
    Basedatos.createStatement();
    Basedatos.ConsultarRegistoDiario();
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