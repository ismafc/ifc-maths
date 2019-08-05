/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.util.ArrayList;

/**
 *
 * @author ismael.flores
 */
public class Nonograma {
    // It Must be multiple of 10
    private final int MAX_DIMENSION = 1000;
    
    // Dimensions
    private int width = 10;
    private int height = 10;
    
    // 0 = Empty
    // 1 = Full
    // -1 = Undefined
    private ArrayList<Integer> cells = new ArrayList<>();
    
    // Clues (definition)
    private ArrayList<ArrayList<Integer>> rows = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> columns = new ArrayList<>();
    
    public Nonograma() {
        super();
        initialize();
    }

    public Nonograma(int w, int h) {
        super();
        width = w;
        height = h;
        initialize();
    }
    
    public Nonograma(Nonograma n) {
        super();
        
        width = n.width;
        height = n.height;
        
        rows = new ArrayList<>();
        n.rows.forEach((r) -> { 
            rows.add((ArrayList<Integer>)r.clone()); 
        });
        
        columns = new ArrayList<>();
        n.columns.forEach((c) -> {
            columns.add((ArrayList<Integer>)c.clone());
        });
        
        cells = new ArrayList<>();
        n.cells.forEach((v) -> {
            cells.add(v);
        });
    }
    
    private void initialize() {
        cells.clear();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cells.add(-1);
            }
        }
        
        rows.clear();
        for (int i = 0; i < height; i++) {
            rows.add(new ArrayList<>());
        }
        
        columns.clear();
        for (int j = 0; j < width; j++) {
            columns.add(new ArrayList<>());
        }
    }

    public void setRowDefinition(int row, ArrayList<Integer> definition) {
        if (row >= 0 && row < rows.size()) {
            rows.set(row, definition);
        }
    }
    
    public void setColumnDefinition(int column, ArrayList<Integer> definition) {
        if (column >= 0 && column < columns.size()) {
            columns.set(column, definition);
        }
    }
    
    private void setValue(int i, int j, int v) {
        cells.set(i * width + j, v);
    }
    
    private int getValue(int i, int j) {
        return cells.get(i * width + j);
    }

    private boolean isRowDone(int row) {
        for (int column = 0; column < width; column++) {
            if (getValue(row, column) == -1) 
                return false;
        }
        return true;
    }

    private boolean isColumnDone(int column) {
        for (int row = 0; row < height; row++) {
            if (getValue(row, column) == -1) 
                return false;
        }
        return true;
    }
    
    private boolean isDone() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (getValue(i, j) == -1) 
                    return false;
            }
        }
        return true;
    }

    private boolean updateRowValues(int row, ArrayList<ArrayList<Long>> results) {
        boolean changes = false;
        int nValues = results.get(0).size();
        for (int column = 0; column < nValues; column++) {
            boolean fixed = true;
            long target = results.get(0).get(column);
            for (ArrayList<Long> r : results) {
                if (r.get(column) != target) {
                    fixed = false;
                    break;
                }
            }
            if (fixed) {
                if (target == 0) {
                    if (getValue(row, column) != 0)
                        changes = true;
                    setValue(row, column, 0);
                }
                else {
                    if (getValue(row, column) != 1)
                        changes = true;
                    setValue(row, column, 1);
                }
            }                
        }
        return changes;
    }

    private boolean updateColumnValues(int column, ArrayList<ArrayList<Long>> results) {
        boolean changes = false;
        int nValues = results.get(0).size();
        for (int row = 0; row < nValues; row++) {
            boolean fixed = true;
            long target = results.get(0).get(row);
            for (ArrayList<Long> r : results) {
                if (r.get(row) != target) {
                    fixed = false;
                    break;
                }
            }
            if (fixed) {
                if (target == 0) {
                    if (getValue(row, column) != 0)
                        changes = true;
                    setValue(row, column, 0);
                }
                else {
                    if (getValue(row, column) != 1)
                        changes = true;
                    setValue(row, column, 1);
                }
            }
        }
        return changes;
    }
    
    private int minToPush(ArrayList<Integer> numberOfDots) {
        int sum = numberOfDots.stream().map((v) -> v).reduce(0, Integer::sum);
        sum += (numberOfDots.size() - 1);
        return sum;
    }
    
    private ArrayList<ArrayList<Long>> expandCandidates(ArrayList<Long> candidate, 
                                                        ArrayList<Integer> nextNumberOfDots, 
                                                        int iNextNumberOfDots, int maxCells) {
        ArrayList<ArrayList<Long>> newCandidates = new ArrayList<>();
        int minToPush = minToPush(nextNumberOfDots);
        int first = candidate.size();
        int offset = 0;
        while (first + offset + minToPush <= maxCells) {
            ArrayList<Long> newCandidate = (ArrayList<Long>)candidate.clone();
            for (int i = 0; i < offset; i++)
                newCandidate.add(0L);
            for (int i = 0; i < nextNumberOfDots.get(0); i++)
                newCandidate.add(nextNumberOfDots.get(0) * (long)MAX_DIMENSION + (long)iNextNumberOfDots);
            if (newCandidate.size() < maxCells) {
                newCandidate.add(0L);
                if (nextNumberOfDots.size() == 1) {
                    while (newCandidate.size() < maxCells)
                        newCandidate.add(0L);
                }
            }
            newCandidates.add(newCandidate);
            offset++;
        }
        return newCandidates;
    }

    ArrayList<ArrayList<Long>> checkColumn(int column, ArrayList<ArrayList<Long>> expanded) {
        ArrayList<ArrayList<Long>> newExpanded = new ArrayList<>();
        for (ArrayList<Long> candidate : expanded) {
            boolean good = true;
            int row = 0;
            for (long v : candidate) {
                if (getValue(row, column) == 0 && v > 0) {
                    good = false;
                    break;
                }
                else if (getValue(row, column) == 1 && v == 0) {
                    good = false;
                    break;
                }
                row++;
            }
            if (good)
                newExpanded.add(candidate);
        }
        return newExpanded;
    }

    ArrayList<ArrayList<Long>> checkRow(int row, ArrayList<ArrayList<Long>> expanded) {
        ArrayList<ArrayList<Long>> newExpanded = new ArrayList<>();
        for (ArrayList<Long> candidate : expanded) {
            boolean good = true;
            int column = 0;
            for (long v : candidate) {
                if (getValue(row, column) == 0 && v > 0) {
                    good = false;
                    break;
                }
                else if (getValue(row, column) == 1 && v == 0) {
                    good = false;
                    break;
                }
                column++;
            }
            if (good)
                newExpanded.add(candidate);
        }
        return newExpanded;
    }
    
    private ArrayList<ArrayList<Long>> getRowPosibleResults(int row) {
        ArrayList<Integer> numberOfDots = (ArrayList<Integer>)rows.get(row).clone();
        int iNumberOfDots = 0;
        ArrayList<ArrayList<Long>> results = expandCandidates(new ArrayList<>(), numberOfDots, iNumberOfDots, width);
        results = checkRow(row, results);
        while (numberOfDots.size() > 1) {
            ArrayList<ArrayList<Long>> newResults = new ArrayList<>();
            numberOfDots.remove(0);
            iNumberOfDots++;
            for (ArrayList<Long> candidate : results) {
                ArrayList<ArrayList<Long>> expanded = expandCandidates(candidate, numberOfDots, iNumberOfDots, width);
                expanded = checkRow(row, expanded);
                newResults.addAll(expanded);
            }
            results = newResults;
        }
        return results;
    }

    private ArrayList<ArrayList<Long>> getColumnPosibleResults(int column) {
        ArrayList<Integer> numberOfDots = (ArrayList<Integer>)columns.get(column).clone();
        int iNumberOfDots = 0;
        ArrayList<ArrayList<Long>> results = expandCandidates(new ArrayList<>(), numberOfDots, iNumberOfDots, height);
        results = checkColumn(column, results);
        while (numberOfDots.size() > 1) {
            ArrayList<ArrayList<Long>> newResults = new ArrayList<>();
            numberOfDots.remove(0);
            iNumberOfDots++;
            for (ArrayList<Long> candidate : results) {
                ArrayList<ArrayList<Long>> expanded = expandCandidates(candidate, numberOfDots, iNumberOfDots, height);
                expanded = checkColumn(column, expanded);
                newResults.addAll(expanded);
            }
            results = newResults;
        }
        return results;
    }
    
    // -1 : No solution / Inconsistent
    // 0 : No changes
    // 1 : Changes
    private int processRow(int row) {
        ArrayList<ArrayList<Long>> results = getRowPosibleResults(row);        
        if (results.isEmpty())
            return -1;
        
        boolean b = updateRowValues(row, results);
        return (b == true ? 1 : 0);
    }

    // -1 : No solution / Inconsistent
    // 0 : No changes
    // 1 : Changes
    private int processColumn(int column) {
        ArrayList<ArrayList<Long>> results = getColumnPosibleResults(column);        
        
        if (results.isEmpty())
            return -1;
        
        boolean b = updateColumnValues(column, results);
        return (b == true ? 1 : 0);
    }

    // -1 : Imposible to do
    // 0 : Done
    // 1 : Not done. Need to split.
    private int process(boolean debug) {
        while (!isDone()) {
            boolean changed = false;
            for (int row = 0; row < height; row++) {
                if (!isRowDone(row)) {
                    int changedRow = processRow(row);
                    if (changedRow == -1)
                        return -1;
                    if (!changed)
                        changed = (changedRow != 0);
                    if (debug) {
                        System.out.println("Processed Row = " + row);
                        System.out.println(this);
                    }
                }
            }            
            for (int column = 0; column < width; column++) {
                if (!isColumnDone(column)) {
                    int changedColumn = processColumn(column);
                    if (changedColumn == -1)
                        return -1;
                    if (!changed)
                        changed = (changedColumn != 0);
                    if (debug) {
                        System.out.println("Processed Column = " + column);
                        System.out.println(this);
                    }
                }
            }
            if (!changed)
                break;
        }
        return (isDone() ? 0 : 1);
    }
    
    private ArrayList<Nonograma> split() {
        int min_row = MAX_DIMENSION;
        int i_min_row = -1;
        int min_column = MAX_DIMENSION;
        int i_min_column = -1;
        ArrayList<ArrayList<Long>> row_results = new ArrayList<>();
        ArrayList<ArrayList<Long>> column_results = new ArrayList<>();
        ArrayList<Nonograma> nonogramas = new ArrayList<>(); 
        for (int row = 0; row < height; row++) {
            if (!isRowDone(row)) {
                ArrayList<ArrayList<Long>> results = getRowPosibleResults(row);
                if (results.size() < min_row) {
                    min_row = results.size();
                    i_min_row = row;
                    row_results = results;
                }                    
            }
        }
        for (int column = 0; column < width; column++) {
            if (!isColumnDone(column)) {
                ArrayList<ArrayList<Long>> results = getColumnPosibleResults(column);
                if (results.size() < min_column) {
                    min_column = results.size();
                    i_min_column = column;
                    column_results = results;
                }
            }
        }
        if (min_row <= min_column) {
            for (ArrayList<Long> result : row_results) {
                Nonograma n = new Nonograma(this);
                int column = 0;
                for (long v : result) {
                    n.setValue(i_min_row, column, (v > 0) ? 1 : 0);
                    column++;
                }
                nonogramas.add(n);
            }
        }
        else {
            for (ArrayList<Long> result : column_results) {
                Nonograma n = new Nonograma(this);
                int row = 0;
                for (long v : result) {
                    n.setValue(row, i_min_column, (v > 0) ? 1 : 0);
                    row++;
                }
                nonogramas.add(n);
            }
        }
        
        return nonogramas;
    }
    
    public ArrayList<Nonograma> solve(boolean debug) {        
        ArrayList<Nonograma> solutions = new ArrayList<>();
        ArrayList<Nonograma> nonogramas = new ArrayList<>();
        nonogramas.add(this);
        while (nonogramas.size() > 0) {
            ArrayList<Nonograma> nonogramas_aux = new ArrayList<>();
            for (Nonograma n : nonogramas) {
                int result = n.process(debug); 
                if (result == 1)
                    nonogramas_aux.addAll(n.split());
                else if (result == 0)
                    solutions.add(n);
            }
            nonogramas = nonogramas_aux;
        }
        return solutions;
    }
    
    private String getCharacter(int row, int column) {
        switch (getValue(row, column)) {
            case 1:
                return "X";
            case 0:
                return ".";
            default:
                return "?";
        }
    }
    
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                str = str + getCharacter(i, j);
            }
            str += "\n";
        }
        return str + "\n";
    }
}
