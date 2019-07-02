/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.math.BigInteger;
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
    
}
