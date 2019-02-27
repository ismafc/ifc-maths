/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P160_169;

import java.util.Arrays;

/**
 *
 * @author ismael.flores
 */
public class Problem166 {
    
    /*    
    A 4x4 grid is filled with digits d, 0 ≤ d ≤ 9.

    It can be seen that in the grid

    6 3 3 0
    5 0 4 3
    0 7 1 4
    1 2 4 5

    the sum of each row and each column has the value 12. Moreover the sum of each diagonal is also 12.

    In how many ways can you fill a 4x4 grid with the digits d, 0 ≤ d ≤ 9 so that each row, each column, and both diagonals have the same sum?
    */
    
    private static long found = 0;
    
    private static class State implements Comparable<State> {

        private long dimension = 4;
        private long[] square = null;

        public State(long d) {
            dimension = d;
            square = new long [(int)(d * d)];
            for (int i = 0; i < d * d; i++) {
                square[i] = -1;
            }
        }        
        
        public State(long d, long[] s) {
            dimension = d;
            square = s;
        }
        
        public long get(int i, int j) {
            return square[i * (int)dimension + j];
        }

        public void set(int i, int j, long v) {
            square[i * (int)dimension + j] = v;
        }
        
        public long getDimension() {
            return dimension;
        }
        
        @Override
        public int compareTo(State st) {
            if (st.getDimension() == dimension)
                return 0;
            return -1;
        }
        
        @Override
        public String toString() {
            return "Dimension = " + dimension + " - " + Arrays.toString(square);
        }
    }

    private static long getMaxn(State st, int i, int j, long DIMENSION, 
                                   long MAX_NUMBER, long sum) {
        // Restricciones en la fila i
        long sum_row = 0;
        for (int column = 0; column < j; column++) {
            sum_row += st.get(i, column);
        }
        long maxn1 = (sum - sum_row < MAX_NUMBER) ? (sum - sum_row) : MAX_NUMBER;
                
        // Restricciones en la columna j
        long sum_column = 0;
        for (int row = 0; row < i; row++) {
            sum_column += st.get(row, j);
        }
        long maxn2 = (sum - sum_column < MAX_NUMBER) ? (sum - sum_column) : MAX_NUMBER;
        long maxn = (maxn1 < maxn2) ? maxn1 : maxn2;
       
        // Restricciones en la diagonal principal
        if (i == j) {
            long sum_diagonal1 = 0;
            for (int rc = 0; rc < i; rc++) {
                sum_diagonal1 += st.get(rc, rc);
            }
            long maxn3 = (sum - sum_diagonal1 < MAX_NUMBER) ? (sum - sum_diagonal1) : MAX_NUMBER;
            maxn = (maxn < maxn3) ? maxn : maxn3;
        }
        
        // Restricciones en la diagonal secundaria
        if (i + j + 1 == DIMENSION) {
            long sum_diagonal2 = 0;
            for (int rc = 0; rc < i; rc++) {
                sum_diagonal2 += st.get(rc, (int)DIMENSION - rc - 1);
            }
            long maxn4 = (sum - sum_diagonal2 < MAX_NUMBER) ? (sum - sum_diagonal2) : MAX_NUMBER;
            maxn = (maxn < maxn4) ? maxn : maxn4;
        }
        return maxn;
    }
    
    private static boolean check(State st, int i, int j, long DIMENSION, 
                                 long MAX_NUMBER, long sum) {
        // Restricciones en la fila i
        long sum_row = 0;
        for (int column = 0; column < j; column++) {
            sum_row += st.get(i, column);
        }
        if (sum_row > sum)
            return false;  // Ya nos hemos pasado
        
        sum_row = sum_row + ((j < DIMENSION - 1) ? DIMENSION - 1 - j : 0) * MAX_NUMBER;
        if (sum_row + MAX_NUMBER < sum)
            return false;  // Ya no llegamos
        
        // Restricciones en la columna j
        long sum_column = 0;
        for (int row = 0; row < i; row++) {
            sum_column += st.get(row, j);
        }
        if (sum_column > sum)
            return false;  // Ya nos hemos pasado

        sum_column = sum_column + ((i < DIMENSION - 1) ? DIMENSION - 1 - i : 0) * MAX_NUMBER;
        if (sum_column + MAX_NUMBER < sum)
            return false;  // Ya no llegamos
        
        // Restricciones en la diagonal principal
        if (i == j) {
            long sum_diagonal1 = 0;
            for (int rc = 0; rc < i; rc++) {
                sum_diagonal1 += st.get(rc, rc);
            }
            if (sum_diagonal1 > sum)
                return false;  // Ya nos hemos pasado
            
            sum_diagonal1 = sum_diagonal1 + ((i < DIMENSION - 1) ? DIMENSION - 1 - i : 0) * MAX_NUMBER;
            if (sum_diagonal1 + MAX_NUMBER < sum)
                return false;  // Ya no llegamos
        }
        
        // Restricciones en la diagonal secundaria
        if (i + j + 1 == DIMENSION) {
            long sum_diagonal2 = 0;
            for (int rc = 0; rc < i; rc++) {
                sum_diagonal2 += st.get(rc, (int)DIMENSION - rc - 1);
            }
            if (sum_diagonal2 > sum)
                return false;  // Ya nos hemos pasado
            sum_diagonal2 = sum_diagonal2 + ((i < DIMENSION - 1) ? DIMENSION - 1 - i : 0) * MAX_NUMBER;
            if (sum_diagonal2 + MAX_NUMBER < sum)
                return false;  // Ya no llegamos
        }
        return true;
    }

    private static long getMinn(State st, int i, int j, long DIMENSION, 
                                   long MIN_NUMBER, long MAX_NUMBER, long sum) {
        // Restricciones en la fila i
        long sum_row = 0;
        for (int column = 0; column < j; column++) {
            sum_row += st.get(i, column);
        }        
        sum_row = sum_row + ((j < DIMENSION - 1) ? DIMENSION - 1 - j : 0) * MAX_NUMBER;
        long minn1 = (sum - sum_row < MIN_NUMBER) ? MIN_NUMBER : sum - sum_row; 
        
        // Restricciones en la columna j
        long sum_column = 0;
        for (int row = 0; row < i; row++) {
            sum_column += st.get(row, j);
        }
        sum_column = sum_column + ((i < DIMENSION - 1) ? DIMENSION - 1 - i : 0) * MAX_NUMBER;
        long minn2 = (sum - sum_column < MIN_NUMBER) ? MIN_NUMBER : sum - sum_column;
        long minn = (minn1 > minn2) ? minn1 : minn2;
        
        // Restricciones en la diagonal principal
        if (i == j) {
            long sum_diagonal1 = 0;
            for (int rc = 0; rc < i; rc++) {
                sum_diagonal1 += st.get(rc, rc);
            }
            
            sum_diagonal1 = sum_diagonal1 + ((i < DIMENSION - 1) ? DIMENSION - 1 - i : 0) * MAX_NUMBER;
            long minn3 = (sum - sum_diagonal1 < MIN_NUMBER) ? MIN_NUMBER : sum - sum_diagonal1; 
            minn = (minn > minn3) ? minn : minn3;
        }
        
        // Restricciones en la diagonal secundaria
        if (i + j + 1 == DIMENSION) {
            long sum_diagonal2 = 0;
            for (int rc = 0; rc < i; rc++) {
                sum_diagonal2 += st.get(rc, (int)DIMENSION - rc - 1);
            }

            sum_diagonal2 = sum_diagonal2 + ((i < DIMENSION - 1) ? DIMENSION - 1 - i : 0) * MAX_NUMBER;
            long minn4 = (sum - sum_diagonal2 < MIN_NUMBER) ? MIN_NUMBER : sum - sum_diagonal2; 
            minn = (minn > minn4) ? minn : minn4;
        }
        return minn;
    }
    
    private static void deployBranch(State st, int i, int j, 
                                     long DIMENSION, long MIN_NUMBER, long MAX_NUMBER, long sum) {
        if (check(st, i, j, DIMENSION, MAX_NUMBER, sum)) {
            long minn = getMinn(st, i, j, DIMENSION, MIN_NUMBER, MAX_NUMBER, sum);
            long maxn = getMaxn(st, i, j, DIMENSION, MAX_NUMBER, sum);
            if (minn <= maxn) {
                for (long v = minn; v <= maxn; v++) {
                    State nst = new State(DIMENSION, st.square.clone());
                    nst.set(i, j, v);
                    if (i == DIMENSION - 1 && j == DIMENSION - 1) {
                        found++;
                        continue;
                    }
                    int nj = (j == DIMENSION - 1) ? 0 : j + 1;
                    int ni = (j == DIMENSION - 1) ? i + 1 : i;
                    deployBranch(nst, ni, nj, DIMENSION, MIN_NUMBER, MAX_NUMBER, sum);
                }
            }
        }
    }
    
    public static void problem166() {
        //
        // Una aproximación sería calcular las posibilidades por suma (de 0 a 36, que és la máxima ya que 9 x 4 = 36)
        // Para cada posible suma vamos desplegando el árbol de posibilidades teniendo en cuenta las restricciones
        //   1.- Si lo que falta por sumar no llegaría al objetivo paramos
        //   2.- Si ya nos hemos pasado paramos
        // Hay que ir construyendo número a número (por ejemplo desde arriba a la izquierda a abajo a la derecha)
        //
        // Results:
        //
        // Found 1 posibilities (sum = 0)
        // Found 9 posibilities (sum = 1)
        // Found 57 posibilities (sum = 2)
        // Found 257 posibilities (sum = 3)
        // Found 932 posibilities (sum = 4)
        // Found 2836 posibilities (sum = 5)
        // Found 7572 posibilities (sum = 6)
        // Found 18180 posibilities (sum = 7)
        // Found 40105 posibilities (sum = 8)
        // Found 82433 posibilities (sum = 9)
        // Found 159409 posibilities (sum = 10)
        // Found 290729 posibilities (sum = 11)
        // Found 499856 posibilities (sum = 12)
        // Found 809824 posibilities (sum = 13)
        // Found 1237264 posibilities (sum = 14)
        // Found 1786448 posibilities (sum = 15)
        // Found 2444905 posibilities (sum = 16)
        // Found 3181649 posibilities (sum = 17)
        // Found 3948385 posibilities (sum = 18)
        // Found 4685129 posibilities (sum = 19)
        // Found 5343586 posibilities (sum = 20)
        // Found 5892770 posibilities (sum = 21)
        // Found 6320210 posibilities (sum = 22)
        // Found 6630178 posibilities (sum = 23)
        // Found 6839305 posibilities (sum = 24)
        // Found 6970625 posibilities (sum = 25)
        // Found 7047601 posibilities (sum = 26)
        // Found 7089929 posibilities (sum = 27)
        // Found 7111854 posibilities (sum = 28)
        // Found 7122462 posibilities (sum = 29)
        // Found 7127198 posibilities (sum = 30)
        // Found 7129102 posibilities (sum = 31)
        // Found 7129777 posibilities (sum = 32)
        // Found 7129977 posibilities (sum = 33)
        // Found 7130025 posibilities (sum = 34)
        // Found 7130033 posibilities (sum = 35)
        // Found 7130034 posibilities (sum = 36)
        //
        final long MIN_NUMBER = 0;
        final long MAX_NUMBER = 9;
        final long DIMENSION = 4;
        for (long sum = DIMENSION * MIN_NUMBER; sum <= DIMENSION * MAX_NUMBER; sum++) {
            int i = 0;
            int j = 0;
            State st = new State(DIMENSION);
            deployBranch(st, i, j, DIMENSION, MIN_NUMBER, MAX_NUMBER, sum);
            System.out.println("Found " + found + " posibilities (sum = " + sum + ")");
        }
    }
}
