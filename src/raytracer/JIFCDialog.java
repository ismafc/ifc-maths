/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raytracer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author ismael.flores
 */
public class JIFCDialog extends JDialog implements ActionListener {
    private final ArrayList<BufferedImage> canvas = new ArrayList<>();
    private Timer timer = new Timer(40, this);
    private int animatedPos = 0;
    private int animatedDir = 1;
    
    public JIFCDialog(JFrame parent, String title, boolean modal) {
        super(parent, title, modal);
    }
    
    private static Color getColor(Color c1, Color c2, int pos, int steps) {
        int c1r = c1.getRed();
        int c2r = c2.getRed();
        int c1b = c1.getBlue();
        int c2b = c2.getBlue();
        int c1g = c1.getGreen();
        int c2g = c2.getGreen();
        int c3r = c1r + ((c2r - c1r) * pos) / steps;
        int c3b = c1b + ((c2b - c1b) * pos) / steps;
        int c3g = c1g + ((c2g - c1g) * pos) / steps;
        return new Color(c3r, c3g, c3b);
    }
    
    public void createMandelbrot(int steps) {
        int w = this.getPreferredSize().width;
        int h = this.getPreferredSize().height;
        BufferedImage ncanvas = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);        
        double stepx = 4.0 / (double)w;
        double stepy = 4.0 / (double)h;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                double xx = (double)x * stepx - 2.0;
                double yy = (double)y * stepy - 2.0;
                int s = IFCMath.isMandelbrot(new Complex(xx, yy), steps);
                ncanvas.setRGB(x, y, s == steps ? Color.black.getRGB() : getColor(Color.black, Color.red, s, steps).getRGB());
            }
        }
        canvas.add(ncanvas);
    }
    
    public void GO() {
        timer.start();
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(canvas.get(animatedPos), null, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (animatedPos == canvas.size() - 1)
            animatedDir = -1;
        if (animatedPos == 0)
            animatedDir = 1;
        animatedPos += animatedDir;
        repaint();
    }
}
