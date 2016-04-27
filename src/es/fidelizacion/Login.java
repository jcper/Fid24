package es.fidelizacion;



import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
 
/* PasswordDemo.java requires no other files. */
 
public class Login extends JPanel implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private static String OK = "ok";
	static char[] correctPassword = { '1','2','3','4' };
    private JFrame controllingFrame; //needed for dialogs
    private JPasswordField passwordField;
    
 
    public Login(JFrame f) {
        //Use the default FlowLayout.
        controllingFrame = f;
 
        //Create everything.
        passwordField = new JPasswordField(10);
        passwordField.setActionCommand(OK);
        passwordField.addActionListener(this);
        
        JLabel label = new JLabel("Introduce la contraseña: ");
        label.setLabelFor(passwordField);
        JPanel textPane = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        textPane.add(label);
        textPane.add(passwordField);
        JButton okButton;
        okButton=new JButton("Login");
		okButton.setActionCommand(OK);
        okButton.addActionListener(this);
        textPane.add(okButton);
        add(textPane);
        
    }
 
 
 
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
 
        if (OK.equals(cmd)) { //Process the password.
            char[] input = passwordField.getPassword();
            if (isPasswordCorrect(input)) {
           	 controllingFrame.setVisible(false);
         	Formulario.menuFormulario1.setEnabled(true);
         	Formulario.menuFormulario2.setEnabled(true);
         	Formulario.menuFormulario3.setEnabled(true);
         	Formulario.Configuracion.setEnabled(true);
         	Formulario.menuFormulario.setEnabled(false);
               
            } else {
                JOptionPane.showMessageDialog(controllingFrame,
                    "Contraseña invalida",
                    "Error Message",
                    JOptionPane.ERROR_MESSAGE);
               
            }
 
            //Zero out the possible password, for security.
            //Arrays.fill(input, '0');
            passwordField.selectAll();
            resetFocus();
            System.out.println(input);
        } 
    }
 
    /**
     * Checks the passed-in array against the correct password.
     * After this method returns, you should invoke eraseArray
     * on the passed-in array.
     */
    private static boolean isPasswordCorrect(char[] input) {
        boolean isCorrect = true;
       
     
 
        if (input.length != correctPassword.length){
            isCorrect = false;
        }else{
        	 isCorrect=Arrays.equals(input,correctPassword);
        }
 
        //Zero out the password.
        //Arrays.fill(correctPassword,'0');
 
        return isCorrect;
    }
 
    //Must be called from the event dispatch thread.
    protected void resetFocus() {
        passwordField.requestFocusInWindow();
    }


    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    public static void login() {
        //Create and set up the window.
        JFrame frame = new JFrame("Password");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
        //Create and set up the content pane.
        final Login newContentPane = new Login(frame);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Make sure the focus goes to the right component
        //whenever the frame is initially given the focus.
        frame.addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent e) {
                newContentPane.resetFocus();
            }
        });
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
      }
 
    }
  

