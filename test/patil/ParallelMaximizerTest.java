/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Preetam
 */
public class ParallelMaximizerTest {
    
    public ParallelMaximizerTest() {
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
     * Test of main method, of class ParallelMaximizer.
     */
   // @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        ParallelMaximizer.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of max method, of class ParallelMaximizer.
     */
    @Test
    public void testMax() throws Exception {
        int	threadCount = 10; // number of threads to run
 ParallelMaximizer maximizer = new ParallelMaximizer(threadCount);
	
	
		int size = 10000; // size of list
		LinkedList<Integer> list = new LinkedList<Integer>();
		Random rand = new Random();
		int serialMax = Integer.MIN_VALUE;
		int parallelMax = 0;
		// populate list with random elements
		for (int i=0; i<size; i++) {
			int next = rand.nextInt();
			list.add(next);
			serialMax = Math.max(serialMax, next); // compute serialMax
		}
		// try to find parallelMax
		try {
			parallelMax = maximizer.max(list);
		} catch (InterruptedException e) {
			e.printStackTrace();
			fail("The test failed because the max procedure was interrupted unexpectedly.");
		} catch (Exception e) {
			e.printStackTrace();
			fail("The test failed because the max procedure encountered a runtime error: " + e.getMessage());
		}
		
		assertEquals("The serial max doesn't match the parallel max", serialMax, parallelMax);
	}

    /**
     * Test of main method, of class ParallelMaximizer.
     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        
//        
//        String[] args = null;
//        ParallelMaximizer.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of main method, of class ParallelMaximizer.
     */
   
    /**
     * Test of main method, of class ParallelMaximizer.
     */
    
   
    }

    
    

