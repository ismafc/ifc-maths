/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.util.ArrayList;

/**
 *
 * @author iflores
 */
public class Sudoku {
    final private ArrayList<SudokuCell> cells = new ArrayList<>();
    
    public Sudoku() {
        super();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells.add(new SudokuCell());
            } 
        }
    }
    
    public Sudoku(ArrayList<Integer> values) {
        super();
        initialize(values);
    }

    public Sudoku(Sudoku s) {
        super();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells.add(new SudokuCell(s.get(i, j)));
            } 
        }
    }
    
    public ArrayList<Sudoku> solve(boolean debug) {
        ArrayList<Sudoku> solutions = new ArrayList<>();
        ArrayList<Sudoku> sudokus = new ArrayList<>();
        sudokus.add(this);
        while (sudokus.size() > 0) {
            ArrayList<Sudoku> sudokus_aux = new ArrayList<>();
            for (Sudoku s : sudokus) {
                if (!s.process(debug))
                    sudokus_aux.addAll(s.split());
                else {
                    if (debug) System.out.println(s.toString());
                    solutions.add(s);
                }
            }
            sudokus = sudokus_aux;
        }
        return solutions;
    }
    
    private void initialize(ArrayList<Integer> values) {
        if (values.size() == 9 * 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    cells.add(new SudokuCell());
                    if (values.get(i * 9 + j) != 0)
                        set(i, j, values.get(i * 9 + j));
                }
            }
        }
    }

    public boolean isDone() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (get(i, j).size() != 1)
                    return false;
            }
        }
        return true;
    }
    
    public void set(int i, int j, int value) {
        get(i, j).set(value);
    }
    
    public SudokuCell get(int i, int j) {
        return cells.get(i * 9 + j);
    }

    // Dividimos el Sudoku en n a partir de la celda que tiene menos posibles
    // valores (idealmente 2)
    private ArrayList<Sudoku> split() {
        int min_pos = 10, min_i = 0, min_j = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (get(i, j).size() > 1) {
                    if (get(i, j).size() < min_pos) {
                        min_i = i;
                        min_j = j;
                        min_pos = get(i, j).size();
                    }
                }
            }
        }
        ArrayList<Sudoku> sudokus = new ArrayList<>();
        if (min_pos > 1 && min_pos < 10) {
            for (int p : get(min_i, min_j).posibles) {
                Sudoku s = new Sudoku(this);
                s.set(min_i, min_j, p);
                sudokus.add(s);
            }
        }
        return sudokus;
    }
    
    // Reducimos las posibilidades de las celdas en función de las ya fijadas y
    // miramos si las posibilidades de las celdas se convierten en certezas
    // porque no pueden ponerse en otro lugar de la fila, columna o bloque
    private boolean process(boolean debug) {
        while (!isDone()) {
            boolean changed = false;
            if (debug) System.out.println(toString());
            while (scan()) {
                if (debug) System.out.println(toString());
                changed = true;
            }
            changed = changed | check();
            if (debug && changed) System.out.println(toString());
            if (!changed)
                break;
        }
        return isDone();
    }

    // Reducimos las posibilidades de las celdas en función de las ya fijadas
    private boolean scan() {
        boolean changed = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                changed |= processCell(i, j);
            }
        }
        return changed;
    }

    // Miramos si las posibilidades de las celdas se convierten en certezas
    // porque no pueden ponerse en otro lugar de la fila, columna o bloque
    private boolean check() {
        boolean changed = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                changed |= checkCell(i, j);
            }
        }
        return changed;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                str = str + get(i, j).toString() + " ";
            }
            str += "\n";
        }
        return str + "\n";
    }
    
    // Reducimos las posibilidades de la celda (i, j) en función de las ya fijadas
    private boolean processCell(int i, int j) {
        boolean changed = false;
        SudokuCell cell = get(i, j);
        // Recorro columna j
        for (int i1 = 0; i1 < 9; i1++) {
            if (i1 != i) {
                SudokuCell sc = get(i1, j);
                if (sc.size() == 1 && cell.contains(sc.get(0))) {
                    cell.remove(sc.get(0));
                    changed = true;
                }
            }
        }
        // Recorro fila i
        for (int j1 = 0; j1 < 9; j1++) {
            if (j1 != j) {
                SudokuCell sc = get(i, j1);
                if (sc.size() == 1 && cell.contains(sc.get(0))) {
                    cell.remove(sc.get(0));
                    changed = true;
                }
            }
        }
        
        // Recorro bloque 3x3 donde esta (i,j)
        int i1 = (i / 3) * 3;
        int i2 = i1 + 3;
        while (i1 < i2) {
            int j1 = (j / 3) * 3;
            int j2 = j1 + 3;
            while (j1 < j2) {
                if (j1 != j || i1 != i) {
                    SudokuCell sc = get(i1, j1);
                    if (sc.size() == 1 && cell.contains(sc.get(0))) {
                        cell.remove(sc.get(0));
                        changed = true;
                    }
                }
                j1++;
            }
            i1++;
        }
        return changed;
    }

    // Miramos si las posibilidades de la celda (i,j) se convierten en certezas
    // porque no pueden ponerse en otro lugar de la fila i, columna j o el bloque
    // en el que esta (i, j)
    private boolean checkCell(int i, int j) {
        boolean changed = false;
        SudokuCell cell = get(i, j);
        if (cell.size() == 1)
            return changed;
        for (int posibility = 0; posibility < cell.size() && !changed; posibility++) {
            int value = cell.get(posibility);
            // Recorro columna j para ver si value puede estar en algun otro sitio
            boolean found = false;
            for (int i1 = 0; i1 < 9 && !found; i1++) {
                if (i1 != i) {
                    SudokuCell sc = get(i1, j);
                    if (sc.contains(value)) {
                        found = true;
                    }
                }
            }
            if (!found) {
                cell.set(value);
                changed = true;
                break;
            }
            
            // Recorro fila i para ver si value puede estar en algun otro sitio
            found = false;
            for (int j1 = 0; j1 < 9 && !found; j1++) {
                if (j1 != j) {
                    SudokuCell sc = get(i, j1);
                    if (sc.contains(value)) {
                        found = true;
                    }
                }
            }
            if (!found) {
                cell.set(value);
                changed = true;
                break;
            }

            // Recorro bloque 3x3 donde esta (i,j)
            // para ver si value puede estar en algun otro sitio
            found = false;
            int i1 = (i / 3) * 3;
            int i2 = i1 + 3;
            while (i1 < i2 && !found) {
                int j1 = (j / 3) * 3;
                int j2 = j1 + 3;
                while (j1 < j2 && !found) {
                    if (j1 != j || i1 != i) {
                        SudokuCell sc = get(i1, j1);
                        if (sc.contains(value)) {
                            found = true;
                        }
                    }
                    j1++;
                }
                i1++;
            }
            if (!found) {
                cell.set(value);
                changed = true;
                break;
            }
        }
        return changed;
    }
    
}
