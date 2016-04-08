/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prioritymanagementassistant;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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

    /**
     * Test of getDestinationFolder method, of class Background.
     */
    @Test
    public void testGetDestinationFolder() {
        System.out.println("getDestinationFolder");
        Assignment a = new Assignment("test", 5, 5, 2017, 24, 59, 3, false);
        Background b = new Background();
        
        String expResult = "";
        String result = b.getDestinationFolder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeFile method, of class Background.
     */
    @Test
    public void testWriteFile() throws Exception {
        System.out.println("writeFile");
        Assignment a = new Assignment("test", 5, 5, 2017, 24, 59, 3, false);
        Background b = new Background();
        String path = "";
        b.writeFile(path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFile method, of class Background.
     */
    @Test
    public void testIsFile() {
        System.out.println("isFile");
        Assignment a = new Assignment("test", 5, 5, 2017, 24, 59, 3, false);
        Background b = new Background();
        boolean expResult = false;
        boolean result = b.isFile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createBackgroundFile method, of class Background.
     */
    @Test
    public void testCreateBackgroundFile() throws Exception {
        System.out.println("createBackgroundFile");
        Assignment a = new Assignment("test", 5, 5, 2017, 24, 59, 3, false);
        Background b = new Background();
        String s = "";
        b.createBackgroundFile(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadList method, of class Background.
     */
    @Test
    public void testLoadList() throws Exception {
        System.out.println("loadList");
        Assignment a = new Assignment("test", 5, 5, 2017, 24, 59, 3, false);
        Background b = new Background();
        String expResult = "";
        String result = b.loadList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buildList method, of class Background.
     */
    @Test
    public void testBuildList() {
        System.out.println("buildList");
        Assignment a = new Assignment("test", 5, 5, 2017, 24, 59, 3, false);
        Background b = new Background();
        String build = "";
        b.buildList(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printList method, of class Background.
     */
    @Test
    public void testPrintList() {
        System.out.println("printList");
        Assignment a = new Assignment("test", 5, 5, 2017, 24, 59, 3, false);
        Background b = new Background();
        b.printList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaskInfo method, of class Background.
     */
    @Test
    public void testGetTaskInfo() {
        System.out.println("getTaskInfo");
        Assignment a = new Assignment("test", 5, 5, 2017, 24, 59, 3, false);
        Background b = new Background();
        String s = "";
        boolean expResult = false;
        boolean result = b.getTaskInfo(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeOnLoad method, of class Background.
     */
    @Test
    public void testRemoveOnLoad() {
        System.out.println("removeOnLoad");
        Assignment a = new Assignment("test", 5, 5, 2017, 24, 59, 3, false);
        Background b = new Background();
        b.removeOnLoad();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTask method, of class Background.
     */
    @Test
    public void testRemoveTask() {
        System.out.println("removeTask");
        Assignment a = new Assignment("test", 5, 5, 2017, 24, 59, 3, false);
        Background b = new Background();
        String s = "";
        boolean expResult = false;
        boolean result = b.removeTask(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNull method, of class Background.
     */
    @Test
    public void testIsNull() {
        System.out.println("isNull");
        Assignment a = new Assignment("test", 5, 5, 2017, 24, 59, 3, false);
        Background b = new Background();
        boolean expResult = false;
        boolean result = b.isNull();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printWholeList method, of class Background.
     */
    @Test
    public void testPrintWholeList() {
        System.out.println("printWholeList");
        Assignment a = new Assignment("test", 5, 5, 2017, 24, 59, 3, false);
        Background b = new Background();
        b.printWholeList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        
    }

    /**
     * Test of isAssignmentPresent method, of class Background.
     */
    @Test
    public void testIsAssignmentPresent() {
        System.out.println("isAssignmentPresent");
        String s = "";
        boolean expResult = false;
        boolean result = Background.isAssignmentPresent(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sort method, of class Background.
     */
    @Test
    public void testSort() {
        System.out.println("sort");
        Assignment a = new Assignment("test", 5, 5, 2017, 24, 59, 3, false);
        Background b = new Background();
        b.sort();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
