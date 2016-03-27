/*
 * MatrixNxM.java
 *
 * Created on 13 de agosto de 2005, 14:05
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package raytracer;

import java.util.Arrays;

/**
 * Implements a 4 x 4 matrix (of double values)
 * This Matrix has at least 1x1 dimension
 * @author Isma
 */
public class MatrixNxM {

    /** 
     * Contains number of rows for this matrix (by default 4)
     */
    private int rows = 4;
    
    /** 
     * Contains number of columns for this matrix (by default 4)
     */
    private int columns = 4;
    
    /** 
     * Contains The inverse matrix for this matrix.
     * This variable is calculated in 'inverse' function and is erased when
     * the matrix changes in some way.
     */
    private MatrixNxM inverseMatrix = null;
    
    /** 
     * Contains the doubles that allows to this matrix (row, column)
     * stored in a N x M array of doubles
     */
    protected double[][] values = new double[rows][columns];
    
    /**
     * 
     * Creates a new instance of MatrixNxM 
     * It's initialized to identity 4 x 4 matrix
     */
    public MatrixNxM() {
        super();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                values[i][j] = (i == j) ? 1.0 : 0.0;
    }
    
    /**
     * 
     * Creates a new instance of MatrixNxM initialized with parameter 'nvalues'.
     * Parameter must be at least a 1x1 matrix array.
     * @param nvalues array of N x M double used to initialized matrix
     */
    public MatrixNxM(double[][] nvalues) {
        super();
        if (nvalues.length > 0) {
            if (nvalues[0].length > 0) {
                rows = nvalues.length;
                columns = nvalues[0].length;
                values = new double[rows][columns];
                for (int i = 0; i < rows; i++)
                    System.arraycopy(nvalues[i], 0, values[i], 0, columns);
            }
        }
    }
    
    /**
     * 
     * Creates a new instance of MatrixNxM initialized with parameter
     * @param m the new matrix used to initialize this
     */
    public MatrixNxM(MatrixNxM m) {
        super();
        rows = m.rows;
        columns = m.columns;
        values = new double[rows][columns];
        for (int i = 0; i < rows; i++)
            System.arraycopy(m.values[i], 0, values[i], 0, columns);
    }

    /**
     * 
     * Creates a new instance of MatrixNxM initialized with parameters
     * Matrix is initialized to identity
     * @param nrows Number of rows of new matrix
     * @param ncolumns Number of columns of new matrix
     */
    public MatrixNxM(int nrows, int ncolumns) {
        super();
        rows = (nrows <= 0) ? rows : nrows;
        columns = (ncolumns <= 0) ? columns : ncolumns;
        values = new double[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                values[i][j] = (i == j) ? 1.0 : 0.0;
    }
    
    /**
     * Returns the number of rows for this MatrixNxM, that is, N
     * @return Integer with number of rows
     */
    public int getRows() { return rows; }

    /**
     * Returns the number of columns for this MatrixNxM, that is, M
     * @return Integer with number of columns
     */
    public int getColumns() { return columns; }
    
    /** 
     * Checks if 'matrix' is equal to this matrix
     * @param o The matrix to compare with
     * @return True if both matrix are equals and False if not
     */
    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof MatrixNxM) {
            MatrixNxM m = (MatrixNxM)o;
            if (rows != m.rows || columns != m.columns)
                return false;
            for (int i = 0; i < m.rows; i++)
                for (int j = 0; j < m.columns; j++)
                    if (values[i][j] != m.values[i][j])
                        return false;
            return true;
        }
        return false;
    }

    /**
     * Generates hash code for this MatrixNxM
     * @return integer with hash code based on 'rows', 'columns' and 'values'
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.rows;
        hash = 59 * hash + this.columns;
        hash = 59 * hash + Arrays.deepHashCode(this.values);
        return hash;
    }
    
    /** 
     * Transpose this matrix 
     * @return MatrixNxM with this matrix transposed
     */
    public MatrixNxM transpose() {
        double[][] v = new double [columns][rows];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                v[j][i] = values[i][j];
        return new MatrixNxM(v);
    }
    
    /** 
     * Calculates the inverse of this matrix if this is not calculated and it's possible.
     * If it's calculated then return it directly
     * @return Returns a N x N matrix containing the inverse of this matrix
     */
    public MatrixNxM getInverse() {
        if (inverseMatrix != null)
            return inverseMatrix;
        double d = determinant(values);
        if (d == 0.0 || Double.isNaN(d))
            return null;
        inverseMatrix = new MatrixNxM(rows, columns);
        // Transposed adjunts matrix divided by determinant
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                inverseMatrix.set(j, i, cofactor(values, i, j) / d);
        return inverseMatrix;
    }

    /** 
     * Inverts this matrix.
     * @return True if matrix in invertible and False if not
     */
    public boolean invert() {
        if (inverseMatrix == null)
            inverseMatrix = getInverse();
        if (inverseMatrix == null)
            return false;
        MatrixNxM m = new MatrixNxM(this);
        set(inverseMatrix);
        inverseMatrix = m;
        return true;
    }
    
    /** 
     * Initializes the value located in ('i', 'j') with value 'v'
     * @param i Row of target value
     * @param j Column of target value
     * @param v New value in (i, j)
     * @return True if value has been asigned to required position, False otherwise
     */
    public boolean set(int i, int j, double v) {
        if (i >= 0 && i < rows && j >= 0 && j < columns) {
            values[i][j] = v;
            inverseMatrix = null;
            return true;
        }
        return false;
    }

    /** 
     * Returns value located in (row, column)
     * if (row, column) is out of range, NaN is returned
     * @param row Row of target value
     * @param column Column of target value
     * @return Double with value in (row, column), NaN otherwise
     */
    public double get(int row, int column) {
        if (row >= 0 && row < rows && column >= 0 && column < columns) {
            return values[row][column];
        }
        return Double.NaN;
    }
    
    /** 
     * Copies matrix 'm' in this matrix (clonation)
     * @param m Matrix to be copied in
     */
    public void set(MatrixNxM m) {
        rows = m.rows;
        columns = m.columns;
        values = m.values;
        inverseMatrix = m.inverseMatrix;
    }
    
    /** 
     * Multiplies this matrix by value 'v'
     * @param v Double with value to multiply to this matrix
     */
    public void mul(double v) {
        if (v != 1.0) {
            for (double[] value : values) {
                for (int j = 0; j < value.length; j++) {
                    value[j] *= v;
                }
            }
            inverseMatrix = null;
        }
    }

    /** 
     * Multiplies this matrix by 'm' matrix (composition)
     * @param m Matrix to compose to this matrix
     * @return True if multiplication is possible and False if not
     */
    public boolean mul(MatrixNxM m) {
        if (columns != m.rows || columns == 0 || rows == 0 || m.columns == 0 || m.rows == 0)
            return false;
        double[][] v = new double[rows][m.columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < m.columns; j++) {
                v[i][j] = 0.0;
                for (int k = 0; k < columns; k++)
                    v[i][j] += values[i][k] * m.values[k][j];
            }
        }
        values = v;
        inverseMatrix = null;
        return true;
    }

    /** 
     * Multiplies 'm1' by 'm2' and returns a matrix with the result of this operation,
     * that is, the compositition of both matrix
     * @param m1 Frist matrix to composite
     * @param m2 Second matrix to composite
     * @return A matrix with m1.m2 or null if multiplication is not possible
     */
    static public MatrixNxM mul(MatrixNxM m1, MatrixNxM m2) {
        MatrixNxM m = new MatrixNxM(m1);
        if (m.mul(m2))
            return m;
        else
            return null;
    }
    
    /** 
     * Makes this matrix null (all values will be 0)
     */
    public void toNull() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                values[i][j] = 0.0;
        inverseMatrix = null;
    }
    
    /** 
     * Makes this matrix the identity matrix (all values will be 0 unless diagonal values to 1)
     * @return True if this matrix is squared and False if not
     */
    public boolean toIdentity() {
        if (rows != columns)
            return false;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                values[i][j] = (i == j) ? 1.0 : 0.0;
        inverseMatrix = null;
        return true;
    }

    /** 
     * Makes this matrix a translation defined by 'o'
     * @param o 3D Object defining the translation in each axe
     * @return True if this is a 4 x 4 matrix and False if not
     */
    public boolean toTranslation(Object3D o) {
        if (rows != 4 || columns != 4)
            return false;
        toIdentity();
        values[0][3] = o.x;
        values[1][3] = o.y;
        values[2][3] = o.z;
        inverseMatrix = null;
        return true;
    }

    /** 
     * Makes this matrix a scaling defined by 'o'
     * @param sx X axis scale
     * @param sy Y axis scale
     * @param sz Z axis scale
     * @return True if this is a 4 x 4 matrix and False otherwise
     */
    public boolean toScale(double sx, double sy, double sz) {
        if (rows != 4 || columns != 4)
            return false;
        toIdentity();
        values[0][0] = sx;
        values[1][1] = sy;
        values[2][2] = sz;
        inverseMatrix = null;
        return true;
    }
    
    /** 
     * Makes this matrix a scaling defined by 'o'
     * @param o 3D Object defining the scaling in each axe
     * @return True if this is a 4 x 4 matrix or Object3D is not null and False otherwise
     */
    public boolean toScale(Object3D o) {
        if (rows != 4 || columns != 4 || o == null)
            return false;
        toIdentity();
        values[0][0] = o.x;
        values[1][1] = o.y;
        values[2][2] = o.z;
        inverseMatrix = null;
        return true;
    }
    
    /** 
     * Makes this matrix a rotation in X axis 'r' radiants
     * @param r Angle in radiants to rotate
     * @return True if this is a 4 x 4 matrix and False if not
     */
    public boolean toRotationX(double r) {
        if (rows != 4 || columns != 4)
            return false;
        toIdentity();
        values[1][1] = Math.cos(r);
        values[1][2] = -Math.sin(r);
        values[2][1] = Math.sin(r);
        values[2][2] = Math.cos(r);
        inverseMatrix = null;
        return true;
    }

    /** 
     * Makes this matrix a rotation in Y axis 'r' radiants
     * @param r Angle in radiants to rotate
     * @return True if this is a 4 x 4 matrix and False if not
     */
    public boolean toRotationY(double r) {
        if (rows != 4 || columns != 4)
            return false;
        toIdentity();
        values[0][0] = Math.cos(r);
        values[0][2] = Math.sin(r);
        values[2][0] = -Math.sin(r);
        values[2][2] = Math.cos(r);
        inverseMatrix = null;
        return true;
    }

    /** 
     * Makes this matrix a rotation in Z axis 'r' radiants
     * @param r Angle in radiants to rotate
     * @return True if this is a 4 x 4 matrix and False if not
     */
    public boolean toRotationZ(double r) {
        if (rows != 4 || columns != 4)
            return false;
        toIdentity();
        values[0][0] = Math.cos(r);
        values[0][1] = -Math.sin(r);
        values[1][0] = Math.sin(r);
        values[1][1] = Math.cos(r);
        inverseMatrix = null;
        return true;
    }
    
    /** 
     * Makes this matrix a rotation by 'r' radiants arround 'o' axis (ussually a vector)
     * If axis is a null vector this matrix is transformed to identity
     * @param r Angle in radiants to rotate
     * @param o Three dimensional object representing the axis (vector)
     * @return True if this is a 4 x 4 matrix and False if not
     */
    public boolean toRotation(double r, Object3D o) {
        if (rows != 4 || columns != 4)
            return false;
        toIdentity();
        Vector3D a = new Vector3D(o);
        a.normalize();

        double s = Math.sin(r);
        double c = Math.cos(r);

        values[0][0] = a.x * a.x + (1.0 - a.x * a.x) * c;
        values[0][1] = a.x * a.y * (1.0 - c) - a.z * s;
        values[0][2] = a.x * a.z * (1.0 - c) + a.y * s;

        values[1][0] = a.x * a.y * (1.0 - c) + a.z * s;
        values[1][1] = a.y * a.y + (1.0 - a.y * a.y) * c;
        values[1][2] = a.y * a.z * (1.0 - c) - a.x * s;

        values[2][0] = a.x * a.z * (1.0 - c) - a.y * s;
        values[2][1] = a.y * a.z * (1.0 - c) + a.x * s;
        values[2][2] = a.z * a.z + (1.0 - a.z * a.z) * c;

        //
        // Is the same that:
        //
        // double beta = Math.atan2(o.y, o.z);
        // double gamma = Math.atan2(o.x, Math.sqrt(o.y * o.y + o.z * o.z));
        
        // toRotationX(-beta);
        // MatrixNxM m = new MatrixNxM();
        // m.toRotationY(gamma);
        // mul(m);
        // m.toRotationZ(r);
        // mul(m);
        // m.toRotationY(-gamma);
        // mul(m);
        // m.toRotationX(beta);
        // mul(m);
        //
        
        inverseMatrix = null;
        
        return true;
    }    
    
    /** 
     * Makes this matrix a look-at transformation matrix.
     * Gives a transformation between camera space and world space.
     * All parameters are in world coordinates.
     * @param pos Camera position
     * @param look Position being looked at from the camera
     * @param up Orients camera along viewing direction
     * @return True if construction is possible and False if not
     */
    public boolean lookAt(Point3D pos, Point3D look, Vector3D up) {
        if (rows != 4 || columns != 4)
            return false;
        Vector3D upNormalized = new Vector3D(up);
        if (!upNormalized.normalize())
            return false;
        
        values[0][3] = pos.x;
        values[1][3] = pos.y;
        values[2][3] = pos.z;
        values[3][3] = 1;
        
        Vector3D dir = new Vector3D(pos, look);
        Vector3D right = Vector3D.cross(dir, upNormalized);
        Vector3D newUp = Vector3D.cross(right, dir);
        
        values[0][0] = right.x;
        values[1][0] = right.y;
        values[2][0] = right.z;
        values[3][0] = 0;
        values[0][1] = newUp.x;
        values[1][1] = newUp.y;
        values[2][1] = newUp.z;
        values[3][1] = 0;
        values[0][2] = dir.x;
        values[1][2] = dir.y;
        values[2][2] = dir.z;
        values[3][2] = 0;
        
        inverseMatrix = null;
        
        return true;
    }
    
    /** 
     * Transforms the 3D object 'o' applying this matrix transformation
     * @param o Three dimensional object to be transformed
     * @return True if transformation is possible and False if not
     */
    public boolean transform(Object3D o) {
        if (rows != 4 || columns != 4)
            return false;
        double[] col = { o.x, o.y, o.z, 0.0};
        double[] result = {0.0, 0.0, 0.0, 0.0};
        if (o instanceof Point3D) {
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                   result[i] += values[i][j] * col[j];
            if (result[3] != 1.0 && result[3] != 0.0) {
                result[0] /= result[3];
                result[1] /= result[3];
                result[2] /= result[3];
            }
        }
        else if (o instanceof Normal3D) {
            MatrixNxM m = getInverse();
            result[0] = m.values[0][0] * o.x + m.values[1][0] * o.y + m.values[2][0] * o.z;
            result[1] = m.values[0][1] * o.x + m.values[1][1] * o.y + m.values[2][1] * o.z;
            result[2] = m.values[0][2] * o.x + m.values[1][2] * o.y + m.values[2][2] * o.z;
        }
        else {
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                   result[i] += values[i][j] * col[j];            
        }
        o.x = result[0];
        o.y = result[1];
        o.z = result[2];
        return true;
    }

    /** 
     * Transforms the 3D ray 'r' applying this matrix transformation
     * @param r Three dimensional ray to be transformed
     * @return True if transformation is possible and False if not
     */
    public boolean transform(Ray3D r) {
        if (!transform(r.o))
            return false;
        if (!transform(r.d))
            return false;
        return false;
    }

    /** 
     * Transforms the 3D box 'b' applying this matrix transformation
     * @param b Three dimensional box to be transformed
     */        
    public void transform(Box3D b) {
        Point3D o = b.pMin;
        Vector3D x = new Vector3D(o, new Point3D(b.pMax.x, o.y, o.z));
        Vector3D y = new Vector3D(o, new Point3D(o.x, b.pMax.y, o.z));
        Vector3D z = new Vector3D(o, new Point3D(o.x, o.y, b.pMax.z));
        transform(o);
        transform(x);
        transform(y);
        transform(z);
        b.set(o);
        b.union(Point3D.add(o, x));
        b.union(Point3D.add(o, y));
        b.union(Point3D.add(o, z));
        b.union(Point3D.add(Point3D.add(o, z),  x));
        b.union(Point3D.add(Point3D.add(o, z),  y));
        b.union(Point3D.add(Point3D.add(Point3D.add(o, x),  y), z));
    }
    
    /** 
     * This function tells us if this matrix transformation changes handedness
     * @return True if this matrix swaps handedness and False if not
     */
    public boolean swapsHandedness() {
        return (cofactor(values, 3, 3) < 0.0);
    }

    /** 
     * Divides this matrix by 'v' value
     * @param v Double with value to divide to this matrix
     */
    public void div(double v) {
        if (v != 0 && v != 1.0) {
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < columns; j++)
                    values[i][j] /= v;
            inverseMatrix = null;
        }
    }
    
    /** 
     * Adds the matrix 'm' to this matrix
     * @param m Matrix to add to this matrix
     * @return True if addition is possible and False if not
     */
    public boolean add(MatrixNxM m) {
        if (rows != m.rows || columns != m.columns)
            return false;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                values[i][j] += m.values[i][j];
        inverseMatrix = null;
        return true;
    }

    /** 
     * Substracts the matrix 'm' to this matrix
     * @param m Matrix to substract to this matrix
     * @return True if substraction is possible and False if not
     */
    public boolean sub(MatrixNxM m) {
        if (rows != m.rows || columns != m.columns)
            return false;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                values[i][j] -= m.values[i][j];
        inverseMatrix = null;
        return true;
    }

    /** 
     * Check if this MatrixNxM is Square (same number of rows and columns)
     * @return True if this matrix is square, False otherwise
     */
    public boolean isSquare() {
        return (values != null && values.length > 0 && values.length == values[0].length);
    }

    /** 
     * Check if given MatrixNxM 'm' is Square (same number of rows and columns)
     * @param m matrix to check
     * @return True if given matrix 'm' is square, False otherwise
     */
    static public boolean isSquare(MatrixNxM m) {
        return m.isSquare();
    }

    /** 
     * Check if given matrix of doubles 'v' is Square (same number of rows and columns)
     * @param v matrix to check
     * @return True if given matrix of doubles 'v' is square, False otherwise
     */
    static public boolean isSquare(double[][] v) {
        return (v != null && v.length > 0 && v.length == v[0].length);
    }
    
    /** 
     * Calculates the determinant for this 4 x 4 matrix
     * @return Double with determinant for this matrix
     */
    public double determinant() {
        return determinant(values);
    }

    /** 
     * Calculates the determinant for a N x N matrix stored in 'v'.
     * If v is not squared or null then returns NaN
     * @param v Two dimensional array of doubles with matrix stored by rows
     * @return Double with determinant for 'v' matrix (or NaN if is not possible to calculate it)
     */
    static public double determinant(double v[][]) {
        // If 'v' is not and squared matrix returns NaN
        if (!isSquare(v))
            return Double.NaN;
        switch (v.length) {
            case 0: // If number of rows is 0 the returns NaN
                return Double.NaN;
            case 1:
                return v[0][0];
            case 2:
                return v[0][0] * v[1][1] - v[0][1] * v[1][0];
            default:
                double d = 0.0;
                for (int i = 0; i < v.length; i++)
                    d += v[i][0] * cofactor(v, i, 0);
                return d;
        }
    }
    
    /** 
     * Calculates the adjunt value for (i, j) position in a N x N matrix stored in 'v'.
     * @param v Two dimensional array of doubles with matrix stored by rows. It must be a squared matrix.
     * @param i Row of 'v' to calculate the cofactor
     * @param j Column of 'v' to calculate the cofactor
     * @return Double with cofactor for (i, j) position of 'v' matrix, that is the determinant of minor of 'v' matrix for (i, j) position with sign determined by (-1)^(i + j)
     */
    static private double cofactor(double v[][], int i, int j) {
        double[][] subv = new double[v.length - 1][v.length - 1];
        for (int ni = 0; ni < v.length; ni++) {
            for (int nj = 0; nj < v[ni].length; nj++) {
                if (ni != i && nj != j)
                    subv[(ni < i) ? ni : ni - 1][(nj < j) ? nj : nj - 1] = v[ni][nj];
            }
        }
        return ((((i + j) % 2) == 0) ? 1.0 : -1.0) * ((subv.length == 0) ? 1.0 : determinant(subv));
    }
    
    /** 
     * Returns a String representation for this object
     * @return String representing this object
     */
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < rows; i++) {
            str += "(";
            for (int j = 0; j < columns; j++)
                str += values[i][j] + ((j < columns - 1) ? ", " : "");
            str += ")" + ((i < rows - 1) ? " - " : "");
        }
        return str;
    }
}
