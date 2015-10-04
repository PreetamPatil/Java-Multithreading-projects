/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patil;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Preetam
 */
public class ParallelMaximizerWorker extends Thread {

    protected LinkedList<Integer> list;
    protected int partialMax = Integer.MIN_VALUE; // initialize to lowest value

    public ParallelMaximizerWorker(LinkedList<Integer> list) {
        this.list = list;
    }

    /**
     * Update <code>partialMax</code> until the list is exhausted.
     */
    public void run() {
        while (true) {
            int number;
			// check if list is not empty and removes the head
            // synchronization needed to avoid atomicity violation
            synchronized (list) {
               
                if (list.isEmpty()) {
                      return; // list is empty
                }
                number = list.remove();
            }

            
                // update partialMax according to new value
                // TODO: IMPLEMENT CODE HERE

            partialMax = Math.max(partialMax, number);
            
            System.out.println("Worker Thread: "+Thread.currentThread().getName());
        }
    }

    public int getPartialMax() {
        return partialMax;
    }

}
