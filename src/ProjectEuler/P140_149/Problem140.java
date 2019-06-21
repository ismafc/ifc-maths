/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P140_149;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import Library.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem140 {
    /*
    Modified Fibonacci golden nuggets

    Consider the infinite polynomial series AG(x) = xG1 + x^2G2 + x^3G3 + ..., where Gk is the kth term of the second order recurrence relation Gk = Gk−1 + Gk−2, G1 = 1 and G2 = 4; 
    that is, 1, 4, 5, 9, 14, 23, ... .

    For this problem we shall be concerned with values of x for which AG(x) is a positive integer.

    The corresponding values of x for the first five natural numbers are shown below.
    x               AG(x)
    (√5−1)/4        1
    2/5             2
    (√22−2)/6       3
    (√137−5)/14     4
    1/2             5

    We shall call AG(x) a golden nugget if x is rational, because they become increasingly rarer; for example, the 20th golden nugget is 211345365.

    Find the sum of the first thirty golden nuggets.
    */
    public static void problem140(long GOLDENS) {
        /*
        1.- AG(x)=AG(4/10)=2
        2.- AG(x)=AG(8/16)=5
        3.- AG(x)=AG(28/48)=21
        4.- AG(x)=AG(54/90)=42
        5.- AG(x)=AG(190/310)=152
        6.- AG(x)=AG(368/598)=296
        7.- AG(x)=AG(1300/2106)=1050
        8.- AG(x)=AG(2520/4080)=2037
        9.- AG(x)=AG(8908/14416)=7205
        10.- AG(x)=AG(17270/27946)=13970
        11.- AG(x)=AG(61054/98790)=49392
        12.- AG(x)=AG(118368/191526)=95760
        13.- AG(x)=AG(418468/677098)=338546
        14.- AG(x)=AG(811304/1312720)=656357
        15.- AG(x)=AG(2868220/4640880)=2320437
        16.- AG(x)=AG(5560758/8997498)=4498746
        17.- AG(x)=AG(19659070/31809046)=15904520
        18.- AG(x)=AG(38114000/61669750)=30834872
        19.- AG(x)=AG(134745268/218022426)=109011210
        20.- AG(x)=AG(261237240/422690736)=211345365        

        */
        long count = 0;
        long N = 1;
        while (count < 20) {
            long sq = 5 * N * N + 14 * N + 1;
            if (IFCMath.isPerfectSquare(sq)) {
                long num = (long)Math.sqrt((double)sq) - N - 1;
                long den = 2 * (N + 3);
                count++;
                System.out.println(count + ".- AG(x)=AG(" + num + "/" + den + ")=" + N);
            }
            N++;
        }
        
        // La x sigue la fracción continua 1/(1+1/(1+1/(2+1/(...)))), o sea,
        // 2/5, 7/12, 19/31, 50/81, ...
        // Y también la x sigue la fracción continua 1/(1+1/(1+1/(1+1/(...)))), o sea,
        // 1/2, 2/3, 3/5, 5/8, 8/13, ...
        long goldens = 0;
        BigInteger num = BigInteger.ONE;
        BigInteger den = new BigInteger("2");
        BigInteger num1 = new BigInteger("2");
        BigInteger den1 = new BigInteger("5");
        ArrayList<BigInteger> G = new ArrayList<BigInteger>();
        while (goldens < GOLDENS * 2) {
            BigInteger nd1 = num1.multiply(den1);
            BigInteger nn1 = num1.multiply(num1);
            BigInteger dd1 = den1.multiply(den1);
            BigInteger fxn1 = nd1.add(nn1.multiply(new BigInteger("3")));
            BigInteger fxd1 = dd1.subtract(nd1).subtract(nn1);
            if (fxd1.compareTo(BigInteger.ZERO) == 1) {
                goldens++;
                System.out.println("Golden " + goldens + ": x=" + num1.toString() + "/" + den1.toString() + " -> f(x) = " + fxn1.divide(fxd1).toString());
                G.add(fxn1.divide(fxd1));
            }
            num1 = den1.add(num1);
            den1 = num1.add(den1);

            BigInteger nd = num.multiply(den);
            BigInteger nn = num.multiply(num);
            BigInteger dd = den.multiply(den);
            BigInteger fxn = nd.add(nn.multiply(new BigInteger("3")));
            BigInteger fxd = dd.subtract(nd).subtract(nn);
            if (fxd.compareTo(BigInteger.ZERO) == 1) {
                goldens++;
                System.out.println("Golden " + goldens + ": x=" + num.toString() + "/" + den.toString() + " -> f(x) = " + fxn.divide(fxd).toString());
                G.add(fxn.divide(fxd));
            }
            den = num.add(den);
            num = den.subtract(num);
        }
        Collections.sort(G);
        BigInteger suma = BigInteger.ZERO;
        int C = 1;
        for (BigInteger bi : G) {
            suma = suma.add(bi);
            System.out.println("Golden " + C + " -> f(x) = " + bi.toString());
            if (C == GOLDENS)
                break;
            C++;
        }
        System.out.println("Suma = " + suma);
    }    
}
