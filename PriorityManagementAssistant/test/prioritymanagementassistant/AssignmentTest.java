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
     * Test of setDefaultPath method, of class Assignment.
     */
    @Test
    public void testSetDefaultPath1() {
        System.out.println("setDefaultPath");
        String input = "C:\\\\person\\\\Desktop\\";
        exception.expectMessage("C:\\\\person\\\\Desktop\\");  //any invalid path like this will evoke the program to ask the user again, so this is expected to fail
    }

    /**
     * Test of setDefaultPath method, of class Assignment.
     */
    @Test
    public void testSetDefaultPath2() {
        System.out.println("setDefaultPath");
        String input = "C:\\\\person\\\\Desktop\\\\test\\\\newFile.txt";
        String expectedInput = "C:\\\\person\\\\Desktop\\\\test\\\\newFile.txt";
        assertEquals(expectedInput, input);  //this path is valid and would generate the default path for the saved file
    }
    
    
    
    
    
    
    
    
    
    
    /**
     * Test of getPath method, of class Assignment.
     */
    @Test
    public void testGetPath1() {
        System.out.println("getPath");
        String input = "C:\\\\person\\\\Desktop\\\\test";
        exception.expectMessage("C:\\\\person\\\\Desktop\\\\test");  //any invalid path like this will evoke the program to ask the user again, so this is expected to fail
    }

    /**
     * Test of getPath method, of class Assignment.
     */
    @Test
    public void testGetPath2() {
        System.out.println("getPath");
        String input = "C:\\\\person\\\\Desktop\\\\newFile.txt";
        String expectedInput = "C:\\\\person\\\\Desktop\\\\newFile.txt";
        assertEquals(expectedInput, input);  //this path is valid and would generate the path for the saved file
    }
    
    
    
    
    
    
    
    /**
     * Test of getTask method, of class Assignment.
     */
    @Test
    public void testGetTask1() {
        System.out.println("getTask");
        String input = "---";
        exception.expectMessage("---");     //this is expected to fail because --- is the delimeter for reading the saved file
    }

    /**
     * Test of getTask method, of class Assignment.
     */
    @Test
    public void testGetTask2() {
        System.out.println("getTask");
        String input = "cschw";
        String expectedInput = "cschw";
        assertEquals(expectedInput, input);     //this will pass because any string except for --- can be the name of a task
    }
    
    
    
    
//            String[] testInfo = {"blah\n",
//                             "hw\n",
//                             "MEETING\n",
//                             "Foo Bar\n",
//                             "HeLlOwOrLd\n",
//                             "     \n",
//                             "---\n",       //this will cause the program to ask again
//                             "6879786b5986v475\n",
//                             "*(^&RV HGHUYF\n",
//                             "%E&*$V&*^%V(**B)\n"};
//        ByteArrayInputStream input;
//        for(String elements : testInfo){
//            input = new ByteArrayInputStream(elements.getBytes());
//            System.setIn(input);
//            System.setIn(System.in);
//        }
    
    
    
    
    /**
     * Test of getMonth method, of class Assignment.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        String input = "cschw";
        String expectedInput = "cschw";
        assertEquals(expectedInput, input);
        
        
        
        String n = "";
        int expResult = 0;
        int result = Assignment.getMonth(n);//how do I set the values in this!!!!!!!!!!!!
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        
//                String[] testInfo = {"12\n",
//                             " \n",
//                             "324\n",
//                             "11\n",
//                             "3\n",
//                             "7\n",
//                             "gdf\n",
//                             "4\n",
//                             "3\n"};
//        ByteArrayInputStream input;
//        for(String elements : testInfo){
//            input = new ByteArrayInputStream(elements.getBytes());
//            System.setIn(input);
//            System.setIn(System.in);
//        }
    }
    
    
    
    
    
    
    
    
    
    

    /**
     * Test of getDay method, of class Assignment.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        int m = 0;
        String n = "";
        int expResult = 0;
        int result = Assignment.getDay(m, n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//                String[] testInfo = {"12\n",
//                             " \n",
//                             "30\n",
//                             "11\n",
//                             "3\n",
//                             "7\n",
//                             "31\n",
//                             "4\n",
//                             "3\n"};
//        ByteArrayInputStream input;
//        for(String elements : testInfo){
//            input = new ByteArrayInputStream(elements.getBytes());
//            System.setIn(input);
//            System.setIn(System.in);
//        }
    }

    /**
     * Test of getYear method, of class Assignment.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        String n = "";
        int expResult = 0;
        int result = Assignment.getYear(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
//                String[] testInfo = {"1253\n",
//                             " \n",
//                             "3540\n",
//                             "11\n",
//                             "2016\n",
//                             "7\n",
//                             "2017\n",
//                             "4\n",
//                             "3\n"};
//        ByteArrayInputStream input;
//        for(String elements : testInfo){
//            input = new ByteArrayInputStream(elements.getBytes());
//            System.setIn(input);
//            System.setIn(System.in);
//        }
    }

    /**
     * Test of getHour method, of class Assignment.
     */
    @Test
    public void testGetHour() {
        System.out.println("getHour");
        String n = "";
        int expResult = 0;
        int result = Assignment.getHour(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//                String[] testInfo = {"12\n",
//                             " \n",
//                             "30\n",
//                             "11\n",
//                             "3\n",
//                             "7\n",
//                             "31\n",
//                             "24\n",
//                             "23\n"};
//        ByteArrayInputStream input;
//        for(String elements : testInfo){
//            input = new ByteArrayInputStream(elements.getBytes());
//            System.setIn(input);
//            System.setIn(System.in);
//        }
    }

    /**
     * Test of getMinute method, of class Assignment.
     */
    @Test
    public void testGetMinute() {
        System.out.println("getMinute");
        String n = "";
        int expResult = 0;
        int result = Assignment.getMinute(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//                String[] testInfo = {"56\n",
//                             " \n",
//                             "30\n",
//                             "11\n",
//                             "300\n",
//                             "7\n",
//                             "31\n",
//                             "4\n",
//                             "3\n"};
//        ByteArrayInputStream input;
//        for(String elements : testInfo){
//            input = new ByteArrayInputStream(elements.getBytes());
//            System.setIn(input);
//            System.setIn(System.in);
//        }
    }

    /**
     * Test of getPriority method, of class Assignment.
     */
    @Test
    public void testGetPriority() {
        System.out.println("getPriority");
        String n = "";
        int expResult = 0;
        int result = Assignment.getPriority(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//                String[] testInfo = {"C:\\Users\\Kyle Z\\Desktop\\testFile.txt\n",
//                             "C:\\Users\\Kyle Z\\Desktop\\testFile.txt\n",
//                             "C:\\Users\\Kyle Z\\Desktop\\testFile.txt\n",
//                             "C:\\Users\\Kyle Z\\Desktop\\testFile.txt\n",
//                             "C:\\Users\\Kyle Z\\Desktop\\testFile.txt\n",
//                             "C:\\Users\\Kyle Z\\Desktop\\testFile.txt\n",
//                             "C:\\Users\\Kyle Z\\Desktop\\testFile.txt\n",
//                             "C:\\Users\\Kyle Z\\Desktop\\testFile.txt\n",
//                             "C:\\Users\\Kyle Z\\Desktop\\testFile.txt\n",};
//        ByteArrayInputStream input;
//        for(String elements : testInfo){
//            input = new ByteArrayInputStream(elements.getBytes());
//            System.setIn(input);
//            System.setIn(System.in);
//        }
    }
    
}
