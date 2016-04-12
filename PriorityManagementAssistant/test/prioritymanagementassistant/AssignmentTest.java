/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prioritymanagementassistant;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Kyle Z
 */
public class AssignmentTest {
    
    public AssignmentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    /**
     * Test of getName method, of class Assignment.
     */
    @Test
    public void testGetName() {
        Assignment instance = new Assignment("test1", 4, 20, 2016, 13, 59, 2, false);
        String expResult = "test1";
        assertEquals(expResult, instance.getName());
        try {
            assertEquals(expResult, instance.getName());
            //Assert.fail( "Should have thrown an exception" );
        } 
        catch (Exception e) {
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        }   
    }

    /**
     * Test of setName method, of class Assignment.
     */
    @Test
    public void testSetName() {
        Assignment instance = new Assignment("test1", 4, 20, 2016, 13, 59, 2, false);
        String expResult = "test1.1";
        instance.setName("test1.1");
        
        try {
            assertEquals(expResult, instance.getName());
            //Assert.fail( "Should have thrown an exception" );
        } 
        catch (Exception e) {
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        }   
    }

    /**
     * Test of getMonth method, of class Assignment.
     */
    @Test
    public void testGetMonth() {
        Assignment instance = new Assignment("test1", 4, 20, 2016, 13, 59, 2, false);
        int expResult = 4;
        
        try {
            assertEquals(expResult, instance.getMonth());
            //Assert.fail( "Should have thrown an exception" );
        } 
        catch (Exception e) {
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        }  
    }

    /**
     * Test of setMonth method, of class Assignment.
     */
    @Test
    public void testSetMonth() {
        Assignment instance = new Assignment("test1", 4, 20, 2016, 13, 59, 2, false);
        int expResult = 5;
        instance.setMonth(5);
        
        try {
            assertEquals(expResult, instance.getMonth());
            //Assert.fail( "Should have thrown an exception" );
        } 
        catch (Exception e) {
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        }  
    }

    /**
     * Test of getDay method, of class Assignment.
     */
    @Test
    public void testGetDay() {
        Assignment instance = new Assignment("test1", 4, 20, 2016, 13, 59, 2, false);
        int expResult = 20;
        
        try {
            assertEquals(expResult, instance.getDay());
            //Assert.fail( "Should have thrown an exception" );
        } 
        catch (Exception e) {
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        } 
    }

    /**
     * Test of setDay method, of class Assignment.
     */
    @Test
    public void testSetDay() {
        Assignment instance = new Assignment("test1", 4, 20, 2016, 13, 59, 2, false);
        int expResult = 21;
        instance.setDay(21);
        
        try {
            assertEquals(expResult, instance.getDay());
            //Assert.fail( "Should have thrown an exception" );
        } 
        catch (Exception e) {
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        }
    }

    /**
     * Test of getYear method, of class Assignment.
     */
    @Test
    public void testGetYear() {
        Assignment instance = new Assignment("test1", 4, 20, 2016, 13, 59, 2, false);
        int expResult = 2016;
        
        try {
            assertEquals(expResult, instance.getYear());
            //Assert.fail( "Should have thrown an exception" );
        } 
        catch (Exception e) {
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        } 
    }

    /**
     * Test of setYear method, of class Assignment.
     */
    @Test
    public void testSetYear() {
        Assignment instance = new Assignment("test1", 4, 20, 2016, 13, 59, 2, false);
        int expResult = 2017;
        instance.setYear(2017);
        
        try {
            assertEquals(expResult, instance.getYear());
            //Assert.fail( "Should have thrown an exception" );
        } 
        catch (Exception e) {
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        }
    }

    /**
     * Test of getHour method, of class Assignment.
     */
    @Test
    public void testGetHour() {
        Assignment instance = new Assignment("test1", 4, 20, 2016, 13, 59, 2, false);
        int expResult = 13;
        
        try {
            assertEquals(expResult, instance.getHour());
            //Assert.fail( "Should have thrown an exception" );
        } 
        catch (Exception e) {
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        }
    }

    /**
     * Test of setHour method, of class Assignment.
     */
    @Test
    public void testSetHour() {
        Assignment instance = new Assignment("test1", 4, 20, 2016, 13, 59, 2, false);
        int expResult = 14;
        instance.setHour(14);
        
        try {
            assertEquals(expResult, instance.getHour());
            //Assert.fail( "Should have thrown an exception" );
        } 
        catch (Exception e) {
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        }
    }

    /**
     * Test of getMinute method, of class Assignment.
     */
    @Test
    public void testGetMinute() {
        Assignment instance = new Assignment("test1", 4, 20, 2016, 13, 59, 2, false);
        int expResult = 59;
        
        try {
            assertEquals(expResult, instance.getMinute());
            //Assert.fail( "Should have thrown an exception" );
        } 
        catch (Exception e) {
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        }
    }

    /**
     * Test of setMinute method, of class Assignment.
     */
    @Test
    public void testSetMinute() {
        Assignment instance = new Assignment("test1", 4, 20, 2016, 13, 59, 2, false);
        int expResult = 45;
        instance.setMinute(45);
        
        try {
            assertEquals(expResult, instance.getMinute());
            //Assert.fail( "Should have thrown an exception" );
        } 
        catch (Exception e) {
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        }
    }

    /**
     * Test of getPriority method, of class Assignment.
     */
    @Test
    public void testGetPriority() {
        Assignment instance = new Assignment("test1", 4, 20, 2016, 13, 59, 2, false);
        int expResult = 2;
        
        try {
            assertEquals(expResult, instance.getPriority());
            //Assert.fail( "Should have thrown an exception" );
        } 
        catch (Exception e) {
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        }
    }

    /**
     * Test of setPriority method, of class Assignment.
     */
    @Test
    public void testSetPriority() {
        Assignment instance = new Assignment("test1", 4, 20, 2016, 13, 59, 2, false);
        int expResult = 3;
        instance.setPriority(3);
        
        try {
            assertEquals(expResult, instance.getPriority());
            //Assert.fail( "Should have thrown an exception" );
        } 
        catch (Exception e) {
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        }
    }

    /**
     * Test of getPopup method, of class Assignment.
     */
    @Test
    public void testGetPopup() {
        Assignment instance = new Assignment("test1", 4, 20, 2016, 13, 59, 2, false);
        boolean expResult = false;
        
        try {
            assertEquals(expResult, instance.getPopup());
            //Assert.fail( "Should have thrown an exception" );
        } 
        catch (Exception e) {
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        }
    }

    /**
     * Test of setPopup method, of class Assignment.
     */
    @Test
    public void testSetPopup() {
        Assignment instance = new Assignment("test1", 4, 20, 2016, 13, 59, 2, false);
        boolean expResult = true;
        instance.setPopup(true);
        
        try {
            assertEquals(expResult, instance.getPopup());
            //Assert.fail( "Should have thrown an exception" );
        } 
        catch (Exception e) {
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        }
    }
    
}
