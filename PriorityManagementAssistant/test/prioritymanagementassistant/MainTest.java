/*
 * Test the Program Management Assistant Program and attempt to break the
 * program.
 * 
 *
 * Determine the amount of tests to run per method by
 * the amount of paramters + amount of conditionals + try / catch statements
 *
 *
 *
 * The methods for the Main.java class are private except for the main,
 * so I will be running the test program by the main method everytime.
 * I am also doing this because all the time variables are dependent on the
 * higher up time variables. (EX) getDay() needs to see the month you've
 * selected because the amount of days in each month vary. All the "TIME"
 * based methods except for the getYear() method would be affected in a
 * similar fashion.
 *
 *
 */

package prioritymanagementassistant;

import java.io.ByteArrayInputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
//import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Kyle Z
 */
public class MainTest {
    
    public MainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {//run on 1st init
        
    }
    
    @AfterClass
    public static void tearDownClass() {//runs after all tests
        
    }
    
    @Before
    public void setUp() {//runs before each method
        
    }
    
    @After
    public void tearDown() {//runs after each method
        
    }
    
    @Rule
    public ExpectedException exc = ExpectedException.none();

    @Test
    public void testSetPath(){
        String[] testInfo = {"C:\\Users\\Kyle Z\\Desktop\\no.txt\n",
                             "C:\\Users\\Kyle Z\\Desktop\\YES.txt\n",
                             "C:\\Users\\Kyle Z\\Desktop\n",       //this will cause the program to ask again
                             "C:\\Users\\Kyle Z\\Desktop\\MaYbE.txt\n",
                             "C:\\Users\\Kyle Z\\Desktop\\rirvuitibu.txt\n",
                             "C:\\Users\\Kyle Z\n",       //this will cause the program to ask again
                             "C:\\Users\\Kyle Z\\Foo\n",       //this will cause the program to ask again
                             "C:\\Users\\Kyle Z\\Desktop\\Bar WHAT.txt\n",
                             "C:\\Users\\Kyle Z\\FU_BAR\n"};       //this will cause the program to ask again
        ByteArrayInputStream input;
        for(String elements : testInfo){
            input = new ByteArrayInputStream(elements.getBytes());
            System.setIn(input);
            System.setIn(System.in);
        }
    }
    
    @Test
    public void testGetTask(){
        String[] testInfo = {"blah\n",
                             "hw\n",
                             "MEETING\n",
                             "Foo Bar\n",
                             "HeLlOwOrLd\n",
                             "     \n",
                             "---\n",       //this will cause the program to ask again
                             "6879786b5986v475\n",
                             "*(^&RV HGHUYF\n",
                             "%E&*$V&*^%V(**B)\n"};
        ByteArrayInputStream input;
        for(String elements : testInfo){
            input = new ByteArrayInputStream(elements.getBytes());
            System.setIn(input);
            System.setIn(System.in);
        }
    }
    
    @Test
    public void testGetYear(){
        String[] testInfo = {"1253\n",
                             " \n",
                             "3540\n",
                             "11\n",
                             "2016\n",
                             "7\n",
                             "2017\n",
                             "4\n",
                             "3\n"};
        ByteArrayInputStream input;
        for(String elements : testInfo){
            input = new ByteArrayInputStream(elements.getBytes());
            System.setIn(input);
            System.setIn(System.in);
        }
    }
    
    @Test
    public void testGetMonth(){
        String[] testInfo = {"12\n",
                             " \n",
                             "324\n",
                             "11\n",
                             "3\n",
                             "7\n",
                             "gdf\n",
                             "4\n",
                             "3\n"};
        ByteArrayInputStream input;
        for(String elements : testInfo){
            input = new ByteArrayInputStream(elements.getBytes());
            System.setIn(input);
            System.setIn(System.in);
        }
    }
    
    @Test
    public void testGetDay(){
        String[] testInfo = {"12\n",
                             " \n",
                             "30\n",
                             "11\n",
                             "3\n",
                             "7\n",
                             "31\n",
                             "4\n",
                             "3\n"};
        ByteArrayInputStream input;
        for(String elements : testInfo){
            input = new ByteArrayInputStream(elements.getBytes());
            System.setIn(input);
            System.setIn(System.in);
        }
    }
    
    @Test
    public void testGetHour(){
        String[] testInfo = {"12\n",
                             " \n",
                             "30\n",
                             "11\n",
                             "3\n",
                             "7\n",
                             "31\n",
                             "24\n",
                             "23\n"};
        ByteArrayInputStream input;
        for(String elements : testInfo){
            input = new ByteArrayInputStream(elements.getBytes());
            System.setIn(input);
            System.setIn(System.in);
        }
    }
    @Test
    public void testGetMinute(){
        String[] testInfo = {"56\n",
                             " \n",
                             "30\n",
                             "11\n",
                             "300\n",
                             "7\n",
                             "31\n",
                             "4\n",
                             "3\n"};
        ByteArrayInputStream input;
        for(String elements : testInfo){
            input = new ByteArrayInputStream(elements.getBytes());
            System.setIn(input);
            System.setIn(System.in);
        }
    }
    
    @Test
    public void testGetPriority(){
        String[] testInfo = {"C:\\Users\\Kyle Z\\Desktop\\testFile.txt\n",
                             "C:\\Users\\Kyle Z\\Desktop\\testFile.txt\n",
                             "C:\\Users\\Kyle Z\\Desktop\\testFile.txt\n",
                             "C:\\Users\\Kyle Z\\Desktop\\testFile.txt\n",
                             "C:\\Users\\Kyle Z\\Desktop\\testFile.txt\n",
                             "C:\\Users\\Kyle Z\\Desktop\\testFile.txt\n",
                             "C:\\Users\\Kyle Z\\Desktop\\testFile.txt\n",
                             "C:\\Users\\Kyle Z\\Desktop\\testFile.txt\n",
                             "C:\\Users\\Kyle Z\\Desktop\\testFile.txt\n",};
        ByteArrayInputStream input;
        for(String elements : testInfo){
            input = new ByteArrayInputStream(elements.getBytes());
            System.setIn(input);
            System.setIn(System.in);
        }
    }
    
    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testMain() {
        String[] testInfo = {"y\nmeeting\n2016\n03\n24\n23\n59\nC:\\Users\\Kyle Z\\Desktop\\testFile.txt\ny\n",
                             "y\nmathHW\n2016\n03\n31\n23\n59\nC:\\Users\\Kyle Z\\Desktop\\testFile.txt\ny\n",
                             "y\ncscHW\n2016\n03\n25\n23\n59\nC:\\Users\\Kyle Z\\Desktop\\testFile.txt\ny\n",
                             "y\neceHW\n2016\n04\n09\n23\n59\nC:\\Users\\Kyle Z\\Desktop\\testFile.txt\ny\n",
                             "y\neceEXAM\n2016\n05\n09\n23\n59\nC:\\Users\\Kyle Z\\Desktop\\testFile.txt\ny\n",
                             "y\nmeeting\n2016\n06\n09\n23\n59\nC:\\Users\\Kyle Z\\Desktop\\testFile.txt\ny\n",
                             "y\nmeeting\n2016\n07\n09\n23\n59\nC:\\Users\\Kyle Z\\Desktop\\testFile.txt\ny\n",
                             "y\nfacebook_just_kidding\n2016\n07\n09\n23\n59\nC:\\Users\\Kyle Z\\Desktop\\testFile.txt\ny\n",
                             "y\nblah_IDK\n2016\n08\n09\n23\n59\nC:\\Users\\Kyle Z\\Desktop\\testFile.txt\ny\n"};
        
        ByteArrayInputStream input;
        for(String elements : testInfo){
            input = new ByteArrayInputStream(elements.getBytes());
            System.setIn(input);
            System.setIn(System.in);
        }
        
        // do your thing

        // optionally, reset System.in to its original
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
