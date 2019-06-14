package dialogs;

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
import raytracer.Complex;
import raytracer.GWindow;
import raytracer.IFCMath;

/**
 * Implementation of a Dialog showing a Mandelbrot set or an animation of
 * Mandelbrot sets
 * @author ismael.flores
 * @version 1.0
 */
public class JFractalDialog extends JDialog implements ActionListener {
    /**
     * Time (ms) between frames in animation
     */
    private int animationFrameTime = 40;
    
    /**
     * Array of images where animation is stored (precompilation needed)
     */
    private final ArrayList<BufferedImage> canvas = new ArrayList<>();
    
    /**
     * Timer needed to manage animation
     */
    private Timer timer = new Timer(animationFrameTime, this);

    /**
     * Animation state (position from '0' to 'canvas.size() - 1')
     */
    private int animatedPos = 0;

    /**
     * Animation direction (1 or -1) in order to play or playback
     */
    private int animatedDir = 1;

    /**
     * Window displayed for Mandelbrot set ('imaginary' window)
     * 'c' value in Mandelbrot set will be inside this window.
     */
    private GWindow window = new GWindow(-2.0, -2.0, 2.0, 2.0);

    /**
     * initial value for Mandelbrot set (tipically 0+0i):
     * Z(0) = 'initialValue'
     * Z(n+1) = Z(n)^2 + 'c'
     */
    private Complex initialValue = new Complex(0.0, 0.0);

    /**
     * Array of colors (gradient) used for calculate each pixel depending on
     * how many steps have been calculated to find if it's not from Mandelbrot set.
     * It's never 'null'
     */
    private final ArrayList<Color> colors = new ArrayList<>();

    /**
     * Color for Mandelbrot set values (black bt default)
     * how many steps have been calculated to find if it's not from Mandelbrot set.
     */
    private Color mandelbrotColor = Color.black;

    /**
     * Image dimensions in pixels (each pixel will be computed)
     */
    private Dimension dimensions = new Dimension(500, 500);
    
    /**
     * Dialog constructor
     * @param parent Dialog's Parent window
     * @param title Title for the dialog
     * @param modal True or False if dialog is modal or not
     */
    public JFractalDialog(JFrame parent, String title, boolean modal) {
        super(parent, title, modal);
    }
    
    /**
     * Calculates color of a value that has been necessary 'pos'
     * steps to be considered out of Mandelbrot set
     * @param c Array of colors to choose the gradient
     * @param pos Steps needed to determine if current value allows to Mandelbrot set or not
     * @param steps Number máximum of steps used to determine if a value allows or not to a Mandelbrot set
     * @return Calculated color
     */
    private static Color getColor(ArrayList<Color> c, int pos, int steps) {
        // Obtaining two colors to interpolate (c1r, c1g, c1b) and (c2r, c2g, c2b)
        int offset = ((c.size() - 1) * (pos - 1)) / steps;
        int c1r = c.get(offset).getRed();
        int c2r = c.get(offset + 1).getRed();
        int c1g = c.get(offset).getGreen();
        int c2g = c.get(offset + 1).getGreen();
        int c1b = c.get(offset).getBlue();
        int c2b = c.get(offset + 1).getBlue();
        
        // Obtaining steps by interval of colors (nsteps) and relative pos (npos)
        int nsteps = steps / (c.size() - 1);
        int npos = pos - nsteps * offset;
        if (npos > nsteps)
            npos = nsteps;
        
        // Obtaining final color by interpolation (c3r, c3g, c3b)
        int c3r = c1r + ((c2r - c1r) * npos) / nsteps;
        int c3b = c1b + ((c2b - c1b) * npos) / nsteps;
        int c3g = c1g + ((c2g - c1g) * npos) / nsteps;
        return new Color(c3r, c3g, c3b);
    }
    
    /**
     * Sets Window to check (imaginary Window).
     * We will map this window to images's dimensions
     * @param w Imaginary window to explore
     */
    public void setWindow(GWindow w) {
        window = w;
    }

    /**
     * Sets Mandelbrot's images dimension. We will map 'real' Window to this dimensions
     * @param d Dialog's dimension
     */
    public void setDimensions(Dimension d) {
        dimensions = d;
    }
    
    /**
     * Sets initial complex value for Mandelbrot set (tipically 0+0i)
     * Z(0) = 'i'
     * Z(n+1) = Z(n)^2 + 'c'
     * @param i First value of Mandelbrot set
     */
    public void setInitialValue(Complex i) {
        initialValue = i;
    }
    
    /**
     * Sets color for Mandelbrot set values
     * @param c Color for all values that allows to processed Mandelbrot set
     */
    public void setMandelbrotColor(Color c) {
        mandelbrotColor = c;
    }
    
    /**
     * Clears all defined colors
     */
    public void clearColors() {
        colors.clear();
    }
    
    /**
     * Adds a color to the array of colors used for calculate each pixel color.
     * @param c Color to add to the array
     */
    public void addColor(Color c) {
        colors.add(c);
    }
    
    /**
     * Sets time (in milliseconds) between frames in animation
     * @param milis Milliseconds between frames in animation
     */
    public void setAnimationFrameTime(int milis) {
        animationFrameTime = milis; 
        timer = new Timer(animationFrameTime, this);
    }
    
    /**
     * Calculates the image for mandelbrot set. We map the imaginary square 'window'
     * to the dialog with 'dimensions' (each pixel maped to one complex value in 'window').
     * We use 'colors' (or 'mandelbrotColor' if value allows to the set) to obtain value color
     * depending on steps needed to determine that value is not in Mandelbrot set.
     * Z(0) = 'initialValue'
     * Z(n+1) = Z(n)^2 + 'xx + yyi'
     * @param steps Maximum number of iterations evaluated.
     * If we arrive to this number, value allows to Mandelbrot set
     */
    public void createMandelbrot(int steps) {
        if (initialValue == null) {
            System.out.println("Initial value for Mandelbrot set undefined");
            return;
        }
        if (colors.size() < 2) {
            System.out.println("At least two colors are needed to calculate Mandelbrot set value color");
            return;
        }
        
        // Creating BufferedImage to store calculated image
        BufferedImage ncanvas = new BufferedImage(dimensions.width, dimensions.height, BufferedImage.TYPE_INT_ARGB);
        
        // Calculating steps in imaginary window to check
        double stepx = window.getWidth() / (double)dimensions.width;
        double stepy = window.getHeight() / (double)dimensions.height;
        
        // Evaluating each pixel in image
        for (int y = 0; y < dimensions.height; y++) {
            for (int x = 0; x < dimensions.width; x++) {
                // Calculating 'c' (xx + yyi) to check in Mandelbrot set:
                // Z(0) = 'initialValue'
                // Z(n+1) = Z(n)^2 + c                
                double xx = (double)x * stepx + window.getXMin();
                double yy = (double)y * stepy + window.getYMin();
                
                // Evaluating steps to determine if value xx+yyi allows to Mandelbrot set
                int s = IFCMath.isMandelbrot(initialValue, new Complex(xx, yy), steps);
                
                // Evaluating color for this value
                ncanvas.setRGB(x, y, s == steps ? mandelbrotColor.getRGB() : getColor(colors, s, steps).getRGB());
            }
        }
        
        // Adding produced image to array
        canvas.add(ncanvas);
    }

    /**
     * Stops animation timer
     */
    public void STOP() {
        timer.stop();
    }
    
    /**
     * Starts animation timer
     */
    public void GO() {
        timer.start();
    }
    
    /**
     * Painting 'animatedPos' image of the images's array 'canvas' when it's needed.
     * If it's necessary we resample the image to the real dialog's dimensions.
     * @param g Graphics context to paint to
     */
    @Override
    public void paint(Graphics g) {
        if (canvas.size() > animatedPos && animatedPos >= 0) {
            Graphics2D g2d = (Graphics2D)g;
            double nw = getSize().getWidth();
            double nh = getSize().getHeight();
            double w = (double)canvas.get(animatedPos).getWidth();
            double h = (double)canvas.get(animatedPos).getHeight();
            if (nw == w && nh == h)
                g2d.drawImage(canvas.get(animatedPos), null, null);
            else {
                // Resampling image to real  dialog's dimensions
                AffineTransform at = new AffineTransform();
                at.scale(nw / w, nh / h);
                AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
                BufferedImage after = scaleOp.filter(canvas.get(animatedPos), null);
                g2d.drawImage(after, null, null);
            }
        }
    }

    /**
     * Each timer event we have to actualize frame to be displayed changing
     * animation's direction 'animatedDir' if it's necessary. Animation is:
     * '0' -&gt; 'canvas.size()-1' -&gt; '0'
     * @param e Event to callback
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Timer) {
            if (animatedPos == canvas.size() - 1)
                animatedDir = -1;
            if (animatedPos == 0)
                animatedDir = 1;
            animatedPos += animatedDir;
            repaint();
        }
    }
}
