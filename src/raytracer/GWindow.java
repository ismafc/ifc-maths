/*
 * GWindow.java
 */

package raytracer;

/**
 * Class to manage a 2D Window (real world)
 * xMin < xMax and yMin < yMax
 * @author Ismael Flores Campoy
 * @version 1.0
 */
public class GWindow 
{
    
    /**
     * Minimum x value of window (x-axis)
     */
    protected double xMin = Double.NaN;

    /**
     * Maximum x value of window (x-axis)
     */
    protected double xMax = Double.NaN;
    
    /**
     * Minimum y value of window (y-axis)
     */
    protected double yMin = Double.NaN;

    /**
     * Maximum y value of window (y-axis)
     */
    protected double yMax = Double.NaN;
    
    /** 
     * Creates a new instance of GWindow 
     */
    public GWindow() {
    }

    /** 
     * Creates a new instance of GWindow with
     * a copy of given parameter 'w'
     * @param w GWindow to copy to this object
     */
    public GWindow(GWindow w) {
        xMin = w.xMin;
        xMax = w.xMax;
        yMin = w.yMin;
        yMax = w.yMax;        
    }
    
    /** 
     * Creates a new instance of GWindow using
     * given parameters
     * @param nxMin Minimum x value of Window (x-axis)
     * @param nyMin Minimum y value of Window (y-axis)
     * @param nxMax Maximum x value of Window (x-axis)
     * @param nyMax Maximum y value of Window (y-axis)
     */
    public GWindow(double nxMin, double nyMin, double nxMax, double nyMax) {
        xMin = nxMin;
        xMax = nxMax;
        yMin = nyMin;
        yMax = nyMax;
    }

    /** 
     * Updates this GWindow with given parameters
     * @param nxMin Minimum x value of Window (x-axis)
     * @param nyMin Minimum y value of Window (y-axis)
     * @param nxMax Maximum x value of Window (x-axis)
     * @param nyMax Maximum y value of Window (y-axis)
     */
    public void set(double nxMin, double nyMin, double nxMax, double nyMax) {
        xMin = nxMin;
        xMax = nxMax;
        yMin = nyMin;
        yMax = nyMax;
    }

    /** 
     * Returns with of GWindow. It assumes that xMax > xMin
     * @return Double with width
     */
    public double getWidth() {
        return xMax - xMin;
    }
    
    /** 
     * Returns height of GWindow. It assumes that yMax > yMin
     * @return Double with height
     */
    public double getHeight() {
        return yMax - yMin;
    }
    
    public double getPercentY(double y) {
        return yMin + ((yMax - yMin) * y) / 100.0;
    }

    public double getPercentX(double x) {
        return xMin + ((xMax - xMin) * x) / 100.0;
    }

    @Override
    public boolean equals(Object w) {
        if (w instanceof GWindow) {
            return xMin == ((GWindow)w).xMin && 
                   xMax == ((GWindow)w).xMax && 
                   yMin == ((GWindow)w).yMin && 
                   yMax == ((GWindow)w).yMax;
        }
        return false;
    }
    
    public boolean equalsX(GWindow w) {
        return xMin == w.xMin && xMax == w.xMax;
    }
    
    public boolean equalsY(GWindow w) {
        return yMin == w.yMin && yMax == w.yMax;
    }
    
    public void move(double w, double h) {
        xMin += w;
        xMax += w;
        yMin += h;
        yMax += h;
    }
    
    public void cutBy(GWindow w) {
        if (xMin < w.xMin) {
            xMax += (w.xMin - xMin);
            xMin = w.xMin;
        }
        if (xMax > w.xMax) {
            xMin -= (xMax - w.xMax);
            xMax = w.xMax;
        }
        if (yMin < w.yMin) {
            yMax += (w.yMin - yMin);
            yMin = w.yMin;
        }
        if (yMax > w.yMax) {
            yMin -= (yMax - w.yMax);
            yMax = w.yMax;
        }        
    }
}
