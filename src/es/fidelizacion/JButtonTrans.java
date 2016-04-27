package es.fidelizacion;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JButtonTrans extends JButton{

	    /**
	 * 
	 */
	private static final long serialVersionUID = 6995203382639757550L;
	private static final Color color_trans_1 = new Color(1f,1f,1f,.2f);
    private static final Color color_trans_2 = new Color(0f,0f,0f,.4f);
    private static final Color color_trans_3 = new Color(1f,1f,1f,.2f);
    private static final Color color_trans_4 = new Color(1f,1f,1f,.1f);
    private Color color_1;
    private Color color_2;
    private int radio = 8;
	
	public JButtonTrans(){
		this.updateUI();
		this.repaint();
	}
	
   public JButtonTrans(String text) {
        super(text);
    }
    
    public void setRadioButton(int radio){
    	this.radio=radio;
    }
    public int getRadioButton(){
    	return radio;
    }
    
    
    @Override public void updateUI() {
        super.updateUI();
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        setForeground(Color.WHITE);
    }
    @Override protected void paintComponent(Graphics g) {
        int x = 0;
        int y = 0;
        int w = getWidth();
        int h = getHeight();
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape area = new RoundRectangle2D.Float(x, y, w-1, h-1, getRadioButton(), getRadioButton());
        color_1 = color_trans_1;
        color_2 = color_trans_2;
        ButtonModel m = getModel();
        if(m.isPressed()) { /**SI EL BUTON FUE PRESIONADO*/
        	color_1 = color_trans_4;
        	color_2 = color_trans_3;
        }else if(m.isRollover()) { /*****SI PASA POR ENCIMA*****/
        	color_1 = color_trans_3;
            color_2 = color_trans_4;
        }
        /*****creo un gradiente*******/
        g2.setPaint(new GradientPaint(x, y, color_1, x, y+h, color_2, true));
        g2.fill(area);
        g2.setPaint(color_trans_2);
        g2.draw(area);
        g2.dispose();
        super.paintComponent(g);
    }
}
