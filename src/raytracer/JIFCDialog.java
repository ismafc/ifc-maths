/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raytracer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
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
    private int animationFrameTime = 40;
    private final ArrayList<BufferedImage> canvas = new ArrayList<>();
    private Timer timer = new Timer(animationFrameTime, this);
    private int animatedPos = 0;
    private int animatedDir = 1;
    private GWindow window = new GWindow(-2.0, -2.0, 2.0, 2.0);
    private Complex initialValue = new Complex(0.0, 0.0);
    private ArrayList<Color> colors = new ArrayList<Color>();
    private Dimension dimensions = new Dimension(500, 500);
    
    public JIFCDialog(JFrame parent, String title, boolean modal) {
        super(parent, title, modal);
    }
    
    private static Color getColor(ArrayList<Color> c, int pos, int steps) {
        int offset = ((c.size() - 1) * (pos - 1)) / steps;
        int c1r = c.get(offset).getRed();
        int c2r = c.get(offset + 1).getRed();
        int c1b = c.get(offset).getBlue();
        int c2b = c.get(offset + 1).getBlue();
        int c1g = c.get(offset).getGreen();
        int c2g = c.get(offset + 1).getGreen();
        int nsteps = steps / (c.size() - 1);
        int npos = pos - nsteps * offset;
        if (npos > nsteps)
            npos = nsteps;
        int c3r = c1r + ((c2r - c1r) * npos) / nsteps;
        int c3b = c1b + ((c2b - c1b) * npos) / nsteps;
        int c3g = c1g + ((c2g - c1g) * npos) / nsteps;
        return new Color(c3r, c3g, c3b);
    }
    
    public void setWindow(GWindow w) {
        window = w;
    }

    public void setDimensions(Dimension d) {
        dimensions = d;
    }
    
    public void setInitialValue(Complex i) {
        initialValue = i;
    }
    
    public void clearColors() {
        colors.clear();
    }
    
    public void addColor(Color c) {
        colors.add(c);
    }
    
    public void setAnimationFrameTime(int milis) {
        animationFrameTime = milis; 
        timer = new Timer(animationFrameTime, this);
    }
    
    public void createMandelbrot(int steps) {
        if (initialValue == null)
            return;
        if (colors.size() < 2)
            return;
        int w = dimensions.width;
        int h = dimensions.height;
        BufferedImage ncanvas = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);        
        double stepx = window.getWidth() / (double)w;
        double stepy = window.getHeight() / (double)h;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                double xx = (double)x * stepx + window.xMin;
                double yy = (double)y * stepy + window.yMin;
                int s = IFCMath.isMandelbrot(initialValue, new Complex(xx, yy), steps);
                ncanvas.setRGB(x, y, s == steps ? Color.black.getRGB() : getColor(colors, s, steps).getRGB());
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
        if (canvas.size() > 0 && canvas.size() > animatedPos) {
            double nw = getSize().getWidth();
            double nh = getSize().getHeight();
            int w = canvas.get(animatedPos).getWidth();
            int h = canvas.get(animatedPos).getHeight();
            if (nw == (double)w && nh == (double)h)
                g2d.drawImage(canvas.get(animatedPos), null, null);
            else {
                AffineTransform at = new AffineTransform();
                at.scale(nw / (double)w, nh / (double)h);
                AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
                BufferedImage after = scaleOp.filter(canvas.get(animatedPos), null);
                g2d.drawImage(after, null, null);
            }
        }
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
