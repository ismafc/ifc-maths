/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P120_129;

/**
 *
 * @author ismael.flores
 */
public class Problem125 {
    
    private static boolean isPalindrome10L(Long n) {
        Long digits = Math.round(Math.floor(Math.log10(n))) + 1L;
        for (int digit = 0; digit < digits / 2; digit++) {
            int d1 = (int)(n / Math.pow(10, digit)) % 10;
            int d2 = (int)(n / Math.pow(10, digits - digit - 1)) % 10;
            if (d1 != d2)
                return false;
        }
        return true;
    }
    
    // Suma de los palíndrimos < 'to' que son suma de cuadrados (2 o más)
    /*
    Palindromic sums

    The palindromic number 595 is interesting because it can be written as the sum of consecutive squares: 6^2 + 7^2 + 8^2 + 9^2 + 10^2 + 11^2 + 12^2.

    There are exactly eleven palindromes below one-thousand that can be written as consecutive square sums, and the sum of these palindromes is 4164. 
    Note that 1 = 0^2 + 1^2 has not been included as this problem is concerned with the squares of positive integers.

    Find the sum of all the numbers less than 10^8 that are both palindromic and can be written as the sum of consecutive squares.
    */
    static long problem125(long to) {
        long sum = 0L;
        for (long pa = 1L; pa < to; pa++) {
            if (isPalindrome10L(pa)) {
                long n = Math.round(Math.floor(Math.sqrt(pa)));
                long s = (n * (n + 1) * (2 * n + 1) / 6);
                while (s > pa && n > 0) {
                    long nn = n;
                    long sumaux = nn * nn;
                    while (sumaux < pa || nn == 1) {
                        nn--;
                        sumaux += (nn * nn);
                    }
                    if (sumaux == pa) {
                        if (nn < n) {
                            sum += pa;
                            System.out.println(pa + " = " + nn + " to " + n);
                        }
                        break;
                    }
                    n--;
                    s = (n * (n + 1) * (2 * n + 1) / 6);
                }
                if (s == pa && 1 < n) {
                    System.out.println(pa + " = " + 1 + " to " + n);
                    sum += pa;
                }
                // n1(n1+1)(2n1+1)/6 - n2(n2+1)(2n2+1)/6 = pa
            }
        }
        System.out.println(sum);
        return sum;
    }

}
