/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P140_149;

import Library.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem144 {
    /*
    Investigating multiple reflections of a laser beam.
    
    In laser physics, a "white cell" is a mirror system that acts as a delay line for the laser beam. 
    The beam enters the cell, bounces around on the mirrors, and eventually works its way back out.
    The specific white cell we will be considering is an ellipse with the equation 4x^2 + y^2 = 100
    The section corresponding to −0.01 ≤ x ≤ +0.01 at the top is missing, allowing the light to enter and exit through the hole.
    The light beam in this problem starts at the point (0.0,10.1) just outside the white cell, 
    and the beam first impacts the mirror at (1.4,-9.6).
    Each time the laser beam hits the surface of the ellipse, 
    it follows the usual law of reflection "angle of incidence equals angle of reflection." 
    That is, both the incident and reflected beams make the same angle with the normal line at the point of incidence.
    In the figure on the left, the red line shows the first two points of contact between the laser beam and the wall of the white cell; 
    the blue line shows the line tangent to the ellipse at the point of incidence of the first bounce.
    The slope m of the tangent line at any point (x,y) of the given ellipse is: m = −4x/y
    The normal line is perpendicular to this tangent line at the point of incidence.
    The animation on the right shows the first 10 reflections of the beam.
    How many times does the beam hit the internal surface of the white cell before exiting?
    */
    public static void problem144() {
        Double EPSILON = 0.0000001;
        Long reflections = 0L;
        Double xo = 0.0;
        Double yo = 10.1;
        Double xx = 1.4;
        Double yy = -9.6;
        Double me = (-4 * xx) / yy;
        Boolean exiting = false;
        while (!exiting) {
            // Pendiente perpendicular a la tangente de la elipse 
            Double mpe = -1.0 / me;
            // Tangente de la recta incidente
            Double mri = (yy - yo) / (xx - xo);
            // Tangente de la recta saliente (mro+mri)/2=mpe -> mro=2mpe-mri 
            Double mro = Math.tan(2.0 * Math.atan(mpe) - Math.atan(mri));
            // y = mx + d; d = y - mx
            Double d = yy - mro * xx;
            // 4x^2+(m*x+d)^2=100 -> 4x^2+m^2*x^2+2mdx+d^2=100 -> (4+m^2)x^2+2mdx+d^2-100=0
            // x = -2md+sqrt((2md)^2-4*(4+m^2)(d^2-100)/2(4+m^2)
            // x = -2md-sqrt((2md)^2-4*(4+m^2)(d^2-100)/2(4+m^2)
            xo = xx;
            yo = yy;
            xx = (-2.0*mro*d+Math.sqrt((2.0*mro*d)*(2.0*mro*d)-4*(4+mro*mro)*(d*d-100.0)))/(2.0*(4.0+mro*mro));
            if (xx < -5.0 || xx > 5.0 || Math.abs(xx - xo) < EPSILON) {
                xx = (-2.0*mro*d-Math.sqrt((2.0*mro*d)*(2.0*mro*d)-4*(4+mro*mro)*(d*d-100.0)))/(2.0*(4.0+mro*mro));
            }
            yy = Math.sqrt(100-4*xx*xx);
            if (Math.abs(mro - (yy - yo) / (xx - xo)) > EPSILON) {
                yy = -yy;
            }
            exiting = (xx >= -0.01 && xx <= 0.01 && yy > 0);
            me = (-4 * xx) / yy;
            reflections++;
        }
        System.out.println("Reflections = " + reflections);
    }    
}
