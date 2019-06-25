/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P001_009;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import Library.IFCMath;

/**
 * 
 * Class to solve problem 1 in <a href="https://www.projecteuler.net" target="_blank">Project Euler</a>:
 * 
 * <p style="font-size:20px; color:#C83819">Multiples of 3 and 5</p>
 * 
 * <p style="font-size:14px; color:#000000">If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
 * The sum of these multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000.</p>
 *
 * @author Ismael Flores &lt;ismafc@gmail.com&gt;
 * @version 1.0
 * 
 */
public class Problem001 {

    /**
     * Enum containing implemented algorithms:<br>
     * <b>SOLUTION1:</b> One loop and compare each value in range with all provided values<br>
     * <b>SOLUTION2:</b> Using algorithm based on one loop for each multiple -step by this multiple- and in each loop don't add if added in some loop before<br>
     * <b>SOLUTION3:</b> All first 'n' multiples of one number 'k' has a formule:<br>
     * \(k \cdot \frac{n \cdot (n + 1)}{2}\)<br>
     * We need to substract multiples of Least Common Multiples added before recursvely
     */
    public enum Algorithm {
        SOLUTION1, SOLUTION2, SOLUTION3
    }
    
    /** 
     * Finds the sum of all the multiples of <b><i>a</i></b> or <b><i>b</i></b> from 1 and below <b><i>below</i></b>
     * Using algorithm based on one loop and compare each value in range with all provided values
     * @param a First value to check with all numbers in range <b>[1, <i>below</i>)</b>
     * @param b Second value to check with all numbers in range <b>[1, <i>below</i>)</b>
     * @param below Upper bound (not included). It defines range <b>[1, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    public long solution1(long a, long b, long below) {
        return solution1(new ArrayList<>(Arrays.asList(a, b)), 1, below);
    }

    /** 
     * Finds the sum of all the multiples of <b><i>a</i></b> or <b><i>b</i></b> from 1 and below <b><i>below</i></b>
     * Using algorithm based on one loop and compare each value in range with all provided values
     * @param a First value to check with all numbers in range <b>[1, <i>below</i>)</b>
     * @param b Second value to check with all numbers in range <b>[1, <i>below</i>)</b>
     * @param below Upper bound (not included). It defines range <b>[1, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum
     */
    public BigInteger solution1(BigInteger a, BigInteger b, BigInteger below) {
        return solution1(new ArrayList<>(Arrays.asList(a, b)), BigInteger.ONE, below);
    }
    
    /** 
     * Finds the sum of all the multiples of <b><i>a</i></b> or <b><i>b</i></b> from <b><i>from</i></b> and below <b><i>below</i></b>
     * Using algorithm based on one loop and compare each value in range with all provided values
     * @param a First value to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param b Second value to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param from Lower bound (included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @param below Upper bound (not included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    public long solution1(long a, long b, long from, long below) {
        return solution1(new ArrayList<>(Arrays.asList(a, b)), from, below);
    }

    /** 
     * Finds the sum of all the multiples of <b><i>a</i></b> or <b><i>b</i></b> from <b><i>from</i></b> and below <b><i>below</i></b>
     * Using algorithm based on one loop and compare each value in range with all provided values
     * @param a First value to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param b Second value to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param from Lower bound (included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @param below Upper bound (not included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum
     */
    public BigInteger solution1(BigInteger a, BigInteger b, BigInteger from, BigInteger below) {
        return solution1(new ArrayList<>(Arrays.asList(a, b)), from, below);
    }
   
    /** 
     * Finds the sum of all the multiples of any number in <b><i>values</i></b> (values[0], values[1], ..., values[n-1] or values[n]) from <b><i>from</i></b> and below <b><i>below</i></b>.
     * Using algorithm based on one loop and compare each value in range with all provided values
     * @param values List of values to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param from Lower bound (included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with all values in <b><i>values</i></b>
     * @param below Upper bound (not included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with all values in <b><i>values</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    private long solution1(ArrayList<Long> values, long from, long below) {
        long sum = 0;
        for (long i = from; i < below; i++) {
            if (IFCMath.mod(i, values))
                sum += i;
        }
        return sum;
    }

    /** 
     * Finds the sum of all the multiples of any number in <b><i>values</i></b> (values[0], values[1], ..., values[n-1] or values[n]) from <b><i>from</i></b> and below <b><i>below</i></b>.
     * Using algorithm based on one loop and compare each value in range with all provided values
     * @param values List of values to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param from Lower bound (included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with all values in <b><i>values</i></b>
     * @param below Upper bound (not included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with all values in <b><i>values</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum
     */
    private BigInteger solution1(ArrayList<BigInteger> values, BigInteger from, BigInteger below) {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger i = from; i.compareTo(below) == -1; i = i.add(BigInteger.ONE)) {
            if (IFCMath.mod(i, values))
                sum = sum.add(i);
        }
        return sum;
    }
    
    /** 
     * Finds the sum of all the multiples of <b><i>a</i></b> or <b><i>b</i></b> from 1 and below <b><i>below</i></b>
     * Using algorithm based on one loop for each multiple -step by this multiple- and in each loop don't add if added in some loop before
     * @param a First value to check with all numbers in range <b>[1, <i>below</i>)</b>
     * @param b Second value to check with all numbers in range <b>[1, <i>below</i>)</b>
     * @param below Upper bound (not included). It defines range <b>[1, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    public long solution2(long a, long b, long below) {
        return solution2(new ArrayList<>(Arrays.asList(a, b)), 1, below);
    }

    /** 
     * Finds the sum of all the multiples of <b><i>a</i></b> or <b><i>b</i></b> from 1 and below <b><i>below</i></b>
     * Using algorithm based on one loop for each multiple -step by this multiple- and in each loop don't add if added in some loop before
     * @param a First value to check with all numbers in range <b>[1, <i>below</i>)</b>
     * @param b Second value to check with all numbers in range <b>[1, <i>below</i>)</b>
     * @param below Upper bound (not included). It defines range <b>[1, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum
     */
    public BigInteger solution2(BigInteger a, BigInteger b, BigInteger below) {
        return solution2(new ArrayList<>(Arrays.asList(a, b)), BigInteger.ONE, below);
    }
    
    /** 
     * Finds the sum of all the multiples of <b><i>a</i></b> or <b><i>b</i></b> from <b><i>from</i></b> and below <b><i>below</i></b>
     * Using algorithm based on one loop for each multiple -step by this multiple- and in each loop don't add if added in some loop before
     * @param a First value to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param b Second value to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param from Lower bound (included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @param below Upper bound (not included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    public long solution2(long a, long b, long from, long below) {
        return solution2(new ArrayList<>(Arrays.asList(a, b)), from, below);
    }

    /** 
     * Finds the sum of all the multiples of <b><i>a</i></b> or <b><i>b</i></b> from <b><i>from</i></b> and below <b><i>below</i></b>
     * Using algorithm based on one loop for each multiple -step by this multiple- and in each loop don't add if added in some loop before
     * @param a First value to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param b Second value to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param from Lower bound (included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @param below Upper bound (not included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum
     */
    public BigInteger solution2(BigInteger a, BigInteger b, BigInteger from, BigInteger below) {
        return solution2(new ArrayList<>(Arrays.asList(a, b)), from, below);
    }
    
    /** 
     * Finds the sum of all the multiples of any number in <b><i>values</i></b> (values[0], values[1], ..., values[n-1] or values[n]) from <b><i>from</i></b> and below <b><i>below</i></b>.
     * Using algorithm based on one loop for each multiple -step by this multiple- and in each loop don't add if added in some loop before
     * @param values List of values to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param from Lower bound (included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with all values in <b><i>values</i></b>
     * @param below Upper bound (not included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with all values in <b><i>values</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    private long solution2(ArrayList<Long> values, long from, long below) {
        long sum = 0;
        ArrayList<Long> nV = new ArrayList<>();
        for (long value : values) {
            long M1 = (from % value == 0) ? from : from + value - from % value;
            for (long i = M1; i < below; i += value) {
                if (!IFCMath.mod(i, nV)) {
                    sum += i;
                }
            }
            nV.add(value);
        }
        return sum;
    }

    /** 
     * Finds the sum of all the multiples of any number in <b><i>values</i></b> (values[0], values[1], ..., values[n-1] or values[n]) from <b><i>from</i></b> and below <b><i>below</i></b>.
     * Using algorithm based on one loop for each multiple -step by this multiple- and in each loop don't add if added in some loop before
     * @param values List of values to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param from Lower bound (included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with all values in <b><i>values</i></b>
     * @param below Upper bound (not included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with all values in <b><i>values</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum
     */
    private BigInteger solution2(ArrayList<BigInteger> values, BigInteger from, BigInteger below) {
        BigInteger sum = BigInteger.ZERO;
        ArrayList<BigInteger> nV = new ArrayList<>();
        for (BigInteger value : values) {
            BigInteger M1 = (from.mod(value).equals(BigInteger.ZERO)) ? from : from.add(value).subtract(from.mod(value));
            for (BigInteger i = M1; i.compareTo(below) == -1; i = i.add(value)) {
                if (!IFCMath.mod(i, nV))
                    sum = sum.add(i);
            }
            nV.add(value);
        }
        return sum;
    }    
    
    /** 
     * Finds the sum of all the multiples of <b><i>a</i></b> or <b><i>b</i></b> from 1 and below <b><i>below</i></b>
     * Using algorithm based on sum of <b>n</b> first multiples of <b>k</b>:<br>
     * \(k \cdot \frac{n \cdot (n + 1)}{2}\)<br>
     * And recursively substraction of least common multiple
     * @param a First value to check with all numbers in range <b>[1, <i>below</i>)</b>
     * @param b Second value to check with all numbers in range <b>[1, <i>below</i>)</b>
     * @param below Upper bound (not included). It defines range <b>[1, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    public long solution3(long a, long b, long below) {
        return solution3(new ArrayList<>(Arrays.asList(a, b)), 1, below);
    }
    
    /** 
     * Finds the sum of all the multiples of <b><i>a</i></b> or <b><i>b</i></b> from <b><i>from</i></b> and below <b><i>below</i></b>
     * Using algorithm based on sum of <b>n</b> first multiples of <b>k</b>:<br>
     * \(k \cdot \frac{n \cdot (n + 1)}{2}\)<br>
     * And recursively substraction of least common multiple
     * @param a First value to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param b Second value to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param from Lower bound (included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @param below Upper bound (not included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    public long solution3(long a, long b, long from, long below) {
        return solution3(new ArrayList<>(Arrays.asList(a, b)), from, below);
    }

    /** 
     * Finds the sum of all the multiples of <b><i>a</i></b> or <b><i>b</i></b> from 1 and below <b><i>below</i></b>
     * Using algorithm based on sum of <b>n</b> first multiples of <b>k</b>:<br>
     * \(k \cdot \frac{n \cdot (n + 1)}{2}\)<br>
     * And recursively substraction of least common multiple
     * @param a First value to check with all numbers in range <b>[1, <i>below</i>)</b>
     * @param b Second value to check with all numbers in range <b>[1, <i>below</i>)</b>
     * @param below Upper bound (not included). It defines range <b>[1, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum
     */
    public BigInteger solution3(BigInteger a, BigInteger b, BigInteger below) {
        return solution3(new ArrayList<>(Arrays.asList(a, b)), BigInteger.ONE, below);
    }

    /** 
     * Finds the sum of all the multiples of <b><i>a</i></b> or <b><i>b</i></b> from <b><i>from</i></b> and below <b><i>below</i></b>
     * Using algorithm based on sum of <b>n</b> first multiples of <b>k</b>:<br>
     * \(k \cdot \frac{n \cdot (n + 1)}{2}\)<br>
     * And recursively substraction of least common multiple
     * @param a First value to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param b Second value to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param from Lower bound (included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @param below Upper bound (not included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum
     */
    public BigInteger solution3(BigInteger a, BigInteger b, BigInteger from, BigInteger below) {
        return solution3(new ArrayList<>(Arrays.asList(a, b)), from, below);
    }
    
    /** 
     * Finds the sum of all the multiples of any number in <b><i>values</i></b> (values[0], values[1], ..., values[n-1] or values[n]) 
     * from <b><i>from</i></b> and below <b><i>below</i></b>
     * Using algorithm based on sum of <b>n</b> first multiples of <b>k</b>:<br>
     * \(k \cdot \frac{n \cdot (n + 1)}{2}\)<br>
     * And recursively substraction of least common multiple
     * 
     * @param values List of values to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param from Lower bound (included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with all values in <b><i>values</i></b>
     * @param below Upper bound (not included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with all values in <b><i>values</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    private long solution3(ArrayList<Long> values, long from, long below) {
        ArrayList<Long> nV = new ArrayList<>();
        long total = 0;
        for (long value : values) {
            long E1 = below - 1;
            long A1 = E1 / value;
            long R1 = value * (A1 * (A1 + 1)) / 2;
            long E2 = from - 1;
            long A2 = E2 / value;
            long R2 = value * (A2 * (A2 + 1)) / 2;
            long R = R1 - R2;
            ArrayList<Long> repeated = new ArrayList<>(); 
            nV.forEach(p -> repeated.add(IFCMath.MCM(value, p)));
            total = total + R - solution3(repeated, from, below);
            nV.add(value);
        }
        return total;
    }

    /** 
     * Finds the sum of all the multiples of any number in <b><i>value</i></b> (value[0], value[1], ..., value[n-1] or value[n]) 
     * from <b><i>from</i></b> and below <b><i>below</i></b> using <b>BigInteger</b> class to allow big numbers<br>
     * Using algorithm based on sum of <b>n</b> first multiples of <b>k</b>:<br>
     * \(k \cdot \frac{n \cdot (n + 1)}{2}\)<br>
     * And recursively substraction of least common multiple
     * 
     * @param values List of values to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param from Lower bound (included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with all values in <b><i>value</i></b>
     * @param below Upper bound (not included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with all values in <b><i>value</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum
     */
    private BigInteger solution3(ArrayList<BigInteger> values, BigInteger from, BigInteger below) {
        ArrayList<BigInteger> nV = new ArrayList<>();
        BigInteger TWO = new BigInteger("2");
        BigInteger total = BigInteger.ZERO;
        for (BigInteger value : values) {
            BigInteger E1 = below.subtract(BigInteger.ONE);
            BigInteger A1 = E1.divide(value);
            BigInteger R1 = A1.add(BigInteger.ONE).multiply(A1).multiply(value).divide(TWO);
            BigInteger E2 = from.subtract(BigInteger.ONE);
            BigInteger A2 = E2.divide(value);
            BigInteger R2 = A2.add(BigInteger.ONE).multiply(A2).multiply(value).divide(TWO);
            BigInteger R = R1.subtract(R2);
            ArrayList<BigInteger> repeated = new ArrayList<>(); 
            nV.forEach(p -> repeated.add(IFCMath.MCM(value, p)));
            total = total.add(R).subtract(solution3(repeated, from, below));
            nV.add(value);
        }
        return total;
    }

    /** 
     * Find the sum of all the multiples of 3 or 5 below 1000
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    public long solve() {
        return solve(new ArrayList<>(Arrays.asList(3L, 5L)), 1, 1000, Algorithm.SOLUTION3);
    }

    /** 
     * Find the sum of all the multiples of 3 or 5 below 1000
     * @param algorithm Algorithm we want to use to calculate the desired value
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum calculated using provided algorithm
     */
    public long solve(Algorithm algorithm) {
        return solve(new ArrayList<>(Arrays.asList(3L, 5L)), 1, 1000, algorithm);
    }
    
    /** 
     * Finds the sum of all the multiples of <b><i>a</i></b> or <b><i>b</i></b> from 1 and below <b><i>below</i></b>
     * @param a First value to check with all numbers in range <b>[1, <i>below</i>)</b>
     * @param b Second value to check with all numbers in range <b>[1, <i>below</i>)</b>
     * @param below Upper bound (not included). It defines range <b>[1, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    public long solve(long a, long b, long below) {
        return solve(new ArrayList<>(Arrays.asList(a, b)), 1, below, Algorithm.SOLUTION3);
    }

    /** 
     * Finds the sum of all the multiples of <b><i>a</i></b> or <b><i>b</i></b> from 1 and below <b><i>below</i></b> with
     * provided algorithm through <b><i>algorithm</i></b>
     * @param a First value to check with all numbers in range <b>[1, <i>below</i>)</b>
     * @param b Second value to check with all numbers in range <b>[1, <i>below</i>)</b>
     * @param below Upper bound (not included). It defines range <b>[1, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @param algorithm Algorithm we want to use to calculate the desired value
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum calculated using provided algorithm
     */
    public long solve(long a, long b, long below, Algorithm algorithm) {
        return solve(new ArrayList<>(Arrays.asList(a, b)), 1, below, algorithm);
    }
    
    /** 
     * Finds the sum of all the multiples of <b><i>a</i></b> or <b><i>b</i></b> from <b><i>from</i></b> and below <b><i>below</i></b>
     * @param a First value to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param b Second value to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param from Lower bound (included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @param below Upper bound (not included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    public long solve(long a, long b, long from, long below) {
        return solve(new ArrayList<>(Arrays.asList(a, b)), from, below, Algorithm.SOLUTION3);
    }

    /** 
     * Finds the sum of all the multiples of <b><i>a</i></b> or <b><i>b</i></b> from <b><i>from</i></b> and below <b><i>below</i></b>
     * using provided algorithm through <b><i>algorithm</i></b>
     * @param a First value to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param b Second value to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param from Lower bound (included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @param below Upper bound (not included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @param algorithm Algorithm we want to use to calculate the desired value
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum calculated using provided algorithm
     */
    public long solve(long a, long b, long from, long below, Algorithm algorithm) {
        return solve(new ArrayList<>(Arrays.asList(a, b)), from, below, algorithm);
    }

    /** 
     * Finds the sum of all the multiples of <b><i>a</i></b> or <b><i>b</i></b> from 1 and below <b><i>below</i></b>
     * @param a First value to check with all numbers in range <b>[1, <i>below</i>)</b>
     * @param b Second value to check with all numbers in range <b>[1, <i>below</i>)</b>
     * @param below Upper bound (not included). It defines range <b>[1, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum
     */
    public BigInteger solve(BigInteger a, BigInteger b, BigInteger below) {
        return solve(new ArrayList<>(Arrays.asList(a, b)), BigInteger.ONE, below, Algorithm.SOLUTION3);
    }

    /** 
     * Finds the sum of all the multiples of <b><i>a</i></b> or <b><i>b</i></b> from 1 and below <b><i>below</i></b> using
     * provided algorithm through <b><i>algorithm</i></b>
     * @param a First value to check with all numbers in range <b>[1, <i>below</i>)</b>
     * @param b Second value to check with all numbers in range <b>[1, <i>below</i>)</b>
     * @param below Upper bound (not included). It defines range <b>[1, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @param algorithm Algorithm we want to use to calculate the desired value
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum calculated using provided algorithm
     */
    public BigInteger solve(BigInteger a, BigInteger b, BigInteger below, Algorithm algorithm) {
        return solve(new ArrayList<>(Arrays.asList(a, b)), BigInteger.ONE, below, algorithm);
    }
    
    /** 
     * Finds the sum of all the multiples of <b><i>a</i></b> or <b><i>b</i></b> from <b><i>from</i></b> and below <b><i>below</i></b>
     * @param a First value to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param b Second value to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param from Lower bound (included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @param below Upper bound (not included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum
     */
    public BigInteger solve(BigInteger a, BigInteger b, BigInteger from, BigInteger below) {
        return solve(new ArrayList<>(Arrays.asList(a, b)), from, below, Algorithm.SOLUTION3);
    }

    /** 
     * Finds the sum of all the multiples of <b><i>a</i></b> or <b><i>b</i></b> from <b><i>from</i></b> and below <b><i>below</i></b>
     * using provided algorithm through <b><i>algorithm</i></b>
     * @param a First value to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param b Second value to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param from Lower bound (included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @param below Upper bound (not included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with <b><i>a</i></b> and <b><i>b</i></b>
     * @param algorithm Algorithm we want to use to calculate the desired value
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum calculated using provided algorithm
     */
    public BigInteger solve(BigInteger a, BigInteger b, BigInteger from, BigInteger below, Algorithm algorithm) {
        return solve(new ArrayList<>(Arrays.asList(a, b)), from, below, algorithm);
    }
    
    /** 
     * Finds the sum of all the multiples of any number in <b><i>value</i></b> (value[0], value[1], ..., value[n-1] or value[n]) from <b><i>from</i></b> and below <b><i>below</i></b>.
     * @param values List of values to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param from Lower bound (included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with all values in <b><i>value</i></b>
     * @param below Upper bound (not included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with all values in <b><i>value</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    public long solve(ArrayList<Long> values, long from, long below) {
        return solve(values, from, below, Algorithm.SOLUTION3);
    }

    /** 
     * Finds the sum of all the multiples of any number in <b><i>value</i></b> (value[0], value[1], ..., value[n-1] or value[n]) from <b><i>from</i></b> and below <b><i>below</i></b>.
     * @param values List of values to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param from Lower bound (included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with all values in <b><i>value</i></b>
     * @param below Upper bound (not included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with all values in <b><i>value</i></b>
     * @param algorithm Algorithm we want to use to calculate the desired value
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum calculated using provided algorithm
     */
    public long solve(ArrayList<Long> values, long from, long below, Algorithm algorithm) {
        switch (algorithm) {
            case SOLUTION1:
                return solution1(values, from, below);
            case SOLUTION2:
                return solution2(values, from, below);
            case SOLUTION3:
                return solution3(values, from, below);
        }
        return solution3(values, from, below);
    }
    
    /** 
     * Finds the sum of all the multiples of any number in <b><i>value</i></b> (value[0], value[1], ..., value[n-1] or value[n]) from <b><i>from</i></b> and below <b><i>below</i></b>.
     * @param values List of values to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param from Lower bound (included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with all values in <b><i>value</i></b>
     * @param below Upper bound (not included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with all values in <b><i>value</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum
     */
    public BigInteger solve(ArrayList<BigInteger> values, BigInteger from, BigInteger below) {
        return solve(values, from, below, Algorithm.SOLUTION3);
    }

    /** 
     * Finds the sum of all the multiples of any number in <b><i>value</i></b> (value[0], value[1], ..., value[n-1] or value[n]) from <b><i>from</i></b> and below <b><i>below</i></b>.
     * @param values List of values to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param from Lower bound (included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with all values in <b><i>value</i></b>
     * @param below Upper bound (not included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with all values in <b><i>value</i></b>
     * @param algorithm Algorithm we want to use to calculate the desired value
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum calculated using provided algorithm
     */
    public BigInteger solve(ArrayList<BigInteger> values, BigInteger from, BigInteger below, Algorithm algorithm) {
        switch (algorithm) {
            case SOLUTION1:
                return solution1(values, from, below);
            case SOLUTION2:
                return solution2(values, from, below);
            case SOLUTION3:
                return solution3(values, from, below);
        }
        return solution3(values, from, below);
    }
}

