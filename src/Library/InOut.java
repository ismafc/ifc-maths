/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;

/**
 * In this class we will add several usefull In &amp; Out functions
 * 
 * @author ismael.flores
 * @param <T> Abstract and generic class
 */
public class InOut<T> {

    /** 
     * Obtain a string representation of list <b><i>list</i></b><br>. That is:
     * Elements of this list separated by provided text <b><i>inText</i></b>
     * 
     * @param list List to obtain string represetation
     * @param inText Text to add between each value of list
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/String.html" target="_blank"><b>String</b></a> 
     * with desired text
     */
    public String getListText(ArrayList<T> list, String inText) {
        String txt = "";
        for (int i = 0; i < list.size(); i++) {
            T bi = list.get(i);
            txt += bi.toString();
            if (i < list.size() - 1)
                txt += inText;
        }
        return txt;
    }
    
    /** 
     * Convert <b><i>v</i></b> to a <b>long</b>.<br>
     * If <b>v</b> is not a valid <b>long</b> the <b><i>default_value</i></b> is returned
     * 
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
        } catch (NumberFormatException ex) {
            String msg = name + " is not a number: Assuming " + default_value;
            String className = InOut.class.getName();
            Logger.getLogger(className).log(Level.SEVERE, msg, ex);
        }
        return value;
    }

    /** 
     * Convert <b><i>v</i></b> to a <b>BigInteger</b>.<br>
     * If <b>v</b> is not a valid <b>BigInteger</b> the <b><i>default_value</i></b> is returned
     * 
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
        } catch (NumberFormatException ex) {
            String msg = name + " is not a number: Assuming " + default_value;
            String className = InOut.class.getName();
            Logger.getLogger(className).log(Level.SEVERE, msg, ex);
        }
        return value;
    }
    
    /** 
     * Finds the first argument called <b><i>name</i></b> in arguments <b><i>args</i></b>.<br>
     * Argumens have the form: <b>[argument_name]:[value]</b> where <b>value</b> is a <b>long</b>.<br>
     * If <b>value</b> is not a valid <b>long</b> or <b>argument_name</b> is not found in <b><i>args</i></b>
     * the <b><i>default_value</i></b> is returned
     * 
     * @param args List of string where we will find argument <b><i>name</i></b>
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
     * 
     * @param args List of string where we will find argument <b><i>name</i></b>
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

    /** 
     * Finds the first argument called <b><i>name</i></b> in arguments <b><i>args</i></b>.<br>
     * Argumens have the form: <b>[argument_name]:[value]</b> where <b>value</b> is a <b>String</b>.<br>
     * If <b>value</b> is not a valid <b>String</b> or <b>argument_name</b> is not found in <b><i>args</i></b>
     * the <b><i>default_value</i></b> is returned
     * 
     * @param args List of string where we will find argument <b><i>name</i></b>
     * @param default_value value returned if <b>value</b> is not a valid <b>String</b> or <b>argument_name</b> is not found in <b><i>args</i></b>
     * @param name Argument name searched in <b><i>args</i></b>
     * @return <a href="https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/lang/String.html" target="_blank"><b>String</b></a> with value of argument <b><i>name</i></b> found 
     * or <b><i>default_value</i></b> if <b>value</b> is not a valid <b>String</b> or <b>argument_name</b> is not found in <b><i>args</i></b>
     */
    public static String getArgument(String[] args, String default_value, String name) {
        String value = default_value;
        for (String param : args) {
            if (param.startsWith(name + ":"))
                value = param.substring(name.length() + 1);
        }
        return value;
    }
    
    /** 
     * return value of parameter called <b><i>name</i></b> in parameters <b><i>p</i></b>.<br>
     * Parameters could have two forms:<br> 
     * 1.- <b>[name]:[value]</b> where <b>value</b> is a <b>String</b>.<br>
     * 2.- <b>--[name]=[value]</b> where <b>value</b> is a <b>String</b>.<br>
     * If <b>value</b> is not a valid <b>String</b> or <b>name</b> is not found in <b><i>p</i></b>
     * the <b><i>defaultValue</i></b> is returned.<br>
     * <b><i>uppercase</i></b> indicates if returned value must be uppercased or not.
     * 
     * @param p List of <a href="https://openjfx.io/javadoc/11/javafx.graphics/javafx/application/Application.Parameters.html" target="_blank"><b>Parameter</b></a> where we will find argument <b><i>name</i></b>
     * @param name Argument name searched in <b><i>p</i></b>
     * @param defaultValue value returned if <b>value</b> is not a valid <b>String</b> or <b>name</b> is not found in <b><i>p</i></b>
     * @param uppercase <a href="https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/lang/Boolean.html" target="_blank"><b>Boolean</b></a> indicating if <b>value</b> must be returned as uppercase or not
     * @return <a href="https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/lang/String.html" target="_blank"><b>String</b></a> with value of argument <b><i>name</i></b> found 
     * or <b><i>defaultValue</i></b> if <b>value</b> is not a valid <b>String</b> or <b>name</b> is not found in <b><i>p</i></b>
     */
    public static String getParameter(Application.Parameters p, String name, String defaultValue, boolean uppercase) {
        if (p == null)
            return defaultValue;
        List<String> argsl = p.getUnnamed();
        String[] args = (argsl.size() > 0 ? argsl.toArray(new String[0]) : new String[0]);
        String value1 = getArgument(args, (String)null, name);
        String value2 = p.getNamed().get(name);
        String value = (value1 == null ? (value2 == null ? defaultValue : value2) : value1);
        return (uppercase? value.toUpperCase() : value);
    }

    /** 
     * return value of parameter called <b><i>name</i></b> in parameters <b><i>p</i></b>.<br>
     * Parameters could have two forms:<br> 
     * 1.- <b>[name]:[value]</b> where <b>value</b> is a <b>BigInteger</b>.<br>
     * 2.- <b>--[name]=[value]</b> where <b>value</b> is a <b>BigInteger</b>.<br>
     * If <b>value</b> is not a valid <b>BigInteger</b> or <b>name</b> is not found in <b><i>p</i></b>
     * the <b><i>defaultValue</i></b> is returned.<br>
     * 
     * @param p List of <a href="https://openjfx.io/javadoc/11/javafx.graphics/javafx/application/Application.Parameters.html" target="_blank"><b>Parameter</b></a> where we will find argument <b><i>name</i></b>
     * @param name Argument name searched in <b><i>p</i></b>
     * @param defaultValue value returned if <b>value</b> is not a valid <b>BigInteger</b> or <b>name</b> is not found in <b><i>p</i></b>
     * @return <a href="https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with value of argument <b><i>name</i></b> found 
     * or <b><i>defaultValue</i></b> if <b>value</b> is not a valid <b>String</b> or <b>name</b> is not found in <b><i>p</i></b>
     */
    public static BigInteger getParameter(Application.Parameters p, String name, BigInteger defaultValue) {
        if (p == null)
            return defaultValue;
        List<String> argsl = p.getUnnamed();
        String[] args = (argsl.size() > 0 ? argsl.toArray(new String[0]) : new String[0]);
        BigInteger value1 = InOut.getArgument(args, (BigInteger)null, name);
        String value2 = p.getNamed().get(name);
        BigInteger value = (value1 == null ? (value2 == null ? defaultValue : new BigInteger(value2)) : value1);
        return value;
    }
    
    /** 
     * return value of parameter called <b><i>name</i></b> in parameters <b><i>p</i></b>.<br>
     * Parameters could have two forms:<br> 
     * 1.- <b>[name]:[value]</b> where <b>value</b> is a <b>long</b>.<br>
     * 2.- <b>--[name]=[value]</b> where <b>value</b> is a <b>long</b>.<br>
     * If <b>value</b> is not a valid <b>long</b> or <b>name</b> is not found in <b><i>p</i></b>
     * the <b><i>defaultValue</i></b> is returned.<br>
     * 
     * @param p List of <a href="https://openjfx.io/javadoc/11/javafx.graphics/javafx/application/Application.Parameters.html" target="_blank"><b>Parameter</b></a> where we will find argument <b><i>name</i></b>
     * @param name Argument name searched in <b><i>p</i></b>
     * @param defaultValue value returned if <b>value</b> is not a valid <b>String</b> or <b>name</b> is not found in <b><i>p</i></b>
     * @return <a href="https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/lang/Long.html" target="_blank"><b>long</b></a> with value of argument <b><i>name</i></b> found 
     * or <b><i>defaultValue</i></b> if <b>value</b> is not a valid <b>String</b> or <b>name</b> is not found in <b><i>p</i></b>
     */
    public static long getParameter(Application.Parameters p, String name, long defaultValue) {
        if (p == null)
            return defaultValue;
        List<String> argsl = p.getUnnamed();
        String[] args = (argsl.size() > 0 ? argsl.toArray(new String[0]) : new String[0]);
        long value1 = InOut.getArgument(args, Long.MIN_VALUE, name);
        String value2 = p.getNamed().get(name);
        long value = (value1 == Long.MIN_VALUE ? (value2 == null ? defaultValue : Long.parseLong(value2)) : value1);
        return value;
    }
    
   /**
     * Convert a millisecond duration (<b><i>millis</i></b>) to a string format 
     * according to localization stored in <b><i>bundle</i></b>
     * 
     * @param millis A duration to convert to a string form
     * @param bundle Localized resources to use
     * @return A string with the format:
     * "X Days, Y Hours, Z Minutes, A Seconds, M Milliseconds"
     */
    public static String getDurationText(long millis, ResourceBundle bundle) {
        if (millis < 0) {
            throw new IllegalArgumentException("Negative duration is not allowed");
        }

        long days = TimeUnit.MILLISECONDS.toDays(millis);
        millis -= TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);
        millis -= TimeUnit.SECONDS.toMillis(seconds);

        StringBuilder sb = new StringBuilder(64);
        if (days > 0) {
            sb.append(days);
            sb.append(" ");
            if (days != 1)
                sb.append(bundle.getString("base.days"));
            else
                sb.append(bundle.getString("base.day"));
            sb.append(", ");
        }
        if (hours > 0 || days > 0) {
            sb.append(hours);
            sb.append(" ");
            if (hours != 1)
                sb.append(bundle.getString("base.hours"));
            else
                sb.append(bundle.getString("base.hour"));
            sb.append(", ");
        }
        if (minutes > 0 || hours > 0 || days > 0) {
            sb.append(minutes);
            sb.append(" ");
            if (minutes != 1)
                sb.append(bundle.getString("base.minutes"));
            else
                sb.append(bundle.getString("base.minute"));
            sb.append(", ");
        }
        if (seconds > 0 || minutes > 0 || hours > 0 || days > 0) {
            sb.append(seconds);
            sb.append(" ");
            if (seconds != 1)
                sb.append(bundle.getString("base.seconds"));
            else
                sb.append(bundle.getString("base.second"));
            sb.append(", ");
        }
        sb.append(millis);
        sb.append(" ");
        if (millis != 1)
            sb.append(bundle.getString("base.milliseconds"));
        else
            sb.append(bundle.getString("base.millisecond"));

        return sb.toString();
    }
}
