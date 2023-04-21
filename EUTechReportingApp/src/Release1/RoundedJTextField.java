package Release1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextField;

public class RoundedJTextField extends JTextField {
	   private Shape shape;
	   public RoundedJTextField(int size) {
	   super(size);
	   setOpaque(false);
	}
	protected void paintComponent(Graphics g) {
	   g.setColor(getBackground());
	   g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
	   super.paintComponent(g);
	}
	protected void paintBorder(Graphics g) {
	   g.setColor(Color.WHITE);
	   g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
	}
	public boolean contains(int x, int y) {
	   if (shape == null || !shape.getBounds().equals(getBounds())) {
	      shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 30, 30);
	   }
	   return shape.contains(x, y);
	   }
	}
