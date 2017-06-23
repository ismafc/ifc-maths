/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author iflores
 */
public class SudokuCell {
    public ArrayList<Integer> posibles = new ArrayList<>();
    
    public SudokuCell() {
        super();
        posibles.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9));
    }

    public SudokuCell(SudokuCell sc) {
        super();
        for (int p : sc.posibles)
            posibles.add(p);
    }
    
    public void set(int value) {
        posibles.clear();
        posibles.add(value);
    }
    
    @Override
    public String toString() {
        String str = "-";
        if (posibles.size() == 1)
            str = posibles.get(0).toString();
        return str;
    }

    public int size() {
        return posibles.size();
    }
    
    public int get(int i) {
        return posibles.get(i);
    }
    
    public void clear() {
        posibles.clear();
    }
    
    public boolean contains(Object value) {
        return posibles.contains(value);
    }
    
    public boolean remove(Object value) {
        return posibles.remove(value);
    }
}
