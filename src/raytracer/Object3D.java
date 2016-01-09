/*
 * Object3D.java
 *
 * Created on 25 de mayo de 2005, 19:06
 */

package raytracer;

/**
 * Stores a Object with three components (X, Y and Z). It will be usefull for Points, Vector, Normals, etc.
 * @author Isma
 * @version 1.0
 */
public class Object3D {
    
    /**
     * X value in 3D environment
     */
    protected double x = 0.0;
    
    /**
     * Y value in 3D environment
     */
    protected double y = 0.0;
    
    /**
     * Z value in 3D environment
     */
    protected double z = 0.0;

    /**
     * Object3D with all components to zero
     */
    static final public Object3D ZERO = new Object3D(0.0, 0.0, 0.0);
    
    /**
     * Creates a new instance of Object3D
     * All variables initialized to 0
     */
    public Object3D() {
    }

    /**
     * Creates a new instance of Object3D with parameters
     * @param nx X value for 3D environment
     * @param ny Y value for 3D environment
     * @param nz Z value for 3D environment
     */
    public Object3D(double nx, double ny, double nz) {
        set(nx, ny, nz);
    }

    /**
     * Creates a new instance of Object3D with object
     * @param o Object to clone
     */
    public Object3D(Object3D o) {
        if (o != null) {
            set(o.x, o.y, o.z);
        }
    }

    /**
     * Creates a new instance of Object3D with array
     * @param c Array of 3 or more values (x, y and z)
     */
    public Object3D(double c[]) {
        if (c != null) {
            if (c.length >= 3) {
                set(c[0], c[1], c[2]);
            }
        }
    }
    
    /**
     * Initializes this Object3D with input values
     * @param nx Double for x field
     * @param ny Double for y field
     * @param nz Double for z field
     */
    public final void set(double nx, double ny, double nz) {
        x = nx;
        y = ny;
        z = nz;
    }

    /**
     * Initializes this Object3D with input value
     * @param o Object3D to copy in this Object
     * @return True if given object 'o' is not null, False otherwise
     */
    public boolean set(Object3D o) {
        if (o == null) 
            return false;
        set(o.x, o.y, o.z);
        return true;
    }
    
    /**
     * Initializes this Object3D with input value
     * @param c Array of three doubles with x, y and z values (in this order)
     * @return True if input array 'c' has three values and False if not
     */
    public boolean set(double c[]) {
        if (c != null && c.length >= 3) {
            set(c[0], c[1], c[2]);
            return true;
        }
        return false;
    }
    
    /**
     * Initializes x value of this Object3D with input value
     * @param nx Double with new x value
     */
    public void setX(double nx) { x = nx; }

    /**
     * Returns x value of this Object3D
     * @return Double with x value
     */
    public double getX() { return x; }
    
    /**
     * Initializes y value of this Object3D with input value
     * @param ny Double with new y value
     */
    public void setY(double ny) { y = ny; }

    /**
     * Returns y value of this Object3D
     * @return Double with y value
     */
    public double getY() { return y; }
    
    /**
     * Initializes z value of this Object3D with input value
     * @param nz Double with new z value
     */
    public void setZ(double nz) { z = nz; }
    
    /**
     * Returns z value of this Object3D
     * @return Double with z value
     */
    public double getZ() { return z; }
    
    /**
     * Obtains values of this Object3D in input parameter 'c'
     * @param c Array of three values where we will store x, y and z values (in this order)
     * @return True if input array 'c' has three values and False if not
     */
    public boolean get(double c[]) {
        if (c != null && c.length >= 3) {
            c[0] = x;
            c[1] = y;
            c[2] = z;
            return true;
        }
        return false;
    }

    /**
     * Returns an Object3D with the sum of Object3D 'o' to this object. 
     * It consists on add x value to x value, y value to y value and z value to z value
     * @param o Object3D to add to this object
     * @return Object3D with (this + 'o') if given object 'o' is not null, null otherwise
     */
    public Object3D add(Object3D o) {
        if (o == null)
            return null;
        return new Object3D(x + o.x, y + o.y, z + o.z);
    }

    /**
     * Returns an Object3D with subtraction between input Object3D 'o' and this object. 
     * It consists on substract x value from x value, y value from y value and z value from z value
     * @param o Object3D to substract to this object
     * @return Object3D with (this - 'o') if given object 'o' is not null, null otherwise
     */
    public Object3D sub(Object3D o) {
        if (o == null) 
            return null;
        return new Object3D(x - o.x, y - o.y, z - o.z);
    }
    
    /**
     * Returns an Object3D with division between this Object3D and input value 'd'. 
     * It consists on divide x, y and z by 'd' value
     * @param d Double with value to divide
     * @return Object3D with this división if division can be done and null if not (division by 0)
     */
    public Object3D div(double d) {
        if (d == 0.0)
            return null;
        return new Object3D(x / d, y / d, z / d);
    }

    /**
     * Returns an Object3D with division between this Object3D and input Object3D 'o'. 
     * It consists on divide x by x, y by y and z by z
     * @param o Object3D with value to divide
     * @return Object3D with división ('this' / 'o') if division can be done and null if not (some division by 0)
     */
    public Object3D div(Object3D o) {
        if (o == null)
            return null;
        if (o.x == 0.0 || o.y == 0.0 || o.z == 0.0)
            return null;
        return new Object3D(x / o.x, y / o.y, z / o.z);
    }
    
    /**
     * Multiplies this Object3D by input value 'd' and returns an Object3D woth the result.
     * It consists on multiply x, y and z by 'd' value
     * @param d Double with value to multiply
     * @return Object3D with the result of this multiplication
     */
    public Object3D mul(double d) {
        return new Object3D(x * d, y * d, z * d);
    }
    
    /**
     * Multiplies this Object3D by input Object3D 'o' and returns an Object3D with the result.
     * It consists on multiply x by x, y by y and z by z
     * @param o Object3D with value to multiply
     * @return Multiplications ('this' * 'o') if given object 'o' is not null, null otherwise
     */
    public Object3D mul(Object3D o) {
        if (o == null) 
            return null;
        return new Object3D(x * o.x, y * o.y, z * o.z);
    }
    
    /**
     * Adds input values to this object and returns an Object3D with the result. 
     * It consists on add nx value to x value, ny value to y value and nz value to z value
     * @param nx Double fo add to x value of this object
     * @param ny Double fo add to y value of this object
     * @param nz Double fo add to z value of this object
     * @return Object3D with the result of the operation
     */
    public Object3D add(double nx, double ny, double nz) {
        return new Object3D(x + nx, y + ny, z + nz);
    }

    /**
     * Substracts input values from this object and returns an Object3D with the result.
     * It consists on substracy nx from x value, ny value from y value and nz value from z value
     * @param nx Double fo substract to x value of this object
     * @param ny Double fo substract to y value of this object
     * @param nz Double fo substract to z value of this object
     * @return Object3D with the result of the operation
     */
    public Object3D sub(double nx, double ny, double nz) {
        return new Object3D(x - nx, y - ny, z - nz);
    }

    /**
     * Multiplies input values by this object and returns the result in an Object3D.
     * It consists on multipliy nx by x value, ny value by y value and nz value by z value
     * @param nx Double fo multiply by x value of this object
     * @param ny Double fo multiply by y value of this object
     * @param nz Double fo multiply by z value of this object
     * @return Object3D with the result of the operation
     */
    public Object3D mul(double nx, double ny, double nz) {
        return new Object3D(x * nx, y * ny, z * nz);
    }

    /**
     * Divides input values by this object and returns an Object3D with the result. 
     * It consists on divide nx by x value, ny value by y value and nz value by z value
     * @param nx Double fo divide by x value of this object
     * @param ny Double fo divide by y value of this object
     * @param nz Double fo divide by z value of this object
     * @return Object3D with the result of the operation if it is posible, null otherwise (division by 0)
     */
    public Object3D div(double nx, double ny, double nz) {
        if (nx == 0.0 || ny == 0.0 || nz == 0.0)
            return null;
        return new Object3D(x / nx, y / ny, z / nz);
    }

    /**
     * Adds input array 'c' to this object and returns an Object3D with the result. 
     * It consists on add x value to x[0] value, y value to c[1] value and z value to c[2] value
     * @param c Array of double to add to this object
     * @return Object3D with operation if array length is more than three and null if not
     */
    public Object3D add(double c[]) {
        if (c.length < 3)
            return null;
        return new Object3D(x + c [0], y + c[1], z + c[2]);
    }
    
    /**
     * Asks if this Object3D is null (0.0)
     * @return True if all values are 0.0 and False if not
     */
    public boolean isNull() {
        return x == 0.0 && y == 0.0 && z == 0.0;
    }
    
    /**
     * Asks if this Object3D is near null (0.0 +/- some defined value)
     * @param epsilon Tolerance value
     * @return True if all values are between 0.0 and epsilon (included), and False if not
     */
    public boolean isNull(double epsilon) {
        epsilon = (epsilon >= 0) ? epsilon : -epsilon;
        return x <= epsilon && x >= -epsilon && 
               y <= epsilon && y >= -epsilon &&
               z <= epsilon && z >= -epsilon;
    }
    
    /**
     * Asks if this Object3D is valid or not
     * @return True if all values are NaN and False if not
     */
    public boolean isInvalid() {
        return Double.isNaN(x) || Double.isNaN(y) || Double.isNaN(z);
    }
    
    /**
     * Invalidates this Object3D initializing all values to NaN values
     */
    public void invalidate() {
        x = Double.NaN;
        y = Double.NaN;
        z = Double.NaN;
    }
    
    /**
     * Compares Object3D 'o' with 'this' point
     * @param o Object3D to compare with
     * @return True if 'o' and 'this' are equals and False if they are not equals
     */
    @Override
    public boolean equals(Object o) {
        if (o != null || o instanceof Object3D) {
            return ((Object3D)o).x == x && 
                   ((Object3D)o).y == y &&
                   ((Object3D)o).z == z;
        }
        return false;
    }

    /**
     * Generates hash code for this Object3D
     * @return integer with hash code based on 'x', 'y' and 'z'
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
        return hash;
    }
    
    /**
     * Asks if this Object3D is equal than input value with input tolerance
     * x,y and z must be equals one by one with epsilon tolerance
     * @param o Object to compare to this Object3D
     * @param epsilon Tolerance value (have to be positive)
     * @return True if both objects are equals with given tolerance and False if not. 
     */
    public boolean equals(Object3D o, double epsilon) {
        epsilon = (epsilon >= 0) ? epsilon : -epsilon;
        return x >= o.x - epsilon && x <= o.x + epsilon && 
               y >= o.y - epsilon && y <= o.y + epsilon && 
               z >= o.z - epsilon && z <= o.z + epsilon;
    }   
    
    /**
     * Asks for a String representation of this Object3D (x,y,z)
     * @return String representing this Object3D 
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    /** 
     * Calculates the length of this object ^ 2 (sometimes is not necessary to
     * calculate length to know some properties about vectors (3D objects)
     * @return Double containing the length of object ^ 2
     */
    public double lengthSquared() {
        return x * x + y * y + z * z;
    }
    
    /** 
     * Calculates the length of this object. No errors are possible because
     *'lengthSquared' is always greater or equal than 0
     * @return Double containing the length of object
     */
    public double length() {
        return Math.sqrt(lengthSquared());
    }
    
    /** 
     * Calculates length of object 'o'
     * @param o Three components object to calculate its length
     * @return Double containing o length
     */
    static public double length(Object3D o) {
        return (o != null) ? o.length() : Double.NaN;
    }
    
}
