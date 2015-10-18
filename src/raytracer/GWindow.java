/*
 * GWindow.java
 */

package raytracer;

/**
 * Class to manage a 2D Window (real world)
 * xMin &lt; xMax and yMin &lt; yMax
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
        if (w != null)
            set(w.xMin, w.yMin, w.xMax, w.yMax);
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
        set(nxMin, nyMin, nxMax, nyMax);
    }

    /** 
     * Updates this GWindow with given parameters
     * @param nxMin Minimum x value of Window (x-axis)
     * @param nyMin Minimum y value of Window (y-axis)
     * @param nxMax Maximum x value of Window (x-axis)
     * @param nyMax Maximum y value of Window (y-axis)
     */
    public final void set(double nxMin, double nyMin, double nxMax, double nyMax) {
        xMin = nxMin;
        xMax = nxMax;
        yMin = nyMin;
        yMax = nyMax;
    }

    /** 
     * Returns with of GWindow. It assumes that xMax &gt; xMin but, if not,
     * a negative value is returned
     * @return Double with width
     */
    public double getWidth() {
        return xMax - xMin;
    }
    
    /** 
     * Returns height of GWindow. It assumes that yMax &gt; yMin but, if not,
     * a negative value is returned
     * @return Double with height
     */
    public double getHeight() {
        return yMax - yMin;
    }
    
    /** 
     * Returns the absolute y value corresponding to the given percentage 'y'.
     * Tipically, if y is a value between 0 and 100, returned double
     * has a value between yMin and and yMax
     * @param y percentage of y-axis we find
     * @return Double with y value corresponding to y-percentage given
     */
    public double getPercentY(double y) {
        return yMin + ((yMax - yMin) * y) / 100.0;
    }

    /** 
     * Returns the absolute x value corresponding to the given percentage 'x'.
     * Tipically, if x is a value between 0 and 100, returned double
     * has a value between xMin and and xMax
     * @param x percentage of x-axis we find
     * @return Double with x value corresponding to x-percentage given
     */
    public double getPercentX(double x) {
        return xMin + ((xMax - xMin) * x) / 100.0;
    }

    /** 
     * Compares this object with given object 'o'.
     * @param o Object to be compared with
     * @return true if given object has same coordinates than this object, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof GWindow) {
            GWindow w = (GWindow)o;
            return xMin == w.xMin && xMax == w.xMax && 
                   yMin == w.yMin && yMax == w.yMax;
        }
        return false;
    }

    /** 
     * Calculates and returns a hash code. Tipically used to store object in 
     * Hash Tables and other structures
     * @return Integer with hash code calculated
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (Double.doubleToLongBits(xMin) ^ (Double.doubleToLongBits(xMin) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(xMax) ^ (Double.doubleToLongBits(xMax) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(yMin) ^ (Double.doubleToLongBits(yMin) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(yMax) ^ (Double.doubleToLongBits(yMax) >>> 32));
        return hash;
    }
    
    /** 
     * Compares this GWindow x-coordinates with the same x-coordinates of given GWindow 'w'.
     * @param w GWindow to be compared with
     * @return true if x-coordinates are equals, false otherwise
     */
    public boolean equalsX(GWindow w) {
        return (w != null) ? xMin == w.xMin && xMax == w.xMax : false;
    }
    
    /** 
     * Compares this GWindow y-coordinates with the same y-coordinates of given GWindow 'w'.
     * @param w GWindow to be compared with
     * @return true if y-coordinates are equals, false otherwise
     */
    public boolean equalsY(GWindow w) {
        return (w != null) ? yMin == w.yMin && yMax == w.yMax : false;
    }
    
    /** 
     * Moves this GWindow 'w' coordinates in x-axis and 'h' coordinates in
     * y-axis. Tipically, positive values of 'w' moves window to the right and
     * positive values of 'h' moves window to the bottom.
     * @param w coordinates to move on x-axis
     * @param h coordinates to move on y-axis
     */
    public void move(double w, double h) {
        xMin += w;
        xMax += w;
        yMin += h;
        yMax += h;
    }
    
    /** 
     * Returns text representation of this 2D window:
     * ((xMin, yMin) - (xMax, yMax))
     * @return String with text representation of this window
     */
    @Override
    public String toString() {
        return "((" + xMin + ", " + yMin + ") - (" + xMax + ", " + yMax + "))";
    }
}
