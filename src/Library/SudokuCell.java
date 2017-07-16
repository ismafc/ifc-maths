/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iflores
 */
public class SudokuCell implements Iterable<Integer> {
    private ArrayList<Integer> posibles = new ArrayList<>();
    
    public SudokuCell() {
        super();
    }

    public SudokuCell(SudokuCell sc) {
        super();
        for (int p : sc.posibles)
            posibles.add(p);
    }

    public SudokuCell(int posibilities) {
        super();
        setPosibles(posibilities);
    }
    
    public final void setPosibles(int posibilities) {
        posibles.clear();
        for (int p = 1; p <= posibilities; p++)
            posibles.add(p);
    }
    
    public void fixTo(int value) {
        posibles.clear();
        posibles.add(value);
    }
    
    public boolean isFixed() {
        return posibles.size() == 1;
    }
    
    @Override
    public String toString() {
        String str = "-";
        if (posibles.size() == 1)
            str = posibles.get(0).toString();
        return str;
    }

    public int numberOfPosibilities() {
        return posibles.size();
    }
    
    public int getPosibility(int i) {
        return posibles.get(i);
    }

    public int getValue() {
        return numberOfPosibilities() != 1 ? 0 : getPosibility(0);
    }
    
    public boolean isPosible(int value) {
        return posibles.contains(value);
    }
    
    public boolean removePosibility(int value) {
        return posibles.remove((Integer)value);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SudokuCell))
            return false;
        SudokuCell sc = (SudokuCell)o;
        if (numberOfPosibilities() != 1 && sc.numberOfPosibilities() != 1)
            return true;
        if (numberOfPosibilities() != sc.numberOfPosibilities())
            return false;
        return getPosibility(0) == sc.getPosibility(0);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.posibles);
        return hash;
    }
    
    @Override
    public SudokuCell clone() {
        SudokuCell sc = new SudokuCell();
        try {
            sc = (SudokuCell)super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(SudokuCell.class.getName()).log(Level.SEVERE, null, ex);
        }
        sc.setPosibles(posibles);
        return sc;
    }
    
    @Override
    public Iterator<Integer> iterator() {
        return posibles.iterator();
    }
    
    public void setPosibles(ArrayList<Integer> ps) {
        posibles = new ArrayList<>();
        for (int p : ps)
            posibles.add(p);
    }
}
