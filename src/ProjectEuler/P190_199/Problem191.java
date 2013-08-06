/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P190_199;

/**
 *
 * @author ismael.flores
 */
public class Problem191 {
    private static long pow(long base, long exponent) {
        long result = 1;
        while (exponent > 0) {
            result *= base;
            exponent--;
        }
        return result;
    }

    private static long goods(long N, long G) {
        long BAD = 0;
        if (N >= G) {
            // Suponemos que las G seguidas empiezan en 0, 1, ...
            for (long K = G; K <= N; K++) {
                // Todas las combinaciones después por las combinaciones buenas antes
                BAD += pow(2, N - K) * goods(K - G - 1, G);
            }
        }
        return pow(2, N) - BAD;
    }
    
    /*    
    Prize Strings

    A particular school offers cash rewards to children with good attendance and punctuality. 
    If they are absent for three consecutive days or late on more than one occasion then they forfeit their prize.

    During an n-day period a trinary string is formed for each child consisting of L's (late), O's (on time), and A's (absent).

    Although there are eighty-one trinary strings for a 4-day period that can be formed, exactly forty-three strings would lead to a prize:

    OOOO OOOA OOOL OOAO OOAA OOAL OOLO OOLA OAOO OAOA
    OAOL OAAO OAAL OALO OALA OLOO OLOA OLAO OLAA AOOO
    AOOA AOOL AOAO AOAA AOAL AOLO AOLA AAOO AAOA AAOL
    AALO AALA ALOO ALOA ALAO ALAA LOOO LOOA LOAO LOAA
    LAOO LAOA LAAO

    How many "prize" strings exist over a 30-day period?
    */
    public static void problem191(long N) {
        // Buenos en las combinaciones sin ningún dia tarde (L)
        long GOOD = goods(N, 3);
        
        // Ahora miramos las combincaciones con un dia tarde (L)
        for (long L = 0; L < N; L++) {
            // Buenos en las combinaciones sin ningún dia tarde (L) a la izquierda
            long G1 = goods(L, 3);
            // Buenos en las combinaciones sin ningún dia tarde (L) a la derecha
            long G2 = goods(N - L - 1, 3);
            GOOD += (G1 * G2);
        }
        
        System.out.println("Good = " + GOOD);
    }    
}
