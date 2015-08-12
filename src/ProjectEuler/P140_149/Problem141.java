/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P140_149;

/**
 *
 * @author ismael.flores
 */
public class Problem141 {
    /*
    Investigating progressive numbers, n, which are also square

    A positive integer, n, is divided by d and the quotient and remainder are q and r respectively. 
    In addition d, q, and r are consecutive positive integer terms in a geometric sequence, but not necessarily in that order.

    For example, 58 divided by 6 has quotient 9 and remainder 4. 
    It can also be seen that 4, 6, 9 are consecutive terms in a geometric sequence (common ratio 3/2).
    We will call such numbers, n, progressive.

    Some progressive numbers, such as 9 and 10404 = 102^2, happen to also be perfect squares.
    The sum of all progressive perfect squares below one hundred thousand is 124657.

    Find the sum of all progressive perfect squares below one trillion (10^12).
    */
    private static boolean isProgressive (long n, long sqrn) {
        for (long d = 2; d < sqrn; d++) {
            long r = n % d;
            if (r > 0) {
                // q > d > r
                long q = n / d;
                if (d * d == q * r) {
                    System.out.println("(" + n + ") : " + r + ", "+ d + ", " + q + ", ");
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void problem141(long max) {
        // (9) : 1, 2, 4, 
        // (10404) : 36, 72, 144, 
        // (16900) : 25, 75, 225, 
        // (97344) : 8, 92, 1058, 
        // (576081) : 81, 360, 1600, 
        // (6230016) : 512, 1472, 4232, 
        // (7322436) : 1936, 2420, 3025, 
        // (12006225) : 1225, 2450, 4900, 
        // (36869184) : 5184, 5760, 6400, 
        // (37344321) : 3969, 5292, 7056, 
        // (70963776) : 5832, 7452, 9522, 
        // (196112016) : 432, 4392, 44652, 
        // (256160025) : 1089, 6534, 39204, 
        // (1361388609) : 21609, 30870, 44100, 
        // (1380568336) : 12544, 25872, 53361, 
        // (8534988225) : 50625, 75600, 112896, 
        // (9729849600) : 50625, 78975, 123201, 
        // (12551169024) : 27648, 70272, 178608, 
        // (13855173264) : 41616, 83232, 166464, 
        // (16394241600) : 69696, 104544, 156816, 
        // (123383587600) : 67600, 202800, 608400, 
        // (142965659664) : 314928, 355752, 401868, 
        // (547674002500) : 521284, 658464, 831744,
        long _n = 3;
        long nn = _n * _n;
        long sum = 0;
        while (nn < max) {
            if (isProgressive(nn, _n))
                sum += nn;
            _n++;
            nn = _n * _n;
        }
        System.out.println("sum = " + sum);
    }    
}
