package es.fidelizacion;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.MenuItemUI;
import javax.swing.plaf.basic.BasicButtonUI;

import java.awt.event.*;
import java.io.IOException;

public class Formulario extends JFrame implements ActionListener, ChangeListener {

	static JFrame ventana;
	static JPanel p;
	JLabel Codigo;
	static JLabel SaldoTotal;
	static JLabel PremiosActuales;
	static JTextField AreaCodigo; 
	static JLabel IdCliente;
	static JLabel Nombre;
	static JLabel Apellido1;
	static String NombreCliente;
	static String Apellido1Cliente;
	JLabel SaldoActual;
    static JButtonTrans Actualizar;
    static JButtonTrans Aceptar;
    JButtonTrans Anular;
    static JButtonTrans Cancelar;
    static Fecha FechaActual;
    static Fecha FechaActualMysql;
	static JMenuItem elementoFormulario;
	static JMenuItem elementoPuntos;
	static JMenuItem elementoConsultas;
	static JMenuBar  BarraDeMenu;
	static JMenu menuFormulario;
	static JMenu menuFormulario1;
	static JMenu menuFormulario2;
	static JMenu menuFormulario3;
	static JMenu menuFormulario4;
    public static Timer timer;
    public static Timer BotonActualizar;
	static JLabel Fecha;
	static int DiasDemo;
	static String Premios;//variables  para guardar campo premios
	static String PuntosTotales;//variables  puntostotales de saldototal
	static String IDclientePantalla;//variable  idclientePantalla, idclientebasedatos
	static String FechaEntradaMysql;
	static JLabel SaldoImporte;
	static JLabel PremioImporte;
    static JLabel Time;
    static JLabel SaldoActualI;
    static JLabel PremiosI;
	static JLabel Factura_Ticket;
    static JLabel texto_Incremento;
	static JTextField texto_Factura_Ticket;
	static JLabel texto_SaldoActualI;
	static JLabel texto_PremiosI;
	static JRadioButton Venta;
	static JLabel Incremento;
	static JButtonTrans CONSUMIRPREMIOSIMPORTE;
	static JButtonTrans Teclado;
	JButtonTrans Minimizar;
	JButtonTrans ImprimirSaldo;
	static JButtonTrans Configuracion;
	static int puntosporImporte;
	static String PremioImporteF;
	static int premioPuntosImporte;
	static int restar_puntos_consumirpremiosimporte;
	static String UltimaOperacion;
	static String TipoUltimaOperacion;
	static String TipoUltimaOperacionPremio;
	static String UltimaOperacionPremio;
	static String TipoUltimaOperacionPremioConsumido;
	static String UltimaOperacionPremioConsumido;
	ImageIcon Iclientes;
	ImageIcon Ihome;
	ImageIcon IFidelizacion;
	ImageIcon IConsulta;
	ImageIcon Iinformacion;
	ImageIcon ILogo;
	ImageIcon Imprimir;
	JLabel Logo;
	ImageIcon Iminimizar;
	ImageIcon Iconfiguracion;
	ImageIcon Isalir;
	JLabel salir;
	static ImageIcon Idemo;
	static ImageIcon AlarmaPremio;
	static ImageIcon IError;
	ImageIcon ITeclado;
	static private String Fecha_AnteriorMysql;
	static boolean detectadoPuertoserie;
	static boolean detectadoCodigoBarras;
	static boolean EstadoTeclado;
	
	
	
   
         public Formulario() {
        	EstadoTeclado=true;
        	detectadoPuertoserie=true;
        	detectadoCodigoBarras=true;
		    Iclientes=new ImageIcon("images/clientes16.png");
		    Ihome=new ImageIcon("images/Home16.png");
		    IFidelizacion=new ImageIcon("images/calculadora16.png");
		    IConsulta=new ImageIcon("images/ConsultaDatos.png");
		    Iinformacion=new ImageIcon("images/Informacion16.png");
		    AlarmaPremio=new ImageIcon("images/campana48.png");
		    IError=new ImageIcon("images/Error48.png");
		    ILogo=new ImageIcon("images/logoFID48.png");
		    Iminimizar=new ImageIcon("images/minimizar64.png");
		    Iconfiguracion=new ImageIcon("images/configure364.png");
		    Ihome=new ImageIcon("images/Home16.png");
			Idemo=new ImageIcon("images/demo48.png");
			Isalir=new ImageIcon("images/salir48.png");
			ITeclado=new ImageIcon("images/teclado48.png");
			Imprimir=new ImageIcon("images/imprimir48.jpg");
			salir=new JLabel();
			salir.setIcon(Isalir);
		    Logo=new JLabel();
            Font fV = new Font("Verdana", Font.BOLD, 12);
            Font FM=new Font("MONOSPACED", Font.PLAIN, 12);
		    timer=new Timer(100,this);
		    Premios="";
		    PuntosTotales="";
		    IDclientePantalla="";
		    ventana=new JFrame("Pantalla de Fidelizacion de Clientes");
		    BarraDeMenu=new JMenuBar();
		    FechaActual=new Fecha();
		    FechaActualMysql=new Fecha();
		    AreaCodigo=new JTextField();
		    Fecha=new JLabel(FechaActual.getFecha());
			Time=new JLabel(FechaActual.getTime());
			FechaEntradaMysql=FechaActual.getFechamysql();
		    JLabel Titulo=new JLabel("FID24  SOFTWARE DE FIDELIZACION");
		    JLabel Titulo1=new JLabel("PROGRAMA DE PUNTOS");
		    Titulo1.setFont(fV);
		    Titulo.setFont(fV);
		    Incremento=new JLabel("INCREMENTO SALDO");
		    Incremento.setFont(FM);
		    Codigo=new JLabel("Introduzca el codigo: ");
		    Codigo.setFont(fV);
		    PremiosActuales=new JLabel();
		    PremiosActuales.setFont(fV);
		    IdCliente =  new JLabel();
		    IdCliente.setFont(fV);
		    SaldoActualI=  new JLabel(" PUNTOS ");
		    SaldoActualI.setFont(FM);

		    JLabel Comidas_desayunos= new JLabel("Nº MENUS O DESAYUNOS");
		    Comidas_desayunos.setFont(fV);
		  
		     Venta = new JRadioButton("IMPORTES");
		     Venta.setFont(FM);
		     Venta.setEnabled(false);
		    PremiosI = new JLabel("PREMIOS ");
		    PremiosI.setFont(FM);
		    Fecha=new JLabel("Fecha entrada: "+FechaActual.getFecha());
		    Fecha.setFont(FM);
		    Time=new JLabel("Hora entrada: "+FechaActual.getTime());
		    Time.setFont(FM);
		    JButtonTrans BORRAR =  new JButtonTrans("BORRAR");
		    BORRAR.setFont(fV);
		    BORRAR.setForeground(Color.black);
		    JButtonTrans ANULAR =  new JButtonTrans("ANULAR");
		    ANULAR.setFont(fV);
		    ANULAR.setForeground(Color.black);
			JButtonTrans GUARDAR=  new JButtonTrans("GUARDAR");
			GUARDAR.setFont(fV);
			GUARDAR.setForeground(Color.black);
			JButtonTrans SALIR= new JButtonTrans("SALIR");
			SALIR.setFont(fV);
			SALIR.setForeground(Color.black);
		    Cancelar= new JButtonTrans("Desactivar");
			Cancelar.setFont(fV);
		    Cancelar.setForeground(Color.black);
		    Actualizar=new JButtonTrans("ACTUALIZAR");
			Actualizar.setFont(fV);
			Actualizar.setForeground(Color.black);
		    Aceptar=new JButtonTrans("ACEPTAR");
			Aceptar.setFont(fV);
			Aceptar.setForeground(Color.black);
			Aceptar.setEnabled(false);
		    CONSUMIRPREMIOSIMPORTE=new JButtonTrans("CONSUMIR");
		    CONSUMIRPREMIOSIMPORTE.setFont(fV);
		    CONSUMIRPREMIOSIMPORTE.setForeground(Color.black);
		    Minimizar=new JButtonTrans();
		    Minimizar.setIcon(Iminimizar);
		    Configuracion=new JButtonTrans();
		    Configuracion.setIcon(Iconfiguracion);
		    Configuracion.setEnabled(false);
		    Teclado=new JButtonTrans();
		    Teclado.setIcon(ITeclado);
		    ImprimirSaldo=new JButtonTrans();
		    ImprimirSaldo.setIcon(Imprimir);
			Factura_Ticket= new JLabel("Factura/Ticket Compra(Importes)");
			Factura_Ticket.setFont(FM);
		    texto_Incremento= new JLabel("0");
		    texto_Incremento.setEnabled(false);
			texto_Factura_Ticket= new JTextField();
			texto_Factura_Ticket.setEnabled(false);
		    texto_SaldoActualI=new JLabel();
		 
		    texto_PremiosI=new JLabel();
		   
		    SaldoImporte=new JLabel();
		 
		    PremioImporte=new JLabel();
		    Nombre=new JLabel();
		    Nombre.setFont(fV);
		    Apellido1=new JLabel();
		    Apellido1.setFont(fV);
			
		 p=new JPanel();//instacion un JPanel
		 Titulo.setBounds(new Rectangle(260, 40, 500, 21));
		 Logo.setBounds((new Rectangle(60, 10, 50, 50)));
		 Logo.setIcon(ILogo);
		 Configuracion.setBounds(700, 7, 64,64);
		 Minimizar.setBounds(620,7, 64, 64);
		 AreaCodigo.setBounds(new Rectangle(190, 60, 400, 21));
		 ventana.setSize(800,600);
		 ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 ventana.setExtendedState(ICONIFIED);
		 p=(JPanel) ventana.getContentPane();//aqui hago un cast(JPanel)
		 p.setLayout(null);
		 Codigo.setBounds(new Rectangle(40, 60, 220, 21));
		 Actualizar.setBounds(new Rectangle(300,90, 200, 21));
		 Fecha.setBounds(40, 90, 200, 21);
		 Time.setBounds(40, 110, 200, 21);
		 SaldoActualI.setBounds(new Rectangle (100, 260, 100, 21));
		 texto_SaldoActualI.setBounds(new Rectangle(115, 280, 50, 21));
		 Titulo1.setBounds(310,200, 200, 21);
		 Incremento.setBounds(275,435,200,21);
		 texto_Incremento.setBounds(new Rectangle(400,435,50,21));
		 Venta.setBounds(100,230,100,21);
		 Venta.setBackground(Color.WHITE);
		 Venta.addChangeListener(this);
	
		 PremiosI.setBounds(100,310,200,21);
		 texto_PremiosI.setBounds(new Rectangle(155, 310,50, 21));
		 Cancelar.setBounds(80,370,120,15);
		 Cancelar.setEnabled(false);
		
		 Factura_Ticket.setBounds(100,460,300,21);
		 texto_Factura_Ticket.setBounds(340, 460, 200, 21);
		 Aceptar.setBounds(550, 460, 100, 21);
		 ImprimirSaldo.setBounds(630,260,64,64);
		 BORRAR.setBounds(new Rectangle(250,500,100,21));
		 GUARDAR.setBounds(new Rectangle(450,500,100,21));
		 SALIR.setBounds(new Rectangle(650,500,100,21));
		 ANULAR.setBounds(new Rectangle(50,500,100,21));
		 Comidas_desayunos.setBounds(290,350,400,21);
		
		
		
		 Teclado.setBounds(620,370,64,64);
		 IdCliente.setBounds(new Rectangle (80, 130, 220, 21));
		 IdCliente.setVisible(false);
		 Nombre.setBounds(new Rectangle (80, 150, 220, 21));
		 Nombre.setVisible(false);
		 Apellido1.setBounds(new Rectangle (80, 170, 220, 21));
		 Apellido1.setVisible(false);
	   
	     SaldoImporte.setBounds(300,130,200,21);
	     SaldoImporte.setVisible(false);
	
		 PremioImporte.setBounds(520,130,300,21);
		 PremioImporte.setVisible(false);
		
		 CONSUMIRPREMIOSIMPORTE.setBounds(520,160,150,21);
		 CONSUMIRPREMIOSIMPORTE.setVisible(false);
		 p.add(Codigo);
		 p.add(AreaCodigo);
		 p.add(SaldoActualI);
		 p.add(texto_SaldoActualI);
	
		 p.add(Venta);
		
		 p.add(PremiosI);
		 p.add(texto_PremiosI);
		
		 p.add(GUARDAR);
		 p.add(BORRAR);
		 p.add(SALIR);
		 p.add(ANULAR);
		 p.add(Titulo);
		 p.add(Titulo1);
		 p.add(Incremento);
		 p.add(texto_Incremento);
		 p.add(Factura_Ticket);
		 p.add(texto_Factura_Ticket);
		 p.add(Comidas_desayunos);
	
		 p.add(Fecha);
		 p.add(Time);
		 p.add(Actualizar);
		 p.add(IdCliente);
		 p.add(Nombre);
		 p.add(Apellido1);
	
		 p.add(SaldoImporte);
		
		 p.add(PremioImporte);
		
		 p.add(CONSUMIRPREMIOSIMPORTE);
		 p.setBackground(Color.WHITE);
		 p.add(Logo);
		 p.add(Aceptar);
		 p.add(Cancelar);
		 p.add(Minimizar);
		 p.add(Configuracion);
		 p.add(Teclado);
		 p.add(ImprimirSaldo);
		 ventana.setVisible(true);
		 añadirBarraAdministrador(ventana);
		 añadirBarraConsultas(ventana);
		 añadirBarraDatosFidelizacion(ventana);
		 añadirBarraDatosCliente(ventana);
		 añadirBarraAcerca(ventana);
		 Version_demo();
	     timer.start();
        
	     SALIR.addActionListener(new ActionListener(){
      	   public void actionPerformed(ActionEvent e){
      		 int confirmado = JOptionPane.showConfirmDialog(null, "¿Deseas salir de la aplicacion?",null, 0, 0, Isalir);
             if (JOptionPane.OK_OPTION == confirmado){
             Backupdiario.backup();
      		  ventana.dispose();
      		  if(PuertoSerie.entrada!=null){
      		  PuertoSerie.CerrarCom();
             }
      		  System.exit(0);
      		  
             } 
      	   }
      	
      });
	     
	     ImprimirSaldo.addActionListener(new ActionListener(){
	      	   public void actionPerformed(ActionEvent e){
	      	ticket ticketsaldo=new ticket(Nombre.getText(),Apellido1.getText(),AreaCodigo.getText(),IDclientePantalla,FechaEntradaMysql,texto_SaldoActualI.getText(),
	      	   texto_PremiosI.getText());
	      	try {
				ticketsaldo.print();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	         }
	     });
	     
	     Minimizar.addActionListener(new ActionListener(){
	      	   public void actionPerformed(ActionEvent e){
	      			ventana.setExtendedState(ICONIFIED);
	      		   
	      	   }
	      	
	      });
	     Configuracion.addActionListener(new ActionListener(){
	      	   public void actionPerformed(ActionEvent e){
	      			Configurar.ConfigurarCOM();
	      		   
	      	   }
	     });
	     
	     Teclado.addActionListener(new ActionListener(){
	      	   public void actionPerformed(ActionEvent e){
	      		    
	      			//TecladoVirtual.Teclado();
	      			new Tecladonumerico();
	      		   
	      	   }
	     });
	     
	     Cancelar.addActionListener(new ActionListener(){
	      	   public void actionPerformed(ActionEvent e){
	      		
	      		 ActivarTecladoSeleccion();
	      		   
	      	   }
	      	
	      });
	    Actualizar.addActionListener(new ActionListener(){
	      	   public void actionPerformed(ActionEvent e){
	      		 detectadoPuertoserie=false; 
	      		  AreaCodigo.setEnabled(false);
	      		  TipoUltimaOperacion="";
	      		  UltimaOperacion="";
	      		  TipoUltimaOperacionPremio="";
	      		  UltimaOperacionPremio="";
	      	      TipoUltimaOperacionPremioConsumido="";
	      	      UltimaOperacionPremioConsumido="";
	      		  Basedatos.loadHSQLDB(); 
	              Basedatos.connectDB(); 
	              Basedatos.createStatement(); 
	              String CodigoB=AreaCodigo.getText();
	              Basedatos.ConsultaclientesPantalla(CodigoB);
	              InsertarDatosPantalla1();
	              if(AreaCodigo.getText().equals("")){//comprueba que no es una cadena vacia.
	            	   BorrarFormulario();
	            	   AreaCodigo.setEnabled(true);
	            	   PuertoSerie.LeerSerial.s="";
	            	   JOptionPane.showMessageDialog(ventana,
	            			   "Codigo incorrecto, por favor vuelva a introducirlo","Error", JOptionPane.WARNING_MESSAGE,IError);
	            	 
	            	  
	            
	              }
	              
	              else if(IDclientePantalla.equals("")){
	            	  BorrarFormulario();
	            	   AreaCodigo.setEnabled(true);
	            	   PuertoSerie.LeerSerial.s="";
	            	  JOptionPane.showMessageDialog(ventana,
	            			   "Codigo incorrecto, por favor vuelva a introducirlo","Error", JOptionPane.WARNING_MESSAGE,IError);
	            	   
	            	 
	            	
	              }else{
	              Basedatos.ConsultaclientesPantalla(CodigoB);
	              InsertarDatosPantalla1();
	              int IDBI=Integer.parseInt(IDclientePantalla);
	              Basedatos.ActualizarPremiosImporte(IDBI);
	              Basedatos.ConsultaPuntosPantallaImportes(IDBI);
	              ActivarTecladoSeleccion();
	              texto_Incremento.setText("0");
	              Basedatos.closeHSQLDB();
	              }
	              
	           }
	      	
	      });
	    GUARDAR.addActionListener(new ActionListener(){
	      	   public void actionPerformed(ActionEvent e){
	      		 detectadoPuertoserie=false;
	      		ventana.setExtendedState(ICONIFIED);
	      	    AreaCodigo.setEnabled(false);
      		   
	      		  Basedatos.loadHSQLDB(); 
	              Basedatos.connectDB(); 
	              Basedatos.createStatement(); 
	              String CodigoB=AreaCodigo.getText();
	              Basedatos.ConsultaclientesPantalla(CodigoB);
	              InsertarDatosPantalla1();
	              if(AreaCodigo.getText().equals("")){
	            	   JOptionPane.showMessageDialog(ventana,
	 	      				   "El campo Introduzca el Codigo: esta en blanco","Error", JOptionPane.WARNING_MESSAGE,IError);
	            	   AreaCodigo.setEnabled(true);
	            	   PuertoSerie.LeerSerial.s="";
	            	
	              }else if(IDclientePantalla.equals("")){
	            	 
	            	   JOptionPane.showMessageDialog(ventana,
	            			   "Codigo incorrecto, por favor vuelva a introducirlo","Error", JOptionPane.WARNING_MESSAGE,IError);
	            	   
	            	   BorrarFormulario();
	            	   AreaCodigo.setEnabled(true);
	            	   Formulario.ventana.setExtendedState(JFrame.NORMAL);
	            	   PuertoSerie.LeerSerial.s="";
	            	
	              }else{
	            
	              int IDBI=Integer.parseInt(IDclientePantalla);
	              Basedatos.ActualizarPremiosImporte(IDBI);
	              Basedatos.closeHSQLDB();
	              BorrarFormulario();
	              ventana.setExtendedState(ICONIFIED);
	              AreaCodigo.setEnabled(true);
	             
	              }
	           }
	      	
	      });
	          
	    
	        ANULAR.addActionListener(new ActionListener(){
	      	   public void actionPerformed(ActionEvent e){
	      		 int confirmado = JOptionPane.showConfirmDialog(
	      				   ventana,"¿Deseas anular la ultima operacion realizada?");
                   if (JOptionPane.OK_OPTION == confirmado){
	      		  int IDBI=Integer.parseInt(IDclientePantalla);
	      		if(TipoUltimaOperacion.equals("Importe")){
	      			 Basedatos.loadHSQLDB(); 
		             Basedatos.connectDB(); 
		             Basedatos.createStatement(); 
		             Basedatos.ActualizarSaldoPuntosImportesAnulada(UltimaOperacion, IDBI);
		             Basedatos.inserRegistroDiario(Formulario.FechaEntradaMysql,AreaCodigo.getText(),IDBI ,"Importes","Anulados",UltimaOperacion);
		             Basedatos.AnularTabladiariaImportes(IDBI,Formulario.FechaEntradaMysql, UltimaOperacion);
		             Basedatos.ActualizarPremiosImporte(IDBI);
		             Basedatos.ConsultarTablasImportes();
		             Basedatos.ConsultaPuntosPantallaImportes(IDBI);
		             Basedatos.ConsultaclientesPantallaIDclienteImportes(IDBI);
		             InsertarDatosPantalla1();
		             AreaCodigo.setEnabled(false);
		             TipoUltimaOperacion="";
		             UltimaOperacion="";
	      		}
        
	
	      		
                if(TipoUltimaOperacionPremio.equals("PremioImporte")){
                	 Basedatos.loadHSQLDB(); 
		             Basedatos.connectDB(); 
		             Basedatos.createStatement(); 
		             Basedatos.ActualizarPremiosImporte(IDBI);
		             Basedatos.ConsultaPuntosPantallaImportes(IDBI);
	      			 Basedatos.ConsultaclientesPantallaIDclienteImportes(IDBI);
	      			 Basedatos.closeHSQLDB();
	      			 InsertarDatosPantalla1();
		             AreaCodigo.setEnabled(false);
		             TipoUltimaOperacionPremio="";
                }
	      		  
                  
                if( TipoUltimaOperacionPremioConsumido.equals("PremioConsumidoImporteAnulado")){
                	Basedatos.loadHSQLDB(); 
		             Basedatos.connectDB(); 
		             Basedatos.createStatement(); 
		             Basedatos.AnularPremioConsumidoImporte(IDBI);
		             Basedatos.AnularImporteConsumido(IDBI);
		             String DevolverPuntosconsumidosI=String.valueOf(Formulario.restar_puntos_consumirpremiosimporte);
		             Basedatos.ActualizarSaldoPuntosImportes(DevolverPuntosconsumidosI, IDBI);
		             Basedatos.inserRegistroDiario(Formulario.FechaEntradaMysql,AreaCodigo.getText(),IDBI ,"Importe","AnuladosCONS",DevolverPuntosconsumidosI);
		             Basedatos.ActualizarPremiosImporte(IDBI);
		             Basedatos.ConsultaPuntosPantallaImportes(IDBI);
	      			 Basedatos.ConsultaclientesPantallaIDclienteImportes(IDBI);
	      			 Basedatos.closeHSQLDB();
	      			 InsertarDatosPantalla1();
		             AreaCodigo.setEnabled(false);
		             TipoUltimaOperacionPremioConsumido="";
                }
                
	              }
	      	   }
	      });
	  
	            
	 
	     
	  
	     
	    
	     CONSUMIRPREMIOSIMPORTE.addActionListener(new ActionListener(){
	      	   public void actionPerformed(ActionEvent e){
	      		  int saldototalImporte=Integer.parseInt(texto_SaldoActualI.getText());
	      		   if(saldototalImporte>=restar_puntos_consumirpremiosimporte){
	      			
	      		 if(PremioImporte.getText().equals("PREMIOS ACTUALES: 0")){
	      			JOptionPane.showMessageDialog(
	      				   ventana,
	      				   "Actualmente no tienes premios");
	      			 
	      		 }else{
	      			CONSUMIRPREMIOSIMPORTE.setEnabled(true);
	      			int confirmado = JOptionPane.showConfirmDialog(
	      				   ventana,
	      				   "Deseas consumir tu premio actual:"+texto_PremiosI.getText());

	      				if (JOptionPane.OK_OPTION == confirmado){
	      				   System.out.println("Premio Consumido"); 
	      				  Basedatos.loadHSQLDB(); 
	        	          Basedatos.connectDB(); 
	        	          Basedatos.createStatement();
	        	          int IDBI=Integer.parseInt(IDclientePantalla);
	        	         
	        	          Basedatos.ConsumirPremiosImporte(IDBI);
	        	          Basedatos.ConsultaclientesPantallaIDclienteImportes(IDBI);
	        	          String puntosconsumidos=String.valueOf(Formulario.restar_puntos_consumirpremiosimporte);
	        	          Basedatos.inserRegistroDiario(Formulario.FechaEntradaMysql,AreaCodigo.getText(),IDBI ,"Importe","Consumidos",puntosconsumidos);
	                      InsertarDatosPantallaImportes();
	    	              texto_Incremento.setText("0");
	    	              Basedatos.closeHSQLDB();
	    	              TipoUltimaOperacionPremioConsumido="PremioConsumidoImporteAnulado";
	    	      	      UltimaOperacionPremioConsumido="ImporteConsumidoAnulado";
	    	      	      TipoUltimaOperacion="";
	    	      	      UltimaOperacion="";
	      				}else{
	      				   System.out.println("vale... no borro nada...");
	      			 }
	      	   }
	      	}
	      	   }
	      });
	     
	     BORRAR.addActionListener(new ActionListener(){
	      	   public void actionPerformed(ActionEvent e){
	      		 BorrarFormulario();
	      		 AreaCodigo.setEnabled(true);
	      	   }
	      	
	      });
	     
	    
  }
	 
	    
		 
	  static void BorrarFormulario(){
		  AreaCodigo.setText("");
		  PuertoSerie.LeerSerial.s="";
 		  Premios="";
 		  PuntosTotales="";
 		  IDclientePantalla="";
 		  texto_Incremento.setText("");
 		  IdCliente.setVisible(false);
		  IdCliente.setText("");
		  Nombre.setVisible(false);
		  Apellido1.setVisible(false);
		
		  SaldoImporte.setVisible(false);
		
		
		  PremioImporte.setVisible(false);
		
		  CONSUMIRPREMIOSIMPORTE.setVisible(false);
		  Nombre.setVisible(false);
		  Apellido1.setVisible(false);
		 
		     texto_Incremento.setText("");
	      texto_Factura_Ticket.setText("");
         texto_SaldoActualI.setText("");
	 
	     texto_PremiosI.setText("");
	   
	     DesactivarTecladoSeleccion();
	     detectadoPuertoserie=true;
	     detectadoCodigoBarras=true;
	     Actualizar.setEnabled(true);
	     AreaCodigo.setEnabled(true);
	 }
	        
	        
         private void añadirBarraAdministrador(JFrame barraVentana){
			barraVentana.setJMenuBar(BarraDeMenu);
		    menuFormulario = new JMenu("Administrador");
			BarraDeMenu.add(menuFormulario);
			JMenuItem elementoLogin = new JMenuItem("Login");
			menuFormulario.add(elementoLogin);
			menuFormulario.setIcon(Ihome);
			class AbrirActionListener implements ActionListener{
				public void actionPerformed(ActionEvent evento){
					Login.login();
					TecladoVirtual.Teclado();
				}
		    }
			elementoLogin.addActionListener(new AbrirActionListener());
	   }
        private void añadirBarraAcerca(JFrame barraVentana){
				barraVentana.setJMenuBar(BarraDeMenu);
				menuFormulario4 = new JMenu("Acerca");
				menuFormulario4.setIcon(Iinformacion);
				BarraDeMenu.add(menuFormulario4);
			    JMenuItem elementoAcercade = new JMenuItem("FID24 version 2.01");
			    JMenuItem elementoAyuda= new JMenuItem("Ayuda");
			    menuFormulario4.add(elementoAyuda);
			    menuFormulario4.add(elementoAcercade);
				class LicenciaActionListener implements ActionListener{
					public void actionPerformed(ActionEvent evento){
					   PanelLicencia.Configurar();
					}
			    }
				elementoAcercade.addActionListener(new LicenciaActionListener());
				
				class AyudaActionListener implements ActionListener{
					public void actionPerformed(ActionEvent evento){
					   PanelAyuda.Ayuda();
					}
			    }
				elementoAyuda.addActionListener(new AyudaActionListener());
	   }
        
	   private void añadirBarraDatosCliente(JFrame barraVentana){
			barraVentana.setJMenuBar(BarraDeMenu);
		    menuFormulario3 = new JMenu("Datos Clientes");
			BarraDeMenu.add(menuFormulario3);
			menuFormulario3.setIcon(Iclientes);
			menuFormulario3.setEnabled(false);
			JMenuItem elementoFormulario = new JMenuItem("Formulario");
			menuFormulario3.add(elementoFormulario);
			class AbrirActionListener implements ActionListener{
				public void actionPerformed(ActionEvent evento){
					new PanelAdministrador();
				}
		    }
			elementoFormulario.addActionListener(new AbrirActionListener());
	   }
		
	   private void añadirBarraConsultas(JFrame barraVentana){
			barraVentana.setJMenuBar(BarraDeMenu);
			menuFormulario1 = new JMenu("Tablas Consultas");
			BarraDeMenu.add(menuFormulario1);
			menuFormulario1.setEnabled(false);
			menuFormulario1.setIcon(IConsulta);
			JMenuItem elementoConsultasClientes = new JMenuItem("Tabla Clientes");
			JMenuItem elementoConsultasImportes = new JMenuItem("Tabla Importes");
			JMenuItem elementoListadoGeneral=new JMenuItem("Tabla Diaria");
			menuFormulario1.add(elementoConsultasClientes);
			menuFormulario1.add(elementoConsultasImportes);
			menuFormulario1.add(elementoListadoGeneral);
			class TablaClientes implements ActionListener{
				public void actionPerformed(ActionEvent evento){
					new ConsultasTablas();
				}
		    }
			
			
			class TablaImportes implements ActionListener{
				public void actionPerformed(ActionEvent evento){
					new ConsultasImportes();
				}
		    }
			class TablaDiaria implements ActionListener{
				public void actionPerformed(ActionEvent evento){
					new ListadoGeneral();
				}
		    }
			elementoConsultasClientes.addActionListener(new TablaClientes());
	        elementoConsultasImportes.addActionListener(new TablaImportes());
			elementoListadoGeneral.addActionListener(new TablaDiaria());
	   }
	
	 
	   
	
      
       
	   static void InsertarDatosPantalla1(){
			  IdCliente.setVisible(true);
			  IdCliente.setText("ID CLIENTE: "+ IDclientePantalla);
			  Fecha.setText(FechaActual.getFecha());
  		      Time.setText(FechaActual.getTime());
			  Nombre.setVisible(true);
			  Nombre.setText(NombreCliente);
			  Apellido1.setVisible(true);
			  Apellido1.setText(Apellido1Cliente);
		
			  SaldoImporte.setVisible(false);
			 
			  PremioImporte.setVisible(false);
			
			  CONSUMIRPREMIOSIMPORTE.setVisible(false);
			  
			}	
	   
	
	   
	 
	   private void InsertarDatosPantallaImportes(){
			  IdCliente.setVisible(true);
			  IdCliente.setText("ID CLIENTE: "+ IDclientePantalla);
			  Nombre.setVisible(true);
			  Nombre.setText(NombreCliente);
			  Apellido1.setVisible(true);
			  Apellido1.setText(Apellido1Cliente);
			  SaldoImporte.setVisible(true);
			  SaldoImporte.setText("SALDO TOTAL IMPORTES: "+ texto_SaldoActualI.getText());
			  PremioImporte.setVisible(true);
			  PremioImporte.setText("PREMIOS ACTUALES: "+ texto_PremiosI.getText());
			  CONSUMIRPREMIOSIMPORTE.setVisible(true);
			 
			}	
	   
	     
	
	   
	   
		@Override
		public void stateChanged(ChangeEvent e) {
			
			
		}
		
		static void setFecha_AnteriorMysql(String FechaAnterior){
			Fecha_AnteriorMysql=FechaAnterior;
		}
		
		static String getFecha_AnteriorMysql(){
			
			return Fecha_AnteriorMysql;
		}
		public static void  CompararFechaSistema(){
			 Formulario.setFecha_AnteriorMysql("2015-01-19");
			if(FechaActualMysql.getFechamysql().equals(Formulario.getFecha_AnteriorMysql())){
				Formulario.setFecha_AnteriorMysql(FechaActualMysql.getFechamysql());
		    }
			      
			
			System.out.println(FechaActualMysql.getFechamysql()+"+"+ Formulario.getFecha_AnteriorMysql());
		}
		
		private static void Version_demo(){
			
			if((PanelAdministrador.Licencia==0)  && (Formulario.FechaEntradaMysql.equals(Formulario.FechaActualMysql))){
				
				Generarbasedemo.restore();
				
			}
	
			if(PanelAdministrador.Licencia==0){
			  System.out.println(PanelAdministrador.Licencia);
				 System.out.println(Formulario.DiasDemo);
				if(DiasDemo>=30){
				     JOptionPane.showMessageDialog(
	 	      				  ventana,
	 	      				 "Esta en un version demo por favor si quieres "
	 	      				 + "seguir utilizando este programa solicite su licencia","Demo",JOptionPane.WARNING_MESSAGE,Formulario.Idemo);
				           
				           System.exit(0);
				       }
				
				  
				}
			}
			
		
		
	public static void main(String[] args) {
		 new Formulario();
		 CompararFechaSistema();
	     Basedatos.loadHSQLDB(); 
         Basedatos.connectDB(); 
         Basedatos.createStatement(); 
         Basedatos.createTablesFidelizacion();
         Basedatos.createTables();
         Basedatos.createTablesCatalogo();;
         Basedatos.createTablesImporte();
         Basedatos.createTablesDiaria();
         Basedatos.createTablesConsumo();
         Basedatos.createTablesRegalosPendientes();
         Basedatos.createConfiguracionLector();
         Basedatos.createConfiguracion();
         Basedatos.ConfigurarPuntosFidelizacion();
         Basedatos.CreateRegistroDiario();
         Basedatos.ConfigurarLector();
         Basedatos.Configurar();
         Basedatos.ActualizarDiasDemo();
         Basedatos.closeHSQLDB();
         new PuertoSerie();
         System.out.println(PuertoSerie.puerto);
         System.out.println(PuertoSerie.intervalomsgTotal);
         
	}

       private static void ActivarTecladoSeleccion(){
    	   
		     Venta.setEnabled(true);
			
			 Aceptar.setEnabled(false);
		    texto_Incremento.setEnabled(true);
			texto_Factura_Ticket.setEnabled(false);
			Cancelar.setEnabled(false);
			Teclado.setEnabled(false);
			
    	 }
       
       static void DesactivarTecladoSeleccionImportes(){
    	   
		     Venta.setEnabled(false);
			
			 Aceptar.setEnabled(true);
		    texto_Incremento.setEnabled(true);
			texto_Factura_Ticket.setEnabled(true);
			Cancelar.setEnabled(true);
			Teclado.setEnabled(true);
  	 }
       private static void DesactivarTecladoSeleccion(){
    	   
		     Venta.setEnabled(false);
			 Aceptar.setEnabled(false);
		    texto_Incremento.setEnabled(false);
			texto_Factura_Ticket.setEnabled(false);
			Cancelar.setEnabled(false);
			Teclado.setEnabled(true);
			
	 }
       
       private void DetectarPuertoSerie(){
    	  String caracteres=AreaCodigo.getText();
    	  if(caracteres.length()==13 && detectadoPuertoserie){
    		 ventana.setExtendedState(MAXIMIZED_VERT);
    		       AreaCodigo.setEnabled(false);
    		       timer.stop();
    		    BotonActualizar=new Timer(1000, new TimerListener());
    		    BotonActualizar.start();
    	  }if(caracteres.length()>=14){
      		 AreaCodigo.setText("");
      		
      		}
       }
       
       
    		    
       public static  class TimerListener implements ActionListener {
    	      public void actionPerformed(ActionEvent evt) 
    	      {   
    	    	   TipoUltimaOperacion="";
          		   UltimaOperacion="";
          		   TipoUltimaOperacionPremio="";
          		   UltimaOperacionPremio="";
          	      TipoUltimaOperacionPremioConsumido="";
          	      UltimaOperacionPremioConsumido="";
          		  Basedatos.loadHSQLDB(); 
                  Basedatos.connectDB(); 
                  Basedatos.createStatement(); 
                  String CodigoB=AreaCodigo.getText();
                  Basedatos.ConsultaclientesPantalla(CodigoB);
                  InsertarDatosPantalla1();
                  if(AreaCodigo.getText().equals("")){
                	  Formulario.BorrarFormulario();
               	     PuertoSerie.LeerSerial.s="";
               	      BotonActualizar.stop();
                      timer.start();
                	
                	   JOptionPane.showMessageDialog(ventana,
                			   "Codigo incorrecto, por favor vuelva a introducirlo","Error", JOptionPane.WARNING_MESSAGE,IError);
                	 
                  } else if(IDclientePantalla.equals("")){
                       BorrarFormulario();
                  	   PuertoSerie.LeerSerial.s="";
                  	   BotonActualizar.stop();
                  	   timer.start();
                	
                	   JOptionPane.showMessageDialog(ventana,
                			   "Este codigo no ha sido dado de alta como cliente","Error", JOptionPane.WARNING_MESSAGE,IError);
                	   
                	   
                  }else{
                 
                  int IDBI=Integer.parseInt(IDclientePantalla);
                  
                  Basedatos.ActualizarPremiosImporte(IDBI);
                 
                  Basedatos.ConsultaPuntosPantallaImportes(IDBI);
                 
                  ActivarTecladoSeleccion();
                  texto_Incremento.setText("0");
                  Basedatos.closeHSQLDB();
                  detectadoPuertoserie=false;
                  detectadoCodigoBarras=false;
                  Actualizar.setEnabled(false);
                  BotonActualizar.stop();
                  timer.start();
                  }
               }
           }
    		
    	  
    @Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
    	  Fecha=new JLabel(FechaActual.getFecha());
		  Time=new JLabel(FechaActual.getTime());
		   DetectarPuertoSerie();
		
		   
	
    	    
    	   
  			
  	  			
  	    	     
    
    

            if(Venta.isSelected()){
            	
            	InsertarDatosPantalla1();
            	InsertarDatosPantallaImportes();
            	DesactivarTecladoSeleccionImportes();
            	texto_Incremento.setText("0");
			    Aceptar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
				int puntosImporte=0;
				int saldo_importeActual=0;
			    saldo_importeActual=Integer.parseInt(texto_Factura_Ticket.getText());
		        while(puntosporImporte*10<=saldo_importeActual){
				saldo_importeActual=saldo_importeActual-puntosporImporte*10;
				puntosImporte=puntosImporte+puntosporImporte;
				String SpuntosImporte1=String.valueOf(puntosImporte);
				texto_Incremento.setText(SpuntosImporte1);
				
		      } 
		     
			  Basedatos.loadHSQLDB(); 
	          Basedatos.connectDB(); 
	          Basedatos.createStatement();
	          int IDS=Integer.parseInt(IDclientePantalla);
	          Basedatos.ActualizarSaldoPuntosImportes(texto_Incremento.getText(), IDS);
	          Basedatos.ActualizarTabladiariaImportes(IDS,Formulario.FechaEntradaMysql,texto_Incremento.getText());
	          System.out.println(texto_Incremento.getText());
	          TipoUltimaOperacion="Importe";
	          UltimaOperacion=texto_Incremento.getText();
	          Basedatos.ActualizarPremiosImporte(IDS);
	          Basedatos.ConsultaPuntosPantallaImportes(IDS);
	          Basedatos.inserRegistroDiario(Formulario.FechaEntradaMysql,AreaCodigo.getText(),IDS ,"IMPORTES","Obtenidos",texto_Incremento.getText());
	          texto_Factura_Ticket.setText("");
	          InsertarDatosPantallaImportes();
	          Basedatos.closeHSQLDB();
	          ActivarTecladoSeleccion();
			}
			
			
			
		 });
			 
   			}
			 
    }



	private void añadirBarraDatosFidelizacion(JFrame barraVentana){
			barraVentana.setJMenuBar(BarraDeMenu);
			menuFormulario2 = new JMenu("Datos Fidelizacion");
			BarraDeMenu.add(menuFormulario2);
			menuFormulario2.setEnabled(false);
			menuFormulario2.setIcon(IFidelizacion);
			JMenuItem elementoPuntos = new JMenuItem("Tabla de puntos");
			menuFormulario2.add(elementoPuntos);
			class AbrirActionListener implements ActionListener{
				public void actionPerformed(ActionEvent evento){
					PanelFidelizacion.ConfigurarFidelizacion();
				}
		    }
			elementoPuntos.addActionListener(new AbrirActionListener());
	   }	
  
}



