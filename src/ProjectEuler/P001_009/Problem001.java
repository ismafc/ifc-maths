/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P001_009;

import java.math.BigInteger;
import java.util.ArrayList;
import raytracer.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem001 {

    /*
    Multiples of 3 and 5

    If we list all the natural numbers below 10 that are multiples of 3 or 5, 
    we get 3, 5, 6 and 9. The sum of these multiples is 23.
    Find the sum of all the multiples of 3 or 5 below 1000.
    */
           
    public static long solution1(long A, long B, long M, long N) {
        long sum = 0;
        for (long i = M; i < N; i++) {
            if (i % A == 0 || i % B == 0)
                sum += i;
        }
        return sum;
    }

    public static BigInteger solution1(BigInteger A, BigInteger B, BigInteger M, BigInteger N) {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger i = M; i.compareTo(N) == -1; i = i.add(BigInteger.ONE)) {
            if (i.mod(A).equals(BigInteger.ZERO) || i.mod(B).equals(BigInteger.ZERO))
                sum = sum.add(i);
        }
        return sum;
    }

    public static BigInteger solution1(ArrayList<BigInteger> V, BigInteger FROM, BigInteger BELOW) {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger i = FROM; i.compareTo(BELOW) == -1; i = i.add(BigInteger.ONE)) {
            if (IFCMath.mod(i, V))
                sum = sum.add(i);
        }
        return sum;
    }
    
    public static long solution1(ArrayList<Long> V, long M, long N) {
        long sum = 0;
        for (long i = M; i < N; i++) {
            if (IFCMath.mod(i, V))
                sum += i;
        }
        return sum;
    }
    
    public static long solution2(ArrayList<Long> V, long M, long N) {
        long sum = 0;
        ArrayList<Long> nV = new ArrayList<>();
        for (long v : V) {
            long M1 = (M % v == 0) ? M : M + v - M % v;
            for (long i = M1; i < N; i += v) {
                if (!IFCMath.mod(i, nV)) {
                    sum += i;
                }
            }
            nV.add(v);
        }
        return sum;
    }

    public static BigInteger solution2(ArrayList<BigInteger> V, BigInteger M, BigInteger N) {
        BigInteger sum = BigInteger.ZERO;
        ArrayList<BigInteger> nV = new ArrayList<>();
        for (BigInteger v : V) {
            BigInteger M1 = (M.mod(v).equals(BigInteger.ZERO)) ? M : M.add(v).subtract(M.mod(v));
            for (BigInteger i = M1; i.compareTo(N) == -1; i = i.add(v)) {
                if (!IFCMath.mod(i, nV))
                    sum = sum.add(i);
            }
            nV.add(v);
        }
        return sum;
    }
    
    public static long solution2(long A, long B, long M, long N) {
        long sum = 0;
        long M1 = (M % A == 0) ? M : M + A - M % A;
        for (long i = M1; i < N; i += A) {
            sum += i;
        }
        M1 = (M % B == 0) ? M : M + B - M % B;
        for (long i = M1; i < N; i += B) {
            if (i % A != 0)
                sum += i;
        }
        return sum;
    }

    public static BigInteger solution2(BigInteger A, BigInteger B, BigInteger M, BigInteger N) {
        BigInteger sum = BigInteger.ZERO;
        BigInteger M1 = (M.mod(A).equals(BigInteger.ZERO)) ? M : M.add(A).subtract(M.mod(A));
        for (BigInteger i = M1; i.compareTo(N) == -1; i = i.add(A)) {
            sum = sum.add(i);
        }
        M1 = (M.mod(B).equals(BigInteger.ZERO)) ? M : M.add(B).subtract(M.mod(B));
        for (BigInteger i = M1; i.compareTo(N) == -1; i = i.add(B)) {
            if (i.mod(A).compareTo(BigInteger.ZERO) != 0)
                sum = sum.add(i);
        }
        return sum;
    }
    
    public static BigInteger solution3(BigInteger A, BigInteger B, BigInteger N) {
        BigInteger TWO = new BigInteger("2");
        BigInteger E = N.subtract(BigInteger.ONE);
        BigInteger AB = IFCMath.MCM(A , B);
        BigInteger A1 = E.divide(A);
        BigInteger B1 = E.divide(B);
        BigInteger AB1 = E.divide(AB);
        BigInteger AF = A1.add(BigInteger.ONE).multiply(A1).multiply(A).divide(TWO);
        BigInteger BF = B1.add(BigInteger.ONE).multiply(B1).multiply(B).divide(TWO);
        BigInteger ABF = AB1.add(BigInteger.ONE).multiply(AB1).multiply(AB).divide(TWO);
        return AF.add(BF).subtract(ABF);
    }

    public static BigInteger solution3(BigInteger A, BigInteger B, BigInteger M, BigInteger N) {
        return solution3(A, B, N).subtract(solution3(A, B, M));
    }
    
    public static long solution3(long A, long B, long N) {
        long E = N - 1;
        long AB = IFCMath.MCM(A , B);
        long A1 = E / A;
        long B1 = E / B;
        long AB1 = E / AB;
        return A * (A1 * (A1 + 1)) / 2 + 
               B * (B1 * (B1 + 1)) / 2 - 
               AB * (AB1 * (AB1 + 1)) / 2;
    }
    
    public static long solution3(long A, long B, long M, long N) {
        return solution3(A, B, N) - solution3(A, B, M);
    }

    public static long solution3(ArrayList<Long> V, long M, long N) {
        ArrayList<Long> nV = new ArrayList<>();
        long total = 0;
        for (long v : V) {
            long E1 = N - 1;
            long A1 = E1 / v;
            long R1 = v * (A1 * (A1 + 1)) / 2;
            long E2 = M - 1;
            long A2 = E2 / v;
            long R2 = v * (A2 * (A2 + 1)) / 2;
            long R = R1 - R2;
            ArrayList<Long> repeated = new ArrayList<>(); 
            nV.forEach(p -> repeated.add(IFCMath.MCM(v, p)));
            total = total + R - solution3(repeated, M, N);
            nV.add(v);
        }
        return total;
    }

    public static BigInteger solution3(ArrayList<BigInteger> V, BigInteger M, BigInteger N) {
        ArrayList<BigInteger> nV = new ArrayList<>();
        BigInteger TWO = new BigInteger("2");
        BigInteger total = BigInteger.ZERO;
        for (BigInteger v : V) {
            BigInteger E1 = N.subtract(BigInteger.ONE);
            BigInteger A1 = E1.divide(v);
            BigInteger R1 = A1.add(BigInteger.ONE).multiply(A1).multiply(v).divide(TWO);
            BigInteger E2 = M.subtract(BigInteger.ONE);
            BigInteger A2 = E2.divide(v);
            BigInteger R2 = A2.add(BigInteger.ONE).multiply(A2).multiply(v).divide(TWO);
            BigInteger R = R1.subtract(R2);
            ArrayList<BigInteger> repeated = new ArrayList<>(); 
            nV.forEach(p -> repeated.add(IFCMath.MCM(v, p)));
            total = total.add(R).subtract(solution3(repeated, M, N));
            nV.add(v);
        }
        return total;
    }
    
    public static BigInteger problem001(BigInteger A, BigInteger B, BigInteger M, BigInteger N) {
        BigInteger s1 = solution1(A, B, M, N);
        System.out.println("Result 1 = " + s1);
        BigInteger s2 = solution2(A, B, M, N);
        System.out.println("Result 2 = " + s2);
        BigInteger s3 = solution3(A, B, M, N);
        System.out.println("Result 3 = " + s3);
        return s3;
    }

    public static BigInteger problem001(ArrayList<BigInteger> V, BigInteger FROM, BigInteger BELOW) {
/*        for (int i = 0; i < 22; i++) {
            long t = System.currentTimeMillis();
            solution1(V, FROM, BELOW);
            System.out.print((System.currentTimeMillis() - t) + ", ");            
        }
        System.out.println("");
        for (int i = 0; i < 22; i++) {
            long t = System.currentTimeMillis();
            solution2(V, FROM, BELOW);
            System.out.print((System.currentTimeMillis() - t) + ", ");
        }
        System.out.println("");
        for (int i = 0; i < 22; i++) {
            long t = System.currentTimeMillis();
            solution3(V, FROM, BELOW);
            System.out.print((System.currentTimeMillis() - t) + ", ");
        }
        System.out.println("");*/
        BigInteger s1 = solution1(V, FROM, BELOW);
        System.out.println("Result 1 = " + s1);
        BigInteger s2 = solution2(V, FROM, BELOW);
        System.out.println("Result 2 = " + s2);
        BigInteger s3 = solution3(V, FROM, BELOW);
        System.out.println("Result 3 = " + s3);
        return s3;
    }
    
    public static long problem001(ArrayList<Long> V, long FROM, long BELOW) {
        long s1 = solution1(V, FROM, BELOW);
        System.out.println("Result 1 = " + s1);
        long s2 = solution2(V, FROM, BELOW);
        System.out.println("Result 2 = " + s2);
        long s3 = solution3(V, FROM, BELOW);
        System.out.println("Result 3 = " + s3);
        return s3;
    }
    
    public static long problem001(long A, long B, long M, long N) {
        long s1 = solution1(A, B, M, N);
        System.out.println("Result 1 = " + s1);
        long s2 = solution2(A, B, M, N);
        System.out.println("Result 2 = " + s2);
        long s3 = solution3(A, B, M, N);
        System.out.println("Result 3 = " + s3);
        return s3;
    }
    
}

