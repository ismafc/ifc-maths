/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author ismaf
 */
public class InOutNGTest {
    
    private String[] args = null;
    
    public InOutNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        args = new String[] {"V1:3", "V2:5", "FROM:1", "BELOW:1000", "P:error", "BIG:18362781233492778327891"};
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getArgument(String[] args, long default_value, String name) method, of class InOut.
     */
    @Test
    public void testGetArgument_3args_1() {
        System.out.println("getArgument(String[] args, long default_value, String name)");
        long default_value = -1L;
        String name = "V1";
        long expResult = 3L;
        long result = InOut.getArgument(args, default_value, name);
        assertEquals(expResult, result);

        name = "V2";
        expResult = 5L;
        result = InOut.getArgument(args, default_value, name);
        assertEquals(expResult, result);
        
        name = "FROM";
        expResult = 1L;
        result = InOut.getArgument(args, default_value, name);
        assertEquals(expResult, result);
        
        name = "BELOW";
        expResult = 1000L;
        result = InOut.getArgument(args, default_value, name);
        assertEquals(expResult, result);

        // Not found
        name = "V3";
        expResult = -1L;
        result = InOut.getArgument(args, default_value, name);
        assertEquals(expResult, result);
        
        // Invalid value
        name = "P";
        expResult = -1L;
        result = InOut.getArgument(args, default_value, name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getArgument(String[] args, BigInteger default_value, String name) method, of class InOut.
     */
    @Test
    public void testGetArgument_3args_2() {
        System.out.println("getArgument(String[] args, BigInteger default_value, String name)");
        BigInteger default_value = new BigInteger("-1");
        String name = "V1";
        BigInteger expResult = new BigInteger("3");
        BigInteger result = InOut.getArgument(args, default_value, name);
        assertEquals(expResult, result);

        name = "V2";
        expResult = new BigInteger("5");
        result = InOut.getArgument(args, default_value, name);
        assertEquals(expResult, result);
        
        name = "FROM";
        expResult = new BigInteger("1");
        result = InOut.getArgument(args, default_value, name);
        assertEquals(expResult, result);
        
        name = "BELOW";
        expResult = new BigInteger("1000");
        result = InOut.getArgument(args, default_value, name);
        assertEquals(expResult, result);

        // Not found
        name = "V3";
        expResult = new BigInteger("-1");
        result = InOut.getArgument(args, default_value, name);
        assertEquals(expResult, result);
        
        // Invalid value
        name = "P";
        expResult = new BigInteger("-1");
        result = InOut.getArgument(args, default_value, name);
        assertEquals(expResult, result);

        // Big Value
        name = "BIG";
        expResult = new BigInteger("18362781233492778327891");
        result = InOut.getArgument(args, default_value, name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDurationText(long millis, ResourceBundle bundle) method, of class InOut.
     */
    @Test
    public void testGetDurationText() {
        System.out.println("getDuration(long millis, ResourceBundle bundle)");
        Locale.setDefault(Locale.ENGLISH);
        ResourceBundle bundle = ResourceBundle.getBundle("resources/messages");
        long millis = 0L;
        String expResult = "0 Milliseconds";
        String result = InOut.getDurationText(millis, bundle);
        assertEquals(expResult, result);

        millis = 2L * 1000L + 1L;
        expResult = "2 Seconds, 1 Millisecond";
        result = InOut.getDurationText(millis, bundle);
        assertEquals(expResult, result);
        
        millis = 1L * 60L * 1000L + 5L * 1000L + 12L;
        expResult = "1 Minute, 5 Seconds, 12 Milliseconds";
        result = InOut.getDurationText(millis, bundle);
        assertEquals(expResult, result);

        millis = 1L * 3600L * 1000L + 15L * 60L * 1000L;
        expResult = "1 Hour, 15 Minutes, 0 Seconds, 0 Milliseconds";
        result = InOut.getDurationText(millis, bundle);
        assertEquals(expResult, result);
        
        millis = 28L * 3600L * 1000L + 3L * 60L * 1000L + 1L * 1000L + 123L;
        expResult = "1 Day, 4 Hours, 3 Minutes, 1 Second, 123 Milliseconds";
        result = InOut.getDurationText(millis, bundle);
        assertEquals(expResult, result);
        
        millis = 48L * 3600L * 1000L + 12L * 1000L + 1L;
        expResult = "2 Days, 0 Hours, 0 Minutes, 12 Seconds, 1 Millisecond";
        result = InOut.getDurationText(millis, bundle);
        assertEquals(expResult, result);
        
        Locale.setDefault(new Locale("es", "ES"));
        bundle = ResourceBundle.getBundle("resources/messages");
        millis = 0L;
        expResult = "0 Milisegundos";
        result = InOut.getDurationText(millis, bundle);
        assertEquals(expResult, result);

        millis = 2L * 1000L + 1L;
        expResult = "2 Segundos, 1 Milisegundo";
        result = InOut.getDurationText(millis, bundle);
        assertEquals(expResult, result);
        
        millis = 1L * 60L * 1000L + 5L * 1000L + 12L;
        expResult = "1 Minuto, 5 Segundos, 12 Milisegundos";
        result = InOut.getDurationText(millis, bundle);
        assertEquals(expResult, result);

        millis = 1L * 3600L * 1000L + 15L * 60L * 1000L;
        expResult = "1 Hora, 15 Minutos, 0 Segundos, 0 Milisegundos";
        result = InOut.getDurationText(millis, bundle);
        assertEquals(expResult, result);
        
        millis = 28L * 3600L * 1000L + 3L * 60L * 1000L + 1L * 1000L + 123L;
        expResult = "1 Día, 4 Horas, 3 Minutos, 1 Segundo, 123 Milisegundos";
        result = InOut.getDurationText(millis, bundle);
        assertEquals(expResult, result);
        
        millis = 48L * 3600L * 1000L + 12L * 1000L + 1L;
        expResult = "2 Días, 0 Horas, 0 Minutos, 12 Segundos, 1 Milisegundo";
        result = InOut.getDurationText(millis, bundle);
        assertEquals(expResult, result);
    }

    /**
     * Test of getListText(ArrayList<T> list, String inText) method, of class InOut.
     */
    @Test
    public void testGetListText() {
        System.out.println("getListText(ArrayList<T> list, String inText)");
        InOut<BigInteger> instance = new InOut<>();
        String inText = " + ";
        String expResult = "3 + 5 + 6";
        ArrayList<BigInteger> list = new ArrayList<>(Arrays.asList(new BigInteger("3"),
                                                                   new BigInteger("5"),
                                                                   new BigInteger("6")));
        String result = instance.getListText(list, inText);
        assertEquals(expResult, result);

        expResult = "14";
        list = new ArrayList<>(Arrays.asList(new BigInteger("14")));
        result = instance.getListText(list, inText);
        assertEquals(expResult, result);

        inText = ", ";
        expResult = "13, 26";
        list = new ArrayList<>(Arrays.asList(new BigInteger("13"),
                                             new BigInteger("26")));
        result = instance.getListText(list, inText);
        assertEquals(expResult, result);
    }

    /**
     * Test of getArgument(String[] args, String default_value, String name) method, of class InOut.
     */
    @Test
    public void testGetArgument_3args_3() {
        System.out.println("getArgument(String[] args, String default_value, String name)");
        String default_value = "-1";
        String name = "V1";
        String expResult = "3";
        String result = InOut.getArgument(args, default_value, name);
        assertEquals(expResult, result);

        name = "V2";
        expResult = "5";
        result = InOut.getArgument(args, default_value, name);
        assertEquals(expResult, result);
        
        name = "FROM";
        expResult = "1";
        result = InOut.getArgument(args, default_value, name);
        assertEquals(expResult, result);
        
        name = "BELOW";
        expResult = "1000";
        result = InOut.getArgument(args, default_value, name);
        assertEquals(expResult, result);

        // Not found
        name = "V3";
        expResult = "-1";
        result = InOut.getArgument(args, default_value, name);
        assertEquals(expResult, result);
        
        // Invalid value
        name = "P";
        expResult = "error";
        result = InOut.getArgument(args, default_value, name);
        assertEquals(expResult, result);

        // Big Value
        name = "BIG";
        expResult = "18362781233492778327891";
        result = InOut.getArgument(args, default_value, name);
        assertEquals(expResult, result);
    }
    
}
