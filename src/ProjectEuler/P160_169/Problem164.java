/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P160_169;

import java.util.HashMap;

/**
 *
 * @author ismael.flores
 */
public class Problem164 {
    private static class State {

        public long st = 0;
        public long peso = 1L;

        public State(long s, long p) {
            st = s;
            peso = p;
        }

    }
    
    static private HashMap<Long, State> expand(State e) {
        HashMap<Long, State> l = new HashMap<>();
        long i = (e.st * 10) % 1000;
        long v = i / 100 + (i / 10) % 10 + i % 10;
        for (long k = 0; k <= 9 - v; k++) {
            l.put(k + i, new State(k + i, e.peso));
        }
        return l;
    }

    /*    
    Numbers for which no three consecutive digits have a sum greater than a given value.
    How many 20 digit numbers n (without any leading zero) exist such that no three consecutive digits of n have a sum greater than 9?
    */
    public static void problem164(long DIGITS) {
        // Recorrido en anchura del árbol de casos posibles
        // Cada nivel es un dígito más
        
        // 1.- 001, 002, 003, 004, 005, 006, 007, 008, 009
        
        // 2.- 001 -> 010, 011, 012, 013, 014, 015, 016, 017, 018
        // 2.- 002 -> 020, 021, 022, 023, 024, 025, 026, 027
        // 2.- 003 -> 030, 031, 032, 033, 034, 035, 036
        // 2.- 004 -> 040, 041, 042, 043, 044, 045
        // 2.- 005 -> 050, 051, 052, 053, 054
        // 2.- 006 -> 060, 061, 062, 063
        // 2.- 007 -> 070, 071, 072
        // 2.- 008 -> 080, 081
        // 2.- 009 -> 090

        // 3.- 010 -> 100, 101, 102, 103, 104, 105, 106, 107, 108
        // 3.- 011 -> 110, 111, 112, 113, 114, 115, 116, 117
        // ...
        // 3.- 017 -> 170, 171
        // 3.- 018 -> 180
        // 3.- 020 -> 200, 201, 202, 203, 204, 205, 206, 207
        // 3.- 021 -> 210, 211, 212, 213, 214, 215, 216
        // ...
        // 3.- 026 -> 260, 261
        // 3.- 027 -> 270
        // ...
        // 3.- 080 -> 800, 801
        // 3.- 081 -> 810
        // 3.- 090 -> 900
        
        HashMap<Long, State> states = new HashMap<>();
        for (long l = 1L; l <= 9L; l++)
            states.put(l, new State(l, 1));
        for (int digit = 2; digit <= DIGITS; digit++) {
            HashMap<Long, State> nstates = new HashMap<>();
            for (State e : states.values()) {
                HashMap<Long, State> exp = expand(e);
                for (Long i : exp.keySet()) {
                    if (nstates.containsKey(i)) {
                        nstates.put(i, new State(i, exp.get(i).peso + nstates.get(i).peso));
                    }
                    else {
                        nstates.put(i, exp.get(i));
                    }
                }
            }
            states = nstates;
        }
        long count = 0;
        for (State e : states.values()) {
            count += e.peso;
        }
        System.out.println("Combinantos for " + DIGITS + " digits = " + count);
    }    
}
