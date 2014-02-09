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
        
        public long[] jumpTimes(long a) {
            long[] ntimes = times.clone();
            long na = numbersA(a);
            ntimes[(int)numberOfSheets()] += na;
/*            if (na > 1) {
                for (int i = 0; i < times.length; i++) {
                    if (i != numberOfSheets() && ntimes[i] > 0)
                        ntimes[i] += na;
                }
            }*/
            return ntimes;
        }
    }
    
    public static void problem151() {
        long jobs = 1;
        HashMap<Long, State> states = new HashMap<>();
        // First state is 1 A2, 1 A3, 1 A4 and 1 A5 in job 0
        states.put(1111L, new State(0, 1111L, new long[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
        while (jobs < 15) {
            HashMap<Long, State> nstates = new HashMap<>();
            for (State st : states.values()) {
                for (long a = 2; a <= 5; a++) {
                    long an = st.numbersA(a);
                    if (an > 0) {
                        // Cogemos un A(a)
                        long nsheet = st.jumpSheets(a);
                        State nst = new State(jobs, nsheet, st.jumpTimes(a));
                        if (nstates.containsKey(nsheet)) {
                            // Merge!!!
                            nstates.get(nsheet).addTimes(nst.getTimes());
                        }
                        else
                            nstates.put(nsheet, nst);
                    }
                }
            }
            states = nstates;
            jobs++;
        }
        double sum = 0.0;
        for (long i = 1; i < 9; i++) {
            sum += states.get(1L).probabilityOf(i) * 14.0;
            System.out.println(states.get(1L).probabilityOf(i) * 14.0);
        }
        System.out.println(sum);
    }
}
