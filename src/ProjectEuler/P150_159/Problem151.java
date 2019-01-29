/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P150_159;

import raytracer.Tree;
import java.util.*;
import raytracer.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem151 {
    
    private static long[] posibilities = {0, 0, 0, 0};
    
    private static class State implements Comparable<State> {

        private long sheets = 0; // [#A2][#A3][#A4][#A5]
        private int[] times = new int [16]; // {1, 4, 2, ...} = 1 time found 1, 4 times found 2, 2 times found 3, ...
        private int[] sheets_found = new int [14];

        public State(long s, int[] t, int[] sf) {
            sheets = s;
            times = t;
            sheets_found = sf;
        }
        
        public int[] getTimes() {
            return times;
        }

        public int[] getSheetsFound() {
            return sheets_found;
        }        
        
        public long getTotalTimes() {
            long sum = 0;
            for (int i = 0; i < times.length; i++) {
                sum += times[i];
            }
            return sum;
        }
        
        public long getSheets() {
            return sheets;
        }
        
        public void addTimes(long[] t) {
            for (int i = 0; i < times.length; i++) {
                times[i] += t[i];
            }
        }
        
        public long numbersA(long a) {
            return (sheets / (long)Math.pow(100, 5 - a)) % 100;
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
            nsheets -= (long)Math.pow(100, 5 - a);
            a++;
            while (a <= 5) {
                nsheets += (long)Math.pow(100, 5 - a);
                a++;
            }
            return nsheets;
        }
        
        public int[] jump() {
            int[] ntimes = times.clone();
            ntimes[(int)numberOfSheets()]++;
            return ntimes;
        }
            
        @Override
        public int compareTo(State st) {
            if (st.getSheets() == sheets)
                return 0;
            return -1;
        }
        
        @Override
        public String toString() {
            return sheets + " - " + Arrays.toString(times) + " - " + Arrays.toString(sheets_found);
        }
    }
    
    private static void deployBranch(Tree<State> states, State st) {
        states.setValue(st);
        if (st.getSheets() > 1) {
            // Desplegamos hijos
            // Miramos que pasa cuando sacamos las diferentes tipos de hojas (A2, A3, A4 o A5)
            for (long a = 2; a <= 5; a++) {
                // Pueden sacarse 'an' hojas de tipo A[a]
                long an = st.numbersA(a);
                while (an > 0) {
                    // Sacamos una hoja de tipo A[a] (de las 'an' que hay) y calculamos 
                    // el nuevo estado des pués de cortar y volver a poner en el sobre
                    Tree<State> nTree = new Tree<>();
                    states.addBranch(nTree);
                    long nsheet = st.jumpSheets(a);
                    State nState = new State(nsheet, st.getTimes().clone(), st.getSheetsFound().clone());
                    nState.getTimes()[(int)st.numberOfSheets()] += 1;
                    nState.getSheetsFound()[states.getLevel()] = (int)nsheet;
                    deployBranch(nTree, nState);
                    states.removeBranch(states.getBranchIndex(nTree));
                    an--;
                }
            }
        }
        else {
            if (st.getTimes()[1] == 3)
                System.out.println(st);
            posibilities[st.getTimes()[1]]++;
            //System.out.println("Posibilities: " + posibilities + " (" + st + ")");
        }
    }
    
    public static void problem151() {
        Tree<State> states = new Tree<>();
        // First state is 1 A2, 1 A3, 1 A4 and 1 A5 in job 0
        
        // Job 0 (1 state)
        // 1111 (0222, 1022, 1102, 1110) {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0}

        // Job 1 (4 states)
        // 1111 -> 0222 (0133, 0133, 0213, 0213, 0221, 0221) {0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0}
        // 1111 -> 1022 (0133, 1013, 1013, 1021, 1021) {0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0}
        // 1111 -> 1102 (0213, 1013, 1101, 1101) {0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0}
        // 1111 -> 1110 (0221, 1021, 1101) {0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0}

        // Job 2 (18 states)     
        // 1111 -> 0222 -> 0133 (0044, 0124, 0124, 0124, 0132, 0132, 0132) {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0}
        // 1111 -> 0222 -> 0133 (0044, 0124, 0124, 0124, 0132, 0132, 0132) {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0}
        // 1111 -> 0222 -> 0213 (0124, 0124, 0204, 0212, 0212, 0212) {0,0,0,1,0,2,0,0,0,0,0,0,0,0,0,0}
        // 1111 -> 0222 -> 0213 (0124, 0124, 0204, 0212, 0212, 0212) {0,0,0,1,0,2,0,0,0,0,0,0,0,0,0,0}
        // 1111 -> 0222 -> 0221 {0132, 0132, 0212, 0212, 0220) {0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0}
        // 1111 -> 0222 -> 0221 {0132, 0132, 0212, 0212, 0220) {0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0}
        
        // Resultados previos
        // 
        // #0 = 594926640
        // #1 = 43103340
        // #2 = 481950
        // #3 = 945
        // Total = 638512875
        // Expected times = 0.06901986901986902

        State st = new State(1010101L, new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        deployBranch(states, st);
/*        while (jobs < 15) {
            ArrayList<State> nstates = new ArrayList<>();
            for (State st : states) {
                for (long a = 2; a <= 5; a++) {
                    long an = st.numbersA(a);
                    while (an > 0) {
                        long nsheet = st.jumpSheets(a);
                        State found_sheet = contains_sheet(nstates, nsheet);
                        if (found_sheet == null) {
                            State nst = new State(st.getLeafs(), nsheet, st.getTimes().clone());
                            nst.getTimes()[(int)st.numberOfSheets()] += 1;
                            nstates.add(nst);
                        }
                        else {
                            found_sheet.addTimes(st.getTimes());
                            found_sheet.getTimes()[(int)st.numberOfSheets()] += 1;
                            found_sheet.addLeafs(st.getLeafs());
                        }
                        an--;
                    }
                }
            }
            states = nstates;
            jobs++;
        }
        long[] times = states.get(0).getTimes();

        System.out.println((double)times[1] / (double)states.get(0).getLeafs());*/
        long total = 0;
        for (long p : posibilities) {
            System.out.println(p);
            total += p;
        }
        System.out.println("Total : " + total);
        double expected = 0;
        long i = 0;
        for (long p : posibilities) {
            expected += ((double)i) * ((double)p / (double)total);
            i++;
        }
        System.out.println(expected);
    }
}
