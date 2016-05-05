package es.fidelizacion;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class PanelFidelizacion extends JFrame implements ActionListener  {
   static private String Art1="ARTICULO 1";
   static private String Art2="ARTICULO 2";
   static private String Import="IMPORTES";
   static String[] labelsFidelizacion = {Art1,Art2,Import};
   static int numPairs1 = labelsFidelizacion.length;
   static String[] labelsPremios={"Tipo Premios Menu: ","Tipo Premios Desayunos: ","Tipo Premios Importes"};
   static int numPairs2= labelsPremios.length;
   static String[] labelsPuntos={"Desayuno Puntos: ", "Menu Puntos: ", "Importe Puntos: "};
   static int numPairs3= labelsPuntos.length;
   static String[] puntos ={ "0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
   static String[] PremiosPuntos={"0","10","20","30","40","50","60","70","80","90","100","200","300","400","500","600","700","800","900","1000"};
   static String[] Premios ={"0","1 menu","2 menus","3 menus","4 menus","5 menus", "1 desayuno","2 desayunos","3 desayunos","4 desayunos",
	    "5 desayunos", "5% descuento", "10% descuento", "15% descuento", "20% descuento","25% descuento"};
   static JComboBox comboPuntos[]= new JComboBox[numPairs1];
   static JComboBox comboPremios[]=new JComboBox[numPairs2];
   static JComboBox comboGeneradorPuntos[]=new JComboBox[numPairs3];
  
   
  
   /**
    * Create the GUI and show it.  For thread safety,
    * this method should be invoked from the
    * event-dispatching thread.
    */
       static void ConfigurarFidelizacion()  {
       
		JButtonTrans MODIFICAR=  new JButtonTrans("MODIFICAR");	  
		MODIFICAR.setForeground(Color.black);
		JButtonTrans SALIR= new JButtonTrans("SALIR");
		SALIR.setForeground(Color.black);
		JButtonTrans CONSULTAR=new JButtonTrans("CONSULTAR");
		CONSULTAR.setForeground(Color.black);
		JPanel Botones;
		
		SpringLayout layout;
		
		
		
		JLabel nombre = new JLabel("NOMBRE");
		JLabel puntosxarticulo = new JLabel("PUNTOS");
		JLabel limite = new JLabel("LIMITE");
		JLabel premio= new JLabel("PREMIO");
    
       //Create and populate the panel.
	   layout= new SpringLayout();
	   JPanel pCampos = new JPanel(layout);
	   pCampos.setBackground(Color.WHITE);
	   
       JPanel pPuntos = new JPanel(layout);
       pPuntos.setBackground(Color.WHITE);
       JPanel pPremios= new JPanel(layout);
       pPremios.setBackground(Color.WHITE);
       JPanel pGenerador=new JPanel(layout);
       pGenerador.setBackground(Color.WHITE);
       for (int i = 0; i <numPairs1; i++) {
             JTextField text = new JTextField();
             text.setText(labelsFidelizacion[i]);
            pCampos.add(text);
            
         }
       for (int i = 0; i <numPairs1; i++) {
         comboPuntos[i] = new JComboBox(PremiosPuntos);
          pPuntos.add(comboPuntos[i]);
       }
      for (int i = 0; i < numPairs2; i++){ 
    	   comboPremios[i] = new JComboBox(Premios);
           pPremios.add(comboPremios[i]);
       }
    
       for (int i = 0; i < numPairs3; i++) {
          comboGeneradorPuntos[i] = new JComboBox(puntos);
          pGenerador.add(comboGeneradorPuntos[i]);
       }
        
       
      
       
       
        Botones=new JPanel(new FlowLayout(FlowLayout.LEFT,50,10));
        Botones.setBackground(Color.WHITE);
        Botones.add(MODIFICAR);
        Botones.add(SALIR);
        Botones.add(CONSULTAR);
       
       
       
       //Layout the panel.
       SpringUtilities.makeCompactGrid(pPuntos,numPairs1,1,6,6,6,6);//xPad, yPad
       SpringUtilities.makeCompactGrid(pPremios,numPairs2,1,6,6,6,6);//xPad, yPad
       SpringUtilities.makeCompactGrid(pGenerador,numPairs3,1,6,6,6,6);//xPad, yPad
       SpringUtilities.makeCompactGrid(pCampos,numPairs3,1,6,6,6,6);//xPad, yPad
       JFrame frame = new JFrame("Fidelizacion");
       
       frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
       frame.setBackground(Color.WHITE);
       JPanel Panel1=new JPanel(new FlowLayout(FlowLayout.LEFT,25,0));
       Panel1.setBackground(Color.WHITE);
       JPanel PanelE=new JPanel(new FlowLayout(FlowLayout.LEFT,50,0));
       PanelE.setBackground(Color.WHITE);
       PanelE.add(nombre);
       PanelE.add(puntosxarticulo);
       PanelE.add(limite);
       PanelE.add(premio);
       Panel1.add(pCampos);
       Panel1.add(pGenerador);
       Panel1.add(pPuntos);
       Panel1.add(pPremios);
       Panel1.add(Botones);
       frame.add(PanelE);
       frame.add(Panel1);
       frame.setResizable(false);
       
       
       //Display the window.
       frame.setVisible(true);
       frame.setSize(500,250);
       
       Basedatos.loadHSQLDB(); 
       Basedatos.connectDB(); 
       Basedatos.createStatement(); 
       Basedatos.ConfigurarPuntosFidelizacion();
       Basedatos.closeHSQLDB();
       
       comboGeneradorPuntos[0].setSelectedItem(String.valueOf(Formulario.puntosporDesayuno));
       comboGeneradorPuntos[1].setSelectedItem(String.valueOf(Formulario.puntosporMenu));
       comboGeneradorPuntos[2].setSelectedItem(String.valueOf(Formulario.puntosporImporte));
       comboPuntos[0].setSelectedItem(String.valueOf(Formulario.premioPuntosMenu));
       comboPuntos[1].setSelectedItem(String.valueOf(Formulario.premioPuntosDesayuno));
       comboPuntos[2].setSelectedItem(String.valueOf(Formulario.premioPuntosImporte));
       comboPremios[0].setSelectedItem(Formulario.PremioMenuF);
       comboPremios[1].setSelectedItem(Formulario.PremioDesayunoF);
       comboPremios[2].setSelectedItem(Formulario.PremioImporteF);
       
       SALIR.addActionListener(new ActionListener(){
       	   public void actionPerformed(ActionEvent e){
    		   frame.dispose();
    	     }
    	
         });
       
       MODIFICAR.addActionListener(new ActionListener(){
       	   public void actionPerformed(ActionEvent e){
       		String puntosporDesayuno=(String) comboGeneradorPuntos[0].getSelectedItem();
       		int puntosporDesayunoI=Integer.parseInt(puntosporDesayuno);
       		String puntosporMenu=(String) comboGeneradorPuntos[1].getSelectedItem();
       		int puntosporMenuI=Integer.parseInt(puntosporMenu);
       		String puntosporImporte=(String)comboGeneradorPuntos[2].getSelectedItem();
       		int puntosporImporteI=Integer.parseInt(puntosporImporte);
       		String seleccionadopuntosMenus=(String)comboPuntos[0].getSelectedItem();
       		int seleccionadopuntosMenusI=Integer.parseInt(seleccionadopuntosMenus);
       	    String seleccionadopuntosDesayunos= (String)comboPuntos[1].getSelectedItem();
       	    int seleccionadopuntosDesayunosI=Integer.parseInt(seleccionadopuntosDesayunos);
       		String seleccionadopuntosImportes= (String)comboPuntos[2].getSelectedItem();
       		int seleccionadopuntosImportesI=Integer.parseInt(seleccionadopuntosImportes);
       		String seleccionadoPremiosMenu=(String)comboPremios[0].getSelectedItem();
       		String seleccionadoPremiosDesayunos=(String)comboPremios[1].getSelectedItem();
       		String seleccionadoPremiosImportes=(String)comboPremios[2].getSelectedItem();
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
