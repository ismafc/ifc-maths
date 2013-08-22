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
    private static class PaperSheets {

        public long fromOne = 0;
        public long fromSheet = Long.MIN_VALUE;
        public long peso = 1L;
        public ArrayList<Long> sheets = new ArrayList<>();

        public PaperSheets(long fs, long fo, long p, ArrayList<Long> s) {
            fromSheet = fs;
            fromOne = fo;
            peso = p;
            sheets = s;
        }

    }
    
    public static void problem151() {
        long jobs = 1;
        HashMap<Long, ArrayList<Double>> numbersInJobs = new HashMap<>();
        HashMap<Long, HashMap<Long, Double>> sheetsInJobs = new HashMap<>();
        for (long number = 2L; number <= 5L; number++) {
            numbersInJobs.put(number, new ArrayList<Double>());
        }
        long times = 0;
        ArrayList<PaperSheets> psl = new ArrayList<>();
        psl.add(new PaperSheets(5L, 0L, 1L, new ArrayList<>(Arrays.asList(2L,3L,4L,5L))));
        while (jobs <= 14) {
            // Fusionamos estados
            ArrayList<PaperSheets> npsl = new ArrayList<>();
            for (PaperSheets ps : psl) {
                if (ps.sheets.size() == 1) {
                    times += ps.peso;
                    ps.fromOne++;
                }
                PaperSheets found = null;
                for (PaperSheets fps : npsl) {
                    if (ps.fromOne != fps.fromOne)
                        continue;
                    if (fps.sheets.size() != ps.sheets.size())
                        continue;
                    boolean f = true;
                    for (int i = 0; i < ps.sheets.size(); i++) {
                        if (fps.sheets.get(i) != ps.sheets.get(i)) {
                            f = false;
                            break;
                        }
                    }
                    if (f) {
                        found = fps;
                        break;
                    }
                }
                if (found == null)
                    npsl.add(ps);
                else
                    found.peso += ps.peso;
            }
            psl = npsl;

            // Calculate # of sheets <#sheets, #times>
            HashMap<Long, Long> countSS = new HashMap<>();
            Long totalSS = 0L;
            for (PaperSheets ps : psl) {
                if (countSS.containsKey((long)ps.sheets.size())) {
                    countSS.put((long)ps.sheets.size(), countSS.get((long)ps.sheets.size()) + ps.peso);
                }
                else {
                    countSS.put((long)ps.sheets.size(), ps.peso);
                }
                totalSS += ps.peso;
            }
            for (Long K : countSS.keySet()) {
                if (sheetsInJobs.containsKey(K)) {
                    sheetsInJobs.get(K).put(jobs, (double)countSS.get(K) / (double)totalSS);
                }
                else {
                    HashMap<Long, Double> jobSheet = new HashMap<>();
                    jobSheet.put(jobs, (double)countSS.get(K) / (double)totalSS);
                    sheetsInJobs.put(K, jobSheet);
                }
            }

            // Expand
            npsl = new ArrayList<>();
            for (PaperSheets ps : psl) {
                for (Long s : ps.sheets) {
                    // Quito el que he cogido
                    ArrayList<Long> nsl = new ArrayList<Long>(ps.sheets);
                    nsl.remove(s);
                    // añado los cortes
                    long ns = s + 1; 
                    while (ns <= 5L) {
                        nsl.add(ns);
                        ns++;
                    }
                    if (nsl.size() > 0) {
                        npsl.add(new PaperSheets(s, ps.fromOne, ps.peso, nsl));
                    }
                }
            }
            psl = npsl;
            
            // Calculate # of 2,3,4 and 5
            for (long number = 2; number <= 5L; number++) {
                long count = 0;
                long total = 0;
                for (PaperSheets ps : psl) {
                    count += (ps.fromSheet == number) ? ps.peso : 0;
                    total += ps.peso;
                }
                numbersInJobs.get(number).add((double)count / (double)total);
            }

            jobs++;
        }
        ArrayList<PaperSheets> npsl = new ArrayList<>();
        for (PaperSheets ps : psl) {
            PaperSheets found = null;
            for (PaperSheets fps : npsl) {
                if (ps.fromOne != fps.fromOne)
                    continue;
                if (fps.sheets.size() != ps.sheets.size())
                    continue;
                boolean f = true;
                for (int i = 0; i < ps.sheets.size(); i++) {
                    if (fps.sheets.get(i) != ps.sheets.get(i)) {
                        f = false;
                        break;
                    }
                }
                if (f) {
                    found = fps;
                    break;
                }
            }
            if (found == null)
                npsl.add(ps);
            else
                found.peso += ps.peso;
        }
        psl = npsl;
        
        long total = 0;
        for (PaperSheets ps : psl) {
            total += ps.peso;
        }
        System.out.println("Numero de veces que en encontrado 1 hoja = " + (double)times / (double)total);
        double expected = 0;
        for (PaperSheets ps : psl) {
            double prob = (double)ps.peso / (double)total;
            System.out.println("Threads with " + ps.fromOne + " founds of 1 sheet = " + ps.peso + " of " + total + " (" + prob + ")");
            expected += ((double)ps.fromOne * prob);
        }
        System.out.println("expected number of times that the foreman finds a single sheet of paper in the envelope = " + expected);
        
        for (Long NUMBER : numbersInJobs.keySet()) {
            double result = 0.0;
            int job = 1;
            for (Double D : numbersInJobs.get(NUMBER)) {
                System.out.println("Job " + job + " = " + D);
                result += D;
                job++;
            }
            System.out.println(NUMBER  + " in jobs : " + result);
        }
        
        for (Long sheets : sheetsInJobs.keySet()) {
            double result = 0.0;
            for (Long job : sheetsInJobs.get(sheets).keySet()) {
                System.out.println("Job " + job + " = " + sheetsInJobs.get(sheets).get(job));
                result += sheetsInJobs.get(sheets).get(job);
            }
            System.out.println(sheets + " sheets in jobs : " + result);
        }
    }
}
