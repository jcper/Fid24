package es.fidelizacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import es.fidelizacion.Formulario.TimerListener;



 public class PanelAdministrador extends JFrame implements ActionListener {
	
	static JFrame VentanaAdministrador;
	static JPanel pAdministrador;
	static JLabel CodigoAdministrador;
	static JTextField AreaCodigoAdministrador;
	static JButtonTrans Alta;
	static JButtonTrans Eliminar;
	static JButtonTrans Modificar;
	static JButtonTrans Consultar;
	static JButtonTrans Salir;
    static int CodigoBarras;
    static String Contraseña;
    static int Licencia;
    static String Fecha;
    static String Establecimiento;
    static String Nif;
    JButton teclado;
    JButton guardar;
    JButton cargar;
    JButton configuracion;
	ImageIcon Teclado;
	ImageIcon Guardar;
	ImageIcon Cargar;
	ImageIcon Fid24;
	ImageIcon Configuracion;
	ImageIcon Interrogacion;
	JLabel Logo;
	static JProgressBar progressBarRestaurar; 
	static JProgressBar progressBarBackup;
	Timer timeradministrador;
	
	
  public PanelAdministrador() {
	  timeradministrador=new Timer(1000,this);
	  Formulario.AreaCodigo.setEnabled(false);
	  progressBarRestaurar = new JProgressBar();
	  progressBarBackup=new JProgressBar();
	  Teclado=new ImageIcon("images/teclado48.png");
	  Guardar=new ImageIcon("images/guardar48.jpg");
	  Cargar=new ImageIcon("images/insertarArchivo48.png");
	  Fid24=new ImageIcon("images/logoFID64.png");
	  Configuracion=new ImageIcon("images/ConfiguracionAdministrador48.png");
	  Interrogacion=new ImageIcon("images/Interrogacion48.png");
	  Font fV = new Font("Verdana", Font.BOLD, 12);
	  Font fVTitulo = new Font("Verdana", Font.BOLD, 16);
	  JLabel Titulo=new JLabel("PANEL ADMINISTRADOR");
	  Logo=new JLabel();
	  Logo.setIcon(Fid24);
	  Titulo.setFont(fVTitulo);
	  teclado=new JButton();
	  guardar=new JButton();
	  cargar=new JButton();
	  configuracion=new JButton();
	  VentanaAdministrador=new JFrame("Panel de admninistrador");
	  CodigoAdministrador=new JLabel("Introduce el codigo del Cliente:");
	  CodigoAdministrador.setFont(fV);
	  AreaCodigoAdministrador= new JTextField();
	  Alta=new JButtonTrans("ALTA");
	  Alta.setFont(fV);
	  Alta.setForeground(Color.black);
	  Eliminar=new JButtonTrans("ELIMINAR");
	  Eliminar.setFont(fV);
	  Eliminar.setForeground(Color.black);
	  Modificar=new JButtonTrans("MODIFICAR");
	  Modificar.setFont(fV);
	  Modificar.setForeground(Color.black);
	  Consultar=new JButtonTrans("CONSULTAR");
	  Consultar.setFont(fV);
	  Consultar.setForeground(Color.black);
	  Salir=new JButtonTrans("SALIR");
	  Salir.setFont(fV);
	  Salir.setForeground(Color.black);
	  pAdministrador=new JPanel();//instacion un JPanel
	  VentanaAdministrador.setSize(800,600);
	  VentanaAdministrador.setResizable(false);
	  VentanaAdministrador.setVisible(true);
	  pAdministrador=(JPanel) VentanaAdministrador.getContentPane();//aqui hago un cast(JPanel)
	  pAdministrador.setLayout(null);
	  Titulo.setBounds(300,6, 250, 21);
	  CodigoAdministrador.setBounds(new Rectangle(5, 80,250, 21));
	  AreaCodigoAdministrador.setBounds(new Rectangle(220, 80, 400, 21));
	  VentanaAdministrador.setVisible(true);
	  teclado.setIcon(Teclado);
	  teclado.setBackground(Color.WHITE);
	  guardar.setIcon(Guardar);
	  guardar.setBackground(Color.WHITE);
	  cargar.setIcon(Cargar);
	  cargar.setBackground(Color.WHITE);
	  configuracion.setIcon(Configuracion);
	  configuracion.setBackground(Color.WHITE);
	  Alta.setBounds(350,150,150,21);
	  Eliminar.setBounds(350,230,150,21);
	  Modificar.setBounds(350,310,150,21);
	  Consultar.setBounds(350,390,150,21);
	  Salir.setBounds(350,470,150,21);
	  cargar.setBounds(740,5,48,48);
	  guardar.setBounds(680,5,48,48);
	  teclado.setBounds(620,5,48,48);
	  configuracion.setBounds(560,5,48,48);
	  Logo.setBounds(60,3,64,64);
	 
	  pAdministrador.add(Titulo);
	  pAdministrador.add(Logo);
	  pAdministrador.add(cargar);
	  pAdministrador.add(guardar);
	  pAdministrador.add(teclado);
	  pAdministrador.add(configuracion);
	  pAdministrador.add(CodigoAdministrador);
	  pAdministrador.add(AreaCodigoAdministrador);
	  pAdministrador.add(Alta);
	  pAdministrador.add(Eliminar);
	  pAdministrador.add(Consultar);
	  pAdministrador.add(Modificar);
	  pAdministrador.add(Salir);
	  pAdministrador.setBackground(Color.WHITE);
	  timeradministrador.start();
          
    
          
          
	  Alta.addActionListener(new ActionListener(){
   	   public void actionPerformed(ActionEvent e){
		   cliente.createAndShowGUI();
	   }
	
});
      Salir.addActionListener(new ActionListener(){
   	   public void actionPerformed(ActionEvent e){
		   VentanaAdministrador.dispose();
	   }
	
});
      Consultar.addActionListener(new ActionListener(){
      	   public void actionPerformed(ActionEvent e){
      		 if(AreaCodigoAdministrador.getText().equals("")){
          	   JOptionPane.showMessageDialog(VentanaAdministrador,
	      	"El campo Introduce el Codigo del cliente: esta en blanco","Error", JOptionPane.WARNING_MESSAGE,Formulario.IError);
          	  
            }
      		 
      		 Basedatos.loadHSQLDB(); 
             Basedatos.connectDB(); 
             Basedatos.createStatement();
             Basedatos.ValidarCodigoFichaCliente(AreaCodigoAdministrador.getText());
             Basedatos.Consultaclientes(AreaCodigoAdministrador.getText());
             ClienteAdministrador.ConsultarPuntosActuales.setEnabled(true);
      		 ClienteAdministrador.ConsultarPuntosConsumidos.setEnabled(true);
      		 ClienteAdministrador.ConsultarRegalosPendientes.setEnabled(true);
             Basedatos.closeHSQLDB();
             AreaCodigoAdministrador.setText("");
             AreaCodigoAdministrador.setEnabled(true);
             Alta.setEnabled(true);
    	   }
    	
    });
      Eliminar.addActionListener(new ActionListener(){
    	
     	   public void actionPerformed(ActionEvent e){
     		  
     		if(AreaCodigoAdministrador.getText().equals("")){
             	   JOptionPane.showMessageDialog(VentanaAdministrador,
   	         "El campo Introduce el Codigo del cliente: esta en blanco","Error", JOptionPane.WARNING_MESSAGE,Formulario.IError);
             	  
             }
     		
     		Basedatos.loadHSQLDB(); 
            Basedatos.connectDB(); 
            Basedatos.createStatement();
            Basedatos.Consultaclientes(AreaCodigoAdministrador.getText());
            Basedatos.ValidarCodigoFichaCliente(AreaCodigoAdministrador.getText());
            ClienteAdministrador.Eliminar.setEnabled(true);
            AreaCodigoAdministrador.setText("");
            AreaCodigoAdministrador.setEnabled(true);
            Alta.setEnabled(true);
      	   }
         
   });
      
      Modificar.addActionListener(new ActionListener(){
    	   public void actionPerformed(ActionEvent e){
    	   if(AreaCodigoAdministrador.getText().equals("")){
              	   JOptionPane.showMessageDialog(VentanaAdministrador,
    	      "El campo Introduce el Codigo del cliente: esta en blanco","Error", JOptionPane.WARNING_MESSAGE,Formulario.IError);
              	  
            } 
    		Basedatos.loadHSQLDB(); 
           Basedatos.connectDB(); 
           Basedatos.createStatement();
           Basedatos.Consultaclientes(AreaCodigoAdministrador.getText());
           Basedatos.ValidarCodigoFichaCliente(AreaCodigoAdministrador.getText());
             ClienteAdministrador.Texto_CodigoEtiqueta.setEnabled(true);
             ClienteAdministrador.Texto_NombreEtiqueta.setEnabled(true);
		     ClienteAdministrador.Texto_Apellido1Etiqueta.setEnabled(true);
		     ClienteAdministrador.Texto_Apellido2Etiqueta.setEnabled(true);
		     ClienteAdministrador.Texto_CodigoPostalEtiqueta.setEnabled(true);
		     ClienteAdministrador.Texto_EmailEtiqueta.setEnabled(true);
		     ClienteAdministrador.Texto_TelefonoEtiqueta.setEnabled(true);
           Basedatos.closeHSQLDB();
           AreaCodigoAdministrador.setText("");
           AreaCodigoAdministrador.setEnabled(true);
           Alta.setEnabled(true);
     	   }
        
  });
          teclado.addActionListener(new ActionListener(){
          	   public void actionPerformed(ActionEvent e){
        		   TecladoVirtual.Teclado();
        	   }
          }); 
          
          guardar.addActionListener(new ActionListener(){
         	   public void actionPerformed(ActionEvent e){
         		  int confirmado = JOptionPane.showConfirmDialog(null, "¿Deseas realizar una copia de seguridad?",null, 0, 0, Interrogacion);
                  if (JOptionPane.OK_OPTION == confirmado){
                	    Alta.setEnabled(false);
                		Eliminar.setEnabled(false);
                	    Modificar.setEnabled(false);
                		Consultar.setEnabled(false);
                		Salir.setEnabled(false);
                	    teclado.setEnabled(false);
                	    guardar.setEnabled(false);
                	    cargar.setEnabled(false);
                	   configuracion.setEnabled(false);
                	   
                	  Border border = BorderFactory.createTitledBorder("por favor espere,mientras se realiza la copia");
                      progressBarBackup.setBorder(border);
                      progressBarBackup.setBounds(600,150,150,40);
                      VentanaAdministrador.add( progressBarBackup);
                        GenerarBackup.backup();
                        Alta.setEnabled(true);
                		Eliminar.setEnabled(true);
                	    Modificar.setEnabled(true);
                		Consultar.setEnabled(true);
                		Salir.setEnabled(true);
                	    teclado.setEnabled(true);
                	    guardar.setEnabled(true);
                	    cargar.setEnabled(true);
                	   configuracion.setEnabled(true);
               
                  }
                  
         	   }
         	   
         }); 
          
          cargar.addActionListener(new ActionListener(){
        	   public void actionPerformed(ActionEvent e){
        		 int confirmado = JOptionPane.showConfirmDialog(null, "¿Deseas restaurar tu copia de seguridad?",null, 0, 0, Interrogacion);
                   if (JOptionPane.OK_OPTION == confirmado){
                	Alta.setEnabled(false);
               		Eliminar.setEnabled(false);
               	    Modificar.setEnabled(false);
               		Consultar.setEnabled(false);
               		Salir.setEnabled(false);
               	    teclado.setEnabled(false);
               	    guardar.setEnabled(false);
               	    cargar.setEnabled(false);
               	    configuracion.setEnabled(false);
               	   
                  Border border = BorderFactory.createTitledBorder("por favor espere,mientras se restaura la copia");
                       progressBarRestaurar.setBorder(border);
                       progressBarRestaurar.setBounds(600,150,150,40);
                       VentanaAdministrador.add( progressBarRestaurar);
                       RestaurarCopia.restore();
                       Alta.setEnabled(true);
               		  Eliminar.setEnabled(true);
               	      Modificar.setEnabled(true);
               		  Consultar.setEnabled(true);
               		  Salir.setEnabled(true);
               	      teclado.setEnabled(true);
               	      guardar.setEnabled(true);
               	      cargar.setEnabled(true);
               	      configuracion.setEnabled(true);
                 
                 }
              }
        }); 
          
          configuracion.addActionListener(new ActionListener(){
       	   public void actionPerformed(ActionEvent e){
     		   ConfigurarAdministrador.Configurar();
     		  
     	   }
       }); 
  }
  private void DetectarPuertoSerie(){
	  String caracteres=AreaCodigoAdministrador.getText();
	  if(caracteres.length()==13){
		  AreaCodigoAdministrador.setEnabled(false);
		  Alta.setEnabled(false);
		  PuertoSerie.LeerSerial.s="";
		}if(caracteres.length()>=14){
			AreaCodigoAdministrador.setText("");
			PuertoSerie.LeerSerial.s="";
       }
   }
   
   
	 
    
    public void actionPerformed(ActionEvent e) {
    	DetectarPuertoSerie();
		}

}
