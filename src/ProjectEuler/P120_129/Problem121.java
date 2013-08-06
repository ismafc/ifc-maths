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
    /*    
    Disc game prize fund

    A bag contains one red disc and one blue disc. In a game of chance a player takes a disc at random and its colour is noted. After each turn the disc is returned to the bag, an extra red disc is added, and another disc is taken at random.

    The player pays £1 to play and wins if they have taken more blue discs than red discs at the end of the game.

    If the game is played for four turns, the probability of a player winning is exactly 11/120, and so the maximum prize fund the banker should allocate for winning in this game would be £10 before they would expect to incur a loss. Note that any payout will be a whole number of pounds and also includes the original £1 paid to play the game, so in the example given the player actually wins £9.

    Find the maximum prize fund that should be allocated to a single game in which fifteen turns are played.
    */
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
