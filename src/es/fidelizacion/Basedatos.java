package es.fidelizacion;

import java.sql.*;

import javax.swing.JOptionPane;


public class Basedatos {
	
	    static Connection con  = null; 
	    static Statement  st   = null;
	    static Statement  stpremios=null;
	    static Statement  stpremios1=null;
	    
	    static PreparedStatement psInsertar = null;
	    static  PreparedStatement psBorrar=null;
	    static ResultSet  res  = null; 
	    static ResultSet  modificar=null;
	    static ResultSet  resP=null;
	    static ResultSet  res1=null;
	    static ResultSet  res2=null;
	    static String     sql=null;
	    static String     sqluse="USE fidelizacion;";
	    static String     sqlpuntos=null;
	    static String     sqlpremios=null;
	    static String     sqlDesayunos = null;
	    static String     sqlComida = null;
	    static String     sqlImporte= null;
	    static String     sqlFidelizacion=null;
	    static String     sqlregalosdesayunos=null;
	    static String     sqlregalosmenus=null;
	    static String     sqlregalosimportes=null;
	   
	    public static void loadHSQLDB() 
	    { 
	        System.out.println("* Starting..."); 
	        try
	        { 
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            System.out.println("* Loading mysql driver..."); 
	        }  
	        catch(Exception e) 
	        {   
	            System.err.println("ERROR: failed to load  JDBC driver."); 
	            e.printStackTrace(); 
	            return;   
	        }  
	    } 
	      
	    public static void connectDB() 
	    { 
	        try
	        {   // Connect to the database or create if it don't exist  
	        	
	            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/?","root","alejandro");
	            st=con.createStatement(); 

	            int c=st.executeUpdate("CREATE DATABASE fidelizacion");
	            st.executeUpdate(sqluse);
	            System.out.println("* Creating mysql connection..."); 
	        } 
	        catch(Exception e) 
	        { 
	            System.err.println("Error: " + e.getMessage()); 
	            return; 
	        } 
	    } 
	      
	    public static void createStatement() 
	    { 
	        try
	        { 
	            st  = con.createStatement(); 
	            stpremios = con.createStatement();
	            stpremios1 = con.createStatement();
	            st.executeUpdate(sqluse);
	            
	        } 
	        catch (Exception e) 
	        {   
	            System.err.println("Error: createStatement: " + e.getMessage());    
	            return; 
	        } 
	    } 
	      
	  
	      
	    public static void createTables() 
	    { 
	        try 
	        {   // Create tables 
	        	
	            sql = " CREATE TABLE clientes" +  "(ID INTEGER auto_increment ," + 
	            		                           "CODIGOBARRASGENERADO VARCHAR(40),"+
	            	                        	    "NOMBRE VARCHAR(100),"+ 
	                                                "1apellido   VARCHAR(100), " + 
	                                                "2apellido   VARCHAR(100),"+
	                                                "CODIGOPOSTAL  VARCHAR(5)," +
	                                                "FECHA_ALTA DATE,"+
	                                                "email      VARCHAR(80)," + 
	                                                "TELEFONO     VARCHAR(50)," +
	                                                "CANTIDAD_DESAYUNOS INTEGER,"+
	                                                "CANTIDAD_MENUS INTEGER,"+
	                                                "CANTIDAD_IMPORTES INTEGER,"+
	                                                "PUNTOS_ACTUALES_DESAYUNOS INTEGER,"+
	                                                "PUNTOS_ACTUALES_MENUS INTEGER,"+
	                                                "PUNTOS_ACTUALES_IMPORTES INTEGER,"+
	                                                "PUNTOS_RCONSUMIDOS_DESAYUNOS INTEGER,"+
	                                                "PUNTOS_RCONSUMIDOS_MENUS INTEGER,"+
	                                                "PUNTOS_RCONSUMIDOS_IMPORTES INTEGER,"+
	                                                "REGALOS_ACUMULADOSDESAYUNOS VARCHAR(100),"+
	                                                "REGALOS_ACUMULADOSMENUS VARCHAR(100),"+
	                                                "REGALOS_ACUMULADOSIMPORTES VARCHAR(100),"+
	                                                " primary key (ID))";   
	                st.executeUpdate(sql);   
	           
	          
	           
	          
	         
	          
	         }  
	        catch (Exception e) 
	        {   
	            System.err.println("Warning: CREATE TABLE: " + e.getMessage());    
	        } 
	    } 
	    
	    
	    public static void createTablesDiaria() 
	    { 
	        try 
	        {   // Create tables 
	        	st.executeUpdate(sqluse);
	            sql = "CREATE TABLE Tabladiaria" +  "(ID INTEGER ," + 
	            		                            "FECHA_DIARIA DATE,"+
	                                                "DESAYUNOS INTEGER,"+
	                                                "MENUS INTEGER,"+
	                                                "IMPORTES INTEGER)";
	                                              
	                                                  
	            st.executeUpdate(sql);   
	         }  
	        catch (Exception e) 
	        {   
	            System.err.println("Warning: CREATE TABLEDIARIA: " + e.getMessage());    
	        } 
	    } 
	    
	    public static void createConfiguracionLector(){
	      try
	        {   // Create tables 
	        	st.executeUpdate(sqluse);
	            sql = "CREATE TABLE ConfiguracionLector " +  "(COM VARCHAR(400),"+ 
	            		                                 "LONGITUD INTEGER,"+
	            		                                 "INTERVALO INTEGER)";
	                                              
	                                                  
	            st.executeUpdate(sql);   
	          
	         }  
	        catch (Exception e) 
	        {   
	            System.err.println("Warning: CREATE ConfiguracionLector: " + e.getMessage());    
	        } 
	    } 
	    
	    public static void createConfiguracion(){
		      try
		        {   // Create tables 
		        	st.executeUpdate(sqluse);
		            sql = "CREATE TABLE Configuracion " +  "(CONTRASEÑA VARCHAR(400),"+ 
		            		                                 "LICENCIA INTEGER,"+
		            		                                 "FECHA DATE,"+
		            		                                 "DIASDEMO INTEGER,"+
		            		                                 "ESTABLECIMIENTO VARCHAR(400),"+
		            		                                 "NIF VARCHAR(400))";
		                                              
		                                                  
		            st.executeUpdate(sql);   
		          
		         }  
		        catch (Exception e) 
		        {   
		            System.err.println("Warning: CREATE Configuracion: " + e.getMessage());    
		        } 
		    } 
	    
	    
	    public static void CreateRegistroDiario() 
	    { 
	        try 
	        {   // Create tables 
	        	st.executeUpdate(sqluse);
	            sql = "CREATE TABLE RegistroDiario" +  "(FECHA_OPERACION DATE,"
	        	                                         +"CODIGO VARCHAR(100),"
	            		                                 +"ID INTEGER,"
	        	                                         +"TABLA_PUNTOS VARCHAR(100),"
	        	                                         +"TIPO_OPERACION VARCHAR(100),"
	        	                                         +"CANTIDAD VARCHAR(100))";
	          st.executeUpdate(sql);   
	         }  
	        catch (Exception e) 
	        {   
	            System.err.println("Warning: CREATE REGISTRO DIARIO: " + e.getMessage());    
	        } 
	    } 
	    
	    public static void createTablesConsumo() 
	    { 
	       
	    	        try 
	    	        {   // Create tables 
	    	        	st.executeUpdate(sqluse);
	    	            sql = "CREATE TABLE TablaConsumoDiario" +  "(ID INTEGER ," +
	    	                                                       "FECHA_DIARIA DATE,"+
	    	                                                       "CONSUMIDOSDESAYUNOS INTEGER,"+
	    	                                                       "PREMIOSDESAYUNOS  VARCHAR(100),"+
	    	            		                                   "CONSUMIDOSMENUS INTEGER,"+
	    	            		                                   "PREMIOSMENUS VARCHAR(100),"+
	    	            		                                   "CONSUMIDOSIMPORTES INTEGER,"+
	    	            		                                   "PREMIOSIMPORTES VARCHAR(100))";
	    	                                              
	    	            st.executeUpdate(sql);   
	    	          }  
	    	        catch (Exception e) 
	    	        {   
	    	            System.err.println("Warning: CREATE TablaConsumoDiario: " + e.getMessage());    
	    	        } 
	    	  
	    }
	    public static void createTablesRegalosPendientes() 
	    { 
	       
	    	        try 
	    	        {   // Create tables 
	    	        	st.executeUpdate(sqluse);
	    	            sql = "CREATE TABLE TablaRegalosPendientes" +  "(ID INTEGER ," +
	    	                                                       "FECHA_DIARIA DATE,"+
	    	                                                       "PREMIOSDESAYUNOS  VARCHAR(100),"+
	    	            		                                   "PREMIOSMENUS VARCHAR(100),"+
	    	            		                                   "PREMIOSIMPORTES VARCHAR(100))";
	    	                                              
	    	            st.executeUpdate(sql);   
	    	          }  
	    	        catch (Exception e) 
	    	        {   
	    	            System.err.println("Warning: CREATE TablaRegalosPendientes: " + e.getMessage());    
	    	        } 
	    	  
	    }
	
	    
	    public static void createTablesDesayunos() 
	    { 
	        try 
	        {   // Create tables 
	        	
	           
	        	st.executeUpdate(sqluse);
	            sqlDesayunos = "CREATE TABLE PuntosDesayunos" +  "(id INTEGER,"+
	            		"FECHA_ALTA DATE,"+
	                    "PUNTOS_ACTUALES INTEGER,"+
	                    "REGALOS_ACUMULADOS VARCHAR(100),"+"REGALOS_CONSUMIDOS INTEGER)";
	            
	           st.executeUpdate(sqlDesayunos);
	           
	          
	          
	         }  
	        catch (Exception e) 
	        {   
	            System.err.println("Warning: CREATE TABLE: " + e.getMessage());    
	        } 
	    } 
	    
	    public static void createTablesComida() 
	    { 
	        try 
	        {   // Create tables 
	        	  st.executeUpdate(sqluse);
	        	  sqlComida = "CREATE TABLE PuntosComida" +  "(id INTEGER,"+
	        			      "FECHA_ALTA DATE,"+
		                      "PUNTOS_ACTUALES INTEGER,"+
		                      "REGALOS_ACUMULADOS VARCHAR(100),"+"REGALOS_CONSUMIDOS INTEGER)";
		           
		          st.executeUpdate(sqlComida);
	           
	           
	           
	          
	         }  
	        catch (Exception e) 
	        {   
	            System.err.println("Warning: CREATE TABLE: " + e.getMessage());    
	        } 
	    } 
	      
	    public static void createTablesImporte() 
	    { 
	        try 
	        {   // Create tables
	        	  st.executeUpdate(sqluse);
	        	  sqlImporte = "CREATE TABLE PuntosImporte" +  "(id INTEGER,"+
	        			  "FECHA_ALTA DATE,"+
		                  "PUNTOS_ACTUALES INTEGER,"+
		                  "REGALOS_ACUMULADOS VARCHAR(100),"+"REGALOS_CONSUMIDOS INTEGER)";
		          
		         st.executeUpdate(sqlImporte);
	        	
	         }  
	        catch (Exception e) 
	        {   
	            System.err.println("Warning: CREATE TABLE: " + e.getMessage());    
	        } 
	    } 
	    
	    public static void createTablesFidelizacion() 
	    { 
	        try 
	        {   // Create tables 
	        	  st.executeUpdate(sqluse);
	        	  sqlFidelizacion = "CREATE TABLE PuntosFidelizacion" +  "(INCREMENTODESAYUNOS INTEGER,"+
		                      "PREMIOSDESAYUNOS VARCHAR(100),"+ "INCREMENTOMENU INTEGER," +
		                      "PREMIOSMENU VARCHAR(100)," + "INCREMENTOIMPORTE INTEGER,"
		                      + "PREMIOSIMPORTE VARCHAR(100),"+"PUNTOSDESAYUNO INTEGER,"+"PUNTOSMENU INTEGER,"+"PUNTOSIMPORTE INTEGER)";
	        	  
		          
		           st.executeUpdate(sqlFidelizacion);
	           
	         }  
	        catch (Exception e) 
	        {   
	            System.err.println("Warning: CREATE TABLE: " + e.getMessage());    
	        } 
	    }
	    
	    
	    public static void restoreDB() 
	    { 
	        try 
	        {   // Restore the database  
	        	st.executeUpdate(sqluse);
	            st.executeUpdate("DROP table clientes;");
	            st.executeUpdate("DELETE FROM puntoscomida;");
	            st.executeUpdate("DELETE FROM puntosimporte;"); 
	            st.executeUpdate("DELETE FROM puntosdesayunos;");
	            st.executeUpdate("DELETE FROM registrodiario;"); 
	            st.executeUpdate("DELETE FROM tablaconsumodiario;");
	            st.executeUpdate("DELETE FROM tabladiaria;");
	            st.executeUpdate("DELETE FROM tablaregalospendientes;"); 
	            System.out.println("Eliminamos la base de datos fidelizacion excepto configuracion lector y licencia"); 
	        } 
	        catch (Exception e) 
	        {   
	            System.err.println("Warning: error eliminar base de datos menos  configuracion y liencia: " + e.getMessage());    
	        }  
	    }
	   
	    public static void BorrarTablaFidelizacion() 
	    { 
	        try 
	        {   // Restore the database
	        	st.executeUpdate(sqluse);
	            st.executeUpdate("DELETE FROM PuntosFidelizacion;"); 
	            System.out.println("ELIMINAMOS LOS DATOS DE LA TABLA"); 
	        } 
	        catch (Exception e) 
	        {   
	            System.err.println("Warning: error on vacuum tables: " + e.getMessage());    
	        }  
	    }
	    public static void closeHSQLDB() 
	    { 
	        // Save temporal data and close 
	        try
	        {   st.executeUpdate(sqluse);
	            st = con.createStatement();   
	            st.executeUpdate("SHUTDOWN");   
	            st.close();  
	        } 
	        catch(Exception e) 
	        { 
	            System.out.println("Error: save temporal data" + e.getMessage()); 
	        }  
	    }
	    public static void insertData(String Codigo, String Nombre, String apellido1, 
	    		String apellido2,String CodigoPostal,String FechaAlta, String Email, String Telefono) 
	    		
	    		
	    { 
	        // Insertamos datos   
	        try 
	        {   st.executeUpdate(sqluse);
	            psInsertar=con.prepareStatement("INSERT INTO clientes(CODIGOBARRASGENERADO,NOMBRE,1apellido,2apellido,CODIGOPOSTAL,FECHA_Alta,email,TELEFONO) VALUES (?,?,?,?,?,?,?,?)");
	        	psInsertar.setString(1,Codigo);
	        	psInsertar.setString(2,Nombre);
	        	psInsertar.setString(3,apellido1);
	        	psInsertar.setString(4,apellido2);
	        	psInsertar.setString(5,CodigoPostal);
	        	psInsertar.setString(6,FechaAlta);
	        	psInsertar.setString(7,Email);
	        	psInsertar.setString(8,Telefono);
	            psInsertar.executeUpdate();
	        	
	        } 
	        catch (Exception e) 
	        {   
	            System.err.println("Warning: error on insert data: " + e.getMessage());    
	            e.printStackTrace(); 
	            return;  
	        }  
	    } 
	      
	    public static void Consultaclientes(String Codigo) 
	    { 
	    	
	        try 
	        {  
	        	 st.executeUpdate(sqluse);
	            // Mostramos por pantalla los clientes seleccionados por el codigo 
	        	 sql = "SELECT * FROM clientes WHERE CODIGOBARRASGENERADO="+Codigo+" OR "+"TELEFONO="+Codigo+" OR "+"ID="+Codigo;
	            res = st.executeQuery(sql);
	           
	            
	            while(res.next()){
	            	String CODIGOBARRASGENERADO=res.getString("CODIGOBARRASGENERADO");
	 	            int ID=res.getInt("ID");
	 	            String NOMBRE=res.getString("NOMBRE");
	 	            String apellido1=res.getString("1apellido");
	 	            String apellido2=res.getString("2apellido");
	 	            String CODIGOPOSTAL=res.getString("CODIGOPOSTAL");
	 	            String EMAIL=res.getString("email");
	 	            String TELEFONO=res.getString("TELEFONO");
	 	            
	 	            
	 	            System.out.print("dato cliente:"+ CODIGOBARRASGENERADO+ID+NOMBRE+
	        	           apellido1+apellido2+CODIGOPOSTAL+
	        	            EMAIL+ TELEFONO);
	 	            
	                ClienteAdministrador.RellenarFormulario(CODIGOBARRASGENERADO,ID,NOMBRE,apellido1,apellido2,CODIGOPOSTAL,EMAIL, TELEFONO);
	               
	        	  }
	            
	            // Free memory 
	            res.close();  
	        } 
	        catch (Exception e) 
	        {   
	            System.err.println("Warning: SELECT JOIN clientes: " + e.getMessage());    
	        } 
	    }
	    public static void ObtenerIDCliente(String Codigo) 
	    { 
	    	
	        try 
	        {  
	        	 st.executeUpdate(sqluse);
	            // Mostramos por pantalla los clientes seleccionados por el codigo 
	        	 sql = "SELECT * FROM clientes WHERE CODIGOBARRASGENERADO="+Codigo;
	            res = st.executeQuery(sql);
	           
	            
	            while(res.next()){
	            	
	 	            cliente.ID=res.getInt("ID");
	 	          
	        	  }
	            
	            // Free memory 
	            res.close();  
	        } 
	        catch (Exception e) 
	        {   
	            System.err.println("Warning: SELECT JOIN ObtenerID: " + e.getMessage());    
	        } 
	    }
	    
	    public static void IDClienteEliminarRegistro(String Codigo) 
	    { 
	    	
	        try 
	        {  
	        	 st.executeUpdate(sqluse);
	            // Mostramos por pantalla los clientes seleccionados por el codigo 
	        	 sql = "SELECT * FROM clientes WHERE CODIGOBARRASGENERADO="+Codigo;
	            res = st.executeQuery(sql);
	           
	            
	            while(res.next()){
	            	int IDeliminacion=res.getInt("ID");
	 	            EliminarIDDesayuno(IDeliminacion);
	 	            EliminarIDMenu(IDeliminacion);
	 	            EliminarIDImporte(IDeliminacion);
	 	            EliminarIDTablaDiaria(IDeliminacion);
	 	            EliminarIDTablaConsumoDiario(IDeliminacion);
	 	            EliminarIDTablaRegalosPendientes(IDeliminacion);
	 	          
	        	  }
	            
	            // Free memory 
	            res.close();  
	        } 
	        catch (Exception e) 
	        {   
	            System.err.println("Warning: SELECT JOIN ObtenerID: " + e.getMessage());    
	        } 
	    }
	    public static void EliminarConfiguracionLector() 
	    { 
	    	
	        try 
	        {  
	        	 st.executeUpdate(sqluse);
	            // Mostramos por pantalla los clientes seleccionados por el codigo 
	        	 sql = "DELETE  FROM Configuracionlector"; 
	        	 st.executeUpdate(sql);
	           } 
	        catch (Exception e) 
	        {   
	            System.err.println("Warning: SELECT JOIN BorrarConfiguracionlector: " + e.getMessage());    
	        } 
	    }
	    
	    public static void EliminarConfiguracion() 
	    { 
	    	
	        try 
	        {  
	        	 st.executeUpdate(sqluse);
	            // Mostramos por pantalla los clientes seleccionados por el codigo 
	        	 sql = "DELETE  FROM Configuracion"; 
	        	 st.executeUpdate(sql);
	           } 
	        catch (Exception e) 
	        {   
	            System.err.println("Warning: SELECT JOIN BorrarConfiguracionAdministrador: " + e.getMessage());    
	        } 
	    }
	    public static void ConsultaclientesPantalla(String Codigo) 
	    { 
	    	
	        try 
	        {  
	        	 st.executeUpdate(sqluse);
	            // Mostramos por pantalla los clientes seleccionados por el codigo 
	        	 sql = "SELECT * FROM clientes WHERE CODIGOBARRASGENERADO="+Codigo+" OR "+" TELEFONO="+Codigo;
	            res = st.executeQuery(sql);
	          
	           
	            
	            while(res.next()){
	 	            int ID=res.getInt("ID");
	 	            String NOMBRE=res.getString("NOMBRE");
	 	            String apellido1=res.getString("1apellido");
	 	           Formulario.NombreCliente=NOMBRE;
		 	       Formulario.Apellido1Cliente=apellido1;
		 	       String IDS=String.valueOf(ID);
		 	       Formulario.IDclientePantalla=IDS;
	 	           
		 	       
		 	    }
	            
	            // Free memory 
	            res.close();  
	        } 
	        catch (Exception e) 
	        {   
	            System.err.println("Warning: SELECT JOIN clientes: " + e.getMessage());    
	        } 
	    }
	    
	    public static void ConsultaclientesPantallaIDcliente(int ID) 
	    { 
	    	
	        try 
	        {   
	        	st.executeUpdate(sqluse);
	            // Mostramos por pantalla los clientes seleccionados por el ID 
	        	 sql = "SELECT * FROM clientes WHERE ID="+ID;
	            res = st.executeQuery(sql);
	          
	           
	            
	            while(res.next()){
	            	
	 	            int ID1=res.getInt("ID");
		 	       String IDS=String.valueOf(ID1);
		 	       Formulario.IDclientePantalla=IDS;
	 	            System.out.print("dato cliente:"+IDS+Formulario.IDclientePantalla);
	 	          }
	            
	            // Free memory 
	            res.close();  
	        } 
	        catch (Exception e) 
	        {   
	            System.err.println("Warning: SELECT JOIN clientes: " + e.getMessage());    
	        } 
	    }
	    
	    public static void ConsultaclientesPantallaIDclienteMenu(int ID) //refresca la pantalla con los datos actuales 
	    { 
	    	
	        try 
	        {  
	        	 st.executeUpdate(sqluse);
	            // Mostramos por pantalla los clientes seleccionados por el ID 
	        	 sql = "SELECT * FROM puntoscomida WHERE ID="+ID;
	            res = st.executeQuery(sql);
	          
	           
	            
	            while(res.next()){
	            	
	 	            int ID1=res.getInt("ID");
	 	            int PUNTOS_ACTUALES=res.getInt("PUNTOS_ACTUALES");
	 	            String REGALOS_ACUMULADOS=res.getString("REGALOS_ACUMULADOS");
	 	            
	 	           
		 	       Formulario.texto_PremiosC.setText(REGALOS_ACUMULADOS);
		 	       String IDS=String.valueOf(ID1);
		 	       Formulario.IDclientePantalla=IDS;
		 	       String PuntosT=String.valueOf(PUNTOS_ACTUALES);
		 	       Formulario.texto_SaldoActualC.setText(PuntosT);
	            }
	 	        // Free memory 
	            res.close();  
	        } 
	        catch (Exception e) 
	        {   
	            System.err.println("Warning: SELECT JOIN puntoscomida: " + e.getMessage());    
	        } 
	    }
	    public static void ConsultaclientesPantallaIDclienteDesayunos(int ID) //refresca la pantalla con los datos actuales 
	    { 
	    	
	        try 
	        {  
	        	 st.executeUpdate(sqluse);
	            // Mostramos por pantalla los clientes seleccionados por el ID 
	        	 sql = "SELECT * FROM puntosdesayunos WHERE ID="+ID;
	            res = st.executeQuery(sql);
	          
	           
	            
	            while(res.next()){
	            	
	 	            int ID1=res.getInt("ID");
	 	            int PUNTOS_ACTUALES=res.getInt("PUNTOS_ACTUALES");
	 	            String REGALOS_ACUMULADOS=res.getString("REGALOS_ACUMULADOS");
	 	            
	 	           
		 	       Formulario.texto_PremiosD.setText(REGALOS_ACUMULADOS);
		 	       String IDS=String.valueOf(ID1);
		 	       Formulario.IDclientePantalla=IDS;
		 	       String PuntosT=String.valueOf(PUNTOS_ACTUALES);
		 	       Formulario.texto_SaldoActualD.setText(PuntosT);
	            }
	 	        // Free memory 
	            res.close();  
	        } 
	        catch (Exception e) 
	        {   
	            System.err.println("Warning: SELECT JOIN puntosdesayuno: " + e.getMessage());    
	        } 
	    }
	    
	    public static void ConsultaclientesPantallaIDclienteImportes(int ID) //refresca la pantalla con los datos actuales 
	    { 
	    	
	        try
	        {  
	        	 st.executeUpdate(sqluse);
	            // Mostramos por pantalla los clientes seleccionados por el ID 
	        	 sql = "SELECT * FROM puntosimporte WHERE ID="+ID;
	            res = st.executeQuery(sql);
	          
	           
	            
	            while(res.next()){
	            	
	 	            int ID1=res.getInt("ID");
	 	            int PUNTOS_ACTUALES=res.getInt("PUNTOS_ACTUALES");
	 	            String REGALOS_ACUMULADOS=res.getString("REGALOS_ACUMULADOS");
	 	            
	 	           
		 	       Formulario.texto_PremiosI.setText(REGALOS_ACUMULADOS);
		 	       String IDS=String.valueOf(ID1);
		 	       Formulario.IDclientePantalla=IDS;
		 	       String PuntosT=String.valueOf(PUNTOS_ACTUALES);
		 	       Formulario.texto_SaldoActualI.setText(PuntosT);
	            }
	 	        // Free memory 
	            res.close();  
	        } 
	        catch (Exception e) 
	        {   
	            System.err.println("Warning: SELECT JOIN puntosimporte: " + e.getMessage());    
	        } 
	    }
	    
	    
	    public static void ConsultaPuntosPantallaDesayunos(int Codigo) 
	    { 
	    	
	        try 
	        {  
	        	 st.executeUpdate(sqluse);
	            // Mostramos por pantalla los puntos de desayunos seleccionados por el codigo 
	        	 sql = "SELECT * FROM puntosdesayunos WHERE id="+Codigo;
	            res = st.executeQuery(sql);
	          
	           
	            
	            while(res.next()){
	              int PuntosA=res.getInt("PUNTOS_ACTUALES");
	 	          String PremiosA=res.getString("REGALOS_ACUMULADOS");
		 	       Formulario.texto_PremiosD.setText(PremiosA);
		 	       String puntA=String.valueOf(PuntosA);
		 	       Formulario.texto_SaldoActualD.setText(puntA);
		 	      System.out.print("dato cliente:"+Formulario.texto_PremiosD+Formulario.texto_PremiosD);
	 	           
	 	          }
	            
	            // Free memory 
	            res.close();  
	        } 
	        catch (Exception e) 
	        {   
	            System.err.println("Warning: SELECT JOIN clientes: " + e.getMessage());    
	        } 
	    }
	    
	    public static void ConsultaPuntosPantallaMenus(int Codigo) 
	    { 
	    	
	        try 
	        {  
	        	 st.executeUpdate(sqluse);
	            // Mostramos por pantalla los puntos de comida seleccionados por el codigo 
	        	 sql = "SELECT * FROM puntoscomida WHERE id="+Codigo;
	            res = st.executeQuery(sql);
	          
	           
	            
	            while(res.next()){
	              int PuntosA=res.getInt("PUNTOS_ACTUALES");
	 	          String PremiosA=res.getString("REGALOS_ACUMULADOS");
		 	       Formulario.texto_PremiosC.setText(PremiosA);
		 	       String puntA=String.valueOf(PuntosA);
		 	       Formulario.texto_SaldoActualC.setText(puntA);
		 	      
	 	           
	 	          }
	            
	            // Free memory 
	            res.close();  
	        } 
	        catch (Exception e) 
	        {   
	            System.err.println("Warning: SELECT JOIN clientes: " + e.getMessage());    
	        } 
	    }
	    
	    public static void ConsultaPuntosPantallaImportes(int Codigo) 
	    { 
	    	
	        try 
	        {  
	        	
	        	
	        	 st.executeUpdate(sqluse);
	            // Mostramos por pantalla los puntosimporte selecionados por el codigo 
	        	 sql = "SELECT * FROM puntosimporte WHERE id="+Codigo;
	            res = st.executeQuery(sql);
	          
	           
	            
	            while(res.next()){
	              int PuntosA=res.getInt("PUNTOS_ACTUALES");
	 	          String PremiosA=res.getString("REGALOS_ACUMULADOS");
		 	       Formulario.texto_PremiosI.setText(PremiosA);
		 	       String puntA=String.valueOf(PuntosA);
		 	       Formulario.texto_SaldoActualI.setText(puntA);
		 	      
	 	           
	 	          }
	            
	            // Free memory 
	            res.close();  
	        } 
	        catch (Exception e) 
	        {   
	            System.err.println("Warning: SELECT JOIN clientes: " + e.getMessage());    
	        } 
	    }
	       public static void EliminarRegistroCliente(String Codigo){
	    	  try
	    	  {
	    		st.executeUpdate(sqluse);
	    	    sql = "DELETE FROM clientes WHERE CODIGOBARRASGENERADO="+Codigo+" OR "+"TELEFONO="+Codigo+ " OR "+"ID="+Codigo;
	    	    psBorrar=con.prepareStatement(sql);
	    	    psBorrar.execute(); 
	    	    
		     }
	    	
	         catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN clientes: " + e.getMessage());    
		        } 
	       }   
         
	       public static void EliminarIDDesayuno(int ID){
		    	  try
		    	  {
		    		st.executeUpdate(sqluse);
		    	    sql = "DELETE FROM puntosdesayunos WHERE ID=?";
		    	    psBorrar=con.prepareStatement(sql);
		    	    psBorrar.setInt(1,ID);
		    	    psBorrar.execute();     
			     }
		    	
		         catch (Exception e) 
			        {   
			            System.err.println("Warning: SELECT JOIN puntosdesayunos:" + e.getMessage());    
			        } 
		       } 
	       
	       
	       public static void EliminarIDTablaConsumoDiario(int ID){
		    	  try
		    	  {
		    		st.executeUpdate(sqluse);
		    	    sql = "DELETE FROM tablaconsumodiario WHERE ID=?";
		    	    psBorrar=con.prepareStatement(sql);
		    	    psBorrar.setInt(1,ID);
		    	    psBorrar.execute();     
			     }
		    	
		         catch (Exception e) 
			        {   
			            System.err.println("Warning: SELECT JOIN tablaconsumoEliminacion:" + e.getMessage());    
			        } 
		       } 
	       public static void EliminarIDTablaRegalosPendientes(int ID){
		    	  try
		    	  {
		    		st.executeUpdate(sqluse);
		    	    sql = "DELETE FROM tablaregalospendientes WHERE ID=?";
		    	    psBorrar=con.prepareStatement(sql);
		    	    psBorrar.setInt(1,ID);
		    	    psBorrar.execute();     
			     }
		    	
		         catch (Exception e) 
			        {   
			            System.err.println("Warning: SELECT JOIN tablaregalospendienteseliminacion:" + e.getMessage());    
			        } 
		       } 
	       public static void EliminarIDTablaDiaria(int ID){
		    	  try
		    	  {
		    		st.executeUpdate(sqluse);
		    	    sql = "DELETE FROM tabladiaria WHERE ID=?";
		    	    psBorrar=con.prepareStatement(sql);
		    	    psBorrar.setInt(1,ID);
		    	    psBorrar.execute();     
			     }
		    	
		         catch (Exception e) 
			        {   
			            System.err.println("Warning: SELECT JOIN tabladiariaeliminacion:" + e.getMessage());    
			        } 
		       } 
	       
	        public static void EliminarUlDesayuno(int ID){
	        	 
	        	   try 
	   	        {   
	   	        	
	   	            // Mostramos por pantalla los clientes seleccionados por el ID 
	        	
	        	sql =" UPDATE tablaregalospendientes  SET PREMIOSDESAYUNOS=PREMIOSDESAYUNOS"+"-" +"1"+" WHERE id="+ID;
	   	        	st.executeUpdate(sql);
	   	        } 
	   	        catch (Exception e) 
	   	        {   
	   	            System.err.println("Warning: SELECT JOIN eliminarUltimoDesayuno: " + e.getMessage());    
	   	        } 
	   	    }
	        
	      
	        public static void AnularDesayunoConsumido(int ID){
	        	 
	        	   try 
	   	        {   
	        		   psInsertar=con.prepareStatement("INSERT INTO tablaconsumodiario(ID,FECHA_DIARIA,CONSUMIDOSDESAYUNOS,PREMIOSDESAYUNOS) VALUES (?,?,?,?)");
	     	           psInsertar.setInt(1,ID);
	     	           psInsertar.setString(2,Formulario.FechaEntradaMysql);
	     	    	   psInsertar.setInt(3,-11);
	     	    	   psInsertar.setString(4,"DesayunoAnulado");
	   	        	   psInsertar.executeUpdate(); 
	   	        } 
	   	        catch (Exception e) 
	   	        {   
	   	            System.err.println("Warning: SELECT JOIN anularDesayunoconsumido: " + e.getMessage());    
	   	        } 
	   	    }
	        public static void AnularMenuConsumido(int ID){
	        	 
	        	   try 
	   	        {   
	        		   psInsertar=con.prepareStatement("INSERT INTO tablaconsumodiario(ID,FECHA_DIARIA,CONSUMIDOSMENUS,PREMIOSMENUS) VALUES (?,?,?,?)");
	     	           psInsertar.setInt(1,ID);
	     	           psInsertar.setString(2,Formulario.FechaEntradaMysql);
	     	    	   psInsertar.setInt(3,-11);
	     	    	   psInsertar.setString(4,"MenuAnulado");
	   	        	   psInsertar.executeUpdate(); 
	   	        } 
	   	        catch (Exception e) 
	   	        {   
	   	            System.err.println("Warning: SELECT JOIN anularMenuconsumido: " + e.getMessage());    
	   	        } 
	   	    }
	   	    
	    
	     
	        public static void AnularImporteConsumido(int ID){
	        	 
	        	   try 
	   	        {   
	        		   psInsertar=con.prepareStatement("INSERT INTO tablaconsumodiario(ID,FECHA_DIARIA,CONSUMIDOSIMPORTES,PREMIOSIMPORTES) VALUES (?,?,?,?)");
	     	           psInsertar.setInt(1,ID);
	     	           psInsertar.setString(2,Formulario.FechaEntradaMysql);
	     	    	   psInsertar.setInt(3,-11);
	     	    	   psInsertar.setString(4,"ImporteAnulado");
	   	        	   psInsertar.executeUpdate(); 
	   	        } 
	   	        catch (Exception e) 
	   	        {   
	   	            System.err.println("Warning: SELECT JOIN anularImporteConsumido: " + e.getMessage());    
	   	        } 
	   	    }
	       public static void EliminarIDMenu(int ID){
		    	  try
		    	  {
		    		st.executeUpdate(sqluse);
		    	    sql = "DELETE FROM puntoscomida WHERE ID=?";
		    	    psBorrar=con.prepareStatement(sql);
		    	    psBorrar.setInt(1,ID);
		    	    psBorrar.execute();     
			     }
		    	
		         catch (Exception e) 
			        {   
			            System.err.println("Warning: SELECT JOIN puntoscomida:" + e.getMessage());    
			        } 
		       } 
	       public static void EliminarUlMenu(int ID){
	        	 
        	   try 
   	        {   
   	        	
   	            sql =" UPDATE tablaregalospendientes  SET PREMIOSMENUS=PREMIOSMENUS"+"-" +"1"+" WHERE id="+ID;
   	        	st.executeUpdate(sql);
   	        } 
   	        catch (Exception e) 
   	        {   
   	            System.err.println("Warning: SELECT JOIN eliminarUltimoMenu: " + e.getMessage());    
   	        } 
   	    }
   	    
	       public static void EliminarIDImporte(int ID){
		    	  try
		    	  {
		    		st.executeUpdate(sqluse);
		    	    sql = "DELETE FROM puntosimporte WHERE ID=?";
		    	    psBorrar=con.prepareStatement(sql);
		    	    psBorrar.setInt(1,ID);
		    	    psBorrar.execute();     
			     }
		    	
		         catch (Exception e) 
			        {   
			            System.err.println("Warning: SELECT JOIN puntosimporte:" + e.getMessage());    
			        } 
		       }  
	       
	       public static void EliminarUlImporte(int ID){
	        	 
        	   try 
   	        {   
   	        	
   	            // Mostramos por pantalla los clientes seleccionados por el ID 
        		   sql =" UPDATE tablaregalospendientes  SET PREMIOSIMPORTES=PREMIOSIMPORTES"+"-" +"1"+" WHERE id="+ID;
	   	           st.executeUpdate(sql);
   	        } 
   	        catch (Exception e) 
   	        {   
   	            System.err.println("Warning: SELECT JOIN eliminarUltimoDesayuno: " + e.getMessage());    
   	        } 
   	    }
	       public static void ModificarCodigoBarras(String Codigo1, int ID){
	    	   
	    	   try
	    	   {
	    		st.executeUpdate(sqluse);
	    	   sql ="UPDATE clientes SET CODIGOBARRASGENERADO="+Codigo1 + " WHERE ID="+ID;
	    	   st.execute(sql);
	    	
		        }
	    	   
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN clientes: " + e.getMessage());    
		        } 
	    	   }
          
          public static void ModificarNombre(String Nombre, String Codigo){
	    	   
	    	   try
	    	   {
	    		   String NombreModificado=Nombre;
	    	   
	    	   st.executeUpdate(sqluse);
	    	   st.execute("UPDATE clientes SET NOMBRE='"+NombreModificado+"'"+ "WHERE CODIGOBARRASGENERADO="+Codigo+" OR "+"TELEFONO="+Codigo+" OR "+"ID="+Codigo);
	    	   st.close();
	    	   
	    	
		        }
	    	   
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN clientes: " + e.getMessage());    
		        } 
	    	   }
       
          public static void ModificarApellido1(String Apellido1, String Codigo){
	    	   
	    	   try
	    	   {
	    	   st.executeUpdate(sqluse);
	    	   sql =" UPDATE clientes SET 1apellido='"+Apellido1+"'"+"WHERE CODIGOBARRASGENERADO="+Codigo+" OR "+"TELEFONO="+Codigo+" OR "+"ID="+Codigo;
	    	   st.execute(sql);
	    	   st.close();
		        }
	    	   
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN clientes: " + e.getMessage());    
		        } 
	    	   
	    	   }
          public static void ModificarApellido2(String Apellido2, String Codigo){
	    	   
	    	   try
	    	   {
	    	   st.executeUpdate(sqluse);
	    	   sql =" UPDATE clientes SET 2apellido='"+Apellido2+"'"+"WHERE CODIGOBARRASGENERADO="+Codigo+" OR "+"TELEFONO="+Codigo+" OR "+"ID="+Codigo;
	    	   st.execute(sql);
	    	
		        }
	    	   
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN clientes: " + e.getMessage());    
		        } 
	    	   }
          public static void ModificarDIRECCION(String DIRECCION, String Codigo){
	    	   
	    	   try
	    	   {
	    	   
	    	   sql =" UPDATE clientes SET DIRECCION='"+DIRECCION+"'"+"WHERE CODIGOBARRASGENERADO="+Codigo+" OR "+"TELEFONO="+Codigo+" OR "+"ID="+Codigo;
	    	   st.execute(sql);
	    	
		        }
	    	   
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN clientes: " + e.getMessage());    
		        } 
	    	   }
	    	   
	    	
          
          public static void ModificarCODIGOPOSTAL(String CODIGOPOSTAL, String Codigo){
	    	   
	    	   try
	    	   {
	    		st.executeUpdate(sqluse);
	    	   sql ="UPDATE clientes SET CODIGOPOSTAL='"+CODIGOPOSTAL+"'"+"WHERE CODIGOBARRASGENERADO="+Codigo+" OR "+"TELEFONO="+Codigo+" OR "+"ID="+Codigo;
	    	   st.execute(sql);
	    	
		        }
	    	   
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN clientes: " + e.getMessage());    
		        } 
	    	   }
             
          public static void ModificarEmail(String Email, String Codigo){
	    	   
	    	   try
	    	   {
	    		st.executeUpdate(sqluse);
	    	   sql =" UPDATE clientes SET email='"+Email+"'"+"WHERE CODIGOBARRASGENERADO="+Codigo+" OR "+"TELEFONO="+Codigo+" OR "+"ID="+Codigo;
	    	   st.execute(sql);
	    	
		        }
	    	   
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN clientes: " + e.getMessage());    
		        } 
	    	   }
          public static void ModificarTelefono(String Telefono, String Codigo){
	    	   
	    	   try
	    	   {
	    		st.executeUpdate(sqluse);
	    	   sql =" UPDATE clientes SET TELEFONO='"+Telefono+"'"+"WHERE CODIGOBARRASGENERADO="+Codigo+" OR "+"TELEFONO="+Codigo+" OR "+"ID="+Codigo;
	    	   st.execute(sql);
	    	
		        }
	    	   
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN clientes: " + e.getMessage());    
		        } 
	    	   }
          
       
         
          public static void insertTablaDesayunos(int ID,String Fecha){
  	    		
  	    		
  	    { 
  	        // Insertamos datos   
  	        try 
  	        {   st.executeUpdate(sqluse);
  	            psInsertar=con.prepareStatement("INSERT INTO PuntosDesayunos VALUES (?,?,?,?,?)");
  	            psInsertar.setInt(1,ID);
  	            psInsertar.setString(2,Fecha);
  	            psInsertar.setInt(3,0);
  	    	    psInsertar.setString(4,"0");
  	    	    psInsertar.setString(5,"0");
	        	psInsertar.executeUpdate();
  	        	
  	        } 
  	        catch (Exception e) 
  	        {   
  	            System.err.println("Warning: error on insert data: " + e.getMessage());    
  	            e.printStackTrace(); 
  	            return;  
  	        }  
  	    } 
         
       }
          public static void insertTablaMenus(int ID, String Fecha){
	    		
	    		
        	    { 
        	        // Insertamos datos   
        	        try 
        	        {   st.executeUpdate(sqluse);
        	            psInsertar=con.prepareStatement("INSERT INTO puntoscomida VALUES (?,?,?,?,?)");
        	            psInsertar.setInt(1,ID);
        	            psInsertar.setString(2,Fecha);
        	            psInsertar.setInt(3,0);
        	    	    psInsertar.setString(4,"0");
        	    	    psInsertar.setString(5,"0");
      	        	    psInsertar.executeUpdate();
        	        	
        	        } 
        	        catch (Exception e) 
        	        {   
        	            System.err.println("Warning: error on insert data: " + e.getMessage());    
        	            e.printStackTrace(); 
        	            return;  
        	        }  
        	    } 
               
             }
            
          
          public static void insertConfiguracionLector(String Com, int longitudLector, int intervalomsg){
	    		
	    		
      	    { 
      	        // Insertamos datos   
      	        try 
      	        {   st.executeUpdate(sqluse);
      	            psInsertar=con.prepareStatement("INSERT INTO configuracionlector VALUES (?,?,?)");
      	            psInsertar.setString(1,Com);
      	            psInsertar.setInt(2,longitudLector);
      	    	    psInsertar.setInt(3,intervalomsg);
    	            psInsertar.executeUpdate();
    	            
    	            
      	        	
      	        } 
      	    
      	        catch (Exception e) 
      	        {   
      	            System.err.println("Warning: error on insertconfiguracionlector: " + e.getMessage());    
      	            e.printStackTrace(); 
      	            return;  
      	        }  
      	    } 
             
           }
          
          public static void insertConfiguracion(String Contraseña, int Licencia, String Fecha,String Establecimiento, String NIF){
	    		
	    		
        	    { 
        	        // Insertamos datos   
        	        try 
        	        {   st.executeUpdate(sqluse);
        	            psInsertar=con.prepareStatement("INSERT INTO configuracion VALUES (?,?,?,?,?,?)");
        	            psInsertar.setString(1,Contraseña);
        	            psInsertar.setInt(2,Licencia);
        	    	    psInsertar.setString(3,Fecha);
        	    	    psInsertar.setInt(4,0);
        	    	    psInsertar.setString(5,Establecimiento);
        	    	    psInsertar.setString(6,NIF);
      	                psInsertar.executeUpdate();
      	         
        	        } 
        	        catch (Exception e) 
        	        {   
        	            System.err.println("Warning: error on insertconfiguracionlector: " + e.getMessage());    
        	            e.printStackTrace(); 
        	            return;  
        	        }  
        	    } 
               
             }
          public static void insertTablaImportes(int ID, String Fecha){
	    		
	    		
      	    { 
      	        // Insertamos datos   
      	        try 
      	        {   st.executeUpdate(sqluse);
      	            psInsertar=con.prepareStatement("INSERT INTO PuntosImporte VALUES (?,?,?,?,?)");
      	            psInsertar.setInt(1,ID);
      	            psInsertar.setString(2,Fecha);
      	            psInsertar.setInt(3,0);
      	    	    psInsertar.setString(4,"0");
      	    	    psInsertar.setString(5,"0");
    	        	psInsertar.executeUpdate();
      	        	
      	        } 
      	        catch (Exception e) 
      	        {   
      	            System.err.println("Warning: error on insert data: " + e.getMessage());    
      	            e.printStackTrace(); 
      	            return;  
      	        }  
      	    } 
             
           }
          
          public static void insertTablaDiaria(int ID,String Fecha){
	    		
	    		
        	    { 
        	        // Insertamos datos   
        	        try 
        	        {   st.executeUpdate(sqluse);
        	            psInsertar=con.prepareStatement("INSERT INTO tabladiaria VALUES (?,?,?,?,?)");
        	            psInsertar.setInt(1,ID);
        	            psInsertar.setString(2,Fecha);
        	    	    psInsertar.setInt(3,0);
        	    	    psInsertar.setInt(4,0);
        	    	    psInsertar.setInt(5,0);
        	      	    psInsertar.executeUpdate();
        	        	
        	        }
        	    
        	        catch (Exception e) 
        	        {   
        	            System.err.println("Warning: error on insert data: " + e.getMessage());    
        	            e.printStackTrace(); 
        	            return;  
        	        }  
        	    } 
          }   
        	    public static void inserRegistroDiario(String Fecha, String Codigo,int ID, String TipoTabla,
        	    		                               String TipoOperacion,String Cantidad){
    	    		
    	    		
            	    { 
            	        // Insertamos datos   
            	        try 
            	        {   st.executeUpdate(sqluse);
            	            psInsertar=con.prepareStatement("INSERT INTO RegistroDiario VALUES (?,?,?,?,?,?)");
                            psInsertar.setString(1,Fecha);
            	            psInsertar.setString(2,Codigo);
            	            psInsertar.setInt(3,ID);
            	            psInsertar.setString(4,TipoTabla);
            	            psInsertar.setString(5,TipoOperacion);
            	            psInsertar.setString(6,Cantidad);
            	    	    psInsertar.executeUpdate();
            	         } 
            	        catch (Exception e) 
            	        {   
            	            System.err.println("Warning: error on insert data: " + e.getMessage());    
            	            e.printStackTrace(); 
            	            return;  
            	        }  
            	    } 
               
             }
          
          public static void insertTablaConsumoDiario(int ID,String Fecha){
	    		
	    		
      	    { 
      	        // Insertamos datos   
      	        try 
      	        {   st.executeUpdate(sqluse);
      	            psInsertar=con.prepareStatement("INSERT INTO tablaconsumodiario VALUES (?,?,?,?,?,?,?,?)");
      	            psInsertar.setInt(1,ID);
      	            psInsertar.setString(2,Fecha);
      	    	    psInsertar.setInt(3,0);
      	    	    psInsertar.setInt(4,0);
      	    	    psInsertar.setInt(5,0);
      	    	    psInsertar.setString(6,"0");
      	    	    psInsertar.setString(7,"0");
      	    	    psInsertar.setString(8,"0");
      	      	    psInsertar.executeUpdate();
      	        	
      	        } 
      	        catch (Exception e) 
      	        {   
      	            System.err.println("Warning: error on insert data: " + e.getMessage());    
      	            e.printStackTrace(); 
      	            return;  
      	        }  
      	    } 
             
          }
          
          public static void insertTablaRegalosPendientes(int ID,String Fecha){
	    		
	    		
        	    { 
        	        // Insertamos datos   
        	        try 
        	        {   st.executeUpdate(sqluse);
        	            psInsertar=con.prepareStatement("INSERT INTO tablaRegalosPendientes VALUES (?,?,?,?,?)");
        	            psInsertar.setInt(1,ID);
        	            psInsertar.setString(2,Fecha);
        	    	    psInsertar.setString(3,"0");
        	    	    psInsertar.setString(4,"0");
        	    	    psInsertar.setString(5,"0");
        	      	    psInsertar.executeUpdate();
        	        	
        	        } 
        	        catch (Exception e) 
        	        {   
        	            System.err.println("Warning: error on insert data: " + e.getMessage());    
        	            e.printStackTrace(); 
        	            return;  
        	        }  
        	    } 
               
            }
          
          public static void insertTablaFidelizacion(int puntosDesayunos, String PremiosDesayunos, int puntosMenu, String PremiosMenu,int puntosImporte, String PremiosImporte, 
           int puntospordesayuno, int puntospormenu, int puntosporimporte){
	    		
	    		
      	    { 
      	        // Insertamos datos   
      	        try 
      	        {  
      	        	BorrarTablaFidelizacion();
      	        	st.executeUpdate(sqluse);
      	            psInsertar=con.prepareStatement("INSERT INTO PuntosFidelizacion  VALUES (?,?,?,?,?,?,?,?,?)");
      	            psInsertar.setInt(1,puntosDesayunos);
      	            psInsertar.setString(2,PremiosDesayunos);
      	    	    psInsertar.setInt(3,puntosMenu);
      	    	    psInsertar.setString(4,PremiosMenu);
      	    	    psInsertar.setInt(5,puntosImporte);
    	    	    psInsertar.setString(6,PremiosImporte);
    	    	    psInsertar.setInt(7,puntospordesayuno);
    	    	    psInsertar.setInt(8,puntospormenu);
    	    	    psInsertar.setInt(9,puntosporimporte);
    	        	psInsertar.executeUpdate();
    	        	int puntosDesayunoActuales=puntospordesayuno;
    	        	int puntosMenuActuales=puntospormenu;
    	        	int puntosImporteActuales=puntosporimporte;
    	        	Formulario.puntosporDesayuno=puntosDesayunoActuales;
    	        	Formulario.puntosporMenu=puntosMenuActuales;
    	        	Formulario.puntosporImporte=puntosImporteActuales;
      	        	
      	        } 
      	        catch (Exception e) 
      	        {   
      	            System.err.println("Warning: error on insert data: " + e.getMessage());    
      	            e.printStackTrace(); 
      	            return;  
      	        }  
      	    } 
             
           }
          
          public static void ConsultaFidelizacion() 
  	    { 
  	    	
  	        try 
  	        {  
  	            // Mostramos por pantalla todos los CLIENTES 
  	        	 st.executeUpdate(sqluse);
  	        	 sql = "SELECT * FROM PuntosFidelizacion";
  	            res = st.executeQuery(sql);
  	           
  	            
  	            while(res.next()){
  	            	int PuntosDesayunos=res.getInt("INCREMENTODESAYUNOS");
  	            	String TipoPremiosD=res.getString("PREMIOSDESAYUNOS");
  	            	int MenuPuntos=res.getInt("INCREMENTOMENU");
  	            	String TipoPremiosM=res.getString("PREMIOSMENU");
  	            	int PuntosImportes=res.getInt("INCREMENTOIMPORTE");
  	            	String TipoPremiosI=res.getString("PREMIOSIMPORTE");
  	            	int puntospordesayuno=res.getInt("PUNTOSDESAYUNO");
  	            	int puntospormenu=res.getInt("PUNTOSMENU");
  	            	int puntosporimporte=res.getInt("PUNTOSIMPORTE");
  	            	
  	           FidelizacionAdministrador.ConsultarFidelizacion(MenuPuntos, TipoPremiosM, PuntosDesayunos, TipoPremiosD, PuntosImportes, 
  	            TipoPremiosI,puntospordesayuno,puntospormenu,puntosporimporte);
  	            	
  	            }
  	            
  	 	
  	            
  	            // Free memory 
  	            res.close();  
  	        } 
  	        catch (Exception e) 
  	        {   
  	            System.err.println("Warning: SELECT JOIN PuntosFidelizacion: " + e.getMessage());    
  	        } 
  	    }
          public static void ConfigurarPuntosFidelizacion() 
    	    { 
    	    	
    	        try 
    	        {  
    	            // Mostramos por pantalla todos los CLIENTES 
    	        	 st.executeUpdate(sqluse);
    	        	 sql = "SELECT * FROM PuntosFidelizacion";
    	            res = st.executeQuery(sql);
    	           
    	            
    	            while(res.next()){
    	            
    	            	int puntospordesayuno=res.getInt("PUNTOSDESAYUNO");
    	            	int puntospormenu=res.getInt("PUNTOSMENU");
    	            	int puntosporimporte=res.getInt("PUNTOSIMPORTE");
    	                Formulario.puntosporDesayuno=puntospordesayuno;
    	                Formulario.puntosporMenu=puntospormenu;
    	                Formulario.puntosporImporte=puntosporimporte;
    	                Formulario.premioPuntosDesayuno=res.getInt("INCREMENTODESAYUNOS");
    	                Formulario.premioPuntosMenu=res.getInt("INCREMENTOMENU");
    	                Formulario.premioPuntosImporte=res.getInt("INCREMENTOIMPORTE");
    	                Formulario.PremioDesayunoF=res.getString("PREMIOSDESAYUNOS");
    	                Formulario.PremioMenuF=res.getString("PREMIOSMENU");
    	                Formulario.PremioImporteF=res.getString("PREMIOSIMPORTE");
    	            	
    	            }
    	            
    	 	
    	            
    	            // Free memory 
    	            res.close();  
    	        } 
    	        catch (Exception e) 
    	        {   
    	            System.err.println("Warning: SELECT JOIN ConfigurarPuntosFidelizacion: " + e.getMessage());    
    	        } 
    	    }
    	    
          public static void ActualizarSaldoPuntosMenu(String cantidad, int ID){
	    	   
	    	   try
	    	   {
	    		st.executeUpdate(sqluse);
	    	   sql =" UPDATE puntoscomida SET PUNTOS_ACTUALES=PUNTOS_ACTUALES"+"+" +cantidad+" WHERE id="+ID;
	    	   st.execute(sql);
	    	
		        }
	    	   
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN puntoscomida: " + e.getMessage());    
		        } 
	    	   }
           
          public static void ActualizarSaldoPuntosMenuAnulada(String cantidad, int ID){
	    	   
	    	   try
	    	   {
	    		st.executeUpdate(sqluse);
	    	   sql =" UPDATE puntoscomida SET PUNTOS_ACTUALES=PUNTOS_ACTUALES"+"-" +cantidad+" WHERE id="+ID;
	    	   st.execute(sql);
	    	
		        }
	    	   
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN puntoscomida: " + e.getMessage());    
		        } 
	    	   }
          
          public static void ActualizarSaldoPuntosDesayunos(String cantidad, int ID){
	    	   
	    	   try
	    	   {
	    		 st.executeUpdate(sqluse);
	    	   sql =" UPDATE puntosdesayunos  SET PUNTOS_ACTUALES=PUNTOS_ACTUALES"+"+" +cantidad+" WHERE id="+ID;
	    	   st.execute(sql);
	    	
		        }
	    	   
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN puntoscomida: " + e.getMessage());    
		        } 
	    	   }
          public static void ActualizarSaldoPuntosDesayunosAnulada(String cantidad, int ID){
	    	   
	    	   try
	    	   {
	    		 st.executeUpdate(sqluse);
	    	   sql =" UPDATE puntosdesayunos  SET PUNTOS_ACTUALES=PUNTOS_ACTUALES"+"-" +cantidad+" WHERE id="+ID;
	    	   st.execute(sql);
	    	
		        }
	    	   
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN puntoscomida: " + e.getMessage());    
		        } 
	    	   }
  	      
          public static void ActualizarContraseña(String Contraseña){
	    	   
	    	   try
	    	   {
	    		 st.executeUpdate(sqluse);
	    	   sql =" UPDATE configuracion  SET CONTRASEÑA="+Contraseña;
	    	   st.execute(sql);
	          }
	    	   
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN ActualizarContraseña: " + e.getMessage());    
		        } 
	    	   }
        	  
          public static void ActualizarDiasDemo(){
	    	   
	    	   try
	    	   {
	    		 st.executeUpdate(sqluse);
	    	   sql="SELECT CONTRASEÑA, TO_DAYS(CURRENT_DATE)- TO_DAYS(FECHA) AS DIASDEMO FROM configuracion";
	    	   st.execute(sql);
	          }
	    	   
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN ActualizarContraseña: " + e.getMessage());    
		        } 
	    	   }
       	  
          public static void ActualizarTabladiariaDesayunos(int ID,String Fecha,String cantidad ){
	    	   
	    	   try
	    	   {
	    		   st.executeUpdate(sqluse);
	    		   if(Fecha.equals(Formulario.getFecha_AnteriorMysql())){
	    			 System.out.println(Fecha);
	    			 sql =" UPDATE tabladiaria SET DESAYUNOS=DESAYUNOS"+"+"+cantidad+" WHERE ID="+ID;
	    	    	 st.execute(sql);  
	    	    	 }else{
	    			   psInsertar=con.prepareStatement("INSERT INTO tabladiaria(ID,FECHA_DIARIA,DESAYUNOS) VALUES (?,?,?)");
	     	           psInsertar.setInt(1,ID);
	     	           psInsertar.setString(2,Fecha);
	     	           int cantidadI=Integer.parseInt(cantidad);
	     	    	   psInsertar.setInt(3,cantidadI);
	   	        	   psInsertar.executeUpdate(); 
	   	        	 System.out.println(Formulario.getFecha_AnteriorMysql()+Fecha);
	    		   }
	    	   }
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN TablaDiariaDesayunos: " + e.getMessage());    
		        }
	    	   
	    	   }
          
          public static void AnularTabladiariaDesayunos(int ID,String Fecha,String cantidad ){
	    	   
	    	   try
	    	   {
	    		       psInsertar=con.prepareStatement("INSERT INTO tabladiaria(ID,FECHA_DIARIA,DESAYUNOS) VALUES (?,?,?)");
	     	           psInsertar.setInt(1,ID);
	     	           psInsertar.setString(2,Fecha);
	     	           int cantidadI=Integer.parseInt(cantidad);
	     	    	   psInsertar.setInt(3,-cantidadI);
	   	        	   psInsertar.executeUpdate(); 
	   	        	 System.out.println(Formulario.getFecha_AnteriorMysql()+Fecha);
	    		   
	    	   }
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN anularTablaDiariaDesayunos: " + e.getMessage());    
		        }
	    	   
	    	   }
          public static void AnularTabladiariaMenus(int ID,String Fecha,String cantidad ){
	    	   
	    	   try
	    	   {
	    		       psInsertar=con.prepareStatement("INSERT INTO tabladiaria(ID,FECHA_DIARIA,MENUS) VALUES (?,?,?)");
	     	           psInsertar.setInt(1,ID);
	     	           psInsertar.setString(2,Fecha);
	     	           int cantidadI=Integer.parseInt(cantidad);
	     	    	   psInsertar.setInt(3,-cantidadI);
	   	        	   psInsertar.executeUpdate(); 
	   	        	 System.out.println(Formulario.getFecha_AnteriorMysql()+Fecha);
	    		   
	    	   }
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN anularTablaDiariaDesayunos: " + e.getMessage());    
		        }
	    	   
	    	   }
          public static void AnularTabladiariaImportes(int ID,String Fecha,String cantidad ){
	    	   
	    	   try
	    	   {
	    		       psInsertar=con.prepareStatement("INSERT INTO tabladiaria(ID,FECHA_DIARIA,IMPORTES) VALUES (?,?,?)");
	     	           psInsertar.setInt(1,ID);
	     	           psInsertar.setString(2,Fecha);
	     	           int cantidadI=Integer.parseInt(cantidad);
	     	    	   psInsertar.setInt(3,-cantidadI);
	   	        	   psInsertar.executeUpdate(); 
	   	        	 System.out.println(Formulario.getFecha_AnteriorMysql()+Fecha);
	    		   
	    	   }
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN anularTablaDiariaDesayunos: " + e.getMessage());    
		        }
	    	   
	    	   }
          public static void ActualizarTablaRegalosPendientesDesayuno(int ID,String Fecha,String cantidad ){
	    	   
	    	   try
	    	   {       st.executeUpdate(sqluse);
	    	   sql =" UPDATE TablaregalosPendientes  SET PREMIOSDESAYUNOS='"+cantidad+"'"+"WHERE id="+ID;
	    		      st.executeUpdate(sql); 
	    	   sql =" UPDATE TablaregalosPendientes  SET FECHA_DIARIA="+Fecha+"WHERE id="+ID;
	    		      st.executeUpdate(sql);  
	    	   }
	    	   
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN TablaRegalosPendientesDesayuno: " + e.getMessage());    
		        }
	    	   
	    	   }
         
          
          public static void ActualizarTablaConsumoDesayunos(int ID,String Fecha,int cantidad,String Premio ){
	    	   
	    	   try
	    	   {       st.executeUpdate(sqluse);
	    		       psInsertar=con.prepareStatement("INSERT INTO tablaconsumodiario(ID,FECHA_DIARIA,CONSUMIDOSDESAYUNOS,PREMIOSDESAYUNOS) VALUES (?,?,?,?)");
	     	           psInsertar.setInt(1,ID);
	     	           psInsertar.setString(2,Fecha);
	     	    	   psInsertar.setInt(3,cantidad);
	     	    	   psInsertar.setString(4,Premio);
	   	        	   psInsertar.executeUpdate(); 
	   	        	 System.out.println(Formulario.getFecha_AnteriorMysql()+Fecha);
	    		   
	    	   }
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN TablaDiariaDesayunos: " + e.getMessage());    
		        }
	    	   
	    	   }
         
         
        
          
          public static void ActualizarTabladiariaMenus(int ID,String Fecha,String cantidad ){
	    	   
	    	   try
	    	   {    st.executeUpdate(sqluse);
	    		   if(Fecha.equals(Formulario.getFecha_AnteriorMysql())){
	    			 System.out.println("equals"+Formulario.getFecha_AnteriorMysql());
	    			 sql =" UPDATE tabladiaria SET MENUS=MENUS"+"+"+cantidad+" WHERE ID="+ID;
	    	    	 st.execute(sql);  
	    	    	 }else{
	    			   psInsertar=con.prepareStatement("INSERT INTO tabladiaria(ID,FECHA_DIARIA,MENUS) VALUES (?,?,?)");
	     	           psInsertar.setInt(1,ID);
	     	           psInsertar.setString(2,Fecha);
	     	           int cantidadI=Integer.parseInt(cantidad);
	     	    	   psInsertar.setInt(3,cantidadI);
	   	        	   psInsertar.executeUpdate(); 
	   	        	 System.out.println(Formulario.getFecha_AnteriorMysql()+Fecha);
	    		   }
	    	   }
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN TablaDiariaMenus: " + e.getMessage());    
		        }
	    	   
	    	   }
          public static void ActualizarTablaRegalosPendientesMenus(int ID,String Fecha,String cantidad ){
	    	   
	    	   try
	    	   {       
	    	          st.executeUpdate(sqluse);
	    	     sql =" UPDATE TablaregalosPendientes  SET PREMIOSMENUS='"+cantidad+"'"+"WHERE id="+ID;
	    		      st.executeUpdate(sql); 
	    	    sql =" UPDATE TablaregalosPendientes  SET FECHA_DIARIA="+Fecha+"WHERE id="+ID;
	    		      st.executeUpdate(sql);  
	   	        	
	    		   
	    	   }
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN Tablaregalospendientesmenus: " + e.getMessage());    
		        }
	    	   
	    	   }
          public static void ActualizarTablaConsumoMenus(int ID,String Fecha,int cantidad,String Premio){
	    	   
	    	   try
	    	   {       st.executeUpdate(sqluse);
	    		       psInsertar=con.prepareStatement("INSERT INTO tablaconsumodiario(ID,FECHA_DIARIA,CONSUMIDOSMENUS,PREMIOSMENUS) VALUES (?,?,?,?)");
	     	           psInsertar.setInt(1,ID);
	     	           psInsertar.setString(2,Fecha);
	     	    	   psInsertar.setInt(3,cantidad);
	     	    	   psInsertar.setString(4,Premio);
	   	        	   psInsertar.executeUpdate(); 
	   	        	 System.out.println(Formulario.getFecha_AnteriorMysql()+Fecha);
	    		   
	    	   }
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN TablaDiariaDesayunos: " + e.getMessage());    
		        }
	    	   
	    	   }
          
          public static void ActualizarTablaConsumoImportes(int ID,String Fecha,String cantidad,String Premio ){
	    	   
	    	   try
	    	   {       st.executeUpdate(sqluse);
	    		       psInsertar=con.prepareStatement("INSERT INTO tablaconsumodiario(ID,FECHA_DIARIA,COSUMIDOSIMPORTES,PREMIOSIMPORTES) VALUES (?,?,?,?)");
	     	           psInsertar.setInt(1,ID);
	     	           psInsertar.setString(2,Fecha);
	     	           int cantidadI=Integer.parseInt(cantidad);
	     	    	   psInsertar.setInt(3,cantidadI);
	     	    	   psInsertar.setString(4,Premio);
	   	        	   psInsertar.executeUpdate(); 
	   	        	 System.out.println(Formulario.getFecha_AnteriorMysql()+Fecha);
	    		   
	    	   }
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN TablaDiariaDesayunos: " + e.getMessage());    
		        }
	    	   
	    	   }
          public static void ActualizarSaldoPuntosImportes(String cantidad, int ID){
	    	   
	    	   try
	    	   {
	    		 st.executeUpdate(sqluse);
	    	   sql =" UPDATE puntosimporte SET PUNTOS_ACTUALES=PUNTOS_ACTUALES"+"+" +cantidad+" WHERE id="+ID;
	    	   st.execute(sql);
	    	
		        }
	    	   
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN saldopuntosimportes: " + e.getMessage());    
		        } 
	    	   }
          public static void ActualizarSaldoPuntosImportesAnulada(String cantidad, int ID){
	    	   
	    	   try
	    	   {
	    		 st.executeUpdate(sqluse);
	    	   sql =" UPDATE puntosimporte SET PUNTOS_ACTUALES=PUNTOS_ACTUALES"+"-" +cantidad+" WHERE id="+ID;
	    	   st.execute(sql);
	    	
		        }
	    	   
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN puntoscomida: " + e.getMessage());    
		        } 
	    	   }
          
      
    
      
          public static void ActualizarTablaRegalosPendientesImportes(int ID,String Fecha,String cantidad ){
	    	   
	    	   try
	    	   {      st.executeUpdate(sqluse);
	    	   
	    	       sql =" UPDATE TablaregalosPendientes  SET PREMIOSIMPORTES='"+cantidad+"'"+"WHERE id="+ID;
	    		      st.executeUpdate(sql); 
	    	       sql =" UPDATE TablaregalosPendientes  SET FECHA_DIARIA="+Fecha+"WHERE id="+ID;
	    		      st.executeUpdate(sql);  
	    		   
	    	   }
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN TablaregalospendientesImportes: " + e.getMessage());    
		        }
	    	   
	    	   }
          public static void ActualizarTabladiariaImportes(int ID,String Fecha,String cantidad ){
	    	   
	    	   try
	    	   {
	    		   st.executeUpdate(sqluse);
	    		   if(Fecha.equals(Formulario.getFecha_AnteriorMysql())){
	    			 System.out.println("equals"+Formulario.getFecha_AnteriorMysql());
	    			 sql =" UPDATE tabladiaria SET IMPORTES=IMPORTES"+"+"+cantidad+" WHERE ID="+ID;
	    	    	 st.execute(sql);  
	    	    	 }else{
	    			   psInsertar=con.prepareStatement("INSERT INTO tabladiaria(ID,FECHA_DIARIA,IMPORTES) VALUES (?,?,?)");
	     	           psInsertar.setInt(1,ID);
	     	           psInsertar.setString(2,Fecha);
	     	           int cantidadI=Integer.parseInt(cantidad);
	     	    	   psInsertar.setInt(3,cantidadI);
	   	        	   psInsertar.executeUpdate(); 
	   	        	 System.out.println(Formulario.getFecha_AnteriorMysql()+Fecha);
	    		   }
	    	   }
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN TablaDiariaImportes: " + e.getMessage());    
		        }
	    	  }
          public static void ConsumirPuntosRegaloMenu(String cantidad, int ID){
	    	   
	    	   try
	    	   {
	    		   st.executeUpdate(sqluse);
	    		 sql =" UPDATE puntoscomida SET PUNTOS_ACTUALES=PUNTOS_ACTUALES"+"-" +cantidad+" WHERE id="+ID;  
	    	     st.execute(sql);
	    	     ActualizarPremiosMenu(ID);    
	    	
		        }
	    	   
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN puntoscomida: " + e.getMessage());    
		        } 
	    	   }
          
          
          
          public static void ConsumirPuntosRegaloDesayunos(String cantidad, int ID){
	    	   
	    	   try
	    	   {
	    		   st.executeUpdate(sqluse);
	    		 sql =" UPDATE puntosdesayunos SET PUNTOS_ACTUALES=PUNTOS_ACTUALES"+"-" +cantidad+" WHERE id="+ID;
	    	     st.execute(sql);
	    	     ActualizarPremiosDesayuno(ID);
	    	
		        }
	    	   
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN puntoscomida: " + e.getMessage());    
		        } 
	    	   }
          
          public static void ConsumirPuntosRegaloImportes(String cantidad, int ID){
	    	   
	    	   try
	    	   {
	    		   st.executeUpdate(sqluse);
	    		 sql =" UPDATE puntosimporte SET PUNTOS_ACTUALES=PUNTOS_ACTUALES"+"-" +cantidad+" WHERE id="+ID;
	    	     st.execute(sql);
	    	     ActualizarPremiosImporte(ID);    
	    	
		        }
	    	   
	    	
	    	   catch (Exception e) 
		        {   
		            System.err.println("Warning: SELECT JOIN puntosimporte: " + e.getMessage());    
		        } 
	    	   }
          
          
          public static void ActualizarPremiosMenu(int ID)
   	   
    	  { 
  	    	
  	        try 
  	        {  
  	            // Mostramos por pantalla los puntos de desayunos seleccionados por el codigo 
  	        	 sql = "SELECT * FROM puntoscomida WHERE id="+ID;//busca al cliente;
  	            res = st.executeQuery(sql);
  	            sqlpuntos="SELECT * FROM puntosfidelizacion";
  	            res1=stpremios.executeQuery(sqlpuntos);//busca base fidelizacion
  	           
  	            while(res.next()){
  	              int PuntosA=res.getInt("PUNTOS_ACTUALES");//obtiene los puntos actuales;
  	              
  	              while(res1.next()){
  	              int puntospormenu=res1.getInt("PUNTOSMENU");
  	              int PuntosMe=res1.getInt("INCREMENTOMENU");
  	              
  	              int PuntosMet=PuntosMe+puntospormenu;
  	              System.out.println("puntosTotales Fidelizacion:" + PuntosA);//imprime por consola limitepuntos totales fidelizacion
  	              String PremioMe=res1.getString("PREMIOSMENU");//Obtnemos el premio menu.
  	             System.out.println("PremiosTotales Fidelizacion:" + PremioMe);//imprime por consola premios actual.
  	          	   System.out.println("Puntos totales: "+PuntosA);
  	               if(PuntosMe!=0 && PuntosA>=PuntosMe)
  	               {//compara los puntos actuales con los puntos de fidelizacion
  	            	  
  	            	System.out.println("Puntos totales1: "+PuntosA);
  	                sql =" UPDATE puntoscomida SET Regalos_Acumulados='"+PremioMe+"'"+"WHERE id="+ID;
  	                st.execute(sql);//guarda el premio seleccionado en la base de datos clientes;
  	                Formulario.CONSUMIRPREMIOSMENU.setEnabled(true);
  	                Formulario.TipoUltimaOperacionPremio="PremioMenu";
	                Formulario.UltimaOperacionPremio="0";
	                if(PuntosA!=0){
	                	  int	RegalosPendientes=PuntosA/PuntosMe;
	   	                String pendientes=String.valueOf(RegalosPendientes);
	 	                 ActualizarTablaRegalosPendientesMenus(ID,Formulario.FechaEntradaMysql,pendientes);
	 	                }
	 	          	
	 	          	      JOptionPane.showMessageDialog(
		      				   Formulario.ventana,
		      				   "has conseguido el siguiente Premio acumulado para la siguiente sesion: "+PremioMe,"Premio",JOptionPane.WARNING_MESSAGE,Formulario.AlarmaPremio);
	 	            	}
	 	             if(PuntosMe!=0 && PuntosA>=PuntosMet){
	 	            	Formulario.restarpuntos_consumirpremiosmenu=PuntosMet; 
	 	             }else{
		            		  sql =" UPDATE puntoscomida SET Regalos_Acumulados='"+0+"'"+"WHERE id="+ID;
		  	  	          	    st.execute(sql);//sino hay premio pone un cero.
		  	  	          	    Formulario.CONSUMIRPREMIOSMENU.setEnabled(false);
		  	             }
	 	             }
	 	            	}
  	              
  	           // Free memory 
  	            res.close(); 
  	            res1.close();
    	  }
  	        catch (Exception e) 
  	        {   
  	            System.err.println("Warning: SELECT JOIN actualizarPremiosMenu: " + e.getMessage());    
  	        }
  	    }
          public static void ActualizarPremiosDesayuno(int ID)
      	   
    	  { 
  	    	
  	        try 
  	        {  
  	            // Mostramos por pantalla los puntos de desayunos seleccionados por el codigo 
  	        	 sql = "SELECT * FROM puntosdesayunos WHERE id="+ID;//busca al cliente;
  	            res = st.executeQuery(sql);
  	            sqlpuntos="SELECT * FROM puntosfidelizacion";
  	            res1=stpremios.executeQuery(sqlpuntos);//busca base fidelizacion
  	           
  	            while(res.next()){
  	              int PuntosA=res.getInt("PUNTOS_ACTUALES");//obtiene los puntos actuales;
  	              
  	              while(res1.next()){
  	              int puntospordesayuno=res1.getInt("PUNTOSDESAYUNO");
  	              int PuntosDe=res1.getInt("INCREMENTODESAYUNOS");
  	               int PuntosDet=PuntosDe+puntospordesayuno;
  	              System.out.println("puntosTotales Fidelizacion:" + PuntosA);//imprime por consola limitepuntos totales fidelizacion
  	              String PremioDe=res1.getString("PREMIOSDESAYUNOS");//Obtnemos el premio menu.
  	             System.out.println("PremiosTotales Fidelizacion:" + PremioDe);//imprime por consola premios actual.
  	          	   System.out.println("Puntos totales: "+PuntosA);
  	          	 if(PuntosDe!=0 && PuntosA>=PuntosDe){//compara los puntos actuales con los puntos de fidelizacion
 	            	  System.out.println("Puntos totales1: "+PuntosA);
 	                sql =" UPDATE puntosdesayunos SET Regalos_Acumulados='"+PremioDe+"'"+"WHERE id="+ID;
 	                Formulario.CONSUMIRPREMIOSDESAYUNO.setEnabled(true);
 	                Formulario.TipoUltimaOperacionPremio="PremioDesayuno";
	                Formulario.UltimaOperacionPremio="0";
	               st.execute(sql);//guarda el premio seleccionado en la base de datos clientes;
 	                if(PuntosA!=0){
 	                int	RegalosPendientes=PuntosA/PuntosDe;
 	                String pendientes=String.valueOf(RegalosPendientes);
 	                 ActualizarTablaRegalosPendientesDesayuno(ID,Formulario.FechaEntradaMysql,pendientes);
 	                }
 	          	
 	          	      JOptionPane.showMessageDialog(
	      				   Formulario.ventana,
	      				   "has conseguido el siguiente Premio acumulado para la siguiente sesion: "+PremioDe,"Premio",JOptionPane.WARNING_MESSAGE,Formulario.AlarmaPremio);
 	            	}
 	             if(PuntosDe!=0 && PuntosA>=PuntosDet){
 	            	Formulario.restarpuntos_consumirpremiosdesayuno=PuntosDet; 
 	             }else{
	            		  sql =" UPDATE puntosdesayunos SET Regalos_Acumulados='"+0+"'"+"WHERE id="+ID;
	  	  	          	    st.execute(sql);//sino hay premio pone un cero.
	  	  	          	    Formulario.CONSUMIRPREMIOSDESAYUNO.setEnabled(false);
	  	             }
 	             }
 	            	}
  	              
  	            // Free memory 
  	            res.close(); 
  	            res1.close();
    	  }
  	        catch (Exception e) 
  	        {   
  	            System.err.println("Warning: SELECT JOIN actualizarPremiosdesayunos: " + e.getMessage());    
  	        }
  	    }
          
          public static void ActualizarPremiosImporte(int ID)
     	   
    	  { 
  	    	
  	        try 
  	        {  
  	            // Mostramos por pantalla los puntos de desayunos seleccionados por el codigo 
  	        	 sql = "SELECT * FROM puntosimporte WHERE id="+ID;//busca al cliente;
  	            res = st.executeQuery(sql);
  	            sqlpuntos="SELECT * FROM puntosfidelizacion";
  	            res1=stpremios.executeQuery(sqlpuntos);//busca base fidelizacion
  	           
  	            while(res.next()){
  	              int PuntosA=res.getInt("PUNTOS_ACTUALES");//obtiene los puntos actuales;
  	              
  	              while(res1.next()){
  	              int puntosporimporte=res1.getInt("PUNTOSIMPORTE");
  	              int PuntosIm=res1.getInt("INCREMENTOIMPORTE");
  	              System.out.println("puntosTotales Fidelizacion:" + PuntosA);//imprime por consola limitepuntos totales fidelizacion
  	              String PremioIm=res1.getString("PREMIOSIMPORTE");//Obtnemos el premio menu.
  	             System.out.println("PremiosTotales Fidelizacion:" + PremioIm);//imprime por consola premios actual.
  	          	   System.out.println("Puntos totales: "+PuntosA);
  	               if(PuntosIm!=0 && PuntosA>=PuntosIm)
  	               {//compara los puntos actuales con los puntos de fidelizacion
  	            	  System.out.println("Puntos totales1: "+PuntosA);
  	                sql =" UPDATE puntosimporte SET Regalos_Acumulados='"+PremioIm+"'"+"WHERE id="+ID;
  	                Formulario.CONSUMIRPREMIOSIMPORTE.setEnabled(true);
  	                Formulario.TipoUltimaOperacionPremio="PremioImporte";
	                Formulario.UltimaOperacionPremio="0";
  	                  st.execute(sql);//guarda el premio seleccionado en la base de datos clientes;
  	                if(PuntosA!=0){
  	 	                int	RegalosPendientes=PuntosA/PuntosIm;
  	 	                String pendientes=String.valueOf(RegalosPendientes);
  	 	                 ActualizarTablaRegalosPendientesImportes(ID,Formulario.FechaEntradaMysql,pendientes);
  	 	                } 
  	                  
  	          	      JOptionPane.showMessageDialog(
 	      				   Formulario.ventana,
 	      				   "has conseguido el siguiente Premio: "+PremioIm,"Premio",JOptionPane.WARNING_MESSAGE,Formulario.AlarmaPremio);
  	               }
  	            		if(PuntosIm!=0 && PuntosA>=PuntosIm+puntosporimporte){
  		 	            	 Formulario.restar_puntos_consumirpremiosimporte=PuntosIm+puntosporimporte; 
  	            	 }else{
 	            		  sql =" UPDATE puntosimporte SET Regalos_Acumulados='"+0+"'"+"WHERE id="+ID;
 	  	  	          	    st.execute(sql);//sino hay premio pone un cero.
 	  	  	          	    Formulario.CONSUMIRPREMIOSIMPORTE.setEnabled(false);
 	  	            	 }
  	               }
  	            	}
  	              
  	            // Free memory 
  	            res.close(); 
  	            res1.close();
    	  }
  	       catch (Exception e) 
  	        {   
  	            System.err.println("Warning: SELECT JOIN actualizarPremiosImporte: " + e.getMessage());    
  	        }
  	    }
  	        
          public static void ConsumirPremiosMenu(int ID){
        	  
          	   try
       	   {
       	   
       	   sql =" UPDATE puntoscomida SET Regalos_Acumulados='"+0+"'"+"WHERE id="+ID;
       	   st.execute(sql);
       	   String LimitePuntos=String.valueOf(Formulario.restarpuntos_consumirpremiosmenu);
       	         ConsumirPuntosRegaloMenu(LimitePuntos,ID);
       	         PremioConsumidoMenu(ID);
       		     EliminarUlMenu(ID);
       		}
       	   
       	
       	   catch (Exception e) 
   	        {   
   	            System.err.println("Warning: SELECT JOIN puntoscomida: " + e.getMessage());    
   	        } 
       	   }
          public static void PremioConsumidoImporte(int ID){
          	
          	try
       	   {
            sql =" UPDATE puntosimporte  SET REGALOS_CONSUMIDOS=REGALOS_CONSUMIDOS"+"+" +1+" WHERE id="+ID;
       	   st.execute(sql);
       	 
       		}
       	   
       	
       	   catch (Exception e) 
   	        {   
   	            System.err.println("Warning: SELECT JOIN puntosdesayuno: " + e.getMessage());    
   	        } 
       	   }
          
          public static void AnularPremioConsumidoImporte(int ID){
            	
            	try
         	   {
              sql =" UPDATE puntosimporte  SET REGALOS_CONSUMIDOS=REGALOS_CONSUMIDOS"+"-" +1+" WHERE id="+ID;
         	   st.execute(sql);
         	 
         		}
         	   
         	
         	   catch (Exception e) 
     	        {   
     	            System.err.println("Warning: SELECT JOIN anularPremioConsumidoImporte: " + e.getMessage());    
     	        } 
         	   }
          
          public static void ConsumirPremiosDesayuno(int ID){
        	  
         	   try
      	   {
      	   
      	   sql =" UPDATE puntosdesayunos SET Regalos_Acumulados='"+0+"'"+"WHERE id="+ID;
    	   st.execute(sql);
    	  
      	   String LimitePuntos=String.valueOf(Formulario.restarpuntos_consumirpremiosdesayuno);
      		     ConsumirPuntosRegaloDesayunos(LimitePuntos,ID);
      		     PremioConsumidoDesayuno(ID);
      		     EliminarUlDesayuno(ID);
      		  
      		     
      		}
      	   
      	
      	   catch (Exception e) 
  	        {   
  	            System.err.println("Warning: SELECT JOIN puntosdesayuno: " + e.getMessage());    
  	        } 
      	   }
          public static void PremioConsumidoDesayuno(int ID){
        	
        	try
     	   {
        	sql =" UPDATE puntosdesayunos  SET REGALOS_CONSUMIDOS=REGALOS_CONSUMIDOS"+"+" +1+" WHERE id="+ID;
     	   st.execute(sql);
     	    
     		}
     	   
     	
     	   catch (Exception e) 
 	        {   
 	            System.err.println("Warning: SELECT JOIN puntosdesayuno: " + e.getMessage());    
 	        } 
     	   }
          public static void AnularPremioConsumidoDesayuno(int ID){
          	
          	try
       	   {
          	sql =" UPDATE puntosdesayunos  SET REGALOS_CONSUMIDOS=REGALOS_CONSUMIDOS"+"-" +1+" WHERE id="+ID;
       	   st.execute(sql);
       	    
       		}
       	   
       	
       	   catch (Exception e) 
   	        {   
   	            System.err.println("Warning: SELECT JOIN puntosdesayuno: " + e.getMessage());    
   	        } 
       	   }
          
          public static void ConsumirPremiosImporte(int ID){
        	  
        	   try
           {
           sql =" UPDATE puntosimporte SET Regalos_Acumulados='"+0+"'"+"WHERE id="+ID;
     	   st.execute(sql);
     	  
     	   String LimitePuntos=String.valueOf(Formulario.restar_puntos_consumirpremiosimporte);
     	         ConsumirPuntosRegaloImportes(LimitePuntos,ID);
     	         PremioConsumidoImporte(ID);
     		     EliminarUlImporte(ID);
     		     
     		}
     	   
     	
     	   catch (Exception e) 
 	        {   
 	            System.err.println("Warning: SELECT JOIN puntosimportes: " + e.getMessage());    
 	        } 
     	   }
          public static void PremioConsumidoMenu(int ID){
          	
          	try
       	   {
           sql =" UPDATE puntoscomida  SET REGALOS_CONSUMIDOS=REGALOS_CONSUMIDOS"+"+" +1+" WHERE id="+ID;
       	   st.execute(sql);
       	   
       	   }
       	
       	   catch (Exception e) 
   	        {   
   	            System.err.println("Warning: SELECT JOIN puntosdesayuno: " + e.getMessage());    
   	        } 
       	   }
           
          public static void AnularPremioConsumidoMenu(int ID){
            	
            	try
         	   {
             sql =" UPDATE puntoscomida  SET REGALOS_CONSUMIDOS=REGALOS_CONSUMIDOS"+"-" +1+" WHERE id="+ID;
         	   st.execute(sql);
         	   
         	   }
         	
         	   catch (Exception e) 
     	        {   
     	            System.err.println("Warning: SELECT JOIN puntosdesayuno: " + e.getMessage());    
     	        } 
            }
          
           public static void ConsultarTablasClientes(){
	  
	       try
	       {
	    	   sql = "SELECT * FROM clientes";
	           res = st.executeQuery(sql);
	           
	            
	            while(res.next()){
	            	String CODIGOBARRASGENERADO=res.getString("CODIGOBARRASGENERADO");
	 	            int ID=res.getInt("ID");
	 	            String NOMBRE=res.getString("NOMBRE");
	 	            String apellido1=res.getString("1apellido");
	 	            String apellido2=res.getString("2apellido");
	 	            String CODIGOPOSTAL=res.getString("CODIGOPOSTAL");
	 	            String FechaAlta=res.getString("FECHA_ALTA");
	 	            String EMAIL=res.getString("email");
	 	            String TELEFONO=res.getString("TELEFONO");
	 	            
	 	           ConsultasTablas.modelo.addRow( new Object[] {CODIGOBARRASGENERADO,ID,FechaAlta,NOMBRE,apellido1,apellido2,CODIGOPOSTAL,EMAIL,TELEFONO} ); 
	        
		  }
	   
	       }      
	
	      catch (Exception e) 
         {   
         System.err.println("Warning: SELECT JOIN clientes: " + e.getMessage());    
         } 
	      
           
 	  
 	  
        }
           
           public static void ConsultarTablasMenus(){
        		  
    	       try
    	       {
    	    	   sql = "SELECT * FROM puntoscomida";
    	           res = st.executeQuery(sql);
    	           
    	            
    	            while(res.next()){
    	            	
    	 	            int ID=res.getInt("ID");
    	 	            int PUNTOS_ACTUALES=res.getInt("PUNTOS_ACTUALES");
    	 	            String REGALOS_ACUMULADOS=res.getString("REGALOS_ACUMULADOS");
    	 	            String REGALOS_CONSUMIDOS=res.getString("REGALOS_CONSUMIDOS");
    	 	            
    	 	           ConsultasMenus.modelo.addRow( new Object[] {ID,PUNTOS_ACTUALES,REGALOS_ACUMULADOS,REGALOS_CONSUMIDOS} ); 
    	        
    		  }
    	   
    	       }      
    	
    	      catch (Exception e) 
             {   
             System.err.println("Warning: SELECT JOIN puntoscomida: " + e.getMessage());    
             } 
    	      
               
     	  
     	  
            }
           
           public static void ConsultarTablasImportes(){
     		  
    	       try
    	       {
    	    	   sql = "SELECT * FROM puntosimporte";
    	           res = st.executeQuery(sql);
    	           
    	            
    	            while(res.next()){
    	            	
    	 	            int ID=res.getInt("ID");
    	 	            int PUNTOS_ACTUALES=res.getInt("PUNTOS_ACTUALES");
    	 	            String REGALOS_ACUMULADOS=res.getString("REGALOS_ACUMULADOS");
    	 	            String REGALOS_CONSUMIDOS=res.getString("REGALOS_CONSUMIDOS");
    	 	            
    	 	           ConsultasImportes.modelo.addRow( new Object[] {ID,PUNTOS_ACTUALES,REGALOS_ACUMULADOS,REGALOS_CONSUMIDOS} ); 
    	        
    		  }
    	   
    	       }      
    	
    	      catch (Exception e) 
             {   
             System.err.println("Warning: SELECT JOIN puntosimporte: " + e.getMessage());    
             } 
    	  }
           
           public static void ConsultarTablasDesayunos(){
      		  
    	       try
    	       {
    	    	   sql = "SELECT * FROM puntosdesayunos";
    	           res = st.executeQuery(sql);
    	           
    	            
    	            while(res.next()){
    	            	
    	 	            int ID=res.getInt("ID");
    	 	            int PUNTOS_ACTUALES=res.getInt("PUNTOS_ACTUALES");
    	 	            String REGALOS_ACUMULADOS=res.getString("REGALOS_ACUMULADOS");
    	 	            String REGALOS_CONSUMIDOS=res.getString("REGALOS_CONSUMIDOS");
    	 	            
    	 	           ConsultasDesayunos.modelo.addRow( new Object[] {ID,PUNTOS_ACTUALES,REGALOS_ACUMULADOS,REGALOS_CONSUMIDOS} ); 
    	        
    		  }
    	   
    	       }      
    	
    	      catch (Exception e) 
             {   
             System.err.println("Warning: SELECT JOIN puntosdesayunos: " + e.getMessage());    
             } 
    	  }
           public static void ConsultarTablaConsumo(int ID){
       		  
    	       try
    	       {
    	    	   sql = "SELECT * FROM tablaconsumodiario WHERE ID="+ID;
    	           res = st.executeQuery(sql);
    	           
    	            
    	            while(res.next()){
    	            	
    	            	
    	 	            String FechaTabla=res.getString("FECHA_DIARIA");
    	 	            int desayunos=res.getInt("CONSUMIDOSDESAYUNOS");
    	 	            int menus=res.getInt("CONSUMIDOSMENUS");
    	 	            int importes=res.getInt("CONSUMIDOSIMPORTES");
    	 	            String PremioDesayuno=res.getString("PREMIOSDESAYUNOS");
    	 	            String PremioMenu=res.getString("PREMIOSMENUS");
    	 	            String PremioImporte=res.getString("PREMIOSIMPORTES");
    	 	            
    	 	           if(desayunos!=0){
    	 	           ConsultaPuntosConsumidosDiarios.modelo.addRow( new Object[] {FechaTabla,desayunos,PremioDesayuno} ); 
    	 	           }
    	 	           if(menus!=0){
    	 	        	ConsultaPuntosConsumidosDiarios.modelo.addRow( new Object[] {FechaTabla,menus,PremioMenu} ); 
    	 	           }
    	 	           if(importes!=0){
   	 	               ConsultaPuntosConsumidosDiarios.modelo.addRow( new Object[] {FechaTabla,importes,PremioImporte} ); 
   	 	               }
   	 	         }      
    	       }
    	      catch (Exception e) 
             {   
             System.err.println("Warning: SELECT JOIN puntosconsumidos: " + e.getMessage());    
             } 
    	  }
          
           
           public static void ConsultarTablaDiaria(int ID){
        		  
    	       try
    	       {
    	    	   sql = "SELECT * FROM tabladiaria WHERE ID="+ID;
    	           res = st.executeQuery(sql);
    	           
    	            
    	            while(res.next()){
    	            	
    	            	
    	 	            String FechaTabla=res.getString("FECHA_DIARIA");
    	 	            int desayunos=res.getInt("DESAYUNOS");
    	 	            int menus=res.getInt("MENUS");
    	 	            int importes=res.getInt("IMPORTES");
    	 	            
    	 	           ConsultaPuntosActualesDiarios.modelo.addRow( new Object[] {FechaTabla,desayunos,menus,importes} ); 
    	        
    		  }
    	   
    	       }      
    	
    	      catch (Exception e) 
             {   
             System.err.println("Warning: SELECT JOIN puntosdesayunos: " + e.getMessage());    
             } 
    	  }
           
           public static void ConsultarTablaRegalosPendientes(int ID){
     		  
    	       try
    	       {
    	    	   sql = "SELECT * FROM tablaregalospendientes WHERE ID="+ID;
    	           res = st.executeQuery(sql);
    	           
    	              while(res.next()){
    	            	String FechaTabla=res.getString("FECHA_DIARIA");
    	 	            String desayunos=res.getString("PREMIOSDESAYUNOS");
    	 	            String menus=res.getString("PREMIOSMENUS");
    	 	            String importes=res.getString("PREMIOSIMPORTES");
    	 	         ConsultaRegalosPendientes.modelo.addRow( new Object[] {FechaTabla,desayunos,menus,importes} ); 
    	        
    		  }
    	   
    	       }      
    	
    	      catch (Exception e) 
             {   
             System.err.println("Warning: SELECT JOIN ConsultaTablaRegalosPendientes: " + e.getMessage());    
             } 
    	  }
           
           public static void ConsultarRegistoDiario(){
      		  
    	       try
    	       {
    	    	   sql = "SELECT * FROM registrodiario";
    	           res = st.executeQuery(sql);
    	           
    	              while(res.next()){
    	            	String FechaTabla=res.getString("FECHA_OPERACION");
    	 	            String Codigo=res.getString("CODIGO");
    	 	            String ID=res.getString("ID");
    	 	            String TablaPuntos=res.getString("TABLA_PUNTOS");
    	 	            String TipoOperacion=res.getString("TIPO_OPERACION");
    	 	            String Cantidad=res.getString("CANTIDAD");
    	 	            
    	 	         ListadoGeneral.modelo.addRow(new Object[] {FechaTabla,Codigo,ID,TablaPuntos,TipoOperacion,Cantidad}); 
    	        
    		  }
    	   
    	       }      
    	
    	      catch (Exception e) 
             {   
             System.err.println("Warning: SELECT JOIN ConsultaTablaRegalosPendientes: " + e.getMessage());    
             } 
    	  }
           
           public static void ConfigurarLector(){
       		  
    	       try
    	       {
    	    	   sql = "SELECT * FROM configuracionlector";
    	           res = st.executeQuery(sql);
    	           
    	              while(res.next()){
    	            	String Com=res.getString("COM");
    	 	            int Longitud=res.getInt("LONGITUD");
    	 	            int Intervalo=res.getInt("INTERVALO");
    	 	            Configurar.puertoCom=Com;
    	 	            Configurar.longitud=Longitud;
    	 	            Configurar.intervalo=Intervalo;
    	 	           PuertoSerie.intervalomsgTotal=Intervalo;
    	 	           PuertoSerie.puerto="COM"+Com;
    	 	           PuertoSerie.longitudLector=Longitud;
    	              }
    	            res.close();  
    	       }
    	 	          catch (Exception e) 
    	              {   
    	              System.err.println("Warning: SELECT JOIN ConfigurarLector: " + e.getMessage());    
    	              } 
    	     	  }    
    	 	        
    	
    	       public static void Configurar(){
    	       		  
        	       try
        	       {
        	    	   sql = "SELECT * FROM configuracion";
        	           res = st.executeQuery(sql);
        	           
        	              while(res.next()){
        	            	PanelAdministrador.Contraseña=res.getString("CONTRASEÑA");
        	            	Login.correctPassword=PanelAdministrador.Contraseña.toCharArray();
        	 	            PanelAdministrador.Licencia=res.getInt("LICENCIA");
        	 	            PanelAdministrador.Fecha=res.getString("FECHA");
        	 	            PanelAdministrador.Establecimiento=res.getString("ESTABLECIMIENTO");
        	 	            PanelAdministrador.Nif=res.getString("NIF");
        	 	            Formulario.DiasDemo=res.getInt("DIASDEMO");
        	 	       }
        	              res.close();  
        	       }      
    	      catch (Exception e) 
             {   
             System.err.println("Warning: SELECT JOIN ConfigurarAdministrador: " + e.getMessage());    
             } 
    	  }
           public static void ValidarCodigoFichaCliente(String Codigo){
       		  
    	       try
    	       {
    	    	   sql = "SELECT * FROM clientes WHERE CODIGOBARRASGENERADO="+Codigo+" OR "+"TELEFONO="+Codigo+" OR "+"ID="+Codigo;
    	           res = st.executeQuery(sql);
    	           
    	            int count=0;
    	            while(res.next()){
    	            	count=res.getMetaData().getColumnCount();
    	            	
    	 	          }
    	            if(count==0){
	            	       JOptionPane.showMessageDialog(PanelAdministrador.VentanaAdministrador,
	 	           "Codigo incorrecto, por favor vuelva a introducirlo","Error", JOptionPane.WARNING_MESSAGE,Formulario.IError);
    	 	           
    	 	       }
    	   
    	       }      
    	
    	      catch (Exception e) 
             {   
             System.err.println("Warning: SELECT JOIN clientes: " + e.getMessage());    
             } 
    	  }
           
}    