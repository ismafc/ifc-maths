/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler;

import java.util.ArrayList;

/**
 *
 * @author ismael.flores
 */
public class PaperSheets {

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
