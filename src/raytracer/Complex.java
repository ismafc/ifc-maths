/*
 * Complex.java
 */
package raytracer;

/**
 * Implementation of a Class to manage complex numbers a + bi
 * @author ismael.flores
 * @version 1.0
*/
public class Complex
{
    
    /**
     * Real part of complex number
     */
    private double re = Double.NaN;

    /**
     * Imaginary part of complex number
     */
    private double im = Double.NaN;

    /** 
     * Creates a new instance of Complex
     */
    public Complex() {
    }
    
    /** 
     * Creates a new object with the given real and imaginary parts
     * @param real Real part of complex number (a in a+bi)
     * @param imag Imaginary part of complex number (b in a+bi)
     */
    public Complex(double real, double imag) {
        set(real, imag);
    }

    /** 
     * Creates a new instance of Complex with
     * a copy of given parameter 'c'
     * @param c Complex to copy to this object
     */
    public Complex(Complex c) {
        if (c != null)
            set(c.re, c.im);
    }

    /** 
     * Initializes the complex with given parameters
     * @param real Real part of complex number (a in a+bi)
     * @param imag Imaginary part of complex number (b in a+bi)
     */
    public final void set(double real, double imag) {
        re = real;
        im = imag;
    }
    
    /** 
     * Compares this object with given object 'c'.
     * @param c Object to be compared with
     * @return true if given object has same real and imaginary parts, false otherwise
     */
    @Override
    public boolean equals(Object c) {
        if (c instanceof Complex)
            return re == ((Complex)c).re && im == ((Complex)c).im;
        else 
            return false;
    }

    /** 
     * Calculates and returns a hash code. Tipically used to store object in 
     * Hash Tables and other structures
     * @return Integer with hash code calculated
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.re) ^ (Double.doubleToLongBits(this.re) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.im) ^ (Double.doubleToLongBits(this.im) >>> 32));
        return hash;
    }

    /** 
     * Returns text representation of this complex value in binomical format a+bi 
     * @return String with binomical format of this complex
     */
    @Override
    public String toString() {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im <  0) return re + " - " + (-im) + "i";
        return re + " + " + im + "i";
    }

    /**
     * Returns abs/modulus/magnitude of this complex:
     * Math.sqrt(re * re + im * im)
     * @return Double with magnitude/modulus/abs value of this complex
     */
    public double abs() { 
        return Math.hypot(re, im); 
    }   
    
    /**
     * Returns angle/phase/argument of this complex in radiants
     * between -pi and pi
     * @return Double with angle/phase/argument value of this complex
     */
    public double phase() { 
        return Math.atan2(im, re); 
    }

    /**
     * Returns a new Complex object whose value is (this + b)
     * @param b Complex to sum to this complex
     * @return Complex with sum of this and given parameter
     */
    public Complex add(Complex b) {
        if (b == null)
            return null;
        double real = re + b.re;
        double imag = im + b.im;
        return new Complex(real, imag);
    }

    /**
     * Returns a new Complex object whose value is (this - b)
     * @param b Complex to subtract of this complex
     * @return Complex with subtraction of this and given parameter
     */
    public Complex subtract(Complex b) {
        if (b == null)
            return null;
        double real = re - b.re;
        double imag = im - b.im;
        return new Complex(real, imag);
    }

    /**
     * Returns a new Complex object whose value is (this * b)
     * @param b Complex to multiply to this complex
     * @return Complex with multiplication of this and given parameter
     */
    public Complex multiply(Complex b) {
        if (b == null)
            return null;
        double real = re * b.re - im * b.im;
        double imag = re * b.im + im * b.re;
        return new Complex(real, imag);
    }

    /**
     * Returns a new Complex object whose value is the scalar
     * multiplication between this complex and a real 'alpha' 
     * @param alpha Real value to scalar multiply to this complex
     * @return Complex with scalar multiplication
     */
    public Complex multiply(double alpha) {
        return new Complex(alpha * re, alpha * im);
    }

    /**
     * Returns a new Complex object whose value is the conjugate of this
     * @return Complex with conjugate of this complex
     */
    public Complex conjugate() {  
        return new Complex(re, -im); 
    }

    /**
     * Returns a new Complex object whose value is the reciprocal of this
     * So, this * reciprocal(this) = 1
     * @return Complex with reciprocal of this complex
     */
    public Complex reciprocal() {
        double scale = re * re + im * im;
        return new Complex(re / scale, -im / scale);
    }

    /**
     * Returns the real part of complex
     * @return Double with real part of complex
     */
    public double re() { 
        return re; 
    }
    
    /**
     * Returns the imaginary part of complex
     * @return Double with imaginary part of complex
     */
    public double im() { 
        return im; 
    }

    /**
     * Returns a new Complex object whose value is (this / b)
     * @param b Complex to divide to this complex
     * @return Complex with division between this and given parameter 'b'
     */
    public Complex divide(Complex b) {
        if (b == null)
            return null;
        return multiply(b.reciprocal());
    }

    /**
     * Returns a new Complex object whose value is (a + b)
     * @param a First Complex to sum
     * @param b Second Complex to sum
     * @return Complex with sum of given parameters
     */
    public static Complex add(Complex a, Complex b) {
        if (a == null || b == null)
            return null;
        double real = a.re + b.re;
        double imag = a.im + b.im;
        return new Complex(real, imag);
    }    

    /**
     * Returns a new Complex object whose value is (a - b)
     * @param a First Complex to sum
     * @param b Second Complex to sum
     * @return Complex with sum of given parameters
     */
    public static Complex subtract(Complex a, Complex b) {
        if (a == null || b == null)
            return null;
        double real = a.re - b.re;
        double imag = a.im - b.im;
        return new Complex(real, imag);
    }    
    
    /**
     * Returns a new Complex object whose value is (a * b)
     * @param a First Complex to multiply
     * @param b Second Complex to multiply
     * @return Complex with multiplication of given parameters
     */
    public static Complex multiply(Complex a, Complex b) {
        if (a == null || b == null)
            return null;
        double real = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        return new Complex(real, imag);
    }
    
    /**
     * Returns a new Complex object with the scalar
     * multiplication between complex 'a' and a real 'alpha' 
     * @param a Complex value to be scalar multiplicated
     * @param alpha Real value to scalar multiply to 'a' complex
     * @return Complex with scalar multiplication between 'a' and 'alpha'
     */
    public static Complex multiply(Complex a, double alpha) {
        if (a == null)
            return null;
        else
            return new Complex(alpha * a.re, alpha * a.im);
    }
    
    /**
     * Returns a new Complex object whose value is the reciprocal of 'a'
     * So, a * reciprocal(a) = 1
     * @param a Complex to calculate the reciprocal
     * @return Complex with reciprocal of given Complex 'a'
     */
    public static Complex reciprocal(Complex a) {
        if (a == null)
            return null;
        double scale = a.re * a.re + a.im * a.im;
        return new Complex(a.re / scale, -a.im / scale);
    }
    
    /**
     * Returns a new Complex object whose value is (a / b)
     * @param a Complex to be divided
     * @param b Complex to divide to
     * @return Complex with division between 'a' and 'b'
     */
    public static Complex divide(Complex a, Complex b) {
        if (b == null)
            return null;
        return Complex.multiply(a, Complex.reciprocal(b));
    }
}
