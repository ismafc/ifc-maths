/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.math.BigInteger;
import java.util.Locale;
import java.util.ResourceBundle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ismael.flores
 */
public class InOutIT {

    private String[] args = null;
    
    public InOutIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        args = new String[] {"V1:3", "V2:5", "FROM:1", "BELOW:1000", "P:error", "BIG:18362781233492778327891"};
    }
    
    @After
    public void tearDown() {
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
     * Test of getDuration method, of class InOut.
     */
    @Test
    public void testGetDuration() {
        System.out.println("getDuration(long millis, ResourceBundle bundle)");
        Locale.setDefault(Locale.ENGLISH);
        ResourceBundle bundle = ResourceBundle.getBundle("resources/messages");
        long millis = 0L;
        String expResult = "0 Milliseconds";
        String result = InOut.getDuration(millis, bundle);
        assertEquals(expResult, result);

        millis = 2L * 1000L + 1L;
        expResult = "2 Seconds, 1 Millisecond";
        result = InOut.getDuration(millis, bundle);
        assertEquals(expResult, result);
        
        millis = 1L * 60L * 1000L + 5L * 1000L + 12L;
        expResult = "1 Minute, 5 Seconds, 12 Milliseconds";
        result = InOut.getDuration(millis, bundle);
        assertEquals(expResult, result);

        millis = 1L * 3600L * 1000L + 15L * 60L * 1000L;
        expResult = "1 Hour, 15 Minutes, 0 Seconds, 0 Milliseconds";
        result = InOut.getDuration(millis, bundle);
        assertEquals(expResult, result);
        
        millis = 28L * 3600L * 1000L + 3L * 60L * 1000L + 1L * 1000L + 123L;
        expResult = "1 Day, 4 Hours, 3 Minutes, 1 Second, 123 Milliseconds";
        result = InOut.getDuration(millis, bundle);
        assertEquals(expResult, result);
        
        millis = 48L * 3600L * 1000L + 12L * 1000L + 1L;
        expResult = "2 Days, 0 Hours, 0 Minutes, 12 Seconds, 1 Millisecond";
        result = InOut.getDuration(millis, bundle);
        assertEquals(expResult, result);
        
        Locale.setDefault(new Locale("es", "ES"));
        bundle = ResourceBundle.getBundle("resources/messages");
        millis = 0L;
        expResult = "0 Milisegundos";
        result = InOut.getDuration(millis, bundle);
        assertEquals(expResult, result);

        millis = 2L * 1000L + 1L;
        expResult = "2 Segundos, 1 Milisegundo";
        result = InOut.getDuration(millis, bundle);
        assertEquals(expResult, result);
        
        millis = 1L * 60L * 1000L + 5L * 1000L + 12L;
        expResult = "1 Minuto, 5 Segundos, 12 Milisegundos";
        result = InOut.getDuration(millis, bundle);
        assertEquals(expResult, result);

        millis = 1L * 3600L * 1000L + 15L * 60L * 1000L;
        expResult = "1 Hora, 15 Minutos, 0 Segundos, 0 Milisegundos";
        result = InOut.getDuration(millis, bundle);
        assertEquals(expResult, result);
        
        millis = 28L * 3600L * 1000L + 3L * 60L * 1000L + 1L * 1000L + 123L;
        expResult = "1 Día, 4 Horas, 3 Minutos, 1 Segundo, 123 Milisegundos";
        result = InOut.getDuration(millis, bundle);
        assertEquals(expResult, result);
        
        millis = 48L * 3600L * 1000L + 12L * 1000L + 1L;
        expResult = "2 Días, 0 Horas, 0 Minutos, 12 Segundos, 1 Milisegundo";
        result = InOut.getDuration(millis, bundle);
        assertEquals(expResult, result);
    }
    
}
