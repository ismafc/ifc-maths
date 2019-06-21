/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P140_149;

import java.util.HashMap;
import Library.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem143 {
    /*
    Let ABC be a triangle with all interior angles being less than 120 degrees. 
    Let X be any point inside the triangle and let XA = p, XC = q, and XB = r.

    Fermat challenged Torricelli to find the position of X such that p + q + r was minimised.

    Torricelli was able to prove that if equilateral triangles AOB, BNC and AMC are constructed on each side of triangle ABC, 
    the circumscribed circles of AOB, BNC, and AMC will intersect at a single point, T, inside the triangle. 
    Moreover he proved that T, called the Torricelli/Fermat point, minimises p + q + r. 
    Even more remarkable, it can be shown that when the sum is minimised, AN = BM = CO = p + q + r and that AN, BM and CO also intersect at T.

    If the sum is minimised and a, b, c, p, q and r are all positive integers we shall call triangle ABC a Torricelli triangle. 
    For example, a = 399, b = 455, c = 511 is an example of a Torricelli triangle, with p + q + r = 784.

    Find the sum of all distinct values of p + q + r ≤ 120000 for Torricelli triangles.    
    */
    public static void problem143(long MAX_DIST) {
/*        long a = 399;
        long b = 455;
        long c = 511;
        double Ax = 0;
        double Ay = 0;
        double Bx = c;
        double By = 0;
        double Cx = (c*c + b*b - a*a) / (2.0 * c);
        double Cy2 = b*b - Cx*Cx;
        double Cy = Math.sqrt(Cy2);
        double Dx = c / 2.0;
        double Dy = -(Math.sqrt(3)*c) / 2.0;
        double d1 = Math.sqrt((Cx-Dx)*(Cx-Dx) + (Cy-Dy)*(Cy-Dy));
        double d2 = Math.sqrt((c*c + b*b + a*a + Math.sqrt(12*c*c*(b*b-Cx*Cx)))/2);
        long det1 = 6*a*a*b*b+6*a*a*c*c+6*b*b*c*c-3*a*a*a*a-3*b*b*b*b-3*c*c*c*c;
        boolean isSquare1 = IFCMath.isPerfectSquare(det1);
        long det2 = c*c + b*b + a*a + (long)Math.sqrt(det1);
        boolean isSquare2 = ((det2 % 2 == 0) && IFCMath.isPerfectSquare(det2 / 2));
        double angle1 = Math.acos(Cx / b);
        double angle2 = Math.acos((c - Cx) / a);
        double angle3 = Math.PI - angle1 - angle2;*/
        HashMap<Long, Boolean> found = new HashMap<>();
        long suma = 0;
        long torricellis = 0;
        for (long c = 1; c <= MAX_DIST; c++) {
            for (long b = c; b >= c / 2; b--) {
                for (long a = b; a >= 1; a--) {
                    if (a + b <= c)
                        a = 0;
                    else {
                        long det1 = 6*a*a*b*b+6*a*a*c*c+6*b*b*c*c-3*a*a*a*a-3*b*b*b*b-3*c*c*c*c;
                        if (IFCMath.isPerfectSquare(det1)) {
                            long sq1 = (long)Math.sqrt(det1);
                            long det2 = c*c + b*b + a*a + sq1;
                            if (det2 % 2 == 0) {
                                if (IFCMath.isPerfectSquare(det2 / 2)) {
                                    double Cx = (c*c + b*b - a*a) / (2.0 * c);
                                    double angle1 = Math.acos(Cx / b);
                                    double angle2 = Math.acos((c - Cx) / a);
                                    double angle3 = Math.PI - angle1 - angle2;
                                    if (angle3 >= 2.0 * Math.PI / 3.0)
                                        a = 0;
                                    else {
                                        long dist = (long)Math.sqrt(det2 / 2);
                                        if (dist <= MAX_DIST) {
                                            if (!found.containsKey(dist)) {
                                                suma += dist;
                                                torricellis++;
                                                found.put(dist, Boolean.TRUE);
                                                System.out.println("a = " + a + "; b = " + b + "; c = " + c + "; d = " + dist + "; suma = " + suma + "; torricellis = " + torricellis);
                                            }
                                            else {
                                                System.out.println("a = " + a + "; b = " + b + "; c = " + c + "; Already found " + dist);
                                            }
                                        }
                                    }
                                }
                                else {
                                    a = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
    }    
}
