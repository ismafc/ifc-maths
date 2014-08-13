/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P150_159;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author ismael.flores
 */
public class Problem151 {
    private static class State {

        private long job = 0;
        private long sheets = 0; // [#A2][#A3][#A4][#A5]
        private long[] times = new long [16]; // {1, 4, 2, ...} = 1 time found 1, 4 times found 2, 2 times found 3, ...

        public State(long j, long s, long[] t) {
            job = j;
            sheets = s;
            times = t;
        }
        
        public long[] getTimes() {
            return times;
        }
        
        public void addTimes(long[] t) {
            for (int i = 0; i < times.length; i++) {
                times[i] += t[i];
            }
        }
        
        public long numbersA(long a) {
            return (sheets / (long)Math.pow(10, 5 - a)) % 10;
        }

        public double probabilityOf(long n) {
            double sum = 0.0;
            for (long t : times) {
                sum += (double)t;
            }
            return (double)times[(int)n] / sum;
        }
        
        public long numberOfSheets() {
            long nos = 0;
            for (long a = 2; a <= 5; a++) {
                nos += numbersA(a);
            }
            return nos;
        }
        
        public long jumpSheets(long a) {
            long nsheets = sheets;
            nsheets -= (long)Math.pow(10, 5 - a);
            a++;
            while (a <= 5) {
                nsheets += (long)Math.pow(10, 5 - a);
                a++;
            }
            return nsheets;
        }
        
        public long[] jump() {
            long[] ntimes = times.clone();
            ntimes[(int)numberOfSheets()]++;
            return ntimes;
        }
        
/*        public long[] jumpTimes(long a) {
            long[] ntimes = times.clone();
            long na = numbersA(a);
            ntimes[(int)numberOfSheets()] += na;
//            if (na > 1) {
//                for (int i = 0; i < times.length; i++) {
//                    if (i != numberOfSheets() && ntimes[i] > 0)
//                        ntimes[i] += na;
//                }
//            }
            return ntimes;
        }*/
    }
    
    public static void problem151() {
        long jobs = 1;
        HashMap<Long, State> states = new HashMap<>();
        // First state is 1 A2, 1 A3, 1 A4 and 1 A5 in job 0
        
        // 1111 (0222, 1022, 1102, 1110) {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0}

        // 0222 (0133, 0133, 0213, 0213, 0221, 0221) {0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0}
        // 1022 (0133, 1013, 1013, 1021, 1021) {0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0}
        // 1102 (0213, 1013, 1101, 1101) {0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0}
        // 1110 (0221, 1221, 1121) {0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0}

        // 1102 -> 0213 (0124, 0124, 0204, 0212, 0212, 0212) {0,0,0,2,0,1,0,0,0,0,0,0,0,0,0,0}
        // 1102 -> 1013 (0124, 1004, 1012, 1012, 1012) {0,0,0,2,1,0,0,0,0,0,0,0,0,0,0,0}
        // 1102 -> 1101 (0212, 1012, 1100) {0,0,1,2,0,0,0,0,0,0,0,0,0,0,0,0}
        // 1102 -> 1101 (0212, 1012, 1100) {0,0,1,2,0,0,0,0,0,0,0,0,0,0,0,0}
        
        // 0222 -> 0133 (0044, 0124, 0124, 0124, 0132, 0132, 0132) {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0}
        // 0222 -> 0133 (0044, 0124, 0124, 0124, 0132, 0132, 0132) {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0}
        // 0222 -> 0213 (0124, 0124, 0204, 0212, 0212, 0212) {0,0,0,1,0,2,0,0,0,0,0,0,0,0,0,0}
        // 0222 -> 0213 (0124, 0124, 0204, 0212, 0212, 0212) {0,0,0,1,0,2,0,0,0,0,0,0,0,0,0,0}
        // 0222 -> 0221 {0132, 0132, 0212, 0212, 0220) {0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0}
        // 0222 -> 0221 {0132, 0132, 0212, 0212, 0220) {0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0}
       
        states.put(1111L, new State(0, 1111L, new long[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
        double sum = 0.0;
        while (jobs < 15) {
            HashMap<Long, State> nstates = new HashMap<>();
            for (State st : states.values()) {
                for (long a = 2; a <= 5; a++) {
                    long an = st.numbersA(a);
                    if (an > 0) {
                        // Cogemos un A(a)
                        long nsheet = st.jumpSheets(a);
                        if (nstates.containsKey(nsheet)) {
                            // Merge!!!
                            for (int ia = 0; ia < an - 1; ia++) {
                                nstates.get(nsheet).addTimes(nstates.get(nsheet).getTimes());
                            }
                            nstates.get(nsheet).getTimes()[(int)st.numberOfSheets()] += an;
                        }
                        else {
                            State nst = new State(jobs, nsheet, st.getTimes().clone());
                            nst.getTimes()[(int)st.numberOfSheets()] += an;
                            nstates.put(nsheet, nst);
                        }
                    }
                }
            }
            // 
            // Quizás para cada job habría que calcular el número esperado de veces
            // que esperamos encontrar 1 hoja
            //
            State nst = new State(jobs, 0, new long[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            for (State st : nstates.values()) {
                nst.addTimes(st.getTimes());
            }
            sum += nst.probabilityOf(1);
            states = nstates;
            jobs++;
        }
/*        double sum = 0.0;
        for (long i = 1; i < 9; i++) {
            sum += states.get(1L).probabilityOf(i) * 14.0;
            System.out.println(states.get(1L).probabilityOf(i) * 14.0);
        }*/
        System.out.println(sum);
    }
}
