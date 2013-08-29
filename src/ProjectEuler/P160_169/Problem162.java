/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P160_169;

import java.util.HashMap;

/**
 *
 * @author Isma
 */
public class Problem162 {
    private static class State {

        final static public int ST_NONE = 0;
        final static public int ST_ZERO = 1;
        final static public int ST_ONE = 2;
        final static public int ST_A = 3;
        final static public int ST_ZEROONE = 4;
        final static public int ST_ZEROA = 5;
        final static public int ST_ONEA = 6;
        final static public int ST_ALL = 7;
        
        public int st = ST_NONE;
        public long peso = 1L;

        public State(int s, long p) {
            st = s;
            peso = p;
        }

    }

/*
   Hexadecimal numbers
   Problem 162

   In the hexadecimal number system numbers are represented using 16 different digits:
   0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F

   The hexadecimal number AF when written in the decimal number system equals 10x16+15=175.

   In the 3-digit hexadecimal numbers 10A, 1A0, A10, and A01 the digits 0,1 and A are all present.
   Like numbers written in base ten we write hexadecimal numbers without leading zeroes.

   How many hexadecimal numbers containing at most sixteen hexadecimal digits exist with all of the digits 0,1, and A present at least once?
   Give your answer as a hexadecimal number.

   (A,B,C,D,E and F in upper case, without any leading or trailing code that marks the number as hexadecimal and without leading zeroes , e.g. 1A3F and not: 1a3f and not 0x1a3f and not $1A3F and not #1A3F and not 0000001A3F)
*/    
    public static void problem162(long DIGITS) {
        long count = 0;
        HashMap<Integer, State> states = new HashMap<>();
        states.put(State.ST_ONE, new State(State.ST_ONE, 1));
        states.put(State.ST_A, new State(State.ST_A, 1));
        states.put(State.ST_NONE, new State(State.ST_NONE, 13));
        for (int digit = 2; digit <= DIGITS; digit++) {
            HashMap<Integer, State> nstates = new HashMap<>();
            for (State e : states.values()) {
                for (int l = 0; l <= 15; l++) {
                    State ne = new State(e.st, e.peso);
                    switch (l) {
                        case 0:
                            switch (e.st) {
                                case State.ST_ZERO:
                                case State.ST_ZEROA:
                                case State.ST_ZEROONE:
                                case State.ST_ALL:                                    
                                    break;
                                case State.ST_ONE:
                                    ne.st = State.ST_ZEROONE;
                                    break;
                                case State.ST_ONEA:
                                    ne.st = State.ST_ALL;
                                    break;
                                case State.ST_A:
                                    ne.st = State.ST_ZEROA;
                                    break;
                                case State.ST_NONE:
                                    ne.st = State.ST_ZERO;
                                    break;
                            }
                            break;
                        case 1:
                            switch (e.st) {
                                case State.ST_ONE:
                                case State.ST_ONEA:
                                case State.ST_ZEROONE:
                                case State.ST_ALL:
                                    break;
                                case State.ST_ZERO:
                                    ne.st = State.ST_ZEROONE;
                                    break;
                                case State.ST_ZEROA:
                                    ne.st = State.ST_ALL;
                                    break;
                                case State.ST_A:
                                    ne.st = State.ST_ONEA;
                                    break;
                                case State.ST_NONE:
                                    ne.st = State.ST_ONE;
                                    break;
                            }
                            break;
                        case 0xA:
                            switch (e.st) {
                                case State.ST_A:
                                case State.ST_ONEA:
                                case State.ST_ZEROA:
                                case State.ST_ALL:
                                    break;
                                case State.ST_ZERO:
                                    ne.st = State.ST_ZEROA;
                                    break;
                                case State.ST_ONE:
                                    ne.st = State.ST_ONEA;
                                    break;
                                case State.ST_ZEROONE:
                                    ne.st = State.ST_ALL;
                                    break;
                                case State.ST_NONE:
                                    ne.st = State.ST_A;
                                    break;
                            }
                            break;
                        default:
                            break;
                    }
                    if (nstates.containsKey(ne.st))
                        ne.peso += nstates.get(ne.st).peso;
                    nstates.put(ne.st, ne);
                }
            }
            states = nstates;
            if (states.containsKey(State.ST_ALL)) {
                long c = states.get(State.ST_ALL).peso;
                count += c;
                System.out.println("Combinations for " + digit + " digits = " + c);
            }
        }
        System.out.println("Total = " + count);
    }    
}
