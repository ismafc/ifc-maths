/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P160_169;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import raytracer.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem169 {
    private static class State {
        
        public BigInteger v = null;
        //public ArrayList<BigDecimal> st = new ArrayList<>();
        public int r = 0;
        
        public State(BigInteger _v, int _r) {
            v = _v;
            r = _r;
        }
/*        
        public State(BigDecimal _v, ArrayList<BigDecimal> _st, int _r) {
            v = _v;
            st = _st;
            r = _r;            
        }
*/        
        @Override
        public String toString() {
            String ret = "{ ";
            ret += v.toString();
            ret += " | {";
/*            for (BigDecimal d : st) {
                ret += d.toString();
                ret += ",";
            }
            ret += "} | {";*/
            for (int nr = r; nr >= 0; nr--) {
                ret += nr;
                ret += ",";
            }
            ret += "} }";
            return ret;
        }
    }
    
    // Devuelve el máximo valor que podría conseguirse si:
    // max = 2*2^p + 2*2^(p-1) + 2*2^(p-2) + ... + 2*2^0
    public static BigInteger max(int p) {
        BigInteger result = BigInteger.ZERO;
        BigInteger two = new BigInteger("2");
        while (p >= 0) {
            result = result.add(two.pow(p).multiply(two));
            p--;
        }
        return result;
    }

    public static long max(long p) {
        long result = 0;
        while (p >= 0) {
            result += 2 * IFCMath.lpow(2, p);
            p--;
        }
        return result;
    }
    
    public static void expand(long v, long p, long[] nfst, long[] res) {
        res[0] = 0;
        long r = p;
        while (max(r) >= v && r >= 0) {
            long nv = v - 2 * IFCMath.lpow(2, r);
            if (nv > 0) {
                nfst[(int)res[1]] = nv;
                nfst[(int)res[1] + 1] = r - 1;
                res[1] += 2;
            }
            else if (nv == 0)
                res[0]++;
            nv = v - IFCMath.lpow(2, r);
            if (nv > 0) {
                nfst[(int)res[1]] = nv;
                nfst[(int)res[1] + 1] = r - 1;
                res[1] += 2;
            }
            else if (nv == 0)
                res[0]++;
            r--;
        }
    }
    
    public static long expand(State st, ArrayList<State> lst) {
        long found = 0;
        int compar = 0;
        BigInteger two = new BigInteger("2");
        int r = st.r;
        while (max(r).compareTo(st.v) >= 0 && r >= 0) {
            BigInteger nv = st.v.subtract(two.pow(r).multiply(two));
            compar = nv.compareTo(BigInteger.ZERO);
            if (compar > 0) {
                State nst = new State(nv, r - 1);
/*                nst.st = (ArrayList<BigDecimal>)st.st.clone();
                nst.st.add(two.pow(r));
                nst.st.add(two.pow(r));*/
                lst.add(nst);
                
            }
            else if (compar == 0)
                found++;
            nv = st.v.subtract(two.pow(r));
            compar = nv.compareTo(BigInteger.ZERO);
            if (compar > 0) {
                State nst = new State(nv, r - 1);
/*                nst.st = (ArrayList<BigDecimal>)st.st.clone();
                nst.st.add(two.pow(r));*/
                lst.add(nst);
            }
            else if (compar == 0)
                found++;
            r--;
        }
        return found;
    }
    
    /*    
    Exploring the number of different ways a number can be expressed as a sum of powers of 2

    Define f(0)=1 and f(n) to be the number of different ways n can be expressed 
    as a sum of integer powers of 2 using each power no more than twice.

    For example, f(10)=5 since there are five different ways to express 10:

    1 + 1 + 8
    1 + 1 + 4 + 4
    1 + 1 + 2 + 2 + 4
    2 + 4 + 4
    2 + 8

    What is f(10^25)?
    */
    public static void problem169(BigInteger target) {
        /*
        --- {10 | {} | {3,2,1,0)}
        
        3 (max = 30) -> Sí (30 >= 10)
        -6 | {8,8} | {2,1,0} -> No
        2 | {8} | {2,1,0}
        
        2 (max = 14) -> Sí (14 >= 10)
        2 | {4,4} | {1,0}
        6 | {4} | {1,0}
        
        1 (max = 6) -> No (Stop)
        
        {2 | {8} | {2,1,0}} - {2 | {4,4} | {1,0}} - {6 | {4} | {1,0}}
        --- {2 | {8} | {2,1,0}} - {2 | {4,4} | {1,0}} - {6 | {4} | {1,0}}
                
Old = 1; New = 3; sum = 0; ms = 16
Old = 3; New = 4; sum = 4; ms = 0
Old = 4; New = 1; sum = 5; ms = 16
Old = 1; New = 0; sum = 5; ms = 0
f(10) = 5
 - 
Old = 1; New = 3; sum = 0; ms = 0
Old = 3; New = 8; sum = 0; ms = 32
Old = 8; New = 21; sum = 0; ms = 15
Old = 21; New = 55; sum = 0; ms = 0
Old = 55; New = 108; sum = 0; ms = 16
Old = 108; New = 224; sum = 0; ms = 31
Old = 224; New = 523; sum = 0; ms = 31
Old = 523; New = 1179; sum = 0; ms = 63
Old = 1179; New = 2686; sum = 0; ms = 125
Old = 2686; New = 6352; sum = 0; ms = 265
Old = 6352; New = 14021; sum = 0; ms = 532
Old = 14021; New = 29883; sum = 0; ms = 1066
Old = 29883; New = 65262; sum = 0; ms = 1906
Old = 65262; New = 147427; sum = 0; ms = 4700
Old = 147427; New = 347383; sum = 0; ms = 10335
Old = 347383; New = 834286; sum = 0; ms = 22952
Old = 834286; New = 2030827; sum = 0; ms = 52429
Old = 2030827; New = 4991556; sum = 0; ms = 117182
Old = 4991556; New = 12109392; sum = 294912; ms = 265303
        
        */
        BigInteger maxLong = new BigInteger(Long.toString(Long.MAX_VALUE));
        long[] faststates = new long[0];
        long currentLongState = 0;
        
        ArrayList<State> states = new ArrayList<>();
        states.add(new State(target, IFCMath.log(2, target, 0).intValue()));
        long sum = 0;
        while (states.size() > 0) {
            long ms = System.currentTimeMillis();
            ArrayList<State> nstates = new ArrayList<>();
            for (State st : states) {
                sum += expand(st, nstates);
            }
            states = nstates;
            
            int i = 0;
            long[] newfaststates = new long [(states.size() + (int)currentLongState) * 2];
            for (long fs : faststates) {
                newfaststates[i] = fs;
                i++;
            }
            i = 0;
            while (i < states.size()) {
                if (states.get(i).v.compareTo(maxLong) < 0) {
                    newfaststates[(int)currentLongState * 2] = states.get(i).v.longValue();
                    newfaststates[(int)currentLongState * 2 + 1] = states.get(i).r;
                    states.remove(i);
                    currentLongState++;
                }
                else
                    i++;
            }
            faststates = newfaststates;
        }
        states = null;
        System.gc();
        while (faststates.length > 0) {
            long[] results = new long [2];
            long[] newfaststates = new long [faststates.length * 3];
            results[1] = 0;
            for (int i = 0; i < faststates.length; i += 2) {
                expand(faststates[i], faststates[i + 1], newfaststates, results);
                sum += results[0];
            }
            faststates = new long [(int)results[1]];
            int i = 0;
            while (i < results[1]) {
                faststates[i] = newfaststates[i];
                i++;
            }
        }
        System.out.println("f(" + target.toString() + ") = " + sum);
    }
}
