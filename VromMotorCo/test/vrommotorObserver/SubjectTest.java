/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vrommotorObserver;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vrommotorobserver.Observer;
import vrommotorobserver.Subject;

/**
 *
 * @author rodri
 */
public class SubjectTest {
    
    public SubjectTest() {
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
     * Test of addObserver method, of class Subject.
     */
    @Test
    public void testAddObserver() {
        System.out.println("addObserver");
        Observer observer = null;
        Subject instance = new Subject();
        instance.addObserver(observer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeObserver method, of class Subject.
     */
    @Test
    public void testRemoveObserver() {
        System.out.println("removeObserver");
        Observer observer = null;
        Subject instance = new Subject();
        instance.removeObserver(observer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of performImportantAction method, of class Subject.
     */
    @Test
    public void testPerformImportantAction() {
        System.out.println("performImportantAction");
        String message = "";
        Subject instance = new Subject();
        instance.performImportantAction(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
