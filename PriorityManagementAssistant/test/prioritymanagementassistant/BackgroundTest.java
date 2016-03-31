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
        String expResult = "";
        String result = Background.getDestinationFolder();
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
        String path = "";
        Background.writeFile(path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFile method, of class Background.
     */
    @Test
    public void testIsFile() {
        System.out.println("isFile");
        boolean expResult = false;
        boolean result = Background.isFile();
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
        String s = "";
        Background.createBackgroundFile(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadList method, of class Background.
     */
    @Test
    public void testLoadList() throws Exception {
        System.out.println("loadList");
        String expResult = "";
        String result = Background.loadList();
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
        String build = "";
        Background.buildList(build);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printList method, of class Background.
     */
    @Test
    public void testPrintList() {
        System.out.println("printList");
        Background.printList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTask method, of class Background.
     */
    @Test
    public void testGetTask() {
        System.out.println("getTask");
        String s = "";
        boolean expResult = false;
        boolean result = Background.getTask(s);
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
        Background.removeOnLoad();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTask method, of class Background.
     */
    @Test
    public void testRemoveTask() {
        System.out.println("removeTask");
        String s = "";
        boolean expResult = false;
        boolean result = Background.removeTask(s);
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
        boolean expResult = false;
        boolean result = Background.isNull();
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
        Background.printWholeList();
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
     * Test of setTask method, of class Background.
     */
    @Test
    public void testSetTask() {
        System.out.println("setTask");
        String s = "";
        Background.setTask(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTime method, of class Background.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        int y = 0;
        int mo = 0;
        int d = 0;
        int h = 0;
        int mi = 0;
        Background.setTime(y, mo, d, h, mi);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPriority method, of class Background.
     */
    @Test
    public void testSetPriority() {
        System.out.println("setPriority");
        int p = 0;
        Background.setPriority(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeElement method, of class Background.
     */
    @Test
    public void testRemoveElement() {
        System.out.println("removeElement");
        Background.removeElement();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sort method, of class Background.
     */
    @Test
    public void testSort() {
        System.out.println("sort");
        Background.sort();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
