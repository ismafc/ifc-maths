/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author iflores
 */
public class Sudoku {
    final private ArrayList<SudokuCell> cells = new ArrayList<>();
    private int dimension = 9;
    
    public Sudoku() {
        super();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                cells.add(new SudokuCell(dimension));
            }
        }
    }
    
    public Sudoku(ArrayList<Integer> values) {
        super();
        initialize(values);
    }

    public Sudoku(Sudoku s) {
        super();
        dimension = s.dimension;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                cells.add(new SudokuCell(s.get(i, j)));
            } 
        }
    }

    private void initialize(ArrayList<Integer> values) {
        if (IFCMath.isPerfectSquare(values.size())) {
            dimension = (int)Math.round(Math.sqrt(values.size()));
            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    cells.add(new SudokuCell(dimension));
                    if (values.get(i * dimension + j) != 0)
                        set(i, j, values.get(i * dimension + j));
                }
            }
        }
    }    
    
    private int super_cell() {
        return (int)Math.round(Math.sqrt(dimension));
    }
    
    public ArrayList<Sudoku> solve() {
        return solve(false);
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
    
    public boolean isDone() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (get(i, j).numberOfPosibilities() != 1)
                    return false;
            }
        }
        return true;
    }
    
    public void set(int i, int j, int value) {
        if (value > 0)
            get(i, j).fixTo(value);
        else
            get(i, j).setPosibles(dimension);
    }
    
    public SudokuCell get(int i, int j) {
        return cells.get(i * dimension + j);
    }

    public int getFixedCells() {
        int fixedCells = 0;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (get(i, j).isFixed())
                    fixedCells++;
            }
        }
        return fixedCells;
    }
    
    private ArrayList<Sudoku> nextLevel() {
        ArrayList<Sudoku> moreSudokus = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (get(i, j).numberOfPosibilities() == 1) {
                    Sudoku s = new Sudoku(this);
                    s.set(i, j, 0);
                    Sudoku sAux = new Sudoku(s);
                    ArrayList<Sudoku> solutions = s.solve();
                    if (solutions.size() == 1)
                        moreSudokus.add(sAux);
                }
            }
        }
        return moreSudokus;
    }    
    
    public ArrayList<Sudoku> increaseLevel(int level, int max) {
        ArrayList<Sudoku> moreSudokus = new ArrayList<>();
        moreSudokus.add(this);
        while (moreSudokus.size() > 0 && level > 0) {
            ArrayList<Sudoku> evenMoreSudokus = new ArrayList<>();
            for (Sudoku s : moreSudokus) {
                ArrayList<Sudoku> sNewLevel = s.nextLevel();
                for (Sudoku sn : sNewLevel) {
                    if (!evenMoreSudokus.contains(sn))
                        evenMoreSudokus.add(sn);
                    if (evenMoreSudokus.size() > max)
                        break;                    
                }
                if (evenMoreSudokus.size() > max)
                    break;
            }
            if (evenMoreSudokus.isEmpty())
                break;
            else
                moreSudokus = evenMoreSudokus;
            level--;
        }
        return moreSudokus;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Sudoku))
            return false;
        Sudoku s = (Sudoku)o;
        if (dimension != s.dimension)
            return false;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (!get(i, j).equals(s.get(i, j)))
                    return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.cells);
        hash = 71 * hash + this.dimension;
        return hash;
    }
    
    // Dividimos el Sudoku en n a partir de la celda que tiene menos posibles
    // valores (idealmente 2)
    private ArrayList<Sudoku> split() {
        int min_pos = 10, min_i = 0, min_j = 0;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (get(i, j).numberOfPosibilities() > 1) {
                    if (get(i, j).numberOfPosibilities() < min_pos) {
                        min_i = i;
                        min_j = j;
                        min_pos = get(i, j).numberOfPosibilities();
                    }
                }
            }
        }
        ArrayList<Sudoku> sudokus = new ArrayList<>();
        if (min_pos > 1 && min_pos < dimension + 1) {
            for (int p : get(min_i, min_j)) {
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
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                changed |= processCell(i, j);
            }
        }
        return changed;
    }

    // Miramos si las posibilidades de las celdas se convierten en certezas
    // porque no pueden ponerse en otro lugar de la fila, columna o bloque
    private boolean check() {
        boolean changed = false;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                changed |= checkCell(i, j);
            }
        }
        return changed;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
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
        for (int i1 = 0; i1 < dimension; i1++) {
            if (i1 != i) {
                SudokuCell sc = get(i1, j);
                if (sc.numberOfPosibilities() == 1 && cell.isPosible(sc.getPosibility(0))) {
                    cell.removePosibility(sc.getPosibility(0));
                    changed = true;
                }
            }
        }
        // Recorro fila i
        for (int j1 = 0; j1 < dimension; j1++) {
            if (j1 != j) {
                SudokuCell sc = get(i, j1);
                if (sc.numberOfPosibilities() == 1 && cell.isPosible(sc.getPosibility(0))) {
                    cell.removePosibility(sc.getPosibility(0));
                    changed = true;
                }
            }
        }
        
        // Recorro bloque super_cell x super_cell donde esta (i,j)
        int i1 = (i / super_cell()) * super_cell();
        int i2 = i1 + super_cell();
        while (i1 < i2) {
            int j1 = (j / super_cell()) * super_cell();
            int j2 = j1 + super_cell();
            while (j1 < j2) {
                if (j1 != j || i1 != i) {
                    SudokuCell sc = get(i1, j1);
                    if (sc.numberOfPosibilities() == 1 && cell.isPosible(sc.getPosibility(0))) {
                        cell.removePosibility(sc.getPosibility(0));
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
        if (cell.numberOfPosibilities() == 1)
            return changed;
        for (int posibility = 0; posibility < cell.numberOfPosibilities() && !changed; posibility++) {
            int value = cell.getPosibility(posibility);
            // Recorro columna j para ver si value puede estar en algun otro sitio
            boolean found = false;
            for (int i1 = 0; i1 < dimension && !found; i1++) {
                if (i1 != i) {
                    SudokuCell sc = get(i1, j);
                    if (sc.isPosible(value)) {
                        found = true;
                    }
                }
            }
            if (!found) {
                cell.fixTo(value);
                changed = true;
                break;
            }
            
            // Recorro fila i para ver si value puede estar en algun otro sitio
            found = false;
            for (int j1 = 0; j1 < dimension && !found; j1++) {
                if (j1 != j) {
                    SudokuCell sc = get(i, j1);
                    if (sc.isPosible(value)) {
                        found = true;
                    }
                }
            }
            if (!found) {
                cell.fixTo(value);
                changed = true;
                break;
            }

            // Recorro bloque super_cell x super_cell donde esta (i,j)
            // para ver si value puede estar en algun otro sitio
            found = false;
            int i1 = (i / super_cell()) * super_cell();
            int i2 = i1 + super_cell();
            while (i1 < i2 && !found) {
                int j1 = (j / super_cell()) * super_cell();
                int j2 = j1 + super_cell();
                while (j1 < j2 && !found) {
                    if (j1 != j || i1 != i) {
                        SudokuCell sc = get(i1, j1);
                        if (sc.isPosible(value)) {
                            found = true;
                        }
                    }
                    j1++;
                }
                i1++;
            }
            if (!found) {
                cell.fixTo(value);
                changed = true;
                break;
            }
        }
        return changed;
    }
    
}
