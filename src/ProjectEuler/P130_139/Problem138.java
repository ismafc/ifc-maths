/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P130_139;

import java.math.BigInteger;
import raytracer.IFCMath;

/**
 *
 * @author Isma
 */
public class Problem138 {
    // A mixture of analysis and guesswork... We find that (5*b^2+8*b+4)/4 must be an integer and a perfect square:
    // Found: 17, 305, 5473, 98209, 1762289, ... And slow
    // h is growing with factor 17,9442719100... That is:
    // 17+1/(1+1/(16+1/(1+1/(16+1/(...)))))
    public static void problem138() {
        long count = 1;
        BigInteger hh = new BigInteger("15");
        BigInteger suml = new BigInteger("17");
        while (count < 12) {
            BigInteger base = hh.multiply(new BigInteger("179442719100")).divide(new BigInteger("10000000000"));
            BigInteger step = BigInteger.ONE;
            while (true) {
                BigInteger nh = base.add(step);
                BigInteger bb = nh.add(BigInteger.ONE);
                if (bb.mod(new BigInteger("2")) == BigInteger.ZERO) {
                    bb = bb.divide(new BigInteger("2"));
                    BigInteger lsq = bb.multiply(bb).add(nh.multiply(nh));
                    if (IFCMath.isPerfectSquare(lsq)) {
                        System.out.println("b = " + bb.multiply(new BigInteger("2")).toString() + "; L = " + (IFCMath.sqrt(lsq)) + "; h = " + nh);
                        suml = suml.add(IFCMath.sqrt(lsq));
                        hh = nh;
                        count++;
                        break;
                    }
                }
                
                bb = nh.subtract(BigInteger.ONE);
                if (bb.mod(new BigInteger("2")) == BigInteger.ZERO) {
                    bb = bb.divide(new BigInteger("2"));
                    BigInteger lsq = bb.multiply(bb).add(nh.multiply(nh));
                    if (IFCMath.isPerfectSquare(lsq)) {
                        System.out.println("b = " + bb.multiply(new BigInteger("2")).toString() + "; L = " + (IFCMath.sqrt(lsq)) + "; h = " + nh);
                        suml = suml.add(IFCMath.sqrt(lsq));
                        hh = nh;
                        count++;
                        break;
                    }
                }

                nh = base.subtract(step);
                bb = nh.add(BigInteger.ONE);
                if (bb.mod(new BigInteger("2")) == BigInteger.ZERO) {
                    bb = bb.divide(new BigInteger("2"));
                    BigInteger lsq = bb.multiply(bb).add(nh.multiply(nh));
                    if (IFCMath.isPerfectSquare(lsq)) {
                        System.out.println("b = " + bb.multiply(new BigInteger("2")).toString() + "; L = " + (IFCMath.sqrt(lsq)) + "; h = " + nh);
                        suml = suml.add(IFCMath.sqrt(lsq));
                        hh = nh;
                        count++;
                        break;
                    }
                }
                
                bb = nh.subtract(BigInteger.ONE);
                if (bb.mod(new BigInteger("2")) == BigInteger.ZERO) {
                    bb = bb.divide(new BigInteger("2"));
                    BigInteger lsq = bb.multiply(bb).add(nh.multiply(nh));
                    if (IFCMath.isPerfectSquare(lsq)) {
                        System.out.println("b = " + bb.multiply(new BigInteger("2")).toString() + "; L = " + (IFCMath.sqrt(lsq)) + "; h = " + nh);
                        suml = suml.add(IFCMath.sqrt(lsq));
                        hh = nh;
                        count++;
                        break;
                    }
                }
                
                step = step.add(BigInteger.ONE);
            }
        }
        System.out.println("Sum of L = " + suml.toString());
    }    
}
