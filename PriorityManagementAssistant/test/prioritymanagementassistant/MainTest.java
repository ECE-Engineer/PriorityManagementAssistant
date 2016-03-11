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
 *
 *
 *
 *
 *
 *
 *
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
import static org.junit.Assert.*;
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
