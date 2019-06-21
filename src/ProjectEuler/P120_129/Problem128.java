/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P120_129;

import java.util.ArrayList;
import java.util.HashMap;
import Library.IFCMath;
import raytracer.MatrixNxM;
import raytracer.Point3D;

/**
 *
 * @author ismael.flores
 */
public class Problem128 {
    
    private static long PD3(long center, MatrixNxM m, HashMap<Long, Boolean> prs) {
        long primes = 0;
        for (int v = 0; v < m.getColumns(); v++) {
            long vtocheck = Math.abs((long)m.get(0, v) - center);
            if (prs.containsKey(vtocheck))
                primes += ((prs.get(vtocheck) == true) ? 1 : 0);
            else {
                boolean chk = IFCMath.isPrime(vtocheck);
                prs.put(vtocheck, chk);
                primes += ((chk == true) ? 1 : 0);
            }
            if (primes > 3)
                return -1;
            if (m.getColumns() - v + primes < 3)
                return -1;
        }
        return primes;
    }
    /*
    Hexagonal tile differences

    A hexagonal tile with number 1 is surrounded by a ring of six hexagonal tiles, starting at "12 o'clock" and numbering the tiles 2 to 7 in an anti-clockwise direction.

    New rings are added in the same fashion, with the next rings being numbered 8 to 19, 20 to 37, 38 to 61, and so on. The diagram below shows the first three rings.

    By finding the difference between tile n and each its six neighbours we shall define PD(n) to be the number of those differences which are prime.

    For example, working clockwise around tile 8 the differences are 12, 29, 11, 6, 1, and 13. So PD(8) = 3.

    In the same way, the differences around tile 17 are 1, 17, 16, 1, 11, and 10, hence PD(17) = 2.

    It can be shown that the maximum value of PD(n) is 3.

    If all of the tiles for which PD(n) = 3 are listed in ascending order to form a sequence, the 10th tile would be 271.

    Find the 2000th tile in this sequence.
    */
    static public void ejercicio128() {
        // Hexagonal tile differences
        // Cada número tiene 6 adyacentes "MatrixNxM(1,6)"
                
        // Se guardan valores cuya función PD es 3 (número de primos de las diferencias)
        ArrayList<Long> treses = new ArrayList<>();
        
        // La capa 0 tiene 1 valor, empieza en 1 y acaba en 1
        // El primer valor (1) tiene como adyacentes a 2,3,4,5,6 y 7
        Point3D capa_previous = new Point3D(1, 1, 1);
        int ncapa = 1;
        
        // Se guardan los valores adyacentes de cada valor (el indice en el vector + 1 es el valor)
        MatrixNxM adyacente = new MatrixNxM(new double[][]{{2, 3, 4, 5, 6, 7}});
        long nadyacentes = 1;

        HashMap<Long, Boolean> prs = new HashMap<>();
        long pd = PD3(nadyacentes, adyacente, prs);
        if (pd == 3)
            treses.add(nadyacentes);
        
        while (treses.size() < 2002) {
            long primero = (long)capa_previous.getZ() + 1;
            long ultimo = primero + ncapa * 6 - 1;
            long step = 0;
            long primeroPrevious = (long)capa_previous.getY();
            long ultimoPrevious = (long)capa_previous.getZ();
            long primeroNext = ultimo + 1;
            long ultimoNext = primeroNext + (ncapa + 1) * 6 - 1;
            long previous = primeroPrevious;
            long next = primeroNext;
            capa_previous = new Point3D(ncapa * 6, primero, ultimo);
/*            int capa = valores_capa.size();
            int primero = (int)valores_capa.get(capa - 1).z + 1;
            int ultimo = primero + capa * 6 - 1;
            valores_capa.add(new Point3D(capa * 6, primero, ultimo));
            int step = 0;
            int primeroPrevious = (int)valores_capa.get(capa - 1).y;
            int ultimoPrevious = (int)valores_capa.get(capa - 1).z;
            int primeroNext = ultimo + 1;
            int ultimoNext = primeroNext + (capa + 1) * 6 - 1;
            int previous = primeroPrevious;
            int next = primeroNext;*/
            for (long valor = primero; valor <= ultimo; valor++) {
                if (step == 0) {
                    // Tiene tres "hijos" (sólo un padre)
                    adyacente = new MatrixNxM(new double[][]{{previous, 
                                                                 (valor == primero) ? ultimo : valor - 1, 
                                                                 (valor == ultimo) ? primero : valor + 1, 
                                                                 (next == primeroNext) ? ultimoNext : next - 1, 
                                                                 next, 
                                                                 next + 1}});
                    next += 2;
                }
                else {
                    // Tiene dos "hijos" (dos padres)
                    adyacente = new MatrixNxM(new double[][]{{previous, 
                                                                 (previous == ultimoPrevious) ? primeroPrevious : previous + 1,
                                                                 (valor == primero) ? ultimo : valor - 1, 
                                                                 (valor == ultimo) ? primero : valor + 1, 
                                                                 (next == primeroNext) ? ultimoNext : next - 1, 
                                                                 next}});
                    next++;
                    previous++;
                }
                nadyacentes++;
                step = (step + 1) % ncapa;
                
                pd = PD3(nadyacentes, adyacente, prs);
                if (pd == 3) {
                    treses.add(nadyacentes);
                    System.out.println(treses.size() + ".- " + treses.get(treses.size() - 1));
                }
            }
            ncapa++;
        }
    }

}
