/*
 * GWindow.java
 *
 * Created on 28 de diciembre de 2005, 16:37
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package raytracer;

/**
 *
 * @author ismael.flores
 */
public class GWindow 
{
    
    protected double xMin = Double.NaN;
    protected double xMax = Double.NaN;
    protected double yMin = Double.NaN;
    protected double yMax = Double.NaN;
    
    /** Creates a new instance of GWindow */
    public GWindow() {
    }

    public GWindow(GWindow w) {
        xMin = w.xMin;
        xMax = w.xMax;
        yMin = w.yMin;
        yMax = w.yMax;        
    }
    
    public GWindow(double nxMin, double nyMin, double nxMax, double nyMax) {
        xMin = nxMin;
        xMax = nxMax;
        yMin = nyMin;
        yMax = nyMax;
    }

    public void set(double nxMin, double nyMin, double nxMax, double nyMax) {
        xMin = nxMin;
        xMax = nxMax;
        yMin = nyMin;
        yMax = nyMax;        
    }

    public double getWidth() {
        return xMax - xMin;
    }
    
    public double getHeight() {
        return yMax - yMin;
    }
    
    public double getPercentY(double y) {
        return Math.min(yMin, yMax) + (Math.abs(yMax - yMin) * y) / 100.0;
    }

    public double getPercentX(double x) {
        return Math.min(xMin, xMax) + (Math.abs(xMax - xMin) * x) / 100.0;
    }

    public boolean equals(GWindow w) {
        return xMin == w.xMin && xMax == w.xMax && yMin == w.yMin && yMax == w.yMax;
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
