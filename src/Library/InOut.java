/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.math.BigInteger;

/**
 * In this class we will add several usefull In &amp; Out functions
 * @author ismael.flores
 */
public class InOut {

    /** 
     * Convert <b><i>v</i></b> to a <b>long</b>.<br>
     * If <b>v</b> is not a valid <b>long</b> the <b><i>default_value</i></b> is returned
     * @param v String to convert to a <b>long</b>
     * @param default_value value returned if <b><i>v</i></b> is not a valid <b>long</b>
     * @param name Argument name used just for display log if needed
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with value of <b><i>v</i></b> 
     * or <b><i>default_value</i></b> if <b><i>v</i></b> is not a valid <b>long</b>
     */
    private static long getValue(String v, long default_value, String name) {
        long value = default_value;
        try {
            value = Long.parseLong(v);
        } catch (NumberFormatException e) {
            System.out.println(name + " is not a number: Assuming " + default_value);
        }
        return value;
    }

    /** 
     * Convert <b><i>v</i></b> to a <b>BigInteger</b>.<br>
     * If <b>v</b> is not a valid <b>BigInteger</b> the <b><i>default_value</i></b> is returned
     * @param v String to convert to a <b>long</b>
     * @param default_value value returned if <b><i>v</i></b> is not a valid <b>BigInteger</b>
     * @param name Argument name used just for display log if needed
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with value of <b><i>v</i></b> 
     * or <b><i>default_value</i></b> if <b><i>v</i></b> is not a valid <b>BigInteger</b>
     */
    private static BigInteger getValue(String v, BigInteger default_value, String name) {
        BigInteger value = default_value;
        try {
            value = new BigInteger(v);
        } catch (NumberFormatException e) {
            System.out.println(name + " is not a number: Assuming " + default_value);
        }
        return value;
    }
    
    /** 
     * Finds the first argument called <b><i>name</i></b> in arguments <b><i>args</i></b>.<br>
     * Argumens have the form: <b>[argument_name]:[value]</b> where <b>value</b> is a <b>long</b>.<br>
     * If <b>value</b> is not a valid <b>long</b> or <b>argument_name</b> is not found in <b><i>args</i></b>
     * the <b><i>default_value</i></b> is returned
     * @param args List of string where we will found argument <b><i>name</i></b>
     * @param default_value value returned if <b>value</b> is not a valid <b>long</b> or <b>argument_name</b> is not found in <b><i>args</i></b>
     * @param name Argument name searched in <b><i>args</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with value of argument <b><i>name</i></b> found 
     * or <b><i>default_value</i></b> if <b>value</b> is not a valid <b>long</b> or <b>argument_name</b> is not found in <b><i>args</i></b>
     */
    public static long getArgument(String[] args, long default_value, String name) {
        long value = default_value;
        for (String param : args) {
            if (param.startsWith(name + ":")) {
                String v = param.substring(name.length() + 1);
                value = getValue(v, default_value, name);
                return value;
            }
        }
        return value;
    }
    
    /** 
     * Finds the first argument called <b><i>name</i></b> in arguments <b><i>args</i></b>.<br>
     * Argumens have the form: <b>[argument_name]:[value]</b> where <b>value</b> is a <b>BigInteger</b>.<br>
     * If <b>value</b> is not a valid <b>BigInteger</b> or <b>argument_name</b> is not found in <b><i>args</i></b>
     * the <b><i>default_value</i></b> is returned
     * @param args List of string where we will found argument <b><i>name</i></b>
     * @param default_value value returned if <b>value</b> is not a valid <b>BigInteger</b> or <b>argument_name</b> is not found in <b><i>args</i></b>
     * @param name Argument name searched in <b><i>args</i></b>
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with value of argument <b><i>name</i></b> found 
     * or <b><i>default_value</i></b> if <b>value</b> is not a valid <b>BigInteger</b> or <b>argument_name</b> is not found in <b><i>args</i></b>
     */
    public static BigInteger getArgument(String[] args, BigInteger default_value, String name) {
        BigInteger value = default_value;
        for (String param : args) {
            if (param.startsWith(name + ":")) {
                String v = param.substring(name.length() + 1);
                value = getValue(v, default_value, name);
                return value;
            }
        }
        return value;
    }
}
