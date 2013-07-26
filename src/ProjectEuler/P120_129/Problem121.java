/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P120_129;

import raytracer.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem121 {
    
    private static long probabilidades = 0;

    private static void sumaProbabilidades(String base) {
        long i = 1L;
        long mul = 1L;
        for (char c : base.toCharArray()) {
            if (c == 'N') {
                mul = mul * i;
            }
            i++;
        }
        probabilidades += mul;
    }
    
    // Cuenta las apariciones del carácter 'c' en la cadena 's'
    private static int count(String s, char c) {
        if (s == null) {
            return 0;
        }
        int ocur = 0;
        for (char cc : s.toCharArray()) {
            ocur += (cc == c ? 1 : 0);
        }
        return ocur;
    }

    private static void binomial(long m, long n, String base) {
        long a = m - n;
        if (count(base, 'N') >= n) {
            while (base.length() < m)
                base += 'A';
            sumaProbabilidades(base);
            System.out.println(base + "(" + probabilidades + ")");
        }
        else if (count(base, 'A') >= a) {
            while (base.length() < m)
                base += 'N';
            sumaProbabilidades(base);
            System.out.println(base + "(" + probabilidades + ")");
        }
        else {
            String baseA = base + 'A';
            String baseN = base + 'N';
            binomial(m, n, baseA);
            binomial(m, n, baseN);
        }
    }
    
    // Juego de la bolsa con bolas rojas y azules
    static public void ejercicio121() {
        long m = 15;
        for (long n = 0; n < ((m % 2 == 0) ? (m / 2) : (m / 2 + 1)); n++) {
            binomial(m, n, "");
        }
        long f = IFCMath.factorial(m + 1L);
        double premio = (double)probabilidades / (double)f;
        System.out.println(probabilidades + " Sobre " + f + " = " + premio + " (" + (1.0 / premio) + ")");
    }
    
}
