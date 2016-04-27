package es.fidelizacion;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import java.util.*;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FidelizacionAdministrador extends JFrame  {
	
	 static JLabel PuntosMenu;
     static JLabel DesayunoPuntos;
     static JLabel ImportesPuntos; 
     static JLabel puntosporDesayuno;
     static JLabel puntosporMenu;
     static JLabel puntosporImporte;
     static JLabel TipoPremiosMenu;
     static JLabel TipoPremiosDesayunos;
     static JLabel TipoPremiosImportes;
     static JButton Salir;
     
     static void ConsultarFidelizacion(int MenuPuntos, String TipoPremiosM, int PuntosDesayunos,String TipoPremiosD, 
    		 int PuntosImportes,String TipoPremiosI,int puntospordesayuno, int puntospormenu, int puntosporimporte
    		 )
    		 
    		 {
    	       String PuntosporD=String.valueOf(puntospordesayuno);
    	       String PuntosporM=String.valueOf(puntospormenu);
    	       String PuntosporI=String.valueOf(puntosporimporte);
    	       String PuntosM=String.valueOf(MenuPuntos);
    	       String PuntosD=String.valueOf(PuntosDesayunos);
    	       String PuntosI=String.valueOf(PuntosImportes);
    	       puntosporDesayuno=new JLabel("Desayuno puntos: " + PuntosporD);
    	       puntosporMenu=new JLabel("Menu puntos: " + PuntosporM);
    	       puntosporImporte=new JLabel("Importe puntos: " + PuntosporI);
    	       PuntosMenu=new JLabel("Menu premio puntos: " + PuntosM);
    	       DesayunoPuntos=new JLabel("Desayuno premio puntos: " + PuntosD);
    	       ImportesPuntos=new JLabel("Importes premio puntos:"+PuntosI);
    	       TipoPremiosMenu=new JLabel("Tipo Premios Menu: "+TipoPremiosM);
    	       TipoPremiosDesayunos=new JLabel("Tipo Premios Desayunos: "+TipoPremiosD);
    	       TipoPremiosImportes=new JLabel("Tipo Premios Importes: "+TipoPremiosI);
    	       Salir=new JButton("SALIR");
    	        
    	        JPanel p = new JPanel();
    	        JPanel botones=new JPanel();
    	        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
    	        p.add( puntosporDesayuno);
    	        p.add( puntosporMenu);
    	        p.add(puntosporImporte);
    	        p.add(PuntosMenu);
    	        p.add(TipoPremiosMenu);
    	        p.add(DesayunoPuntos);
    	        p.add(TipoPremiosDesayunos);
    	        p.add(ImportesPuntos);
    	        p.add(TipoPremiosImportes);
    	        botones.setLayout(new FlowLayout(FlowLayout.CENTER));
    	        botones.add(Salir);
    	        JFrame frame = new JFrame("Panel Consulta Fidelizacion");
    	        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
    	        frame.add(p);
    	        frame.add(botones);
    	        frame.setResizable(false);
    	      
    	        
    	       

    	        //Display the window.
    	      
    	        frame.setVisible(true);
    	        frame.setSize(400,400);
    	        Salir.addActionListener(new ActionListener(){
    	     	   public void actionPerformed(ActionEvent e){
    	    		   frame.dispose();
    	    	   }
    	    });
    	        
   }
	
	

}
