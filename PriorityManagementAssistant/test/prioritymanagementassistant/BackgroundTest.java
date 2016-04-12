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
public class BackgroundTest {
    
    public BackgroundTest() {
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
     * Test of getDestinationFolder method, of class Background.
     */
    @Test
    public void testGetDestinationFolder() {
        Background instance = new Background();
        instance.filePath = "C:\\Users\\Kyle Z\\Desktop\\test.txt";
        String expResult = "Desktop";
        
        try {
            assertEquals(expResult, instance.getDestinationFolder());
            //Assert.fail( "Should have thrown an exception" );
        } 
        catch (Exception e) {
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        }   
    }

    /**
     * Test of writeFile method, of class Background.
     */
    @Test
    public void testWriteFile() throws Exception {
        String path = "C:\\Users\\Kyle Z\\Documents\\runPMA.txt";
        Background instance = new Background();
        instance.writeFile(path);
        boolean expResult = true;
        
        try {
            assertEquals(expResult, instance.isFile());
            //Assert.fail( "Should have thrown an exception" );
        } 
        catch (Exception e) {
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        } 
    }
    
    /**
     * Test of isFile method, of class Background.
     */
    @Test
    public void testIsFile() {
        Background instance = new Background();
        boolean expResult = true;
        
        try {
            assertEquals(expResult, instance.isFile());
            //Assert.fail( "Should have thrown an exception" );
        } 
        catch (Exception e) {
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        } 
    }

    /**
     * Test of createBackgroundFile method, of class Background.
     */
    @Test
    public void testCreateBackgroundFile() throws Exception {
        Background instance = new Background();
        String s = "C:\\Users\\Kyle Z\\Documents\\runPMA.txt";
        instance.filePath = "C:\\Users\\Kyle Z\\Documents\\runPMA.txt";
        instance.createBackgroundFile(s);
        boolean expResult = true;
        boolean result;
        if(instance.isFile() && (instance.getDestinationFolder().equals("Documents"))){
            result = true;
        }else{
            result = false;
        }
        
        try {
            assertEquals(expResult, result);
            //Assert.fail( "Should have thrown an exception" );
        } 
        catch (Exception e) {
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        } 
    }

    /**
     * Test of createBatchFile method, of class Background.
     */
    @Test
    public void testCreateBatchFile() throws Exception {
        Background instance = new Background();
        
        try {
            instance.createBatchFile();
            //Assert.fail( "Should have thrown an exception" );
            Assert.assertTrue(true);
        } 
        catch (Exception e) {
            Assert.fail( "Should have thrown an exception" );
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        } 
    }

    /**
     * Test of loadList method, of class Background.
     */
    @Test
    public void testLoadList() throws Exception {
        Background instance = new Background();
        
        try {
            instance.loadList();
            //Assert.fail( "Should have thrown an exception" );
            Assert.assertTrue(true);
        } 
        catch (Exception e) {
            Assert.fail( "Should have thrown an exception" );
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        } 
    }

    /**
     * Test of buildList method, of class Background.
     */
    @Test
    public void testBuildList() {
        Assignment test = new Assignment("test1", 4, 20, 2016, 13, 59, 2, false);
        Background instance = new Background();
        
        try {
            instance.buildList(test);
            //Assert.fail( "Should have thrown an exception" );
            Assert.assertTrue(true);
        } 
        catch (Exception e) {
            Assert.fail( "Should have thrown an exception" );
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        } 
    }

    /**
     * Test of printList method, of class Background.
     */
    @Test
    public void testPrintList() {
        Background instance = new Background();
        
        try {
            instance.printList();
            //Assert.fail( "Should have thrown an exception" );
            Assert.assertTrue(true);
        } 
        catch (Exception e) {
            Assert.fail( "Should have thrown an exception" );
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        } 
    }

    /**
     * Test of getTaskInfo method, of class Background.
     */
    @Test
    public void testGetTaskInfo() {
        Assignment test = new Assignment("test1", 4, 20, 2016, 13, 59, 2, false);
        Background instance = new Background();
        
        instance.list.add(test);
        
        try {
            instance.getTaskInfo("test1");
            //Assert.fail( "Should have thrown an exception" );
            Assert.assertTrue(true);
        } 
        catch (Exception e) {
            Assert.fail( "Should have thrown an exception" );
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        } 
    }

    /**
     * Test of removeOnLoad method, of class Background.
     */
    @Test
    public void testRemoveOnLoad() {
        Background instance = new Background();
        
        try {
            instance.removeOnLoad();
            //Assert.fail( "Should have thrown an exception" );
            Assert.assertTrue(true);
        } 
        catch (Exception e) {
            Assert.fail( "Should have thrown an exception" );
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        }
    }

    /**
     * Test of removeTask method, of class Background.
     */
    @Test
    public void testRemoveTask() {
        Assignment test = new Assignment("test1", 4, 20, 2016, 13, 59, 2, false);
        Background instance = new Background();
        
        instance.list.add(test);
        
        try {
            instance.removeTask("test1");
            //Assert.fail( "Should have thrown an exception" );
            Assert.assertTrue(true);
        } 
        catch (Exception e) {
            Assert.fail( "Should have thrown an exception" );
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        } 
    }

    /**
     * Test of enableAllPopups method, of class Background.
     */
    @Test
    public void testEnableAllPopups() {
        Background instance = new Background();
        
        try {
            instance.enableAllPopups();
            //Assert.fail( "Should have thrown an exception" );
            Assert.assertTrue(true);
        } 
        catch (Exception e) {
            Assert.fail( "Should have thrown an exception" );
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        }
    }

    /**
     * Test of disableAllPopups method, of class Background.
     */
    @Test
    public void testDisableAllPopups() {
        Background instance = new Background();
        
        try {
            instance.disableAllPopups();
            //Assert.fail( "Should have thrown an exception" );
            Assert.assertTrue(true);
        } 
        catch (Exception e) {
            Assert.fail( "Should have thrown an exception" );
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        }
    }

    /**
     * Test of isNull method, of class Background.
     */
    @Test
    public void testIsNull() {
        Background instance = new Background();
        
        try {
            instance.isNull();
            //Assert.fail( "Should have thrown an exception" );
            Assert.assertTrue(true);
        } 
        catch (Exception e) {
            Assert.fail( "Should have thrown an exception" );
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        }
    }

    /**
     * Test of printListDetails method, of class Background.
     */
    @Test
    public void testPrintListDetails() {
        Background instance = new Background();
        
        try {
            instance.printListDetails();
            //Assert.fail( "Should have thrown an exception" );
            Assert.assertTrue(true);
        } 
        catch (Exception e) {
            Assert.fail( "Should have thrown an exception" );
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        }
    }

    /**
     * Test of isAssignmentPresent method, of class Background.
     */
    @Test
    public void testIsAssignmentPresent() {
        Assignment test = new Assignment("test1", 4, 20, 2016, 13, 59, 2, false);
        Background instance = new Background();
        instance.list.add(test);
        
        try {
            //Assert.fail( "Should have thrown an exception" );
            assertEquals(true, instance.isAssignmentPresent("test1"));
        } 
        catch (Exception e) {
            Assert.fail( "Should have thrown an exception" );
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        } 
    }

    /**
     * Test of getAssignment method, of class Background.
     */
    @Test
    public void testGetAssignment() {
        Assignment test = new Assignment("test1", 4, 20, 2016, 13, 59, 2, false);
        Background instance = new Background();
        instance.list.add(test);
        instance.isAssignmentPresent("test1");
        
        try {
            //Assert.fail( "Should have thrown an exception" );
            assertEquals(test, instance.getAssignment());
        } 
        catch (Exception e) {
            Assert.fail( "Should have thrown an exception" );
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        } 
    }

    /**
     * Test of sort method, of class Background.
     */
    @Test
    public void testSort() {
        Assignment test = new Assignment("test1", 4, 20, 2016, 13, 59, 2, false);
        Background instance = new Background();
        instance.list.add(test);
        
        try {
            instance.sort();
            //Assert.fail( "Should have thrown an exception" );
            Assert.assertTrue(true);
        } 
        catch (Exception e) {
            Assert.fail( "Should have thrown an exception" );
            String expectedMessage = "this is the message I expect to get";
            Assert.assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
        } 
    }
    
}
