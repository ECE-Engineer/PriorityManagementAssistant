/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    * For Expecting Exceptions
    */
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testMain() throws Exception {
//        System.out.println("main");
//        String[] args = {"y\nmeeting\n2016\n03\n24\n23\n59\nC:\\Users\\Kyle Z\\Desktop\\testFile.txt\ny\n",
//                             "y\nmathHW\n2016\n03\n31\n23\n59\nC:\\Users\\Kyle Z\\Desktop\\testFile.txt\ny\n",
//                             "y\ncscHW\n2016\n03\n25\n23\n59\nC:\\Users\\Kyle Z\\Desktop\\testFile.txt\ny\n",
//                             "y\neceHW\n2016\n04\n09\n23\n59\nC:\\Users\\Kyle Z\\Desktop\\testFile.txt\ny\n",
//                             "y\neceEXAM\n2016\n05\n09\n23\n59\nC:\\Users\\Kyle Z\\Desktop\\testFile.txt\ny\n",
//                             "y\nmeeting\n2016\n06\n09\n23\n59\nC:\\Users\\Kyle Z\\Desktop\\testFile.txt\ny\n",
//                             "y\nmeeting\n2016\n07\n09\n23\n59\nC:\\Users\\Kyle Z\\Desktop\\testFile.txt\ny\n",
//                             "y\nfacebook_just_kidding\n2016\n07\n09\n23\n59\nC:\\Users\\Kyle Z\\Desktop\\testFile.txt\ny\n",
//                             "y\nblah_IDK\n2016\n08\n09\n23\n59\nC:\\Users\\Kyle Z\\Desktop\\testFile.txt\ny\n"};
        
        
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
                //Main.main(new String[]{});
                System.setIn(input);
                System.setIn(System.in);
                //System.out.print("testinfo n\n");
        }
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
