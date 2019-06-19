/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P001_009;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import raytracer.IFCMath;

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
     * Constant related to first algorithm:<br>
     * One loop and compare each value in range with all provided values
     */
    public final static int SOLUTION1 = 1;
    
    /**
     * Constant related to second algorithm:<br>
     * Using algorithm based on one loop for each multiple -step by this multiple- and in each loop don't add if added in some loop before
     */
    public final static int SOLUTION2 = 2;
    
    /**
     * Constant related to third algorithm:<br>
     * All first 'n' multiples of one number 'k' has a formule:<br>
     * \(k \cdot \frac{n \cdot (n + 1)}{2}\)<br>
     * We need to substract multiples of Least Common Multiples added before recursvely
     */
    public final static int SOLUTION3 = 3;

    /** 
     * Finds the sum of all the multiples of <b><i>A</i></b> or <b><i>B</i></b> from 1 and below <b><i>BELOW</i></b>
     * Using algorithm based on one loop and compare each value in range with all provided values
     * @param A First value to check with all numbers in range <b>[1, <i>BELOW</i>)</b>
     * @param B Second value to check with all numbers in range <b>[1, <i>BELOW</i>)</b>
     * @param BELOW Upper bound (not included). It defines range <b>[1, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    public long solution1(long A, long B, long BELOW) {
        return solution1(new ArrayList<>(Arrays.asList(A, B)), 1, BELOW);
    }

    /** 
     * Finds the sum of all the multiples of <b><i>A</i></b> or <b><i>B</i></b> from 1 and below <b><i>BELOW</i></b>
     * Using algorithm based on one loop and compare each value in range with all provided values
     * @param A First value to check with all numbers in range <b>[1, <i>BELOW</i>)</b>
     * @param B Second value to check with all numbers in range <b>[1, <i>BELOW</i>)</b>
     * @param BELOW Upper bound (not included). It defines range <b>[1, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum
     */
    public BigInteger solution1(BigInteger A, BigInteger B, BigInteger BELOW) {
        return solution1(new ArrayList<>(Arrays.asList(A, B)), BigInteger.ONE, BELOW);
    }
    
    /** 
     * Finds the sum of all the multiples of <b><i>A</i></b> or <b><i>B</i></b> from <b><i>FROM</i></b> and below <b><i>BELOW</i></b>
     * Using algorithm based on one loop and compare each value in range with all provided values
     * @param A First value to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param B Second value to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param FROM Lower bound (included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @param BELOW Upper bound (not included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    public long solution1(long A, long B, long FROM, long BELOW) {
        return solution1(new ArrayList<>(Arrays.asList(A, B)), FROM, BELOW);
    }

    /** 
     * Finds the sum of all the multiples of <b><i>A</i></b> or <b><i>B</i></b> from <b><i>FROM</i></b> and below <b><i>BELOW</i></b>
     * Using algorithm based on one loop and compare each value in range with all provided values
     * @param A First value to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param B Second value to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param FROM Lower bound (included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @param BELOW Upper bound (not included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum
     */
    public BigInteger solution1(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW) {
        return solution1(new ArrayList<>(Arrays.asList(A, B)), FROM, BELOW);
    }
   
    /** 
     * Finds the sum of all the multiples of any number in <b><i>V</i></b> (V[0], V[1], ..., V[n-1] or V[n]) from <b><i>FROM</i></b> and below <b><i>BELOW</i></b>.
     * Using algorithm based on one loop and compare each value in range with all provided values
     * @param V List of values to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param FROM Lower bound (included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with all values in <b><i>V</i></b>
     * @param BELOW Upper bound (not included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with all values in <b><i>V</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    private long solution1(ArrayList<Long> V, long FROM, long BELOW) {
        long sum = 0;
        for (long i = FROM; i < BELOW; i++) {
            if (IFCMath.mod(i, V))
                sum += i;
        }
        return sum;
    }

    /** 
     * Finds the sum of all the multiples of any number in <b><i>V</i></b> (V[0], V[1], ..., V[n-1] or V[n]) from <b><i>FROM</i></b> and below <b><i>BELOW</i></b>.
     * Using algorithm based on one loop and compare each value in range with all provided values
     * @param V List of values to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param FROM Lower bound (included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with all values in <b><i>V</i></b>
     * @param BELOW Upper bound (not included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with all values in <b><i>V</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum
     */
    private BigInteger solution1(ArrayList<BigInteger> V, BigInteger FROM, BigInteger BELOW) {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger i = FROM; i.compareTo(BELOW) == -1; i = i.add(BigInteger.ONE)) {
            if (IFCMath.mod(i, V))
                sum = sum.add(i);
        }
        return sum;
    }
    
    /** 
     * Finds the sum of all the multiples of <b><i>A</i></b> or <b><i>B</i></b> from 1 and below <b><i>BELOW</i></b>
     * Using algorithm based on one loop for each multiple -step by this multiple- and in each loop don't add if added in some loop before
     * @param A First value to check with all numbers in range <b>[1, <i>BELOW</i>)</b>
     * @param B Second value to check with all numbers in range <b>[1, <i>BELOW</i>)</b>
     * @param BELOW Upper bound (not included). It defines range <b>[1, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    public long solution2(long A, long B, long BELOW) {
        return solution2(new ArrayList<>(Arrays.asList(A, B)), 1, BELOW);
    }

    /** 
     * Finds the sum of all the multiples of <b><i>A</i></b> or <b><i>B</i></b> from 1 and below <b><i>BELOW</i></b>
     * Using algorithm based on one loop for each multiple -step by this multiple- and in each loop don't add if added in some loop before
     * @param A First value to check with all numbers in range <b>[1, <i>BELOW</i>)</b>
     * @param B Second value to check with all numbers in range <b>[1, <i>BELOW</i>)</b>
     * @param BELOW Upper bound (not included). It defines range <b>[1, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum
     */
    public BigInteger solution2(BigInteger A, BigInteger B, BigInteger BELOW) {
        return solution2(new ArrayList<>(Arrays.asList(A, B)), BigInteger.ONE, BELOW);
    }
    
    /** 
     * Finds the sum of all the multiples of <b><i>A</i></b> or <b><i>B</i></b> from <b><i>FROM</i></b> and below <b><i>BELOW</i></b>
     * Using algorithm based on one loop for each multiple -step by this multiple- and in each loop don't add if added in some loop before
     * @param A First value to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param B Second value to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param FROM Lower bound (included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @param BELOW Upper bound (not included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    public long solution2(long A, long B, long FROM, long BELOW) {
        return solution2(new ArrayList<>(Arrays.asList(A, B)), FROM, BELOW);
    }

    /** 
     * Finds the sum of all the multiples of <b><i>A</i></b> or <b><i>B</i></b> from <b><i>FROM</i></b> and below <b><i>BELOW</i></b>
     * Using algorithm based on one loop for each multiple -step by this multiple- and in each loop don't add if added in some loop before
     * @param A First value to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param B Second value to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param FROM Lower bound (included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @param BELOW Upper bound (not included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum
     */
    public BigInteger solution2(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW) {
        return solution2(new ArrayList<>(Arrays.asList(A, B)), FROM, BELOW);
    }
    
    /** 
     * Finds the sum of all the multiples of any number in <b><i>V</i></b> (V[0], V[1], ..., V[n-1] or V[n]) from <b><i>FROM</i></b> and below <b><i>BELOW</i></b>.
     * Using algorithm based on one loop for each multiple -step by this multiple- and in each loop don't add if added in some loop before
     * @param V List of values to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param FROM Lower bound (included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with all values in <b><i>V</i></b>
     * @param BELOW Upper bound (not included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with all values in <b><i>V</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    private long solution2(ArrayList<Long> V, long FROM, long BELOW) {
        long sum = 0;
        ArrayList<Long> nV = new ArrayList<>();
        for (long v : V) {
            long M1 = (FROM % v == 0) ? FROM : FROM + v - FROM % v;
            for (long i = M1; i < BELOW; i += v) {
                if (!IFCMath.mod(i, nV)) {
                    sum += i;
                }
            }
            nV.add(v);
        }
        return sum;
    }

    /** 
     * Finds the sum of all the multiples of any number in <b><i>V</i></b> (V[0], V[1], ..., V[n-1] or V[n]) from <b><i>FROM</i></b> and below <b><i>BELOW</i></b>.
     * Using algorithm based on one loop for each multiple -step by this multiple- and in each loop don't add if added in some loop before
     * @param V List of values to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param FROM Lower bound (included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with all values in <b><i>V</i></b>
     * @param BELOW Upper bound (not included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with all values in <b><i>V</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum
     */
    private BigInteger solution2(ArrayList<BigInteger> V, BigInteger FROM, BigInteger BELOW) {
        BigInteger sum = BigInteger.ZERO;
        ArrayList<BigInteger> nV = new ArrayList<>();
        for (BigInteger v : V) {
            BigInteger M1 = (FROM.mod(v).equals(BigInteger.ZERO)) ? FROM : FROM.add(v).subtract(FROM.mod(v));
            for (BigInteger i = M1; i.compareTo(BELOW) == -1; i = i.add(v)) {
                if (!IFCMath.mod(i, nV))
                    sum = sum.add(i);
            }
            nV.add(v);
        }
        return sum;
    }    
    
    /** 
     * Finds the sum of all the multiples of <b><i>A</i></b> or <b><i>B</i></b> from 1 and below <b><i>BELOW</i></b>
     * Using algorithm based on sum of <b>n</b> first multiples of <b>k</b>:<br>
     * \(k \cdot \frac{n \cdot (n + 1)}{2}\)<br>
     * And recursively substraction of least common multiple
     * @param A First value to check with all numbers in range <b>[1, <i>BELOW</i>)</b>
     * @param B Second value to check with all numbers in range <b>[1, <i>BELOW</i>)</b>
     * @param BELOW Upper bound (not included). It defines range <b>[1, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    public long solution3(long A, long B, long BELOW) {
        return solution3(new ArrayList<>(Arrays.asList(A, B)), 1, BELOW);
    }
    
    /** 
     * Finds the sum of all the multiples of <b><i>A</i></b> or <b><i>B</i></b> from <b><i>FROM</i></b> and below <b><i>BELOW</i></b>
     * Using algorithm based on sum of <b>n</b> first multiples of <b>k</b>:<br>
     * \(k \cdot \frac{n \cdot (n + 1)}{2}\)<br>
     * And recursively substraction of least common multiple
     * @param A First value to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param B Second value to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param FROM Lower bound (included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @param BELOW Upper bound (not included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    public long solution3(long A, long B, long FROM, long BELOW) {
        return solution3(new ArrayList<>(Arrays.asList(A, B)), FROM, BELOW);
    }

    /** 
     * Finds the sum of all the multiples of <b><i>A</i></b> or <b><i>B</i></b> from 1 and below <b><i>BELOW</i></b>
     * Using algorithm based on sum of <b>n</b> first multiples of <b>k</b>:<br>
     * \(k \cdot \frac{n \cdot (n + 1)}{2}\)<br>
     * And recursively substraction of least common multiple
     * @param A First value to check with all numbers in range <b>[1, <i>BELOW</i>)</b>
     * @param B Second value to check with all numbers in range <b>[1, <i>BELOW</i>)</b>
     * @param BELOW Upper bound (not included). It defines range <b>[1, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum
     */
    public BigInteger solution3(BigInteger A, BigInteger B, BigInteger BELOW) {
        return solution3(new ArrayList<>(Arrays.asList(A, B)), BigInteger.ONE, BELOW);
    }

    /** 
     * Finds the sum of all the multiples of <b><i>A</i></b> or <b><i>B</i></b> from <b><i>FROM</i></b> and below <b><i>BELOW</i></b>
     * Using algorithm based on sum of <b>n</b> first multiples of <b>k</b>:<br>
     * \(k \cdot \frac{n \cdot (n + 1)}{2}\)<br>
     * And recursively substraction of least common multiple
     * @param A First value to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param B Second value to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param FROM Lower bound (included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @param BELOW Upper bound (not included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum
     */
    public BigInteger solution3(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW) {
        return solution3(new ArrayList<>(Arrays.asList(A, B)), FROM, BELOW);
    }
    
    /** 
     * Finds the sum of all the multiples of any number in <b><i>V</i></b> (V[0], V[1], ..., V[n-1] or V[n]) 
     * from <b><i>FROM</i></b> and below <b><i>BELOW</i></b>
     * Using algorithm based on sum of <b>n</b> first multiples of <b>k</b>:<br>
     * \(k \cdot \frac{n \cdot (n + 1)}{2}\)<br>
     * And recursively substraction of least common multiple
     * 
     * @param V List of values to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param FROM Lower bound (included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with all values in <b><i>V</i></b>
     * @param BELOW Upper bound (not included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with all values in <b><i>V</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    private long solution3(ArrayList<Long> V, long FROM, long BELOW) {
        ArrayList<Long> nV = new ArrayList<>();
        long total = 0;
        for (long v : V) {
            long E1 = BELOW - 1;
            long A1 = E1 / v;
            long R1 = v * (A1 * (A1 + 1)) / 2;
            long E2 = FROM - 1;
            long A2 = E2 / v;
            long R2 = v * (A2 * (A2 + 1)) / 2;
            long R = R1 - R2;
            ArrayList<Long> repeated = new ArrayList<>(); 
            nV.forEach(p -> repeated.add(IFCMath.MCM(v, p)));
            total = total + R - solution3(repeated, FROM, BELOW);
            nV.add(v);
        }
        return total;
    }

    /** 
     * Finds the sum of all the multiples of any number in <b><i>V</i></b> (V[0], V[1], ..., V[n-1] or V[n]) 
     * from <b><i>FROM</i></b> and below <b><i>BELOW</i></b> using <b>BigInteger</b> class to allow big numbers<br>
     * Using algorithm based on sum of <b>n</b> first multiples of <b>k</b>:<br>
     * \(k \cdot \frac{n \cdot (n + 1)}{2}\)<br>
     * And recursively substraction of least common multiple
     * 
     * @param V List of values to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param FROM Lower bound (included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with all values in <b><i>V</i></b>
     * @param BELOW Upper bound (not included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with all values in <b><i>V</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum
     */
    private BigInteger solution3(ArrayList<BigInteger> V, BigInteger FROM, BigInteger BELOW) {
        ArrayList<BigInteger> nV = new ArrayList<>();
        BigInteger TWO = new BigInteger("2");
        BigInteger total = BigInteger.ZERO;
        for (BigInteger v : V) {
            BigInteger E1 = BELOW.subtract(BigInteger.ONE);
            BigInteger A1 = E1.divide(v);
            BigInteger R1 = A1.add(BigInteger.ONE).multiply(A1).multiply(v).divide(TWO);
            BigInteger E2 = FROM.subtract(BigInteger.ONE);
            BigInteger A2 = E2.divide(v);
            BigInteger R2 = A2.add(BigInteger.ONE).multiply(A2).multiply(v).divide(TWO);
            BigInteger R = R1.subtract(R2);
            ArrayList<BigInteger> repeated = new ArrayList<>(); 
            nV.forEach(p -> repeated.add(IFCMath.MCM(v, p)));
            total = total.add(R).subtract(solution3(repeated, FROM, BELOW));
            nV.add(v);
        }
        return total;
    }

    /** 
     * Find the sum of all the multiples of 3 or 5 below 1000
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    public long solve() {
        return solve(new ArrayList<>(Arrays.asList(3L, 5L)), 1, 1000, SOLUTION3);
    }

    /** 
     * Find the sum of all the multiples of 3 or 5 below 1000
     * @param solution Algorithm we want to use to calculate the desired value
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum calculated using provided algorithm
     */
    public long solve(int solution) {
        return solve(new ArrayList<>(Arrays.asList(3L, 5L)), 1, 1000, solution);
    }
    
    /** 
     * Finds the sum of all the multiples of <b><i>A</i></b> or <b><i>B</i></b> from 1 and below <b><i>BELOW</i></b>
     * @param A First value to check with all numbers in range <b>[1, <i>BELOW</i>)</b>
     * @param B Second value to check with all numbers in range <b>[1, <i>BELOW</i>)</b>
     * @param BELOW Upper bound (not included). It defines range <b>[1, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    public long solve(long A, long B, long BELOW) {
        return solve(new ArrayList<>(Arrays.asList(A, B)), 1, BELOW, SOLUTION3);
    }

    /** 
     * Finds the sum of all the multiples of <b><i>A</i></b> or <b><i>B</i></b> from 1 and below <b><i>BELOW</i></b> with
     * provided algorithm through <b><i>solution</i></b>
     * @param A First value to check with all numbers in range <b>[1, <i>BELOW</i>)</b>
     * @param B Second value to check with all numbers in range <b>[1, <i>BELOW</i>)</b>
     * @param BELOW Upper bound (not included). It defines range <b>[1, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @param solution Algorithm we want to use to calculate the desired value
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum calculated using provided algorithm
     */
    public long solve(long A, long B, long BELOW, int solution) {
        return solve(new ArrayList<>(Arrays.asList(A, B)), 1, BELOW, solution);
    }
    
    /** 
     * Finds the sum of all the multiples of <b><i>A</i></b> or <b><i>B</i></b> from <b><i>FROM</i></b> and below <b><i>BELOW</i></b>
     * @param A First value to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param B Second value to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param FROM Lower bound (included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @param BELOW Upper bound (not included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    public long solve(long A, long B, long FROM, long BELOW) {
        return solve(new ArrayList<>(Arrays.asList(A, B)), FROM, BELOW, SOLUTION3);
    }

    /** 
     * Finds the sum of all the multiples of <b><i>A</i></b> or <b><i>B</i></b> from <b><i>FROM</i></b> and below <b><i>BELOW</i></b>
     * using provided algorithm through <b><i>solution</i></b>
     * @param A First value to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param B Second value to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param FROM Lower bound (included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @param BELOW Upper bound (not included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @param solution Algorithm we want to use to calculate the desired value
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum calculated using provided algorithm
     */
    public long solve(long A, long B, long FROM, long BELOW, int solution) {
        return solve(new ArrayList<>(Arrays.asList(A, B)), FROM, BELOW, solution);
    }

    /** 
     * Finds the sum of all the multiples of <b><i>A</i></b> or <b><i>B</i></b> from 1 and below <b><i>BELOW</i></b>
     * @param A First value to check with all numbers in range <b>[1, <i>BELOW</i>)</b>
     * @param B Second value to check with all numbers in range <b>[1, <i>BELOW</i>)</b>
     * @param BELOW Upper bound (not included). It defines range <b>[1, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum
     */
    public BigInteger solve(BigInteger A, BigInteger B, BigInteger BELOW) {
        return solve(new ArrayList<>(Arrays.asList(A, B)), BigInteger.ONE, BELOW, SOLUTION3);
    }

    /** 
     * Finds the sum of all the multiples of <b><i>A</i></b> or <b><i>B</i></b> from 1 and below <b><i>BELOW</i></b> using
     * provided algorithm through <b><i>solution</i></b>
     * @param A First value to check with all numbers in range <b>[1, <i>BELOW</i>)</b>
     * @param B Second value to check with all numbers in range <b>[1, <i>BELOW</i>)</b>
     * @param BELOW Upper bound (not included). It defines range <b>[1, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @param solution Algorithm we want to use to calculate the desired value
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum calculated using provided algorithm
     */
    public BigInteger solve(BigInteger A, BigInteger B, BigInteger BELOW, int solution) {
        return solve(new ArrayList<>(Arrays.asList(A, B)), BigInteger.ONE, BELOW, solution);
    }
    
    /** 
     * Finds the sum of all the multiples of <b><i>A</i></b> or <b><i>B</i></b> from <b><i>FROM</i></b> and below <b><i>BELOW</i></b>
     * @param A First value to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param B Second value to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param FROM Lower bound (included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @param BELOW Upper bound (not included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum
     */
    public BigInteger solve(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW) {
        return solve(new ArrayList<>(Arrays.asList(A, B)), FROM, BELOW, SOLUTION3);
    }

    /** 
     * Finds the sum of all the multiples of <b><i>A</i></b> or <b><i>B</i></b> from <b><i>FROM</i></b> and below <b><i>BELOW</i></b>
     * using provided algorithm through <b><i>solution</i></b>
     * @param A First value to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param B Second value to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param FROM Lower bound (included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @param BELOW Upper bound (not included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with <b><i>A</i></b> and <b><i>B</i></b>
     * @param solution Algorithm we want to use to calculate the desired value
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum calculated using provided algorithm
     */
    public BigInteger solve(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW, int solution) {
        return solve(new ArrayList<>(Arrays.asList(A, B)), FROM, BELOW, solution);
    }
    
    /** 
     * Finds the sum of all the multiples of any number in <b><i>V</i></b> (V[0], V[1], ..., V[n-1] or V[n]) from <b><i>FROM</i></b> and below <b><i>BELOW</i></b>.
     * @param V List of values to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param FROM Lower bound (included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with all values in <b><i>V</i></b>
     * @param BELOW Upper bound (not included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with all values in <b><i>V</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum
     */
    public long solve(ArrayList<Long> V, long FROM, long BELOW) {
        return solve(V, FROM, BELOW, SOLUTION3);
    }

    /** 
     * Finds the sum of all the multiples of any number in <b><i>V</i></b> (V[0], V[1], ..., V[n-1] or V[n]) from <b><i>FROM</i></b> and below <b><i>BELOW</i></b>.
     * @param V List of values to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param FROM Lower bound (included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with all values in <b><i>V</i></b>
     * @param BELOW Upper bound (not included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with all values in <b><i>V</i></b>
     * @param solution Algorithm we want to use to calculate the desired value
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with desired sum calculated using provided algorithm
     */
    public long solve(ArrayList<Long> V, long FROM, long BELOW, int solution) {
        switch (solution) {
            case SOLUTION1:
                return solution1(V, FROM, BELOW);
            case SOLUTION2:
                return solution2(V, FROM, BELOW);
            case SOLUTION3:
                return solution3(V, FROM, BELOW);
        }
        return solution3(V, FROM, BELOW);
    }
    
    /** 
     * Finds the sum of all the multiples of any number in <b><i>V</i></b> (V[0], V[1], ..., V[n-1] or V[n]) from <b><i>FROM</i></b> and below <b><i>BELOW</i></b>.
     * @param V List of values to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param FROM Lower bound (included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with all values in <b><i>V</i></b>
     * @param BELOW Upper bound (not included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with all values in <b><i>V</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum
     */
    public BigInteger solve(ArrayList<BigInteger> V, BigInteger FROM, BigInteger BELOW) {
        return solve(V, FROM, BELOW, SOLUTION3);
    }

    /** 
     * Finds the sum of all the multiples of any number in <b><i>V</i></b> (V[0], V[1], ..., V[n-1] or V[n]) from <b><i>FROM</i></b> and below <b><i>BELOW</i></b>.
     * @param V List of values to check with all numbers in range <b>[<i>FROM</i>, <i>BELOW</i>)</b>
     * @param FROM Lower bound (included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with all values in <b><i>V</i></b>
     * @param BELOW Upper bound (not included). It defines range <b>[<i>FROM</i>, <i>BELOW</i>)</b> to check with all values in <b><i>V</i></b>
     * @param solution Algorithm we want to use to calculate the desired value
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with desired sum calculated using provided algorithm
     */
    public BigInteger solve(ArrayList<BigInteger> V, BigInteger FROM, BigInteger BELOW, int solution) {
        switch (solution) {
            case SOLUTION1:
                return solution1(V, FROM, BELOW);
            case SOLUTION2:
                return solution2(V, FROM, BELOW);
            case SOLUTION3:
                return solution3(V, FROM, BELOW);
        }
        return solution3(V, FROM, BELOW);
    }
}

