/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patil;

import java.lang.reflect.Field;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Preetam
 */
public class ParallelMaximizer {

    int numThreads;
    int workersThread;
    ArrayList<ParallelMaximizerWorker> workers; // = new ArrayList<ParallelMaximizerWorker>(numThreads);

    public ParallelMaximizer(int numThreads) {
        
         workers = new ArrayList<ParallelMaximizerWorker>(numThreads);
         this.numThreads = numThreads;
    }

    public static void main(String[] args) {
        int numThreads = 200000; // number of threads for the maximizer
        int  numElements = 10; // number of integers in the list
        int size = 1100; // Determines the size of the list (Chnage this parameter to change the size of the list)
        ParallelMaximizer maximizer = new ParallelMaximizer(numThreads);
        LinkedList<Integer> list = new LinkedList<Integer>();

        
     		// populate the list
        // TODO: change this implementation to test accordingly
       // for (int i = 0; i < numElements; i++) {
            //list.add(i);
                Random rand = new Random();
		int serialMax = Integer.MIN_VALUE;
		// populate list with random elements
                
                
		for (int i=0; i<size; i++) {
			int next = rand.nextInt();
			list.add(next);
			serialMax = Math.max(serialMax, next); // compute serialMax
                        
	//	}
            
        }
                
         System.out.println("The Serial Max number is: "+ serialMax);
         

        // run the maximizer
        try {
            System.out.println("Parallel Max number is:"+maximizer.max(list));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Finds the maximum by using <code>numThreads</code> instances of
     * <code>ParallelMaximizerWorker</code> to find partial maximums and then
     * combining the results.
     *
     * @param list <code>LinkedList</code> containing <code>Integers</code>
     * @return Maximum element in the <code>LinkedList</code>
     * @throws InterruptedException
     */
    public int max(LinkedList<Integer> list) throws InterruptedException {
        int max = Integer.MIN_VALUE; // initialize max as lowest value

        // run numThreads instances of ParallelMaximizerWorker
        for (int i = 0; i < numThreads; i++) {
            workers.add(i, new ParallelMaximizerWorker(list));
            workers.get(i).start();
        }
        
        
            for (int i = 0; i < workers.size(); i++) {
                workers.get(i).join();
            }
            
        // wait for threads to finish
       

        // take the highest of the partial maximums
        // TODO: IMPLEMENT CODE HERE
            
          for (int i = 0; i < workers.size(); i++) {

           workers.get(i).join();
           System.out.println("Worker ("+i+") value:"+workers.get(i).partialMax);
           max = Math.max(max, workers.get(i).getPartialMax());

        }
        
        return max;
 
}
    
}