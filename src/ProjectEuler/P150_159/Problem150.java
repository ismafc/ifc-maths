/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P150_159;

/**
 *
 * @author ismael.flores
 */
public class Problem150 {
    /*
    In a triangular array of positive and negative integers, 
    we wish to find a sub-triangle such that the sum of the numbers it contains is the smallest possible.

    In the example below, it can be easily verified that the marked triangle satisfies this condition having a sum of −42.

                        15
                    -14     -7
                20      -13     -5
            -3      8       23      -26
        1       -4      -5      -18     5
    -16     31      2       9       28      3
    
    We wish to make such a triangular array with one thousand rows, 
    so we generate 500500 pseudo-random numbers sk in the range ±2^19, 
    using a type of random number generator (known as a Linear Congruential Generator) as follows:

    t := 0 
    for k = 1 up to k = 500500: 
        t := (615949*t + 797807) modulo 2^20
        sk := t−2^19
    
    Thus: s1 = 273519, s2 = −153582, s3 = 450905 etc

    Our triangular array is then formed using the pseudo-random numbers thus:

                s1
            s2      s3
        s4      s5      s6  
    s7      s8      s9      s10
                ...

    Sub-triangles can start at any element of the array and extend down as far as we like 
    (taking-in the two elements directly below it from the next row, 
    the three elements directly below from the row after that, and so on). 
    The "sum of a sub-triangle" is defined as the sum of all the elements it contains. 
    Find the smallest possible sub-triangle sum.
    */

    public static long getRow(long k) {
        return (long)Math.ceil((Math.sqrt(1 + 8 * k) - 1) / 2);
    }

    public static long getMinSum(long[] triangle, long TRIANGLE_ROWS, long k) {
        long minSum = Long.MAX_VALUE;
        long values = TRIANGLE_ROWS * (TRIANGLE_ROWS + 1) / 2;
        long offset = getRow(k);
        long width = 1;
        long sum = 0;
        while (k <= values) {
            for (long i = 0; i < width; i++) {
                sum += triangle[(int)k - 1];
                k++;
            }
            if (sum < minSum)
                minSum = sum;
            width += 1;
            k += (offset - 1);
        }
        return minSum;
    }
    
    public static void problem150() {
/*        
        final long TRIANGLE_ROWS = 6;
        long values = TRIANGLE_ROWS * (TRIANGLE_ROWS + 1) / 2;
        long[] triangle = new long[]{
                            15,
                        -14,     -7,
                    20,      -13,     -5,
                -3,     8,       23,      -26,
            1,       -4,      -5,      -18,     5,
        -16,     31,      2,       9,       28,      3};
*/
        final long TRIANGLE_ROWS = 1000;
        long values = TRIANGLE_ROWS * (TRIANGLE_ROWS + 1) / 2;
        long[] triangle = new long[(int)values];
        long t = 0;
        long p2_20 = (long)Math.pow(2, 20);
        long p2_19 = (long)Math.pow(2, 19);
        for (long k = 1; k <= values; k++) { 
            t = (615949 * t + 797807) % p2_20;
            triangle[(int)k - 1] = t - p2_19;
        }
        
        long globalMinSum = Long.MAX_VALUE;
        for (long k = 1; k <= values; k++) {
            long newMinSum = getMinSum(triangle, TRIANGLE_ROWS, k);
            if (newMinSum < globalMinSum)
                globalMinSum = newMinSum;
        }
        
        System.out.println("Minimum sum = " + globalMinSum);
    }
}
