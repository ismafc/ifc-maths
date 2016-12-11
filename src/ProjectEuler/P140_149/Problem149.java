/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P140_149;

import raytracer.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem149 {
    /*
    Looking at the table below, it is easy to verify that the maximum possible sum of adjacent numbers in any direction 
    (horizontal, vertical, diagonal or anti-diagonal) is 16 (= 8 + 7 + 1).

    −2	5   3   2
    9	−6  5	1
    3	2   7	3
    −1	8   −4  8

    Now, let us repeat the search, but on a much larger scale:

    First, generate four million pseudo-random numbers using a specific form of what is known as a "Lagged Fibonacci Generator":

    For 1 ≤ k ≤ 55, sk = [100003 − 200003k + 300007k^3] (modulo 1000000) − 500000.
    For 56 ≤ k ≤ 4000000, sk = [sk−24 + sk−55 + 1000000] (modulo 1000000) − 500000.

    Thus, s10 = −393027 and s100 = 86613.

    The terms of s are then arranged in a 2000×2000 table, using the first 2000 numbers to fill the first row (sequentially), 
    the next 2000 numbers to fill the second row, and so on.

    Finally, find the greatest sum of (any number of) adjacent entries in any direction (horizontal, vertical, diagonal or anti-diagonal).
    */
    
    public static long get(int column, int row, long[] orig) {
        return orig[row * (int)Math.sqrt(orig.length) + column];
    }
    
    public static void s(long k, long[] dest) {
        if (k <= 55)
            dest[(int)k - 1] = (100003 - 200003 * k + 300007 * k * k * k) % 1000000 - 500000;
        else
            dest[(int)k - 1] = (dest[(int)k - 24 - 1] + dest[(int)k - 55 - 1] + 1000000) % 1000000 - 500000;
    }
   
    public static void problem149() {        
        // Calculate table 
        final int TABLE_DIMENSION = 2000;
        long[] table = new long[TABLE_DIMENSION * TABLE_DIMENSION];      
        for (int k = 1; k <= TABLE_DIMENSION * TABLE_DIMENSION; k++)
            s(k, table);
        System.out.println("s(10) = " + table[10 - 1]);
        System.out.println("s(100) = " + table[100 - 1]);

/*
        final int TABLE_DIMENSION = 4;
        long[] table = new long[]{-2,5,3,2,9,-6,5,1,3,2,7,3,-1,8,-4,8};
*/        
        long max_sum = Long.MIN_VALUE;
        long[] numbers = new long[TABLE_DIMENSION];
        // Check horizontals
        for (int row = 0; row < TABLE_DIMENSION; row++) {
            for (int column = 0; column < TABLE_DIMENSION; column++)
                numbers[column] = get(column, row, table);
            long act_sum = IFCMath.max_sum_adjacent_numbers(numbers);
            if (act_sum > max_sum)
                max_sum = act_sum;
        }
        // Check verticals
        for (int column = 0; column < TABLE_DIMENSION; column++) {
            for (int row = 0; row < TABLE_DIMENSION; row++)
                numbers[row] = get(column, row, table);
            long act_sum = IFCMath.max_sum_adjacent_numbers(numbers);
            if (act_sum > max_sum)
                max_sum = act_sum;
        }
        
        // Check diagonals
        for (int column = 0; column < TABLE_DIMENSION; column++) {
            numbers = new long [column + 1];
            int c = column;
            int r = 0;
            while (c >= 0) {
                numbers[r] = get(c, r, table);
                c--;
                r++;
            }
            long act_sum = IFCMath.max_sum_adjacent_numbers(numbers);
            if (act_sum > max_sum)
                max_sum = act_sum;
        }
        for (int row = 1; row < TABLE_DIMENSION; row++) {
            numbers = new long [TABLE_DIMENSION - row];
            int r = row;
            int c = TABLE_DIMENSION - 1;
            while (r < TABLE_DIMENSION) {   
                numbers[r - row] = get(c, r, table);
                r++;
                c--;
            }
            long act_sum = IFCMath.max_sum_adjacent_numbers(numbers);
            if (act_sum > max_sum)
                max_sum = act_sum;            
        }

        // Check antidiagonals
        for (int column = 0; column < TABLE_DIMENSION; column++) {
            numbers = new long [column + 1];
            int c = column;
            int r = TABLE_DIMENSION - 1;
            while (c >= 0) {
                numbers[c] = get(c, r, table);
                c--;
                r--;
            }
            long act_sum = IFCMath.max_sum_adjacent_numbers(numbers);
            if (act_sum > max_sum)
                max_sum = act_sum;
        }
        for (int column = 1; column < TABLE_DIMENSION; column++) {
            numbers = new long [TABLE_DIMENSION - column];
            int c = column;
            int r = 0;
            while (c < TABLE_DIMENSION) {
                numbers[r] = get(c, r, table);
                r++;
                c++;
            }
            long act_sum = IFCMath.max_sum_adjacent_numbers(numbers);
            if (act_sum > max_sum)
                max_sum = act_sum;            
        }
        System.out.println("Max = " + max_sum);
    }
}
