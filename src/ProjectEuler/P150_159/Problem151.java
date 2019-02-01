/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P150_159;

import Library.Tree;
import java.util.*;

/**
 *
 * @author ismael.flores
 */
public class Problem151 {
    
    private static long[] times_found_one_sheet = {0, 0, 0, 0};
    private static double[] probabilities = {0, 0, 0, 0};
    
    private static class State implements Comparable<State> {

        private long sheets = 0; // [#A2][#A3][#A4][#A5]
        private int[] times = new int [16]; // {1, 4, 2, ...} = 1 time found 1, 4 times found 2, 2 times found 3, ...
        private long[] sheets_found = new long [14];
        private double[] probabilities = new double [14];

        public State(long s, int[] t, long[] sf, double[] p) {
            sheets = s;
            times = t;
            sheets_found = sf;
            probabilities = p;
        }
        
        public int[] getTimes() {
            return times;
        }

        public long[] getSheetsFound() {
            return sheets_found;
        }        
        
        public double[] getProbabilities() {
            return probabilities;
        }        

        public double getProbability() {
            double probability = 1.0;
            for (double p : probabilities) {
                probability *= p;
            }
            return probability;
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
            return sheets + " - " + Arrays.toString(times) + " - " + Arrays.toString(sheets_found) + " - " + Arrays.toString(probabilities);
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
                    State nState = new State(nsheet, st.getTimes().clone(), st.getSheetsFound().clone(), st.getProbabilities().clone());
                    nState.getTimes()[(int)st.numberOfSheets()] += 1;
                    nState.getSheetsFound()[states.getLevel()] = (int)st.getSheets();
                    nState.getProbabilities()[states.getLevel()] = (double)1.0 / (double)st.numberOfSheets();
                    deployBranch(nTree, nState);
                    states.removeBranch(states.getBranchIndex(nTree));
                    an--;
                }
            }
        }
        else {
            //System.out.println(st + " = " + st.getProbability());
            probabilities[st.getTimes()[1]] += st.getProbability();
            times_found_one_sheet[st.getTimes()[1]]++;
        }
    }
    
    public static void problem151() {
        Tree<State> states = new Tree<>();
        // First state is 1 A2, 1 A3, 1 A4 and 1 A5 in job 0
        
        // Job 0 (1 state)
        // 01010101 (00020202, 01000202, 01010002, 01010100) {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0}

        // Job 1 (4 states)
        // 01010101 -> 00020202 (00010303, 00010303, 00020103, 00020103, 00020201, 00020201) {0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0}
        // 01010101 -> 01000202 (00010303, 01000103, 01000103, 01000201, 01000201) {0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0}
        // 01010101 -> 01010002 (00020103, 01000103, 01010001, 01010001) {0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0}
        // 01010101 -> 01010100 (00020201, 01000201, 01010001) {0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0}

        // Job 2 (18 states)     
        // 01010101 -> 00020202 -> 00010303 (00000404, 00010204, 00010204, 00010204, 00010302, 00010302, 00010302) {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0}
        // 01010101 -> 00020202 -> 00010303 (00000404, 00010204, 00010204, 00010204, 00010302, 00010302, 00010302) {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0}
        // 01010101 -> 00020202 -> 00020103 (00010204, 00010204, 00020004, 00020102, 00020102, 00020102) {0,0,0,1,0,2,0,0,0,0,0,0,0,0,0,0}
        // 01010101 -> 00020202 -> 00020103 (00010204, 00010204, 00020004, 00020102, 00020102, 00020102) {0,0,0,1,0,2,0,0,0,0,0,0,0,0,0,0}
        // 01010101 -> 00020202 -> 00020201 {00010302, 00010302, 00020102, 00020102, 00020200) {0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0}
        // 01010101 -> 00020202 -> 00020201 {00010302, 00010302, 00020102, 00020102, 00020200) {0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0}
        
        // Resultados 
        // 
        // [594926640, 43103340, 481950, 945]
        // [0.615759569349121, 0.3099639115291948, 0.0683946871465315, 0.00588183191872425]
        // 0.46439878157843056

        State st = new State(1010101L, new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 
                                       new long[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 
                                       new double[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        deployBranch(states, st);
        
        System.out.println(Arrays.toString(times_found_one_sheet));
        System.out.println(Arrays.toString(probabilities));
        double i = 0.0;
        double expected = 0.0;
        for (double p : probabilities) {
            expected += (double)i * (double)p;
            i += 1.0;
        }
        System.out.println(expected);
    }
}
